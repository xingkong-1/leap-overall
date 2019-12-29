package priv.leap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Auther: kong
 * @Date: 2019/12/5 10:56
 * @Description: 视频播放工具类，向前端传输需要播放的视频流
 */
@Controller
public class MediaController {

    /**
     * @param: [request, response]
     * @return: java.lang.String
     * @auther: kong
     * @date: 2019/12/11 11:19
     * 向前端传输视频流
     */
    @ResponseBody
    @RequestMapping(value = "getVideo")
    public String getVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = VideoNavigationController.getVideoPath();     // 获取播放路径
        InputStream inputStream =new FileInputStream("E:\\resources\\leap\\video\\玄界之门.mp4");
        System.out.println();
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.close();
        return "OK";
    }
}
