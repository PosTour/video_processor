package ru.bmstu.video_processor.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bmstu.video_processor.dto.ResponseDto;

@FeignClient(url = "${url.analyzerAPI")
public interface FrameClient {
    @PostMapping("/analyze")
    ResponseDto analyze(@RequestBody String frame);
}
