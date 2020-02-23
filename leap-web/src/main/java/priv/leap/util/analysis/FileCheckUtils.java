package priv.leap.util.analysis;


import it.sauronsoftware.jave.*;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

/**
 * @author: lucifer
 * @date: 2019/9/16
 * @description: 视频、图片 上传校验工具类
 */
@SuppressWarnings("all")
public class FileCheckUtils {
    private static Logger logger = LoggerFactory.getLogger(FileCheckUtils.class);

    /*==============================视频=================================*/
    /**
     * 允许上传最大字节数 10兆
     */
    private static final long VIDEO_ALLOW_MAX_SIZE = 10485760;

    /**
     * 允许上传的文件格式
     */
    private static final List<String> VIDEO_ALLOW_TYPES = Arrays.asList("mp4", "avi");

    /**
     * 允许上传的视频分辨率
     */
    private static final List<String> VIDEO_ALLOW_RESOLUTION = Arrays.asList("1280x720", "1366x768");

    /*==============================图片=================================*/
    /**
     * 允许上传最大字节数 10兆
     */
    private static final long IMAGE_ALLOW_MAX_SIZE = 10485760;

    /**
     * 允许上传的文件格式
     */
    private static final List<String> IMAGE_ALLOW_TYPES = Arrays.asList("jpg");


