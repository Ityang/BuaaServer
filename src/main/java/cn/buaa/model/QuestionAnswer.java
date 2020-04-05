package cn.buaa.model;

import lombok.Data;

/**
 * @autor wangy
 * @date 2020/4/4 17:41
 **/
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
