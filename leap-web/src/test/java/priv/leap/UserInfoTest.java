package priv.leap;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.background.user.UserinfoEntity;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.service.background.user.impl.UserInfoServiceImpl;
import priv.leap.service.background.video.AdminVideoService;
import priv.leap.service.config.AppConfig;
import priv.leap.service.user.home.navigation.impl.VideoNavigationServiceImpl;
import priv.leap.service.user.video.play.impl.VideoPlayServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserInfoTest {

    @Test
    public void userInfoTest1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContest.xml");
        UserInfoServiceImpl userInfoServiceImpl = context.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);

        for (UserinfoEntity userinfo : userInfoServiceImpl.getAll()) {
            System.out.println(userinfo.toString());
        }
    }

    @Test
    public void userInfoTest2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContest.xml");
        UserInfoServiceImpl userInfoServiceImpl = context.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "县治");
        map.put("age", 10);
        userInfoServiceImpl.insertUser(map);

        System.out.println("-=====================================================-");
        System.out.println(userInfoServiceImpl.getAll().toString());
    }

    @Test
    public void userInfoTest3() {
//        UserInfoServiceImpl bean = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
//        System.out.println(bean.getAll());
    }

    @Test
    public void userInfoTest4() {
//        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
//        UserinfoEntity userinfo = new UserinfoEntity();
//        userinfo.setuName("老了");
//        userinfo.setuPassword("1234eqwe");
//        userinfo.setuAge(10);
//        userinfo.setuSex(0);
//        userinfo.setuPhone("12345678910");
//        userinfo.setIsMember(0);
//        Map map = new HashMap();
//        map.put("userinfo",userinfo);
//        int i = userInfoServiceImpl.insertUser(map);
//        System.out.println(i);
    }

    @Test
    public void userInfoTest5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContestVideo.xml");
        context.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
    }

    @Test
    public void userInfoTest6() {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        List<UserinfoEntity> all = userInfoServiceImpl.getAll();
        System.out.println(all.size());
    }

    @Test
    public void videoP() {
        AdminVideoService adminVideoService = GetApplicationConfig.getBean("adminVideoServiceImpl", AdminVideoService.class);
        System.out.println(adminVideoService.getAll());
    }

    @Test
    public void video1() {
        VideoPlayServiceImpl service = GetApplicationConfig.getBean("videoPlayServiceImpl", VideoPlayServiceImpl.class);
        List<VideoStorageEntity> videoStorageAll = service.getVideoStorageAll();
    }

    @Test
    public void video2() {
        VideoNavigationServiceImpl service = GetApplicationConfig.getBean("videoNavigationServiceImpl", VideoNavigationServiceImpl.class);
        System.out.println("service.getVideoNavigationVoAll() = " + service.getVideoNavigationVoAll("小猪佩奇"));


    }

    @Test
    public void video3() {
        VideoNavigationServiceImpl service = GetApplicationConfig.getBean("videoNavigationServiceImpl",VideoNavigationServiceImpl.class);
        String str = service.getByPath("小猪佩奇");
        System.out.println(str+"----------------------------->>>>");
    }

    @Test
    public void video4() {
        AdminVideoService service = GetApplicationConfig.getBean("adminVideoServiceImpl", AdminVideoService.class);
        service.getMaxId();
    }
}
