package priv.leap.util;

import org.springframework.web.multipart.MultipartFile;
import priv.leap.entity.user.VideoNavigationVO;
import priv.leap.service.background.video.AdminVideoService;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/13 11:15
 * @Description: 保存数据到数据库
 */
public class PreserveData {
    /**
     * @param: [navigationVO, file, picture, pictureFilePath, videoFilePath, service]
     * @return: void
     * @auther: kong
     * @date: 2019/12/13 11:22
     * 将视频信息保存在数据库
     */
    public static void videoData(VideoNavigationVO navigationVO, MultipartFile file, MultipartFile picture,
                                String pictureFilePath, String videoFilePath, AdminVideoService service) throws IOException {

        // 将数据保存在数据库
        Map videoInfoMap = AddDataMap.addVideoMap(file, navigationVO);
        Map videoIntroduction = AddDataMap.addIntroductionMap(navigationVO);
        Map videoStorageEntityMap = AddDataMap.VideoStorageEntityFileMap(videoFilePath, file);
        Map pictureEntityMap = AddDataMap.PictureEntityFileMap(pictureFilePath, picture, navigationVO.getvName());
        service.insertVideo(videoInfoMap, videoStorageEntityMap, pictureEntityMap, videoIntroduction);
    }
}
