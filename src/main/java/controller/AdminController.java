package controller;

import config.MessageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Jiayiwu on 17/4/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Controller
public class AdminController {
    String adminName = "admin";
    String password = "becky";


    @RequestMapping("/login")
    @ResponseBody
    public MessageInfo login(HttpSession httpSession,String username,String password){
        if (username.equals(adminName)&&password.equals(password)){
            httpSession.setAttribute("user",true);
            return new MessageInfo(true,"登录成功");
        }
        return new MessageInfo(false,"账号或密码错误");

    }

}
