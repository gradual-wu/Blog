package top.gradual.blog.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gradual.blog.config.QiNiuProperties;
import top.gradual.blog.domain.dto.QiNiuUploadResultDTO;

/**
 * @Description: 七牛云文件上传工具
 * @Author: gradual
 * @Date: 2018-09-05 8:53
 */
@Component("uploadUtils")
public class QiNiuFileUploadUtils {

    private final QiNiuProperties qiNiuProperties;
    private Auth auth;
    private UploadManager uploadManager;
    private JsonUtil jackJsonUtils;
    private final String URL = "http://resource.gradual.top/";

    @Autowired
    public QiNiuFileUploadUtils(QiNiuProperties qiNiuProperties, JsonUtil jackJsonUtils) {
        this.qiNiuProperties = qiNiuProperties;
        this.jackJsonUtils = jackJsonUtils;
        this.auth = Auth.create(qiNiuProperties.getAk(), qiNiuProperties.getSk());
        this.uploadManager = new UploadManager();
    }

    /**
     * 获取凭证
     * @param bucketName 空间名称
     * @param key 如果需要覆盖上传则设置此参数
     * @return
     */
    private String getUpToken(String bucketName, String key) {
        return auth.uploadToken(bucketName);
    }

    /**
     * 上传方法
     * @param filePath 文件路径  （也可以是字节数组、或者File对象）
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     */
    public QiNiuUploadResultDTO upload(String filePath, String key) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filePath, key, getUpToken(qiNiuProperties.getBucketname(), key));
            // 打印返回的信息
            String result = res.bodyString();
            QiNiuUploadResultDTO uploadResult =  jackJsonUtils.jsonToObject(result, QiNiuUploadResultDTO.class);
            uploadResult.setKey(URL + uploadResult.getKey());
            return uploadResult;
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
