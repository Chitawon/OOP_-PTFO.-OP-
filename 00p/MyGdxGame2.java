package com.mygdx.game;
import java.awt.image.*;
import javax.imageio.ImageIO;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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
	 private int n;
	 BufferedImage image;
	 public  JLabel imageLabel;
	
	public MyGdxGame() throws IOException {
		fr = new JFrame("game");
        p1 = new JPanel();
        p2 = new JPanel();
		btn1 = new JButton("click");
		txt1 = new JTextField("Dice");
		image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/1.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		btn1.addActionListener(this);
		p1.setLayout(new GridLayout(2,1));
		 p1.add(btn1);
	     p1.add(txt1);
	     p1.add(p2);
	     fr. getContentPane().add(p1);
	     fr.setFont(new Font("TimesRoman",Font.BOLD,60));
	        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        fr.pack();     
	        fr.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		  JLabel label = new JLabel(new ImageIcon(image));
		  p2.setLayout(new FlowLayout());
		     p2.add(label);
		Random rand = new Random();
		n = rand.nextInt(6);
		n += 1;
        System.out.println("Press : " + e.getActionCommand() + n);
        if((e.getSource().equals(btn1))&&(txt1.getText().equals("Dice"))){
        	if(n == 1) {
        		p2.remove(label);
					 try {
						image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/1.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  label = new JLabel(new ImageIcon(image));
					  System.out.println("Press : " + e.getActionCommand() + n);
					 p2.add(label);
        	}else if(n == 2) {
        		p2.remove(label);
					 try {
						image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/2.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  label = new JLabel(new ImageIcon(image));
					 p2.add(label);
        	}else if(n == 3) {
        		p2.remove(label);
					 try {
						image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/3.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  label = new JLabel(new ImageIcon(image));
					 p2.add(label);
        	}else if(n == 4) {
        		p2.remove(label);
					 try {
						image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/4.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  label = new JLabel(new ImageIcon(image));
					 p2.add(label);
        	}else if(n == 5) {
        		p2.remove(label);
					 try {
						image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/5.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  label = new JLabel(new ImageIcon(image));
					 p2.add(label);
        	}else if(n == 6) {
        		p2.remove(label);
        		try {
					 image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/6.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        		label = new JLabel(new ImageIcon(image));
				 p2.add(label);
        	}
          	txt1.setText("Stop");
        }else if((e.getSource().equals(btn1))&&(txt1.getText().equals("Stop"))){
        	if(txt1.getText().equals("Stop")) {
        	p2.remove(label);
			 try {
				image = ImageIO.read(new File("C:\\Users\\comnate\\Desktop\\dic/1.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
        	txt1.setText("Dice");
			 label = new JLabel(new ImageIcon(image));
			 p2.add(label);
    }
}
	public static void main(String[] args) throws IOException {
        new MyGdxGame();
    }

}
