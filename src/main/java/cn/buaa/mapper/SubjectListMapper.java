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

    @Select("SELECT * FROM subject WHERE TITLE regexp #{title}")
    public List<SubjectList> queryByTitle(@Param("title") String title);

    @Select("SELECT * FROM subject ")
    public List<SubjectList> query();

    Subject getSubjectDetailBySubjectId(String subjectId);

    void insertSubject(Subject subject);

    void updateSubject(Subject subject);

    void insertQuestionBank(QuestionBank questionBank);

    void updateQuestionBank(QuestionBank questionBank);

    void updateQuestionAnswer(QuestionAnswer questionAnswer);

    void insertQuestionAnswer(QuestionAnswer questionAnswer);

    void saveUserAnswer(UserAnswer userAnswer);

    UserAnswer checkUserAnswer(UserAnswer userAnswer);
}