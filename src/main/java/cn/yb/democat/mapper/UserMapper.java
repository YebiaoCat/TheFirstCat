package cn.yb.democat.mapper;

import cn.yb.democat.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<UserEntity> AllUser(String username);
}
