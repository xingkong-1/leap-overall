package priv.leap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.service.user.video.play.impl.VideoPlayServiceImpl;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/5 09:38
 * @Description: 向前端传递所有播放需要的数据
 *
 */
@Controller
public class VideoPlayController {

    /**
     * @param: []
     * @return: void
     * @auther: kong
     * @date: 2019/12/18 20:03
     * 向前端传输所有需要，展示的数据，如视频名称，简介等
     */
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "video/play", produces = "application/json;charset=UTF-8")
    public void videoPlay() {
        VideoPlayServiceImpl service = GetApplicationConfig.getBean("videoPlayServiceImpl", VideoPlayServiceImpl.class);
        List<VideoStorageEntity> videoStorageAll = service.getVideoStorageAll();
    }
}
