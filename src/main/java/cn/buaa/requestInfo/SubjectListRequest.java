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
public class SubjectListRequest {

    public Integer uid;

    @NotEmpty(message = "page不能为空！")
    @NotNull(message = "page不能为空！")
    public int pageNum;

    @NotEmpty(message = "number不能为空！")
    @NotNull(message = "number不能为空！")
    public int pageSize;

    public String title;
}
