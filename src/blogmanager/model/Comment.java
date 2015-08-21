package blogmanager.model;

import blogmanager.genel.Utilities;
import java.sql.Timestamp;

/**
 *
 * @author Rahman Yazgan
 */
public class Comment {
    private int commentID;
    private int blogID;
    private int userID;
    private String userName;
    private String commentTitle;
    private String commentContent;
    private Timestamp commentDate;
    
    public void prepareWelcomeComment(Blog blog, User user){
        this.blogID = blog.getBlogID();
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.commentTitle = "Hoş Geldiniz";
        this.commentContent = "Merhaba " + userName + " bloğuma hoş geldiniz.";
        this.commentDate = Utilities.createNewTimestamp();
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }
    
}