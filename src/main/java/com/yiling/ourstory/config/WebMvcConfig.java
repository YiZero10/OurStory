package com.yiling.ourstory.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/webapp/**").addResourceLocations("file:E:/项目学习/ourstory/src/main/resource/webapp/");
        super.addResourceHandlers(registry);
    }
}
