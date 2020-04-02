package cn.buaa.service;

import cn.buaa.mapper.UserInfoMapper;
import cn.buaa.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Bob
 */
@Service
public class UserInfoService {

    private UserInfoMapper userInfoMapper;

    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public List<Map<String,Object>> register(UserInfo userInfo){
        return  userInfoMapper.add(userInfo.getTell(),userInfo.getPass(),userInfo.getImei(),
                userInfo.getRole(),0,userInfo.getCreatedAt());
    }

    public boolean checkUserByLoginName(String userName){
        return  userInfoMapper.checkUserByName(userName);
    }

    public  List<Map<String,Object>> queryByName(String userName){
        return  userInfoMapper.queryByName(userName);
    }


    public  UserInfo queryName(String userName){
        return  userInfoMapper.queryName(userName);
    }
}
