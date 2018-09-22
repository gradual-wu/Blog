package top.gradual.blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import top.gradual.blog.dao.mapper.BlogLinksMapper;
import top.gradual.blog.domain.dto.LinkInputDTO;
import top.gradual.blog.domain.dto.LinksDTO;
import top.gradual.blog.domain.entites.BlogLinks;
import top.gradual.blog.service.BlogLinksService;

/**
 * @Description: 友情链接服务层
 * @Author: gradual
 * @Date: 2018-09-20 上午9:05
 */
@Service
@CacheConfig(cacheNames = "blogLinks")
public class BlogLinksServiceImpl implements BlogLinksService {

    @Autowired
    private BlogLinksMapper blogLinksMapper;

    /**
     * @description: 获取所有友情链接
     *
     * @author: gradual
     * @date: 2018/9/20 上午9:19
     * @param: []
     * @return: java.util.List<top.gradual.blog.domain.dto.LinksDTO>
     */
    @Override
    public List<LinksDTO> getAllLinks() {
        List<BlogLinks> blogLinks = blogLinksMapper.selectAllLinks();
        return blogLinks.stream()
                .map(a -> (new LinksDTO(a.getId(), a.getTitle(), a.getHref())))
                .collect(Collectors.toList());
    }

    /**
     * @description: 删除友情链接
     *
     * @author: gradual
     * @date: 2018/9/20 上午9:19
     * @param: [id]
     * @return: boolean
     */
    @Override
    public boolean deleteLinks(long id) {

        int flag = blogLinksMapper.deleteByPrimaryKey(id);
        if (flag > 0) {
            return true;
        }
        return false;
    }

    /**
     * @description: 更新友情链接
     *
     * @author: gradual
     * @date: 2018/9/20 上午9:19
     * @param: [inputDTO]
     * @return: boolean
     */
    @Override
    public boolean updateLinks(LinkInputDTO inputDTO) {

        BlogLinks links = new BlogLinks();
        links.setTitle(inputDTO.getTitle());
        links.setHref(inputDTO.getHref());
        links.setId(inputDTO.getId());
        int flag = blogLinksMapper.updateByPrimaryKey(links);
        if (flag > 0) {
            return true;
        }
        return false;
    }

    /**
     * @description: 添加友情链接
     *
     * @author: gradual
     * @date: 2018/9/20 上午9:19
     * @param: [inputDTO]
     * @return: top.gradual.blog.domain.dto.LinksDTO
     */
    @Override
    public LinksDTO insertLinks(LinkInputDTO inputDTO) {

        BlogLinks links = new BlogLinks();
        links.setTitle(inputDTO.getTitle());
        links.setHref(inputDTO.getHref());
        links.setGmtCreate(new Date());
        links.setGmtModified(new Date());
        int flag = blogLinksMapper.insertSelective(links);
        if (flag > 0) {
            return new LinksDTO(links.getId(), inputDTO.getTitle(), inputDTO.getHref());
        }
        return null;
    }
}
