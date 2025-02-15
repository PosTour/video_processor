package ru.bmstu.video_processor.mapper;

import org.mapstruct.Mapper;
import ru.bmstu.video_processor.domain.Response;
import ru.bmstu.video_processor.dto.ResponseDto;

@Mapper
public interface ResponseMapper {
    Response responseDtoToResponse(ResponseDto responseDto);
}