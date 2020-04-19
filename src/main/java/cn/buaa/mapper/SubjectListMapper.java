package cn.buaa.mapper;

import cn.buaa.common.MyMapper;
import cn.buaa.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Bob
 */
public interface SubjectListMapper extends MyMapper<SubjectList> {

    @Select("SELECT * FROM subject WHERE TITLE regexp #{title} and status =1")
    public List<SubjectList> queryByTitle(@Param("title") String title);

    @Select("SELECT * FROM subject where status=1")
    public List<SubjectList> query();

    @Select("SELECT * FROM subject where uid= #{uid}")
    public List<SubjectList> queryById(@Param("uid")int uid);

    Subject getSubjectDetailBySubjectId(String subjectId);

    void insertSubject(Subject subject);

    void updateSubject(Subject subject);

    void insertQuestionBank(QuestionBank questionBank);

    void updateQuestionBank(QuestionBank questionBank);

    void updateQuestionAnswer(QuestionAnswer questionAnswer);

    void insertQuestionAnswer(QuestionAnswer questionAnswer);

    void saveUserAnswer(UserAnswer userAnswer);

    UserAnswer checkUserAnswer(UserAnswer userAnswer);

    List<UserAnswer> checkUserAnswerById(UserAnswer userAnswer);

    List<UserAnswer> getStatistics(UserAnswer userAnswer);
}