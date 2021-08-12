package cn.kgc.ssm.appsys.controller.backend;


import cn.kgc.ssm.appsys.tools.Constants;
import cn.kgc.ssm.appsys.pojo.BackendUser;
import cn.kgc.ssm.appsys.service.BackendUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static cn.kgc.ssm.appsys.tools.Constants.USER_SESSION;


@Controller
@RequestMapping("/manager")
public class BackendLoginController {
    @Resource
    BackendUserService backendUserService;
    @RequestMapping("/login")
    public String login() {
        return "backendlogin";
    }

    @RequestMapping("/dologin")
    public ModelAndView dologin(String userCode, String userPassword, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        BackendUser backendUser = backendUserService.login(userCode, userPassword);
        if (backendUser != null) {
            session.setAttribute(Constants.USER_SESSION, backendUser);
            modelAndView.setViewName("redirect:/manager/backend/main");
        } else {
            modelAndView.addObject("error", "密码用户名错误");
            modelAndView.setViewName("backendlogin");
        }
        return modelAndView;
    }


    @RequestMapping("/backend/main")
    public String backendMain(HttpSession session) {
        BackendUser backendUser = (BackendUser) session.getAttribute(Constants.USER_SESSION);
        if (backendUser == null) {
            return "backendlogin";
        }
        return "backend/main";
    }




}
