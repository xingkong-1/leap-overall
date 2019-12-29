package priv.leap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import priv.leap.interceptors.MyInterceptors;

@Configuration      // 顶级配置类
@ComponentScan({"priv.leap.controller.background","priv.leap.controller.user"})
@EnableWebMvc       // 相当于 mvc:annotation-driven
public class MvcConfig implements WebMvcConfigurer {

//    配置视图解析器
    @Bean
    public InternalResourceViewResolver resourceViewREsolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptors myInterceptors = new MyInterceptors();
        InterceptorRegistration registration = registry.addInterceptor(myInterceptors);
        registration.addPathPatterns("/**");
    }

//    配置ajax 有错误
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new AllEncompassingFormHttpMessageConverter());
//    }

    //    配置文件上传
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(-1);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration registration = registry.addResourceHandler("/resources/leap/**");
        registration.addResourceLocations("classpath:/resources/leap/");

    }
}
