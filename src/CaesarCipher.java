import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CaesarCipher extends JFrame {
    public CaesarCipher() {
        init();
    }
    private String String_Box[]={"凱薩","無"};

    private Container
            ct = new Container();
    private JLabel
            L1 = new JLabel("Method"),
            L2 = new JLabel("Password");
    private JButton
            RUN = new JButton("Run"),
            Clear = new JButton("Clear"),
            Exit = new JButton("Exit");
    private JTextArea
            jTextArea1 = new JTextArea(),
            jTextArea2 = new JTextArea();
    private JTextField
            UserInout =new JTextField();
    private JRadioButton
            jRadioButton_Encrypt = new JRadioButton("Encrypt",true),
            jRadioButton_Decrypt = new JRadioButton("Decrypt",false);
    private ButtonGroup
            buttonGroup = new ButtonGroup();
    private JPanel
            Panel = new JPanel(new BorderLayout()),
            Panel_center = new JPanel(new GridLayout(9,1,5,5));

    private JComboBox<String>
            jComboBox =new JComboBox<String>(String_Box);


    private void init() {
        this.setVisible(true);
        this.setResizable(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainFrame();
            }
        });
        ct = this.getContentPane();
        Panel.setBounds(0,0,560,500);
        Panel_center.setPreferredSize(new Dimension(100,500));
        jComboBox.setSize(100,50);
        jTextArea1.setPreferredSize(new Dimension(210,500));
        jTextArea2.setPreferredSize(new Dimension(210,500));
        buttonGroup.add(jRadioButton_Encrypt);
        buttonGroup.add(jRadioButton_Decrypt);
        Panel_center.add(L1);
        Panel_center.add(jComboBox);
        Panel_center.add(L2);
        Panel_center.add(UserInout);
        Panel_center.add(jRadioButton_Encrypt);
        Panel_center.add(jRadioButton_Decrypt);
        Panel_center.add(RUN);
        Panel_center.add(Clear);
        Panel_center.add(Exit);
        Panel.add(jTextArea1,BorderLayout.WEST);
        Panel.add(Panel_center,BorderLayout.CENTER);
        Panel.add(jTextArea2,BorderLayout.EAST);
        ct.add(Panel);
        jRadioButton_Encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea2.setText("");
            }
        });
        jRadioButton_Decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText("");
            }
        });

        RUN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int Input = Integer.parseInt(UserInout.getText());//檢查是否為數字
                    if(UserInout.getText().equals("")){
                        JOptionPane.showConfirmDialog(UserInout,"請輸入加密號碼","Error",JOptionPane.CLOSED_OPTION);
                        System.out.println("沒輸入User");
                    }
                    else{
                        if(jRadioButton_Encrypt.isSelected()){
                            String s = jTextArea1.getText();
                            if(s.length()==0){
                                JOptionPane.showConfirmDialog(UserInout,"請輸入要加密文字","Error",JOptionPane.CLOSED_OPTION);
                            }
                            else
                                switch (jComboBox.getSelectedIndex()){
                                    case 0:
                                        char data[]=jTextArea1.getText().toCharArray();
                                        for(int i=0;i<data.length;i++){
                                            data[i]=(char)(data[i]+Input);
                                        }
                                        jTextArea2.setText(new String(data));
                                        break;
                                    case 1:
                                        JOptionPane.showConfirmDialog(UserInout,"Method選則未開發","Error",JOptionPane.CLOSED_OPTION);
                                        break;
                                }
                            System.out.println("Encrypt加密動作");//Encrypt加密動作
                        }
                        else {
                            String s = jTextArea2.getText();
                            if(s.length()==0){
                                JOptionPane.showConfirmDialog(UserInout,"請輸入要解密文字","Error",JOptionPane.CLOSED_OPTION);
                            }
                            else
                                switch (jComboBox.getSelectedIndex()){
                                    case 0:
                                        char data[]=jTextArea2.getText().toCharArray();
                                        for(int i=0;i<data.length;i++){
                                            data[i]=(char)(data[i]-Input);
                                        }
                                        jTextArea1.setText(new String(data));
                                        break;
                                    case 1:
                                        break;
                                }
                        }
                    }
                }
                catch (Exception e1){
                    JOptionPane.showConfirmDialog(UserInout,"請輸入'數字' ","Error",JOptionPane.CLOSED_OPTION);
                    System.out.println(e1.getMessage());
                }

            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MainFrame();
                dispose();
            }
        });
        this.pack();
    }
    public static void main(String[] args) {
        new CaesarCipher();
    }
}