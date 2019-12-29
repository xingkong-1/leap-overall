package priv.leap.dao.background.video;

import priv.leap.entity.background.video.VideoinfoEntity;

import java.util.List;
import java.util.Map;

public interface VideoInfoDao {
    List<VideoinfoEntity> getAll();
    List<VideoinfoEntity> getByName(String vName);
    Long getMaxId();
    void insertVideo(Map<String, VideoinfoEntity> videoInfo);


//    void updateVideo();
//    void deleteVidoe();
}
