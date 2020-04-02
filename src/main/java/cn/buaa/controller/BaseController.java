package cn.buaa.controller;

import cn.buaa.common.Config;
import cn.buaa.common.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Bob
 */
@Slf4j
@Controller
public class BaseController {

    /**
     * 返回正确结果
     *
     * @param data data
     * @return 返回正确结果
     */
    public JsonResult jsonSuccessResult(Object data,String message) {
        return new JsonResult(Config.NETWORK_SUCCESS,message,data);
    }

    /**
     * 返回正确结果
     *
     * @return 返回正确结果
     */
    public JsonResult jsonSuccessResult(String message) {
        return new JsonResult(Config.NETWORK_SUCCESS,message);
    }

    /**
     * 返回错误结果
     *
     * @return 返回错误结果
     */
    public JsonResult jsonErrorResult(int code,String message) {
        return new JsonResult(code,message);
    }

    /**
     * 返回错误结果
     *
     * @return 返回错误结果
     */
    public JsonResult jsonErrorResult(int code) {
        return new JsonResult(code);
    }

    /**
     * runtimeException 以及其他异常捕获
     * @param e e
     * @param request request
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult exception(Exception e, HttpServletRequest request) {
        System.out.println("异常信息如下:"+e);
//        log.error("异常信息如下：", e);
        return jsonErrorResult(Config.NETWORK_ERROR, Config.ERROR_MESSAGE);
    }
}
