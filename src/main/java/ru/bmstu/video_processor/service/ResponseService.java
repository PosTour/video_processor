package ru.bmstu.video_processor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.video_processor.dto.ResponseDto;
import ru.bmstu.video_processor.mapper.ResponseMapper;
import ru.bmstu.video_processor.repository.ResponseRepository;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final ResponseMapper responseMapper;

    public void save(ResponseDto responseDto) {
        var response = responseMapper.responseDtoToResponse(responseDto);
        responseRepository.save(response);
    }
}
