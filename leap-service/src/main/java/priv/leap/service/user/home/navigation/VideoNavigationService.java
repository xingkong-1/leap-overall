package priv.leap.service.user.home.navigation;

import priv.leap.entity.user.VideoNavigationVO;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 20:24
 * @Description:
 */
public interface VideoNavigationService {
    List<VideoNavigationVO> getVideoNavigationVoAll(String pName);
    String getByPath(String pPath);
}
