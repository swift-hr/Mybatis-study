package mybatis.simple.model;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 * */
public class SysUser {
    /**
     * id
     * */
    private Long id;
    /**
     * 名称
     * */
    private String userName;
    /**
     * 密码
     * */
    private String userPassword;
    /**
     * 邮箱
     * */
    private String userEmail;
    /**
     * 用户信息
     * */
    private String userInfo;
    /**
     * 头像
     * */
    private byte[] headImg;
    /**
     * 创建日期
     * */
    private Date createTime;

    private List<SysRole> role;

    public List<SysRole> getRole() {
        return role;
    }

    public void setRole(List<SysRole> role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
