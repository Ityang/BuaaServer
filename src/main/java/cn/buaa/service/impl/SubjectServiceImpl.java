package cn.buaa.service.impl;

import cn.buaa.mapper.SubjectListMapper;
import cn.buaa.model.*;
import cn.buaa.service.SubjectService;
import cn.buaa.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bob
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectListMapper subjectListMapper;

    @Override
    public List<SubjectList> query() {
        return subjectListMapper.query();
    }

    @Override
    public List<SubjectList> queryByTitle(String title) {
        return subjectListMapper.queryByTitle(title);
    }

    @Override
    public List<SubjectList> queryById(int uid) {
        return subjectListMapper.queryById(uid);
    }
    @Override
    public Subject getSubjectDetailBySubjectId(String subjectId) {
        return subjectListMapper.getSubjectDetailBySubjectId(subjectId);
    }

    @Override
    public Subject save(Subject subject) {
        subjectListMapper.insertSubject(subject);
//        subjectListMapper.save(subject);
        return subject;
    }

    @Override
    public void update(Subject subject) {
        subjectListMapper.updateSubject(subject);
//        if(subject.getQuestionBankList().size()>0){
//            for (QuestionBank questionBank : subject.getQuestionBankList()){
//                if(StringUtil.isNotNull(questionBank.getId())){
//                    //修改
//                    subjectListMapper.updateQuestionBank(questionBank);
//                }else{
//                    //新增
//                    subjectListMapper.insertQuestionBank(questionBank);
//                }
//            }
//        }
    }

    @Override
    public void saveQuestionBank(QuestionBank questionBank) {
        subjectListMapper.insertQuestionBank(questionBank);
        if(questionBank.getQuestionAnswerList().size()>0){
            for(QuestionAnswer questionAnswer : questionBank.getQuestionAnswerList()){
                if(StringUtil.isNotNull(questionAnswer.getId())){
                    questionAnswer.setUpdateUser(questionBank.getCreateUser());
                    subjectListMapper.updateQuestionAnswer(questionAnswer);
                }else{
                    questionAnswer.setQuestionId(questionBank.getId());
                    questionAnswer.setCreateUser(questionBank.getCreateUser());
                    subjectListMapper.insertQuestionAnswer(questionAnswer);
                }
            }
        }
    }

    @Override
    public void updateQuestionBank(QuestionBank questionBank) {
        subjectListMapper.updateQuestionBank(questionBank);
    }

    @Override
    public void saveUserAnswer(List<UserAnswer> userAnswerList) {
        for(UserAnswer userAnswer : userAnswerList) {
            subjectListMapper.saveUserAnswer(userAnswer);
        }
    }

    @Override
    public UserAnswer checkUserAnswer(UserAnswer userAnswer) {
        return subjectListMapper.checkUserAnswer(userAnswer);
    }
}
