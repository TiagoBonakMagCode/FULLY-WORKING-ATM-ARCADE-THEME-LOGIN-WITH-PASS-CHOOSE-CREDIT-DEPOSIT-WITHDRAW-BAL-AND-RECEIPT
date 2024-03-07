import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FinalProjectMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoadingScreen();
        });
    }
}
class LoadingScreen {
    JFrame frame = new JFrame("ARCADE'S GOLD RESERVE");
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JPanel pbarPanel = new JPanel();
    JPanel textlogopanel = new JPanel();
    JPanel textlogopanellineborder = new JPanel();
    JButton startingButton = new JButton();
    JButton exitButton = new JButton();
    JLabel design1 = new JLabel();
    JFrame frame2 = new JFrame("ARCADE'S GOLD RESERVE");
    JPanel panel3 = new JPanel();
    JButton account1 = new JButton();
    JButton account2 = new JButton();
    JFrame LogInFrame = new JFrame();
    JFrame LogInFrame2 = new JFrame();
    JLabel choose = new JLabel();
    JLabel acc1 = new JLabel();
    JLabel acc2 = new JLabel();
    JButton backButton1 = new JButton();
    JButton backButton2 = new JButton();
    JPanel LogInPanel1 = new JPanel();
    JPanel LogInPanel2 = new JPanel();
    JPasswordField ACC1PASS = new JPasswordField();
    JPasswordField ACC2PASS = new JPasswordField();
    JLabel PINLABEL1 = new JLabel();
    JLabel PINLABEL2 = new JLabel();
    JPanel Buttonpanel;
    JPanel Buttonpanel1;
    JButton [] numberButtons= new JButton[10];
    JButton [] numberButtons1= new JButton[10];
    JButton DeleteButton, ClearButton;
    JButton DeleteButton1, ClearButton1;
    JToggleButton EyeButton;    

    
    JProgressBar pbarstart = new JProgressBar(5, 100);
    Timer t;

    int i = 0;
    int ATTEMPTS = 3;
    final String CorrectPass1 = "123456";
    final String CorrectPass2 = "654321";

    Font myFont = new Font(" Monocraft ",Font.BOLD,15);

    LoadingScreen() {
        ImageIcon logo = new ImageIcon("LOGO.png");
        frame.setIconImage(logo.getImage());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500, 880);
        frame.setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("MAINBG.png");
        Image image = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        label.setIcon(scaledImageIcon);
        frame.setContentPane(label);
        frame.setVisible(true);
        frame.add(textlogopanel);
        textlogopanel.setLayout(null);
        textlogopanel.setBounds(290, 50, 920, 500);
        textlogopanel.setBackground(Color.BLACK);
        textlogopanel.setOpaque(false);
        ImageIcon textlogo = new ImageIcon("TextlogoWithchest-removebg-preview.png");
        JLabel textlogoLabel = new JLabel(textlogo);
        textlogoLabel.setBounds(0, 2, 920, 500);
        textlogopanel.add(textlogoLabel);
        frame.add(textlogopanel);

        frame.add(panel2);
        panel2.setLayout(null);
        panel2.setBounds(190, 80, 1500, 900);
        panel2.setBackground(Color.BLACK);
        panel2.setOpaque(false);

        pbarPanel.setBounds(190, 80, 1000, 10000);
        pbarPanel.setOpaque(false);
        pbarPanel.setLayout(null);
        pbarPanel.setVisible(true);
        panel2.add(pbarPanel);

        ImageIcon exitButtonIcon = new ImageIcon("EXIT.png");
        exitButton.setSize(250, 65);
        Image exitButtonImage = exitButtonIcon.getImage().getScaledInstance(250, 65, Image.SCALE_SMOOTH);
        exitButton.setIcon(new ImageIcon(exitButtonImage));
        exitButton.setBounds(425, 330, 250, 65);
        exitButton.setBorderPainted(false);
        exitButton.setFocusable(false);

