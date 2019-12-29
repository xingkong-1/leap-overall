package priv.leap.dao.user;

import priv.leap.entity.background.video.PictureEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/16 20:47
 * @Description:
 */
public interface UserVideoTypeDao {
    List<PictureEntity> getPictureData(String typeVlaue);
}
