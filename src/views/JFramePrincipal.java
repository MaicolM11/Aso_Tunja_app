package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Control;


public class JFramePrincipal extends JFrame{


	private static final long serialVersionUID = 1L;

	private JPanel panelPrincipal;
	private JPanelCenter centerPanel;
	
	
	public JFramePrincipal(Control control) {
		panelPrincipal = new JPanel(new BorderLayout());
		setSize(new Dimension(300, 530));
		setLocationRelativeTo(null);
		centerPanel = new JPanelCenter();
		initComponents(control);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/icono.png"));
		setIconImage(icon);
	}
	
	
	
	private void initComponents(Control control) {
		// TODO Auto-generated method stub
		
		panelPrincipal.add(panelNorth(control), BorderLayout.NORTH);
		panelPrincipal.add(centerPanel, BorderLayout.CENTER);

		add(panelPrincipal);
	
	}
	
	
	private JPanel panelNorth(Control control) {
		JPanel panelNorth = new JPanel();
		
		panelNorth.setPreferredSize(new Dimension(300, 40));
		panelNorth.setBackground(Color.decode("#042822"));
		
		
		
		panelNorth.add(new JMenuBar_Screen(control));
		
		
		
		JLabel txt = new JLabel("Aso Plaza");
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("Gabriola", Font.BOLD, 25));
		txt.setBorder(BorderFactory.createEmptyBorder(0, 70, 5, 60));
		panelNorth.add(txt);
		
		return panelNorth;
	}



	public void update(int client, double kilos) {
		// TODO Auto-generated method stub
		centerPanel.updateDates(client, kilos);
	}
	

	

	public void showMessage(String message){
		JOptionPane.showMessageDialog(null, message);;
	} 
	
	
	public int readInt(String titulo){
		int resultado= Integer.parseInt(JOptionPane.showInputDialog(null, titulo));
		return resultado;
	}
	
	public double readDouble(String titulo){
		double resultado= Double.parseDouble(JOptionPane.showInputDialog(null, titulo));
		return resultado;
	}
	
	



}
