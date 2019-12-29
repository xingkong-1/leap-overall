package priv.leap.dao.background.user;

import priv.leap.entity.background.user.UserinfoEntity;

import java.util.List;
import java.util.Map;

public interface AdminUserDao {
    List<UserinfoEntity> getAll();
    List<UserinfoEntity> getByName(String uName);
    int insertUser(Map<String, Object> userinfo);
    int deleteUser(int uId);
    List<UserinfoEntity> getById(int uId);
    int updateUser(Map<String, UserinfoEntity> userinfo);
}
