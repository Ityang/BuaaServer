package cn.buaa.model;

import lombok.Data;

/**
 * @autor wangy
 * @date 2020/4/5 14:53
 **/
@Data
public class UserAnswer {

    private Integer id;

    private Integer userId;

    private Integer subjectId;

    private Integer questionId;

    private String answer;

    private String remark;

    private String status;

    private String createTime;

    private String updateTime;
}
