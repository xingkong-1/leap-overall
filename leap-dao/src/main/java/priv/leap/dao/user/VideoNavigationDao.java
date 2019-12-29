package priv.leap.dao.user;

import priv.leap.entity.user.VideoNavigationVO;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 20:10
 * @Description:
 */
public interface VideoNavigationDao {
    List<VideoNavigationVO> getVideoNavigationVoAll(String pName);
    String getByPath(String pPath);
}
