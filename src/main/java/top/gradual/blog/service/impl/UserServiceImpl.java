package top.gradual.blog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import top.gradual.blog.dao.mapper.UserInfoMapper;
import top.gradual.blog.domain.dto.UserInfoInputDTO;
import top.gradual.blog.domain.dto.UserInfoResultDTO;
import top.gradual.blog.domain.entites.UserInfo;
import top.gradual.blog.domain.entites.UserInfoExample;
import top.gradual.blog.service.UserService;
import top.gradual.blog.util.Base64Utils;

/**
 * @Description: 用户服务层实现类
 * @Author: gradual
 * @Date: 2018-09-03 15:55
 */
@Service("userService")
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * @description: 根据用户ID查找用户
     *
     * @author: gradual
     * @date: 2018/9/3 16:04
     * @param: [id]
     * @return: top.gradual.blog.domain.dto.UserInfoResultDTO
     */
    @Override
    public UserInfoResultDTO getUserById(Long id) {
        logger.debug("获取用户ID为" + id + "的用户");
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        UserInfoResultDTO userInfoResult = new UserInfoResultDTO();
        BeanUtils.copyProperties(userInfo, userInfoResult);
        return userInfoResult;
    }

    @Override
    public UserInfoResultDTO getUserByUserName(String userName) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<UserInfo> users = userInfoMapper.selectByExample(example);
        if (users.size() <= 0) {
            return null;
        }
        UserInfoResultDTO userInfoResultDTO = new UserInfoResultDTO();
        BeanUtils.copyProperties(users.get(0), userInfoResultDTO);
        return userInfoResultDTO;
    }

    @Override
    public UserInfoResultDTO userLogin(UserInfoInputDTO infoInputDTO) {
        try {
            UserInfoResultDTO resultDTO = getUserByUserName(infoInputDTO.getUsername());
            if (Base64Utils.base64(infoInputDTO.getPassword()).equals(resultDTO.getPassword())) {
                logger.debug("密码正确，允许登录");
                return resultDTO;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("登录失败！");
        }

    }

    @Override
    public UserInfoResultDTO addUser(UserInfoInputDTO userInfoInputDTO) {
        return null;
    }

    @Override
    public UserInfoResultDTO updateUserInfo(UserInfoInputDTO userInfoInputDTO) {
        return null;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
