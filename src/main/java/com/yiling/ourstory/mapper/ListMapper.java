package com.yiling.ourstory.mapper;

import com.yiling.ourstory.model.ToDoList;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ListMapper {

    @Insert("INSERT INTO to_do_list (content,createTime,modifyTime,status,type) " +
            "VALUES (#{content},#{createTime},#{modifyTime},#{listStatus},#{listType})")
    void save(ToDoList toDoList);

    @Results(
            {
                    @Result(column = "content",property = "content"),
                    @Result(column = "status",property = "listStatus"),
                    @Result(column = "type",property = "listType"),
                    @Result(column = "createTime",property = "createTime"),
                    @Result(column = "modifyTime",property = "modifyTime")
            }
    )
    @Select("SELECT * FROM to_do_list WHERE id = #{id}")
    List<ToDoList> findAllById(@Param("id") int id);

    @Results(
            {
                    @Result(column = "content",property = "content"),
                    @Result(column = "status",property = "listStatus"),
                    @Result(column = "type",property = "listType"),
                    @Result(column = "createTime",property = "createTime"),
                    @Result(column = "modifyTime",property = "modifyTime")
            }
    )
    @Select("SELECT * FROM to_do_list WHERE id = #{id}")
    ToDoList findById(@Param("id") int id);

    @Results(
            {
                    @Result(column = "content",property = "content"),
                    @Result(column = "status",property = "listStatus"),
                    @Result(column = "type",property = "listType"),
                    @Result(column = "createTime",property = "createTime"),
                    @Result(column = "modifyTime",property = "modifyTime")
            }
    )
    @Select("SELECT * FROM to_do_list WHERE type = #{type} AND `status` != #{code}")
    List<ToDoList> findByType(@Param("type") int type,@Param("code") int code);

    @Results(
            {
                    @Result(column = "content",property = "content"),
                    @Result(column = "status",property = "listStatus"),
                    @Result(column = "type",property = "listType"),
                    @Result(column = "createTime",property = "createTime"),
                    @Result(column = "modifyTime",property = "modifyTime")
            }
    )
    @Select("select * from to_do_list where `status`= #{code} AND type=#{type} ORDER BY createTime desc")
    List<ToDoList> findAllByStatusAndType(@Param("code") int code,@Param("type") int type);

    @Update("UPDATE to_do_list " +
            "SET `status`=#{code},`modifyTime`=#{modify} WHERE id=#{id}")
    void deleteList(@Param("code")int code, @Param("modify") Date modify, @Param("id")int id);

    @Update("UPDATE to_do_list " +
            "SET `status`=#{code},`modifyTime`=#{modify} WHERE id=#{id}")
    void updateListStatus(@Param("code")int code, @Param("modify") String modify, @Param("id")int id);
}
