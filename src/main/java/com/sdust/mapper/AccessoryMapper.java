package com.sdust.mapper;

import com.sdust.entity.Accessory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Mapper
public interface AccessoryMapper {
    @Select("<script>select accessoryid as accessoryId,fruitid as fruitId, name as name, price as price,createtime as createTime from accessory </script>")
    List<Accessory> selectAll();

    @Select("<script>select accessoryid as accessoryId,fruitid as fruitId, name as name, price as price,createtime as createTime from accessory where fruitid=#{fruitId} </script>")
    List<Accessory> selctByFruitId(Accessory accessory);

    @Insert("insert into accessory values (#{accessoryId},#{fruitId},#{name},#{price},#{createTime})")
    void insert(Accessory accessory);

    @Delete("delete from accessory where accessoryid = #{id}; ")
    void deleteById(@Param("id") String id);

    @Delete("delete from accessory where fruitid = #{id}")
    int deleteByFruitId(@Param("id") String fruitId);

    @Delete("delete from accessory where accessoryid in (${ids})")
    void deleteByIds(@Param("ids") String ids);
//    @Select("delete from accessory where accessoryid in (#{ss}); ")
//    void delete(String ss);
}
