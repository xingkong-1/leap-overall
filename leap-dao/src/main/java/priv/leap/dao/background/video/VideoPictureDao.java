package priv.leap.dao.background.video;

import priv.leap.entity.background.video.PictureEntity;

import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/2 19:15
 * @Description:
 */
public interface VideoPictureDao {
    void insertPicture(Map<String, PictureEntity> pictureMap);
}
