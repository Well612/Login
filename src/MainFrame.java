import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        init2();
    }
    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu
            jMenu_Option = new JMenu("選單"),

            jMenu_HomeWord = new JMenu("作品"),

            jMenu_Tool = new JMenu("工具"),
            jMenu_HomeWord_Game = new JMenu("Game"),

            jMenu_About = new JMenu("關於");
    private JMenuItem
            Item_Save =new JMenuItem("存檔"),
            Item_Read =new JMenuItem("讀取"),
            Item_Exit =new JMenuItem("離開"),

            Item_OOXX =new JMenuItem("OOXX"),
            Item_RamdomKeyboard =new JMenuItem("亂數鍵盤"),

            Item_Setting =new JMenuItem("設定"),
            Item_Introduction =new JMenuItem("開發者介紹");
    private Font font = new Font(null,Font.BOLD,15);
    private JPanel jPanel_MainScreen = new JPanel(new BorderLayout(5,5));
    private Container ct;
    private void init2() {
//        this.setBounds(500, 40, 500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setJMenuBar(jMenuBar);
        ct = this.getContentPane();
        ct.setLayout(new BorderLayout(5,5));
        jPanel_MainScreen.setPreferredSize(new Dimension(500,500));
        Item_Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /*--------------------選單項目-------------------*/
        Item_OOXX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new RandomKeyboard();
                dispose();
                new OOXX();
            }
        });
        /*--------------------作品項目-------------------*/
        Item_RamdomKeyboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new RandomKeyboard();
                dispose();
            }
        });
        /*--------------------工具項目-------------------*/
        Item_Setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        /*-------------------Add-------------------*/
        jMenuBar.add(jMenu_Option);
        jMenuBar.add(jMenu_HomeWord);
        jMenuBar.add(jMenu_Tool);
        jMenuBar.add(jMenu_About);
        jMenu_Option.add(Item_Save);
        jMenu_Option.add(Item_Read);
        jMenu_Option.add(Item_Exit);
        jMenu_HomeWord.add(Item_RamdomKeyboard);
        jMenu_HomeWord.add(jMenu_HomeWord_Game);
        jMenu_HomeWord_Game.add(Item_OOXX);
        jMenu_Tool.add(Item_Setting);
        jMenu_About.add(Item_Introduction);

//        jPanel_MainScreen.add();
//        jPanel_MainScreen.add();
//        jPanel_MainScreen.add();

        ct.add(jPanel_MainScreen,BorderLayout.CENTER);
        this.pack();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}