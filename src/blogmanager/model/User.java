package blogmanager.model;

import blogmanager.genel.Utilities;
import java.sql.Timestamp;

/**
 *
 * @author Rahman Yazgan
 */
public class User {

    private int userID;
    private String email;
    private String password;
    private String userName;
    private String accessPermission;
    private Timestamp recordDate;

    private void createNewUser() {
        this.userName = "Yeni Kullanıcı";
        this.email = "deneme@deneme.com";
        this.password = "deneme";
        this.accessPermission = "A";
        this.recordDate = Utilities.createNewTimestamp();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccessPermission() {
        return accessPermission;
    }

    public void setAccessPermission(String accessPermission) {
        this.accessPermission = accessPermission;
    }

    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }
}
