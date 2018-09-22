package top.gradual.blog.service;

import java.util.List;

import top.gradual.blog.domain.dto.DiscussInputDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-09-17 下午5:30
 */
public interface ArticleDiscussService {
    DiscussResultDTO addDiscuss(DiscussInputDTO discussInputDTO);

    List<DiscussResultDTO> getDiscuss(Long articleId);

    boolean deleteDiscuss(Long id);
}
