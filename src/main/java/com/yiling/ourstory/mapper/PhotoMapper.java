package com.yiling.ourstory.mapper;

import com.yiling.ourstory.model.Photo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PhotoMapper {
    @Insert("INSERT INTO photo (id,address,description,status,gmt_create,gmt_modify) " +
            "VALUES (#{id},#{address},#{description},#{status},#{createTime},#{modifyTime})")
    void savePhoto(Photo photo);


    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "address",property = "address"),
                    @Result(column = "description",property = "description"),
                    @Result(column = "status",property = "status"),
                    @Result(column = "gmt_create",property = "createTime"),
                    @Result(column = "gmt_modify",property = "modifyTime")
            }
    )
    @Select("SELECT * FROM photo WHERE `status`=1")
    List<Photo> findPhotosByStatus();

    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "address",property = "address"),
                    @Result(column = "description",property = "description")
            }
    )
    @Select("SELECT id,address,description FROM photo WHERE `status`!=0")
    List<Photo> getPhotosByStatus();

    @Update("UPDATE photo " +
            "SET `status`=#{code},`modify`=#{modify} WHERE id=#{id}")
    void deletePhoto(@Param("code")int code, @Param("modify") String modify, @Param("id")String id);
}
