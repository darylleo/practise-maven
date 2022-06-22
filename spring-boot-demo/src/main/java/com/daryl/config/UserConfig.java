package com.daryl.config;

import com.daryl.entity.UserEntity;
import com.daryl.mycondition.OnClassCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wl
 * @create 2022-01-11
 */
@Configuration
public class UserConfig {

    @Bean
    @Conditional(OnClassCondition.class)
    public UserEntity userEntity(){
        return new UserEntity();
    }
}
