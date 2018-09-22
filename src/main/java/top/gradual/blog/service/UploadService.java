package top.gradual.blog.service;

import org.springframework.web.multipart.MultipartFile;
import top.gradual.blog.domain.dto.QiNiuUploadResultDTO;

/**
 * @Description: 上传服务层接口
 * @Author: gradual
 * @Date: 2018-09-05 10:36
 */
public interface UploadService {
    QiNiuUploadResultDTO uploadImg(MultipartFile file, String tmpPath);
}
