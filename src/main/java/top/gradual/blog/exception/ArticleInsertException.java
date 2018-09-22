package top.gradual.blog.exception;

/**
 * @Description: 博文添加异常
 * @Author: gradual
 * @Date: 2018-09-03 19:30
 */
public class ArticleInsertException extends RuntimeException {
    public ArticleInsertException() {
    }

    public ArticleInsertException(String message) {
        super(message);
    }

    public ArticleInsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleInsertException(Throwable cause) {
        super(cause);
    }

    public ArticleInsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
