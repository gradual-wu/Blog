package top.gradual.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 七牛云上传配置类
 * @Author: gradual
 * @Date: 2018-09-05 9:04
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuProperties {

    private String ak;
    private String sk;
    private String bucketname;

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }

    @Override
    public String toString() {
        return "QiNiuProperties{" +
                "ACCESS_KEY='" + ak + '\'' +
                ", SECRET_KEY='" + sk + '\'' +
                ", bucketname='" + bucketname + '\'' +
                '}';
    }
}