    /**
     * 判断视频是否满足上传要求
     *
     * @param multipartFile
     * @return
     * @throws EncoderException
     */
    public static Map<String, Object> isAllowMultimedia(MultipartFile multipartFile) throws Exception {
        File file = null;
        InputStream inputStream = null;
        Map<String, Object> map = new HashMap<>(16);

        try {

            //检查视频格式、大小是否允许上传
            Map<String, Object> contentTypeAndSizeMap = checkContentTypeAndSize(multipartFile);
            Object suffix = contentTypeAndSizeMap.get("suffix");
            Encoder encoder = new Encoder();
            MultimediaInfo encoderInfo = null;
            file = new File(multipartFile.getOriginalFilename());
            inputStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream, file);
            encoderInfo = encoder.getInfo(file);

            //视频播放时长
            long duration = encoderInfo.getDuration();
            logger.debug("视频播放时长:{}秒", duration / 1000);

            //多媒体文件格式名称
            String encoderInfoFormat = encoderInfo.getFormat();
            logger.debug("多媒体文件格式名称:{}", encoderInfoFormat);

            //音频 返回一组特定于音频的信息。如果为空，则多媒体文件中没有音频*流。
            AudioInfo audio = encoderInfo.getAudio();
            if (audio != null) {
                //音频流解码器名称
                String audioDecoder = audio.getDecoder();
                logger.debug("音频流解码器名称:{}", audioDecoder);
            }

            //视频
            VideoInfo videoInfo = encoderInfo.getVideo();
            if (videoInfo == null) {
                throw new RuntimeException("多媒体文件中没有视频流");
            }

            //视频流解码器名称
            String videoInfoDecoder = videoInfo.getDecoder();
            logger.debug("视频流解码器名称:{}", videoInfoDecoder);

            //返回视频大小。如果为空，则此信息不可用
            VideoSize videoInfoSize = videoInfo.getSize();
            if (videoInfoSize == null) {
                throw new RuntimeException("视频分辨率获取失败");
            }

            //视频高度
            int height = videoInfoSize.getHeight();
            //视频宽度
            int width = videoInfoSize.getWidth();
            //检查分辨率

            Map<String, Object> resolutionMap = checkVideoResolution(width, height);
            map.put("videoResolution", resolutionMap.get("videoResolution"));
            map.put("duration", duration / 1000);           // 视频播放时长
            map.put("videoInfoDecoder", videoInfoDecoder);     //视频流解码器名称
            map.put("fileSize", convertFileSize(multipartFile.getSize()));   // 视频大小
            map.put("suffix", suffix);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            /*
             //删除临时文件 利用nio删除，可以获取删除失败异常 用io包则不行
            if (file != null) {
                Path filePath = Paths.get(f.getPath());
                boolean deleteIfExists = Files.deleteIfExists(filePath);
                logger.debug("临时文件是否删除成功:{}", deleteIfExists);
            }
            */
        }
        return map;
    }


    /**
     * 判断图片是否允许上传
     *
     * @param multipartFile
     * @return
     */
    public static Boolean isAllowImage(MultipartFile multipartFile) throws IOException {
        //判断是否为图片 true 是
        boolean isImage = isImageIo(multipartFile);
        if (!isImage) {
            throw new RuntimeException("上传文件不是图片");
        }
        //检查图片、大小是否允许上传
        Map<String, Object> map = checkContentTypeAndSize(multipartFile);
        logger.info("suffix", map.get("suffix"));
        return true;
    }


    /**
     * 判断文件是否是图片
     */
    private static boolean isImageIo(MultipartFile multipartFile) throws IOException {
        BufferedImage read;
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
            read = ImageIO.read(inputStream);
            if (read == null) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        } finally {
            inputStream.close();
        }
        return true;
    }


    /**
     * 检查文件格式是否允许上传(视频、图片)
     *
     * @return
     */
    private static Map<String, Object> checkContentTypeAndSize(MultipartFile multipartFile) throws IOException {
        Map<String, Object> map = new HashMap<>(16);
        boolean isContentTypeAndSize = true;
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        long fileSize = multipartFile.getSize();
        if (isImageIo(multipartFile)) {
            boolean contains = IMAGE_ALLOW_TYPES.contains(suffix);
            if (!contains) {
                isContentTypeAndSize = false;
            }
            boolean a = checkFileSize(fileSize, IMAGE_ALLOW_MAX_SIZE);
            if (!a) {
                throw new RuntimeException("文件最大允许上传:" + convertFileSize(IMAGE_ALLOW_MAX_SIZE));
            }
        } else {
            boolean c = VIDEO_ALLOW_TYPES.contains(suffix);
            if (!c) {
                isContentTypeAndSize = false;
            }
            boolean b = checkFileSize(fileSize, VIDEO_ALLOW_MAX_SIZE);
            if (!b) {
                throw new RuntimeException("文件最大允许上传:" + convertFileSize(VIDEO_ALLOW_MAX_SIZE));
            }
        }
        if (!isContentTypeAndSize) {
            throw new RuntimeException("文件格式不支持，支持类型" + IMAGE_ALLOW_TYPES.toString());
        }
        map.put("suffix", suffix);
        return map;
    }

    /**
     * 检查视频文件大小是否允许上传
     *
     * @param fileSize
     * @param maxSize
     * @return
     */
    private static boolean checkFileSize(Long fileSize, Long maxSize) {
        logger.debug("文件字节数:{}", fileSize);
        if (fileSize > maxSize) {
            return false;
        }
        return true;
    }


    /**
     * 检查视频分辨率是否符合上传要求
     *
     * @param width
     * @param height
     * @return
     */
    private static Map<String, Object> checkVideoResolution(int width, int height) {
        Map<String, Object> map = new HashMap<>(16);
        logger.debug("视频分辨率=======宽度:{},高度:{}", width, height);

        StringBuffer stringBuffer = new StringBuffer();
        String videoResolution = stringBuffer.append(width).append("x").append(height).toString();
        System.out.println("videoResolution = " + videoResolution);
        if (!VIDEO_ALLOW_RESOLUTION.contains(videoResolution)) {
            throw new RuntimeException("分辨率目前只允许：" + VIDEO_ALLOW_RESOLUTION);
        }
        map.put("videoResolution", videoResolution);
        return map;
    }


    /**
     * 将字节大小转换为KB/MB/GB/B
     *
     * @param size
     * @return
     */
    private static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else {
            return String.format("%d B", size);
        }
    }
}
