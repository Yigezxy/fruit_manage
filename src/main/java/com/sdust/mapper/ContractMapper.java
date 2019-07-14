package com.sdust.mapper;

import com.sdust.entity.Contract;
import com.sdust.entity.ContractVo;
import com.sdust.entity.MiddleTab;
import com.sdust.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
@Mapper
public interface ContractMapper {

    @Select("<script> select t.contractid as contractId,t.barcode as barCode,t.createtime as createTime,t.type,r.name as retailerName from contract t left join retailer r on t.retailerid = r.retailerid " +
            "where 1=1 " +
            "<if test=\"c.barCode != null\">and t.barcode = #{c.barCode}</if>" +
            "<if test=\"c.type != null\"> and t.type like #{c.type}</if>" +
            "<if test=\"startTime != null\"> and t.createtime <![CDATA[>=]]> #{startTime}</if>" +
            "<if test=\"endTime != null\"> and t.createtime <![CDATA[<=]]> #{endTime}</if>" +
            "<if test=\"c.retailerName != null\"> and r.name like '%${c.retailerName}%'</if>" +
            "<if test=\"c.startPage != null and c.pageSize != null\">LIMIT #{c.startPage},#{c.pageSize}</if>" +
            "</script>")
    List<ContractVo> findContractList(@Param("c") ContractVo contractVo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("<script> select count(*) from contract t left join retailer r on t.retailerid = r.retailerid " +
            "where 1=1 " +
            "<if test=\"c.barCode != null\">and t.barcode = #{c.barCode}</if>" +
            "<if test=\"c.type != null\"> and t.type like #{c.type}</if>" +
            "<if test=\"startTime != null\"> and t.createtime <![CDATA[>=]]> #{startTime}</if>" +
            "<if test=\"endTime != null\"> and t.createtime <![CDATA[<=]]> #{endTime}</if>" +
            "<if test=\"c.retailerName != null\"> and r.name like '%${c.retailerName}%'</if>" +
            "</script>")
    int count(@Param("c") ContractVo contractVo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select("select MAX(barcode) from contract")
    String getMaxBarCode();

    @Insert("INSERT INTO contract (contractid, retailerid, barcode, type, createtime) values (#{c.contractId}, #{id}, #{c.barCode}, #{c.type}, #{c.createTime})")
    void insert(@Param("c") Contract contract,@Param("id") String retailerId);

    @Insert("insert into middle_tab (middleid, contractid, fruitid, number) VALUES (#{middleId}, #{contractId}, #{fruitId}, #{number})")
    void insertMiddleTab(MiddleTab middleTab);

    @Select("SELECT contractid as contractId,barcode as barCode,type,createTime as createTime from contract where contractid=#{id}")
//    @Results({
//            @Result(id = true , property=" shopid ",column=" shopid "), //这个是为了匹配ShopList里面的一些属性，如果名字对应可以不写
//            @Result(id=true,property="fruitid",column="fruitid"),//这个也是同理
////@Result(property="name",column="name"),
////用cid字段通过配置的路径去查找这个aClass对象
//            @Result(property="commodities",column="retailerId",one=@One(select="com.sdust.mapper.ShopperMapper.findFriutById",
//                    fetchType= FetchType.LAZY)),
//    })
    Contract get(@Param("id") String contractId);

    @Delete("DELETE FROM contract WHERE contractid=#{id}")
    void deleteById(@Param("id") String contractId);
}
