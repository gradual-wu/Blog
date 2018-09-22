package top.gradual.blog.service;

import java.util.List;

import top.gradual.blog.domain.dto.LinkInputDTO;
import top.gradual.blog.domain.dto.LinksDTO;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-09-20 上午9:22
 */
public interface BlogLinksService {
    List<LinksDTO> getAllLinks();

    boolean deleteLinks(long id);

    boolean updateLinks(LinkInputDTO inputDTO);

    LinksDTO insertLinks(LinkInputDTO inputDTO);
}
