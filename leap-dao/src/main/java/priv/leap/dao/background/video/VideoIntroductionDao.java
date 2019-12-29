package priv.leap.dao.background.video;

import priv.leap.entity.background.video.VideoIntroductionEntity;

import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/13 08:55
 * @Description:
 */
public interface VideoIntroductionDao {
    void IntroductionInsert(Map<String, VideoIntroductionEntity> videoIntroduction);
}
