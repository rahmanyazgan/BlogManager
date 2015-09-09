package blogmanager.database;

import blogmanager.model.Blog;
import blogmanager.model.BlogDetail;
import blogmanager.model.Comment;
import blogmanager.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahman Yazgan
 */
public class DatabaseOperations {

    private Connection dbConnection;
    private String databaseURL = null;
    private String query;
    private String password;
    private String userName;
    private String[] tables = {"blog", "comments", "users"};
    private int result;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public DatabaseOperations() {
        this.databaseURL = "jdbc:mysql://localhost:3306/blog";
        this.userName = "root";
        this.password = "";
    }

    public DatabaseOperations(String userName, String password, String tableName, String url) {
        this.databaseURL = url;
        this.userName = userName;
        this.password = password;
    }

    public void getDBConnection() throws Exception {
        if (dbConnection != null) {
            if (!dbConnection.isClosed()) {
                return;
            }
        }

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        dbConnection = DriverManager.getConnection(this.databaseURL, this.userName, this.password);
    }

    public void dbConnectionClose() throws Exception {
        if (dbConnection != null) {
            if (!dbConnection.isClosed()) {
                dbConnection.close();
            }
        }
    }

    public void deleteAllTables() throws SQLException {
        for (String table : tables) {
            deleteTable(table);
        }
    }

    private Statement createStatement() throws SQLException {
        statement = null;
        statement = dbConnection.createStatement();
        return statement;
    }

    private PreparedStatement createPreparedStatement(String query) throws SQLException {
        preparedStatement = null;
        preparedStatement = dbConnection.prepareStatement(query);
        return preparedStatement;
    }

    public void deleteTable(String tableName) throws SQLException {
        query = "DELETE FROM " + tableName;
        statement = createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public boolean createUser(User user) throws SQLException {
        query = "INSERT INTO users (Email, Password, UserName, "
                + "AccessPermission, RecordDate) VALUES (?,?,?,?,?)";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getAccessPermission());
        preparedStatement.setTimestamp(5, user.getRecordDate());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result > 0;
    }

