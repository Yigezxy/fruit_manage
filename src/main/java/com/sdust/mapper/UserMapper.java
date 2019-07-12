package com.sdust.mapper;

import com.sdust.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Mapper
public interface UserMapper {
    @Select("<script>select userid as userId,name as name from user </script>")
    List<User> searchAll();

    @Select("<script> select userid as userId,name as name from user where username=#{userName} and password=#{password} </script>")
    List<User> find(User user);

    @Insert("insert into user values (#{userId},#{userName},#{password},#{name},#{telphone})")
    void insert(User user);

    @Select("<script> select userid as userId,name as name from user where username=#{userName} </script>")
    List<User> findByName(User user);
}
