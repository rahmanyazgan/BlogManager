package blogmanager.genel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Rahman Yazgan
 */
public class Utilities {
    private static String time;
    private static int result;

    private static String getTİme() {
        return time;
    }

    private static void setTime(String time) {
        Utilities.time = time;
    }

    private static String dateTime(String dateFormat, Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        time = simpleDateFormat.format(date);
        return time;
    }

    public static String showDateTime(Timestamp timestamp) {
        setTime(dateTime("dd/MM/yyyy - [hh:mm]", timestamp));
        return getTİme();
    }

    public static String showOnlyDate(Timestamp timestamp) {
        setTime(dateTime("dd/MM/yyyy", timestamp));
        return getTİme();
    }

    public static String showOnlyTime(Timestamp timestamp) {
        setTime(dateTime("hh:mm", timestamp));
        return getTİme();
    }

    public static Timestamp createNewTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static TableModel createModelForTable(Object[][] data, Object[] title) {
        TableModel tableModel = new DefaultTableModel(data, title) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return tableModel;
    }

    public static void showMessageBox(String message, String messageType) {
        switch (messageType) {
            case "ERROR":
                JOptionPane.showMessageDialog(new JFrame(), message,
                        "HATA", JOptionPane.ERROR_MESSAGE);
                break;
            case "INFORMATION":
                JOptionPane.showMessageDialog(new JFrame(), message,
                        "BİLGİ", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "WARNING":
                JOptionPane.showMessageDialog(new JFrame(), message, 
                        "UYARI", JOptionPane.WARNING_MESSAGE);
                break;
            case "QUESTION":
                askQuestion("", message);
        }
    }
    
    public static int askQuestion(String title, String description) {
        Object[] options = {"EVET", "HAYIR"};
        
        result = JOptionPane.showOptionDialog(new JFrame(), 
                description,
                title, 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[1]);
                
        return result;
    }

}
