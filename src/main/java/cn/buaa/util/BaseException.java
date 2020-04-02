package cn.buaa.util;

/**
 * @author Bob
 */
public class BaseException extends Exception{

    private static final long serialVersionUID = -7648155890866704623L;

    private String resultCode;

    private Throwable cause;
    private String message;

    public BaseException(String message, Throwable cause) {
        super(String.format("%s,系统异常源信息:%s", message, cause.getMessage()), cause);
        this.message = message;
        this.cause = cause;
    }

    public BaseException(String resultCode, String message) {
        super(String.format("错误描述：resultCode:%s, message:%s", resultCode, message));
        this.resultCode = resultCode;
        this.message = message;
    }

    public BaseException(String resultCode, String message, Throwable cause) {
        super(String.format("错误描述：resultCode:%s, message:%s, 系统异常源信息:%s", resultCode, message, cause.getMessage()), cause);
        this.resultCode = resultCode;
        this.message = message;
        this.cause = cause;
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(Throwable cause) {
        super(String.format("系统异常源信息:%s", cause.getMessage()));
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
