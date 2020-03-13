package com.licaibo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by licaibo on 2017/9/30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String id;
    private String username;
    private String password;


}
