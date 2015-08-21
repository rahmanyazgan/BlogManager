package blogmanager.model;

import blogmanager.genel.Utilities;
import java.sql.Timestamp;

/**
 *
 * @author Rahman Yazgan
 */
public class Blog {

    private int blogID;
    private int userID;
    private String blogTitle;
    private String description;
    private Timestamp createDate;

    public Blog() {
    }

    public Blog(Blog blog) {
        this.blogID = blog.blogID;
        this.userID = blog.userID;
        this.blogTitle = blog.blogTitle;
        this.description = blog.description;
        this.createDate = blog.createDate;
    }
    
    public void prepareNewBlogInfo(User user) {
        this.userID = user.getUserID();
        this.blogTitle = "Merhaba. Ben " + user.getUserName()
                + ". Bloğuma hoşgeldiniz.";
        this.description = "Bu otomatik oluşturulmuş bir blogdur."
                + "Blog içeriğini değiştirmek istiyorsanız kullanıcı adı ve şifrenizle"
                + " sisteme giriş yapınız.";
        this.createDate = Utilities.createNewTimestamp();
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

}
