package priv.leap.service.user.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.leap.dao.user.UserVideoTypeDao;
import priv.leap.entity.background.video.PictureEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/17 09:29
 * @Description: 视频类型页面类
 */
@Service
public class UserVideoTypeServiceImpl implements UserVideoTypeService {

    @Autowired
    private UserVideoTypeDao typeDao;

    /**
     * @param: [typeVlaue]
     * @return: java.util.List<priv.leap.entity.background.video.PictureEntity>
     * @auther: kong
     * @date: 2019/12/18 19:59
     * 向控制器传输视频类型页面图片数据
     */
    @Override
    public List<PictureEntity> getPictureData(String typeVlaue) {
        return typeDao.getPictureData(typeVlaue);
    }
}
