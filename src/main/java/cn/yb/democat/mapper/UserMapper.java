package cn.yb.democat.mapper;

import cn.yb.democat.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<UserEntity> AllUser(@Param("username") String username);

    List<UserEntity> GetUserByUsernameAndPassword(@Param("username")String username,@Param("password") String password);

    void UpdateUserPassword(@Param("id")int id,@Param("newPassword")String newPassword);

    void InsertNewUser(@Param("user") UserEntity user);

    List<UserEntity> GetUserById(@Param("id")int id);
}
