package com.example.__PostNotesApplication.web;

import com.example.__PostNotesApplication.po.Line;
import com.example.__PostNotesApplication.po.Title;
import com.example.__PostNotesApplication.service.LineService;
import com.example.__PostNotesApplication.service.TitleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

public class EditController {
    @Autowired
    private LineService lineService;
    @Autowired
    private TitleService titleService;
    @PostMapping("/edit")
    public String postTitle(Title title, BindingResult result, RedirectAttributes attributes) throws NotFoundException {
        Title temp_title;
        if (title.getId() == null) {
            temp_title=titleService.saveTitle(title);
            System.out.println("save\n");
        }else{
            temp_title=titleService.updateTitle(title.getId(),title);
            System.out.println(title.getId().toString()+" update\n");
        }
        if(temp_title==null){
            System.out.println("False\n");
            return "404";
        }else{
            System.out.println("True\n");
            return "400";
        }
    }
    //更改完成狀態life
    @PostMapping("/{id}/life")
    public String postLife(@PathVariable Long id, @RequestParam String check) throws Exception {
        Title temp_title = titleService.getTitle(id);
        //功能1：便利貼已完成
        if(check == "0") {
            temp_title.setLife(false);
        }else if(check == "1"){
            temp_title.setLife(true);
        }
        titleService.updateTitle(id,temp_title);
        System.out.println(temp_title.getId().toString()+" lifeUpdate\n");
        if(temp_title==null){
            System.out.println("False\n");
            return "404";
        }else{
            System.out.println("True\n");
            return "400";
        }
    }
    @PostMapping("/line")
    public String postLine(Line line, HttpSession session) throws NotFoundException {
        Line temp_line;
        if (line.getId() == null) {
            temp_line =  lineService.saveLine(line);
        } else {
            temp_line = lineService.updateLine(line.getId(), line);
        }
        if(temp_line == null){
            System.out.println("message false");
            return "404";
        }else{
            System.out.println("message complete");
            return "400";
        }
    }
}
