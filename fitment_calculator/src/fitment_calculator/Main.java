package fitment_calculator;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class Main extends JFrame {
	public static double camber;
	public static String camberstring;
	
	public static double offset;
	public static String offsetstring;
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Fitment Calculator");
		VisPanel panel = new VisPanel();
		
		JButton b = new JButton("Click");
		JLabel camberlabel = new JLabel();
		JLabel offsetlabel = new JLabel();
		JSlider camberslider = new JSlider(JSlider.HORIZONTAL, -25, 25, 0);
		JSlider offsetslider = new JSlider(JSlider.HORIZONTAL, -30, 30, 0);
		
		//---------OBJECT PROPERTIES----------
		camberlabel.setBounds(25, 10, 100, 30);
		offsetlabel.setBounds(100, 10, 100, 30);
		camberlabel.setText("Camber: ");
		offsetlabel.setText("Offset: ");
		b.setBounds(1125, 600, 100, 40);
		camberslider.setBounds(1100, 20, 100, 20);
		offsetslider.setBounds(1100, 40, 100, 20);
		panel.setBounds(25, 75, 1000, 600);
		
		//Button listener
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		camberslider.addChangeListener((ChangeEvent e) ->{
			JSlider src = (JSlider) e.getSource();
			camber = src.getValue();
			camberstring = Integer.toString(src.getValue());
			camberlabel.setText(" Camber: " + camberstring);
			panel.setCamber(camber);
			panel.repaint();
		});
		
		offsetslider.addChangeListener((ChangeEvent e) ->{
			JSlider src = (JSlider) e.getSource();
			offset = src.getValue();
			offsetstring = Integer.toString(src.getValue());
			offsetlabel.setText("Offset: " + offsetstring);
			panel.setOffset(offset);
			panel.repaint();
		});
		
		
		//----------FRAME/WINDOW SETTINGS--------
		f.add(b);f.add(camberlabel);f.add(offsetlabel);f.add(camberslider);f.add(offsetslider);f.add(panel); //add all objects to frame
		
		//f.pack();
		f.setSize(1280,720); 
		f.setLayout(null); 
		f.setVisible(true); 
	
		
	}
}
