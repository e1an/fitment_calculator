package fitment_calculator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class VisPanel extends JPanel{
	private Graphics2D g2;
	
	private static VisPanel instance;
	private static boolean instanceExists = false;
	
	private double camber;
	private double offsetcenter;
	
	RoundRectangle2D tire = new RoundRectangle2D.Double(400, 200, 100, 150, 10, 10); //x, y, w, h, arcw, arch //1 in = 10 px
	//Line2D offsetline = new Line2D.Double(450, 100, 450, 50);
	Line2D offsetline = new Line2D.Double(tire.getCenterX(), tire.getCenterY() - tire.getHeight() /2, tire.getCenterX(), tire.getCenterY() + tire.getHeight() /2);
	
	public VisPanel() {
		this.setBackground(Color.white);
		
	}
	
	public static VisPanel getInstance() {
		if(instanceExists == false) {
			instance = new VisPanel();
			return instance;
		}else {
			return instance;
		}
	}
	
	public void setCamber(double rotation) {
		camber = rotation;
	}
	
	public void setOffset(double offset) {
		offsetcenter = tire.getCenterY() + offset;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		
		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(camber), tire.getCenterX(), offsetcenter);
		g2.draw(at.createTransformedShape(tire));
		
		AffineTransform atline = AffineTransform.getRotateInstance(Math.toRadians(camber), tire.getCenterX(), tire.getCenterY());
		g2.draw(atline.createTransformedShape(offsetline));
		
		//g2.draw(offsetline);
	}
}
