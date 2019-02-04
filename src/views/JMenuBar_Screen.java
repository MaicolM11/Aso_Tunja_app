package views;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Control;

public class JMenuBar_Screen extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JMenu menu;
	private JMenuItem newClient, showClients, exit, update, weeks;
	
	
	
	public JMenuBar_Screen(Control control) {
		this.setOpaque(false);

		this.initComponents(control);
	}

	private void initComponents(Control control) {
		// TODO Auto-generated method stub
		menu = new JMenu();
		menu.setIcon(new ImageIcon("src/imgs/menu.png"));
		menu.setBorderPainted(false);
		
		update = new JMenuItem("Actualizar");
		update.addActionListener(control);
		update.setActionCommand(EnumsPrincipal.E_UPDATE.name());
		
		
		newClient = new JMenuItem("Nuevo cliente");
		newClient.addActionListener(control);
		newClient.setActionCommand(EnumsPrincipal.E_NEW_CLIENT_MB.name());
		
		
		showClients = new JMenuItem("Mostrar clientes");
		showClients.addActionListener(control);
		showClients.setActionCommand(EnumsPrincipal.SHOW_DATES.name());
		
		
		weeks = new JMenuItem("Digitar semanas");
		weeks.addActionListener(control);
		weeks.setActionCommand(EnumsPrincipal.E_WEEKS.name());
		
		exit = new JMenuItem("exit");
		exit.addActionListener(control);
		exit.setActionCommand(EnumsPrincipal.EXIT.name());
		
		
		menu.add(update);
		menu.add(newClient);
		menu.add(showClients);
		menu.add(weeks);
		menu.add(exit);
		
		
		
		this.add(menu);

	}
	
}
