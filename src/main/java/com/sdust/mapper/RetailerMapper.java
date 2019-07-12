package com.sdust.mapper;

import com.sdust.entity.Retailer;
import com.sdust.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Mapper
public interface RetailerMapper {
    @Select("<script> select retailerid as retailerId,name,telphone,address,status,createtime as createTime from retailer " +
            "<where> 1=1 " +
            "<if test=\"r.name != null\"> and name like '%${r.name}%'</if>" +
            "<if test=\"r.address != null\"> and address like '%${r.address}%'</if>" +
            "<if test=\"r.status != null\"> and status like '%${r.status}%'</if>" +
            "<if test=\"r.telphone != null\"> and telphone = #{r.telphone}</if>" +
            "<if test=\"r.createTime != null\"> and createtime <![CDATA[=]]> #{r.createTime}</if>" +
            "<if test=\"startTime != null\"> and createtime <![CDATA[>=]]> #{startTime}</if>" +
            "<if test=\"endTime != null\"> and createtime <![CDATA[<=]]> #{endTime}</if>" +
            "<if test=\"r.startPage != null and r.pageSize != null\">LIMIT #{r.startPage},#{r.pageSize}</if>" +
            "</where>" +
            "</script>")
    List<Retailer> find(@Param("r") Retailer retailer, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("<script> select count(*) from retailer " +
            "<where> 1=1 " +
            "<if test=\"r.name != null\"> and name like '%${r.name}%'</if>" +
            "<if test=\"r.address != null\"> and address like '%${r.address}%'</if>" +
            "<if test=\"r.status != null\"> and status like '%${r.status}%'</if>" +
            "<if test=\"r.telphone != null\"> and telphone = #{r.telphone}</if>" +
            "<if test=\"r.createTime != null\"> and createtime <![CDATA[=]]> #{r.createTime}</if>" +
            "<if test=\"startTime != null\"> and createtime <![CDATA[>=]]> #{startTime}</if>" +
            "<if test=\"endTime != null\"> and createtime <![CDATA[<=]]> #{endTime}</if>" +
            "</where>" +
            "</script>")
    Integer count(@Param("r") Retailer retailer, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select retailerid as retailerId,name,telphone,address,status,createtime as createTime from retailer where retailerid=#{retailerId}")
    Retailer get(@Param("retailerId") String id);

    @Update("update retailer set name=#{name},telphone=#{telphone},address=#{address},status=#{status} where retailerid=#{retailerId}")
    void update(Retailer retailer);

    @Delete("DELETE FROM retailer WHERE retailerid=#{retailerid}")
    void deleteById(@Param("retailerid") String retailerId);

    @Insert("insert into retailer (retailerid, name, telphone, address, status, createtime) VALUES (#{retailerId}, #{name}, #{telphone}, #{address}, #{status}, #{createTime})")
    void insert(Retailer retailer);
}
