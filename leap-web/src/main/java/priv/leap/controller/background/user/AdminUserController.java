package priv.leap.controller.background.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.background.user.UserinfoEntity;
import priv.leap.service.background.user.impl.UserInfoServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 */

@ControllerAdvice
@Controller
@CrossOrigin(origins = "http://localhost:8080", methods = {
        RequestMethod.PUT,
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS})
public class AdminUserController {

    /* 转发到管理员主界面 */
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "adminUser")
    public List<UserinfoEntity> userinfo() {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        List<UserinfoEntity> all = userInfoServiceImpl.getAll();
        return all;
    }

    /* 显示用户搜索结果 */
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "adminUser")
    public List<UserinfoEntity> userFuzzy(String userName) {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean(
                "userInfoServiceImpl", UserInfoServiceImpl.class);
        List<UserinfoEntity> byName = userInfoServiceImpl.getByName(userName);
        return byName;
    }


    /* 转发到用户添加界面 */
    @RequestMapping("addUserAdmin")
    public String addUserAdmin() {
        return "addUserAdmin";
    }

    /* 用户添加 */
    @PostMapping("addUserAdmin")
    public String addUserAdmin(UserinfoEntity userinfo, Model model) {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        Map map = new HashMap();
        map.put("userinfo", userinfo);
        int i = userInfoServiceImpl.insertUser(map);
        model.addAttribute("");
        return "adminUser";
    }

    /**
     * 用户删除
     **/
    @PostMapping("deleteUser")
    public String deleteUser(int uId, Model model) {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        int i = userInfoServiceImpl.deleteUser(uId);
        model.addAttribute("uId", i);
        return "adminUser";
    }

    /* 用户修改 */
    @ResponseBody
    @PutMapping(value = "updateUser/{uId}")
    public String updateUser(@PathVariable int uId, @RequestBody UserinfoEntity userinfo) {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        Map<String, UserinfoEntity> map = new HashMap<>();
        map.put("userinfo", userinfo);
        int i = userInfoServiceImpl.updateUser(map);
        return "OK" + i;
    }

    @ResponseBody
    @DeleteMapping(value = "deleteUser/{uId}")
    public String updateUser(@PathVariable Integer uId) {
        UserInfoServiceImpl userInfoServiceImpl = GetApplicationConfig.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        int i = userInfoServiceImpl.deleteUser(uId);
        return "OK"+i;
    }
}
