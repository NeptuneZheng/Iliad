package neptune.controller;

import neptune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by ZHENGNE on 8/5/2018.
 */
@RestController  // for html, use RestController(@Responsebody + @Controller); for jsp, could only use @Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/"})
    public ModelAndView indexPage(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = {"/index.html"})
    public String loginPage(){
        userService.verifyUserLogin("aaa","aaa");
        return "loginPage";
    }

    @RequestMapping(value =  "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request){
        return null;
    }

}
