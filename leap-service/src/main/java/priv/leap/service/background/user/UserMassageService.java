package priv.leap.service.background.user;

import priv.leap.entity.background.user.UserMessage;

import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/26 10:36
 * @Description:
 */
public interface UserMassageService {
    int insertUser(Map<String, UserMessage> userinfo);
    UserMessage getMessage(int uId);
}
