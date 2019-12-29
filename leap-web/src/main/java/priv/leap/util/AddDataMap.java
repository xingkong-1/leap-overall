package priv.leap.util;

import org.springframework.web.multipart.MultipartFile;
import priv.leap.entity.background.video.PictureEntity;
import priv.leap.entity.background.video.VideoIntroductionEntity;
import priv.leap.entity.background.video.VideoStorageEntity;
import priv.leap.entity.background.video.VideoinfoEntity;
import priv.leap.entity.user.VideoNavigationVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/2 11:52
 * @Description: 将数据添加到实体类中
 */
public class AddDataMap {
    /*视频信息添加*/
    public static Map<String, VideoinfoEntity> addVideoMap(MultipartFile file, VideoNavigationVO navigationVO) {
        Map videoInfoMap = new HashMap();
        VideoinfoEntity videoInfo = new VideoinfoEntity();
        // 添加视频信息到VideoinfoEntity类中
        String definition = FileUtil.isDefinition(file);
        videoInfo.setvName(navigationVO.getvName());
        videoInfo.setvType(navigationVO.getvType());
        videoInfo.setvVideoType(navigationVO.getvVideoType());
        videoInfo.setvRegion(navigationVO.getvRegion());
        videoInfo.setvDefinition(definition);
        videoInfo.setvRemark(navigationVO.getvRemark());
        videoInfo.setvDateIssued(navigationVO.getvDateIssued());

        videoInfoMap.put("videoInfo", videoInfo);

        return videoInfoMap;
    }

    /**视频信息添加*/
    public static Map<String, VideoIntroductionEntity> addIntroductionMap(VideoNavigationVO navigationVO) {
        Map videoIntroduction = new HashMap();
        VideoIntroductionEntity videoIntroductionEntity = new VideoIntroductionEntity();
        // 添加视频信息到VideoIntroductionEntity类中
        videoIntroductionEntity.setViAge(navigationVO.getViAge());
        videoIntroductionEntity.setViSex(navigationVO.getViSex());
        videoIntroduction.put("videoIntroduction", videoIntroductionEntity);

        return videoIntroduction;
    }

    /*图片添加*/
    public static Map<String, PictureEntity> PictureEntityFileMap(String path, MultipartFile file, String name) throws IOException {
        String fileSize = String.valueOf(file.getSize());
        String filePath = path + file.getOriginalFilename();
        PictureEntity pictureEntity = new PictureEntity();
        Map<String, PictureEntity> map = new HashMap();
        pictureEntity.setpName(name);
        pictureEntity.setpPath(filePath);
        pictureEntity.setpSize(fileSize);

        map.put("pictureMap", pictureEntity);
        return map;
    }

    /*视频添加*/
    public static Map<String, VideoStorageEntity> VideoStorageEntityFileMap(String path, MultipartFile file) throws IOException {
        String fileSize = String.valueOf(file.getSize());           // 获取视频大小
        String filePath = path + file.getOriginalFilename();        // 获取视频路径

        VideoStorageEntity videoStorageEntity = new VideoStorageEntity();
        videoStorageEntity.setsPath(filePath);
        videoStorageEntity.setsSize(fileSize);

        Map<String, VideoStorageEntity> map = new HashMap();
        map.put("videoStorage", videoStorageEntity);
        return map;
    }

}
