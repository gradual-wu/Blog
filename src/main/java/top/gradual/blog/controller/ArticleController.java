package top.gradual.blog.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.gradual.blog.domain.dto.ArticleInputDTO;
import top.gradual.blog.domain.dto.ArticleResultDTO;
import top.gradual.blog.domain.dto.ArticleTypeResultDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;
import top.gradual.blog.domain.dto.PageInputDTO;
import top.gradual.blog.domain.dto.QiNiuUploadResultDTO;
import top.gradual.blog.domain.dto.UserInfoResultDTO;
import top.gradual.blog.domain.vo.ArticleCartVO;
import top.gradual.blog.domain.vo.ArticleVO;
import top.gradual.blog.domain.vo.EditVO;
import top.gradual.blog.domain.vo.IndexVO;
import top.gradual.blog.domain.vo.ListVO;
import top.gradual.blog.service.ArticleDiscussService;
import top.gradual.blog.service.ArticleService;
import top.gradual.blog.service.ArticleTypeService;
import top.gradual.blog.service.UploadService;

/**
 * @Description: 博文类控制器
 * @Author: gradual
 * @Date: 2018-08-27 12:10
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ArticleDiscussService articleDiscussService;


    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    /**
     * @description: 添加博文
     *
     * @author: gradual
     * @date: 2018/9/19 上午10:33
     * @param: [articleInput, session]
     * @return: java.lang.Object
     */
    @ResponseBody
    @PostMapping("/article")
    public Object addArticle(ArticleInputDTO articleInput, HttpSession session) {
        logger.debug("获取登录用户信息");
        UserInfoResultDTO user = (UserInfoResultDTO) session.getAttribute("user");
        Long userId = user.getId();
        logger.debug("用户ID为:" + userId + "--> 添加博客");
        articleInput.setUserId(userId);
        logger.debug("新增博客信息 articleInput :: " + articleInput);
        Map<String, Object> result = new HashMap<>();
        ArticleResultDTO resultDTO = articleService.addArticle(articleInput);
        boolean flag = resultDTO != null;
        result.put("flag", flag);
        if (flag) {
            result.put("message", "博文已成功发布");
            result.put("url", "article-"+resultDTO.getId()+".html");
        } else {
            result.put("message", "博文发布失败");
        }
        return result;
    }

    /**
     * @description: 博文详情页
     *
     * @author: gradual
     * @date: 2018/9/19 上午10:32
     * @param: [id, model]
     * @return: java.lang.String
     */
    @GetMapping("/article-{id}.html")
    public String toArticle(@PathVariable Long id, Model model) {
        logger.debug("获取博文ID为" + id + "的文章信息");
        ArticleResultDTO article = articleService.getArticleById(id);
        logger.debug("获取博文的留言信息");
        List<DiscussResultDTO> discusses = articleDiscussService.getDiscuss(id);
        ArticleVO articleVO = new ArticleVO();
        articleVO.setArticle(article);
        articleVO.setDiscusses(discusses);
        model.addAttribute("articleView", articleVO);
        return "info";
    }

    /**
     * @description: 博文编辑界面
     *
     * @author: gradual
     * @date: 2018/9/19 上午10:32
     * @param: [model]
     * @return: java.lang.String
     */
    @GetMapping("/edit.html")
    public String toEdit(Model model) {
        List<ArticleTypeResultDTO> articleTypeLists = articleTypeService.getArticleTypeAll();
        Map<String, Long> articleTypes = new HashMap<>();
        for (ArticleTypeResultDTO articleTypeResultDTO : articleTypeLists) {
            articleTypes.put(articleTypeResultDTO.getType(), articleTypeResultDTO.getId());
        }
        EditVO editVO = new EditVO();
        editVO.setArticleTypes(articleTypes);
        model.addAttribute("edit", editVO);
        return "edit";

    }

    /**
     * @description: 通过分类筛选博文
     *
     * @author: gradual
     * @date: 2018/9/19 上午10:31
     * @param: [id, input, model]
     * @return: java.lang.String
     */
    @GetMapping("/article/type/{id}")
    public String getArticltListByType(@PathVariable Long id, PageInputDTO input, Model model) {
        PageInfo<ArticleCartVO> pageInfo = articleService.getArticleListByTypeId(id, input.getPageNum());
        ListVO list = new ListVO();
        list.setType(articleTypeService.getArticleTypeById(id));
        list.setPageInfo(pageInfo);
        model.addAttribute("listView", list);
        return "list";
    }

    /**
     * @description: 编辑博文
     *
     * @author: gradual
     * @date: 2018/9/22 下午5:25
     * @param: [id, model]
     * @return: java.lang.String
     */
    @GetMapping("/edit-{id}.html")
    public String toUpdateView(@PathVariable("id") Long id, Model model) {

        logger.debug("跳转到修改博文ID为" + id + "的修改界面");
        ArticleResultDTO article = articleService.getArticleById(id);
        List<ArticleTypeResultDTO> types = article.getTypes();
        List<Long> typeIds = types.stream()
                .map(ArticleTypeResultDTO::getId)
                .collect(Collectors.toList());
        List<ArticleTypeResultDTO> articleTypeLists = articleTypeService.getArticleTypeAll();
        Map<String, Long> articleTypes = articleTypeLists.stream().collect(Collectors.toMap(ArticleTypeResultDTO::getType, ArticleTypeResultDTO::getId));
        EditVO editVO = new EditVO();
        editVO.setTypeIds(typeIds);
        editVO.setArticle(article);
        editVO.setArticleTypes(articleTypes);
        model.addAttribute("edit", editVO);
        return "edit";
    }

    /**
     * @description: 修改博文
     *
     * @author: gradual
     * @date: 2018/9/22 下午5:26
     * @param: [inputDTO]
     * @return: java.lang.Object
     */
    @PutMapping("/article/{id}")
    @ResponseBody
    public Object updateArticle(ArticleInputDTO inputDTO) {
        logger.debug("为博文ID为" + inputDTO.getId() + "的博文更新内容");
        Map<String, Object> result = new HashMap<>();
        ArticleResultDTO article = articleService.updateArticle(inputDTO);
        logger.debug("确认是否成功更新博文内容");
        if (article == null) {
            result.put("message", "更新博文信息失败！");
            result.put("flag", false);
        } else {
            result.put("message", "更新博文信息成功！");
            result.put("flag", true);
        }
        return result;
    }

    /**
     * @description: 删除博文
     *
     * @author: gradual
     * @date: 2018/9/21 下午3:34
     * @param: [id]
     * @return: java.lang.Object
     */
    @DeleteMapping("/article/{id}")
    @ResponseBody
    public Object deleteArticle(@PathVariable("id") Long id, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        logger.debug("删除博文ID为" + id + "的博文");
        boolean flag = articleService.deleteArticle(id);
        result.put("flag", flag);
        if (flag) {
            request.getServletContext().setAttribute("praiseItems", articleService.getArticleByPraise());
            result.put("message", "删除成功，为您跳转到主页");
            result.put("url", "/index.html");
        } else {
            result.put("message", "删除失败");
        }
        return result;
    }

    /**
     * @description: 主页
     *
     * @author: gradual
     * @date: 2018/9/7 16:28
     * @param: [input, model, request]
     * @return: java.lang.String
     */
    @GetMapping({"/index.html", "/"})
    public String toIndex(PageInputDTO input, Model model) {
        logger.debug("访问主页,并传入分页信息" + input);
        logger.debug("获取分页信息");
        PageInfo<ArticleCartVO> carts = articleService.getArticleByUser(1L, input.getPageNum());
        logger.debug("创建主页实体显示类");
        IndexVO indexVO = new IndexVO();
        indexVO.setPageInfo(carts);
        logger.debug("分页列表" + carts.getList());
        model.addAttribute("indexView", indexVO);
        return "index";
    }


    /**
     * @description: 图片上传
     *
     * @author: gradual
     * @date: 2018/9/7 16:28
     * @param: [file, request]
     * @return: java.lang.Object
     */
    @PostMapping("/uploadImg")
    @ResponseBody
    public Object uploadImages(@RequestParam("img") MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/") + "tmp";
        QiNiuUploadResultDTO resultDTO = uploadService.uploadImg(file, path);
        Map<String, Object> result = new HashMap<>();
        if (resultDTO != null) {
            result.put("errno", 0);
            result.put("data", new String[]{resultDTO.getKey()});
        } else {
            result.put("errno", 1);
        }
        return result;
    }

    /**
     * @description: 博文点赞
     *
     * @author: gradual
     * @date: 2018/9/21 下午3:34
     * @param: [articleId, session]
     * @return: java.lang.Object
     */
    @PostMapping("/praise")
    @ResponseBody
    public Object praise(Long articleId, HttpSession session) {
        logger.debug("为博文Id为" + articleId + "的博文点赞");
        Map<String, Object> result = new HashMap<>();
        List<Long> articleIds = (List<Long>) session.getAttribute("praise");
        if (articleIds == null || !articleIds.contains(articleId)) {
            ArticleResultDTO resultDTO = articleService.addPraise(articleId);
            if (resultDTO != null) {
                result.put("message", "点赞成功！");
                result.put("flag", true);
                result.put("praise", resultDTO.getPraise());
                if (articleIds == null) {
                    articleIds = new LinkedList<>();
                }
                articleIds.add(articleId);
                session.setAttribute("praise", articleIds);
                return result;
            }
        }
        logger.debug("已经点过赞无法点赞");
        result.put("message", "你已经点过赞了！");
        result.put("flag", true);
        return result;
    }
}
