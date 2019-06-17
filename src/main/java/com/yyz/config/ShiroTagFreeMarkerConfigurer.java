package com.yyz.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author 一卓
 * @ClassName: ShiroTagFreeMarkerConfigurer
 * @description: TODO
 * @date 2019/6/17 11:08
 */
@Configuration
public class ShiroTagFreeMarkerConfigurer{

    @Autowired
    freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() {
        try {
            configuration.setSharedVariable("shiro", new ShiroTags());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
