package cn.buaa.controller;

import cn.buaa.common.Config;
import cn.buaa.model.FeedBack;
import cn.buaa.requestInfo.FeedBackRequest;
import cn.buaa.service.FeedBackService;
import cn.buaa.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户反馈类
 *
 * @author Bob
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class FeedBackController extends BaseController {

    private FeedBackService feedBackService;

    @Autowired
    public void setFeedBackService(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    /**
     * 意见反馈
     *
     * @param request RegisterRequest
     * @return 是否意见反馈成功
     */
    @RequestMapping(value = "/feedback", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public Object register(@RequestBody FeedBackRequest request) {
        if (request == null) {
            return jsonErrorResult(Config.PARAM_ERROR, "参数不能为空！");
        }

        FeedBack feedBack = new FeedBack();
        feedBack.setUserId(request.userId);
        feedBack.setInfo(request.info);
        String time = DateUtil.getCurrentTime(DateUtil.FORMAT_TIME_02);
        feedBack.setCreateTime(DateUtil.parse(time, DateUtil.FORMAT_TIME_02));

        feedBackService.insert(feedBack);

        return jsonSuccessResult(Config.NETWORK_SUCCESS,"意见反馈成功！");
    }
}
