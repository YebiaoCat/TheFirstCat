package cn.yb.democat.mapper;

import cn.yb.democat.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<UserEntity> AllUser(@Param("username") String username);
    List<UserEntity> GetUserByUsernameAndPassword(@Param("username")String username,@Param("password") String password);
}
