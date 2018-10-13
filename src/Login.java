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
            PanelInput = new JPanel(new GridLayout(2, 2, 1, 1)),
            PanelButton = new JPanel(new GridLayout(1, 4, 1, 1));
    private JPasswordField
            FiedAccount = new JPasswordField() ;
    protected JPasswordField FiedPassword = new JPasswordField();

    private JButton
            KeyB = new JButton(" < 小鍵盤"),
            LoginB = new JButton("登入"),
            Exit = new JButton("離開");
    private Font font = new Font(null, Font.BOLD, 18);
    private JLabel
            jLabel_Account = new JLabel("Account : ",SwingConstants.CENTER),
            jLable_Password = new JLabel("Password : ",SwingConstants.CENTER);
    private String
            Account = "1",
            Password = "0";
    private Container ct = this.getContentPane();
    private KeyBoard keyBoard;
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
        PanelInput.setPreferredSize(new Dimension(300,70));
        PanelButton.setPreferredSize(new Dimension(300, 40));
        LoginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (String.valueOf(FiedAccount.getPassword()).equals(Account) && String.valueOf(FiedPassword.getPassword()).equals(Password)) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                    System.out.println("成功");

                    dispose();

                } else {
                    FiedAccount.setBackground(new Color(226, 162, 156));
                    FiedPassword.setBackground(new Color(226, 162, 156));
                    System.out.println(FiedPassword.getPassword());
                }
            }
        });

        KeyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KeyBoard(Login.this);
                keyBoard.setVisible(true);
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /*-------------------Add-------------------*/
        PanelInput.add(jLabel_Account);
        PanelInput.add(FiedAccount);
        PanelInput.add(jLable_Password);
        PanelInput.add(FiedPassword);
        PanelButton.add(KeyB);
        PanelButton.add(LoginB);
        PanelButton.add(Exit);
        ct.add(PanelInput, BorderLayout.CENTER);
        ct.add(PanelButton, BorderLayout.SOUTH);
        this.pack();

        System.out.println(this.getWidth());
        System.out.println(this.getHeight());

    }

    public static void main(String[] args) {
        new Login();
    }
}