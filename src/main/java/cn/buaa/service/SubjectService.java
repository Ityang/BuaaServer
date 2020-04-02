package cn.buaa.service;

import cn.buaa.mapper.SubjectListMapper;
import cn.buaa.model.SubjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bob
 */
@Service
public class SubjectService {

    private SubjectListMapper subjectListMapper;

    @Autowired
    public void setSubjectListMapper(SubjectListMapper subjectListMapper) {
        this.subjectListMapper = subjectListMapper;
    }

    public List<SubjectList> query() {
        return subjectListMapper.query();
    }

    public List<SubjectList> queryByTitle(String title) {
        return subjectListMapper.queryByTitle(title);
    }
}