    public void addUsersFromList(List<User> userList) throws SQLException {
        query = "INSERT INTO users (Email, Password, UserName, "
                + "AccessPermission, RecordDate) VALUES (?,?,?,?,?)";
        try {
            dbConnection.setAutoCommit(false);
            preparedStatement = createPreparedStatement(query);
            for (User user : userList) {
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getUserName());
                preparedStatement.setString(4, user.getAccessPermission());
                preparedStatement.setTimestamp(5, user.getRecordDate());
                preparedStatement.executeUpdate();
            }
            dbConnection.commit();
            dbConnection.setAutoCommit(true);
            preparedStatement.close();
        } catch (SQLException exception) {
            dbConnection.rollback();
            throw exception;
        }
    }

    public boolean createBlog(Blog blog) throws SQLException {
        query = "INSERT INTO blog (UserID, BlogTitle, Description, "
                + "CreateDate) VALUES (?,?,?,?)";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, blog.getUserID());
        preparedStatement.setString(2, blog.getBlogTitle());
        preparedStatement.setString(3, blog.getDescription());
        preparedStatement.setTimestamp(4, blog.getCreateDate());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result > 0;
    }

    public boolean createComment(Comment comment) throws SQLException {
        query = "INSERT INTO comments (BlogID, UserID, UserName, "
                + "CommentTitle, CommentContent, CommentDate) VALUES (?,?,?,?,?,?)";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, comment.getBlogID());
        preparedStatement.setInt(2, comment.getUserID());
        preparedStatement.setString(3, comment.getUserName());
        preparedStatement.setString(4, comment.getCommentTitle());
        preparedStatement.setString(5, comment.getCommentContent());
        preparedStatement.setTimestamp(6, comment.getCommentDate());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result > 0;
    }

    public boolean isRegisteredEmail(String email) throws SQLException {
        query = "SELECT Email FROM users WHERE Email = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, email);
        boolean result = preparedStatement.execute();
        preparedStatement.close();
        return result;
    }

    public int findUserID(String email) throws SQLException {
        query = "SELECT UserID FROM users WHERE Email = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();

        result = 0;
        if (resultSet.next()) {
            result = resultSet.getInt("UserID");
        }
        preparedStatement.close();
        resultSet.close();

        return result;
    }

    public int findBlogID(Timestamp createDate) throws SQLException {
        query = "SELECT BlogID FROM blog WHERE CreateDate = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setTimestamp(1, createDate);
        resultSet = preparedStatement.executeQuery();

        result = 0;
        if (resultSet.next()) {
            result = resultSet.getInt("BlogID");
        }
        preparedStatement.close();
        resultSet.close();

        return result;
    }

    public User getUserInfo(String email, String password) throws SQLException {
        query = "SELECT * FROM users WHERE Email = ? and Password = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();
        
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setUserID(resultSet.getInt("UserID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setUserName(resultSet.getString("UserName"));
            user.setAccessPermission(resultSet.getString("AccessPermission"));
            user.setRecordDate(resultSet.getTimestamp("RecordDate"));
        }
        preparedStatement.close();
        resultSet.close();
        return user;
    }

    public User getUserInfo(String email) throws SQLException {
        query = "SELECT * FROM users WHERE Email = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setUserID(resultSet.getInt("UserID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setUserName(resultSet.getString("UserName"));
            user.setAccessPermission(resultSet.getString("AccessPermission"));
            user.setRecordDate(resultSet.getTimestamp("RecordDate"));
        }
        preparedStatement.close();
        resultSet.close();
        return user;
    }

    public User getUserInfo(int userID) throws SQLException {
        query = "SELECT * FROM users WHERE UserID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, userID);
        resultSet = preparedStatement.executeQuery();
        
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setUserID(resultSet.getInt("UserID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setUserName(resultSet.getString("UserName"));
            user.setAccessPermission(resultSet.getString("AccessPermission"));
            user.setRecordDate(resultSet.getTimestamp("RecordDate"));
        }
        preparedStatement.close();
        resultSet.close();
        return user;
    }

    public List<User> getAllUsers() throws SQLException {
        query = "SELECT * FROM users";
        preparedStatement = createPreparedStatement(query);
        resultSet = preparedStatement.executeQuery();
        
        List<User> userList = null;
        if (resultSet.next()) {
            userList = new ArrayList<User>();
        }
        
        resultSet.beforeFirst();
        while (resultSet.next()) {
            User user = new User();
            user.setUserID(resultSet.getInt("UserID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setUserName(resultSet.getString("UserName"));
            user.setAccessPermission(resultSet.getString("AccessPermission"));
            user.setRecordDate(resultSet.getTimestamp("RecordDate"));
            userList.add(user);
        }
        preparedStatement.close();
        resultSet.close();
        return userList;
    }

    public Blog getBlogInfo(int blogID) throws SQLException {
        query = "SELECT * FROM blog WHERE BlogID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, blogID);
        resultSet = preparedStatement.executeQuery();
        
        Blog blog = null;
        if (resultSet.next()) {
            blog = new Blog();
            blog.setBlogID(resultSet.getInt("BlogID"));
            blog.setUserID(resultSet.getInt("UserID"));
            blog.setBlogTitle(resultSet.getString("BlogTitle"));
            blog.setDescription(resultSet.getString("Description"));
            blog.setCreateDate(resultSet.getTimestamp("CreateDate"));
        }
        preparedStatement.close();
        resultSet.close();
        return blog;

    }

    public int[] getBlogStat(int blogID) throws SQLException {
        int[] res = new int[2];
        query = "SELECT Count(*) FROM blog WHERE BlogID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, blogID);
        resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            res[0] = resultSet.getInt(1);
        }

        query = "SELECT Count(*) FROM comments c WHERE c.BlogID in "
                + "(Select a.BlogID FROM blog a WHERE a.BlogID = ? )";

        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, blogID);
        resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            res[1] = resultSet.getInt(1);
        }
        preparedStatement.close();
        resultSet.close();
        return res;
    }

    public List<Blog> getAllBlogs() throws SQLException {
        query = "SELECT * FROM blog";
        preparedStatement = createPreparedStatement(query);
        resultSet = preparedStatement.executeQuery();
        
        List<Blog> blogList = null;
        if (resultSet.next()) {
            blogList = new ArrayList<Blog>();
        }
        
        resultSet.beforeFirst();
        while (resultSet.next()) {
            Blog blog = new Blog();
            blog.setBlogID(resultSet.getInt("BlogID"));
            blog.setUserID(resultSet.getInt("UserID"));
            blog.setBlogTitle(resultSet.getString("BlogTitle"));
            blog.setDescription(resultSet.getString("Description"));
            blog.setCreateDate(resultSet.getTimestamp("CreateDate"));
            blogList.add(blog);
        }
        preparedStatement.close();
        resultSet.close();
        return blogList;
    }
    
    public List<Blog> getAllBlogsBelongToUser(User user) throws SQLException {
        query = "SELECT * FROM blog WHERE UserID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, user.getUserID());
        resultSet = preparedStatement.executeQuery();
        
        List<Blog> blogList = null;
        if (resultSet.next()) {
            blogList = new ArrayList<Blog>();
        }
        resultSet.beforeFirst();
        while (resultSet.next()) {
            Blog blog = new Blog();
            blog.setBlogID(resultSet.getInt("BlogID"));
            blog.setUserID(resultSet.getInt("UserID"));
            blog.setBlogTitle(resultSet.getString("BlogTitle"));
            blog.setDescription(resultSet.getString("Description"));
            blog.setCreateDate(resultSet.getTimestamp("CreateDate"));
            blogList.add(blog);
        }
        preparedStatement.close();
        resultSet.close();
        return blogList;

    }
    
    public List<Comment> getAllComments() throws SQLException {
        query = "SELECT * FROM comments";
        preparedStatement = createPreparedStatement(query);
        resultSet = preparedStatement.executeQuery();
        
        List<Comment> commentList = null;
        if (resultSet.next()) {
            commentList = new ArrayList<Comment>();
        }
        resultSet.beforeFirst();

        while (resultSet.next()) {
            Comment comment = new Comment();
            comment.setCommentID(resultSet.getInt("CommentID"));
            comment.setBlogID(resultSet.getInt("BlogID"));
            comment.setUserID(resultSet.getInt("UserID"));
            comment.setUserName(resultSet.getString("UserName"));
            comment.setCommentTitle(resultSet.getString("CommentTitle"));
            comment.setCommentContent(resultSet.getString("CommentContent"));
            comment.setCommentDate(resultSet.getTimestamp("CommentDate"));
            commentList.add(comment);
        }
        preparedStatement.close();
        resultSet.close();
        return commentList;
    }
    
    public List<Comment> getAllCommentsBelongToBlog(Blog blog)
            throws SQLException {
        query = "SELECT * FROM comments WHERE BlogID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, blog.getBlogID());
        resultSet = preparedStatement.executeQuery();
        
        List<Comment> commentList = null;
        if (resultSet.next()) {
            commentList = new ArrayList<Comment>();
        }
        resultSet.beforeFirst();

        while (resultSet.next()) {
            Comment comment = new Comment();
            comment.setCommentID(resultSet.getInt("CommentID"));
            comment.setBlogID(resultSet.getInt("BlogID"));
            comment.setUserID(resultSet.getInt("UserID"));
            comment.setCommentTitle(resultSet.getString("CommentTitle"));
            comment.setCommentContent(resultSet.getString("CommentContent"));
            comment.setCommentDate(resultSet.getTimestamp("CommentDate"));
            commentList.add(comment);
        }
        preparedStatement.close();
        resultSet.close();
        return commentList;
    }

    public boolean deleteComment(Comment comment) throws SQLException {
        query = "DELETE FROM comments WHERE CommentID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, comment.getCommentID());
        boolean result = (preparedStatement.executeUpdate() > 0);
        preparedStatement.close();
        return result;
    }

    public boolean deleteBlog(Blog blog) throws SQLException {
        query = "DELETE FROM blog WHERE BlogID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, blog.getBlogID());
        boolean result = (preparedStatement.executeUpdate() > 0);
        preparedStatement.close();
        return result;
    }

    public boolean deleteUser(User user) throws SQLException {
        query = "DELETE FROM users WHERE UserID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setInt(1, user.getUserID());
        boolean result = (preparedStatement.executeUpdate() > 0);
        preparedStatement.close();
        return result;
    }

    public BlogDetail getBlogDetail(int blogID) throws SQLException {
        Blog blog = getBlogInfo(blogID);
        BlogDetail blogDetail = new BlogDetail(blog);
        User user = getUserInfo(blog.getUserID());
        blogDetail.setUser(user);

        int[] stat = getBlogStat(blog.getBlogID());
        blogDetail.setArticleCount(stat[0]);
        blogDetail.setCommentCount(stat[1]);
        return blogDetail;
    }

    public boolean updateBlogInfo(Blog blog) throws SQLException {
        query = "UPDATE blog SET BlogTitle = ?, Description = ?, "
                + "UserID = ? WHERE BlogID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, blog.getBlogTitle());
        preparedStatement.setString(2, blog.getDescription());
        preparedStatement.setInt(3, blog.getUserID());
        preparedStatement.setInt(4, blog.getBlogID());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (result > 0);
    }
    
    public boolean updateCommentInfo(Comment comment) throws SQLException {
        query = "UPDATE comments SET CommentTitle = ?, CommentContent = ?, "
                + "UserID = ? WHERE CommentID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, comment.getCommentTitle());
        preparedStatement.setString(2, comment.getCommentContent());
        preparedStatement.setInt(3, comment.getUserID());
        preparedStatement.setInt(4, comment.getCommentID());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (result > 0);
    }

    public boolean updateUserInfo(User user) throws SQLException {
        query = "UPDATE users SET Email = ?, "
                + "Password = ?, UserName = ?, "
                + "AccessPermission = ? WHERE UserID = ?";
        preparedStatement = createPreparedStatement(query);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getAccessPermission());
        preparedStatement.setInt(5, user.getUserID());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (result > 0);
    }
    
    public String[] getTableAllColumnsName(String tableName) throws SQLException {
        query = "SELECT * FROM " + tableName;
        preparedStatement = createPreparedStatement(query);
        ResultSetMetaData metaData = preparedStatement.getMetaData();

        int number = metaData.getColumnCount();
        String[] results = new String[number];
        for (int i = 0; i < number; i++) {
            results[i] = metaData.getColumnName(i + 1);
        }
        return results;
    }
}
