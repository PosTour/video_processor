package ru.bmstu.video_processor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.video_processor.domain.Response;
import ru.bmstu.video_processor.repository.ResponseRepository;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseRepository responseRepository;

    public void save(Response response) {
        responseRepository.save(response);
    }
}
