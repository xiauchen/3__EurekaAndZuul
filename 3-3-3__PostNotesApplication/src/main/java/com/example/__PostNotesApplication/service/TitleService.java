package com.example.__PostNotesApplication.service;

import com.example.__PostNotesApplication.po.Line;
import com.example.__PostNotesApplication.po.Title;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TitleService {
    Title saveTitle(Title title);

    Title updateTitle(Long id, Title title) throws NotFoundException;

    void deleteTitle(Long id);

    Title getTitle(Long id);

    Title getTitleByName(String name);

    List<Title> listTitle();

    List<Title> listTitle(String ids);

    List<Title> listTitle(String query,Pageable pageable);

    Optional<Title> getTitleById(Long id);

    Page<Title> listTitle(Pageable pageable);

}
