package cn.buaa.mapper;

import cn.buaa.model.UserInfo;
import cn.buaa.common.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Bob
 */
public interface UserInfoMapper extends MyMapper<UserInfo> {

    @Select("insert into users_info(TELL,PASS,IMEI,ROLE,STATUS,CREATED_AT) values (#{username},#{password},#{imei},#{role},#{status},#{created_at})")
    public List<Map<String, Object>> add(@Param("username") String username, @Param("password") String password,
                                         @Param("imei") String imei, @Param("role") int role,
                                         @Param("status") int status, @Param("created_at") Date created_at);

    @Select("SELECT COUNT(*) countNum FROM users_info  WHERE TELL= #{username}")
    public boolean checkUserByName(@Param("username") String username);

    @Select("SELECT *  FROM users_info  WHERE TELL= #{username}")
    public List<Map<String, Object>> queryByName(@Param("username") String username);

    @Select("SELECT *  FROM users_info  WHERE TELL= #{username}")
    public UserInfo queryName(@Param("username") String username);
}