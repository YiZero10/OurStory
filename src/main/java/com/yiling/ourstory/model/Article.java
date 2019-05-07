package com.yiling.ourstory.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @NotNull
    private int id;

    private String title;

    private int category;

    private String content;

    private int status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modify;

    public Article(int id, String title, int category, String content, int status, Date create, Date modify) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.status = status;
        this.create = create;
        this.modify = modify;
    }

    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }
}
