package com.mmc.security.admin.biz;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mmc.security.admin.entity.User;
import com.mmc.security.admin.mapper.MenuMapper;
import com.mmc.security.admin.mapper.UserMapper;
import com.mmc.security.admin.vo.UserVO;
import com.mmc.security.auth.client.jwt.UserAuthUtil;
import com.mmc.security.auth.client.vo.UserOrgInfo;
import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.common.constant.UserConstant;
import com.mmc.security.common.msg.TableResultResponse;
import com.mmc.security.common.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-08 16:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper,User> {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAuthUtil userAuthUtil;
    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    @CacheClear(pre="user{1.username}")
    public void updateSelectiveById(User entity) {
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Cache(key="user{1}")
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }

    @Override
    public TableResultResponse selectByQuery(Query query) {
        String userName=null;
        User user=new User();
        if(query.entrySet().size()>0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                userName=entry.getValue().toString();
            }

        }
        int count = mapper.conutByQuery(userName);

        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<UserVO> list = userMapper.listByQuery(userName);
        return new TableResultResponse<UserVO>(Long.valueOf(count), list);
    }

    public UserOrgInfo getUserOrgById(Integer id){
        return userMapper.getUserOrgById(id);
    }


}
