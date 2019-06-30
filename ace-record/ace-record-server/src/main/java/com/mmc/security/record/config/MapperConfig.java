package com.mmc.security.record.config;

import com.mmc.security.record.interceptor.PermissionsInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@MapperScan({"com.mmc.security.admin.mapper"})
public class MapperConfig {

    //注册插件
    @Bean
    public PermissionsInterceptor myPlugin() {
        PermissionsInterceptor myPlugin = new PermissionsInterceptor();
        return myPlugin;
    }
}
