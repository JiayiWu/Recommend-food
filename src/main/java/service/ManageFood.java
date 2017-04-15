package service;

import config.FoodList;
import config.MessageInfo;
import dao.FoodDao;
import model.Food;
import org.springframework.stereotype.Service;
import vo.FoodVO;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Service
public class ManageFood {

    @Resource
    FoodDao foodDao;

    public void initFood(){
        Random random = new Random();
        FoodList.initFood();
        if (!util.DateUtil.isLate()) {
            for (int i = 0; i <= 3; i++) {
                List<Food> foods = foodDao.findFood(i);
                if (foods.size() > 0) {
                    int param = random.nextInt(foods.size());
                    FoodList.addFood(new FoodVO(foods.get(param)));
                }
            }
        }else {
            List<Food> foods = foodDao.findFood(4);
            if (foods.size() > 0) {
                int param = random.nextInt(foods.size());
                FoodList.addFood(new FoodVO(foods.get(param)));
            }else {
                List<Food> foods1 = foodDao.findFood(0);
                int param = random.nextInt(foods.size());
                FoodList.addFood(new FoodVO(foods.get(param)));
            }
        }
    }

    public MessageInfo getRecommend(){
        if (util.DateUtil.isLate()){
            return new MessageInfo(false,FoodList.getFoodList(),"快迟到了,拿点东西就去上课吧!");
        }else
            return new MessageInfo(true,FoodList.getFoodList(),"获取成功");
    }

    public MessageInfo addFood(Food food){
        return foodDao.addFood(food);
    }

    public Object findFoodList(int type){
        return foodDao.findFood(type);
    }

    public MessageInfo deleteFood(int id){
        return foodDao.deleteFood(id);
    }


}
