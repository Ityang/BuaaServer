package cn.buaa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author Bob
 */
@Data
public class Subject {
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
     * 状态
     */
    @Column(name = "status")
    private String status;

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

    private List<QuestionBank> questionBankList;
}
