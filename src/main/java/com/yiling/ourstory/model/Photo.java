package com.yiling.ourstory.model;

import javax.persistence.Id;
import java.util.Date;

public class Photo {
    @Id
    private String id;

    private String address;

    private String description;

    private int status;

    private String createTime;

    private String modifyTime;

    public Photo(String id, String address, String description, String createTime, String modifyTime,int status) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.status=status;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Photo(String id,String address,String description){
        this.id = id;
        this.address = address;
        this.description = description;
    }

    public Photo(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
