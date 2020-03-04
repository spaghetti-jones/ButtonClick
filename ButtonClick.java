// Author: Luis Barrera
// Code by Eric Pogue from the original ButtonClick.java
// Assignment: ButtonClick | Quiz 4
// Minor addition: Added a button "Button 4"
// Minor addition: Click Button 4 to replace it with another button

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt. FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SeperateActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("SeperateActionListener::actionPerformed!");
    }
}

class ButtonFrame extends JFrame implements ActionListener{
    public ButtonFrame() {
        setBounds(100,100,800,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        button1.addActionListener(this);

        JButton button2 = new JButton("Button 2");
        button2.addActionListener(new SeperateActionListener());

        JButton button3 = new JButton("Button 3");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Anonymous::actionPerformed");
            }
        });

        JButton button4 = new JButton("Button 4");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            myButtonPanel.remove(button4);
            JButton replacement = new JButton("replacement");
            System.out.println("Button 4 has been replaced!");
            myButtonPanel.add(replacement);
            myButtonPanel.revalidate();
            myButtonPanel.repaint();
            }
        });

        myButtonPanel.add(button1);
        myButtonPanel.add(button2);
        myButtonPanel.add(button3);

        myButtonPanel.add(button4);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(myButtonPanel, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("myButtonFrame::actionPerformed!");
    }
}

public class ButtonClick {
    public static void main(String[] args) {
        System.out.println("Hello ButtonClick!");

        ButtonFrame myButtonFrame = new ButtonFrame();
        myButtonFrame.setVisible(true);
    }
}