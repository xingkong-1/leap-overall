package priv.leap.service.user.type;

import priv.leap.entity.background.video.PictureEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/17 09:28
 * @Description:
 */
public interface UserVideoTypeService {
    List<PictureEntity> getPictureData(String typeVlaue);
}
