import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class KeyBoard extends JFrame {
    public KeyBoard (Login login) {
        Init(login.FiedPassword,login.getX());
    }
    private JButton
            jButton_Clear = new JButton("清除"),
            jButton_Input[][] = new JButton[4][3];
    private JPanel
            jPanel_Input = new JPanel(new GridLayout(4,3,1,1)),
            jPanel_passdword = new JPanel(new GridLayout(1,2,3,3));
    private JPasswordField jPasswordField = new JPasswordField();
    private Container cp;
    private int buttonText = 1;     //提供按鈕 文字 及 指令
    private Font
            Font_Passeword =new Font(null,Font.BOLD,40),
            Font_Word =new Font(null,Font.BOLD,17);
    private void Init(JPasswordField LoginPassword,int x){
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(x-280,40,250,400);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("keyboard.png"));
        this.setVisible(true);
        this.setTitle("密碼小鍵盤");

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        jPanel_Input.setBackground(Color.BLACK);
        /*-------------------NORTH-------------------*/
        jPanel_passdword.add(jPasswordField);
        jPanel_passdword.add(jButton_Clear);
        jPanel_passdword.setPreferredSize(new Dimension(250,50));
        jButton_Clear.setFont(Font_Word);


        /*-------------------CENTER-------------------*/
        for(int i=0;i<=3;i++){          //雙for迴圈建立Button
            for(int j=0;j<=2;j++){
                jButton_Input[i][j] = new JButton();
                jButton_Input[i][j].setFont(Font_Passeword);
                jButton_Input[i][j].setText(Integer.toString(buttonText));
                jPanel_Input.add(jButton_Input[i][j]);
                jButton_Input[i][j].setActionCommand(Integer.toString(buttonText)); //設定按鈕指令,利用buttonText

                /*-------------------Set 1~9 ActionListener-------------------*/
                if(i<3){
                    jButton_Input[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jPasswordField.setText(String.valueOf(jPasswordField.getPassword())+e.getActionCommand());
                            //設定密碼文字 = 將密碼字元轉字串 + 使用者輸入指令
                        }
                    });
                }
                buttonText++;
            }
        }
        /*-------------------Set 數字"0" - 離開 ActionListener-------------------*/
        jButton_Input[3][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPasswordField.setText(String.valueOf(jPasswordField.getPassword())+"0");
            }
        });
        jButton_Input[3][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (String.valueOf(jPasswordField.getPassword()).equals("")) {
                    System.out.println("無輸入");
                } else {
                    LoginPassword.setText(String.valueOf(jPasswordField.getPassword()));
                }
            }
        });
        jButton_Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPasswordField.setText("");
                LoginPassword.setText("");
            }
        });
        jButton_Input[3][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jButton_Input[3][0].setText("0");
        jButton_Input[3][1].setText("送出");
        jButton_Input[3][1].setFont(Font_Word);
        jButton_Input[3][2].setText("Exit");
        jButton_Input[3][2].setFont(Font_Word);
        /*-------------------cp.add-------------------*/
        cp.add(jPanel_passdword,BorderLayout.NORTH);
        cp.add(jPanel_Input,BorderLayout.CENTER);
    }
}