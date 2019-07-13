package com.sdust.service.serviceimpl;

import com.sdust.entity.Commodities;
import com.sdust.entity.ShopList;
import com.sdust.entity.ShopListVo;
import com.sdust.entity.Shopper;
import com.sdust.mapper.ShopperMapper;
import com.sdust.service.IShopperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cierlly on 7/13/2019.
 */
@Service
public class ShopperService implements IShopperService{
    @Resource
    private ShopperMapper shopperMapper;

    @Override
    public String inster(Shopper shopper) {
        if(!shopper.getPhonenumber().isEmpty() && !shopper.getPassword().isEmpty()){
            Shopper shopper1 = shopperMapper.findByPhone(shopper);

            if(shopper1 != null){
                return "该手机号已经注册,可以直接登录";
            }else{
                shopperMapper.insert(shopper);
                return "注册成功";
            }

        }else{
            return "手机号或者密码为空";
        }
    }

    public Shopper findUserByPhone(String phone){
        Shopper shopper = new Shopper();
        shopper.setPhonenumber(phone);
        Shopper shopper1 = shopperMapper.findByPhone(shopper);
        if(shopper1 != null){
            return shopper1;
        }
        else{
            return null;
        }
    }
    public List<String> FindType(){
        List<String> stringList  = shopperMapper.SelectAllType();
        return stringList;
    }
    public List<Commodities> FindAllFruit(){
        List<Commodities> commoditiesList = shopperMapper.SelectAllFruit();
        return commoditiesList;
    }
    //查询单个类型的水果
    public List<Commodities> FindFruitByName(String name){
        List<Commodities> fruitlist = shopperMapper.findFriutByName(name);
        return fruitlist;
    }

    @Override
    public Commodities FindFruitById(String fruitid) {
        Commodities commodities = shopperMapper.findFriutById(fruitid);
        return commodities;
    }

    @Override
    public List<ShopList> selectShoplistByShopperid(Shopper shopper) {
        List<ShopList> shopLists = shopperMapper.findShopListByShopperid(shopper);
        return shopLists;
    }

    @Override
    public List<ShopListVo> searchVo() {
        return shopperMapper.searchVo();
    }

    @Override
    public List<ShopListVo> searchVoByShopperid(Shopper shopper) {
        return shopperMapper.searchVoById(shopper);
    }

    public String insertIntoShoplist(ShopList shopList){
        shopperMapper.insertIntoShopList(shopList);
        return "加入购物车成功";
    }
}
