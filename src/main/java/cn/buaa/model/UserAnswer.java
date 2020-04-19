package cn.buaa.model;

import lombok.Data;

/**
 * @author Bob
 */
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
