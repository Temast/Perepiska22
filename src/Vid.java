
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Vid extends JDialog  {
    private JButton buttonOtpr;
    private JTextField textSoobch;
    private JTextArea textChata;
    private JLabel label1;
    private JLabel label2;
    private JPanel contentPane;



    public Vid() {
        setContentPane(contentPane);
        setModal(true);
        Chat chat = new Chat("nazvanie", "tema", new Date());
        label2.setText(chat.getNazvanie());

    }
    public void createGUI() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        buttonOtpr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textChata.setText(e.getActionCommand());
            }
        });

    }
}
