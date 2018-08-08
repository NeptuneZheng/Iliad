package neptune.service;

import neptune.domain.User;

/**
 * Created by ZHENGNE on 8/2/2018.
 */
public interface UserService {
    public boolean verifyUserLogin(String usr_name, String usr_password);
    public User getUserInfoByName(String usr_name);
    public User addNewUser(User user);
    public void recordUserAction(String usr_name, String login_ip);
}
