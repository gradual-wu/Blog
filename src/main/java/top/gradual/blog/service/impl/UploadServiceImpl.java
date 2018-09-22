package top.gradual.blog.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.gradual.blog.domain.dto.QiNiuUploadResultDTO;
import top.gradual.blog.service.UploadService;
import top.gradual.blog.util.QiNiuFileUploadUtils;

/**
 * @Description: 上传服务层实现类
 * @Author: gradual
 * @Date: 2018-09-05 10:38
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    @Autowired
    @Qualifier("uploadUtils")
    private QiNiuFileUploadUtils uploadUtils;

    private final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Override
    public QiNiuUploadResultDTO uploadImg(MultipartFile file, String path) {
        QiNiuUploadResultDTO resultDTO = null;
        try {
            String uuid = UUID.randomUUID().toString();
            logger.debug("生成随机UUID图片名" + uuid);
            String qiniuPath = "blog/images/article/";
            logger.debug("上传到七牛云路径是:" + qiniuPath);
            File fileSourcePath = new File(path);
            //获取文件名
            String fileName = file.getOriginalFilename();
            logger.debug("获取到文件真实名称:" + fileName);
            //获取文件扩展名
            String extension = fileName.substring(fileName.lastIndexOf("."));
            logger.debug("获取到文件后缀名:" + extension);
            File fileSource = new File(fileSourcePath, uuid + extension);
            if (!fileSourcePath.exists()) {
                fileSourcePath.mkdirs();
            }
            logger.debug("将文件存到服务器临时文件夹中:" + fileSource.getPath());
            file.transferTo(fileSource);
            logger.debug("将临时图片文件上传到七牛云储存空间中");
            resultDTO = uploadUtils.upload(fileSource.getPath(), qiniuPath + fileSource.getName());
            logger.debug("获取到上传返回对象:" + resultDTO);
            logger.debug("删除临时文件");
            fileSource.delete();
        } catch (IOException e) {
            logger.debug("文件上传失败!");
            //上传失败
            e.printStackTrace();
            return null;
        }
        return resultDTO;
    }
}
