package priv.leap.controller.background.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import priv.leap.config.GetApplicationConfig;
import priv.leap.entity.background.video.VideoinfoEntity;
import priv.leap.entity.user.VideoNavigationVO;
import priv.leap.service.background.video.AdminVideoService;
import priv.leap.service.background.video.impl.AdminVideoInfoServiceImpl;
import priv.leap.util.FileUtil;
import priv.leap.util.PreserveData;
import priv.leap.vo.background.FiltrateVO;

import java.io.IOException;
import java.util.List;

/**
 * 后台视频管理
 */
@Controller
@CrossOrigin(origins = "http://localhost:8080", methods = {
        RequestMethod.PUT,
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS})
public class AdminVideoController {
    private String pictureFilePath = "E:\\resources\\leap\\picture\\";
    private String videoFilePath = "E:\\resources\\leap\\video\\";

    /*
     * 上传视频
     * */
    @ResponseBody
    @PostMapping(value = "insertVideo", produces = "application/json;charset=UTF-8")
    public String insertVideo(VideoNavigationVO navigationVO, MultipartFile file, MultipartFile picture) throws IOException {
        AdminVideoService service = GetApplicationConfig.getBean("adminVideoServiceImpl", AdminVideoService.class);
// 将视频和图片保存到服务器
        FileUtil.outFileWhile(videoFilePath, file);
        FileUtil.outFileWhile(pictureFilePath, picture);

//  将数据保存到数据库
        PreserveData.videoData(navigationVO, file, picture, pictureFilePath, videoFilePath, service);
        return "添加成功";
    }

    /*显示所有的视频数据给后台展示*/
    @ResponseBody
    @GetMapping(value = "videoInfo")
    public List<VideoinfoEntity> getVideoInfo() {
        AdminVideoService service = GetApplicationConfig.getBean("adminVideoServiceImpl", AdminVideoService.class);
        List<VideoinfoEntity> all = service.getAll();
        return all;
    }

    /*根据后台筛选的数据，显示所有搜索出来的视频数据给后台展示*/
    @ResponseBody
    @GetMapping(value = "getByVideoInfo")
    public List<VideoinfoEntity> getByVideoInfo(FiltrateVO filtrateVO) {
        return analysis(filtrateVO);
    }

    /**
     * 解析FiltrateVO对象，将数据赋值个实体类，返回数据库查询出来的所有视频信息
     */
    public List<VideoinfoEntity> analysis(FiltrateVO filtrateVO) {
        AdminVideoInfoServiceImpl service = GetApplicationConfig.getBean("adminVideoInfoServiceImpl", AdminVideoInfoServiceImpl.class);
        VideoinfoEntity videoInfo = new VideoinfoEntity();
        filtrateVO.setDate(filtrateVO.getDate() + "%");
        videoInfo.setvType(filtrateVO.getRank());
        videoInfo.setvVideoType(filtrateVO.getType());
        videoInfo.setvRegion(filtrateVO.getRegion());
        videoInfo.setvDateIssued(filtrateVO.getDate());
        List<VideoinfoEntity> byVideoInfo = service.getByVideoInfo(videoInfo);
        return byVideoInfo;
    }

}
