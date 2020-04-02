package cn.buaa.controller;

import cn.buaa.common.Config;
import cn.buaa.common.PageResult;
import cn.buaa.model.SubjectList;
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

import java.util.List;

/**
 * @author Bob
 */
@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    private SubjectService subjectService;

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

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

        if (request.uid == null) {
            return jsonErrorResult(Config.USER_HAS_NO_LOGIN, "用户未登录！");
        }

        PageHelper.startPage(request.pageNum, request.pageSize);
        List<SubjectList> subjectLists ;

        if(StringUtil.isNull(request.title)){
            subjectLists = subjectService.query();
        }else {
            subjectLists = subjectService.queryByTitle(request.title);
        }

        PageInfo<SubjectList> pageInfo = new PageInfo<>(subjectLists);
        PageResult pageResult = BuildInfoResponse.packagePage(pageInfo);

        return jsonSuccessResult(pageResult, "");
    }
}
