package com.example.__PostNotesApplication.service;

import com.example.__PostNotesApplication.dao.LineRepository;
import com.example.__PostNotesApplication.po.Line;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    private com.example.__PostNotesApplication.dao.LineRepository lineRepository;

    @Transactional
    @Override
    public Line saveLine(Line line) {
        return lineRepository.save(line);
    }

    @Transactional
    @Override
    public Line updateLine(Long id, Line line) throws NotFoundException {
        Line t = lineRepository.findById(id).orElse(null);
        if(t == null){
            throw new NotFoundException("不存在該標簽");
        }

        return lineRepository.save(line);
    }

    @Transactional
    @Override
    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

    @Override
    public Line getLine(Long id) {
        return lineRepository.findById(id).orElse(null);
    }

    @Override
    public Line getLineByContent(String content) {
        return lineRepository.findByContent(content);
    }

    @Override
    public List<Line> listLine() {
        return lineRepository.findAll();
    }

    @Override
    public List<Line> listLine(String ids) {
        return lineRepository.findAllById(converToList(ids));
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
    public List<Line> listLineByTitleId(Long id) {
        return lineRepository.findByTitleId(id);
    }

    @Override
    public Page<Line> listLine(Pageable pageable) {
        return lineRepository.findAll(pageable);
    }

}
