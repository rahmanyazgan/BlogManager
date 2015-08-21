/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogmanager.view;

import blogmanager.database.DatabaseOperations;
import blogmanager.genel.Utilities;
import blogmanager.model.User;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Rahman Yazgan
 */
public class UserOperationsJDialog extends javax.swing.JDialog {

    private final DefaultTableCellRenderer cellRenderer;
    private final DatabaseOperations databaseOperations;
    private Integer userID;
    private String email;
    private String password;
    private String userName;
    private String accessPermission;
    private List<User> users;
    private User user;

    /**
     * Creates new form UserOperationsJDialog
     *
     * @param parent
     * @param modal
     */
    public UserOperationsJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(parent);

        cellRenderer = new DefaultTableCellRenderer();
        databaseOperations = new DatabaseOperations();
        getData();
        setTableColumnNames();
        hideColumn(0);
        setCellRenderer();
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
        jButtonAddNewUser = new javax.swing.JButton();
        jButtonUpdateUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jPanelUserInformations = new javax.swing.JPanel();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxAccessPermission = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserInformations = new javax.swing.JTable();

        jButtonClearInformations.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonClearInformations.setText("Temizle");
        jButtonClearInformations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearInformationsActionPerformed(evt);
            }
        });

        jButtonAddNewUser.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonAddNewUser.setText("Ekle");
        jButtonAddNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewUserActionPerformed(evt);
            }
        });

        jButtonUpdateUser.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonUpdateUser.setText("Güncelle");
        jButtonUpdateUser.setEnabled(false);
        jButtonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateUserActionPerformed(evt);
            }
        });

        jButtonDeleteUser.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButtonDeleteUser.setText("Sil");
        jButtonDeleteUser.setEnabled(false);
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActionsLayout = new javax.swing.GroupLayout(jPanelActions);
        jPanelActions.setLayout(jPanelActionsLayout);
        jPanelActionsLayout.setHorizontalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonClearInformations, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelActionsLayout.setVerticalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addGroup(jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClearInformations)
                    .addComponent(jButtonUpdateUser)
                    .addComponent(jButtonDeleteUser)
                    .addComponent(jButtonAddNewUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelUserInformations.setBorder(javax.swing.BorderFactory.createTitledBorder("Kullanıcı Bilgileri"));

        jTextFieldUserName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Ad Soyad :");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("E-Posta :");

        jTextFieldEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Şifre :");

        jTextFieldPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Kullanıcı İzni :");

        jComboBoxAccessPermission.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jComboBoxAccessPermission.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Okur (Yorum yazabilir)", "Yazar (Blog sahibi olabilir)", "Yönetici (Tüm verilere erişebilir)" }));

        javax.swing.GroupLayout jPanelUserInformationsLayout = new javax.swing.GroupLayout(jPanelUserInformations);
        jPanelUserInformations.setLayout(jPanelUserInformationsLayout);
        jPanelUserInformationsLayout.setHorizontalGroup(
            jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUserInformationsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUserName))
            .addGroup(jPanelUserInformationsLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAccessPermission, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelUserInformationsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPassword)
                    .addComponent(jTextFieldEmail)))
        );
        jPanelUserInformationsLayout.setVerticalGroup(
            jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserInformationsLayout.createSequentialGroup()
                .addGroup(jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUserInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxAccessPermission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableUserInformations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTableUserInformations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserInformationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUserInformations);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelUserInformations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelUserInformations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getData() {
        String tableName = "users";

        try {
            databaseOperations.getDBConnection();
            Object[] columnNames = databaseOperations.getTableAllColumnsName(tableName);
            Object[][] userObject = getUserList(databaseOperations.getAllUsers());
            jTableUserInformations.setModel(Utilities.createModelForTable(userObject, columnNames));
            users = databaseOperations.getAllUsers();
            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Hata : " + ex.getMessage(), "ERROR");
        }
    }

    private void setTableColumnNames() {
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Kullanıcı ID");
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("E-Posta");
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Şifre");
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Ad Soyad");
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Erişim İzni");
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(5).setHeaderValue("Kayıt Tarihi");
    }

    private void hideColumn(int columnNo) {
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(columnNo).setMaxWidth(0);
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(columnNo).setMinWidth(0);
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(columnNo).setWidth(0);
        jTableUserInformations.getTableHeader().getColumnModel().getColumn(columnNo).setPreferredWidth(0);
    }

    private void setCellRenderer() {
        cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTableUserInformations.getColumn("Kullanıcı ID").setCellRenderer(cellRenderer);
        jTableUserInformations.getColumn("E-Posta").setCellRenderer(cellRenderer);
        jTableUserInformations.getColumn("Şifre").setCellRenderer(cellRenderer);
        jTableUserInformations.getColumn("Ad Soyad").setCellRenderer(cellRenderer);
        jTableUserInformations.getColumn("Erişim İzni").setCellRenderer(cellRenderer);
        jTableUserInformations.getColumn("Kayıt Tarihi").setCellRenderer(cellRenderer);
    }

    private Object[][] getUserList(List<User> users) {
        if (users == null) {
            return null;
        }
        Object[][] userListObject = new Object[users.size()][6];

        for (int i = 0; i < users.size(); i++) {
            userListObject[i][0] = users.get(i).getUserID();
            userListObject[i][1] = users.get(i).getEmail();
            userListObject[i][2] = users.get(i).getPassword();
            userListObject[i][3] = users.get(i).getUserName();
            userListObject[i][4] = users.get(i).getAccessPermission();
            userListObject[i][5] = users.get(i).getRecordDate();
        }
        return userListObject;
    }

    private void jTableUserInformationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserInformationsMouseClicked
        Integer selectedRow = jTableUserInformations.getSelectedRow();

        if (selectedRow.toString() != null) {
            jButtonDeleteUser.setEnabled(true);
            jButtonUpdateUser.setEnabled(true);
        } else {
            return;
        }

        try {
            userID = (Integer) jTableUserInformations.getValueAt(selectedRow, 0);
            email = jTableUserInformations.getValueAt(selectedRow, 1).toString();
            password = jTableUserInformations.getValueAt(selectedRow, 2).toString();
            userName = jTableUserInformations.getValueAt(selectedRow, 3).toString();
            accessPermission = (String) jTableUserInformations.getValueAt(selectedRow, 4);

            jTextFieldUserName.setText(userName);
            jTextFieldEmail.setText(email);
            jTextFieldPassword.setText(password);

            setJComboBoxAccessPermission();
        } catch (NullPointerException ex) {
            Utilities.showMessageBox("Hata: " + ex.getMessage(), "ERROR");
        }
    }//GEN-LAST:event_jTableUserInformationsMouseClicked

    // A: Yönetici(Admin), O: Okur(Reader), Y: Yazar(Author)
    private String getAccessPermission(int jComboBoxSelectedIndex) {
        switch (jComboBoxSelectedIndex) {
            case 2:
                accessPermission = "A";
                break;
            case 0:
                accessPermission = "O";
                break;
            case 1:
                accessPermission = "Y";
                break;
        }
        return accessPermission;
    }

    private void setJComboBoxAccessPermission() {
        switch (accessPermission) {
            case "A":
                jComboBoxAccessPermission.setSelectedIndex(2);
                break;
            case "O":
                jComboBoxAccessPermission.setSelectedIndex(0);
                break;
            case "Y":
                jComboBoxAccessPermission.setSelectedIndex(1);
                break;
            default:
                jComboBoxAccessPermission.setSelectedIndex(0);
        }
    }

    private void jButtonClearInformationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearInformationsActionPerformed
        clearInformation();
    }//GEN-LAST:event_jButtonClearInformationsActionPerformed

    private void clearInformation() {
        jTextFieldEmail.setText("");
        jTextFieldPassword.setText("");
        jTextFieldUserName.setText("");
        jComboBoxAccessPermission.setSelectedIndex(0);

        userID = null;
        email = null;
        password = null;
        userName = null;
        accessPermission = null;

        jButtonDeleteUser.setEnabled(false);
        jButtonUpdateUser.setEnabled(false);
    }

    private void getUserInformation() {
        email = jTextFieldEmail.getText();
        password = jTextFieldPassword.getText();
        userName = jTextFieldUserName.getText();

        int selectedIndex = jComboBoxAccessPermission.getSelectedIndex();
        accessPermission = getAccessPermission(selectedIndex);
    }

    private boolean setUserInformation() {
        try {
            user.setEmail(email);
            user.setPassword(password);
            user.setUserName(userName);
            user.setAccessPermission(accessPermission);
            user.setRecordDate(Utilities.createNewTimestamp());
            return true;
        } catch (Exception ex) {
            Utilities.showMessageBox("Hata: " + ex.getMessage(), "ERROR");
            return false;
        }
    }

    private void jButtonAddNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewUserActionPerformed
        getUserInformation();
        try {
            if (email.isEmpty() || password.isEmpty()) {
                Utilities.showMessageBox("E-posta veya şifre bilgisini girmediniz.", "ERROR");
                return;
            }

            databaseOperations.getDBConnection();

            if (users != null) {
                for (User tempUser : users) {
                    if (email.contains(tempUser.getEmail())) {
                        Utilities.showMessageBox("Bu e-posta adresi daha önce kullanılmış. "
                                + "Farklı bir e-posta adresi kullanınız.", "ERROR");
                        return;
                    }
                }
            }

            user = new User();
            if (setUserInformation()) {
                databaseOperations.createUser(user);
                getData();
                Utilities.showMessageBox("Kullanıcı eklendi.", "INFORMATION");
            }

            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Hata: " + ex.getMessage(), "ERROR");
        }
    }//GEN-LAST:event_jButtonAddNewUserActionPerformed

    private void jButtonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateUserActionPerformed
        getUserInformation();

        try {
            databaseOperations.getDBConnection();
            user = selectedUser();

            if (setUserInformation()) {
                databaseOperations.updateUserInfo(user);
                getData();
                Utilities.showMessageBox("Kullanıcı bilgileri güncellendi.", "INFORMATION");
            }
            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Bir kullanıcı seçiniz.", "ERROR");
        }
    }//GEN-LAST:event_jButtonUpdateUserActionPerformed

    private User selectedUser() {
        for (User tempUser : users) {
            if (userID.equals(tempUser.getUserID())) {
                return tempUser;
            }
        }
        return null;
    }

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        try {
            databaseOperations.getDBConnection();
            user = selectedUser();
            databaseOperations.deleteUser(user);
            getData();
            clearInformation();
            Utilities.showMessageBox("Kullanıcı silindi.", "INFORMATION");
            databaseOperations.dbConnectionClose();
        } catch (Exception ex) {
            Utilities.showMessageBox("Bir kullanıcı seçiniz.", "WARNING");
        }
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewUser;
    private javax.swing.JButton jButtonClearInformations;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox jComboBoxAccessPermission;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelActions;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelUserInformations;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUserInformations;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables

}
