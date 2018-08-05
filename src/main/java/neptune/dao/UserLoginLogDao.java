package neptune.dao;

import neptune.domain.UserLoginLog;

/**
 * Created by ZHENGNE on 8/2/2018.
 */
public interface UserLoginLogDao {
    public void insertLoginLog(UserLoginLog userLoginLog);
}
