package priv.leap.dao.background.user;

import priv.leap.entity.background.user.UserMessage;

import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/26 09:41
 * @Description:
 */
public interface UserMessageDao {
    int insertUser(Map<String, UserMessage> userMessage);

    UserMessage getMessage(int uId);

}
