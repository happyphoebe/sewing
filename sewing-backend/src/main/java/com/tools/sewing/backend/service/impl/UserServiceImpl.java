package com.tools.sewing.backend.service.impl;

import com.tools.sewing.backend.service.UserService;
import com.tools.sewing.backend.vo.UserRoleVO;
import com.tools.sewing.backend.vo.UserVO;
import com.tools.sewing.core.dao.sewing.UsersDao;
import com.tools.sewing.core.mapper.sewing.UserMapper;
import com.tools.sewing.core.po.sewing.UsersPO;
import com.tools.sewing.core.po.sewingMapper.UserMapperPO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoebe on 2016/11/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<UserRoleVO> getAllUsers() {
        List<UserRoleVO> userRoleVOs = new ArrayList<>();
        List<UserMapperPO> userMapperPOs = userMapper.findAll();
        for (UserMapperPO userMapperPO : userMapperPOs){
            UserRoleVO userRoleVO = new UserRoleVO();
            BeanUtils.copyProperties(userMapperPO, userRoleVO);
            userRoleVOs.add(userRoleVO);
        }
        return userRoleVOs;
    }

    @Override
    public List<UserVO> getUserByName(String name) {
        List<UserVO> userVOs = new ArrayList<>();
        List<UsersPO> usersPOs = usersDao.findByName(name);
        for (UsersPO usersPO : usersPOs){
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(usersPO, userVO);
            userVOs.add(userVO);
        }
        return userVOs;
    }

}
