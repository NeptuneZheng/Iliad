package neptune.dao.impl;

import neptune.dao.UserDao;
import neptune.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by ZHENGNE on 8/1/2018.
 */
@Repository("UserDaoImpl")
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int getMatchCount(String usr_name, String usr_password) {
        return mongoTemplate.find(new Query(Criteria.where("usr_name").is(usr_name).and("usr_password").is(usr_password)),User.class).size();
    }

    @Override
    public User findUserByUserName(String usr_name) {
        return mongoTemplate.findOne(new Query(Criteria.where("usr_name").is(usr_name)),User.class);
    }
}
