import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public Login() {
        init();
    }
    private JPanel
            jPanel_Input = new JPanel(new GridLayout(2, 2, 1, 1)),
            jPanel_Button = new JPanel(new GridLayout(1, 4, 1, 1));
    private JPasswordField
            FiedAccount = new JPasswordField() ;
    protected JPasswordField
            FiedPassword = new JPasswordField();
    private JButton
            Login = new JButton("登入"),
            Exit = new JButton("離開");
    protected JButton
            KeyB = new JButton(" < 小鍵盤");
    private Font
            font = new Font(null, Font.BOLD, 18);
    private JLabel
            jLabel_Account = new JLabel("Account : ",SwingConstants.CENTER),
            jLable_Password = new JLabel("Password : ",SwingConstants.CENTER);
    private String
            Account = "0",
            Password = "1";
    private Container
            ct = this.getContentPane();
    private Dimension
            screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private void init() {
        this.setLocation((screenSize.width)/2-158,50);
//        this.setBounds(820, 40, 400, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        ct.setLayout(new BorderLayout());
        jLabel_Account.setFont(font);
        jLable_Password.setFont(font);
        jPanel_Input.setPreferredSize(new Dimension(300,70));
        jPanel_Button.setPreferredSize(new Dimension(300, 40));
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (String.valueOf(FiedAccount.getPassword()).equals(Account) &&
                        String.valueOf(FiedPassword.getPassword()).equals(Password))
                {
                    new MainFrame();
                    dispose();
                } else {
                    FiedAccount.setBackground(new Color(226, 162, 156));
                    FiedPassword.setBackground(new Color(226, 162, 156));
                }
            }
        });
        KeyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KeyB.setEnabled(false);
                new KeyBoard(Login.this);
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /*-------------------Add-------------------*/
        jPanel_Input.add(jLabel_Account);
        jPanel_Input.add(FiedAccount);
        jPanel_Input.add(jLable_Password);
        jPanel_Input.add(FiedPassword);
        jPanel_Button.add(KeyB);
        jPanel_Button.add(Login);
        jPanel_Button.add(Exit);
        ct.add(jPanel_Input, BorderLayout.CENTER);
        ct.add(jPanel_Button, BorderLayout.SOUTH);
        this.pack();
    }

    public static void main(String[] args) {
        new Login();
    }
}