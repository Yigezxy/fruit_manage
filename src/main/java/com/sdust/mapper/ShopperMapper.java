package com.sdust.mapper;

import com.sdust.entity.Commodities;
import com.sdust.entity.ShopList;
import com.sdust.entity.ShopListVo;
import com.sdust.entity.Shopper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by Cierlly on 7/13/2019.
 */
@Mapper
public interface ShopperMapper {

    @Insert("insert into shopper values (#{id},#{username},#{phonenumber},#{password},#{email})")
    void insert(Shopper shopper);

    @Select("<script> select * from shopper where phonenumber=#{phonenumber} </script>")
   Shopper findByPhone(Shopper shopper);

    @Select("<script> select * from commodities</script>")
    List<Commodities> SelectAllFruit();

    @Select("<script> select distinct name from commodities</script>")
    List<String> SelectAllType();

    @Select("<script> select * from commodities where name=#{name} </script>")
    List<Commodities> findFriutByName(String name);

    @Select("<script> select * FROM commodities where fruitid=#{fruitid} </script>")//fruitid as fruitId, name, price, locality, createtime as createTime
    Commodities findFriutById(String fruitid);

//    现在开始购物车
    @Insert("insert  into shoplist  values (#{shopid}, #{shopperid}, #{fruitid}, #{num},#{state})")
    void insertIntoShopList(ShopList shopList);

    @Select("<script> select * from shoplist where shopperid=#{id} </script>")
    List<ShopList> findShopListByShopperid(Shopper shopper);

    @Select("SELECT * from shoplist")
    @Results({
            @Result(id = true,property = "shopid",column = "shopid"),
            @Result(id = true,property = "fruitid",column = "fruitid"),
//            @Result(property = "name",column = "name"),
            //用cid字段通过配置的路径去查找这个aClass对象
            @Result(property = "commodities",column = "fruitid",one = @One(select = "com.sdust.mapper.ShopperMapper.findFriutById",
                    fetchType = FetchType.LAZY)),
    })
    List<ShopListVo> searchVo();
    @Select("SELECT * from shoplist where shopperid = #{id}")
    @Results({
            @Result(id = true,property = "shopid",column = "shopid"),
            @Result(id = true,property = "fruitid",column = "fruitid"),
//            @Result(property = "name",column = "name"),
            //用cid字段通过配置的路径去查找这个aClass对象
            @Result(property = "commodities",column = "fruitid",one = @One(select = "com.sdust.mapper.ShopperMapper.findFriutById",
                    fetchType = FetchType.LAZY)),
    })
    List<ShopListVo> searchVoById(Shopper shopper);
}
