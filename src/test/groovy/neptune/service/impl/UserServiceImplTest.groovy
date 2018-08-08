package neptune.service.impl

import neptune.domain.User
import neptune.service.UserService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * Created by ZHENGNE on 8/6/2018.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest extends Specification {

    @Autowired
    private UserService userService

    void setup() {

    }

    void cleanup() {
    }

    def "VerifyUserLogin"() {
        given:
        boolean b = userService.verifyUserLogin(name,password)

        expect:
        b == exp

        where:
        name    |   password    |   exp
        'aa'    |   'aa'        |   true
        'aa'    |   'bb'        |   false

    }

    def "GetUserInfoByName"() {
        given:
        User user = userService.getUserInfoByName(name)

        expect:
        user.getUsr_id() == id

        where:
        name    |   id
        'aa'    |   '74b87337454200d4d33f80c4663dc5e5'


    }
    def "AddNewUser"() {
        given:
        User user = userService.addNewUser(new User('aa',name,password))

        expect:
        user.toString() != a

        where:
        name    |   password    |   a
        'aa'    |   'aa'        |   ''
    }


    def "RecordUserAction"() {
        given:
        userService.recordUserAction('aa','192.168.1.1')
    }
}
