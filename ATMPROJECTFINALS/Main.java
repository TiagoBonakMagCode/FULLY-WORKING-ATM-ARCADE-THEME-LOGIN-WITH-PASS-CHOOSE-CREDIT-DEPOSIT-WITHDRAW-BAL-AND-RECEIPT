import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Main {
    public static void main(String[] args) {
            jbtnMouseListeners1 ml = new jbtnMouseListeners1();
        };
    }
 
class jbtnMouseListeners1 {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JLabel label = new JLabel();
    JTextField tj = new JTextField();
    JTextField tj2 = new JTextField();
    JButton btn1 = new JButton("ADD");
    JButton btn2 = new JButton("MINUS");
 
 jbtnMouseListeners1(){
        frame.setResizable(false);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
 
        frame.add(panel1);
        frame.setVisible(true);
 
        panel1.setLayout(null);
        panel1.add(label);
       
        panel1.add(tj);
        tj.setBounds(30, 50, 600, 50);
        tj.setHorizontalAlignment(JTextField.CENTER);
        tj.setFont(new Font("Arial", Font.PLAIN, 30));
 
        panel1.add(tj2);
        tj2.setBounds(30, 120, 600, 50);
        tj2.setHorizontalAlignment(JTextField.CENTER);
        tj2.setFont(new Font("Arial", Font.PLAIN, 30));
 
        panel1.add(btn1);
        btn1.setBounds(30, 200, 150, 50);
        btn1.addActionListener(new ActionListener ()  {
            @Override
            public void actionPerformed(ActionEvent e){
            int uInput1 = Integer.parseInt(tj.getText());
            int uInput2 = Integer.parseInt(tj2.getText());
            int sum = uInput1 + uInput2;
            JOptionPane.showMessageDialog(label, "Sum: " + sum);
    }});
 
        panel1.add(btn2);
        btn2.setBounds(200, 200, 150, 50);
        btn2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int uInput1 = Integer.parseInt(tj.getText());
            int uInput2 = Integer.parseInt(tj2.getText());
            int diff = uInput1 - uInput2;
            JOptionPane.showMessageDialog(label, "Difference: " + diff);
    }});
 
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(30, 260, 600, 50);
        label.setFont(new Font("Consolas", Font.BOLD, 20));
    }
}