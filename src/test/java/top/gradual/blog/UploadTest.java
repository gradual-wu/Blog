package top.gradual.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.gradual.blog.config.QiNiuProperties;
import top.gradual.blog.util.QiNiuFileUploadUtils;

/**
 * @Description: 上传测试类
 * @Author: gradual
 * @Date: 2018-09-05 10:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadTest {

    @Autowired
    @Qualifier("uploadUtils")
    private QiNiuFileUploadUtils uploadUtils;

    @Autowired
    private QiNiuProperties qiNiuProperties;

    @Test
    public void test() {
        System.out.println(qiNiuProperties);
        System.out.println(qiNiuProperties.getAk());
        System.out.println(qiNiuProperties.getSk());
        System.out.println(qiNiuProperties.getBucketname());
    }

    @Test
    public void contextLoads() {
        String filePath = "D:\\1.jpg";
        String name = "blog/image/3.jpg";
        System.out.println(uploadUtils.upload(filePath, name));
    }

}
