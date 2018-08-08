package neptune.dao;

import neptune.domain.User;

/**
 * Created by ZHENGNE on 8/1/2018.
 */
public interface UserDao {
    public User findUserByUserID(String id);
    public User findUserByUserName(String usr_name);
    public User addNewUser(User user);
}
