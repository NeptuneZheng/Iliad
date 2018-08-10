package neptune.service.impl;

import jdk.nashorn.internal.runtime.Context;
import neptune.dao.UserDao;
import neptune.dao.UserLoginLogDao;
import neptune.domain.User;
import neptune.domain.UserLoginLog;
import neptune.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by ZHENGNE on 8/2/2018.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLoginLogDao userLoginLogDao;

    @Override
    public boolean verifyUserLogin(String usr_name, String usr_password) {
        return userDao.findUserByUserID(DigestUtils.md5Hex(usr_name + usr_password)) != null;
    }

    @Override
    public User getUserInfoByName(String usr_name) {
        return userDao.findUserByUserName(usr_name);
    }

    @Override
    public User addNewUser(User user) {
        String id = DigestUtils.md5Hex(user.getUsr_name() + user.getUsr_password());
        user.setUsr_id(id);
        return userDao.addNewUser(user);
    }

    @Transactional
    @Override
    public void recordUserAction(String usr_name, String login_ip) {
        User user = userDao.findUserByUserName(usr_name);
        if(user != null){
            Calendar calendar = Calendar.getInstance();
            UserLoginLog userLoginLog = new UserLoginLog(user.getUsr_id(),calendar.getTime(),login_ip);
            userLoginLogDao.insertLoginLog(userLoginLog);
        }else {
            new Context.ThrowErrorManager().error("user info not exist, pls help to check!");
        }
    }
}
