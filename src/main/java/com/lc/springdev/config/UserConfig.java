package com.lc.springdev.config;

import com.lc.springdev.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * user config
 * @author liangchen
 * @date 2020.09.20
 */

@Configuration
public class UserConfig {
    @Bean
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}
