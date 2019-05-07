package com.yiling.ourstory.control;

import com.yiling.ourstory.model.*;
import com.yiling.ourstory.service.AllService;
import com.yiling.ourstory.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@Controller
public class AllControl {

    private AllService allService;
    @Autowired
    public AllControl(AllService allService){
        this.allService = allService;
    }


    @RequestMapping
    public String setDays(ModelMap modelMap){
        DaysCalculator daysCalculator = allService.setDays();
        modelMap.addAttribute("daysCalculator",daysCalculator);
        return "index";
    }

    @RequestMapping("/memory/get")
    public String memory(ModelMap modelMap){
        List<Article> articles = allService.getArticlesByCategory(Category.TRAVEL.getCode());
        modelMap.addAttribute("articles",articles);
        return "memory";
    }

    @RequestMapping("/memory/get/type")
    public String memoryGet(ModelMap modelMap,int type){
        List<Article> articles = allService.getArticlesByCategory(type);
        modelMap.addAttribute("articles",articles);
        return "memory";
    }

    @RequestMapping("/memory/edit")
    public String memoryEdit(){
        return "add";
    }

    @RequestMapping("/memory/add")
    public String addArticle(@ModelAttribute Article article){
        allService.saveArticle(article);
        return "redirect:/memory/get";

    }

    @RequestMapping("/memory/delete")
    public String deleteArticle(int id){
        allService.deleteArticle(id);
        return "redirect:/memory/get";
    }


    @RequestMapping("/list/get")
    public String lists(ModelMap modelMap){
        List<ToDoList> completeLists = allService.getCommonLists(ListStatus.COMPLETE.getCode());
        List<ToDoList> uncompletedLists = allService.getCommonLists(ListStatus.UNCOMPLETED.getCode());

        List<ToDoList> uncompletedDayLists = allService.getDayLists(ListStatus.UNCOMPLETED.getCode());
        List<ToDoList> completeDayLists = allService.getDayLists(ListStatus.COMPLETE.getCode());
        modelMap.addAttribute("complete",completeLists);
        modelMap.addAttribute("uncompleted",uncompletedLists);
        modelMap.addAttribute("daycomplete",completeDayLists);
        modelMap.addAttribute("dayuncompleted",uncompletedDayLists);
        return "list";
    }

    @RequestMapping("/list/add")
    public String addList(@ModelAttribute ToDoList toDoList){
        allService.saveList(toDoList);
        return "redirect:/list/get";
    }

    @RequestMapping("/list/delete")
    public String deleteList(int id){
        allService.deleteList(id);
        return "redirect:/list/get";
    }

    @RequestMapping("/list/done")
    public String completeList(int id){
        allService.completed(id);
        return "redirect:/list/get";
    }

    @RequestMapping("/photo/get")
    public String getPhoto(ModelMap modelMap){
        List<Photo> photos = allService.getPhotos();
        modelMap.addAttribute("photos",photos);
        return "photo";
    }

    @PostMapping("/photo/add")
    public String addPhoto(@RequestParam("file")MultipartFile file,@ModelAttribute Photo photo){
        List<String> msg = FileUpload.writeUploadFile(file);
        photo.setId(msg.get(0));
        photo.setAddress(msg.get(1));
        allService.savePhoto(photo);
        return "redirect:/photo/get";
    }

    @RequestMapping("/photo/delete")
    public String deletePhoto(String id){
        allService.deletePhoto(id);
        return "redirect:photo";
    }

}
