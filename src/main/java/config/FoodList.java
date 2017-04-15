package config;

import vo.FoodVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class FoodList {

    private static boolean isLate = false;

    private static ArrayList<FoodVO> foods = new ArrayList<FoodVO>();

    public static void initFood(){
        foods.clear();
    }

    public static void addFood(FoodVO foodVO){
        foods.add(foodVO);
    }

    public static List<FoodVO> getFoodList(){
        return foods;
    }

    public static boolean isLate() {
        return isLate;
    }

    public static void setIsLate(boolean isLate) {
        FoodList.isLate = isLate;
    }
}
