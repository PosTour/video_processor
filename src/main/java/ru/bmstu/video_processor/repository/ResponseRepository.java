package ru.bmstu.video_processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.video_processor.domain.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {}