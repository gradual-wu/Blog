package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 七牛云上传返回对象
 * @Author: gradual
 * @Date: 2018-09-05 10:19
 */
public class QiNiuUploadResultDTO implements Serializable {
    private String hash;
    private String key;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "QiNiuUploadResult{" +
                "hash='" + hash + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
