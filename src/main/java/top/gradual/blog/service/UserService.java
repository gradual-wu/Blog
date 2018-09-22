package top.gradual.blog.service;

import top.gradual.blog.domain.dto.UserInfoInputDTO;
import top.gradual.blog.domain.dto.UserInfoResultDTO;

/**
 * @Description: 用户相关服务层
 * @Author: gradual
 * @Date: 2018-09-03 15:36
 */
public interface UserService {

    UserInfoResultDTO getUserById(Long id);

    UserInfoResultDTO getUserByUserName(String userName);

    UserInfoResultDTO addUser(UserInfoInputDTO userInfoInputDTO);

    UserInfoResultDTO updateUserInfo(UserInfoInputDTO userInfoInputDTO);

    boolean deleteUserById(Long id);

    UserInfoResultDTO userLogin(UserInfoInputDTO infoInputDTO);
}
