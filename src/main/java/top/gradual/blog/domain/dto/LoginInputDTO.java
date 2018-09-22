package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 登录类
 * @Author: gradual
 * @Date: 2018-08-27 13:45
 */
public class LoginInputDTO implements Serializable {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
