package neptune.dao.impl;

import neptune.dao.UserLoginLogDao;
import neptune.domain.UserLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZHENGNE on 8/2/2018.
 */
@Repository("UserLoginLogDaoImpl")
public class UserLoginLogDaoImpl implements UserLoginLogDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertLoginLog(UserLoginLog userLoginLog) {
        mongoTemplate.save(userLoginLog,"user_log");
    }
}
