package cn.buaa.controller;

import cn.buaa.model.UserInfo;
import cn.buaa.requestInfo.BuildInfoResponse;
import cn.buaa.requestInfo.RegisterRequest;
import cn.buaa.service.UserInfoService;
import cn.buaa.common.Config;
import cn.buaa.util.DateUtil;
import cn.buaa.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户控制类
 *
 * @author Bob
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController {

    private UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 登录
     *
     * @param request RegisterRequest
     * @return 是否登录成功，登录成功后返回用户信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public Object login(@RequestBody RegisterRequest request) {
        if (request == null) {
            return jsonErrorResult(Config.PARAM_ERROR, "参数不能为空！");
        }

        if (StringUtil.isNull(request.loginName)) {
            return jsonErrorResult(Config.PARAM_NOT_NULL, "用户名不能为空！");
        }

        if (StringUtil.isNull(request.loginPass)) {
            return jsonErrorResult(Config.PARAM_NOT_NULL, "密码不能为空！");
        }

        boolean result = userInfoService.checkUserByLoginName(request.loginName);
        if (result) {
            UserInfo userInfo = userInfoService.queryName(request.loginName);

            if (userInfo.getStatus() != 0) {
                return jsonErrorResult(Config.USER_HAS_NO_STATUS, "账户被禁用！");
            }

            if (!userInfo.getPass().equals(request.loginPass)) {
                return jsonErrorResult(Config.PARAM_NOT_NULL, "密码错误！");
            }

            Map<String, Object> userMap = BuildInfoResponse.buildLoginUserInfo(userInfo);

            return jsonSuccessResult(userMap,"登录成功！");
        } else {
            return jsonErrorResult(Config.USER_HAS_NO_SAVE, "用户尚未注册");
        }
    }

    /**
     * 注册
     *
     * @param request RegisterRequest
     * @return 是否注册成功
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public Object register(@RequestBody RegisterRequest request) {
        if (request == null) {
            return jsonErrorResult(Config.PARAM_ERROR, "参数不能为空！");
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setImei(request.imei);
        userInfo.setStatus((short) 0);
        userInfo.setTell(request.loginName);
        userInfo.setPass(request.loginPass);
        userInfo.setRole((short) 0);
        String time = DateUtil.getCurrentTime(DateUtil.FORMAT_TIME_02);
        userInfo.setCreatedAt(DateUtil.parse(time, DateUtil.FORMAT_TIME_02));

        //是否存在此用户，查询数据库中是否存在
        boolean result = userInfoService.checkUserByLoginName(request.loginName);
        if (result) {
            return jsonErrorResult(Config.USER_HAS_SAVE, "此用户名已被注册");
        } else {
            userInfoService.register(userInfo);
            boolean result1 = userInfoService.checkUserByLoginName(request.loginName);
            if (!result1) {
                return jsonErrorResult(Config.USER_HAS_SAVE, "注册失败");
            }

            return jsonSuccessResult(Config.NETWORK_SUCCESS,"注册成功！");
        }
    }
}
