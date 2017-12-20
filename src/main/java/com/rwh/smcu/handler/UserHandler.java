package com.rwh.smcu.handler;

import com.rwh.smcu.entity.User;
import com.rwh.smcu.proto.URI;
import com.rwh.smcu.service.UserService;
import com.rwh.smcu.thread.ThreadStateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/3
 */
@RestController
public class UserHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(URI.SMCU_USER_ADD)
    public void add(User user){
        logger.info("add:"+user);
        userService.add(user);
    }

    @RequestMapping(URI.SMCU_USER_UPDATE)
    public void update(User user){
        logger.info("update:"+user);
        Assert.isNull(user.getId(), "Assert is null");
        userService.update(user);
    }

    @RequestMapping(URI.SMCU_USER_GET)
    public User get(Long id){
        logger.info("get:"+id);
        Assert.isNull(id, "Assert is null");
        return userService.get(id);
    }

    @RequestMapping(URI.SMCU_USER_QUERY)
    public Page<User> query(@PageableDefault Pageable pageRequest, String username){
        logger.info("query:"+pageRequest + " username:"+username);
        if(StringUtils.isEmpty(username) == true){
            return userService.findAll(pageRequest);
        } else {
            List<User> ls = userService.queryUserByName(username);
            Page<User> page = new PageImpl(ls);
            return page;
        }
    }
}
