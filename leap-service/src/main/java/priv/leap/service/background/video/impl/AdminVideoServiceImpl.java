package priv.leap.service.background.video.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.leap.dao.background.video.VideoInfoDao;
import priv.leap.dao.background.video.VideoIntroductionDao;
import priv.leap.dao.background.video.VideoPictureDao;
import priv.leap.dao.background.video.VideoStorageDao;
import priv.leap.entity.background.video.PictureEntity;
import priv.leap.entity.background.video.VideoIntroductionEntity;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.entity.background.video.VideoinfoEntity;
import priv.leap.service.background.video.AdminVideoService;

import java.util.List;
import java.util.Map;

@Service
public class AdminVideoServiceImpl implements AdminVideoService {

    @Autowired
    private VideoInfoDao videoInfoDao;
    @Autowired
    private VideoStorageDao videoStorageDao;
    @Autowired
    private VideoPictureDao videoPictureDao;
    @Autowired
    private VideoIntroductionDao videoIntroductionDao;

    @Override
    public Long getMaxId() {
        Long maxId = videoInfoDao.getMaxId();
        return maxId == null ? 1 : maxId+1;
    }

    //    返回视频所有数据信息
    @Override
    public List<VideoinfoEntity> getAll() {
        return videoInfoDao.getAll();
    }

    //    视频查询
    @Override
    public List<VideoinfoEntity> getByName(String vName) {
        return videoInfoDao.getByName(vName);
    }

    //    添加视频
    @Transactional
    @Override
    public void insertVideo(Map<String, VideoinfoEntity> videoInfo,
                            Map<String, VideoStorageEntity> videoStorageEntityMap,
                            Map<String, PictureEntity> picture,
                            Map<String, VideoIntroductionEntity> videoIntroduction) {

        Long maxId = getMaxId();
        videoStorageEntityMap.get("videoStorage").setvId(maxId);
        picture.get("pictureMap").setvId(maxId);
        videoIntroduction.get("videoIntroduction").setvId(maxId);

        videoPictureDao.insertPicture(picture);
        videoStorageDao.insertVideoStorage(videoStorageEntityMap);
        videoIntroductionDao.IntroductionInsert(videoIntroduction);
        videoInfoDao.insertVideo(videoInfo);
    }
}
