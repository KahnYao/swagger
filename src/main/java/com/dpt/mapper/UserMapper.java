package com.dpt.mapper;

import org.apache.ibatis.annotations.*;
import com.dpt.entity.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findUserByName(@Param("name") String name);

    @Select("SELECT * FROM user WHERE username = #{name}")
    User getUserByName(@Param("name") String name);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);

    @Insert("INSERT INTO user(Id,username,password,usertype,enabled,realname,email,tel) VALUES(#{id}, #{username},#{password}, #{usertype},#{enabled}, #{realname},#{email}, #{tel})")
    int insert(User ui);

    @Insert("INSERT INTO user(Id,username,password,usertype,enabled,realname,email,tel) VALUES(#{id}, #{username},#{password}, #{usertype},#{enabled}, #{realname},#{email}, #{tel})")
    int insertByMap(Map<String, Object> map);

    @Select("SELECT * FROM user WHERE 1=1 ")
    List<User> findAll();

    @Update("UPDATE user SET password=#{password} WHERE username=#{username}")
    void update(User ui);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(int id);

    @Results({ @Result(property = "username", column = "username"), @Result(property = "realname", column = "realname") })
    @Select("SELECT username,realname FROM user WHERE 1=1")
    List<User> queryById();

}
