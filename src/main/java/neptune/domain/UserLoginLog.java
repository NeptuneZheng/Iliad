package neptune.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZHENGNE on 7/30/2018.
 */
public class UserLoginLog implements Serializable{
    private String usr_id;
    private Date login_dtm;
    private String login_ip;

    public UserLoginLog() {
    }

    public UserLoginLog(String usr_id, Date login_dtm, String login_ip) {
        this.usr_id = usr_id;
        this.login_dtm = login_dtm;
        this.login_ip = login_ip;
    }

    public UserLoginLog(Date login_dtm, String login_ip) {
        this.login_dtm = login_dtm;
        this.login_ip = login_ip;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public Date getlogin_dtm() {
        return login_dtm;
    }

    public void setlogin_dtm(Date login_dtm) {
        this.login_dtm = login_dtm;
    }

    public String getlogin_ip() {
        return login_ip;
    }

    public void setlogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    @Override
    public String toString() {
        return "User{" +
                "usr_id='" + usr_id + '\'' +
                ", usr_name='" + login_dtm + '\'' +
                ", usr_password='" + login_ip + '\'' +
                '}';
    }
}