        ImageIcon startbuttonImageIcon = new ImageIcon("MARIOSTART.png");
        startingButton.setSize(250, 65);
        Image buttonImage = startbuttonImageIcon.getImage().getScaledInstance(250, 65, Image.SCALE_SMOOTH);
        startingButton.setIcon(new ImageIcon(buttonImage));
        startingButton.setBounds(80, 330, 250, 65);
        startingButton.setBorderPainted(false);
        startingButton.setFocusable(false);
        startingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == startingButton) {
                    pbarPanel.add(pbarstart);
                    pbarstart.setVisible(true);
                    startingButton.setVisible(false);
                    exitButton.setVisible(false);
                    t.start();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exitButton) {
                    Exit();
                }
            }
        });

        pbarPanel.add(exitButton);
        pbarPanel.add(startingButton);

        pbarstart.setBounds(70, 330, 600, 50);
        pbarstart.setStringPainted(true);
        pbarstart.setString("Starting...");
        pbarstart.setFont(new Font("Monocraft", Font.BOLD, 25));
        pbarstart.setBackground(new Color(0, 255, 255));
        pbarstart.setForeground(new Color(255, 105, 180));
        pbarstart.setFocusable(false);

        ImageIcon ToBeChange = new ImageIcon("LOGO.png");
        frame2.setIconImage(ToBeChange.getImage());
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setSize(1500, 900);
        frame2.setLocationRelativeTo(null);
        frame2.setContentPane(label2);
        frame2.setVisible(false);

        ImageIcon imageIcon1 = new ImageIcon("MAINBG.png");
        Image image1 = imageIcon1.getImage().getScaledInstance(frame2.getWidth(), frame2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon1 = new ImageIcon(image1);
        label2.setIcon(scaledImageIcon1);

        t = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 100) {
                    frame2.setVisible(true);
                    frame.setVisible(false);
                    t.stop();
                } else {
                    i++;
                    pbarstart.setValue(i);
                }
            }
        });

        frame2.add(panel3);
        frame2.add(account1);
        frame2.add(account2);
        frame2.add(choose);
        frame2.add(acc1);
        frame2.add(acc2);

        choose.setText("> CHOOSE YOUR CREDIT CARD <");
        choose.setFont(new Font("Monocraft", Font.BOLD, 35));
        choose.setBounds(430, 240, frame2.getWidth(), frame2.getHeight());
        choose.setForeground(Color.WHITE);

        acc1.setText("CREDIT 1");
        acc1.setFont(new Font("Monocraft", Font.BOLD, 35));
        acc1.setBounds(340, 250, 200, 50);
        acc1.setForeground(Color.CYAN);

        acc2.setText("CREDIT 2");
        acc2.setFont(new Font("Monocraft", Font.BOLD, 35));
        acc2.setBounds(975, 250, 200, 50);
        acc2.setForeground(Color.CYAN);


        ImageIcon account1Icon = new ImageIcon("CREDIT1.jpg");
        account1.setSize(575, 270);
        Image ACCOUNT1ICON = account1Icon.getImage().getScaledInstance(575, 270, Image.SCALE_SMOOTH);
        account1.setIcon(new ImageIcon(ACCOUNT1ICON));
        account1.setBounds(140, 310, 575, 270);
        account1.setBorderPainted(false);
        account1.setFocusable(false);
        account1.setOpaque(false);
        account1.setBackground(Color.BLACK);
        account1.setLayout(null);
        account1.setBorder(null);

        ImageIcon account2Icon = new ImageIcon("CREDIT2.png");
        account2.setSize(575, 270);
        Image ACCOUNT2ICON = account2Icon.getImage().getScaledInstance(575, 270, Image.SCALE_SMOOTH);
        account2.setIcon(new ImageIcon(ACCOUNT2ICON));
        account2.setBounds(780, 310, 575, 270);
        account2.setBorderPainted(false);
        account2.setFocusable(false);
        account2.setOpaque(false);
        account2.setBackground(Color.BLACK);
        account2.setLayout(null);
        account2.setBorder(null);

        account1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (a.getSource() == account1) {
                    LogInFrame.setVisible(true);
                    frame.setVisible(false);
                    frame2.setVisible(false);
                }
            }
        });
        account2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (a.getSource() == account2) {
                    LogInFrame2.setVisible((true));
                    frame.setVisible(false);
                    frame2.setVisible(false);
                }
            }
        });

        LogInFrame = new JFrame("ARCADE'S GOLD RESERVE (CREDIT 1)");
        LogInFrame.setIconImage(logo.getImage());
        LogInFrame.setResizable(false);
        LogInFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LogInFrame.setSize(1500, 900);
        LogInFrame.setLocationRelativeTo(null);
        ImageIcon loginBackgroundIcon = new ImageIcon("LOGINBG.png");
        Image loginBackgroundImage = loginBackgroundIcon.getImage().getScaledInstance(1500, 900, Image.SCALE_SMOOTH);
        JLabel loginBackgroundLabel = new JLabel(new ImageIcon(loginBackgroundImage));
        loginBackgroundLabel.setLayout(null);
        loginBackgroundLabel.setBounds(0, 0, 1500, 900);
        LogInFrame.setContentPane(loginBackgroundLabel);
        Keypad(ACC1PASS);
        LogInFrame.setVisible(false);  
        LogInPanel1.add(backButton1); 
        Playbutton1();
        EyeButton();
        

        LogInFrame2 = new JFrame("ARCADE'S GOLD RESERVE (CREDIT 2)");
        LogInFrame2.setIconImage(logo.getImage());
        LogInFrame2.setResizable(false);
        LogInFrame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LogInFrame2.setSize(1500, 900);
        LogInFrame2.setLocationRelativeTo(null);
        ImageIcon login2BackgroundIcon = new ImageIcon("LOGINBG.png");
        Image login2BackgroundImage = login2BackgroundIcon.getImage().getScaledInstance(1500, 900, Image.SCALE_SMOOTH);
        JLabel login2BackgroundLabel = new JLabel(new ImageIcon(login2BackgroundImage));
        login2BackgroundLabel.setLayout(null);
        login2BackgroundLabel.setBounds(0, 0, 1500, 900);
        LogInFrame2.setContentPane(login2BackgroundLabel);
        Keypad2(ACC2PASS);
        LogInFrame2.setVisible(false); 
        LogInPanel2.add(backButton2);
       
        ImageIcon backButton2Icon = new ImageIcon("BACKBUTTON.png");
        backButton1.setSize(86, 43);
        Image backButton2Icon2 = backButton2Icon.getImage().getScaledInstance(86, 43, Image.SCALE_SMOOTH);
        backButton2.setIcon(new ImageIcon(backButton2Icon2));
        backButton2.setBounds(140,360, 86, 43);
        backButton2.setBorderPainted(false);
        backButton2.setFocusable(false);
        backButton2.setOpaque(false);
        backButton2.setBackground(Color.BLACK);
        backButton2.setLayout(null);
        backButton2.setBorder(null); 

        ImageIcon backButton1Icon = new ImageIcon("BACKBUTTON.png");
        backButton1.setSize(86, 43);
        Image backButton1Icon2 = backButton1Icon.getImage().getScaledInstance(86, 43, Image.SCALE_SMOOTH);
        backButton1.setIcon(new ImageIcon(backButton1Icon2));
        backButton1.setBounds(140,360, 86, 43);
        backButton1.setBorderPainted(false);
        backButton1.setFocusable(false);
        backButton1.setOpaque(false);
        backButton1.setBackground(Color.BLACK);
        backButton1.setLayout(null);
        backButton1.setBorder(null);  
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                if (a.getSource() == backButton1){
                    frame2.setVisible(true);
                    LogInFrame.setVisible(false);
                    
                }
            }
        });      
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                if (a.getSource() == backButton2){
                    frame2.setVisible(true);
                    LogInFrame.setVisible(false); 
                }
            }
        });      
        
        LogInFrame.add(LogInPanel1);
        LogInPanel1.setLayout(null); 
        LogInPanel1.setBounds(220, 200, 2000, 1500);
        LogInPanel1.setBackground(Color.BLACK);
        LogInPanel1.setOpaque(false);

        LogInPanel1.add(PINLABEL1);
        PINLABEL1.setText("Enter PIN");
        PINLABEL1.setFont(new Font("Monocraft", Font.BOLD, 15));
        PINLABEL1.setBounds(195, 260, 100, 30);
        PINLABEL1.setForeground(Color.BLACK);

        LogInPanel1.add(ACC1PASS);
        ImageIcon lockedatmIcon = new ImageIcon("CREDIT1LOCKED.png");
        JLabel lockedatmLabel = new JLabel(lockedatmIcon);
        lockedatmLabel.setLayout(null); 
        lockedatmLabel.setBounds(-20, -85, 550, 500); 
        lockedatmLabel.setOpaque(false); 
        LogInPanel1.add(lockedatmLabel);
        ACC1PASS.setBounds(120,290,200,40);
        ACC1PASS.setHorizontalAlignment(JPasswordField.CENTER);
        ImageIcon loginPaneIcon1 = new ImageIcon("BOARDPANE.png");
        JLabel loginPaneLabel1 = new JLabel(loginPaneIcon1);
        loginPaneLabel1.setLayout(null); 
        loginPaneLabel1.setBounds(0, 0, loginPaneIcon1.getIconWidth(), loginPaneIcon1.getIconHeight());
        loginPaneLabel1.setBackground(Color.BLACK);
        loginPaneLabel1.setOpaque(false);
        LogInPanel1.add(loginPaneLabel1);
        
        LogInFrame2.add(LogInPanel2);
        LogInPanel2.setLayout(null); 
        LogInPanel2.setBounds(220, 200, 2000, 1500);
        LogInPanel2.setBackground(Color.BLACK);
        LogInPanel2.setOpaque(false);
        LogInPanel2.add(ACC2PASS);

        LogInPanel2.add(PINLABEL2);
        PINLABEL2.setText("Enter PIN");
        PINLABEL2.setFont(new Font("Monocraft", Font.BOLD, 15));
        PINLABEL2.setBounds(195, 260, 100, 30);
        PINLABEL2.setForeground(Color.BLACK);

      
        ImageIcon safeatmIcon = new ImageIcon("CREDITCARD2SAFE.png");
        JLabel safeatmLabel = new JLabel(safeatmIcon);
        safeatmLabel.setLayout(null); 
        safeatmLabel.setBounds(-20, -85, 550, 500); 
        safeatmLabel.setOpaque(false); 
        LogInPanel2.add(safeatmLabel);
        ACC2PASS.setBounds(120,290,255,40);
        ACC2PASS.setHorizontalAlignment(JPasswordField.CENTER);
        ImageIcon loginPane2Icon1 = new ImageIcon("BOARDPANE.png");
        JLabel loginPane2Label1 = new JLabel(loginPane2Icon1);
        loginPane2Label1.setLayout(null); 
        loginPane2Label1.setBounds(0, 0, loginPane2Icon1.getIconWidth(), loginPane2Icon1.getIconHeight());
        loginPane2Label1.setBackground(Color.BLACK);
        loginPane2Label1.setOpaque(false);
        LogInPanel2.add(loginPane2Label1);

    }
    public void Playbutton1(){//Play button conditions
        JButton PLYButton = new JButton();
        ImageIcon PLYButtonIcon = new ImageIcon("PlayButton.png");
        PLYButton.setIcon(PLYButtonIcon);
        PLYButton.setBounds(240,360, 85, 40);
        PLYButton.setLayout(null);
        PLYButton.setBackground(Color.BLACK);
        PLYButton.setOpaque(false);
        
        
        ACC1PASS.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){
                e.consume();
            }
            @Override
            public void keyPressed(KeyEvent e){
                e.consume();
            }
            @Override
            public void keyReleased(KeyEvent e){
                e.consume();
            }
        });

        PLYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(ACC1PASS.getPassword());
                if (password.equals(CorrectPass1)) {
                   TransAvail();
                } else {
                    ATTEMPTS--;
                    if (ATTEMPTS == 0) {
                        System.exit(0);
                    } else {
                        Att();
                        ACC1PASS.setText(""); 
                    }
                }
            }
        });
        LogInPanel1.add(PLYButton);
    }
    public void EyeButton(){
        EyeButton = new JToggleButton(new ImageIcon("EYE.png"));
        EyeButton.setOpaque(false);
        EyeButton.setBounds(350,290,30,30);
        UIManager.put("Button.select", new Color(0x9f86c0));
        EyeButton.setPreferredSize(new Dimension(30,30));
        EyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EyeButton.isSelected()) {
                    ACC1PASS.setEchoChar((char) 0);
                    ACC1PASS.setVisible(true); 
                } else {
                    ACC1PASS.setEchoChar('•'); 
                }
            }
        });
        LogInPanel1.add(EyeButton);
}
    public void Keypad(JPasswordField ACC1PASS) {
        Buttonpanel = new JPanel(new GridLayout(4, 3, 10, 10)); 
    
        for (int b = 1; b <= 9; b++) {
            final int digit = b;
            numberButtons[b] = new JButton(String.valueOf(b));
            numberButtons[b].setBackground(new Color(160,160,160));
            numberButtons[b].setFont(new Font("Monocraft", Font.BOLD, 25));
            numberButtons[b].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == numberButtons[digit]) {
                        String TypedPass = new String(ACC1PASS.getPassword());
                        String newPass = TypedPass + String.valueOf(digit);
                        ACC1PASS.setText(newPass);
                    }
                }
            });
            Buttonpanel.add(numberButtons[b]);
        }
    
        numberButtons[0] = new JButton("0");
        numberButtons[0].setFont(new Font("Monocraft", Font.BOLD, 25));
        numberButtons[0].setBackground(new Color(160,160,160));
        numberButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == numberButtons[0]) {
                    String TypedPass = new String(ACC1PASS.getPassword());
                    String newPass = TypedPass + "0";
                    ACC1PASS.setText(newPass);
                }
            }
        });
        Buttonpanel.add(numberButtons[0]);
        DeleteButton1 = new JButton("DEL");
        DeleteButton1.setBackground(new Color(204, 204,0));
        DeleteButton1.setFont(new Font("Monocraft", Font.BOLD, 25));
        DeleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = ACC1PASS.getText();
                if (e.getSource() == DeleteButton1) {
                    if (password.length() > 0) {
                        ACC1PASS.setText(password.substring(0, password.length() - 1));
                    }
                }
            }
        });
        Buttonpanel.add(DeleteButton1);
        ClearButton1 = new JButton("CLEAR");
        ClearButton1.setBackground(new Color(255,102,102));
        ClearButton1.setFont(new Font("Monocraft", Font.BOLD, 25));
        ClearButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ClearButton1) {
                    ACC1PASS.setText("");
                }
            }
        });
        Buttonpanel.add(ClearButton1);
        Buttonpanel.setBackground(Color.BLACK);
        Buttonpanel.setOpaque(false);
        Buttonpanel.setBounds(750, 210, 500, 450);
        LogInFrame.add(Buttonpanel);
    }


    public void Keypad2(JPasswordField ACC2PASS) {
        JPanel Buttonpanel1 = new JPanel(new GridLayout(4, 3, 10, 10)); 
    
        for (int b = 1; b <= 9; b++) {
            final int digit = b;
            numberButtons1[b] = new JButton(String.valueOf(b));
            numberButtons1[b].setBackground(new Color(160, 160, 160));
            numberButtons1[b].setFont(new Font("Monocraft", Font.BOLD, 25));
            numberButtons1[b].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == numberButtons1[digit]) {
                        String TypedPass1 = new String(ACC2PASS.getPassword());
                        String newPass1 = TypedPass1 + String.valueOf(digit);
                        ACC2PASS.setText(newPass1);
                    }
                }
            });
            Buttonpanel1.add(numberButtons1[b]);
        }
    
        numberButtons1[0] = new JButton("0");
        numberButtons1[0].setFont(new Font("Monocraft", Font.BOLD, 25));
        numberButtons1[0].setBackground(new Color(160, 160, 160));
        numberButtons1[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == numberButtons1[0]) {
                    String TypedPass1 = new String(ACC2PASS.getPassword());
                    String newPass1 = TypedPass1 + "0";
                    ACC2PASS.setText(newPass1);
                }
            }
        });
    
        Buttonpanel1.add(numberButtons1[0]);
    
        DeleteButton = new JButton("DEL");
        DeleteButton.setBackground(new Color(204, 204, 0));
        DeleteButton.setFont(new Font("Monocraft", Font.BOLD, 25));
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password1 = ACC2PASS.getText();
                if (e.getSource() == DeleteButton) {
                    if (password1.length() > 0) {
                        ACC2PASS.setText(password1.substring(0, password1.length() - 1));
                    }
                }
            }
        });
        Buttonpanel1.add(DeleteButton);
    
        ClearButton = new JButton("CLEAR");
        ClearButton.setBackground(new Color(255, 102, 102));
        ClearButton.setFont(new Font("Monocraft", Font.BOLD, 25));
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ClearButton) {
                    ACC2PASS.setText("");
                }
            }
        });
        Buttonpanel1.add(ClearButton);
    
        Buttonpanel1.setBackground(Color.BLACK);
        Buttonpanel1.setOpaque(false);
        Buttonpanel1.setBounds(750, 210, 500, 450);
        LogInFrame2.add(Buttonpanel1); 
    } 

    public void Exit() {
        Border ExitBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        
        JLabel ExitQuestionMark = new JLabel();
        ExitQuestionMark.setText("EXIT?");
        ExitQuestionMark.setForeground(new Color(238, 130, 238));
        ExitQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        ExitQuestionMark.setBounds(270, 50, 150, 50); 
        
        JLabel ExitConfirmation1 = new JLabel();
        ExitConfirmation1.setText("Are you sure you want to Exit?");
        ExitConfirmation1.setForeground(Color.WHITE);
        ExitConfirmation1.setFont(new Font("Monocraft", Font.BOLD, 15));
        ExitConfirmation1.setBounds(270, 100, 400, 50); 
        
        JButton YesButton = new JButton("YES");
        YesButton.setBackground(new Color(250,66,27));
        YesButton.setFont(new Font("Monocraft",Font.BOLD,15));
        YesButton.setBounds(300, 170, 80, 40);
        
        JButton NoButton = new JButton("NO");
        NoButton.setBackground(new Color(103,243,0));
        NoButton.setFont(new Font("Monocraft",Font.BOLD,15));
        NoButton.setBounds(450, 170, 75, 44);
        
        JLabel WarningSign = new JLabel();
        ImageIcon WarningSignIcon = new ImageIcon("WARNINGSIGN.png");
        WarningSign.setIcon(WarningSignIcon);
        WarningSign.setBounds(50, 50, 153, 151); 
        WarningSign.setOpaque(false);
        
        JFrame ExitFrame = new JFrame("Exit Confirmation");
        ImageIcon WarningLogo = new ImageIcon("WARNINGLOGO.png");
        ExitFrame.setIconImage(WarningLogo.getImage());
        ExitFrame.getContentPane().setBackground(Color.BLACK);
        ExitFrame.setLayout(null);
        ExitFrame.setSize(700, 300);
        ExitFrame.setLocationRelativeTo(null);
        ExitFrame.getRootPane().setBorder(ExitBorder);
        
        YesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        NoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExitFrame.dispose(); 
            }
        });

        YesButton.setFocusable(false);
        NoButton.setFocusable(false);
        
        ExitFrame.add(ExitQuestionMark);
        ExitFrame.add(ExitConfirmation1);
        ExitFrame.add(YesButton);
        ExitFrame.add(NoButton);
        ExitFrame.add(WarningSign);
        ExitFrame.setVisible(true);
    }

    public void EmptyField(){//empty field
        Border EmptyFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame Empty = new JFrame("Empty Field Notice");
        Empty.setBackground(Color.BLACK);
        ImageIcon WarningLogo1 = new ImageIcon("WARNINGLOGO.png");
        Empty.setIconImage(WarningLogo1.getImage());
        Empty.getContentPane().setBackground(Color.BLACK);
        Empty.setLayout(null);
        Empty.setSize(700, 300);
        Empty.setLocationRelativeTo(null);
        Empty.getRootPane().setBorder(EmptyFrameBorder);

        JLabel EmptyQuestionMark = new JLabel();
        EmptyQuestionMark.setText("FIELD EMPTY");
        EmptyQuestionMark.setForeground(new Color(238, 130, 238));
        EmptyQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        EmptyQuestionMark.setBounds(270, 50, 150, 50); 
        
        JLabel ProvidePIN = new JLabel();
        ProvidePIN.setText("Please provide a PIN");
        ProvidePIN.setForeground(Color.WHITE);
        ProvidePIN.setFont(new Font("Monocraft", Font.BOLD, 15));
        ProvidePIN.setBounds(270, 100, 400, 50);

        JLabel WarningSign1 = new JLabel();
        ImageIcon WarningSignIcon1 = new ImageIcon("WARNINGSIGN.png");
        WarningSign1.setIcon(WarningSignIcon1);
        WarningSign1.setBounds(50, 50, 153, 151); 
        WarningSign1.setOpaque(false);

        JButton OKButton = new JButton();
        OKButton.setBackground(new Color(250,66,27));
        OKButton.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton.setBounds(300, 170, 80, 40);
        OKButton.setFocusable(false);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empty.dispose(); 
            }
        });
        Empty.add(EmptyQuestionMark);
        Empty.add(ProvidePIN);
        Empty.add(OKButton);
        Empty.add(WarningSign1);
        Empty.setVisible(true);
       
    }

    public void PassL(){//pass length limit
        Border PassLFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame PassLg = new JFrame("PIN Lenght Limit Reached Notice");
        PassLg.setBackground(Color.BLACK);
        ImageIcon WarningLogo2 = new ImageIcon("WARNINGLOGO.png");
        PassLg.setIconImage(WarningLogo2.getImage());
        PassLg.getContentPane().setBackground(Color.BLACK);
        PassLg.setLayout(null);
        PassLg.setSize(700, 300);
        PassLg.setLocationRelativeTo(null);
        PassLg.getRootPane().setBorder(PassLFrameBorder);

        JLabel PassLQuestionMark = new JLabel();
        PassLQuestionMark.setText("LIMIT REACHED");
        PassLQuestionMark.setForeground(new Color(238, 130, 238));
        PassLQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        PassLQuestionMark.setBounds(270, 50, 150, 50); 
        
        JLabel LengthN = new JLabel();
        LengthN.setText("PIN must contain 6 Characters Only");
        LengthN.setForeground(Color.WHITE);
        LengthN.setFont(new Font("Monocraft", Font.BOLD, 15));
        LengthN.setBounds(270, 100, 400, 50);

        JLabel WarningSign2 = new JLabel();
        ImageIcon WarningSignIcon2 = new ImageIcon("WARNINGSIGN.png");
        WarningSign2.setIcon(WarningSignIcon2);
        WarningSign2.setBounds(50, 50, 153, 151); 
        WarningSign2.setOpaque(false);

        JButton OKButton1 = new JButton();
        OKButton1.setBackground(new Color(250,66,27));
        OKButton1.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton1.setBounds(300, 170, 80, 40);
        OKButton1.setFocusable(false);

        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassLg.dispose(); 
            }
        });
        PassLg.add(PassLQuestionMark );
        PassLg.add(LengthN);
        PassLg.add(OKButton1);
        PassLg.add(WarningSign2);
        PassLg.setVisible(true);
    }
    
    public void NumbersO(){//Numbers Only
        Border NumberOFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame NumO = new JFrame("Invalid Character");
        NumO.setBackground(Color.BLACK);
        ImageIcon WarningLogo3 = new ImageIcon("WARNINGLOGO.png");
        NumO.setIconImage(WarningLogo3.getImage());
        NumO.getContentPane().setBackground(Color.BLACK);
        NumO.setLayout(null);
        NumO.setSize(700, 300);
        NumO.setLocationRelativeTo(null);
        NumO.getRootPane().setBorder(NumberOFrameBorder);

        JLabel NumOQuestionMark = new JLabel();
        NumOQuestionMark.setText("INVALID");
        NumOQuestionMark.setForeground(new Color(238, 130, 238));
        NumOQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        NumOQuestionMark.setBounds(270, 50, 150, 50); 
        
        JLabel NumOL = new JLabel();
        NumOL.setText("Please Input Numbers Only");
        NumOL.setForeground(Color.WHITE);
        NumOL.setFont(new Font("Monocraft", Font.BOLD, 15));
        NumOL.setBounds(270, 100, 400, 50);

        JLabel WarningSign3 = new JLabel();
        ImageIcon WarningSignIcon3 = new ImageIcon("WARNINGSIGN.png");
        WarningSign3.setIcon(WarningSignIcon3);
        WarningSign3.setBounds(50, 50, 153, 151); 
        WarningSign3.setOpaque(false);

        JButton OKButton2 = new JButton();
        OKButton2.setBackground(new Color(250,66,27));
        OKButton2.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton2.setBounds(300, 170, 80, 40);
        OKButton2.setFocusable(false);

        OKButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NumO.dispose(); 
            }
        });
        NumO.add(NumOQuestionMark);
        NumO.add(NumOL);
        NumO.add(WarningSign3);
        NumO.add(OKButton2);
        NumO.setVisible(true);
    }

    public void Att(){ // Number of Attempts
        Border AttemptsFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame ATT = new JFrame("Attempts Notice");
        ATT.setBackground(Color.BLACK);
        ImageIcon WarningLogo4 = new ImageIcon("WARNINGLOGO.png");
        ATT.setIconImage(WarningLogo4.getImage());
        ATT.getContentPane().setBackground(Color.BLACK);
        ATT.setLayout(null);
        ATT.setSize(700, 300);
        ATT.setLocationRelativeTo(null);
        ATT.getRootPane().setBorder(AttemptsFrameBorder);

        JLabel ATTQuestionMark = new JLabel();
        ATTQuestionMark.setText("ATTEMPTS");
        ATTQuestionMark.setForeground(new Color(238, 130, 238));
        ATTQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        ATTQuestionMark.setBounds(270, 50, 150, 50);

        JLabel ATTR = new JLabel();
        ATTR.setText("Attempts Left: " + ATTEMPTS);
        ATTR.setForeground(Color.WHITE);
        ATTR.setFont(new Font("Monocraft", Font.BOLD, 15));
        ATTR.setBounds(270, 100, 400, 50);

        JLabel WarningSign4 = new JLabel();
        ImageIcon WarningSignIcon4 = new ImageIcon("WARNINGSIGN.png");
        WarningSign4.setIcon(WarningSignIcon4);
        WarningSign4.setBounds(50, 50, 153, 151); 
        WarningSign4.setOpaque(false);

        JButton OKButton3 = new JButton();
        OKButton3.setBackground(new Color(250,66,27));
        OKButton3.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton3.setBounds(300, 170, 80, 40);
        OKButton3.setFocusable(false);

        OKButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATT.dispose(); 
            }
        });
        ATT.add(ATTQuestionMark);
        ATT.add(ATTR);
        ATT.add(WarningSign4);
        ATT.add(OKButton3);
        ATT.setVisible(true);
    }
    public void LogInSuccessful(){ // Log In Successful
        Border LISFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame LIS = new JFrame("LOGIN SUCCESSFUL");
        LIS.setBackground(Color.BLACK);
        ImageIcon CheckLogo = new ImageIcon("CHECK-removebg-preview.png");
        LIS.setIconImage(CheckLogo.getImage());
        LIS.getContentPane().setBackground(Color.BLACK);
        LIS.setLayout(null);
        LIS.setSize(700, 300);
        LIS.setLocationRelativeTo(null);
        LIS.getRootPane().setBorder(LISFrameBorder);

        JLabel LISCELEB = new JLabel();
        LISCELEB.setText("SUCCESSFUL");
        LISCELEB.setForeground(new Color(111, 255, 5));
        LISCELEB.setFont(new Font("Monocraft", Font.BOLD, 40));
        LISCELEB.setBounds(270, 50, 150, 50);

        JLabel LISCONGRATS = new JLabel();
        LISCONGRATS.setText("PIN Correct, Logging In...");
        LISCONGRATS.setForeground(Color.WHITE);
        LISCONGRATS.setFont(new Font("Monocraft", Font.BOLD, 15));
        LISCONGRATS.setBounds(270, 100, 400, 50);

        JLabel LikeSign = new JLabel();
        ImageIcon LikeSignIcon = new ImageIcon("LIKE.png");
        LikeSign.setIcon(LikeSignIcon);
        LikeSign.setBounds(50, 50, 153, 151); 
        LikeSign.setOpaque(false);

        JButton OKButton4 = new JButton();
        OKButton4.setBackground(new Color(250,66,27));
        OKButton4.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton4.setBounds(300, 170, 80, 40);
        OKButton4.setFocusable(false);

        OKButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LIS.dispose();
                TransAvail(); 
            }
        });
        LIS.add(LISCELEB);
        LIS.add(LISCONGRATS);
        LIS.add(LikeSign);
        LIS.add(OKButton4);
        LIS.setVisible(true);

    }


    public void TransAvail(){
        JFrame TransactionsFrame = new JFrame();
        JLabel ForFrame = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        TransactionsFrame.setIconImage(logo.getImage());
        TransactionsFrame.setResizable(false);
        TransactionsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TransactionsFrame.setSize(1500, 880);
        TransactionsFrame.setLocationRelativeTo(null);

        ImageIcon TransactionsFrameBg = new ImageIcon("MAINBG.png");
        Image TransactionsFrameBgIcon = TransactionsFrameBg.getImage().getScaledInstance(TransactionsFrame.getWidth(), TransactionsFrame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon1 = new ImageIcon(TransactionsFrameBgIcon);
        ForFrame .setIcon(scaledImageIcon1);
        TransactionsFrame.setContentPane(label);
        TransactionsFrame.setVisible(true);
    }

}


