package priv.leap.controller.background.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.background.user.UserMessage;
import priv.leap.service.background.user.UserMassageService;
import priv.leap.service.background.user.impl.UserMassageServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/26 10:39
 * @Description:
 */
@ControllerAdvice
@Controller
@CrossOrigin(origins = "http://localhost:8080", methods = {
        RequestMethod.PUT,
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS})
public class UserMassageController {
    @ResponseBody
    @PostMapping(value = "insertUserMassage")
    public String insertUserMassage(UserMessage userMessage) {
        UserMassageService userMassageServiceImpl = GetApplicationConfig.getBean("userMassageServiceImpl", UserMassageServiceImpl.class);
        Map map = new HashMap();
        map.put("userMessage", userMessage);
        int i = userMassageServiceImpl.insertUser(map);
        return "OK"+i;
    }
}
