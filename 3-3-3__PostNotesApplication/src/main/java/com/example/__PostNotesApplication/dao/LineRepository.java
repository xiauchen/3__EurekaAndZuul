package com.example.__PostNotesApplication.dao;

import com.example.__PostNotesApplication.po.Line;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineRepository extends JpaRepository<Line,Long> {

    Line findByContent(String content);

    List<Line> findByTitleId(Long id);
}
