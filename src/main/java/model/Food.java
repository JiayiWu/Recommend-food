package model;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Entity
public class Food {

    @Id
    @GeneratedValue
    private int id;
    //食物名称
    private String foodName;
    //食物类型:0 主食 1热饮 2冷饮 3零食或者水果 4可携带食物
    private int type;


    public Food() {
    }

    public Food(String foodName, int type) {
        this.foodName = foodName;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
