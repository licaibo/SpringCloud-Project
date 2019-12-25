package com.licaibo.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 配置Redis 托管Spring Session
 * @author licaibo
 * @date 2019-12-19
 * @href http://blog.didispace.com/spring-session-xjf-2/
 **/
@Configuration
@EnableRedisHttpSession(redisNamespace = "licaibo:session",maxInactiveIntervalInSeconds = 120)
public class RedisSessionConfig {




}
