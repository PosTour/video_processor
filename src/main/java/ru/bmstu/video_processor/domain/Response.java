package ru.bmstu.video_processor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import ru.bmstu.video_processor.dto.ResponseDto;

import java.util.UUID;

@Entity
@Table(name = "response")
@NoArgsConstructor
@Getter
public class Response {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "value1")
    private double value1;

    @Column(name = "value2")
    private double value2;

    @Column(name = "value3")
    private double value3;

    @Column(name = "value4")
    private double value4;

    @Column(name = "text")
    private String text;

    public Response(ResponseDto responseDto) {
        this.value1 = responseDto.getValue1();
        this.value2 = responseDto.getValue2();
        this.value3 = responseDto.getValue3();
        this.value4 = responseDto.getValue4();
        this.text = responseDto.getText();
    }
}
