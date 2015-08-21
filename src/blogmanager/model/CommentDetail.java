package blogmanager.model;

/**
 *
 * @author Rahman Yazgan
 */
public class CommentDetail extends Comment {
    private Blog blog;
    private User user;
    
    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
