package com.sdust.mapper;

import com.sdust.entity.Commodities;
import com.sdust.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Mapper
public interface CommoditiesMapper {
    @Select("<script>select fruitid as fruitId,name,price,locality,createtime as createTime from commodities" +
            "<where> 1=1 " +
            "<if test=\"c.name != null\"> and name like '%${c.name}%'</if>" +
            "<if test=\"startPrice != null\">  and price <![CDATA[>=]]> #{startPrice}</if>" +
            "<if test=\"endPrice != null\">  and price <![CDATA[<=]]> #{endPrice}</if>" +
            "<if test=\"c.locality != null\"> and locality like '%${c.locality}%'</if>" +
            "<if test=\"c.createTime != null\"> and createtime <![CDATA[=]]> #{c.createTime}</if>" +
            "<if test=\"startTime != null\"> and createtime <![CDATA[>=]]> #{startTime}</if>" +
            "<if test=\"endTime != null\"> and createtime <![CDATA[<=]]> #{endTime}</if>" +
            "<if test=\"c.startPage != null and c.pageSize != null\">LIMIT #{c.startPage},#{c.pageSize}</if>" +
            "</where>" +
            "</script>")
    List<Commodities> find(@Param("c") Commodities commodities, @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("startPrice") Double startPrice, @Param("endPrice") Double endPrice);

    @Select("<script>select count(fruitid) from commodities" +
            "<where> 1=1 " +
            "<if test=\"c.name != null\"> and name like '%${c.name}%'</if>" +
            "<if test=\"startPrice != null\">  and price <![CDATA[>=]]> #{startPrice}</if>" +
            "<if test=\"endPrice != null\">  and price <![CDATA[<=]]> #{endPrice}</if>" +
            "<if test=\"c.locality != null\"> and locality like '%${c.locality}%'</if>" +
            "<if test=\"c.createTime != null\"> and createtime <![CDATA[=]]> #{c.createTime}</if>" +
            "<if test=\"startTime != null\"> and createtime <![CDATA[>=]]> #{startTime}</if>" +
            "<if test=\"endTime != null\"> and createtime <![CDATA[<=]]> #{endTime}</if>" +
            "</where>" +
            "</script>")
    Integer count(@Param("c") Commodities commodities, @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("startPrice") Double startPrice, @Param("endPrice") Double endPrice);

    @Select("select fruitid as fruitId,name,price,locality,createtime as createTime from commodities where fruitid=#{id}")
    Commodities get(@Param("id")String id);

    @Update("<script>" +
            "update commodities\n" +
            "<set>\n" +
            "<if test=\"name != null\">name=#{name},</if>" +
            "<if test=\"price != null\">price=#{price},</if>" +
            "<if test=\"locality != null\">locality = #{locality}</if>" +
            "</set>" +
            "where fruitid=#{fruitId}" +
            "</script>")
    void update(Commodities commodities);

    @Delete("DELETE  FROM commodities WHERE fruitid=#{id}")
    void deleteById(@Param("id") String fruitId);

    @Insert("insert into commodities (fruitid, name, price, locality, createtime) VALUES (#{fruitId}, #{name}, #{price}, #{locality}, #{createTime})")
    void insert(Commodities commodities);
}
