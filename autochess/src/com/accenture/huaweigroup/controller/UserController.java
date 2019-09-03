package com.accenture.huaweigroup.controller;

import com.accenture.huaweigroup.module.entity.User;
import com.accenture.huaweigroup.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "用户接口", tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;
    private Logger LOG = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/loginIdentify", method = {RequestMethod.GET})
    public String loginCheck(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd) {
        try {
            boolean state = userService.loginCheck(userName, userPwd);
            return state ? "ok" : "error";
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("登录过程出现错误！");
        }
        return "error";
    }


    /**
     * 接口名： /user/register
     * 调用方法： POST
     * 参数： userName 用户登录名
     *       userPwd  用户密码
     * 返回值：注册成功返回ok，失败返回error
     *
     * @param userDTO 封装用户注册信息的pojo
     * @return 成功返回ok，否则返回error
     */
//    @RequestMapping(value = "/register", method = {RequestMethod.POST})
//    public String userRegister(@RequestBody UserDTO userDTO) {
//        try {
//            userService.insert(new User(userDTO.getUserName(), userDTO.getUserPwd(), null, userDTO.getUserName()));
//            return "ok";
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOG.error("注册过程出现错误！");
//        }
//        return "error";
//    }


}
