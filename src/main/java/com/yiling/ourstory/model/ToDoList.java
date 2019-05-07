package com.yiling.ourstory.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "to_do_list")
public class ToDoList {

    @Id
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private int listType;

    @Column(name= "status")
    private int listStatus;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "gmt_create")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "gmt_modify")
    private Date modifyTime;

    public ToDoList(String content, int listType, int listStatus, Date createTime, Date modifyTime) {
        this.content = content;
        this.listType = listType;
        this.listStatus = listStatus;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public ToDoList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getListType() {
        return listType;
    }

    public void setListType(int listType) {
        this.listType = listType;
    }

    public int getListStatus() {
        return listStatus;
    }

    public void setListStatus(int listStatus) {
        this.listStatus = listStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
