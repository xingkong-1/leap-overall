package priv.leap.service.background.video;

import priv.leap.entity.background.video.PictureEntity;
import priv.leap.entity.background.video.VideoIntroductionEntity;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.entity.background.video.VideoinfoEntity;

import java.util.List;
import java.util.Map;

public interface AdminVideoService {
    Long getMaxId();
    List<VideoinfoEntity> getAll();
    List<VideoinfoEntity> getByName(String vName);
    void insertVideo(Map<String, VideoinfoEntity> videoInfo,
                     Map<String, VideoStorageEntity> videoStorageEntityMap,
                     Map<String, PictureEntity> pictureEntityMap,
                     Map<String, VideoIntroductionEntity> videoIntroductionMap);
}
