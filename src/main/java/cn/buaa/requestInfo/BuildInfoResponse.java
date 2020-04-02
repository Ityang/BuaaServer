package cn.buaa.requestInfo;

import cn.buaa.common.PageResult;
import cn.buaa.model.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bob
 * <p>
 * 返回数据格式
 */
public class BuildInfoResponse {

    /**
     * 构建用户登录成功返回信息
     */
    public static Map<String, Object> buildLoginUserInfo(UserInfo user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getId());
        map.put("loginName", user.getUsername());
        map.put("phone", user.getTell());
        map.put("user_type", user.getRole());
        return map;
    }

    public static PageResult packagePage(PageInfo pageInfo) {
        PageResult page = new PageResult();
        page.setCurrentPage(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotalSize(pageInfo.getTotal());
        page.setResult(pageInfo.getList());
        page.setTotalPages(pageInfo.getPages());
        page.setSize(pageInfo.getList().size());
        return page;
    }

}
