package priv.leap.service.user.video.play;

import priv.leap.entity.background.video.VideoStorageEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 09:30
 * @Description:
 */
public interface VideoPlayService {
    List<VideoStorageEntity> getVideoStorageAll();
}
