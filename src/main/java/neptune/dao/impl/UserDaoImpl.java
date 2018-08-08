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
    public User findUserByUserID(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)),User.class);
    }

    @Override
    public User findUserByUserName(String usr_name) {
        return mongoTemplate.findOne(new Query(Criteria.where("usr_name").is(usr_name)),User.class);
    }

    @Override
    public User addNewUser(User user) {
        mongoTemplate.save(user);
        return mongoTemplate.findOne(new Query(Criteria.where("usr_name").is(user.getUsr_name()).and("usr_password").is(user.getUsr_password())),User.class);
    }
}
