package com.sdust.service;

import com.sdust.entity.Commodities;
import com.sdust.entity.ShopList;
import com.sdust.entity.ShopListVo;
import com.sdust.entity.Shopper;

import java.util.List;

/**
 * Created by Cierlly on 7/13/2019.
 */
public interface IShopperService {
    String inster(Shopper shopper);
    Shopper findUserByPhone(String phone);
     List<String> FindType();
    List<Commodities> FindAllFruit();
    List<Commodities> FindFruitByName(String name);

    Commodities FindFruitById(String fruitid);

    List<ShopList> selectShoplistByShopperid(Shopper shopper);

    List<ShopListVo> searchVo();

    List<ShopListVo> searchVoByShopperid(Shopper shopper);
}
