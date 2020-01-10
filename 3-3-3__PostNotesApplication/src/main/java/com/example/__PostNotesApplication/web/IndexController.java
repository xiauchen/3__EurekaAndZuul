package com.example.__PostNotesApplication.web;

import com.example.__PostNotesApplication.po.Title;
import com.example.__PostNotesApplication.service.LineService;
import com.example.__PostNotesApplication.service.TitleService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private LineService lineService;
    @Autowired
    private TitleService titleService;
    public IndexController(){}

    @GetMapping("/")
    public String index(){
        return "Hello PostNotes.Docker";
    }
    @GetMapping("/all")
    public String all() throws JSONException {
        JSONObject outData = new JSONObject();
        List<Title> list_title = titleService.listTitle();
        int title_num = 1;
        for (Title temp_title: list_title
             ) {
            outData.put("title"+title_num,temp_title);
            outData.accumulate("title"+title_num,lineService.listLineByTitleId(temp_title.getId()));
            title_num++;
        }
        return outData.toString();
    }
    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id) throws Exception {
        JSONObject outData = new JSONObject();
        outData.put("title",titleService.getTitleById(id).orElseThrow(()->new Exception("What Null")));
        outData.accumulate("title",lineService.listLineByTitleId(id));
        return outData.toString();
    }
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        titleService.deleteTitle(id);
        return "400";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 7,sort ={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query) throws JSONException {
        JSONObject outData = new JSONObject();
        List<Title> list_title = titleService.listTitle("%"+query+"%",pageable);
        int title_num = 1;
        for (Title temp_title: list_title
             ) {
            outData.put("title"+title_num,temp_title);
            outData.accumulate("title"+title_num,lineService.listLineByTitleId(temp_title.getId()));
        }
        return outData.toString();
    }
}
