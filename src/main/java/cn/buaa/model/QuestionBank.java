package cn.buaa.model;

import lombok.Data;

import java.util.List;


/**
 * @author Bob
 */
@Data
public class QuestionBank {

    private Integer id;

    private Integer subjectId;

    private String subjectName;

    private String  rightAnswer;

    private String  subjectType;

    private String  status;

    private Integer  createUser;

    private String  createTime;

    private Integer  updateUser;

    private String  update_time;

    private List<QuestionAnswer> questionAnswerList;

}
