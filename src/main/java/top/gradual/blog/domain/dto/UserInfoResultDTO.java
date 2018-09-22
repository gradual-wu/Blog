package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 服务器返回的用户实体信息类
 * @Author: gradual
 * @Date: 2018-09-03 15:41
 */
public class UserInfoResultDTO implements Serializable {
    private String username;
    private String password;
    private Long id;
    private Integer status;
    private Integer role;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserInfoResultDTO{" +
                "userName='" + username + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", role=" + role +
                '}';
    }
}
