package priv.leap.util;

import org.springframework.web.multipart.MultipartFile;
import priv.leap.util.analysis.FileParseUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @Auther: kong
 * @Date: 2019/12/2 11:28
 * @Description: 操作视频信息
 */
public class FileUtil {
    /*
     * 添加视频和图片到服务器
     * */
    public static void outFileWhile(String filePath,MultipartFile file) throws IOException {
        String[] fileName = file.getOriginalFilename().split("\\.");

        InputStream input = file.getInputStream();
        OutputStream out = new FileOutputStream(filePath + file.getOriginalFilename());
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = input.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        input.close();
        out.close();
    }

    /*
     * 判断视频清晰度
     * */
    public static String isDefinition(MultipartFile file) {
        Map encodingFormat = FileParseUtil.getEncodingFormat("E:\\resources\\leap\\video\\" + file.getOriginalFilename());
        // 获取视频码率
        String rate = encodingFormat.get("bitrate 码率 单位 kb") + "";
        Integer definition = Integer.valueOf(rate) * 2;

        if (definition < 890) {
            return "标清";
        } else if (definition > 890 && definition < 1800) {
            return "高清";
        } else if (definition > 1800 && definition < 3700) {
            return "超清";
        } else {
            return "蓝光";
        }
    }
}
