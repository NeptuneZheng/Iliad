package neptune.controller;

import com.alibaba.fastjson.JSONObject;
import neptune.po.User;
import neptune.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


/**
 * Created by ZHENGNE on 8/5/2018.
 */
@RestController  // for html, use RestController(@Responsebody + @Controller); for jsp, could only use @Controller
@CrossOrigin
public class LoginController {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/"})
    public RedirectView indexPage(){
        logger.warn("get the root route and redirect to login method");
        return new RedirectView("/loginVerify",true,false,false);
    }

    @RequestMapping(value = {"/loginVerify"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public boolean loginPage(@RequestBody JSONObject json){ //@RequestBody User user; @RequestBody Object object； @RequestBody JSONObject json
        logger.info("received loginVerify post request ..... " + json);
        User user = json.toJavaObject(User.class);
        return userService.loginOrRegister(user.getName(),user.getPassword());

    }

}
