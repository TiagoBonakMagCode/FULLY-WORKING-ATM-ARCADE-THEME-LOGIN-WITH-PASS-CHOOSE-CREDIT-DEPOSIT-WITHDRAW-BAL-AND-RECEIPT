import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
    JFrame frame;
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
    JFrame frame2;
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
    JToggleButton EyeButton1;    

    private static final int MAX_PASSWORD_LENGTH = 6;
    public static double SavingBalance1 = 3000.0;
    public static double CurrentBalance1 = 3000.0;
    public static double SavingBalance2 = 3000.0;
    public static double CurrentBalance2 = 3000.0;

    
    JProgressBar pbarstart = new JProgressBar(5, 100);
    Timer t;

    int i = 0;
    int ATTEMPTS = 3;
    int ATTEMPTS1 = 3;
    final String CorrectPass1 = "123456";
    final String CorrectPass2 = "654321";

    Font myFont = new Font("Monocraft",Font.BOLD,20);

    LoadingScreen() {
        frame = new JFrame("ARCADE'S GOLD RESERVE");
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
                    pbarstart.setValue(0);
                    startLoading();
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

        frame2 = new JFrame("ARCADE'S GOLD RESERVE");
        ImageIcon ToBeChange = new ImageIcon("LOGO.png");
        frame2.setIconImage(ToBeChange.getImage());
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setSize(1500, 900);
        frame2.setLocationRelativeTo(null);
        frame2.setContentPane(label2);
        frame2.setVisible(false);
        MainMenuBackButton();

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
        Playbutton2();
        EyeButton1();
       
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
        backButton1.setBounds(150,360, 86, 43);
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
                    ACC1PASS.setText("");
                    
                }
            }
        });      
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                if (a.getSource() == backButton2){
                    frame2.setVisible(true);
                    LogInFrame.setVisible(false);
                    ACC2PASS.setText(""); 
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
        ACC1PASS.setBounds(130,290,248,40);
        ACC1PASS.setFont(myFont);
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
        ACC2PASS.setFont(myFont);
        ACC2PASS.setHorizontalAlignment(JPasswordField.CENTER);
        ImageIcon loginPane2Icon1 = new ImageIcon("BOARDPANE.png");
        JLabel loginPane2Label1 = new JLabel(loginPane2Icon1);
        loginPane2Label1.setLayout(null); 
        loginPane2Label1.setBounds(0, 0, loginPane2Icon1.getIconWidth(), loginPane2Icon1.getIconHeight());
        loginPane2Label1.setBackground(Color.BLACK);
        loginPane2Label1.setOpaque(false);
        LogInPanel2.add(loginPane2Label1);

    }
    public void Playbutton1(){
        JButton PLYButton = new JButton();
        ImageIcon PLYButtonIcon = new ImageIcon("PLAYBUTTON.png");
        PLYButton.setIcon(PLYButtonIcon);
        PLYButton.setBounds(260,360, 93, 45);
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
                String password = ACC1PASS.getText();
                if (password.isEmpty()) {
                    EmptyField(); 
                    ATTEMPTS--; 
                } else if (password.length() > 6) {
                    PassL();
                    ACC1PASS.setText(""); 
                    ATTEMPTS--; 
                } else if (password.equals(CorrectPass1)) {
                    LogInSuccessful(); 
                } else if (!password.equals(CorrectPass1)){
                    INCPASS();
                    ACC1PASS.setText(""); 
                    ATTEMPTS--; 
                }
            }
        });
        LogInPanel1.add(PLYButton);
    }        
    public void EyeButton(){
        EyeButton = new JToggleButton(new ImageIcon("AASDASDAD.png"));
        EyeButton.setOpaque(false);
        EyeButton.setBounds(90,295,30,30);
        EyeButton.setBackground(new Color(216, 159, 114));
        EyeButton.setPreferredSize(new Dimension(30,30));
        EyeButton.setBorderPainted(false);
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
                        String currentPassword = new String(ACC1PASS.getPassword());
                        if (currentPassword.length() < MAX_PASSWORD_LENGTH) {
                            String newPass = currentPassword + String.valueOf(digit);
                            ACC1PASS.setText(newPass);
                        } else {
                            PassL();
                            ATTEMPTS--; 
                            if (ATTEMPTS <= 0) {
                                GameOver(); 
                            }
                            ACC1PASS.setText(""); 
                        }      
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
                    String currentPassword = new String(ACC1PASS.getPassword());
                    if (currentPassword.length() < MAX_PASSWORD_LENGTH) {
                        String newPass = currentPassword + "0";
                        ACC1PASS.setText(newPass);
                     } else{
                        ATTEMPTS--;
                        PassL();
                        ACC1PASS.setText("");
                    }
                    if (ATTEMPTS <= 0) {
                        GameOver(); 

                    }
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
    public void Playbutton2(){
        JButton PLYButton2 = new JButton();
        ImageIcon PLYButtonIcon2 = new ImageIcon("PLAYBUTTON.png");
        PLYButton2.setIcon(PLYButtonIcon2);
        PLYButton2.setBounds(260,360, 93, 45);
        PLYButton2.setLayout(null);
        PLYButton2.setBackground(Color.BLACK);
        PLYButton2.setOpaque(false);
        
        
        ACC2PASS.addKeyListener(new KeyListener() {
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
        PLYButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password1 = ACC2PASS.getText();
                if (password1.isEmpty()) {
                    EmptyField2(); 
                    ATTEMPTS1--; 
                } else if (password1.length() > 6) {
                    PassL2();
                    ACC2PASS.setText(""); 
                    ATTEMPTS1--; 
                } else if (password1.equals(CorrectPass2)) {
                    LogInSuccessful1(); 
                } else if (!password1.equals(CorrectPass2)){
                    INCPASS2();
                    ACC2PASS.setText(""); 
                    ATTEMPTS1--; 
                }
            }
        });
        LogInPanel2.add(PLYButton2);
    }        

    public void EyeButton1(){
        EyeButton1 = new JToggleButton(new ImageIcon("AASDASDAD.png"));
        EyeButton1.setOpaque(false);
        EyeButton1.setBounds(85,295,30,30);
        EyeButton1.setBackground(new Color(216, 159, 114));
        EyeButton1.setPreferredSize(new Dimension(30,30));
        EyeButton1.setBorderPainted(false);
        EyeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EyeButton1.isSelected()) {
                    ACC2PASS.setEchoChar((char) 0);
                    ACC2PASS.setVisible(true); 
                } else {
                    ACC2PASS.setEchoChar('•'); 
                }
            }
        });
        LogInPanel2.add(EyeButton1);
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
                        String currentPassword1 = new String(ACC2PASS.getPassword());
                        if (currentPassword1.length() < MAX_PASSWORD_LENGTH) {
                            String newPass1 = currentPassword1 + String.valueOf(digit);
                            ACC1PASS.setText(newPass1);
                        ACC2PASS.setText(newPass1);
                    } else {
                            PassL2();
                            ATTEMPTS1--; 
                            if (ATTEMPTS1 <= 0) {
                                GameOver2(); 
                            }
                            ACC2PASS.setText(""); 
                        }
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
                    String currentPassword1 = new String(ACC2PASS.getPassword());
                    if (currentPassword1.length() < MAX_PASSWORD_LENGTH) {
                    String newPass1 = currentPassword1 + "0";
                    ACC2PASS.setText(newPass1);
                } else{
                    PassL2();
                    ATTEMPTS1--;
                    ACC2PASS.setText("");
                }
            
                if (ATTEMPTS <= 0) {
                    GameOver2(); 
                }
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
        ExitFrame.setResizable(false);
        
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
        EmptyQuestionMark.setText("FIELD EMPTY!");
        EmptyQuestionMark.setForeground(new Color(255,0,0));
        EmptyQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        EmptyQuestionMark.setBounds(270, 50, 500, 50); 
        
        JLabel ProvidePIN = new JLabel();
        ProvidePIN.setText("Please provide a PIN.");
        ProvidePIN.setForeground(Color.WHITE);
        ProvidePIN.setFont(new Font("Monocraft", Font.BOLD, 15));
        ProvidePIN.setBounds(270, 100, 400, 50);

        JLabel WarningSign1 = new JLabel();
        ImageIcon WarningSignIcon1 = new ImageIcon("WARNINGSIGN.png");
        WarningSign1.setIcon(WarningSignIcon1);
        WarningSign1.setBounds(50, 50, 153, 151); 
        WarningSign1.setOpaque(false);

        JButton OKButton = new JButton();
        OKButton.setBackground(new Color(153,255,51));
        OKButton.setText("OK");
        OKButton.setForeground(Color.BLACK);
        OKButton.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton.setBounds(390, 170, 80, 40);
        OKButton.setFocusable(false);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empty.dispose();
                Att(); 
            if (ATTEMPTS == 0){
                }
            }
            
        });
        Empty.add(EmptyQuestionMark);
        Empty.add(ProvidePIN);
        Empty.add(OKButton);
        Empty.add(WarningSign1);
        Empty.setVisible(true);
       
    }

    public void EmptyField2(){//empty field
        Border EmptyFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame Empty2 = new JFrame("Empty Field Notice");
        Empty2.setBackground(Color.BLACK);
        ImageIcon WarningLogo2 = new ImageIcon("WARNINGLOGO.png");
        Empty2.setIconImage(WarningLogo2.getImage());
        Empty2.getContentPane().setBackground(Color.BLACK);
        Empty2.setLayout(null);
        Empty2.setSize(700, 300);
        Empty2.setLocationRelativeTo(null);
        Empty2.getRootPane().setBorder(EmptyFrameBorder2);

        JLabel EmptyQuestionMark2 = new JLabel();
        EmptyQuestionMark2.setText("FIELD EMPTY!");
        EmptyQuestionMark2.setForeground(new Color(255,0,0));
        EmptyQuestionMark2.setFont(new Font("Monocraft", Font.BOLD, 40));
        EmptyQuestionMark2.setBounds(270, 50, 500, 50); 
        
        JLabel ProvidePIN2 = new JLabel();
        ProvidePIN2.setText("Please provide a PIN.");
        ProvidePIN2.setForeground(Color.WHITE);
        ProvidePIN2.setFont(new Font("Monocraft", Font.BOLD, 15));
        ProvidePIN2.setBounds(270, 100, 400, 50);

        JLabel WarningSign2 = new JLabel();
        ImageIcon WarningSignIcon2 = new ImageIcon("WARNINGSIGN.png");
        WarningSign2.setIcon(WarningSignIcon2);
        WarningSign2.setBounds(50, 50, 153, 151); 
        WarningSign2.setOpaque(false);

        JButton OKButton12 = new JButton();
        OKButton12.setBackground(new Color(153,255,51));
        OKButton12.setText("OK");
        OKButton12.setForeground(Color.BLACK);
        OKButton12.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton12.setBounds(390, 170, 80, 40);
        OKButton12.setFocusable(false);

        OKButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empty2.dispose();
                Att2(); 
            if (ATTEMPTS1 == 0){
                }
            }
            
        });
        Empty2.add(EmptyQuestionMark2);
        Empty2.add(ProvidePIN2);
        Empty2.add(OKButton12);
        Empty2.add(WarningSign2);
        Empty2.setVisible(true);
       
    }
    public void PassL(){//pass length limit
        Border PassLFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame PassLg = new JFrame("PIN Length Limit Reached Notice");
        PassLg.setBackground(Color.BLACK);
        ImageIcon WarningLogo2 = new ImageIcon("WARNINGLOGO.png");
        PassLg.setIconImage(WarningLogo2.getImage());
        PassLg.getContentPane().setBackground(Color.BLACK);
        PassLg.setLayout(null);
        PassLg.setSize(700, 300);
        PassLg.setLocationRelativeTo(null);
        PassLg.getRootPane().setBorder(PassLFrameBorder);
        PassLg.setResizable(false);

        JLabel PassLQuestionMark = new JLabel();
        PassLQuestionMark.setText("LIMIT REACHED!");
        PassLQuestionMark.setForeground(new Color(255,0,0));
        PassLQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        PassLQuestionMark.setBounds(270, 50, 500, 50);
        
        JLabel LengthN = new JLabel();
        LengthN.setText("PIN must contain 6 Characters Only.");
        LengthN.setForeground(Color.WHITE);
        LengthN.setFont(new Font("Monocraft", Font.BOLD, 15));
        LengthN.setBounds(270, 100, 400, 50);

        JLabel WarningSign2 = new JLabel();
        ImageIcon WarningSignIcon2 = new ImageIcon("WARNINGSIGN.png");
        WarningSign2.setIcon(WarningSignIcon2);
        WarningSign2.setBounds(50, 50, 153, 151); 
        WarningSign2.setOpaque(false);

        JButton OKButton1 = new JButton();
        OKButton1.setBackground(new Color(153,255,51));
        OKButton1.setText("OK");
        OKButton1.setForeground(Color.BLACK);
        OKButton1.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton1.setBounds(390, 170, 80, 40);
        OKButton1.setFocusable(false);

        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassLg.dispose(); 
                Att();
            }
        });
        PassLg.add(PassLQuestionMark );
        PassLg.add(LengthN);
        PassLg.add(OKButton1);
        PassLg.add(WarningSign2);
        PassLg.setVisible(true);
    }
    public void PassL2(){//pass length limit
        Border PassLFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame PassLg2 = new JFrame("PIN Length Limit Reached Notice");
        PassLg2.setBackground(Color.BLACK);
        ImageIcon WarningLogo12 = new ImageIcon("WARNINGLOGO.png");
        PassLg2.setIconImage(WarningLogo12.getImage());
        PassLg2.getContentPane().setBackground(Color.BLACK);
        PassLg2.setLayout(null);
        PassLg2.setSize(700, 300);
        PassLg2.setLocationRelativeTo(null);
        PassLg2.getRootPane().setBorder(PassLFrameBorder2);
        PassLg2.setResizable(false);

        JLabel PassLQuestionMark2 = new JLabel();
        PassLQuestionMark2.setText("LIMIT REACHED!");
        PassLQuestionMark2.setForeground(new Color(255,0,0));
        PassLQuestionMark2.setFont(new Font("Monocraft", Font.BOLD, 40));
        PassLQuestionMark2.setBounds(270, 50, 500, 50);
        
        JLabel LengthN2 = new JLabel();
        LengthN2.setText("PIN must contain 6 Characters Only.");
        LengthN2.setForeground(Color.WHITE);
        LengthN2.setFont(new Font("Monocraft", Font.BOLD, 15));
        LengthN2.setBounds(270, 100, 400, 50);

        JLabel WarningSign12 = new JLabel();
        ImageIcon WarningSignIcon12 = new ImageIcon("WARNINGSIGN.png");
        WarningSign12.setIcon(WarningSignIcon12);
        WarningSign12.setBounds(50, 50, 153, 151); 
        WarningSign12.setOpaque(false);

        JButton OKButton13 = new JButton();
        OKButton13.setBackground(new Color(153,255,51));
        OKButton13.setText("OK");
        OKButton13.setForeground(Color.BLACK);
        OKButton13.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton13.setBounds(390, 170, 80, 40);
        OKButton13.setFocusable(false);

        OKButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassLg2.dispose(); 
                Att2();
            }
        });
        PassLg2.add(PassLQuestionMark2 );
        PassLg2.add(LengthN2);
        PassLg2.add(OKButton13);
        PassLg2.add(WarningSign12);
        PassLg2.setVisible(true);
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
        ATT.setResizable(false);

        JLabel ATTQuestionMark = new JLabel();
        ATTQuestionMark.setText("ATTEMPTS");
        ATTQuestionMark.setForeground(new Color(238, 130, 238));
        ATTQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        ATTQuestionMark.setBounds(270, 50, 500, 50);

        JLabel ATTR = new JLabel();
        ATTR.setText("ATTEMPTS LEFT: " + ATTEMPTS);
        ATTR.setForeground(Color.WHITE);
        ATTR.setFont(new Font("Monocraft", Font.BOLD, 15));
        ATTR.setBounds(270, 100, 400, 50);

        JLabel WarningSign4 = new JLabel();
        ImageIcon WarningSignIcon4 = new ImageIcon("WARNINGSIGN.png");
        WarningSign4.setIcon(WarningSignIcon4);
        WarningSign4.setBounds(50, 50, 153, 151); 
        WarningSign4.setOpaque(false);

        JButton OKButton3 = new JButton();
        OKButton3.setBackground(new Color(153,255,51));
        OKButton3.setText("OK");
        OKButton3.setForeground(Color.BLACK);
        OKButton3.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton3.setBounds(390, 170, 80, 40);
        OKButton3.setFocusable(false);

        OKButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATT.dispose();
                if (ATTEMPTS == 0) {
                    LogInFrame.setVisible(false);
                    GameOver();
                }
            }
        });          
        ATT.add(ATTQuestionMark);
        ATT.add(ATTR);
        ATT.add(WarningSign4);
        ATT.add(OKButton3);
        ATT.setVisible(true);
    }
    public void Att2(){ // Number of Attempts
        Border AttemptsFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame ATT2 = new JFrame("Attempts Notice");
        ATT2.setBackground(Color.BLACK);
        ImageIcon WarningLogo14 = new ImageIcon("WARNINGLOGO.png");
        ATT2.setIconImage(WarningLogo14.getImage());
        ATT2.getContentPane().setBackground(Color.BLACK);
        ATT2.setLayout(null);
        ATT2.setSize(700, 300);
        ATT2.setLocationRelativeTo(null);
        ATT2.getRootPane().setBorder(AttemptsFrameBorder2);
        ATT2.setResizable(false); 

        JLabel ATTQuestionMark2 = new JLabel();
        ATTQuestionMark2.setText("ATTEMPTS");
        ATTQuestionMark2.setForeground(new Color(238, 130, 238));
        ATTQuestionMark2.setFont(new Font("Monocraft", Font.BOLD, 40));
        ATTQuestionMark2.setBounds(270, 50, 500, 50);

        JLabel ATTR2 = new JLabel();
        ATTR2.setText("ATTEMPTS LEFT: " + ATTEMPTS1);
        ATTR2.setForeground(Color.WHITE);
        ATTR2.setFont(new Font("Monocraft", Font.BOLD, 15));
        ATTR2.setBounds(270, 100, 400, 50);

        JLabel WarningSign14 = new JLabel();
        ImageIcon WarningSignIcon14 = new ImageIcon("WARNINGSIGN.png");
        WarningSign14.setIcon(WarningSignIcon14);
        WarningSign14.setBounds(50, 50, 153, 151); 
        WarningSign14.setOpaque(false);

        JButton OKButton14 = new JButton();
        OKButton14.setBackground(new Color(153,255,51));
        OKButton14.setText("OK");
        OKButton14.setForeground(Color.BLACK);
        OKButton14.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton14.setBounds(390, 170, 80, 40);
        OKButton14.setFocusable(false);

        OKButton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATT2.dispose();
                if (ATTEMPTS1 == 0) {
                    LogInFrame2.setVisible(false);
                    GameOver2();
                }
            }
        });          
        ATT2.add(ATTQuestionMark2);
        ATT2.add(ATTR2);
        ATT2.add(WarningSign14);
        ATT2.add(OKButton14);
        ATT2.setVisible(true);
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
        LIS.setResizable(false);

        JLabel LISCELEB = new JLabel();
        LISCELEB.setText("PIN Correct!");
        LISCELEB.setForeground(new Color(111, 255, 5));
        LISCELEB.setFont(new Font("Monocraft", Font.BOLD, 40));
        LISCELEB.setBounds(270, 50, 500, 50);

        JLabel LISCONGRATS = new JLabel();
        LISCONGRATS.setText("Logging In...");
        LISCONGRATS.setForeground(Color.WHITE);
        LISCONGRATS.setFont(new Font("Monocraft", Font.BOLD, 15));
        LISCONGRATS.setBounds(270, 100, 400, 50);

        JLabel LikeSign = new JLabel();
        ImageIcon LikeSignIcon = new ImageIcon("LIKE.png");
        LikeSign.setIcon(LikeSignIcon);
        LikeSign.setBounds(50, 50, 153, 151); 
        LikeSign.setOpaque(false);

        JButton OKButton4 = new JButton();
        OKButton4.setBackground(new Color(153,255,51));
        OKButton4.setText("OK");
        OKButton4.setForeground(Color.BLACK);
        OKButton4.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton4.setBounds(390, 170, 80, 40);
        OKButton4.setFocusable(false);

        OKButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LIS.dispose();
                LogInFrame.setVisible(false);
                TransAvail(); 
            }
        });
        LIS.add(LISCELEB);
        LIS.add(LISCONGRATS);
        LIS.add(LikeSign);
        LIS.add(OKButton4);
        LIS.setVisible(true);

    }
    public void LogInSuccessful1(){ // Log In Successful
        Border LISFrameBorder1 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame LIS1 = new JFrame("LOGIN SUCCESSFUL");
        LIS1.setBackground(Color.BLACK);
        ImageIcon CheckLogo1 = new ImageIcon("CHECK-removebg-preview.png");
        LIS1.setIconImage(CheckLogo1.getImage());
        LIS1.getContentPane().setBackground(Color.BLACK);
        LIS1.setLayout(null);
        LIS1.setSize(700, 300);
        LIS1.setLocationRelativeTo(null);
        LIS1.getRootPane().setBorder(LISFrameBorder1);
        LIS1.setResizable(false);

        JLabel LISCELEB1 = new JLabel();
        LISCELEB1.setText("PIN Correct!");
        LISCELEB1.setForeground(new Color(111, 255, 5));
        LISCELEB1.setFont(new Font("Monocraft", Font.BOLD, 40));
        LISCELEB1.setBounds(270, 50, 500, 50);

        JLabel LISCONGRATS1 = new JLabel();
        LISCONGRATS1.setText("Logging In...");
        LISCONGRATS1.setForeground(Color.WHITE);
        LISCONGRATS1.setFont(new Font("Monocraft", Font.BOLD, 15));
        LISCONGRATS1.setBounds(270, 100, 400, 50);

        JLabel LikeSign1 = new JLabel();
        ImageIcon LikeSignIcon1 = new ImageIcon("LIKE.png");
        LikeSign1.setIcon(LikeSignIcon1);
        LikeSign1.setBounds(50, 50, 153, 151); 
        LikeSign1.setOpaque(false);

        JButton OKButton15 = new JButton();
        OKButton15.setBackground(new Color(153,255,51));
        OKButton15.setText("OK");
        OKButton15.setForeground(Color.BLACK);
        OKButton15.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton15.setBounds(390, 170, 80, 40);
        OKButton15.setFocusable(false);

        OKButton15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LIS1.dispose();
                LogInFrame2.setVisible(false);
                TransAvail2(); 
            }
        });
        LIS1.add(LISCELEB1);
        LIS1.add(LISCONGRATS1);
        LIS1.add(LikeSign1);
        LIS1.add(OKButton15);
        LIS1.setVisible(true);
    }
    
    public void INCPASS(){
        Border INcFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame INCFrame = new JFrame("Incorrect PIN");
        INCFrame.setBackground(Color.BLACK);
        ImageIcon CheckLogo = new ImageIcon("XSIGN-removebg-preview.png");
        INCFrame.setIconImage(CheckLogo.getImage());
        INCFrame.getContentPane().setBackground(Color.BLACK);
        INCFrame.setLayout(null);
        INCFrame.setSize(700, 300);
        INCFrame.setLocationRelativeTo(null);
        INCFrame.getRootPane().setBorder(INcFrameBorder);
        INCFrame.setResizable(false);

        JLabel INCL = new JLabel();
        INCL.setText("INVALID!");
        INCL.setForeground(new Color(255,0,0));
        INCL.setFont(new Font("Monocraft", Font.BOLD, 40));
        INCL.setBounds(270, 50, 500, 50);

        JLabel INCL2 = new JLabel();
        INCL2.setText("Incorrect PIN");
        INCL2.setForeground(Color.WHITE);
        INCL2.setFont(new Font("Monocraft", Font.BOLD, 15));
        INCL2.setBounds(270, 100, 400, 50);

        JLabel INCL3 = new JLabel();
        ImageIcon INC3ICON= new ImageIcon("XSIGNbnw.png");
        INCL3.setIcon(INC3ICON);
        INCL3.setBounds(60, 50, 153, 151); 
        INCL3.setOpaque(false);

        JButton OKButton5 = new JButton();
        OKButton5.setBackground(new Color(153,255,51));
        OKButton5.setText("OK");
        OKButton5.setForeground(Color.BLACK);
        OKButton5.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton5.setBounds(390, 170, 80, 40);
        OKButton5.setFocusable(false);

        OKButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INCFrame.dispose();
                Att();
            }
        });
        INCFrame.add(INCL);
        INCFrame.add(INCL2);
        INCFrame.add(INCL3);
        INCFrame.add(OKButton5);
        INCFrame.setVisible(true);
    }
    public void INCPASS2(){
        Border INcFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame INCFrame2 = new JFrame("Incorrect PIN");
        INCFrame2.setBackground(Color.BLACK);
        ImageIcon CheckLogo2 = new ImageIcon("XSIGN-removebg-preview.png");
        INCFrame2.setIconImage(CheckLogo2.getImage());
        INCFrame2.getContentPane().setBackground(Color.BLACK);
        INCFrame2.setLayout(null);
        INCFrame2.setSize(700, 300);
        INCFrame2.setLocationRelativeTo(null);
        INCFrame2.getRootPane().setBorder(INcFrameBorder2);
        INCFrame2.setResizable(false);

        JLabel INCL2 = new JLabel();
        INCL2.setText("INVALID!");
        INCL2.setForeground(new Color(255,0,0));
        INCL2.setFont(new Font("Monocraft", Font.BOLD, 40));
        INCL2.setBounds(270, 50, 500, 50);

        JLabel INCL12 = new JLabel();
        INCL12.setText("Incorrect PIN");
        INCL12.setForeground(Color.WHITE);
        INCL12.setFont(new Font("Monocraft", Font.BOLD, 15));
        INCL12.setBounds(270, 100, 400, 50);

        JLabel INCL13 = new JLabel();
        ImageIcon INC13ICON= new ImageIcon("XSIGNbnw.png");
        INCL13.setIcon(INC13ICON);
        INCL13.setBounds(60, 50, 153, 151); 
        INCL13.setOpaque(false);

        JButton OKButton16 = new JButton();
        OKButton16.setBackground(new Color(153,255,51));
        OKButton16.setText("OK");
        OKButton16.setForeground(Color.BLACK);
        OKButton16.setFont(new Font("Monocraft",Font.BOLD,15));
        OKButton16.setBounds(390, 170, 80, 40);
        OKButton16.setFocusable(false);

        OKButton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INCFrame2.dispose();
                Att2();
            }
        });
        INCFrame2.add(INCL2);
        INCFrame2.add(INCL12);
        INCFrame2.add(INCL13);
        INCFrame2.add(OKButton16);
        INCFrame2.setVisible(true);
    }
    public void GameOver() {
        Border GOFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame GameOverFrame = new JFrame("GAME OVER");
        GameOverFrame.setBackground(Color.BLACK);
        ImageIcon CheckLogo = new ImageIcon("SKULL.png");
        GameOverFrame.setIconImage(CheckLogo.getImage());
        ImageIcon GameOverFrameBG = new ImageIcon("GAMEOVERBG.png");
        JLabel background = new JLabel(GameOverFrameBG);
        background.setBounds(0, 0, 500, 400);
        GameOverFrame.setContentPane(background);
        GameOverFrame.setLayout(null);
        GameOverFrame.setSize(1500, 900);
        GameOverFrame.setLocationRelativeTo(null);
        GameOverFrame.getRootPane().setBorder(GOFrameBorder);
        GameOverFrame.setResizable(false);
    
        JButton OKButton5 = new JButton();
        OKButton5.setBackground(Color.BLACK);
        OKButton5.setText("EXIT");
        OKButton5.setFont(new Font("Monocraft", Font.BOLD, 15));
        OKButton5.setForeground(Color.WHITE);
        OKButton5.setBounds(670, 690, 150, 40);
        OKButton5.setFocusable(false);
        OKButton5.setFocusPainted(false);
        OKButton5.setBorderPainted(false);
        OKButton5.setBorder(null);
    
        OKButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameOverFrame.dispose();
                System.exit(0);
            }
        });
        GameOverFrame.add(OKButton5);
        GameOverFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GameOverFrame.setVisible(true);
    }
    public void GameOver2() {
        Border GOFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame GameOverFrame2 = new JFrame("GAME OVER");
        GameOverFrame2.setBackground(Color.BLACK);
        ImageIcon CheckLogo12 = new ImageIcon("SKULL.png");
        GameOverFrame2.setIconImage(CheckLogo12.getImage());
        ImageIcon GameOverFrameBG2 = new ImageIcon("GAMEOVERBG.png");
        JLabel background2 = new JLabel(GameOverFrameBG2);
        background2.setBounds(0, 0, 500, 400);
        GameOverFrame2.setContentPane(background2);
        GameOverFrame2.setLayout(null);
        GameOverFrame2.setSize(1500, 900);
        GameOverFrame2.setLocationRelativeTo(null);
        GameOverFrame2.getRootPane().setBorder(GOFrameBorder2);
        GameOverFrame2.setResizable(false);
    
        JButton OKButton17 = new JButton();
        OKButton17.setBackground(Color.BLACK);
        OKButton17.setText("EXIT");
        OKButton17.setFont(new Font("Monocraft", Font.BOLD, 15));
        OKButton17.setForeground(Color.WHITE);
        OKButton17.setBounds(670, 690, 150, 40);
        OKButton17.setFocusable(false);
    
        OKButton17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameOverFrame2.dispose();
                System.exit(0);
            }
        });
        GameOverFrame2.add(OKButton17);
        GameOverFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GameOverFrame2.setVisible(true);
    }
    public void MainMenuBackButton() {
        JButton MainMenuBackB = new JButton();
        ImageIcon MainMenuBackBIcon = new ImageIcon("MENUBUTTON.png");
        MainMenuBackB.setIcon(MainMenuBackBIcon);
        MainMenuBackB.setBorder(null);
        MainMenuBackB.setBorderPainted(false);
        MainMenuBackB.setFocusPainted(false);
        MainMenuBackB.setBounds(20, 15, 100, 50);
        MainMenuBackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                frame.setVisible(true);
                frame2.setVisible(false);
                startingButton.setVisible(true);
                pbarstart.setVisible(false);
                exitButton.setVisible(true);
                pbarstart.setValue(0);
                startingButton.setEnabled(true);
            }
        });
        frame2.add(MainMenuBackB);
    }
    public void startLoading() {
        startingButton.setEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pbarstart.setValue(i);
                }
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        }).start();
    }

    public void TransAvail(){
        JFrame TransactionsFrame = new JFrame("TRANSACTION MENU");
        JLabel ForFrame = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        TransactionsFrame.setIconImage(logo.getImage());
        TransactionsFrame.setResizable(false);
        TransactionsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TransactionsFrame.setSize(1500, 880);
        TransactionsFrame.setLocationRelativeTo(null);

        ImageIcon TransactionsFrameBg = new ImageIcon("TRANSACTIONSBG.png");
        Image TransactionsFrameBgIcon = TransactionsFrameBg.getImage().getScaledInstance(TransactionsFrame.getWidth(), TransactionsFrame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon1 = new ImageIcon(TransactionsFrameBgIcon);
        ForFrame .setIcon(scaledImageIcon1);
        TransactionsFrame.setContentPane(ForFrame);
        TransactionsFrame.setVisible(true);

        JButton DepositButton = new JButton();
        DepositButton.setBackground(Color.BLACK);
        DepositButton.setBorder(null);
        DepositButton.setBorderPainted(false);
        DepositButton.setFocusPainted(false);
        DepositButton.setText("DEPOSIT");
        DepositButton.setFont(new Font("Monocraft", Font.BOLD, 50));
        DepositButton.setForeground(Color.CYAN);
        DepositButton.setBounds(130,700,300,50);
        DepositButton.setOpaque(false);
        DepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositButton);
                TransactionsFrame.setVisible(false);
                DEPOSITCHOICE();
            }
        });

        JButton WITHDRAWButton = new JButton();
        WITHDRAWButton.setBackground(Color.BLACK);
        WITHDRAWButton.setBorder(null);
        WITHDRAWButton.setBorderPainted(false);
        WITHDRAWButton.setFocusPainted(false);
        WITHDRAWButton.setText("WITHDRAW");
        WITHDRAWButton.setFont(new Font("Monocraft", Font.BOLD, 50));
        WITHDRAWButton.setForeground(Color.CYAN);
        WITHDRAWButton.setBounds(615,700,300,50);
        WITHDRAWButton.setOpaque(false);
        WITHDRAWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WITHDRAWButton);
                TransactionsFrame.setVisible(false);
                WITHDRAWCHOICE();
            }
        });

        JButton BALANCEButton = new JButton();
        BALANCEButton.setBackground(Color.BLACK);
        BALANCEButton.setBorder(null);
        BALANCEButton.setBorderPainted(false);
        BALANCEButton.setFocusPainted(false);
        BALANCEButton.setText("SAVINGS");
        BALANCEButton.setFont(new Font("Monocraft", Font.BOLD, 50));
        BALANCEButton.setForeground(Color.CYAN);
        BALANCEButton.setBounds(1090,700,300,50);
        BALANCEButton.setOpaque(false);
        BALANCEButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == BALANCEButton);
                TransactionsFrame.setVisible(false);
                TOTAlBALANCE();
            }
        });
        
        JButton CANCELBUTTON = new JButton();
        CANCELBUTTON.setBackground(Color.BLACK);
        CANCELBUTTON.setBorder(null);
        CANCELBUTTON.setBorderPainted(false);
        CANCELBUTTON.setFocusPainted(false);
        CANCELBUTTON.setText("EXIT");
        CANCELBUTTON.setFont(new Font("Monocraft", Font.BOLD, 35));
        CANCELBUTTON.setForeground(Color.RED);
        CANCELBUTTON.setBounds(75,45,100,35);
        CANCELBUTTON.setOpaque(false);
        CANCELBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == CANCELBUTTON);
                Exit();
            }
        });

        TransactionsFrame.add(DepositButton);
        TransactionsFrame.add(WITHDRAWButton);
        TransactionsFrame.add(BALANCEButton);
        TransactionsFrame.add(CANCELBUTTON);

    }

    public void TOTAlBALANCE(){
        JFrame TOTALBALANCEFRAME = new JFrame("TOTAL BALANCE");
        JLabel ForTOTALBALANCE = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        TOTALBALANCEFRAME.setIconImage(logo.getImage());
        TOTALBALANCEFRAME.setResizable(false);
        TOTALBALANCEFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TOTALBALANCEFRAME.setSize(1500, 880);
        TOTALBALANCEFRAME.setLocationRelativeTo(null);

        ImageIcon TOTALBALANCEFrameBg = new ImageIcon("TOTALBALANCEBG.png");
        Image TOTALBALANCEFrameBgIcon = TOTALBALANCEFrameBg.getImage().getScaledInstance(TOTALBALANCEFRAME.getWidth(), TOTALBALANCEFRAME.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITCHOICEscaledImageIcon1 = new ImageIcon(TOTALBALANCEFrameBgIcon);
        ForTOTALBALANCE .setIcon(DEPOSITCHOICEscaledImageIcon1);
        TOTALBALANCEFRAME.setContentPane(ForTOTALBALANCE);
        TOTALBALANCEFRAME.setVisible(true);

        JLabel ShowCURRENT = new JLabel();
        ShowCURRENT.setText("" + CurrentBalance1);
        ShowCURRENT.setFont(new Font("Monocraft",Font.BOLD,70));
        ShowCURRENT.setBounds(700,230,500,300);
        ShowCURRENT.setForeground(new Color(255,255,0));

        JLabel ShowSAVINGS= new JLabel();
        ShowSAVINGS.setText("" + SavingBalance1);
        ShowSAVINGS.setFont(new Font("Monocraft",Font.BOLD,70));
        ShowSAVINGS.setBounds(700,540,500,300);
        ShowSAVINGS.setForeground(new Color(255,255,0));


        JButton BALANCEBACKBUTTON = new JButton("BACK");
        BALANCEBACKBUTTON .setBounds(45,38,100,35);
        BALANCEBACKBUTTON .setBorder(null);
        BALANCEBACKBUTTON .setBorderPainted(false);
        BALANCEBACKBUTTON .setFocusPainted(false);
        BALANCEBACKBUTTON .setFont(new Font("Monocraft", Font.BOLD, 35));
        BALANCEBACKBUTTON .setBackground(Color.BLACK);
        BALANCEBACKBUTTON .setForeground(Color.PINK);
        BALANCEBACKBUTTON .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() ==  BALANCEBACKBUTTON );
                TOTALBALANCEFRAME.setVisible(false);
                TransAvail();
            }
        });
        TOTALBALANCEFRAME.add(ShowCURRENT);
        TOTALBALANCEFRAME.add(ShowSAVINGS);
        TOTALBALANCEFRAME.add( BALANCEBACKBUTTON );

    }

    public void DEPOSITCHOICE(){
        JFrame DEPOSITCHOICE = new JFrame("DEPOSIT CHOICE");
        JLabel ForDEPOSITCHOICE = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        DEPOSITCHOICE.setIconImage(logo.getImage());
        DEPOSITCHOICE.setResizable(false);
        DEPOSITCHOICE.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DEPOSITCHOICE.setSize(1500, 880);
        DEPOSITCHOICE.setLocationRelativeTo(null);

        ImageIcon DEPOSITCHOICEFrameBg = new ImageIcon("DEPOSITOPTIONBG.png");
        Image DEPOSITCHOICEFrameBgIcon = DEPOSITCHOICEFrameBg.getImage().getScaledInstance(DEPOSITCHOICE.getWidth(), DEPOSITCHOICE.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITCHOICEscaledImageIcon1 = new ImageIcon(DEPOSITCHOICEFrameBgIcon);
        ForDEPOSITCHOICE .setIcon(DEPOSITCHOICEscaledImageIcon1);
        DEPOSITCHOICE.setContentPane(ForDEPOSITCHOICE);
        DEPOSITCHOICE.setVisible(true);
        
        JButton DEPOSITCHOICECANCELBUTTON = new JButton();
        DEPOSITCHOICECANCELBUTTON.setBackground(Color.BLACK);
        DEPOSITCHOICECANCELBUTTON.setBorder(null);
        DEPOSITCHOICECANCELBUTTON.setBorderPainted(false);
        DEPOSITCHOICECANCELBUTTON.setFocusPainted(false);
        DEPOSITCHOICECANCELBUTTON.setText("EXIT");
        DEPOSITCHOICECANCELBUTTON.setFont(new Font("Monocraft", Font.BOLD, 35));
        DEPOSITCHOICECANCELBUTTON.setForeground(Color.RED);
        DEPOSITCHOICECANCELBUTTON.setBounds(75,45,100,35);
        DEPOSITCHOICECANCELBUTTON.setOpaque(false);
        DEPOSITCHOICECANCELBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == DEPOSITCHOICECANCELBUTTON);
                Exit();
            }
        });

        JButton DEPOSITCHOICEBACKBUTTON = new JButton("BACK");
        DEPOSITCHOICEBACKBUTTON.setBounds(1310,38,100,35);
        DEPOSITCHOICEBACKBUTTON.setBorder(null);
        DEPOSITCHOICEBACKBUTTON.setBorderPainted(false);
        DEPOSITCHOICEBACKBUTTON.setFocusPainted(false);
        DEPOSITCHOICEBACKBUTTON.setFont(new Font("Monocraft", Font.BOLD, 35));
        DEPOSITCHOICEBACKBUTTON.setBackground(Color.BLACK);
        DEPOSITCHOICEBACKBUTTON.setForeground(Color.PINK);
        DEPOSITCHOICEBACKBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == DEPOSITCHOICEBACKBUTTON);
                DEPOSITCHOICE.setVisible(false);
                TransAvail();
            }
        });

        JButton SAVINGSBUTTONDEPOSIT = new JButton("SAVINGS");
        SAVINGSBUTTONDEPOSIT.setBounds(820,620,400,35);
        SAVINGSBUTTONDEPOSIT.setBorder(null);
        SAVINGSBUTTONDEPOSIT.setBorderPainted(false);
        SAVINGSBUTTONDEPOSIT.setFocusPainted(false);
        SAVINGSBUTTONDEPOSIT.setFont(new Font("Monocraft", Font.BOLD, 50));
        SAVINGSBUTTONDEPOSIT.setBackground(Color.BLACK);
        SAVINGSBUTTONDEPOSIT.setForeground(new Color(255,255,0));
        SAVINGSBUTTONDEPOSIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SAVINGSBUTTONDEPOSIT);
                DEPOSITCHOICE.setVisible(false);
                FORDEPOSITFRAMESAVINGS();
            }
        });

        JButton CURRENTBUTTONDEPOSIT = new JButton("CURRENT");
        CURRENTBUTTONDEPOSIT.setBounds(260,620,400,35);
        CURRENTBUTTONDEPOSIT.setBorder(null);
        CURRENTBUTTONDEPOSIT.setBorderPainted(false);
        CURRENTBUTTONDEPOSIT.setFocusPainted(false);
        CURRENTBUTTONDEPOSIT.setFont(new Font("Monocraft", Font.BOLD, 50));
        CURRENTBUTTONDEPOSIT.setBackground(Color.BLACK);
        CURRENTBUTTONDEPOSIT.setForeground(new Color(255,255,0));
        CURRENTBUTTONDEPOSIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == CURRENTBUTTONDEPOSIT);
                DEPOSITCHOICE.setVisible(false);
                FORDEPOSITFRAMECURRENT();
            }
        });

        DEPOSITCHOICE.add(DEPOSITCHOICEBACKBUTTON);
        DEPOSITCHOICE.add(DEPOSITCHOICECANCELBUTTON);
        DEPOSITCHOICE.add(SAVINGSBUTTONDEPOSIT);
        DEPOSITCHOICE.add(CURRENTBUTTONDEPOSIT);


}
    public void WITHDRAWCHOICE(){
        JFrame WITHDRAWCHOICE = new JFrame("WITHDRAW CHOICE");
        JLabel ForWITHDRAWCHOICE = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        WITHDRAWCHOICE.setIconImage(logo.getImage());
        WITHDRAWCHOICE.setResizable(false);
        WITHDRAWCHOICE.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WITHDRAWCHOICE.setSize(1500, 880);
        WITHDRAWCHOICE.setLocationRelativeTo(null);

        ImageIcon WITHDRAWCHOICEFrameBg = new ImageIcon("WITHDRAWOPTIONBG.png");
        Image WITHDRAWCHOICEFrameBgIcon = WITHDRAWCHOICEFrameBg.getImage().getScaledInstance(WITHDRAWCHOICE.getWidth(), WITHDRAWCHOICE.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon WITHDRAWCHOICEscaledImageIcon1 = new ImageIcon(WITHDRAWCHOICEFrameBgIcon);
        ForWITHDRAWCHOICE .setIcon(WITHDRAWCHOICEscaledImageIcon1);
        WITHDRAWCHOICE.setContentPane(ForWITHDRAWCHOICE);
        WITHDRAWCHOICE.setVisible(true);

        JButton WITHDRAWCHOICECANCELBUTTON = new JButton();
        WITHDRAWCHOICECANCELBUTTON.setBackground(Color.BLACK);
        WITHDRAWCHOICECANCELBUTTON.setBorder(null);
        WITHDRAWCHOICECANCELBUTTON.setBorderPainted(false);
        WITHDRAWCHOICECANCELBUTTON.setFocusPainted(false);
        WITHDRAWCHOICECANCELBUTTON.setText("EXIT");
        WITHDRAWCHOICECANCELBUTTON.setFont(new Font("Monocraft", Font.BOLD, 35));
        WITHDRAWCHOICECANCELBUTTON.setForeground(Color.RED);
        WITHDRAWCHOICECANCELBUTTON.setBounds(75,45,100,35);
        WITHDRAWCHOICECANCELBUTTON.setOpaque(false);
        WITHDRAWCHOICECANCELBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == WITHDRAWCHOICECANCELBUTTON);
                Exit();
            }
        });

        JButton WITHDRAWCHOICEBACKBUTTON = new JButton("BACK");
        WITHDRAWCHOICEBACKBUTTON.setBounds(1310,38,100,35);
        WITHDRAWCHOICEBACKBUTTON.setBorder(null);
        WITHDRAWCHOICEBACKBUTTON.setBorderPainted(false);
        WITHDRAWCHOICEBACKBUTTON.setFocusPainted(false);
        WITHDRAWCHOICEBACKBUTTON.setFont(new Font("Monocraft", Font.BOLD, 35));
        WITHDRAWCHOICEBACKBUTTON.setBackground(Color.BLACK);
        WITHDRAWCHOICEBACKBUTTON.setForeground(Color.PINK);
        WITHDRAWCHOICEBACKBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == WITHDRAWCHOICEBACKBUTTON);
                WITHDRAWCHOICE.setVisible(false);
                TransAvail();
            }
        });
        JButton SAVINGSBUTTONWITHDRAW = new JButton("SAVINGS");
        SAVINGSBUTTONWITHDRAW.setBounds(820,620,400,35);
        SAVINGSBUTTONWITHDRAW.setBorder(null);
        SAVINGSBUTTONWITHDRAW.setBorderPainted(false);
        SAVINGSBUTTONWITHDRAW.setFocusPainted(false);
        SAVINGSBUTTONWITHDRAW.setFont(new Font("Monocraft", Font.BOLD, 50));
        SAVINGSBUTTONWITHDRAW.setBackground(Color.BLACK);
        SAVINGSBUTTONWITHDRAW.setForeground(new Color(255,255,0));
        SAVINGSBUTTONWITHDRAW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SAVINGSBUTTONWITHDRAW);
                WITHDRAWCHOICE.setVisible(false);
                FORWIHTDRAWFRAMESAVINGS();
            }
        });

        JButton CURRENTBUTTONWITHDRAW = new JButton("CURRENT");
        CURRENTBUTTONWITHDRAW.setBounds(260,620,400,35);
        CURRENTBUTTONWITHDRAW.setBorder(null);
        CURRENTBUTTONWITHDRAW.setBorderPainted(false);
        CURRENTBUTTONWITHDRAW.setFocusPainted(false);
        CURRENTBUTTONWITHDRAW.setFont(new Font("Monocraft", Font.BOLD, 50));
        CURRENTBUTTONWITHDRAW.setBackground(Color.BLACK);
        CURRENTBUTTONWITHDRAW.setForeground(new Color(255,255,0));
        CURRENTBUTTONWITHDRAW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == CURRENTBUTTONWITHDRAW);
                WITHDRAWCHOICE.setVisible(false);
                FORWIHTDRAWFRAMECURRENT();
            }
        });
        WITHDRAWCHOICE.add(SAVINGSBUTTONWITHDRAW);
        WITHDRAWCHOICE.add(CURRENTBUTTONWITHDRAW);
        WITHDRAWCHOICE.add(WITHDRAWCHOICEBACKBUTTON);
        WITHDRAWCHOICE.add(WITHDRAWCHOICECANCELBUTTON);
    }

    public void FORDEPOSITFRAMECURRENT(){
        JFrame DEPOSITFRAME = new JFrame("DEPOSIT");
        JLabel DEPOSITFRAMELABEL = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        DEPOSITFRAME.setIconImage(logo.getImage());
        DEPOSITFRAME.setResizable(false);
        DEPOSITFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DEPOSITFRAME.setSize(1500, 880);
        DEPOSITFRAME.setLocationRelativeTo(null);

        ImageIcon DEPOSITFRAMEBg = new ImageIcon("DEPOSITBG.png");
        Image DEPOSITFRAMEBgIcon = DEPOSITFRAMEBg.getImage().getScaledInstance(DEPOSITFRAME.getWidth(), DEPOSITFRAME.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITFRAMEscaledImageIcon1 = new ImageIcon(DEPOSITFRAMEBgIcon);
        DEPOSITFRAMELABEL .setIcon(DEPOSITFRAMEscaledImageIcon1);
        DEPOSITFRAME.setContentPane(DEPOSITFRAMELABEL);
        DEPOSITFRAME.setVisible(true);

        JTextField ENTERDEPOSITAMOUNT = new JTextField();
        ENTERDEPOSITAMOUNT.setBackground(new Color(0,153,153));
        ENTERDEPOSITAMOUNT.setForeground(Color.WHITE);
        ENTERDEPOSITAMOUNT.setFont(new Font("Monocraft", Font.BOLD,25));
        ENTERDEPOSITAMOUNT.setHorizontalAlignment(JTextField.CENTER);
        ENTERDEPOSITAMOUNT.setBounds(520, 270 ,500,50);
        ENTERDEPOSITAMOUNT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton DepositOption1 = new JButton("200");
        DepositOption1.setBounds(490,370,150,70);
        DepositOption1.setFocusPainted(false);
        DepositOption1.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption1.setBackground(new Color(0,153,153));
        DepositOption1.setForeground(Color.WHITE);
        DepositOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption1);
                ENTERDEPOSITAMOUNT.setText("200");
            }
        });

        JButton DepositOption2 = new JButton("500");
        DepositOption2.setBounds(695,370,150,70);
        DepositOption2.setFocusPainted(false);
        DepositOption2.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption2.setBackground(new Color(0,153,153));
        DepositOption2.setForeground(Color.WHITE);
        DepositOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption2);
                ENTERDEPOSITAMOUNT.setText("500");
            }
        });

        JButton DepositOption3 = new JButton("700");
        DepositOption3.setBounds(900,370,150,70);
        DepositOption3.setFocusPainted(false);
        DepositOption3.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption3.setBackground(new Color(0,153,153));
        DepositOption3.setForeground(Color.WHITE);
        DepositOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption3);
                ENTERDEPOSITAMOUNT.setText("700");
            }
        });

        JButton DepositOption4 = new JButton("1000");
        DepositOption4.setBounds(490,470,150,70);
        DepositOption4.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption4.setBackground(new Color(0,153,153));
        DepositOption4.setForeground(Color.WHITE);
        DepositOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption4);
                ENTERDEPOSITAMOUNT.setText("1000");
            }
        });

        JButton DepositOption5 = new JButton("1500");
        DepositOption5.setBounds(695,470,150,70);
        DepositOption5.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption5.setBackground(new Color(0,153,153));
        DepositOption5.setForeground(Color.WHITE);
        DepositOption5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption5);
                ENTERDEPOSITAMOUNT.setText("1500");
            }
        });

        JButton DepositOption6 = new JButton("2000");
        DepositOption6.setBounds(900,470,150,70);
        DepositOption6.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption6.setBackground(new Color(0,153,153));
        DepositOption6.setForeground(Color.WHITE);
        DepositOption6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption6);
                ENTERDEPOSITAMOUNT.setText("2000");
            }
        });

        JButton DEPOSITENTERBUTTON = new JButton("ENTER");
        DEPOSITENTERBUTTON.setBounds(900,570,150,70);
        DEPOSITENTERBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        DEPOSITENTERBUTTON.setBackground(new Color(0,204,0));
        DEPOSITENTERBUTTON.setForeground(Color.BLACK);
        DEPOSITENTERBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double DepositAmount = Double.parseDouble(ENTERDEPOSITAMOUNT.getText());
                    CurrentBalance1 += DepositAmount;
                    DepositSuccessful();
                } catch (NumberFormatException ex) {
                    EmptyFieldDeposit();
                }
            }
        });

        JButton DEPOSITBACKBUTTON = new JButton("CANCEL");
        DEPOSITBACKBUTTON.setBounds(490,570,150,70);
        DEPOSITBACKBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        DEPOSITBACKBUTTON.setBackground(new Color(204,0,0));
        DEPOSITBACKBUTTON.setForeground(Color.BLACK);
        DEPOSITBACKBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == DEPOSITBACKBUTTON);
                DEPOSITFRAME.setVisible(false);
                DEPOSITCHOICE();
            }
        });

        JButton DEPOSITCLEARBUTTON = new JButton("CLEAR");
        DEPOSITCLEARBUTTON.setBounds(695,570,150,70);
        DEPOSITCLEARBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        DEPOSITCLEARBUTTON.setBackground(new Color(204,204,0));
        DEPOSITCLEARBUTTON.setForeground(Color.BLACK);
        DEPOSITCLEARBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DEPOSITCLEARBUTTON);
                ENTERDEPOSITAMOUNT.setText("");
            }
        });

        DEPOSITFRAME.add(ENTERDEPOSITAMOUNT);
        DEPOSITFRAME.add(DepositOption1);
        DEPOSITFRAME.add(DepositOption2);
        DEPOSITFRAME.add(DepositOption3);
        DEPOSITFRAME.add(DepositOption4);
        DEPOSITFRAME.add(DepositOption5);
        DEPOSITFRAME.add(DepositOption6);
        DEPOSITFRAME.add(DEPOSITENTERBUTTON);
        DEPOSITFRAME.add(DEPOSITBACKBUTTON);
        DEPOSITFRAME.add(DEPOSITCLEARBUTTON);



    }

    public void FORDEPOSITFRAMESAVINGS(){
        JFrame DEPOSITFRAME1 = new JFrame("DEPOSIT");
        JLabel DEPOSITFRAMELABEL1 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        DEPOSITFRAME1.setIconImage(logo.getImage());
        DEPOSITFRAME1.setResizable(false);
        DEPOSITFRAME1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DEPOSITFRAME1.setSize(1500, 880);
        DEPOSITFRAME1.setLocationRelativeTo(null);

        ImageIcon DEPOSITFRAMEBg1 = new ImageIcon("DEPOSITBG.png");
        Image DEPOSITFRAMEBgIcon1 = DEPOSITFRAMEBg1.getImage().getScaledInstance(DEPOSITFRAME1.getWidth(), DEPOSITFRAME1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITFRAMEscaledImageIcon11 = new ImageIcon(DEPOSITFRAMEBgIcon1);
        DEPOSITFRAMELABEL1 .setIcon(DEPOSITFRAMEscaledImageIcon11);
        DEPOSITFRAME1.setContentPane(DEPOSITFRAMELABEL1);
        DEPOSITFRAME1.setVisible(true);

        JTextField ENTERDEPOSITAMOUNT1 = new JTextField();
        ENTERDEPOSITAMOUNT1.setBackground(new Color(0,153,153));
        ENTERDEPOSITAMOUNT1.setForeground(Color.WHITE);
        ENTERDEPOSITAMOUNT1.setFont(new Font("Monocraft", Font.BOLD,25));
        ENTERDEPOSITAMOUNT1.setHorizontalAlignment(JTextField.CENTER);
        ENTERDEPOSITAMOUNT1.setBounds(520, 270 ,500,50);
        ENTERDEPOSITAMOUNT1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton SDepositOption1 = new JButton("200");
        SDepositOption1.setBounds(490,370,150,70);
        SDepositOption1.setFocusPainted(false);
        SDepositOption1.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption1.setBackground(new Color(0,153,153));
        SDepositOption1.setForeground(Color.WHITE);
        SDepositOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption1);
                ENTERDEPOSITAMOUNT1.setText("200");
            }
        });

        JButton SDepositOption2 = new JButton("500");
        SDepositOption2.setBounds(695,370,150,70);
        SDepositOption2.setFocusPainted(false);
        SDepositOption2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption2.setBackground(new Color(0,153,153));
        SDepositOption2.setForeground(Color.WHITE);
        SDepositOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption2);
                ENTERDEPOSITAMOUNT1.setText("500");
            }
        });

        JButton SDepositOption3 = new JButton("700");
        SDepositOption3.setBounds(900,370,150,70);
        SDepositOption3.setFocusPainted(false);
        SDepositOption3.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption3.setBackground(new Color(0,153,153));
        SDepositOption3.setForeground(Color.WHITE);
        SDepositOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption3);
                ENTERDEPOSITAMOUNT1.setText("700");
            }
        });

        JButton SDepositOption4 = new JButton("1000");
        SDepositOption4.setBounds(490,470,150,70);
        SDepositOption4.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption4.setBackground(new Color(0,153,153));
        SDepositOption4.setForeground(Color.WHITE);
        SDepositOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption4);
                ENTERDEPOSITAMOUNT1.setText("1000");
            }
        });

        JButton SDepositOption5 = new JButton("1500");
        SDepositOption5.setBounds(695,470,150,70);
        SDepositOption5.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption5.setBackground(new Color(0,153,153));
        SDepositOption5.setForeground(Color.WHITE);
        SDepositOption5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption5);
                ENTERDEPOSITAMOUNT1.setText("1500");
            }
        });

        JButton SDepositOption6 = new JButton("2000");
        SDepositOption6.setBounds(900,470,150,70);
        SDepositOption6.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption6.setBackground(new Color(0,153,153));
        SDepositOption6.setForeground(Color.WHITE);
        SDepositOption6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption6);
                ENTERDEPOSITAMOUNT1.setText("2000");
            }
        });

        JButton SDEPOSITENTERBUTTON = new JButton("ENTER");
        SDEPOSITENTERBUTTON.setBounds(900,570,150,70);
        SDEPOSITENTERBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDEPOSITENTERBUTTON.setBackground(new Color(0,204,0));
        SDEPOSITENTERBUTTON.setForeground(Color.BLACK);
        SDEPOSITENTERBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double DepositAmount1 = Double.parseDouble(ENTERDEPOSITAMOUNT1.getText());
                    SavingBalance1 += DepositAmount1;
                    DepositSuccessful();
                } catch (NumberFormatException ex) {
                    EmptyFieldDeposit();
                }
            }
        });

        JButton SDEPOSITBACKBUTTON = new JButton("CANCEL");
        SDEPOSITBACKBUTTON.setBounds(490,570,150,70);
        SDEPOSITBACKBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDEPOSITBACKBUTTON.setBackground(new Color(204,0,0));
        SDEPOSITBACKBUTTON.setForeground(Color.BLACK);
        SDEPOSITBACKBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SDEPOSITBACKBUTTON);
                DEPOSITFRAME1.setVisible(false);
                DEPOSITCHOICE();
            }
        });

        JButton SDEPOSITCLEARBUTTON = new JButton("CLEAR");
        SDEPOSITCLEARBUTTON.setBounds(695,570,150,70);
        SDEPOSITCLEARBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDEPOSITCLEARBUTTON.setBackground(new Color(204,204,0));
        SDEPOSITCLEARBUTTON.setForeground(Color.BLACK);
        SDEPOSITCLEARBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDEPOSITCLEARBUTTON);
                ENTERDEPOSITAMOUNT1.setText("");
            }
        });

        DEPOSITFRAME1.add(ENTERDEPOSITAMOUNT1);
        DEPOSITFRAME1.add(SDepositOption1);
        DEPOSITFRAME1.add(SDepositOption2);
        DEPOSITFRAME1.add(SDepositOption3);
        DEPOSITFRAME1.add(SDepositOption4);
        DEPOSITFRAME1.add(SDepositOption5);
        DEPOSITFRAME1.add(SDepositOption6);
        DEPOSITFRAME1.add(SDEPOSITENTERBUTTON);
        DEPOSITFRAME1.add(SDEPOSITBACKBUTTON);
        DEPOSITFRAME1.add(SDEPOSITCLEARBUTTON);
    }


    public void FORWIHTDRAWFRAMECURRENT(){ 
        JFrame WITHDRAWFRAME = new JFrame("WITHDRAW");
        JLabel WITHDRAWFRAMELABEL = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        WITHDRAWFRAME.setIconImage(logo.getImage());
        WITHDRAWFRAME.setResizable(false);
        WITHDRAWFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WITHDRAWFRAME.setSize(1500, 880);
        WITHDRAWFRAME.setLocationRelativeTo(null);

        ImageIcon WITHDRAWFRAMEBg = new ImageIcon("WITHDRAWBG.png");
        Image WITHDRAWFRAMEBgIcon = WITHDRAWFRAMEBg.getImage().getScaledInstance(WITHDRAWFRAME.getWidth(), WITHDRAWFRAME.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon WITHDRAWFRAMEscaledImageIcon1 = new ImageIcon(WITHDRAWFRAMEBgIcon);
        WITHDRAWFRAMELABEL .setIcon(WITHDRAWFRAMEscaledImageIcon1);
        WITHDRAWFRAME.setContentPane(WITHDRAWFRAMELABEL);
        WITHDRAWFRAME.setVisible(true);

        JTextField ENTERWITHDRAWAMOUNT = new JTextField();
        ENTERWITHDRAWAMOUNT.setBackground(new Color(0,153,153));
        ENTERWITHDRAWAMOUNT.setForeground(Color.WHITE);
        ENTERWITHDRAWAMOUNT.setFont(new Font("Monocraft", Font.BOLD,25));
        ENTERWITHDRAWAMOUNT.setHorizontalAlignment(JTextField.CENTER);
        ENTERWITHDRAWAMOUNT.setBounds(520, 270 ,500,50);
        ENTERWITHDRAWAMOUNT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton WithdrawOption1 = new JButton("200");
        WithdrawOption1.setBounds(490,370,150,70);
        WithdrawOption1.setFocusPainted(false);
        WithdrawOption1.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption1.setBackground(new Color(0,153,153));
        WithdrawOption1.setForeground(Color.WHITE);
        WithdrawOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption1);
                ENTERWITHDRAWAMOUNT.setText("200");
            }
        });

        JButton WithdrawOption2 = new JButton("500");
        WithdrawOption2.setBounds(695,370,150,70);
        WithdrawOption2.setFocusPainted(false);
        WithdrawOption2.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption2.setBackground(new Color(0,153,153));
        WithdrawOption2.setForeground(Color.WHITE);
        WithdrawOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption2);
                ENTERWITHDRAWAMOUNT.setText("500");
            }
        });

        JButton WithdrawOption3 = new JButton("700");
        WithdrawOption3.setBounds(900,370,150,70);
        WithdrawOption3.setFocusPainted(false);
        WithdrawOption3.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption3.setBackground(new Color(0,153,153));
        WithdrawOption3.setForeground(Color.WHITE);
        WithdrawOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption3);
                ENTERWITHDRAWAMOUNT.setText("700");
            }
        });

        JButton WithdrawOption4 = new JButton("1000");
        WithdrawOption4.setBounds(490,470,150,70);
        WithdrawOption4.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption4.setBackground(new Color(0,153,153));
        WithdrawOption4.setForeground(Color.WHITE);
        WithdrawOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption4);
                ENTERWITHDRAWAMOUNT.setText("1000");
            }
        });

        JButton WithdrawOption5 = new JButton("1500");
        WithdrawOption5.setBounds(695,470,150,70);
        WithdrawOption5.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption5.setBackground(new Color(0,153,153));
        WithdrawOption5.setForeground(Color.WHITE);
        WithdrawOption5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption5);
                ENTERWITHDRAWAMOUNT.setText("1500");
            }
        });

        JButton WithdrawOption6 = new JButton("2000");
        WithdrawOption6.setBounds(900,470,150,70);
        WithdrawOption6.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption6.setBackground(new Color(0,153,153));
        WithdrawOption6.setForeground(Color.WHITE);
        WithdrawOption6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption6);
                ENTERWITHDRAWAMOUNT.setText("2000");
            }
        });

        JButton WITHDRAWENTERBUTTON = new JButton("ENTER");
        WITHDRAWENTERBUTTON .setBounds(900,570,150,70);
        WITHDRAWENTERBUTTON .setFont(new Font("Monocraft", Font.BOLD, 25));
        WITHDRAWENTERBUTTON .setBackground(new Color(0,204,0));
        WITHDRAWENTERBUTTON .setForeground(Color.BLACK);
        WITHDRAWENTERBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawalAmount = Double.parseDouble(ENTERWITHDRAWAMOUNT.getText());
                    if (withdrawalAmount <= CurrentBalance1) {
                        CurrentBalance1 -= withdrawalAmount;
                        DepositSuccessful();
                    } else {
                        INSUFFICIENTBALANCE();
                    }
                } catch (NumberFormatException ex) {
                    EmptyFieldDeposit();
                }
            }
        });
        

        JButton WITHDRAWBACKBUTTON = new JButton("CANCEL");
        WITHDRAWBACKBUTTON.setBounds(490,570,150,70);
        WITHDRAWBACKBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        WITHDRAWBACKBUTTON.setBackground(new Color(204,0,0));
        WITHDRAWBACKBUTTON.setForeground(Color.BLACK);
        WITHDRAWBACKBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == WITHDRAWBACKBUTTON);
                WITHDRAWFRAME.setVisible(false);
                WITHDRAWCHOICE();
            }
        });

        JButton WITHDRAWCLEARBUTTON = new JButton("CLEAR");
        WITHDRAWCLEARBUTTON.setBounds(695,570,150,70);
        WITHDRAWCLEARBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        WITHDRAWCLEARBUTTON.setBackground(new Color(204,204,0));
        WITHDRAWCLEARBUTTON.setForeground(Color.BLACK);
        WITHDRAWCLEARBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WITHDRAWCLEARBUTTON);
                ENTERWITHDRAWAMOUNT.setText("");
            }
        });

        WITHDRAWFRAME.add(ENTERWITHDRAWAMOUNT);
        WITHDRAWFRAME.add(WithdrawOption1);
        WITHDRAWFRAME.add(WithdrawOption2);
        WITHDRAWFRAME.add(WithdrawOption3);
        WITHDRAWFRAME.add(WithdrawOption4);
        WITHDRAWFRAME.add(WithdrawOption5);
        WITHDRAWFRAME.add(WithdrawOption6);
        WITHDRAWFRAME.add(WITHDRAWENTERBUTTON);
        WITHDRAWFRAME.add(WITHDRAWBACKBUTTON);
        WITHDRAWFRAME.add(WITHDRAWCLEARBUTTON);
    }

    public void FORWIHTDRAWFRAMESAVINGS(){ 
        JFrame SWITHDRAWFRAME = new JFrame("WITHDRAW");
        JLabel SWITHDRAWFRAMELABEL = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        SWITHDRAWFRAME.setIconImage(logo.getImage());
        SWITHDRAWFRAME.setResizable(false);
        SWITHDRAWFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SWITHDRAWFRAME.setSize(1500, 880);
        SWITHDRAWFRAME.setLocationRelativeTo(null);

        ImageIcon SWITHDRAWFRAMEBg = new ImageIcon("WITHDRAWBG.png");
        Image SWITHDRAWFRAMEBgIcon = SWITHDRAWFRAMEBg.getImage().getScaledInstance(SWITHDRAWFRAME.getWidth(), SWITHDRAWFRAME.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon WITHDRAWFRAMEscaledImageIcon1 = new ImageIcon(SWITHDRAWFRAMEBgIcon);
        SWITHDRAWFRAMELABEL .setIcon(WITHDRAWFRAMEscaledImageIcon1);
        SWITHDRAWFRAME.setContentPane(SWITHDRAWFRAMELABEL);
        SWITHDRAWFRAME.setVisible(true);

        JTextField SENTERWITHDRAWAMOUNT = new JTextField();
        SENTERWITHDRAWAMOUNT.setBackground(new Color(0,153,153));
        SENTERWITHDRAWAMOUNT.setForeground(Color.WHITE);
        SENTERWITHDRAWAMOUNT.setFont(new Font("Monocraft", Font.BOLD,25));
        SENTERWITHDRAWAMOUNT.setHorizontalAlignment(JTextField.CENTER);
        SENTERWITHDRAWAMOUNT.setBounds(520, 270 ,500,50);
        SENTERWITHDRAWAMOUNT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton SWithdrawOption1 = new JButton("200");
        SWithdrawOption1.setBounds(490,370,150,70);
        SWithdrawOption1.setFocusPainted(false);
        SWithdrawOption1.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption1.setBackground(new Color(0,153,153));
        SWithdrawOption1.setForeground(Color.WHITE);
        SWithdrawOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption1);
                SENTERWITHDRAWAMOUNT.setText("200");
            }
        });

        JButton SWithdrawOption2 = new JButton("500");
        SWithdrawOption2.setBounds(695,370,150,70);
        SWithdrawOption2.setFocusPainted(false);
        SWithdrawOption2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption2.setBackground(new Color(0,153,153));
        SWithdrawOption2.setForeground(Color.WHITE);
        SWithdrawOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption2);
                SENTERWITHDRAWAMOUNT.setText("500");
            }
        });

        JButton SWithdrawOption3 = new JButton("700");
        SWithdrawOption3.setBounds(900,370,150,70);
        SWithdrawOption3.setFocusPainted(false);
        SWithdrawOption3.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption3.setBackground(new Color(0,153,153));
        SWithdrawOption3.setForeground(Color.WHITE);
        SWithdrawOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption3);
                SENTERWITHDRAWAMOUNT.setText("700");
            }
        });

        JButton SWithdrawOption4 = new JButton("1000");
        SWithdrawOption4.setBounds(490,470,150,70);
        SWithdrawOption4.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption4.setBackground(new Color(0,153,153));
        SWithdrawOption4.setForeground(Color.WHITE);
        SWithdrawOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption4);
                SENTERWITHDRAWAMOUNT.setText("1000");
            }
        });

        JButton SWithdrawOption5 = new JButton("1500");
        SWithdrawOption5.setBounds(695,470,150,70);
        SWithdrawOption5.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption5.setBackground(new Color(0,153,153));
        SWithdrawOption5.setForeground(Color.WHITE);
        SWithdrawOption5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption5);
                SENTERWITHDRAWAMOUNT.setText("1500");
            }
        });

        JButton SWithdrawOption6 = new JButton("2000");
        SWithdrawOption6.setBounds(900,470,150,70);
        SWithdrawOption6.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption6.setBackground(new Color(0,153,153));
        SWithdrawOption6.setForeground(Color.WHITE);
        SWithdrawOption6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption6);
                SENTERWITHDRAWAMOUNT.setText("2000");
            }
        });

        JButton SWITHDRAWENTERBUTTON = new JButton("ENTER");
        SWITHDRAWENTERBUTTON .setBounds(900,570,150,70);
        SWITHDRAWENTERBUTTON .setFont(new Font("Monocraft", Font.BOLD, 25));
        SWITHDRAWENTERBUTTON .setBackground(new Color(0,204,0));
        SWITHDRAWENTERBUTTON .setForeground(Color.BLACK);
        SWITHDRAWENTERBUTTON.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double withdrawalAmount = Double.parseDouble(SENTERWITHDRAWAMOUNT.getText());
                        if (withdrawalAmount <= SavingBalance1) {
                            SavingBalance1 -= withdrawalAmount;
                            DepositSuccessful();
                        } else {
                            INSUFFICIENTBALANCE();
                        }
                    } catch (NumberFormatException ex) {
                        EmptyFieldDeposit();
                    }
                }
            });

        JButton SWITHDRAWBACKBUTTON = new JButton("CANCEL");
        SWITHDRAWBACKBUTTON.setBounds(490,570,150,70);
        SWITHDRAWBACKBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWITHDRAWBACKBUTTON.setBackground(new Color(204,0,0));
        SWITHDRAWBACKBUTTON.setForeground(Color.BLACK);
        SWITHDRAWBACKBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SWITHDRAWBACKBUTTON);
                SWITHDRAWFRAME.setVisible(false);
                WITHDRAWCHOICE();
            }
        });

        JButton SWITHDRAWCLEARBUTTON = new JButton("CLEAR");
        SWITHDRAWCLEARBUTTON.setBounds(695,570,150,70);
        SWITHDRAWCLEARBUTTON.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWITHDRAWCLEARBUTTON.setBackground(new Color(204,204,0));
        SWITHDRAWCLEARBUTTON.setForeground(Color.BLACK);
        SWITHDRAWCLEARBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWITHDRAWCLEARBUTTON);
                SENTERWITHDRAWAMOUNT.setText("");
            }
        });

        SWITHDRAWFRAME.add(SENTERWITHDRAWAMOUNT);
        SWITHDRAWFRAME.add(SWithdrawOption1);
        SWITHDRAWFRAME.add(SWithdrawOption2);
        SWITHDRAWFRAME.add(SWithdrawOption3);
        SWITHDRAWFRAME.add(SWithdrawOption4);
        SWITHDRAWFRAME.add(SWithdrawOption5);
        SWITHDRAWFRAME.add(SWithdrawOption6);
        SWITHDRAWFRAME.add(SWITHDRAWENTERBUTTON);
        SWITHDRAWFRAME.add(SWITHDRAWBACKBUTTON);
        SWITHDRAWFRAME.add(SWITHDRAWCLEARBUTTON);
    }


    public void EmptyFieldDeposit(){
        Border EmptyFieldDepositFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame EmptyFieldDeposit = new JFrame("Empty Field Notice");
        EmptyFieldDeposit.setBackground(Color.BLACK);
        ImageIcon WarningLogo1 = new ImageIcon("WARNINGLOGO.png");
        EmptyFieldDeposit.setIconImage(WarningLogo1.getImage());
        EmptyFieldDeposit.getContentPane().setBackground(Color.BLACK);
        EmptyFieldDeposit.setLayout(null);
        EmptyFieldDeposit.setSize(700, 300);
        EmptyFieldDeposit.setLocationRelativeTo(null);
        EmptyFieldDeposit.getRootPane().setBorder(EmptyFieldDepositFrameBorder);

        JLabel EmptyFieldDepositQuestionMark = new JLabel();
        EmptyFieldDepositQuestionMark.setText("FIELD EMPTY!");
        EmptyFieldDepositQuestionMark.setForeground(new Color(255,0,0));
        EmptyFieldDepositQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        EmptyFieldDepositQuestionMark.setBounds(270, 50, 500, 50); 
        
        JLabel EmptyFieldDepositProvide = new JLabel();
        EmptyFieldDepositProvide.setText("Please Enter Amount.");
        EmptyFieldDepositProvide.setForeground(Color.WHITE);
        EmptyFieldDepositProvide.setFont(new Font("Monocraft", Font.BOLD, 15));
        EmptyFieldDepositProvide.setBounds(270, 100, 400, 50);

        JLabel EmptyFieldDepositWarningSign1 = new JLabel();
        ImageIcon EmptyFieldDepositWarningSignIcon1 = new ImageIcon("WARNINGSIGN.png");
        EmptyFieldDepositWarningSign1.setIcon(EmptyFieldDepositWarningSignIcon1);
        EmptyFieldDepositWarningSign1.setBounds(50, 50, 153, 151); 
        EmptyFieldDepositWarningSign1.setOpaque(false);

        JButton EmptyFieldDepositOKButton = new JButton();
        EmptyFieldDepositOKButton.setBackground(new Color(153,255,51));
        EmptyFieldDepositOKButton.setText("OK");
        EmptyFieldDepositOKButton.setForeground(Color.BLACK);
        EmptyFieldDepositOKButton.setFont(new Font("Monocraft",Font.BOLD,15));
        EmptyFieldDepositOKButton.setBounds(390, 170, 80, 40);
        EmptyFieldDepositOKButton.setFocusable(false);

        EmptyFieldDepositOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmptyFieldDeposit.dispose();
                }   
        });
        EmptyFieldDeposit.add(EmptyFieldDepositQuestionMark);
        EmptyFieldDeposit.add(EmptyFieldDepositProvide);
        EmptyFieldDeposit.add(EmptyFieldDepositOKButton);
        EmptyFieldDeposit.add(EmptyFieldDepositWarningSign1);
        EmptyFieldDeposit.setVisible(true);
       
    }

    public void DepositSuccessful(){ // Log In Successful
        Border DSFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame DS= new JFrame("SUCCESSFUL DEPOSIT");
        DS.setBackground(Color.BLACK);
        ImageIcon CheckLogo = new ImageIcon("CHECK-removebg-preview.png");
        DS.setIconImage(CheckLogo.getImage());
        DS.getContentPane().setBackground(Color.BLACK);
        DS.setLayout(null);
        DS.setSize(700, 300);
        DS.setLocationRelativeTo(null);
        DS.getRootPane().setBorder(DSFrameBorder);
        DS.setResizable(false);

        JLabel DSCELEB = new JLabel();
        DSCELEB.setText("SUCESS!");
        DSCELEB.setForeground(new Color(111, 255, 5));
        DSCELEB.setFont(new Font("Monocraft", Font.BOLD, 50));
        DSCELEB.setBounds(270, 50, 500, 50);

        JLabel DSCONGRATS = new JLabel();
        DSCONGRATS.setText("<html><div style='line-height: 0.5;'>TOTAL CURRENT: " + CurrentBalance1 + "<br/>TOTAL SAVINGS: " + SavingBalance1 + "</div></html>");
        DSCONGRATS.setForeground(Color.WHITE);
        DSCONGRATS.setFont(new Font("Monocraft", Font.BOLD, 15));
        DSCONGRATS.setBounds(270, 120, 400, 50);

        JLabel DSLikeSign = new JLabel();
        ImageIcon DSLikeSignIcon = new ImageIcon("LIKE.png");
        DSLikeSign.setIcon(DSLikeSignIcon);
        DSLikeSign.setBounds(50, 50, 153, 151); 
        DSLikeSign.setOpaque(false);

        JButton DSOKButton = new JButton();
        DSOKButton.setBackground(new Color(153,255,51));
        DSOKButton.setText("OK");
        DSOKButton.setForeground(Color.BLACK);
        DSOKButton.setFont(new Font("Monocraft",Font.BOLD,15));
        DSOKButton.setBounds(390, 190, 80, 40);
        DSOKButton.setFocusable(false);

        DSOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DS.dispose();
            }
        });
        DS.add(DSCELEB);
        DS.add(DSCONGRATS);
        DS.add(DSLikeSign);
        DS.add(DSOKButton);
        DS.setVisible(true);

    }

    public void INSUFFICIENTBALANCE(){
        Border INSUFFICIENTBALANCEFrameBorder = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame  INSUFFICIENTBALANCE = new JFrame("Empty Field Notice");
        INSUFFICIENTBALANCE.setBackground(Color.BLACK);
        ImageIcon WarningLogo1 = new ImageIcon("WARNINGLOGO.png");
        INSUFFICIENTBALANCE.setIconImage(WarningLogo1.getImage());
        INSUFFICIENTBALANCE.getContentPane().setBackground(Color.BLACK);
        INSUFFICIENTBALANCE.setLayout(null);
        INSUFFICIENTBALANCE.setSize(700, 300);
        INSUFFICIENTBALANCE.setLocationRelativeTo(null);
        INSUFFICIENTBALANCE.getRootPane().setBorder( INSUFFICIENTBALANCEFrameBorder);

        JLabel  INSUFFICIENTBALANCEQuestionMark = new JLabel();
        INSUFFICIENTBALANCEQuestionMark.setText("INVALID!");
        INSUFFICIENTBALANCEQuestionMark.setForeground(new Color(255,0,0));
        INSUFFICIENTBALANCEQuestionMark.setFont(new Font("Monocraft", Font.BOLD, 40));
        INSUFFICIENTBALANCEQuestionMark.setBounds(270, 50, 500, 50); 
        
        JLabel  INSUFFICIENTBALANCEProvide = new JLabel();
        INSUFFICIENTBALANCEProvide.setText("Insufficient Balance");
        INSUFFICIENTBALANCEProvide.setForeground(Color.WHITE);
        INSUFFICIENTBALANCEProvide.setFont(new Font("Monocraft", Font.BOLD, 15));
        INSUFFICIENTBALANCEProvide.setBounds(270, 100, 400, 50);

        JLabel  INSUFFICIENTBALANCEWarningSign1 = new JLabel();
        ImageIcon  INSUFFICIENTBALANCEWarningSignIcon1 = new ImageIcon("WARNINGSIGN.png");
        INSUFFICIENTBALANCEWarningSign1.setIcon( INSUFFICIENTBALANCEWarningSignIcon1);
        INSUFFICIENTBALANCEWarningSign1.setBounds(50, 50, 153, 151); 
        INSUFFICIENTBALANCEWarningSign1.setOpaque(false);

        JButton  INSUFFICIENTBALANCEOKButton = new JButton();
        INSUFFICIENTBALANCEOKButton.setBackground(new Color(153,255,51));
        INSUFFICIENTBALANCEOKButton.setText("OK");
        INSUFFICIENTBALANCEOKButton.setForeground(Color.BLACK);
        INSUFFICIENTBALANCEOKButton.setFont(new Font("Monocraft",Font.BOLD,15));
        INSUFFICIENTBALANCEOKButton.setBounds(390, 170, 80, 40);
        INSUFFICIENTBALANCEOKButton.setFocusable(false);

        INSUFFICIENTBALANCEOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INSUFFICIENTBALANCE.dispose();
                }   
        });
        INSUFFICIENTBALANCE.add( INSUFFICIENTBALANCEQuestionMark);
        INSUFFICIENTBALANCE.add( INSUFFICIENTBALANCEProvide);
        INSUFFICIENTBALANCE.add( INSUFFICIENTBALANCEOKButton);
        INSUFFICIENTBALANCE.add( INSUFFICIENTBALANCEWarningSign1);
        INSUFFICIENTBALANCE.setVisible(true);
       
    }

    public void TransAvail2(){
        JFrame TransactionsFrame2 = new JFrame("TRANSACTION MENU");
        JLabel ForFrame2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        TransactionsFrame2.setIconImage(logo.getImage());
        TransactionsFrame2.setResizable(false);
        TransactionsFrame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TransactionsFrame2.setSize(1500, 880);
        TransactionsFrame2.setLocationRelativeTo(null);

        ImageIcon TransactionsFrameBg2 = new ImageIcon("TRANSACTIONSBG.png");
        Image TransactionsFrameBgIcon2 = TransactionsFrameBg2.getImage().getScaledInstance(TransactionsFrame2.getWidth(), TransactionsFrame2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon1 = new ImageIcon(TransactionsFrameBgIcon2);
        ForFrame2 .setIcon(scaledImageIcon1);
        TransactionsFrame2.setContentPane(ForFrame2);
        TransactionsFrame2.setVisible(true);

        JButton DepositButton2 = new JButton();
        DepositButton2.setBackground(Color.BLACK);
        DepositButton2.setBorder(null);
        DepositButton2.setBorderPainted(false);
        DepositButton2.setFocusPainted(false);
        DepositButton2.setText("DEPOSIT");
        DepositButton2.setFont(new Font("Monocraft", Font.BOLD, 50));
        DepositButton2.setForeground(Color.CYAN);
        DepositButton2.setBounds(130,700,300,77);
        DepositButton2.setOpaque(false);
        DepositButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               if (e.getSource() == DepositButton2){
                    TransactionsFrame2.setVisible(false);
                    DEPOSITCHOICE2();
               }
            }
        });

        JButton WITHDRAWButton2 = new JButton();
        WITHDRAWButton2.setBackground(Color.BLACK);
        WITHDRAWButton2.setBorder(null);
        WITHDRAWButton2.setBorderPainted(false);
        WITHDRAWButton2.setFocusPainted(false);
        WITHDRAWButton2.setText("WITHDRAW");
        WITHDRAWButton2.setFont(new Font("Monocraft", Font.BOLD, 50));
        WITHDRAWButton2.setForeground(Color.CYAN);
        WITHDRAWButton2.setBounds(615,700,300,77);
        WITHDRAWButton2.setOpaque(false);
        WITHDRAWButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               if (e.getSource() == WITHDRAWButton2){
                    TransactionsFrame2.setVisible(false);
                    WITHDRAWCHOICE2();
               }
            }
        });

        JButton BALANCEButton2 = new JButton();
        BALANCEButton2.setBackground(Color.BLACK);
        BALANCEButton2.setBorder(null);
        BALANCEButton2.setBorderPainted(false);
        BALANCEButton2.setFocusPainted(false);
        BALANCEButton2.setText("BALANCE");
        BALANCEButton2.setFont(new Font("Monocraft", Font.BOLD, 50));
        BALANCEButton2.setForeground(Color.CYAN);
        BALANCEButton2.setBounds(1090,700,300,77);
        BALANCEButton2.setOpaque(false);
        BALANCEButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == BALANCEButton2){
                    TransactionsFrame2.setVisible(false);
                    TOTAlBALANCE2();
                }
            }
        });

        JButton CANCELBUTTON1 = new JButton();
        CANCELBUTTON1.setBackground(Color.BLACK);
        CANCELBUTTON1.setBorder(null);
        CANCELBUTTON1.setBorderPainted(false);
        CANCELBUTTON1.setFocusPainted(false);
        CANCELBUTTON1.setText("EXIT");
        CANCELBUTTON1.setFont(new Font("Monocraft", Font.BOLD, 35));
        CANCELBUTTON1.setForeground(Color.RED);
        CANCELBUTTON1.setBounds(75,45,100,35);
        CANCELBUTTON1.setOpaque(false);
        CANCELBUTTON1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == CANCELBUTTON1);
                Exit();
            }
        });

        TransactionsFrame2.add(CANCELBUTTON1);
        TransactionsFrame2.add(DepositButton2);
        TransactionsFrame2.add(WITHDRAWButton2);
        TransactionsFrame2.add(BALANCEButton2);
    }
    
    public void TOTAlBALANCE2(){
        JFrame TOTALBALANCEFRAME2 = new JFrame("TOTAL BALANCE");
        JLabel ForTOTALBALANCE2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        TOTALBALANCEFRAME2.setIconImage(logo.getImage());
        TOTALBALANCEFRAME2.setResizable(false);
        TOTALBALANCEFRAME2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TOTALBALANCEFRAME2.setSize(1500, 880);
        TOTALBALANCEFRAME2.setLocationRelativeTo(null);

        ImageIcon TOTALBALANCEFrameBg = new ImageIcon("TOTALBALANCEBG.png");
        Image TOTALBALANCEFrameBgIcon = TOTALBALANCEFrameBg.getImage().getScaledInstance(TOTALBALANCEFRAME2.getWidth(), TOTALBALANCEFRAME2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITCHOICEscaledImageIcon1 = new ImageIcon(TOTALBALANCEFrameBgIcon);
        ForTOTALBALANCE2 .setIcon(DEPOSITCHOICEscaledImageIcon1);
        TOTALBALANCEFRAME2.setContentPane(ForTOTALBALANCE2);
        TOTALBALANCEFRAME2.setVisible(true);

        JLabel ShowCURRENT2 = new JLabel();
        ShowCURRENT2.setText("" + CurrentBalance2);
        ShowCURRENT2.setFont(new Font("Monocraft",Font.BOLD,70));
        ShowCURRENT2.setBounds(700,230,500,300);
        ShowCURRENT2.setForeground(new Color(255,255,0));

        JLabel ShowSAVINGS2= new JLabel();
        ShowSAVINGS2.setText("" + SavingBalance2);
        ShowSAVINGS2.setFont(new Font("Monocraft",Font.BOLD,70));
        ShowSAVINGS2.setBounds(700,540,500,300);
        ShowSAVINGS2.setForeground(new Color(255,255,0));


        JButton BALANCEBACKBUTTON2 = new JButton("BACK");
        BALANCEBACKBUTTON2 .setBounds(45,38,100,35);
        BALANCEBACKBUTTON2 .setBorder(null);
        BALANCEBACKBUTTON2 .setBorderPainted(false);
        BALANCEBACKBUTTON2 .setFocusPainted(false);
        BALANCEBACKBUTTON2 .setFont(new Font("Monocraft", Font.BOLD, 35));
        BALANCEBACKBUTTON2 .setBackground(Color.BLACK);
        BALANCEBACKBUTTON2 .setForeground(Color.PINK);
        BALANCEBACKBUTTON2 .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() ==  BALANCEBACKBUTTON2 );
                TOTALBALANCEFRAME2.setVisible(false);
                TransAvail2();
            }
        });
        TOTALBALANCEFRAME2.add(ShowCURRENT2);
        TOTALBALANCEFRAME2.add(ShowSAVINGS2);
        TOTALBALANCEFRAME2.add(BALANCEBACKBUTTON2);

    }

    public void DEPOSITCHOICE2(){
        JFrame DEPOSITCHOICE2 = new JFrame("DEPOSIT CHOICE");
        JLabel ForDEPOSITCHOICE2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        DEPOSITCHOICE2.setIconImage(logo.getImage());
        DEPOSITCHOICE2.setResizable(false);
        DEPOSITCHOICE2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DEPOSITCHOICE2.setSize(1500, 880);
        DEPOSITCHOICE2.setLocationRelativeTo(null);

        ImageIcon DEPOSITCHOICEFrameBg2 = new ImageIcon("DEPOSITOPTIONBG.png");
        Image DEPOSITCHOICEFrameBgIcon2 = DEPOSITCHOICEFrameBg2.getImage().getScaledInstance(DEPOSITCHOICE2.getWidth(), DEPOSITCHOICE2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITCHOICEscaledImageIcon1 = new ImageIcon(DEPOSITCHOICEFrameBgIcon2);
        ForDEPOSITCHOICE2 .setIcon(DEPOSITCHOICEscaledImageIcon1);
        DEPOSITCHOICE2.setContentPane(ForDEPOSITCHOICE2);
        DEPOSITCHOICE2.setVisible(true);
        
        JButton DEPOSITCHOICECANCELBUTTON2 = new JButton();
        DEPOSITCHOICECANCELBUTTON2.setBackground(Color.BLACK);
        DEPOSITCHOICECANCELBUTTON2.setBorder(null);
        DEPOSITCHOICECANCELBUTTON2.setBorderPainted(false);
        DEPOSITCHOICECANCELBUTTON2.setFocusPainted(false);
        DEPOSITCHOICECANCELBUTTON2.setText("EXIT");
        DEPOSITCHOICECANCELBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 35));
        DEPOSITCHOICECANCELBUTTON2.setForeground(Color.RED);
        DEPOSITCHOICECANCELBUTTON2.setBounds(75,45,100,35);
        DEPOSITCHOICECANCELBUTTON2.setOpaque(false);
        DEPOSITCHOICECANCELBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == DEPOSITCHOICECANCELBUTTON2);
                Exit();
            }
        });

        JButton DEPOSITCHOICEBACKBUTTON2 = new JButton("BACK");
        DEPOSITCHOICEBACKBUTTON2.setBounds(1310,38,100,35);
        DEPOSITCHOICEBACKBUTTON2.setBorder(null);
        DEPOSITCHOICEBACKBUTTON2.setBorderPainted(false);
        DEPOSITCHOICEBACKBUTTON2.setFocusPainted(false);
        DEPOSITCHOICEBACKBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 35));
        DEPOSITCHOICEBACKBUTTON2.setBackground(Color.BLACK);
        DEPOSITCHOICEBACKBUTTON2.setForeground(Color.PINK);
        DEPOSITCHOICEBACKBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == DEPOSITCHOICEBACKBUTTON2);
                DEPOSITCHOICE2.setVisible(false);
                TransAvail2();
            }
        });

        JButton SAVINGSBUTTONDEPOSIT2 = new JButton("SAVINGS");
        SAVINGSBUTTONDEPOSIT2.setBounds(820,620,400,35);
        SAVINGSBUTTONDEPOSIT2.setBorder(null);
        SAVINGSBUTTONDEPOSIT2.setBorderPainted(false);
        SAVINGSBUTTONDEPOSIT2.setFocusPainted(false);
        SAVINGSBUTTONDEPOSIT2.setFont(new Font("Monocraft", Font.BOLD, 50));
        SAVINGSBUTTONDEPOSIT2.setBackground(Color.BLACK);
        SAVINGSBUTTONDEPOSIT2.setForeground(new Color(255,255,0));
        SAVINGSBUTTONDEPOSIT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SAVINGSBUTTONDEPOSIT2);
                DEPOSITCHOICE2.setVisible(false);
                FORDEPOSITFRAMESAVINGS();
            }
        });

        JButton CURRENTBUTTONDEPOSIT2 = new JButton("CURRENT");
        CURRENTBUTTONDEPOSIT2.setBounds(260,620,400,35);
        CURRENTBUTTONDEPOSIT2.setBorder(null);
        CURRENTBUTTONDEPOSIT2.setBorderPainted(false);
        CURRENTBUTTONDEPOSIT2.setFocusPainted(false);
        CURRENTBUTTONDEPOSIT2.setFont(new Font("Monocraft", Font.BOLD, 50));
        CURRENTBUTTONDEPOSIT2.setBackground(Color.BLACK);
        CURRENTBUTTONDEPOSIT2.setForeground(new Color(255,255,0));
        CURRENTBUTTONDEPOSIT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == CURRENTBUTTONDEPOSIT2);
                DEPOSITCHOICE2.setVisible(false);
                FORDEPOSITFRAMECURRENT2();
            }
        });

        DEPOSITCHOICE2.add(DEPOSITCHOICEBACKBUTTON2);
        DEPOSITCHOICE2.add(DEPOSITCHOICECANCELBUTTON2);
        DEPOSITCHOICE2.add(SAVINGSBUTTONDEPOSIT2);
        DEPOSITCHOICE2.add(CURRENTBUTTONDEPOSIT2);


}
    public void WITHDRAWCHOICE2(){
        JFrame WITHDRAWCHOICE2 = new JFrame("WITHDRAW CHOICE");
        JLabel ForWITHDRAWCHOICE2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        WITHDRAWCHOICE2.setIconImage(logo.getImage());
        WITHDRAWCHOICE2.setResizable(false);
        WITHDRAWCHOICE2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WITHDRAWCHOICE2.setSize(1500, 880);
        WITHDRAWCHOICE2.setLocationRelativeTo(null);

        ImageIcon WITHDRAWCHOICEFrameBg2 = new ImageIcon("WITHDRAWOPTIONBG.png");
        Image WITHDRAWCHOICEFrameBgIcon2 = WITHDRAWCHOICEFrameBg2.getImage().getScaledInstance(WITHDRAWCHOICE2.getWidth(), WITHDRAWCHOICE2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon WITHDRAWCHOICEscaledImageIcon1 = new ImageIcon(WITHDRAWCHOICEFrameBgIcon2);
        ForWITHDRAWCHOICE2 .setIcon(WITHDRAWCHOICEscaledImageIcon1);
        WITHDRAWCHOICE2.setContentPane(ForWITHDRAWCHOICE2);
        WITHDRAWCHOICE2.setVisible(true);

        JButton WITHDRAWCHOICECANCELBUTTON2 = new JButton();
        WITHDRAWCHOICECANCELBUTTON2.setBackground(Color.BLACK);
        WITHDRAWCHOICECANCELBUTTON2.setBorder(null);
        WITHDRAWCHOICECANCELBUTTON2.setBorderPainted(false);
        WITHDRAWCHOICECANCELBUTTON2.setFocusPainted(false);
        WITHDRAWCHOICECANCELBUTTON2.setText("EXIT");
        WITHDRAWCHOICECANCELBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 35));
        WITHDRAWCHOICECANCELBUTTON2.setForeground(Color.RED);
        WITHDRAWCHOICECANCELBUTTON2.setBounds(75,45,100,35);
        WITHDRAWCHOICECANCELBUTTON2.setOpaque(false);
        WITHDRAWCHOICECANCELBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == WITHDRAWCHOICECANCELBUTTON2);
                Exit();
            }
        });

        JButton WITHDRAWCHOICEBACKBUTTON2 = new JButton("BACK");
        WITHDRAWCHOICEBACKBUTTON2.setBounds(1310,38,100,35);
        WITHDRAWCHOICEBACKBUTTON2.setBorder(null);
        WITHDRAWCHOICEBACKBUTTON2.setBorderPainted(false);
        WITHDRAWCHOICEBACKBUTTON2.setFocusPainted(false);
        WITHDRAWCHOICEBACKBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 35));
        WITHDRAWCHOICEBACKBUTTON2.setBackground(Color.BLACK);
        WITHDRAWCHOICEBACKBUTTON2.setForeground(Color.PINK);
        WITHDRAWCHOICEBACKBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == WITHDRAWCHOICEBACKBUTTON2);
                WITHDRAWCHOICE2.setVisible(false);
                TransAvail2();
            }
        });
        JButton SAVINGSBUTTONWITHDRAW2 = new JButton("SAVINGS");
        SAVINGSBUTTONWITHDRAW2.setBounds(820,620,400,35);
        SAVINGSBUTTONWITHDRAW2.setBorder(null);
        SAVINGSBUTTONWITHDRAW2.setBorderPainted(false);
        SAVINGSBUTTONWITHDRAW2.setFocusPainted(false);
        SAVINGSBUTTONWITHDRAW2.setFont(new Font("Monocraft", Font.BOLD, 50));
        SAVINGSBUTTONWITHDRAW2.setBackground(Color.BLACK);
        SAVINGSBUTTONWITHDRAW2.setForeground(new Color(255,255,0));
        SAVINGSBUTTONWITHDRAW2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SAVINGSBUTTONWITHDRAW2);
                WITHDRAWCHOICE2.setVisible(false);
                FORWIHTDRAWFRAMESAVINGS2();
            }
        });

        JButton CURRENTBUTTONWITHDRAW2 = new JButton("CURRENT");
        CURRENTBUTTONWITHDRAW2.setBounds(260,620,400,35);
        CURRENTBUTTONWITHDRAW2.setBorder(null);
        CURRENTBUTTONWITHDRAW2.setBorderPainted(false);
        CURRENTBUTTONWITHDRAW2.setFocusPainted(false);
        CURRENTBUTTONWITHDRAW2.setFont(new Font("Monocraft", Font.BOLD, 50));
        CURRENTBUTTONWITHDRAW2.setBackground(Color.BLACK);
        CURRENTBUTTONWITHDRAW2.setForeground(new Color(255,255,0));
        CURRENTBUTTONWITHDRAW2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == CURRENTBUTTONWITHDRAW2);
                WITHDRAWCHOICE2.setVisible(false);
                FORWIHTDRAWFRAMECURRENT();
            }
        });
        WITHDRAWCHOICE2.add(SAVINGSBUTTONWITHDRAW2);
        WITHDRAWCHOICE2.add(CURRENTBUTTONWITHDRAW2);
        WITHDRAWCHOICE2.add(WITHDRAWCHOICEBACKBUTTON2);
        WITHDRAWCHOICE2.add(WITHDRAWCHOICECANCELBUTTON2);
    }

    public void FORDEPOSITFRAMECURRENT2(){
        JFrame DEPOSITFRAME2 = new JFrame("DEPOSIT");
        JLabel DEPOSITFRAMELABEL2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        DEPOSITFRAME2.setIconImage(logo.getImage());
        DEPOSITFRAME2.setResizable(false);
        DEPOSITFRAME2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DEPOSITFRAME2.setSize(1500, 880);
        DEPOSITFRAME2.setLocationRelativeTo(null);

        ImageIcon DEPOSITFRAMEBg = new ImageIcon("DEPOSITBG.png");
        Image DEPOSITFRAMEBgIcon = DEPOSITFRAMEBg.getImage().getScaledInstance(DEPOSITFRAME2.getWidth(), DEPOSITFRAME2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITFRAMEscaledImageIcon1 = new ImageIcon(DEPOSITFRAMEBgIcon);
        DEPOSITFRAMELABEL2 .setIcon(DEPOSITFRAMEscaledImageIcon1);
        DEPOSITFRAME2.setContentPane(DEPOSITFRAMELABEL2);
        DEPOSITFRAME2.setVisible(true);

        JTextField ENTERDEPOSITAMOUNT2 = new JTextField();
        ENTERDEPOSITAMOUNT2.setBackground(new Color(0,153,153));
        ENTERDEPOSITAMOUNT2.setForeground(Color.WHITE);
        ENTERDEPOSITAMOUNT2.setFont(new Font("Monocraft", Font.BOLD,25));
        ENTERDEPOSITAMOUNT2.setHorizontalAlignment(JTextField.CENTER);
        ENTERDEPOSITAMOUNT2.setBounds(520, 270 ,500,50);
        ENTERDEPOSITAMOUNT2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton DepositOption12 = new JButton("200");
        DepositOption12.setBounds(490,370,150,70);
        DepositOption12.setFocusPainted(false);
        DepositOption12.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption12.setBackground(new Color(0,153,153));
        DepositOption12.setForeground(Color.WHITE);
        DepositOption12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption12);
                ENTERDEPOSITAMOUNT2.setText("200");
            }
        });

        JButton DepositOption22 = new JButton("500");
        DepositOption22.setBounds(695,370,150,70);
        DepositOption22.setFocusPainted(false);
        DepositOption22.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption22.setBackground(new Color(0,153,153));
        DepositOption22.setForeground(Color.WHITE);
        DepositOption22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption22);
                ENTERDEPOSITAMOUNT2.setText("500");
            }
        });

        JButton DepositOption32 = new JButton("700");
        DepositOption32.setBounds(900,370,150,70);
        DepositOption32.setFocusPainted(false);
        DepositOption32.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption32.setBackground(new Color(0,153,153));
        DepositOption32.setForeground(Color.WHITE);
        DepositOption32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption32);
                ENTERDEPOSITAMOUNT2.setText("700");
            }
        });

        JButton DepositOption42 = new JButton("1000");
        DepositOption42.setBounds(490,470,150,70);
        DepositOption42.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption42.setBackground(new Color(0,153,153));
        DepositOption42.setForeground(Color.WHITE);
        DepositOption42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption42);
                ENTERDEPOSITAMOUNT2.setText("1000");
            }
        });

        JButton DepositOption52 = new JButton("1500");
        DepositOption52.setBounds(695,470,150,70);
        DepositOption52.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption52.setBackground(new Color(0,153,153));
        DepositOption52.setForeground(Color.WHITE);
        DepositOption52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption52);
                ENTERDEPOSITAMOUNT2.setText("1500");
            }
        });

        JButton DepositOption62 = new JButton("2000");
        DepositOption62.setBounds(900,470,150,70);
        DepositOption62.setFont(new Font("Monocraft", Font.BOLD, 25));
        DepositOption62.setBackground(new Color(0,153,153));
        DepositOption62.setForeground(Color.WHITE);
        DepositOption62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DepositOption62);
                ENTERDEPOSITAMOUNT2.setText("2000");
            }
        });

        JButton DEPOSITENTERBUTTON2 = new JButton("ENTER");
        DEPOSITENTERBUTTON2.setBounds(900,570,150,70);
        DEPOSITENTERBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        DEPOSITENTERBUTTON2.setBackground(new Color(0,204,0));
        DEPOSITENTERBUTTON2.setForeground(Color.BLACK);
        DEPOSITENTERBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double DepositAmount2 = Double.parseDouble(ENTERDEPOSITAMOUNT2.getText());
                    CurrentBalance2 += DepositAmount2;
                    DepositSuccessful2();
                } catch (NumberFormatException ex) {
                    EmptyFieldDeposit2();
                }
            }
        });

        JButton DEPOSITBACKBUTTON2 = new JButton("CANCEL");
        DEPOSITBACKBUTTON2.setBounds(490,570,150,70);
        DEPOSITBACKBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        DEPOSITBACKBUTTON2.setBackground(new Color(204,0,0));
        DEPOSITBACKBUTTON2.setForeground(Color.BLACK);
        DEPOSITBACKBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == DEPOSITBACKBUTTON2);
                DEPOSITFRAME2.setVisible(false);
                DEPOSITCHOICE();
            }
        });

        JButton DEPOSITCLEARBUTTON2 = new JButton("CLEAR");
        DEPOSITCLEARBUTTON2.setBounds(695,570,150,70);
        DEPOSITCLEARBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        DEPOSITCLEARBUTTON2.setBackground(new Color(204,204,0));
        DEPOSITCLEARBUTTON2.setForeground(Color.BLACK);
        DEPOSITCLEARBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == DEPOSITCLEARBUTTON2);
                ENTERDEPOSITAMOUNT2.setText("");
            }
        });

        DEPOSITFRAME2.add(ENTERDEPOSITAMOUNT2);
        DEPOSITFRAME2.add(DepositOption12);
        DEPOSITFRAME2.add(DepositOption22);
        DEPOSITFRAME2.add(DepositOption32);
        DEPOSITFRAME2.add(DepositOption42);
        DEPOSITFRAME2.add(DepositOption52);
        DEPOSITFRAME2.add(DepositOption62);
        DEPOSITFRAME2.add(DEPOSITENTERBUTTON2);
        DEPOSITFRAME2.add(DEPOSITBACKBUTTON2);
        DEPOSITFRAME2.add(DEPOSITCLEARBUTTON2);



    }

    public void FORDEPOSITFRAMESAVINGS2(){
        JFrame DEPOSITFRAME12 = new JFrame("DEPOSIT");
        JLabel DEPOSITFRAMELABEL12 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        DEPOSITFRAME12.setIconImage(logo.getImage());
        DEPOSITFRAME12.setResizable(false);
        DEPOSITFRAME12.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DEPOSITFRAME12.setSize(1500, 880);
        DEPOSITFRAME12.setLocationRelativeTo(null);

        ImageIcon DEPOSITFRAMEBg12 = new ImageIcon("DEPOSITBG.png");
        Image DEPOSITFRAMEBgIcon12 = DEPOSITFRAMEBg12.getImage().getScaledInstance(DEPOSITFRAME12.getWidth(), DEPOSITFRAME12.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon DEPOSITFRAMEscaledImageIcon112 = new ImageIcon(DEPOSITFRAMEBgIcon12);
        DEPOSITFRAMELABEL12 .setIcon(DEPOSITFRAMEscaledImageIcon112);
        DEPOSITFRAME12.setContentPane(DEPOSITFRAMELABEL12);
        DEPOSITFRAME12.setVisible(true);

        JTextField ENTERDEPOSITAMOUNT12 = new JTextField();
        ENTERDEPOSITAMOUNT12.setBackground(new Color(0,153,153));
        ENTERDEPOSITAMOUNT12.setForeground(Color.WHITE);
        ENTERDEPOSITAMOUNT12.setFont(new Font("Monocraft", Font.BOLD,25));
        ENTERDEPOSITAMOUNT12.setHorizontalAlignment(JTextField.CENTER);
        ENTERDEPOSITAMOUNT12.setBounds(520, 270 ,500,50);
        ENTERDEPOSITAMOUNT12.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton SDepositOption12 = new JButton("200");
        SDepositOption12.setBounds(490,370,150,70);
        SDepositOption12.setFocusPainted(false);
        SDepositOption12.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption12.setBackground(new Color(0,153,153));
        SDepositOption12.setForeground(Color.WHITE);
        SDepositOption12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption12);
                ENTERDEPOSITAMOUNT12.setText("200");
            }
        });

        JButton SDepositOption22 = new JButton("500");
        SDepositOption22.setBounds(695,370,150,70);
        SDepositOption22.setFocusPainted(false);
        SDepositOption22.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption22.setBackground(new Color(0,153,153));
        SDepositOption22.setForeground(Color.WHITE);
        SDepositOption22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption22);
                ENTERDEPOSITAMOUNT12.setText("500");
            }
        });

        JButton SDepositOption32= new JButton("700");
        SDepositOption32.setBounds(900,370,150,70);
        SDepositOption32.setFocusPainted(false);
        SDepositOption32.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption32.setBackground(new Color(0,153,153));
        SDepositOption32.setForeground(Color.WHITE);
        SDepositOption32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption32);
                ENTERDEPOSITAMOUNT12.setText("700");
            }
        });

        JButton SDepositOption42 = new JButton("1000");
        SDepositOption42.setBounds(490,470,150,70);
        SDepositOption42.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption42.setBackground(new Color(0,153,153));
        SDepositOption42.setForeground(Color.WHITE);
        SDepositOption42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption42);
                ENTERDEPOSITAMOUNT12.setText("1000");
            }
        });

        JButton SDepositOption52 = new JButton("1500");
        SDepositOption52.setBounds(695,470,150,70);
        SDepositOption52.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption52.setBackground(new Color(0,153,153));
        SDepositOption52.setForeground(Color.WHITE);
        SDepositOption52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption52);
                ENTERDEPOSITAMOUNT12.setText("1500");
            }
        });

        JButton SDepositOption62 = new JButton("2000");
        SDepositOption62.setBounds(900,470,150,70);
        SDepositOption62.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDepositOption62.setBackground(new Color(0,153,153));
        SDepositOption62.setForeground(Color.WHITE);
        SDepositOption62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDepositOption62);
                ENTERDEPOSITAMOUNT12.setText("2000");
            }
        });

        JButton SDEPOSITENTERBUTTON2 = new JButton("ENTER");
        SDEPOSITENTERBUTTON2.setBounds(900,570,150,70);
        SDEPOSITENTERBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDEPOSITENTERBUTTON2.setBackground(new Color(0,204,0));
        SDEPOSITENTERBUTTON2.setForeground(Color.BLACK);
        SDEPOSITENTERBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double DepositAmount12 = Double.parseDouble(ENTERDEPOSITAMOUNT12.getText());
                    SavingBalance2 += DepositAmount12;
                    DepositSuccessful2();
                } catch (NumberFormatException ex) {
                    EmptyFieldDeposit2();
                }
            }
        });

        JButton SDEPOSITBACKBUTTON2 = new JButton("CANCEL");
        SDEPOSITBACKBUTTON2.setBounds(490,570,150,70);
        SDEPOSITBACKBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDEPOSITBACKBUTTON2.setBackground(new Color(204,0,0));
        SDEPOSITBACKBUTTON2.setForeground(Color.BLACK);
        SDEPOSITBACKBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SDEPOSITBACKBUTTON2);
                DEPOSITFRAME12.setVisible(false);
                DEPOSITCHOICE2();
            }
        });

        JButton SDEPOSITCLEARBUTTON2 = new JButton("CLEAR");
        SDEPOSITCLEARBUTTON2.setBounds(695,570,150,70);
        SDEPOSITCLEARBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SDEPOSITCLEARBUTTON2.setBackground(new Color(204,204,0));
        SDEPOSITCLEARBUTTON2.setForeground(Color.BLACK);
        SDEPOSITCLEARBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SDEPOSITCLEARBUTTON2);
                ENTERDEPOSITAMOUNT12.setText("");
            }
        });

        DEPOSITFRAME12.add(ENTERDEPOSITAMOUNT12);
        DEPOSITFRAME12.add(SDepositOption12);
        DEPOSITFRAME12.add(SDepositOption22);
        DEPOSITFRAME12.add(SDepositOption32);
        DEPOSITFRAME12.add(SDepositOption42);
        DEPOSITFRAME12.add(SDepositOption52);
        DEPOSITFRAME12.add(SDepositOption62);
        DEPOSITFRAME12.add(SDEPOSITENTERBUTTON2);
        DEPOSITFRAME12.add(SDEPOSITBACKBUTTON2);
        DEPOSITFRAME12.add(SDEPOSITCLEARBUTTON2);
    }


    public void FORWIHTDRAWFRAMECURRENT2(){ 
        JFrame WITHDRAWFRAME2 = new JFrame("WITHDRAW");
        JLabel WITHDRAWFRAMELABEL2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        WITHDRAWFRAME2.setIconImage(logo.getImage());
        WITHDRAWFRAME2.setResizable(false);
        WITHDRAWFRAME2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WITHDRAWFRAME2.setSize(1500, 880);
        WITHDRAWFRAME2.setLocationRelativeTo(null);

        ImageIcon WITHDRAWFRAMEBg2 = new ImageIcon("WITHDRAWBG.png");
        Image WITHDRAWFRAMEBgIcon2 = WITHDRAWFRAMEBg2.getImage().getScaledInstance(WITHDRAWFRAME2.getWidth(), WITHDRAWFRAME2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon WITHDRAWFRAMEscaledImageIcon1 = new ImageIcon(WITHDRAWFRAMEBgIcon2);
        WITHDRAWFRAMELABEL2 .setIcon(WITHDRAWFRAMEscaledImageIcon1);
        WITHDRAWFRAME2.setContentPane(WITHDRAWFRAMELABEL2);
        WITHDRAWFRAME2.setVisible(true);

        JTextField ENTERWITHDRAWAMOUNT2 = new JTextField();
        ENTERWITHDRAWAMOUNT2.setBackground(new Color(0,153,153));
        ENTERWITHDRAWAMOUNT2.setForeground(Color.WHITE);
        ENTERWITHDRAWAMOUNT2.setFont(new Font("Monocraft", Font.BOLD,25));
        ENTERWITHDRAWAMOUNT2.setHorizontalAlignment(JTextField.CENTER);
        ENTERWITHDRAWAMOUNT2.setBounds(520, 270 ,500,50);
        ENTERWITHDRAWAMOUNT2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton WithdrawOption12 = new JButton("200");
        WithdrawOption12.setBounds(490,370,150,70);
        WithdrawOption12.setFocusPainted(false);
        WithdrawOption12.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption12.setBackground(new Color(0,153,153));
        WithdrawOption12.setForeground(Color.WHITE);
        WithdrawOption12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption12);
                ENTERWITHDRAWAMOUNT2.setText("200");
            }
        });

        JButton WithdrawOption22 = new JButton("500");
        WithdrawOption22.setBounds(695,370,150,70);
        WithdrawOption22.setFocusPainted(false);
        WithdrawOption22.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption22.setBackground(new Color(0,153,153));
        WithdrawOption22.setForeground(Color.WHITE);
        WithdrawOption22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption22);
                ENTERWITHDRAWAMOUNT2.setText("500");
            }
        });

        JButton WithdrawOption32 = new JButton("700");
        WithdrawOption32.setBounds(900,370,150,70);
        WithdrawOption32.setFocusPainted(false);
        WithdrawOption32.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption32.setBackground(new Color(0,153,153));
        WithdrawOption32.setForeground(Color.WHITE);
        WithdrawOption32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption32);
                ENTERWITHDRAWAMOUNT2.setText("700");
            }
        });

        JButton WithdrawOption42 = new JButton("1000");
        WithdrawOption42.setBounds(490,470,150,70);
        WithdrawOption42.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption42.setBackground(new Color(0,153,153));
        WithdrawOption42.setForeground(Color.WHITE);
        WithdrawOption42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption42);
                ENTERWITHDRAWAMOUNT2.setText("1000");
            }
        });

        JButton WithdrawOption52 = new JButton("1500");
        WithdrawOption52.setBounds(695,470,150,70);
        WithdrawOption52.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption52.setBackground(new Color(0,153,153));
        WithdrawOption52.setForeground(Color.WHITE);
        WithdrawOption52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption52);
                ENTERWITHDRAWAMOUNT2.setText("1500");
            }
        });

        JButton WithdrawOption62 = new JButton("2000");
        WithdrawOption62.setBounds(900,470,150,70);
        WithdrawOption62.setFont(new Font("Monocraft", Font.BOLD, 25));
        WithdrawOption62.setBackground(new Color(0,153,153));
        WithdrawOption62.setForeground(Color.WHITE);
        WithdrawOption62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WithdrawOption62);
                ENTERWITHDRAWAMOUNT2.setText("2000");
            }
        });

        JButton WITHDRAWENTERBUTTON2 = new JButton("ENTER");
        WITHDRAWENTERBUTTON2 .setBounds(900,570,150,70);
        WITHDRAWENTERBUTTON2 .setFont(new Font("Monocraft", Font.BOLD, 25));
        WITHDRAWENTERBUTTON2 .setBackground(new Color(0,204,0));
        WITHDRAWENTERBUTTON2 .setForeground(Color.BLACK);
        WITHDRAWENTERBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawalAmount = Double.parseDouble(ENTERWITHDRAWAMOUNT2.getText());
                    if (withdrawalAmount <= CurrentBalance2) {
                        CurrentBalance2 -= withdrawalAmount;
                        DepositSuccessful2();
                    } else {
                        INSUFFICIENTBALANCE2();
                    }
                } catch (NumberFormatException ex) {
                    EmptyFieldDeposit2();
                }
            }
        });
        

        JButton WITHDRAWBACKBUTTON2 = new JButton("CANCEL");
        WITHDRAWBACKBUTTON2.setBounds(490,570,150,70);
        WITHDRAWBACKBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        WITHDRAWBACKBUTTON2.setBackground(new Color(204,0,0));
        WITHDRAWBACKBUTTON2.setForeground(Color.BLACK);
        WITHDRAWBACKBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == WITHDRAWBACKBUTTON2);
                WITHDRAWFRAME2.setVisible(false);
                WITHDRAWCHOICE();
            }
        });

        JButton WITHDRAWCLEARBUTTON2 = new JButton("CLEAR");
        WITHDRAWCLEARBUTTON2.setBounds(695,570,150,70);
        WITHDRAWCLEARBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        WITHDRAWCLEARBUTTON2.setBackground(new Color(204,204,0));
        WITHDRAWCLEARBUTTON2.setForeground(Color.BLACK);
        WITHDRAWCLEARBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == WITHDRAWCLEARBUTTON2);
                ENTERWITHDRAWAMOUNT2.setText("");
            }
        });

        WITHDRAWFRAME2.add(ENTERWITHDRAWAMOUNT2);
        WITHDRAWFRAME2.add(WithdrawOption12);
        WITHDRAWFRAME2.add(WithdrawOption22);
        WITHDRAWFRAME2.add(WithdrawOption32);
        WITHDRAWFRAME2.add(WithdrawOption42);
        WITHDRAWFRAME2.add(WithdrawOption52);
        WITHDRAWFRAME2.add(WithdrawOption62);
        WITHDRAWFRAME2.add(WITHDRAWENTERBUTTON2);
        WITHDRAWFRAME2.add(WITHDRAWBACKBUTTON2);
        WITHDRAWFRAME2.add(WITHDRAWCLEARBUTTON2);
    }

    public void FORWIHTDRAWFRAMESAVINGS2(){ 
        JFrame SWITHDRAWFRAME2 = new JFrame("WITHDRAW");
        JLabel SWITHDRAWFRAMELABEL2 = new JLabel();
        ImageIcon logo = new ImageIcon("LOGO.png");
        SWITHDRAWFRAME2.setIconImage(logo.getImage());
        SWITHDRAWFRAME2.setResizable(false);
        SWITHDRAWFRAME2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SWITHDRAWFRAME2.setSize(1500, 880);
        SWITHDRAWFRAME2.setLocationRelativeTo(null);

        ImageIcon SWITHDRAWFRAMEBg2 = new ImageIcon("WITHDRAWBG.png");
        Image SWITHDRAWFRAMEBgIcon2 = SWITHDRAWFRAMEBg2.getImage().getScaledInstance(SWITHDRAWFRAME2.getWidth(), SWITHDRAWFRAME2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon WITHDRAWFRAMEscaledImageIcon12 = new ImageIcon(SWITHDRAWFRAMEBgIcon2);
        SWITHDRAWFRAMELABEL2 .setIcon(WITHDRAWFRAMEscaledImageIcon12);
        SWITHDRAWFRAME2.setContentPane(SWITHDRAWFRAMELABEL2);
        SWITHDRAWFRAME2.setVisible(true);

        JTextField SENTERWITHDRAWAMOUNT2 = new JTextField();
        SENTERWITHDRAWAMOUNT2.setBackground(new Color(0,153,153));
        SENTERWITHDRAWAMOUNT2.setForeground(Color.WHITE);
        SENTERWITHDRAWAMOUNT2.setFont(new Font("Monocraft", Font.BOLD,25));
        SENTERWITHDRAWAMOUNT2.setHorizontalAlignment(JTextField.CENTER);
        SENTERWITHDRAWAMOUNT2.setBounds(520, 270 ,500,50);
        SENTERWITHDRAWAMOUNT2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char N = e.getKeyChar();
                if(!Character.isDigit(N)){
                    e.consume();
                }
            }
        });
        
        JButton SWithdrawOption12 = new JButton("200");
        SWithdrawOption12.setBounds(490,370,150,70);
        SWithdrawOption12.setFocusPainted(false);
        SWithdrawOption12.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption12.setBackground(new Color(0,153,153));
        SWithdrawOption12.setForeground(Color.WHITE);
        SWithdrawOption12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption12);
                SENTERWITHDRAWAMOUNT2.setText("200");
            }
        });

        JButton SWithdrawOption22 = new JButton("500");
        SWithdrawOption22.setBounds(695,370,150,70);
        SWithdrawOption22.setFocusPainted(false);
        SWithdrawOption22.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption22.setBackground(new Color(0,153,153));
        SWithdrawOption22.setForeground(Color.WHITE);
        SWithdrawOption22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption22);
                SENTERWITHDRAWAMOUNT2.setText("500");
            }
        });

        JButton SWithdrawOption32 = new JButton("700");
        SWithdrawOption32.setBounds(900,370,150,70);
        SWithdrawOption32.setFocusPainted(false);
        SWithdrawOption32.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption32.setBackground(new Color(0,153,153));
        SWithdrawOption32.setForeground(Color.WHITE);
        SWithdrawOption32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption32);
                SENTERWITHDRAWAMOUNT2.setText("700");
            }
        });

        JButton SWithdrawOption42 = new JButton("1000");
        SWithdrawOption42.setBounds(490,470,150,70);
        SWithdrawOption42.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption42.setBackground(new Color(0,153,153));
        SWithdrawOption42.setForeground(Color.WHITE);
        SWithdrawOption42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption42);
                SENTERWITHDRAWAMOUNT2.setText("1000");
            }
        });

        JButton SWithdrawOption52 = new JButton("1500");
        SWithdrawOption52.setBounds(695,470,150,70);
        SWithdrawOption52.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption52.setBackground(new Color(0,153,153));
        SWithdrawOption52.setForeground(Color.WHITE);
        SWithdrawOption52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption52);
                SENTERWITHDRAWAMOUNT2.setText("1500");
            }
        });

        JButton SWithdrawOption62= new JButton("2000");
        SWithdrawOption62.setBounds(900,470,150,70);
        SWithdrawOption62.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWithdrawOption62.setBackground(new Color(0,153,153));
        SWithdrawOption62.setForeground(Color.WHITE);
        SWithdrawOption62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWithdrawOption62);
                SENTERWITHDRAWAMOUNT2.setText("2000");
            }
        });

        JButton SWITHDRAWENTERBUTTON2 = new JButton("ENTER");
        SWITHDRAWENTERBUTTON2.setBounds(900,570,150,70);
        SWITHDRAWENTERBUTTON2 .setFont(new Font("Monocraft", Font.BOLD, 25));
        SWITHDRAWENTERBUTTON2 .setBackground(new Color(0,204,0));
        SWITHDRAWENTERBUTTON2 .setForeground(Color.BLACK);
        SWITHDRAWENTERBUTTON2.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double withdrawalAmount2 = Double.parseDouble(SENTERWITHDRAWAMOUNT2.getText());
                        if (withdrawalAmount2 <= SavingBalance2) {
                            SavingBalance2 -= withdrawalAmount2;
                            DepositSuccessful2();
                        } else {
                            INSUFFICIENTBALANCE2();
                        }
                    } catch (NumberFormatException ex) {
                        EmptyFieldDeposit2();
                    }
                }
            });

        JButton SWITHDRAWBACKBUTTON2 = new JButton("CANCEL");
        SWITHDRAWBACKBUTTON2.setBounds(490,570,150,70);
        SWITHDRAWBACKBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWITHDRAWBACKBUTTON2.setBackground(new Color(204,0,0));
        SWITHDRAWBACKBUTTON2.setForeground(Color.BLACK);
        SWITHDRAWBACKBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if (e.getSource() == SWITHDRAWBACKBUTTON2);
                SWITHDRAWFRAME2.setVisible(false);
                WITHDRAWCHOICE2();
            }
        });

        JButton SWITHDRAWCLEARBUTTON2 = new JButton("CLEAR");
        SWITHDRAWCLEARBUTTON2.setBounds(695,570,150,70);
        SWITHDRAWCLEARBUTTON2.setFont(new Font("Monocraft", Font.BOLD, 25));
        SWITHDRAWCLEARBUTTON2.setBackground(new Color(204,204,0));
        SWITHDRAWCLEARBUTTON2.setForeground(Color.BLACK);
        SWITHDRAWCLEARBUTTON2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == SWITHDRAWCLEARBUTTON2);
                SENTERWITHDRAWAMOUNT2.setText("");
            }
        });

        SWITHDRAWFRAME2.add(SENTERWITHDRAWAMOUNT2);
        SWITHDRAWFRAME2.add(SWithdrawOption12);
        SWITHDRAWFRAME2.add(SWithdrawOption22);
        SWITHDRAWFRAME2.add(SWithdrawOption32);
        SWITHDRAWFRAME2.add(SWithdrawOption42);
        SWITHDRAWFRAME2.add(SWithdrawOption52);
        SWITHDRAWFRAME2.add(SWithdrawOption62);
        SWITHDRAWFRAME2.add(SWITHDRAWENTERBUTTON2);
        SWITHDRAWFRAME2.add(SWITHDRAWBACKBUTTON2);
        SWITHDRAWFRAME2.add(SWITHDRAWCLEARBUTTON2);
    }


    public void EmptyFieldDeposit2(){
        Border EmptyFieldDepositFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame EmptyFieldDeposit2 = new JFrame("Empty Field Notice");
        EmptyFieldDeposit2.setBackground(Color.BLACK);
        ImageIcon WarningLogo12 = new ImageIcon("WARNINGLOGO.png");
        EmptyFieldDeposit2.setIconImage(WarningLogo12.getImage());
        EmptyFieldDeposit2.getContentPane().setBackground(Color.BLACK);
        EmptyFieldDeposit2.setLayout(null);
        EmptyFieldDeposit2.setSize(700, 300);
        EmptyFieldDeposit2.setLocationRelativeTo(null);
        EmptyFieldDeposit2.getRootPane().setBorder(EmptyFieldDepositFrameBorder2);

        JLabel EmptyFieldDepositQuestionMark2 = new JLabel();
        EmptyFieldDepositQuestionMark2.setText("FIELD EMPTY!");
        EmptyFieldDepositQuestionMark2.setForeground(new Color(255,0,0));
        EmptyFieldDepositQuestionMark2.setFont(new Font("Monocraft", Font.BOLD, 40));
        EmptyFieldDepositQuestionMark2.setBounds(270, 50, 500, 50); 
        
        JLabel EmptyFieldDepositProvide2 = new JLabel();
        EmptyFieldDepositProvide2.setText("Please Enter Amount.");
        EmptyFieldDepositProvide2.setForeground(Color.WHITE);
        EmptyFieldDepositProvide2.setFont(new Font("Monocraft", Font.BOLD, 15));
        EmptyFieldDepositProvide2.setBounds(270, 100, 400, 50);

        JLabel EmptyFieldDepositWarningSign12 = new JLabel();
        ImageIcon EmptyFieldDepositWarningSignIcon12 = new ImageIcon("WARNINGSIGN.png");
        EmptyFieldDepositWarningSign12.setIcon(EmptyFieldDepositWarningSignIcon12);
        EmptyFieldDepositWarningSign12.setBounds(50, 50, 153, 151); 
        EmptyFieldDepositWarningSign12.setOpaque(false);

        JButton EmptyFieldDepositOKButton2 = new JButton();
        EmptyFieldDepositOKButton2.setBackground(new Color(153,255,51));
        EmptyFieldDepositOKButton2.setText("OK");
        EmptyFieldDepositOKButton2.setForeground(Color.BLACK);
        EmptyFieldDepositOKButton2.setFont(new Font("Monocraft",Font.BOLD,15));
        EmptyFieldDepositOKButton2.setBounds(390, 170, 80, 40);
        EmptyFieldDepositOKButton2.setFocusable(false);

        EmptyFieldDepositOKButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmptyFieldDeposit2.dispose();
                }   
        });
        EmptyFieldDeposit2.add(EmptyFieldDepositQuestionMark2);
        EmptyFieldDeposit2.add(EmptyFieldDepositProvide2);
        EmptyFieldDeposit2.add(EmptyFieldDepositOKButton2);
        EmptyFieldDeposit2.add(EmptyFieldDepositWarningSign12);
        EmptyFieldDeposit2.setVisible(true);
       
    }

    public void DepositSuccessful2(){ // Log In Successful
        Border DSFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame DS2= new JFrame("SUCCESSFUL DEPOSIT");
        DS2.setBackground(Color.BLACK);
        ImageIcon CheckLogo = new ImageIcon("CHECK-removebg-preview.png");
        DS2.setIconImage(CheckLogo.getImage());
        DS2.getContentPane().setBackground(Color.BLACK);
        DS2.setLayout(null);
        DS2.setSize(700, 300);
        DS2.setLocationRelativeTo(null);
        DS2.getRootPane().setBorder(DSFrameBorder2);
        DS2.setResizable(false);

        JLabel DSCELEB2 = new JLabel();
        DSCELEB2.setText("SUCESS!");
        DSCELEB2.setForeground(new Color(111, 255, 5));
        DSCELEB2.setFont(new Font("Monocraft", Font.BOLD, 50));
        DSCELEB2.setBounds(270, 50, 500, 50);

        JLabel DSCONGRATS2 = new JLabel();
        DSCONGRATS2.setText("<html><div style='line-height: 0.5;'>TOTAL CURRENT: " + CurrentBalance2 + "<br/>TOTAL SAVINGS: " + SavingBalance2 + "</div></html>");
        DSCONGRATS2.setForeground(Color.WHITE);
        DSCONGRATS2.setFont(new Font("Monocraft", Font.BOLD, 15));
        DSCONGRATS2.setBounds(270, 120, 400, 50);

        JLabel DSLikeSign2 = new JLabel();
        ImageIcon DSLikeSignIcon2 = new ImageIcon("LIKE.png");
        DSLikeSign2.setIcon(DSLikeSignIcon2);
        DSLikeSign2.setBounds(50, 50, 153, 151); 
        DSLikeSign2.setOpaque(false);

        JButton DSOKButton2 = new JButton();
        DSOKButton2.setBackground(new Color(153,255,51));
        DSOKButton2.setText("OK");
        DSOKButton2.setForeground(Color.BLACK);
        DSOKButton2.setFont(new Font("Monocraft",Font.BOLD,15));
        DSOKButton2.setBounds(390, 190, 80, 40);
        DSOKButton2.setFocusable(false);

        DSOKButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DS2.dispose();
            }
        });
        DS2.add(DSCELEB2);
        DS2.add(DSCONGRATS2);
        DS2.add(DSLikeSign2);
        DS2.add(DSOKButton2);
        DS2.setVisible(true);

    }

    public void INSUFFICIENTBALANCE2(){
        Border INSUFFICIENTBALANCEFrameBorder2 = BorderFactory.createLineBorder(new Color(0, 0, 225));
        JFrame  INSUFFICIENTBALANCE2 = new JFrame("Empty Field Notice");
        INSUFFICIENTBALANCE2.setBackground(Color.BLACK);
        ImageIcon WarningLogo12 = new ImageIcon("WARNINGLOGO.png");
        INSUFFICIENTBALANCE2.setIconImage(WarningLogo12.getImage());
        INSUFFICIENTBALANCE2.getContentPane().setBackground(Color.BLACK);
        INSUFFICIENTBALANCE2.setLayout(null);
        INSUFFICIENTBALANCE2.setSize(700, 300);
        INSUFFICIENTBALANCE2.setLocationRelativeTo(null);
        INSUFFICIENTBALANCE2.getRootPane().setBorder( INSUFFICIENTBALANCEFrameBorder2);

        JLabel  INSUFFICIENTBALANCEQuestionMark2= new JLabel();
        INSUFFICIENTBALANCEQuestionMark2.setText("INVALID!");
        INSUFFICIENTBALANCEQuestionMark2.setForeground(new Color(255,0,0));
        INSUFFICIENTBALANCEQuestionMark2.setFont(new Font("Monocraft", Font.BOLD, 40));
        INSUFFICIENTBALANCEQuestionMark2.setBounds(270, 50, 500, 50); 
        
        JLabel  INSUFFICIENTBALANCEProvide2 = new JLabel();
        INSUFFICIENTBALANCEProvide2.setText("Insufficient Balance");
        INSUFFICIENTBALANCEProvide2.setForeground(Color.WHITE);
        INSUFFICIENTBALANCEProvide2.setFont(new Font("Monocraft", Font.BOLD, 15));
        INSUFFICIENTBALANCEProvide2.setBounds(270, 100, 400, 50);

        JLabel  INSUFFICIENTBALANCEWarningSign12 = new JLabel();
        ImageIcon  INSUFFICIENTBALANCEWarningSignIcon12 = new ImageIcon("WARNINGSIGN.png");
        INSUFFICIENTBALANCEWarningSign12.setIcon( INSUFFICIENTBALANCEWarningSignIcon12);
        INSUFFICIENTBALANCEWarningSign12.setBounds(50, 50, 153, 151); 
        INSUFFICIENTBALANCEWarningSign12.setOpaque(false);

        JButton  INSUFFICIENTBALANCEOKButton2 = new JButton();
        INSUFFICIENTBALANCEOKButton2.setBackground(new Color(153,255,51));
        INSUFFICIENTBALANCEOKButton2.setText("OK");
        INSUFFICIENTBALANCEOKButton2.setForeground(Color.BLACK);
        INSUFFICIENTBALANCEOKButton2.setFont(new Font("Monocraft",Font.BOLD,15));
        INSUFFICIENTBALANCEOKButton2.setBounds(390, 170, 80, 40);
        INSUFFICIENTBALANCEOKButton2.setFocusable(false);

        INSUFFICIENTBALANCEOKButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INSUFFICIENTBALANCE2.dispose();
                }   
        });
        INSUFFICIENTBALANCE2.add( INSUFFICIENTBALANCEQuestionMark2);
        INSUFFICIENTBALANCE2.add( INSUFFICIENTBALANCEProvide2);
        INSUFFICIENTBALANCE2.add( INSUFFICIENTBALANCEOKButton2);
        INSUFFICIENTBALANCE2.add( INSUFFICIENTBALANCEWarningSign12);
        INSUFFICIENTBALANCE2.setVisible(true);
       
    }
}







 
