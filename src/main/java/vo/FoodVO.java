package vo;

import model.Food;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class FoodVO {
    //食物品类
    private String name;
    //食物名称
    private String foodName;

    private int type;

    public FoodVO() {
    }

    public FoodVO(Food food){
        switch (food.getType()){
            case 0:
                this.name = "主食";
                break;
            case 1:
                this.name ="饮品";
                break;
            case 2:
                this.name ="饮品";
                break;
            case 3:
                this.name ="零食";
                break;
            default:
                this.name = "主食";
                break;
        }
        this.type = food.getType();
        this.foodName = food.getFoodName();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
