package top.gradual.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @Description: 服务层工具类
 * @Author: gradual
 * @Date: 2018-08-27 13:46
 */
public class Base64Utils {

    /**
     * @description: 字符串转MD5
     *
     * @author: gradual
     * @date: 2018/8/27 13:51
     * @param: [string]
     * @return: java.lang.String
     */
    public static String base64(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] result = messageDigest.digest(string.getBytes());
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(result);
    }
}
