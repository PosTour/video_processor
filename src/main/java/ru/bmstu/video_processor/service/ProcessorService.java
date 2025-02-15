package ru.bmstu.video_processor.service;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.springframework.stereotype.Service;
import ru.bmstu.video_processor.domain.Response;
import ru.bmstu.video_processor.exception.FrameEncodingException;

import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessorService {

    private final ResponseService responseService;

    public void process(String rtspUrl) {
        VideoCapture capture = new VideoCapture(rtspUrl);
        Mat frame = new Mat();

        while (capture.read(frame)) {
            if (frame.empty()) {
                log.info("Frame is empty");
                continue;
            }

            String encodedFrame = encodeFrame(frame);
            var response = sendToAnalyzer(encodedFrame);
            responseService.save(response);
        }
        capture.release();
    }

    private String encodeFrame(Mat frame) {
        try {
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", frame, matOfByte);
            return Base64.getEncoder().encodeToString(matOfByte.toArray());
        } catch (Exception e) {
            throw new FrameEncodingException("Failed to encode frame");
        }
    }

    private Response sendToAnalyzer(String encodedFrame) {
        // TODO: отправка закодированного фрейма и получение ответа
        return null;
    }
}
