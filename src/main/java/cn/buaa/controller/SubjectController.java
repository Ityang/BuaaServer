package cn.buaa.controller;

import cn.buaa.common.Config;
import cn.buaa.common.JsonResult;
import cn.buaa.common.PageResult;
import cn.buaa.model.QuestionBank;
import cn.buaa.model.Subject;
import cn.buaa.model.SubjectList;
import cn.buaa.model.UserAnswer;
import cn.buaa.requestInfo.BuildInfoResponse;
import cn.buaa.requestInfo.SubjectListRequest;
import cn.buaa.service.SubjectService;
import cn.buaa.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bob
 */
@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询问卷调查列表
     *
     * @return 问卷调查列表
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public Object query(@RequestBody SubjectListRequest request) {
        if (request == null) {
            return jsonErrorResult(Config.PARAM_ERROR, "参数不能为空！");
        }

        PageHelper.startPage(request.pageNum, request.pageSize);
        List<SubjectList> subjectLists;

        if (StringUtil.isNull(request.title)) {
            subjectLists = subjectService.query();
        } else {
            subjectLists = subjectService.queryByTitle(request.title);
        }

        PageInfo<SubjectList> pageInfo = new PageInfo<>(subjectLists);
        PageResult pageResult = BuildInfoResponse.packagePage(pageInfo);

        return jsonSuccessResult(pageResult, "");
    }

    /**
     * 查询问卷调查列表
     *
     * @return 问卷调查列表
     */
    @RequestMapping(value = "/queryById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public Object queryById(@RequestBody SubjectListRequest request) {
        if (request == null) {
            return jsonErrorResult(Config.PARAM_ERROR, "参数不能为空！");
        }

        if (request.uid == null) {
            return jsonErrorResult(Config.PARAM_ERROR, "参数不能为空！");
        }

        PageHelper.startPage(request.pageNum, request.pageSize);
        List<SubjectList> subjectLists;

        subjectLists = subjectService.queryById(request.uid);

        PageInfo<SubjectList> pageInfo = new PageInfo<>(subjectLists);
        PageResult pageResult = BuildInfoResponse.packagePage(pageInfo);

        return jsonSuccessResult(pageResult, "");
    }

    /**
     * 根据问卷ID查询问卷详情
     *
     * @return
     */
    @RequestMapping("/getSubjectDetailBySubjectId")
    public JsonResult getSubjectDetailBySubjectId(@RequestBody Subject subjectParam) {
        Subject subject = subjectService.getSubjectDetailBySubjectId(subjectParam.getId().toString());
        return jsonSuccessResult(subject, "success");
    }

    /**
     * 保存问卷
     *
     * @return
     */
    @RequestMapping("/save")
    public JsonResult save(@RequestBody Subject subject) {
        if (StringUtil.isNotNull(subject.getId())) {
            // todo 这里做修改
            subjectService.update(subject);
        } else {
            // todo 这里做新增
            subjectService.save(subject);
        }
        return jsonSuccessResult(subject, "success");
    }

    /**
     * 保存问卷单个题的题目、选项
     *
     * @return
     */
    @RequestMapping("/saveQuestionBank")
    public JsonResult saveQuestionBank(@RequestBody QuestionBank questionBank) {
        if (StringUtil.isNotNull(questionBank.getId())) {
            // todo 这里做修改
            subjectService.updateQuestionBank(questionBank);
        } else {
            // todo 这里做新增
            subjectService.saveQuestionBank(questionBank);
        }
        return jsonSuccessResult(questionBank, "success");
    }

    /**
     * 保存问卷调查结果
     *
     * @return
     */
    @RequestMapping("/saveUserAnswer")
    public JsonResult saveUserAnswer(@RequestBody List<UserAnswer> userAnswerList) {
        // todo 这里做新增
        subjectService.saveUserAnswer(userAnswerList);
        return jsonSuccessResult(userAnswerList, "success");
    }

    /**
     * 根据用户ID、问卷ID验证用户是否已经填写过此问卷
     * @return code:0、该用户未参与问卷  1、该用户已参与此问卷
     */
    @RequestMapping("/checkUserAnswer")
    public JsonResult checkUserAnswer(@RequestBody UserAnswer userAnswer){
        // todo 这里做新增
        userAnswer = subjectService.checkUserAnswer(userAnswer);
        if(userAnswer==null){
            return jsonSuccessResult(0, "success");
        }
        return jsonSuccessResult(1, "success");
    }
}
