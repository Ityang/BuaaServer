package cn.buaa.mapper;

import cn.buaa.common.MyMapper;
import cn.buaa.model.FeedBack;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FeedBackMapper extends MyMapper<FeedBack> {

    @Select("insert into user_feedback(user_id,info,create_time) values (#{userId},#{info},#{created_at})")
    public List<Map<String, Object>> add(@Param("userId") Integer userId, @Param("info") String info, @Param("created_at") Date created_at);
}