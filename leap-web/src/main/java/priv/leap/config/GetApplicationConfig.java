package priv.leap.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.leap.service.config.AppConfig;

/**
 *  容器配置类
 *
 * */
public class GetApplicationConfig {
    public static ApplicationContext applicationContext = null;

    static {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    /* 返回容器对象 */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /* 返回Bean */
    public static <T>T getBean(Class<? extends T> clz) {
        return applicationContext.getBean(clz);
    }

    public static <T>T getBean(String className, Class<? extends T> clz) {
        return applicationContext.getBean(className, clz);
    }

}
