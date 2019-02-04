package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StartPanel_P11 panelsession;

	public PanelPrincipal(Control control) {
		setBorder(new EmptyBorder(110,0,0,0));
//		setVisible(true);
		panelsession = new StartPanel_P11(control);
		add(panelsession);
		System.out.println("dd");
		setOpaque(false);
	}
	public boolean confirmAdmin(String name, String pasword){
		return panelsession.confirmAdmin(name, pasword);
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		arg0.drawImage(new ImageIcon("src/imgs/fondoapp.png").getImage(), 0, 0, getWidth(), getHeight(), null);
		super.paintBorder(arg0);
	}
}
