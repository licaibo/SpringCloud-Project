package com.licaibo.consumer.servicer;

import com.licaibo.common.dto.UserInfo;
import org.springframework.http.ResponseEntity;

/**
 * @author licaibo
 * @date 2020-04-05
 **/
public interface UserService {

    ResponseEntity<UserInfo> selectByName(String name);

}
