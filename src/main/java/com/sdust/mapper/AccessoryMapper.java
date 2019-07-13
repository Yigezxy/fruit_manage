package com.sdust.mapper;

import com.sdust.entity.Accessory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Mapper
public interface AccessoryMapper {
    @Select("<script>select accessoryid as accessoryId,fruitid as fruitId, name as name, price as price,createtime as createTime from accessory </script>")
    List<Accessory> selectAll();
    @Select("<script>select accessoryid as accessoryId,fruitid as fruitId, name as name, price as price,createtime as createTime from accessory where fruitid=#{fruit} </script>")
    List<Accessory> selctByFruitId(String fruit);
    @Insert("insert into accessory values (#{accessoryId},#{fruitId},#{name},#{price},#{createTime})")
    void insert(Accessory accessory);
    @Delete("delete from accessory where accessoryid = #{id}; ")
    void deleteById(String id);
//    @Select("delete from accessory where accessoryid in (#{ss}); ")
//    void delete(String ss);
}
