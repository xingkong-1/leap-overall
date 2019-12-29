package priv.leap.dao.user;

import priv.leap.entity.background.video.PictureEntity;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.entity.background.video.VideoinfoEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 08:54
 * @Description:
 */
public interface VideoPlayDao {
    List<VideoinfoEntity> getVideoAll();
    List<VideoStorageEntity> getVideoStorageAll();
    List<PictureEntity> getPictureAll();
}
