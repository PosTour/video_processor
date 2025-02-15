package ru.bmstu.video_processor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "response")
@NoArgsConstructor
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

    public Response(double value1, double value2, double value3, double value4, String text) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.text = text;
    }
}
