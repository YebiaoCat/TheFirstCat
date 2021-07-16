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
}
