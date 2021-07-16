package cn.yb.democat.service;

import cn.yb.democat.entity.UserEntity;
import cn.yb.democat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper um;

    public List<UserEntity> getAllUser(String username){
        return um.AllUser(username);
    }

    public List<UserEntity> GetUserByUsernameAndPassword(String username,String password){
        return um.GetUserByUsernameAndPassword(username,password);
    }

    public void UpdateUserPassword(int id,String newPassword){
        um.UpdateUserPassword(id,newPassword);
    }

    public void InsertNewUser(UserEntity ue){
        um.InsertNewUser(ue);
    }

    public List<UserEntity> GetUserById(int id){
        return um.GetUserById(id);
    }
}
