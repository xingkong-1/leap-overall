package priv.leap.dao.background.video;

import priv.leap.entity.background.video.VideoStorageEntity;

import java.util.Map;

public interface VideoStorageDao {

    void insertVideoStorage(Map<String, VideoStorageEntity> videoStorage);

}
