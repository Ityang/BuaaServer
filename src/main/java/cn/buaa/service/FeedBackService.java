package cn.buaa.service;

import cn.buaa.mapper.FeedBackMapper;
import cn.buaa.mapper.SubjectListMapper;
import cn.buaa.model.FeedBack;
import cn.buaa.model.SubjectList;
import cn.buaa.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bob
 */
@Service
public class FeedBackService {

    private FeedBackMapper feedBackMapper;
    @Autowired
    public void setFeedBackMapper(FeedBackMapper feedBackMapper) {
        this.feedBackMapper = feedBackMapper;
    }

    public List<Map<String,Object>> insert(FeedBack feedBack){
        return  feedBackMapper.add(feedBack.getUserId(),feedBack.getInfo(),feedBack.getCreateTime());
    }
}
