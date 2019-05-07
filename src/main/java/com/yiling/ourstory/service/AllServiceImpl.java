package com.yiling.ourstory.service;

import com.yiling.ourstory.mapper.ArticleMapper;
import com.yiling.ourstory.mapper.ListMapper;
import com.yiling.ourstory.mapper.PhotoMapper;
import com.yiling.ourstory.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class AllServiceImpl implements AllService {
    private static final String TOGETHER = "2018-09-04 00:00:00";
    private static final String BIRTHDAY = "2000-02-10 00:00:00";
    private static final int DELETE = 0;
    private static final int EXIT = 1;

    private ArticleMapper articleMapper;
    private ListMapper listMapper;
    private PhotoMapper photoMapper;
    @Autowired
    public AllServiceImpl(ArticleMapper articleMapper,ListMapper listMapper,PhotoMapper photoMapper){
        this.articleMapper=articleMapper;
        this.listMapper=listMapper;
        this.photoMapper=photoMapper;
    }


    @Override
    public DaysCalculator setDays() {
        DaysCalculator daysCalculator = new DaysCalculator();
        daysCalculator.setTogetherTime(setTime(TOGETHER));
        daysCalculator.setBirthday(setTime(BIRTHDAY));

        Date nowTime = new Date();
        int days= (int) ((nowTime.getTime()-daysCalculator.getTogetherTime().getTime())/(24*60*60*1000));
        daysCalculator.setTogetherDays(days);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar birthdayCalendar = Calendar.getInstance();
        Date birthday = setTime(BIRTHDAY);
        birthdayCalendar.setTime(birthday);
        if ((now.get(Calendar.MONTH)+1)>(birthdayCalendar.get(Calendar.MONTH)+1)){
            int years=now.get(Calendar.YEAR)-birthdayCalendar.get(Calendar.YEAR)+1;
            birthdayCalendar.add(Calendar.YEAR,years);
        }else {
            int years=now.get(Calendar.YEAR)-birthdayCalendar.get(Calendar.YEAR);
            birthdayCalendar.add(Calendar.YEAR,years);
        }
        int birthdayDays= (int) ((birthdayCalendar.getTimeInMillis()-now.getTimeInMillis())/(24*60*60*1000));
        daysCalculator.setBirthdayDays(birthdayDays);

        return daysCalculator;
    }

    @Override
    public List<Article> getArticles() {
        return articleMapper.findAllByStatus();
    }

    @Override
    public List<Article> getArticlesByCategory(int code) {
        return articleMapper.findAllByCategory(code);
    }

    @Override
    public List<Integer> getIdsByCategory(int code){
        return articleMapper.findIdsByCategory(code);
    }

    @Override
    public Article getArticleById(int id){
        return articleMapper.findById(id);
    }

    @Override
    public void saveArticle(Article article){
        article.setCreate(new Date());
        article.setModify(new Date());
        article.setStatus(ArticleStatus.COMMON.getCode());
        articleMapper.save(article);
    }

    @Override
    public void deleteArticle(int id){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        articleMapper.deleteArticle(ArticleStatus.DELETE.getCode(),simpleDateFormat.format(new Date()),id);
    }

    @Override
    public List<ToDoList> getCommonLists(int status){
        return listMapper.findAllByStatusAndType(status,ListType.COMMON.getCode());
    }

    @Override
    public List<ToDoList> getDayLists(int status){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar now = Calendar.getInstance();
        Calendar modify = Calendar.getInstance();
        int dayOfToday = now.get(Calendar.DAY_OF_MONTH);

        List<ToDoList> lists = listMapper.findByType(ListType.DAY.getCode(),ListStatus.DELETE.getCode());
        for (ToDoList list:lists) {
            modify.setTime(list.getModifyTime());
            int dayOfModify = modify.get(Calendar.DAY_OF_MONTH);
            if (dayOfModify-dayOfToday<0 && list.getListStatus()==ListStatus.COMPLETE.getCode())
                listMapper.updateListStatus(ListStatus.UNCOMPLETED.getCode(),simpleDateFormat.format(new Date()),list.getId());
    }

        return listMapper.findAllByStatusAndType(status,ListType.DAY.getCode());
    }

    @Override
    public void saveList(ToDoList list){
        list.setCreateTime(new Date());
        list.setModifyTime(new Date());
        list.setListStatus(ListStatus.UNCOMPLETED.getCode());
        listMapper.save(list);
    }

    @Override
    public void deleteList(int id) {
        listMapper.deleteList(ListStatus.DELETE.getCode(),new Date(),id);
    }

    @Override
    public void completed(int id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        listMapper.updateListStatus(ListStatus.COMPLETE.getCode(),simpleDateFormat.format(new Date()),id);
    }

    @Override
    public ToDoList findListById(int id){
        return listMapper.findById(id);
    }

    @Override
    public List<Photo> getPhotos(){
        List<Photo> photos = photoMapper.getPhotosByStatus();
        return photos;
    }

    @Override
    public void deletePhoto(String id){
        photoMapper.deletePhoto(DELETE,new Date().toString(),id);
    }

    @Override
    public void savePhoto(Photo photo){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        photo.setStatus(EXIT);
        photo.setCreateTime(simpleDateFormat.format(new Date()));
        photo.setModifyTime(simpleDateFormat.format(new Date()));
        photoMapper.savePhoto(photo);

    }

    private static Date setTime(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
