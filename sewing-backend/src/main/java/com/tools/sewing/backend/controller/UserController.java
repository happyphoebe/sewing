package com.tools.sewing.backend.controller;

import com.tools.sewing.backend.common.Result;
import com.tools.sewing.backend.common.ResultCode;
import com.tools.sewing.backend.service.UserService;
import com.tools.sewing.backend.utils.ResponseUtils;
import com.tools.sewing.backend.vo.UserRoleVO;
import com.tools.sewing.backend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Phoebe on 2016/11/6.
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @ResponseBody
    public Result getUsers(){
        List<UserRoleVO> data = userService.getAllUsers();
        return ResponseUtils.success(ResultCode.SUCCESS, data);
    }

    @RequestMapping(value ="/user", method = RequestMethod.GET)
    @ResponseBody
    public Result getUsers(@RequestParam(value = "name") String name){
        List<UserVO> data = userService.getUserByName(name);
        return ResponseUtils.success(ResultCode.SUCCESS, data);
    }
}
