package neptune.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by ZHENGNE on 7/30/2018.
 */
@Document
public class User implements Serializable{
    @Id
    private String usr_id;
    private String usr_name;
    private String usr_password;

    public User() {
    }

    public User(String usr_id, String usr_name, String usr_password) {
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_password = usr_password;
    }

    public User(String usr_name, String usr_password) {
        this.usr_name = usr_name;
        this.usr_password = usr_password;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "usr_id='" + usr_id + '\'' +
                ", usr_name='" + usr_name + '\'' +
                ", usr_password='" + usr_password + '\'' +
                '}';
    }
}
