package cn.yb.democat.controller;

import cn.yb.democat.entity.Result;
import cn.yb.democat.entity.ResultCode;
import cn.yb.democat.entity.UserEntity;
import cn.yb.democat.service.UserService;
import cn.yb.democat.tool.MD5;
import lombok.extern.slf4j.Slf4j;
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
        //对密码进行MD5加密
        String passwordMd5 = MD5.getMD5(password);
        List<UserEntity> list = us.GetUserByUsernameAndPassword(username,passwordMd5);
        if(list.size()==0){
            log.error("----------------账号或者密码错误-------------------");
            return Result.fail(ResultCode.USER_NOT_FIND);
        }
        return Result.suc(list);
    }

    //修改用户密码
    @RequestMapping("/changePassword")
    @ResponseBody
    public Result changePassword(String username,String password,String newPassword){
        if(username ==null | password == null | newPassword == null){
            log.error("----------------参数为空----------------");
            return Result.fail(ResultCode.PARAM_IS_NULL);
        }
        //对密码进行MD5加密
        String passwordMd5 = MD5.getMD5(password);
        List<UserEntity> list = us.GetUserByUsernameAndPassword(username,passwordMd5);
        if(list.size()==0){
            log.error("--------------账号或者密码错误---------------------");
            return Result.fail(ResultCode.USER_NOT_FIND);
        }
        //对密码进行MD5加密
        String newPasswordMd5 = MD5.getMD5(newPassword);
        us.UpdateUserPassword(list.get(0).getId(),newPasswordMd5);
        return Result.suc();
    }

    //注册新用户
    @RequestMapping("/registerUser")
    @ResponseBody
    public Result registerUser(String username,String password,String userphone,String emailaddress){
            if(username == null | password == null | userphone == null | emailaddress == null){
                log.error("------------参数为空----------------");
                return  Result.fail(ResultCode.PARAM_IS_NULL);
            }
            //对密码进行MD5加密
            String passwordMd5 = MD5.getMD5(password);
            UserEntity ue = new UserEntity();
            ue.setUserName(username);
            ue.setPassWord(passwordMd5);
            ue.setUserPhone(userphone);
            ue.setEmailAddress(emailaddress);
            us.InsertNewUser(ue);

            int id = ue.getId();
            List<UserEntity> list = us.GetUserById(id);
            return  Result.suc(list);
    }
}
