package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;

import controller.Control;

public class Starting_Screen_P1 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelPrincipal panelPrincipal;

	public Starting_Screen_P1(Control control) {
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/icono.png"));
		setIconImage(icon);
		panelPrincipal = new PanelPrincipal(control);
//		setLocationRelativeTo(null);
		setVisible(true);
		setSize(new Dimension(300, 530));
		setBackground(Color.decode("#042822"));
		setLocationRelativeTo(null);
		add(panelPrincipal);
	}

	public boolean confirmAdmin(String name, String pasword) {
		return panelPrincipal.confirmAdmin(name, pasword);
	}

}
