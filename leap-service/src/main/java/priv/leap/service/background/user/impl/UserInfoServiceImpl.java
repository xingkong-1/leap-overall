package priv.leap.service.background.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.leap.dao.background.user.AdminUserDao;
import priv.leap.entity.background.user.UserinfoEntity;
import priv.leap.service.background.user.UserInfoService;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public List<UserinfoEntity> getAll() {
        return adminUserDao.getAll();
    }

    @Override
    public List<UserinfoEntity> getByName(String uName) {
        return adminUserDao.getByName(uName);
    }

    @Override
    public int insertUser(Map<String, Object> userinfo) {
        return adminUserDao.insertUser(userinfo);
    }

    @Override
    public int deleteUser(int uId) {
        return adminUserDao.deleteUser(uId);
    }

    @Override
    public List<UserinfoEntity> getById(int uId) {
        return adminUserDao.getById(uId);
    }

    @Override
    public int updateUser(Map<String, UserinfoEntity> userinfo) {
        return adminUserDao.updateUser(userinfo);
    }


}
