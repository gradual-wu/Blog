package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 用户信息输入实体类(一般用于用户信息修改和用户注册)
 * @Author: gradual
 * @Date: 2018-09-03 15:41
 */
public class UserInfoInputDTO implements Serializable {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfoInputDTO{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
