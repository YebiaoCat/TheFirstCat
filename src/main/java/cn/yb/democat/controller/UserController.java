package cn.yb.democat.controller;

import cn.yb.democat.entity.Result;
import cn.yb.democat.entity.ResultCode;
import cn.yb.democat.entity.UserEntity;
import cn.yb.democat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/User")
@Slf4j
public class UserController {
    @Autowired
    private UserService us;

    //根据username用户名查询用户信息
    @RequestMapping("/getUserAll")
    @ResponseBody
    public Result getUserAll(String username){
        if(username==null){
            log.error("----------用户名为空----------");
            return Result.fail(ResultCode.PARAM_IS_NULL);
        }
        List<UserEntity> userList = us.getAllUser(username);
        if(userList.size()==0){
            log.error("----------未查到该用户----------");
            return Result.fail(ResultCode.USER_NOT_FIND);
        }
        return Result.suc(userList);
    }


    //验证用户登录信息进行登录
    @RequestMapping("/login")
    @ResponseBody
    public Result getUserLogin(String username,String password){
        if(username == null || password == null){
            log.error("------------用户名和密码不能为空-------------");
            return Result.fail(ResultCode.PARAM_IS_NULL);
        }
        List<UserEntity> list = us.GetUserByUsernameAndPassword(username,password);
        if(list.size()==0){
            log.error("----------------账号或者密码错误-------------------");
            return Result.fail(ResultCode.USER_NOT_FIND);
        }
        return Result.suc(list);
    }
}
