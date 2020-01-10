package com.example.__PostNotesApplication.service;

import com.example.__PostNotesApplication.po.Line;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LineService {
    Line saveLine(Line line);

    Line updateLine(Long id,Line line) throws NotFoundException;

    void deleteLine(Long id);

    Line getLine(Long id);

    Line getLineByContent(String content);

    List<Line> listLine();

    List<Line> listLine(String ids);

    List<Line> listLineByTitleId(Long id);

    Page<Line> listLine(Pageable pageable);

}
