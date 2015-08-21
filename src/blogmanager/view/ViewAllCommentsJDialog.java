/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogmanager.view;

import blogmanager.database.DatabaseOperations;
import blogmanager.genel.Utilities;
import blogmanager.model.Comment;
import blogmanager.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Rahman Yazgan
 */
public class ViewAllCommentsJDialog extends javax.swing.JDialog {

    private final DefaultTableCellRenderer cellRenderer;
    private final DatabaseOperations databaseOperations;
    private Integer commentID;
    private Integer userID;
    private Integer blogID;
    private String userName;
    private String commentTitle;
    private String commentContent;
    private String tempUser;
    private User selectedUser;
    private List<User> userList;
    private Comment comment;
    private boolean commentCreated;

    /**
     * Creates new form ViewAllCommentsJDialog
     *
     * @param parent
     * @param modal
     */
    public ViewAllCommentsJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(parent);

        cellRenderer = new DefaultTableCellRenderer();
        databaseOperations = new DatabaseOperations();
        getData();
        addUsers();
        setTableColumnNames();
        setCellRenderer();

        for (int i = 0; i <= 2; i += 2) {
            hideColumn(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelActions = new javax.swing.JPanel();
        jButtonClearInformations = new javax.swing.JButton();
        jButtonUpdateComment = new javax.swing.JButton();
        jButtonDeleteComment = new javax.swing.JButton();
        jPanelCommentInformations = new javax.swing.JPanel();
        jComboBoxUserList = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCommentContent = new javax.swing.JTextArea();
        jTextFieldCommentTitle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserComments = new javax.swing.JTable();

        jButtonClearInformations.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonClearInformations.setText("Temizle");
        jButtonClearInformations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearInformationsActionPerformed(evt);
            }
        });

        jButtonUpdateComment.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonUpdateComment.setText("Güncelle");
        jButtonUpdateComment.setEnabled(false);
        jButtonUpdateComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateCommentActionPerformed(evt);
            }
        });

        jButtonDeleteComment.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonDeleteComment.setText("Sil");
        jButtonDeleteComment.setEnabled(false);
        jButtonDeleteComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCommentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActionsLayout = new javax.swing.GroupLayout(jPanelActions);
        jPanelActions.setLayout(jPanelActionsLayout);
        jPanelActionsLayout.setHorizontalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonClearInformations, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUpdateComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteComment, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelActionsLayout.setVerticalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addGroup(jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClearInformations)
                    .addComponent(jButtonUpdateComment)
                    .addComponent(jButtonDeleteComment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCommentInformations.setBorder(javax.swing.BorderFactory.createTitledBorder("Yorum Bilgileri"));

        jComboBoxUserList.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxUserList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUserListİtemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Yorum Sahibi :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Yorum :");

        jTextAreaCommentContent.setColumns(20);
        jTextAreaCommentContent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextAreaCommentContent.setLineWrap(true);
        jTextAreaCommentContent.setRows(5);
        jTextAreaCommentContent.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaCommentContent);

        jTextFieldCommentTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Yorum Başlığı :");

        javax.swing.GroupLayout jPanelCommentInformationsLayout = new javax.swing.GroupLayout(jPanelCommentInformations);
        jPanelCommentInformations.setLayout(jPanelCommentInformationsLayout);
        jPanelCommentInformationsLayout.setHorizontalGroup(
            jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCommentInformationsLayout.createSequentialGroup()
                .addGroup(jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCommentInformationsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxUserList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
            .addGroup(jPanelCommentInformationsLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCommentTitle))
        );
        jPanelCommentInformationsLayout.setVerticalGroup(
            jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCommentInformationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCommentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCommentInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUserList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableUserComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTableUserComments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserCommentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUserComments);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCommentInformations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelCommentInformations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableUserCommentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserCommentsMouseClicked
        Integer selectedRow = jTableUserComments.getSelectedRow();

        if (selectedRow.toString() != null) {
            jButtonUpdateComment.setEnabled(true);
            jButtonDeleteComment.setEnabled(true);
        } else {
            return;
        }

        try {
            commentID = (Integer) jTableUserComments.getValueAt(selectedRow, 0);
            blogID = (Integer) jTableUserComments.getValueAt(selectedRow, 1);
            userID = (Integer) jTableUserComments.getValueAt(selectedRow, 2);
            userName = jTableUserComments.getValueAt(selectedRow, 3).toString();
            commentTitle = jTableUserComments.getValueAt(selectedRow, 4).toString();
            commentContent = jTableUserComments.getValueAt(selectedRow, 5).toString();

            jTextFieldCommentTitle.setText(commentTitle);
            jTextAreaCommentContent.setText(commentContent);

            databaseOperations.getDBConnection();
            selectedUser = databaseOperations.getUserInfo(userID);

            String selectedItem = selectedUser.getUserName() + " <" + selectedUser.getEmail() + ">";
            jComboBoxUserList.setSelectedItem(selectedItem);
        } catch (Exception ex) {
            Logger.getLogger(ViewAllCommentsJDialog.class.getName()).log(Level.SEVERE, null, ex);
            Utilities.showMessageBox("Hata: " + ex.getMessage(), "ERROR");
        }
    }//GEN-LAST:event_jTableUserCommentsMouseClicked

    private void jComboBoxUserListİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUserListİtemStateChanged
        selectActiveUser();
    }//GEN-LAST:event_jComboBoxUserListİtemStateChanged

    private void jButtonClearInformationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearInformationsActionPerformed
        clearInformation();
    }//GEN-LAST:event_jButtonClearInformationsActionPerformed

    private void jButtonUpdateCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateCommentActionPerformed
        checkInformationPlaces();
        getCommentInformation();
        
        try {
            databaseOperations.getDBConnection();
            databaseOperations.updateCommentInfo(getSelectedComment());
            getData();
            clearInformation();
            Utilities.showMessageBox("Yorum güncellendi.", "INFORMATION");
            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Bir yorum seçiniz.", "WARNING");
        }
    }//GEN-LAST:event_jButtonUpdateCommentActionPerformed

    private Comment getSelectedComment() {
        comment = new Comment();
        setCommentInformation();
        return comment;
    }

    private void jButtonDeleteCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCommentActionPerformed
        try {
            databaseOperations.getDBConnection();
            databaseOperations.deleteComment(getSelectedComment());
            getData();
            clearInformation();
            Utilities.showMessageBox("Yorum silindi.", "INFORMATION");
            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Bir yorum seçiniz.", "WARNING");
        }
    }//GEN-LAST:event_jButtonDeleteCommentActionPerformed

    private boolean addUsers() {
        if (userList != null) {
            if (userList.size() > 0) {
                jComboBoxUserList.addItem("Seçiniz");
                for (User user : userList) {
                    jComboBoxUserList.addItem(user.getUserName()
                            + " <" + user.getEmail() + ">");
                }
                return true;
            }
        }
        return false;
    }

    private void getData() {
        String tableName = "comments";
        try {
            databaseOperations.getDBConnection();
            Object[] columnNames = databaseOperations.getTableAllColumnsName(tableName);
            Object[][] commentObject = getCommentList(databaseOperations.getAllComments());
            jTableUserComments.setModel(Utilities.createModelForTable(commentObject, columnNames));
            userList = databaseOperations.getAllUsers();
            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Hata: " + ex.getMessage(), "ERROR");
        }
    }

    private void setTableColumnNames() {
        jTableUserComments.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Yorum ID");
        jTableUserComments.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Blog ID");
        jTableUserComments.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Kullanıcı ID");
        jTableUserComments.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Kullanıcı Adı");
        jTableUserComments.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Başlık");
        jTableUserComments.getTableHeader().getColumnModel().getColumn(5).setHeaderValue("Yorum");
        jTableUserComments.getTableHeader().getColumnModel().getColumn(6).setHeaderValue("Yorum Tarihi");
    }

    private void hideColumn(int columnNo) {
        jTableUserComments.getTableHeader().getColumnModel().getColumn(columnNo).setMaxWidth(0);
        jTableUserComments.getTableHeader().getColumnModel().getColumn(columnNo).setMinWidth(0);
        jTableUserComments.getTableHeader().getColumnModel().getColumn(columnNo).setWidth(0);
        jTableUserComments.getTableHeader().getColumnModel().getColumn(columnNo).setPreferredWidth(0);
    }

    private void setCellRenderer() {
        cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTableUserComments.getColumn("Yorum ID").setCellRenderer(cellRenderer);
        jTableUserComments.getColumn("Blog ID").setCellRenderer(cellRenderer);
        jTableUserComments.getColumn("Kullanıcı ID").setCellRenderer(cellRenderer);
        jTableUserComments.getColumn("Kullanıcı Adı").setCellRenderer(cellRenderer);
        jTableUserComments.getColumn("Başlık").setCellRenderer(cellRenderer);
        jTableUserComments.getColumn("Yorum").setCellRenderer(cellRenderer);
        jTableUserComments.getColumn("Yorum Tarihi").setCellRenderer(cellRenderer);
    }

    private Object[][] getCommentList(List<Comment> comments) {
        if (comments == null) {
            return null;
        }
        Object[][] commentListObject = new Object[comments.size()][7];

        for (int i = 0; i < comments.size(); i++) {
            commentListObject[i][0] = comments.get(i).getCommentID();
            commentListObject[i][1] = comments.get(i).getBlogID();
            commentListObject[i][2] = comments.get(i).getUserID();
            commentListObject[i][3] = comments.get(i).getUserName();
            commentListObject[i][4] = comments.get(i).getCommentTitle();
            commentListObject[i][5] = comments.get(i).getCommentContent();
            commentListObject[i][6] = comments.get(i).getCommentDate();
        }
        return commentListObject;
    }

    private void clearInformation() {
        jTextFieldCommentTitle.setText("");
        jTextAreaCommentContent.setText("");
        jComboBoxUserList.setSelectedIndex(0);

        userID = null;
        commentTitle = null;
        commentContent = null;

        jButtonDeleteComment.setEnabled(false);
        jButtonUpdateComment.setEnabled(false);
    }

    private boolean checkInformationPlaces() {
        if (jTextFieldCommentTitle.getText().trim().length() == 0) {
            Utilities.showMessageBox("Yorum başlığı boş olamaz.", "ERROR");
            return false;
        }
        if (jTextAreaCommentContent.getText().trim().length() == 0) {
            Utilities.showMessageBox("Yorum metni boş olamaz.", "ERROR");
            return false;
        }
        if (jComboBoxUserList.getSelectedItem().toString().equals("Seçiniz")) {
            Utilities.showMessageBox("Bir kullanıcı seçiniz.", "ERROR");
            return false;
        }

        return true;
    }

    private void getCommentInformation() {
        commentTitle = jTextFieldCommentTitle.getText();
        commentContent = jTextAreaCommentContent.getText();
        selectedUser = selectActiveUser();
        userName = selectedUser.getUserName();
    }

    private void setCommentInformation() {
        try {
            comment.setCommentID(commentID);
            comment.setBlogID(blogID);
            comment.setUserID(userID);
            comment.setCommentTitle(commentTitle);
            comment.setCommentContent(commentContent);
            comment.setUserName(userName);
        } catch (Exception ex) {
            Utilities.showMessageBox("Hata: " + ex.getMessage(), "ERROR");
        }
    }

    private User selectActiveUser() {
        if (userList != null) {
            tempUser = jComboBoxUserList.getSelectedItem().toString();

            for (User user : userList) {
                if (tempUser.contains(user.getEmail())) {
                    selectedUser = user;
                }
            }
        }
        return selectedUser;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearInformations;
    private javax.swing.JButton jButtonDeleteComment;
    private javax.swing.JButton jButtonUpdateComment;
    private javax.swing.JComboBox jComboBoxUserList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelActions;
    private javax.swing.JPanel jPanelCommentInformations;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUserComments;
    private javax.swing.JTextArea jTextAreaCommentContent;
    private javax.swing.JTextField jTextFieldCommentTitle;
    // End of variables declaration//GEN-END:variables

}
