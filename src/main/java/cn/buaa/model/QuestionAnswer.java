package cn.buaa.model;

import lombok.Data;

@Data
public class QuestionAnswer {

    private Integer id;

    private Integer questionId;

    private String answer;

    private String answerMark;

    private String status;

    private Integer  createUser;

    private String  createTime;

    private Integer  updateUser;

    private String  update_time;

}
