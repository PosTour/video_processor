package ru.bmstu.video_processor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bmstu.video_processor.service.ProcessorService;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final ProcessorService processorService;

    @PostMapping("/process")
    public ResponseEntity<String> processVideo(@RequestBody String rtspUrl) {
        processorService.process(rtspUrl);
        return ResponseEntity.ok("Видео обработано");
    }
}
