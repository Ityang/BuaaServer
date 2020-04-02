package cn.buaa.common;

/**
 * @author Bob
 */
public class Config {
    /**
     * 接口正常的CODE
     */
    public final static int NETWORK_SUCCESS = 200;
    /**
     * 接口错误的CODE
     */
    public final static int NETWORK_ERROR = 400;

    /**
     * 参数校验失败的CODE
     */
    public final static int PARAM_CHECK_INVALID = 150;

    /**
     * 超时返回的CODE
     */
    public final static int TIMEOUT = 160;
    /**
     * 接口正常的message
     */
    public final static String NETWORK_SUCCESS_MESSAGE = "操作成功！";
    /**
     * 接口错误信息
     */
    public final static String ERROR_MESSAGE = "系统错误，请联系管理员！";

    /**
     * 账户未登录
     */
    public final static int USER_HAS_NO_LOGIN = -99;
    /**
     * 参数不能为空
     */
    public final static int PARAM_NOT_NULL = 30001;
    /**
     * 参数错误
     */
    public final static int PARAM_ERROR = 30002;

    /**
     * 用户已经注册
     */
    public final static int USER_HAS_SAVE = 30003;
    /**
     * 用户尚未注册
     */
    public final static int USER_HAS_NO_SAVE = 30004;
    /**
     * 账户被禁用
     */
    public final static int USER_HAS_NO_STATUS = 30005;

}
