package controller;

import config.FoodList;
import config.MessageInfo;
import config.SloganList;
import model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ManageFood;
import util.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Controller
public class MainController {


    @Resource
    ManageFood manageFood;

    @RequestMapping("/food/init")
    @ResponseBody
    public boolean initFood(){
        try {
            manageFood.initFood();
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

        return true;

    }

    @RequestMapping("/food/add")
    @ResponseBody
    public MessageInfo addFood(HttpSession session,String name,int type){
        if (session.getAttribute("user")!=null)
        return manageFood.addFood(new Food(name,type));
        return new MessageInfo(false,"您无权限进行操作");
    }

    @RequestMapping("/food/delete")
    @ResponseBody
    public MessageInfo deleteFood(HttpSession session,int[] orderid) {
        if (session.getAttribute("user") != null) {
            for (int tem : orderid) {
                if (!manageFood.deleteFood(tem).isResult()) {
                    return new MessageInfo(false, "某些食品状态异常,只处理了部分订单");
                }
            }
            return new MessageInfo(true,"删除成功");
        }
        return new MessageInfo(false, "您无权限进行操作");

    }

    @RequestMapping("/food/list")
    @ResponseBody
    public Object getList(HttpSession session,int type){

        return manageFood.findFoodList(type);

    }




    @RequestMapping("/food/recommend")
    @ResponseBody
    public MessageInfo getRecommend(){

        if (DateUtil.isLate()){
            if (!FoodList.isLate()){
                manageFood.initFood();
                FoodList.setIsLate(true);
            }
        }
        return manageFood.getRecommend();

    }

    @RequestMapping("/word/recommend")
    @ResponseBody
    public String getRecommendWord(){
        if (SloganList.getRecommendWord().equals(""))
            SloganList.recommend();
        return SloganList.getRecommendWord();
    }



}
