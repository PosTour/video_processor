package ru.bmstu.video_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VideoProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoProcessorApplication.class, args);
	}

}
