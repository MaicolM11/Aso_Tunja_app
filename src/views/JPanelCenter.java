package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCenter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel numClient ;
	private JLabel numKilos ;

	
	public JPanelCenter() {
		// TODO Auto-generated constructor stub
		
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 460));
		
		
		
		initComponents();
		
	}
	
	
	private void initComponents() {
		// TODO Auto-generated method stub
		JLabel txt = new JLabel("Clientes Registrados");
		txt.setFont(new Font( "Segoe UI", Font.ITALIC , 24));
		txt.setBorder(BorderFactory.createEmptyBorder(40, 0, 70, 0));
		txt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(txt);
		
		
		numClient = new JLabel("0");
		numClient.setFont(new Font( "Segoe UI", Font.ITALIC , 50));
		numClient.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(numClient);
		
		
		JLabel txt2 = new JLabel("Kilos Acumulados");
		txt2.setFont(new Font( "Segoe UI", Font.ITALIC , 22));
		txt2.setBorder(BorderFactory.createEmptyBorder(90, 0, 20, 0));
		txt2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(txt2);
		
		
		numKilos = new JLabel("0");
		numKilos.setFont(new Font( "Segoe UI", Font.ITALIC , 50));
		numKilos.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(numKilos);
		
		
	}


	@Override
	protected void paintComponent(Graphics fondo) {
		Image image = new ImageIcon("src/imgs/fondoPrincipal.png").getImage();
		fondo.drawImage(image, 0, 0, getWidth(), getHeight(), null);	
		super.paintComponent(fondo);
	}


	public void updateDates(int clients, double kilos) {
		// TODO Auto-generated method stub
		numClient.setText(""+clients);
		numKilos.setText(""+kilos);

		
	}
}
