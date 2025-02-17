package ru.bmstu.video_processor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.video_processor.domain.Response;
import ru.bmstu.video_processor.service.ProcessorService;
import ru.bmstu.video_processor.service.ResponseService;

import java.util.List;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final ProcessorService processorService;
    private final ResponseService responseService;

    @PostMapping("/process")
    public ResponseEntity<String> processVideo(@RequestBody String rtspUrl) {
        processorService.process(rtspUrl);
        return ResponseEntity.ok("Видео обработано");
    }

    @GetMapping()
    public List<Response> getAllResponses() {
        return responseService.findAll();
    }
}