package com.mygdx.game;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.badlogic.gdx.graphics.Texture;

public class MyGdxGame implements ActionListener{
	
	Texture img,img2,img3,img4,img5,img6;
	 private JFrame fr;
	 private JButton btn1;
	 private JTextField txt1;
	 private JPanel p1,p2;
	
	public MyGdxGame() throws IOException {
		fr = new JFrame("game");
        p1 = new JPanel();
        p2 = new JPanel();
		btn1 = new JButton("click");
		txt1 = new JTextField("Dice");
		BufferedImage image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/1.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		btn1.addActionListener(this);
		p1.setLayout(new GridLayout(2,1));
		 p1.add(btn1);
	     p1.add(txt1);
	     p1.add(p2);
	     p2.setLayout(new FlowLayout());
	     p2.add(label);
	     fr. getContentPane().add(p1);
	     fr.setFont(new Font("TimesRoman",Font.BOLD,60));
	        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        fr.pack();     
	        fr.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
        System.out.println("Press : " + e.getActionCommand());
        if((e.getSource().equals(btn1))&&(txt1.getText().equals("   Dice"))){
        	txt1.setText("Stop");
        }else if((e.getSource().equals(btn1))&&(txt1.getText().equals("Stop"))){
        	txt1.setText("Dice");
        }
    }
	public static void main(String[] args) throws IOException {
        new MyGdxGame();
    }

}
