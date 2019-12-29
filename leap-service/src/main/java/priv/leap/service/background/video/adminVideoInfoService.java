package priv.leap.service.background.video;

import priv.leap.entity.background.video.VideoinfoEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/26 13:18
 * @Description:
 */
public interface adminVideoInfoService {
    List<VideoinfoEntity> getByVideoInfo(VideoinfoEntity videoinfoEntity);
}
