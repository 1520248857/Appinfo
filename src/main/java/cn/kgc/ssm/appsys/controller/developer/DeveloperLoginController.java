package cn.kgc.ssm.appsys.controller.developer;


import cn.kgc.ssm.appsys.pojo.DevUser;
import cn.kgc.ssm.appsys.service.DevUserService;
import cn.kgc.ssm.appsys.tools.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DeveloperLoginController {

    @Resource
    DevUserService devUserService;

    @RequestMapping("/login")
    public String login() {
        return "devlogin";
    }

    @RequestMapping("/dologin")
    public ModelAndView dologin(String devCode, String devPassword, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        DevUser devUser = devUserService.login(devCode, devPassword);
        if (devCode != null) {
            modelAndView.setViewName("redirect:/dev/flatfrom/main");
            session.setAttribute(Constants.DEV_USER_SESSION, devUser);
        } else {
            modelAndView.setViewName("devlogin");
            modelAndView.addObject("error", "用户名密码错误!!!");
        }
        return modelAndView;
    }


    @RequestMapping("/flatfrom/main")
    public String flatfromMain(HttpSession session) {
        DevUser devUser = (DevUser) session.getAttribute(Constants.DEV_USER_SESSION);
        if (devUser == null) {
            return "delogin";
        }
        return "developer/main";
    }
}
