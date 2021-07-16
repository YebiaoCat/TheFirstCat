package cn.yb.democat.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Integer Id;
    private String userName;
    private String netName;
    private String passWord;
    private Integer userAge;
    private String userSex;
    private String userDescribe;
    private String userPhone;
    private String emailAddress;
}
