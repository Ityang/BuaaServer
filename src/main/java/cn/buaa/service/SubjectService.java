package cn.buaa.service;

import cn.buaa.mapper.SubjectListMapper;
import cn.buaa.model.QuestionBank;
import cn.buaa.model.Subject;
import cn.buaa.model.SubjectList;
import cn.buaa.model.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bob
 */
public interface SubjectService {

//    private SubjectListMapper subjectListMapper;
//
//    @Autowired
//    public void setSubjectListMapper(SubjectListMapper subjectListMapper) {
//        this.subjectListMapper = subjectListMapper;
//    }
//
//    public List<SubjectList> query() {
//        return subjectListMapper.query();
//    }
//
//    public List<SubjectList> queryByTitle(String title) {
//        return subjectListMapper.queryByTitle(title);
//    }
    List<SubjectList> query();

    List<SubjectList> queryByTitle(String title);

    List<SubjectList> queryById(int uid);

    Subject getSubjectDetailBySubjectId(String subjectId);

    Subject save(Subject subject);

    void update(Subject subject);

    void saveQuestionBank(QuestionBank questionBank);

    void updateQuestionBank(QuestionBank questionBank);

    void saveUserAnswer(List<UserAnswer> userAnswerList);

    UserAnswer checkUserAnswer(UserAnswer userAnswer);

    List<UserAnswer> checkUserAnswerById(UserAnswer userAnswer);

    List<UserAnswer> getStatistics(UserAnswer userAnswer);
}
