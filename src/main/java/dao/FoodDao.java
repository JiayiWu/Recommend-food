package dao;

import config.MessageInfo;
import model.Food;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */

@Repository
public class FoodDao {
    @Resource
    BaseDao baseDao;


    public List<Food> findFood(int type){
        if (type==0){
            List<Food> result  = (List<Food>)baseDao.findByProperty(Food.class,"type",0).getObject();
            List<Food> result1  = (List<Food>)baseDao.findByProperty(Food.class,"type",4).getObject();
            for (Food tem :result1){
                result.add(tem);
            }
            return result;

        }
        return (List<Food>)baseDao.findByProperty(Food.class,"type",type).getObject();
    }

    public MessageInfo addFood(Food food){
        return baseDao.save(food);
    }

    public MessageInfo deleteFood(int id){
        return baseDao.deleteById(Food.class,id);
    }



}
