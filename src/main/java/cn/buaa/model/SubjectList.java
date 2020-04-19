package cn.buaa.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "subject")
public class SubjectList {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "UID")
    private Integer uid;

    /**
     * 问卷ID
     */
    @Column(name = "SUBJECT_ID")
    private Integer subjectId;

    /**
     * 问卷调查标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 简介
     */
    @Column(name = "INFO")
    private String info;

    /**
     * 调查次数
     */
    @Column(name = "NUMBER")
    private Integer number;

    /**
     * 问卷类型
     */
    @Column(name = "TYPE")
    private Short type;

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
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 获取主键
     *
     * @return ID - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return UID - 用户ID
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置用户ID
     *
     * @param uid 用户ID
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取问卷ID
     *
     * @return SUBJECT_ID - 问卷ID
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 设置问卷ID
     *
     * @param subjectId 问卷ID
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取问卷调查标题
     *
     * @return TITLE - 问卷调查标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置问卷调查标题
     *
     * @param title 问卷调查标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取简介
     *
     * @return INFO - 简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置简介
     *
     * @param info 简介
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * 获取调查次数
     *
     * @return NUMBER - 调查次数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置调查次数
     *
     * @param number 调查次数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取问卷类型
     *
     * @return TYPE - 问卷类型
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置问卷类型
     *
     * @param type 问卷类型
     */
    public void setType(Short type) {
        this.type = type;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}