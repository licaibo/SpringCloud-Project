package com.licaibo.consumer.servicer.impl;

import com.licaibo.common.dto.UserInfo;
import com.licaibo.consumer.servicer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by licaibo on 2017/9/30
 */
@Service
public class UserServicerImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<UserInfo> selectByName(String name) {
        ResponseEntity<UserInfo> responseEntity = restTemplate.getForEntity("http://provider-server/user/{name}" , UserInfo.class,name);
        return responseEntity;
    }

}
