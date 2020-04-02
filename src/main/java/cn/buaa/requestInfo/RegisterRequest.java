package cn.buaa.requestInfo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Bob
 */
@Data
@ToString
public class RegisterRequest {

    @NotEmpty(message = "loginName属性不能为空！")
    @NotNull(message = "loginName属性不能为空！")
    public String loginName;

    @NotEmpty(message = "loginPass属性不能为空！")
    @NotNull(message = "loginPass属性不能为空！")
    public String loginPass;

    @NotEmpty(message = "imei属性不能为空！")
    @NotNull(message = "imei属性不能为空！")
    public String imei;

    public String phoneCode;

}
