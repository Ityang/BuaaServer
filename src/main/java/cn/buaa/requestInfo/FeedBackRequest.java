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
public class FeedBackRequest {

    @NotEmpty(message = "userId属性不能为空！")
    @NotNull(message = "userId属性不能为空！")
    public Integer userId;

    @NotEmpty(message = "info属性不能为空！")
    @NotNull(message = "info属性不能为空！")
    public String info;
}
