package neptune.controller;

import neptune.po.Hero;
import neptune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ZHENGNE on 8/5/2018.
 */
@Controller  // for html, use RestController(@Responsebody + @Controller); for jsp, could only use @Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/"})
    public RedirectView indexPage(){
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/index");
        return redirectView;
    }


    @RequestMapping(value = {"/index"})
    public String loginPage(){
        userService.verifyUserLogin("aaa","aaa");
        return "loginPage";
    }

    @RequestMapping(value =  "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request){
        return null;
    }

    @RequestMapping(value = "/cHeroes")
    @ResponseBody
    public List<Hero> getHeroes(){
        System.out.println("accept ../cHeroes request");
        List<Hero> heroes = new ArrayList<>();
        int i = 0;
        while (i< 7){
            Hero hero = new Hero(i*3,"Eva"+i);
            heroes.add(hero);
            i++;
        }
        return heroes;
    }

}
