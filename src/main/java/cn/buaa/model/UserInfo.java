package cn.buaa.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "users_info")
public class UserInfo {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * IMEI 号
     */
    @Column(name = "IMEI")
    private String imei;

    /**
     * 密码
     */
    @Column(name = "PASS")
    private String pass;

    /**
     * 当前账户的状态 0、正常；1、注销
     */
    @Column(name = "STATUS")
    private Short status;

    /**
     * 手机号码
     */
    @Column(name = "TELL")
    private String tell;

    /**
     * 用户角色 0，普通用户 ；1、管理员账户
     */
    @Column(name = "ROLE")
    private Short role;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_AT")
    private Date createdAt;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    /**
     * 删除时间
     */
    @Column(name = "DELETED_AT")
    private Date deletedAt;

    /**
     * 获取用户主键
     *
     * @return ID - 用户主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户主键
     *
     * @param id 用户主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return USERNAME - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取IMEI 号
     *
     * @return IMEI - IMEI 号
     */
    public String getImei() {
        return imei;
    }

    /**
     * 设置IMEI 号
     *
     * @param imei IMEI 号
     */
    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    /**
     * 获取密码
     *
     * @return PASS - 密码
     */
    public String getPass() {
        return pass;
    }

    /**
     * 设置密码
     *
     * @param pass 密码
     */
    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    /**
     * 获取当前账户的状态 0、正常；1、注销
     *
     * @return STATUS - 当前账户的状态 0、正常；1、注销
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置当前账户的状态 0、正常；1、注销
     *
     * @param status 当前账户的状态 0、正常；1、注销
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取手机号码
     *
     * @return TELL - 手机号码
     */
    public String getTell() {
        return tell;
    }

    /**
     * 设置手机号码
     *
     * @param tell 手机号码
     */
    public void setTell(String tell) {
        this.tell = tell == null ? null : tell.trim();
    }

    /**
     * 获取用户角色 0，普通用户 ；1、管理员账户
     *
     * @return ROLE - 用户角色 0，普通用户 ；1、管理员账户
     */
    public Short getRole() {
        return role;
    }

    /**
     * 设置用户角色 0，普通用户 ；1、管理员账户
     *
     * @param role 用户角色 0，普通用户 ；1、管理员账户
     */
    public void setRole(Short role) {
        this.role = role;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_AT - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_AT - 更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取删除时间
     *
     * @return DELETED_AT - 删除时间
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * 设置删除时间
     *
     * @param deletedAt 删除时间
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}