package com.example.__PostNotesApplication.dao;

import com.example.__PostNotesApplication.po.Line;
import com.example.__PostNotesApplication.po.Title;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title,Long> {

    Title findByName(String name);

    @Query("select t from Title t where t.name like ?1")
    List<Title> findByQuery(String query, Pageable pageable);
}
