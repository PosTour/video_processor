package ru.bmstu.video_processor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.video_processor.domain.Response;
import ru.bmstu.video_processor.dto.ResponseDto;
import ru.bmstu.video_processor.repository.ResponseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseRepository responseRepository;

    public void save(ResponseDto responseDto) {
        var response = new Response(responseDto);
        responseRepository.save(response);
    }

    public List<Response> findAll() {
        return responseRepository.findAll();
    }
}
