package priv.leap.service.user.video.play.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.leap.dao.user.VideoPlayDao;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.service.user.video.play.VideoPlayService;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 09:33
 * @Description: 获取视频存储的所有信息
 */
@Service
public class VideoPlayServiceImpl implements VideoPlayService {
    @Autowired
    private VideoPlayDao playDao;
    @Override
    public List<VideoStorageEntity> getVideoStorageAll() {
        return playDao.getVideoStorageAll();
    }
}
