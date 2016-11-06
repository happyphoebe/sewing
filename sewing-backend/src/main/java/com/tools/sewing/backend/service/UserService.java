package com.tools.sewing.backend.service;

import com.tools.sewing.backend.vo.UserRoleVO;
import com.tools.sewing.backend.vo.UserVO;

import java.util.List;

/**
 * Created by Phoebe on 2016/11/6.
 */
public interface UserService {

    List<UserRoleVO> getAllUsers();

    List<UserVO> getUserByName(String name);

}
