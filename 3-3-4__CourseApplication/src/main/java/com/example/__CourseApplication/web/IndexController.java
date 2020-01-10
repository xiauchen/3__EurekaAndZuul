package com.example.__CourseApplication.web;

import com.example.__CourseApplication.po.Course;
import com.example.__CourseApplication.service.CourseService;
import com.example.__CourseApplication.service.StudentService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {
    //透過 @RequestMapping 指定從/會被對應到此hello()方法
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    public IndexController() {
    }
    //主頁
    @GetMapping("/")
    public String index(){
        return "Hello Courser-Docker";
    }
    @GetMapping("/all")
    public String all() throws JSONException {
        JSONObject data = new JSONObject();
        List<Course> c = courseService.listCourse();
        int i=1;
        for (Course c1: c
             ) {
            data.put("course"+i,c1);
            data.put("course"+i,studentService.listStudentByCourseId(c1.getId()));
            i++;
        }
        return data.toString();
    }
    //獲取byId ok
    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id) throws Exception {
        JSONObject data = new JSONObject();
        data.put("course",courseService.getCourseById(id).orElseThrow(()-> new Exception("What Null")));
        data.accumulate("student",studentService.listStudentByCourseId(id));
        return data.toString();
    }
    //刪除 ok
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "400";
    }
    //搜尋
    @PostMapping("/search")
    public String search(@PageableDefault(size = 7,sort ={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) throws JSONException {
        JSONObject data = new JSONObject();
        List<Course> c=courseService.listCourse("%"+query+"%",pageable);
        int i=1;
        for (Course c1: c
        ) {
            data.put("course"+i,c1);
            data.accumulate("course"+i,studentService.listStudentByCourseId(c1.getId()));
            i++;
        }
        return data.toString();
    }

}