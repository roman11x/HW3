package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForm extends JFrame implements ActionListener {
    JButton goBack = new JButton("Back To Main Menu");
    ImageIcon back = new ImageIcon("goBackIcon.png");
    public SignUpForm(){
        this.setTitle("Sign Up Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(420,420);
        goBack.setIcon(back);
        goBack.addActionListener(this);
        this.add(goBack);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == goBack){
           AdminMainMenu mainMenu = new AdminMainMenu();
           this.dispose();
       }
    }
}
