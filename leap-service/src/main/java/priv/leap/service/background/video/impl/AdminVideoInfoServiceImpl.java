package priv.leap.service.background.video.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.leap.dao.background.video.AdminVideoInfoDao;
import priv.leap.entity.background.video.VideoinfoEntity;
import priv.leap.service.background.video.adminVideoInfoService;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/26 20:39
 * @Description:
 */
@Service
public class AdminVideoInfoServiceImpl implements adminVideoInfoService {
    @Autowired
    private AdminVideoInfoDao videoInfoDao;
    @Override
    public List<VideoinfoEntity> getByVideoInfo(VideoinfoEntity videoinfoEntity) {
        return videoInfoDao.getByVideoInfo(videoinfoEntity);
    }
}
