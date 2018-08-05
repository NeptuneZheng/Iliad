package neptune.dao;

import neptune.domain.User;

/**
 * Created by ZHENGNE on 8/1/2018.
 */
public interface UserDao {
    public int getMatchCount(String usr_name, String usr_password);
    public User findUserByUserName(String usr_name);
}
