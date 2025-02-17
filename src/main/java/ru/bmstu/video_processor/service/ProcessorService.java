package ru.bmstu.video_processor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.*;
import org.springframework.stereotype.Service;
import ru.bmstu.video_processor.client.FrameClient;
import ru.bmstu.video_processor.dto.ResponseDto;
import ru.bmstu.video_processor.exception.FrameEncodingException;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessorService {

    private final ResponseService responseService;
    private final FrameClient frameClient;

    public void process(String rtspUrl) {
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(rtspUrl)) {
            grabber.setOption("rtsp_transport", "tcp");
            grabber.setVideoCodec(avcodec.AV_CODEC_ID_H264);
            grabber.start();
            Frame frame;
            while ((frame = grabber.grabImage()) != null) {
                if (frame.image == null) {
                    log.info("Frame is empty");
                    continue;
                }

                String encodedFrame = encodeFrame(frame);
                var response = sendToAnalyzer(encodedFrame);
                responseService.save(response);
            }
        } catch (Exception e) {
            log.error("Error during video processing", e);
        }
    }

    private String encodeFrame(Frame frame) {
        try {
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage bufferedImage = converter.convert(frame);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);

            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            throw new FrameEncodingException("Failed to encode frame");
        }
    }

    private ResponseDto sendToAnalyzer(String encodedFrame) {
        return frameClient.analyze(encodedFrame);
    }
}
