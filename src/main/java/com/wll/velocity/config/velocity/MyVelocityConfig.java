package com.wll.velocity.config.velocity;

import com.wll.velocity.config.velocity.org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import com.wll.velocity.config.velocity.org.springframework.web.servlet.view.velocity.VelocityViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

@Configuration
public class MyVelocityConfig extends WebMvcConfigurerAdapter {
    //配置 velocity bean
    @SuppressWarnings("deprecation")
    @Bean
    public VelocityConfigurer velocityConfigurer(ApplicationContext context) {
        VelocityConfigurer config = new VelocityConfigurer();
//        Resource resource = new ClassPathResource("/application.yml");
//        config.setConfigLocation(resource);
        Properties properties = new Properties();
        properties.put("input.encoding", "UTF-8");
        properties.put("output.encoding", "UTF-8");
        config.setVelocityProperties(properties);
        return config;
    }

    //配置 velocity 视图解析器
    @SuppressWarnings("deprecation")
    @Bean
    public VelocityViewResolver velocityResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setCache(false);
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".vm");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setExposeRequestAttributes(true);
        //设置RequestContext在视图页面中的变量名,以便使用${request}获取
        resolver.setRequestContextAttribute("request");
        return resolver;
    }
}
