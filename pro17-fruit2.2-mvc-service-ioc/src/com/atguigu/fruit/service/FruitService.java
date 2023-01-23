package com.atguigu.fruit.service;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public interface FruitService {

    List<Fruit> getFruitList(String keyword, Integer pageNo);

    void addFruit(Fruit fruit);

    Fruit getFruitByFid(Integer fid);

    void delFruit(Integer fid);

    Integer getPageCount(String keyword);

    void updateFruit(Fruit fruit);
}
