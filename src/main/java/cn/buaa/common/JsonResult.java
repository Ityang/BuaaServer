package cn.buaa.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Bob
 */
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int code) {
        this.code = code;
        this.message = message;
    }
}
