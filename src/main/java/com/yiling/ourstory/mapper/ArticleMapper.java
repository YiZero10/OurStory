package com.yiling.ourstory.mapper;

import com.yiling.ourstory.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface ArticleMapper {

    @Insert("INSERT INTO article (title,content,category,`create`,`modify`,`status`) " +
            "VALUES (#{title},#{content},#{category},#{create},#{modify},#{status})")
    void save(Article article);

    @Select("SELECT * FROM article WHERE category = #{code} AND `status`!=0 ORDER BY `create` desc")
    List<Article> findAllByCategory(@Param("code") int code);

    @Select("SELECT id FROM article WHERE category = #{code} AND `status`!=0")
    List<Integer> findIdsByCategory(@Param("code") int code);

    @Select("SELECT * FROM article WHERE id=#{id} AND `status`!=0 ")
    Article  findById(@Param("id") int id);

    @Results(
            {
                    @Result(column = "title",property = "title"),
                    @Result(column = "category",property = "category"),
                    @Result(column = "content",property = "content"),
                    @Result(column = "status",property = "status"),
                    @Result(column = "create",property = "create"),
                    @Result(column = "modify",property = "modify")
            }
    )
    @Select("select * from article where `status`=1 or `status` =2")
    List<Article> findAllByStatus();

    @Update("UPDATE article " +
            "SET `status`=#{code},`modify`=#{modify} WHERE id=#{id}")
    void deleteArticle(@Param("code")int code, @Param("modify")String modify,@Param("id")int id);
}
