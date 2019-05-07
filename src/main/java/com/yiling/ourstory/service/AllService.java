package com.yiling.ourstory.service;

import com.yiling.ourstory.model.Article;
import com.yiling.ourstory.model.DaysCalculator;
import com.yiling.ourstory.model.Photo;
import com.yiling.ourstory.model.ToDoList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AllService {

    DaysCalculator setDays();

    List<Article> getArticles();

    List<Article> getArticlesByCategory(int code);

    List<Integer> getIdsByCategory(int code);

    Article getArticleById(int id);

    void saveArticle(Article article);

    void deleteArticle(int id);

    List<ToDoList> getCommonLists(int status);

    List<ToDoList> getDayLists(int status);

    void saveList(ToDoList list);

    void deleteList(int id);

    void completed(int id);

    ToDoList findListById(int id);

    List<Photo> getPhotos();

    void deletePhoto(String id);

    void savePhoto(Photo photo);
}
