package com.dpt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.dpt.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{name}")

    User findUserByName(@Param("name") String name);

}
