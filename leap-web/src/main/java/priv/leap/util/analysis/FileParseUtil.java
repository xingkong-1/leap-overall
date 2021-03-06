package priv.leap.util.analysis;

import org.apache.commons.lang3.StringUtils;
import org.apache.oro.text.regex.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hy
 * @date 2019/11/7 14:05
 * 提取视频流信息
 */
@SuppressWarnings("all")
public class FileParseUtil {


    public static final Logger LOGGER = LoggerFactory.getLogger(FileParseUtil.class);

    /**
     * 提取音频、视频编码等信息
     *
     * @param filePath
     * @return
     */
    public static Map getEncodingFormat(String filePath) {
        String processFLVResult = processFLV(filePath);
        Map retMap = new HashMap();
        if (StringUtils.isNotBlank(processFLVResult)) {
            PatternCompiler compiler = new Perl5Compiler();
            try {
                String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
                String regexVideo = "Video: (.*?), (.*?), (.*?)[,\\s]";
                String regexAudio = "Audio: (\\w*), (\\d*) Hz";

                Pattern patternDuration = compiler.compile(regexDuration, Perl5Compiler.CASE_INSENSITIVE_MASK);
                PatternMatcher matcherDuration = new Perl5Matcher();
                if (matcherDuration.contains(processFLVResult, patternDuration)) {
                    MatchResult re = matcherDuration.getMatch();
                    retMap.put("提取出播放时间", re.group(1));
                    retMap.put("开始时间", re.group(2));
                    retMap.put("bitrate 码率 单位 kb", re.group(3));
                    System.out.println("提取出播放时间 ===" + re.group(1));
                    System.out.println("开始时间 =====" + re.group(2));
                    System.out.println("bitrate 码率 单位 kb==" + re.group(3));
                }

                Pattern patternVideo = compiler.compile(regexVideo, Perl5Compiler.CASE_INSENSITIVE_MASK);
                PatternMatcher matcherVideo = new Perl5Matcher();

                if (matcherVideo.contains(processFLVResult, patternVideo)) {
                    MatchResult re = matcherVideo.getMatch();
                    retMap.put("编码格式", re.group(1));
                    retMap.put("视频格式", re.group(2));
                    retMap.put("分辨率", re.group(3));
                    System.out.println("编码格式 ===" + re.group(1));
                    System.out.println("视频格式 ===" + re.group(2));
                    System.out.println(" 分辨率 == =" + re.group(3));
                }

                Pattern patternAudio = compiler.compile(regexAudio, Perl5Compiler.CASE_INSENSITIVE_MASK);
                PatternMatcher matcherAudio = new Perl5Matcher();

                if (matcherAudio.contains(processFLVResult, patternAudio)) {
                    MatchResult re = matcherAudio.getMatch();
                    retMap.put("音频编码", re.group(1));
                    retMap.put("音频采样频率", re.group(2));
                    System.out.println("音频编码 ===" + re.group(1));
                    System.out.println("音频采样频率 ===" + re.group(2));
                }
            } catch (MalformedPatternException e) {
                e.printStackTrace();
            }
        }
        return retMap;

    }


    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    private static String processFLV(String inputPath) {
        List commend = new java.util.ArrayList();

        commend.add("E:\\ffmpeg\\FFmpeg\\ffmpeg-4.1.3-win64-static\\bin\\ffmpeg");//可以设置环境变量从而省去这行
        commend.add("ffmpeg");
        commend.add("-i");
        commend.add(inputPath);

        try {

            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.redirectErrorStream(true);
            Process p = builder.start();

//1. start
            BufferedReader buf = null; // 保存ffmpeg的输出结果流
            String line = null;
//read the standard output

            buf = new BufferedReader(new InputStreamReader(p.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
                stringBuffer.append(line);
                continue;
            }
            int ret = p.waitFor(); //这里线程阻塞，将等待外部转换进程运行成功运行结束后，才往下执行
//1. end
            return stringBuffer.toString();
        } catch (Exception e) {
            LOGGER.error("-- processFLV error, message is {}", e);
            return null;
        }
    }
}