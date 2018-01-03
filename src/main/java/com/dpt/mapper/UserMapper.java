package com.dpt.mapper;

import org.apache.ibatis.annotations.*;
import com.dpt.entity.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findUserByName(@Param("name") String name);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User getUserByName(@Param("name") String name);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);

    @Select("SELECT * FROM user WHERE 1=1 ")
    List<User> getUsers();

    @Insert("INSERT INTO user(id,name,age) VALUES(#{id}, #{name}, #{age})")
    int insert(User user);

    @Insert("INSERT INTO user(id,name,age) VALUES(#{id}, #{name}, #{age})")
    int insertByMap(Map<String, Object> map);

    @Update("UPDATE user SET age=#{age}, name=#{name} WHERE id=#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(int id);

    @Results({ @Result(property = "name", column = "name"), @Result(property = "age", column = "age") })
    @Select("SELECT name,age FROM user WHERE 1=1")
    List<User> queryById();

}
