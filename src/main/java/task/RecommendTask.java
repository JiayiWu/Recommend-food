package task;


import config.FoodList;
import config.SloganList;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.ManageFood;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jiayiwu on 17/2/14.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Component
public class RecommendTask {
    @Resource
    ManageFood manageFood;
    //每天凌晨一点进行会员状态检查
    @Scheduled(cron = "0 0 1 * * ?")
    public void recommend(){
        manageFood.initFood();
        FoodList.setIsLate(false);
        SloganList.recommend();
    }
}
