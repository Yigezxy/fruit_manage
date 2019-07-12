package com.sdust.mapper;

import com.sdust.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Mapper
public interface UserMapper {
    @Select("<script> select userid as userId,name as name from user </script>")
    List<User> searchAll();
}
