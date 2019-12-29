package priv.leap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.background.video.PictureEntity;
import priv.leap.service.user.type.UserVideoTypeServiceImpl;

import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/17 09:34
 * @Description: 视频类型页面类 接收前端请求，向前端传输需要展示的数据
 */
@Controller
public class UserVideoTypeController {


    /***
     * @param: [typeValue]
     * @return: java.util.List<priv.leap.entity.background.video.PictureEntity>
     * @auther: kong
     * @date: 2019/12/18 19:49
     * 接收前端所需视频类型的请求，向前端响应数据流，展示图片
     */
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "getPictureData", produces = "application/json;charset=UTF-8")
    public List<PictureEntity> getPictureData(String typeValue) {
        UserVideoTypeServiceImpl userVideoTypeService = GetApplicationConfig.getBean("userVideoTypeServiceImpl", UserVideoTypeServiceImpl.class);
        List<PictureEntity> pictureData = userVideoTypeService.getPictureData(typeValue);
        return pictureData;
    }
}
