package neptune.service.impl;

import neptune.dao.UserDao;
import neptune.dao.UserLoginLogDao;
import neptune.domain.User;
import neptune.domain.UserLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import neptune.service.UserService;

import java.util.Calendar;

/**
 * Created by ZHENGNE on 8/2/2018.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    private UserLoginLogDao userLoginLogDao;

    @Override
    public boolean verifyUserLogin(String usr_name, String usr_password) {

        return userDao.getMatchCount(usr_name,usr_password) > 0;
    }

    @Override
    public User getUserInfoByName(String usr_name) {

        return userDao.findUserByUserName(usr_name);
    }

    @Override
    @Transactional
    public void recordUserAction(String usr_name, String login_ip) {
        User user = userDao.findUserByUserName(usr_name);
        Calendar calendar = Calendar.getInstance();
        UserLoginLog userLoginLog = new UserLoginLog(user.getUsr_id(),calendar.getTime(),login_ip);
        userLoginLogDao.insertLoginLog(userLoginLog);
    }
}
