package cn.buaa.mapper;

import cn.buaa.common.MyMapper;
import cn.buaa.model.SubjectList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Bob
 */
public interface SubjectListMapper extends MyMapper<SubjectList> {

    @Select("SELECT * FROM subject WHERE TITLE regexp #{title}")
    public List<SubjectList> queryByTitle(@Param("title") String title);

    @Select("SELECT * FROM subject ")
    public List<SubjectList> query();
}