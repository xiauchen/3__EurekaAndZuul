package com.example.__PostNotesApplication.service;

import com.example.__PostNotesApplication.dao.TitleRepository;
import com.example.__PostNotesApplication.po.Line;
import com.example.__PostNotesApplication.po.Title;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    private TitleRepository titleRepository;

    @Transactional
    @Override
    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    @Transactional
    @Override
    public Title updateTitle(Long id, Title title) throws NotFoundException {
        return titleRepository.save(title);
    }

    @Transactional
    @Override
    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }

    @Override
    public Title getTitle(Long id) {
        return titleRepository.findById(id).orElse(null);
    }

    @Override
    public Title getTitleByName(String name) {
        return titleRepository.findByName(name);
    }

    @Override
    public List<Title> listTitle() {
        return titleRepository.findAll();
    }

    @Override
    public List<Title> listTitle(String ids) {
        return titleRepository.findAllById(converToList(ids));
    }

    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idarray = ids.split(",");
            for(int i=0;i< idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    public List<Title> listTitle(String query, Pageable pageable){
        return titleRepository.findByQuery(query,pageable);
    }

    @Override
    public Optional<Title> getTitleById(Long id){ return titleRepository.findById(id);}

    @Override
    public Page<Title> listTitle(Pageable pageable) {
        return titleRepository.findAll(pageable);
    }
}
