package com.db.DAAS.mapper;

import com.db.DAAS.model.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {

     void createNews(@Param("newsDescription") String newsDescription);

     @Update("UPDATE newsletter set description = #{newsDescription} where id = 1")
     void updateNews(@Param("newsDescription") String newsDescription);

     @Select("SELECT * from newsletter")
     @Results(value= {
             @Result(property = "id", column="id"),
             @Result(property = "description", column="description")
     })
     List<News> getNews();
}
