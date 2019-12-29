package priv.leap.service.background.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.leap.dao.background.user.UserMessageDao;
import priv.leap.entity.background.user.UserMessage;
import priv.leap.service.background.user.UserMassageService;

import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/26 10:37
 * @Description:
 */
@Service
public class UserMassageServiceImpl implements UserMassageService {
    @Autowired
    private UserMessageDao messageDao;
    @Override
    public int insertUser(Map<String, UserMessage> userinfo) {
        return messageDao.insertUser(userinfo);
    }

    @Override
    public UserMessage getMessage(int uId) {
        return messageDao.getMessage(uId);
    }
}
