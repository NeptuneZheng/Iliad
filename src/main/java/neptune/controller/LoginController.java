package neptune.controller;

import neptune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by ZHENGNE on 8/5/2018.
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index.html"})
    public ModelAndView loginPage(){
        System.out.println("--------------");
        return new ModelAndView("index.jsp");
    }

    @RequestMapping(value =  "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request){
        return null;
    }

}
