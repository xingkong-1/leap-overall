package priv.leap.service.user.home.navigation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.leap.dao.user.VideoNavigationDao;
import priv.leap.entity.user.VideoNavigationVO;
import priv.leap.service.user.home.navigation.VideoNavigationService;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 20:25
 * @Description:
 */
@Service
public class VideoNavigationServiceImpl implements VideoNavigationService {
    @Autowired
    private VideoNavigationDao navigationDao;

    @Override
    public List<VideoNavigationVO> getVideoNavigationVoAll(String pName) {
        return navigationDao.getVideoNavigationVoAll(pName);
    }

    /**
     * @param:
     * @return:
     * @auther: kong
     * @date: 2019/12/10 20:34
     * 获取图片路径
     */
    @Override
    public String getByPath(String pPath) {
        StringBuffer stringBuffer = new StringBuffer();
        String path = new String("E:\\\\resources\\\\leap\\\\picture\\\\");
        if (pPath != null){
            path = "E:\\\\resources\\\\leap\\\\picture\\\\";
        }else {
            return null;
        }
        stringBuffer.append(path);
        stringBuffer.append(pPath);
        stringBuffer.append('%');
        path = String.valueOf(stringBuffer);
        return navigationDao.getByPath(path);
    }
}
