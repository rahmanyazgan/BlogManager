package blogmanager.model;

/**
 *
 * @author Rahman Yazgan
 */
public class BlogDetail extends Blog {
    private User user;
    private int articleCount;
    private int commentCount;

    public BlogDetail(Blog blog) {
        super(blog);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
