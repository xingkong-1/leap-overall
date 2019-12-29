package priv.leap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.user.VideoNavigationVO;
import priv.leap.service.user.home.navigation.impl.VideoNavigationServiceImpl;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: kong
 * @Date: 2019/12/6 07:40
 * @Description: 获取图片，视频等前端需要展示的数据，并且传递给前端
 */
@Controller
public class VideoNavigationController {

    private static VideoNavigationServiceImpl service = GetApplicationConfig.getBean("videoNavigationServiceImpl",VideoNavigationServiceImpl.class);
    private static String videoPath = "";       // 视频路径

    /**
     * 从数据库获取图片信息，以流的形式将图片传输给前端
     */
    @ResponseBody
    @RequestMapping(value = "videoNavigation/{img}")
    public void vidoeNavigation1(@PathVariable("img") String imgurl, HttpServletRequest request, HttpServletResponse response) throws IOException {
// 从数据库获取图片路径
        String imgPath = service.getByPath(imgurl);
// 加载图片
        InputStream inputStream =new FileInputStream(imgPath);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) !=-1) {
            outputStream.write(bytes);
        }
// 强制刷新字节流
        outputStream.flush();
// 关闭字节流
        inputStream.close();
        outputStream.close();
    }

    /**
     * @param: [videoName]
     * @return: void
     * 从数据库获取播放视频页面所需的数据，传输给前端
     */
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "videoPlayInfo", produces = "application/json;charset=UTF-8")
    public List<VideoNavigationVO> videoPlayInfo(String pName) {
// 获取视频，图片，存储所需要的所有数据
        List<VideoNavigationVO> videoNavigationVoAll = service.getVideoNavigationVoAll(pName);
// 获取视频路径
        videoPath = videoNavigationVoAll.get(0).getsPath();
        return videoNavigationVoAll;
    }

    /**
     * @param: []
     * @return: java.lang.String
     * 将播放路径传输给MediaController的getVideo方法，将视频传输给前端
     */
    public static String getVideoPath() {
        return videoPath;
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "getSearchVideoInfo", produces = "application/json;charset=UTF-8")
    public String getSearchVideoInfo(String searchValue) {
        System.out.println(searchValue);
        return "OK";
    }


}
