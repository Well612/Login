import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OOXX extends JFrame {
    public OOXX() {
        init();
    }
    private JButton Run = new JButton("RUN");
    private JButton Re = new JButton("RE");
    private JButton Exit = new JButton("EXIT");
    private Container cp;
    private boolean flag = true;
    private JButton OX_Button[][] = new JButton[3][3];  //2維陣列按鈕
    private JPanel OX_Panel = new JPanel(new GridLayout(3, 3, 3, 3));
    private JPanel Options_Panel = new JPanel(new GridLayout(3, 1, 3, 3));
    private void init() {
        this.setBounds(400, 100, 600, 500);
        this.setVisible(true);
        this.setTitle("OOXX小遊戲");
        cp = this.getContentPane();
        cp.add(OX_Panel, BorderLayout.CENTER);
        cp.add(Options_Panel, BorderLayout.EAST);
        Options_Panel.add(Run);
        Options_Panel.add(Re);
        Options_Panel.add(Exit);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainFrame();
            }
        });
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                OX_Button[i][j] = new JButton();
                OX_Panel.add(OX_Button[i][j]);  //新增
                OX_Button[i][j].setEnabled(false);
                OX_Button[i][j].setBackground(new Color(255, 255, 255));  //背景顏色
                OX_Button[i][j].setFont(new Font(null, Font.BOLD, 72));
                OX_Button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tempBtn = (JButton) e.getSource(); //臨時按鈕ｅ事件
                        if (tempBtn.getText().equals("")) {
                            if (flag == true) {
                                tempBtn.setText("O");
                            } else {
                                tempBtn.setText("X");
                            }
                            flag = !flag;
                        }
                        checkStat();
                    }
                });
            }
        }
        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        OX_Button[i][j].setEnabled(true);
                        OX_Button[i][j].setText("");
                    }
                }
            }
        });
        Re.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        OX_Button[i][j].setEnabled(false);
                    }
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
    }

    private void checkStat() {
        /* --------------行判斷-----------------*/
        if (OX_Button[0][0].getText().equals(OX_Button[0][1].getText()) &&
                OX_Button[0][0].getText().equals(OX_Button[0][2].getText()) &&
                !OX_Button[0][0].getText().equals("")
                )
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[0][0].getText()+"WIN"); }
        else if( OX_Button[1][0].getText().equals(OX_Button[1][1].getText()) &&
                OX_Button[1][0].getText().equals(OX_Button[1][2].getText()) &&
                !OX_Button[1][0].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[1][0].getText()+"WIN"); }

        else if(OX_Button[2][0].getText().equals(OX_Button[2][1].getText()) &&
                OX_Button[2][0].getText().equals(OX_Button[2][2].getText()) &&
                !OX_Button[2][0].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[2][0].getText()+"WIN"); }

        /* --------------直判斷-----------------*/
        else if (OX_Button[0][0].getText().equals(OX_Button[1][0].getText()) &&
                OX_Button[0][0].getText().equals(OX_Button[2][0].getText()) &&
                !OX_Button[0][0].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[0][0].getText()+"WIN"); }
        else if (OX_Button[0][1].getText().equals(OX_Button[1][1].getText()) &&
                OX_Button[0][1].getText().equals(OX_Button[2][1].getText()) &&
                !OX_Button[0][1].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[0][1].getText()+"WIN"); }
        else if (OX_Button[0][2].getText().equals(OX_Button[1][2].getText()) &&
                OX_Button[0][2].getText().equals(OX_Button[2][2].getText()) &&
                !OX_Button[0][2].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[0][2].getText()+"WIN"); }

        /* --------------斜判斷-----------------*/
        else if (OX_Button[0][0].getText().equals(OX_Button[1][1].getText()) &&
                OX_Button[0][0].getText().equals(OX_Button[2][2].getText()) &&
                !OX_Button[0][0].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[0][0].getText()+"WIN"); }
        else if (OX_Button[0][2].getText().equals(OX_Button[1][1].getText()) &&
                OX_Button[0][2].getText().equals(OX_Button[2][0].getText()) &&
                !OX_Button[0][2].getText().equals(""))
        { JOptionPane.showMessageDialog(OOXX.this,  OX_Button[0][2].getText()+"WIN"); }
    }
//    public static void main(String[] args) {
//        new RandomKeyboard();
//    }
}