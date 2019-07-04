package neptune.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import neptune.domain.User;
import neptune.po.Hero;
import neptune.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by ZHENGNE on 8/5/2018.
 */
@Controller  // for html, use RestController(@Responsebody + @Controller); for jsp, could only use @Controller
@CrossOrigin
public class LoginController {
    protected final Logger logger = LogManager.getLogger(this.getClass());

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
        return "loginPage";
    }

    @RequestMapping(value =  "/loginCheck", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String loginCheck(@RequestBody Map<?,?> map){
        if(userService.verifyUserLogin(map.get("userName").toString(),map.get("userPassword").toString())){
            return "mainPage";
        }else{
            return loginPage();
        }
    }

    @RequestMapping(value = "/cHeroes")
    @ResponseBody
    public List<Hero> getHeroes(){
        logger.info("accept ../cHeroes request");
        List<Hero> heroes = new ArrayList<>();
        int i = 0;
        while (i< 7){
            Hero hero = new Hero(i*3,"Eva"+i);
            heroes.add(hero);
            i++;
        }
        return heroes;
    }

    @RequestMapping(value = "/cHeroes/")
    @ResponseBody
    public List<Hero> getHeroe(){
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

    @RequestMapping(value = "/cHeroes/{id}")
    @ResponseBody
    public Hero getHeroeB(@PathVariable(name = "id") String id){
        logger.info("accept ../cHeroes request");

        return new Hero(99,"Boss");
    }

    @RequestMapping(value = "/cHeroes/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Hero updateHeroe(@RequestBody Map<?,?> map){
        logger.info("accept ../cHeroes/update request: %s",map.get("segment"));

        return new Hero(0,"Init");
    }

}
