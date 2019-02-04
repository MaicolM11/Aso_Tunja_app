package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Control;

public class StartPanel_P11 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel title1, title2;
	private JTextField user;
	private JPasswordField paswordtext;
	private JButton confirm, createAccount;

	public StartPanel_P11(Control control) {
		setBackground(Color.decode("#e3efa8"));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		init(control);
	}

	private void init(Control control) {
		
		title1 = new JLabel("Aso Plaza");
		title1.setFont(new Font("Gabriola", 2, 40));
		title1.setForeground(Color.decode("#042822"));
		title1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(title1);

		
		title2 = new JLabel("Tunja limpia para todos");
		title2.setFont(new Font("Gabriola", 0, 20));
		title2.setForeground(Color.decode("#042822"));
		title2.setAlignmentX(Component.CENTER_ALIGNMENT);
		title2.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		add(title2);

		
		add(panelCenter(control));
	
	}
	
	private JPanel panelCenter(Control control) {
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		user = new JTextField();
		user.setBorder(editBorder("Usuario: "));
		user.setOpaque(false);
		user.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(user);
		
		paswordtext = new JPasswordField();
		paswordtext.setBorder(editBorder("Contraseña: "));
		paswordtext.setOpaque(false);
		paswordtext.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(paswordtext);


		
		confirm = new JButton("INGRESAR");
		confirm.setFont(new Font("Gabriola", 1, 15));
		confirm.setForeground(Color.white);
		confirm.setBackground(Color.decode("#042822"));
		confirm.setActionCommand(EnumsPrincipal.E_CONFIRM_ACCOUNT.name());
		confirm.addActionListener(control);
		confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirm.setSize(30, 20);
		panel.add(confirm);



		createAccount = new JButton("¿No tienes cuenta? CREAR CUENTA");
		createAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		createAccount.setOpaque(false);
		createAccount.setForeground(Color.decode("#83C20D"));
		createAccount.setBackground(Color.decode("#83C20D"));
		createAccount.setBorder(null);
		createAccount.setActionCommand(EnumsPrincipal.E_CREATE_ACCOUNT.name());
		createAccount.addActionListener(control);
		panel.add(createAccount);
		return panel;
	}

	@SuppressWarnings("deprecation")
	public boolean confirmAdmin(String names, String pasword) {

			if (names.equals(user.getText()) && pasword.equals(paswordtext.getText())) {
				return true;
			}else {
				return false;
			}
	

	}
	
	private TitledBorder editBorder(String title) {
		Font formato = new Font("Gabriola", 2, 20);

		return BorderFactory.createTitledBorder(null, title, TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, formato, Color.decode("#042822"));
	}

}
