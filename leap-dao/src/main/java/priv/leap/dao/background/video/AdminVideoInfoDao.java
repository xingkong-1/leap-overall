package priv.leap.dao.background.video;

import priv.leap.entity.background.video.VideoinfoEntity;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/26 21:54
 * @Description:
 */
public interface AdminVideoInfoDao {
    List<VideoinfoEntity> getByVideoInfo(VideoinfoEntity videoinfoEntity);
}
