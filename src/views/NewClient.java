package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.Control;
import model.Client;

public class NewClient extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextField name;
	private JTextField lastName;
	private JTextField id;

	public NewClient(Control control) {
		panel = new JPanel();

		this.setBounds(0, 0, 300, 400);
		initComponents(control);
		setModal(true);
		setLocationRelativeTo(null);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/icono.png"));
		setIconImage(icon);

	}

	private void initComponents(Control control) {
		// TODO Auto-generated method stub
		GridLayout layt = new GridLayout(5, 1);
		layt.setVgap(10);
		panel.setLayout(layt);

		panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));

		JLabel txt = new JLabel("Nuevo cliente");
		txt.setFont(new Font("Gabriola", Font.BOLD, 25));
		txt.setForeground(Color.decode("#042822"));

		panel.add(txt);

		name = new JTextField();
		name.setOpaque(false);
		name.setForeground(Color.decode("#042822"));
		name.setBorder(editBorder("Nombres:"));
		panel.add(name);

		lastName = new JTextField();
		lastName.setOpaque(false);
		lastName.setForeground(Color.decode("#042822"));
		lastName.setBorder(editBorder("Apellidos:"));
		panel.add(lastName);

		id = new JTextField();
		id.setOpaque(false);
		id.setForeground(Color.decode("#042822"));
		id.setBorder(editBorder("Documento:"));
		panel.add(id);

		panel.add(buttons(control));

		panel.setBackground(Color.decode("#e3efa8"));
		this.add(panel);
	}
	
	private JPanel buttons(Control control) {
		
		
		JPanel panelBtt = new JPanel();
		panelBtt.setOpaque(false);
		GridLayout layt = new GridLayout(1, 2);
		layt.setHgap(10);
		panelBtt.setLayout(layt);
		
		JButton create = createButton("Crear");
		create.addActionListener(control);
		create.setActionCommand(EnumsPrincipal.E_CREATE_CLIENT.name());
		panelBtt.add(create);

		JButton cancel = createButton("Cancelar");
		cancel.addActionListener(control);
		cancel.setActionCommand(EnumsPrincipal.E_CANCEL_CREATE_CLIENT.name());
		panelBtt.add(cancel);
		
		return panelBtt;
	}

	private JButton createButton(String title) {
		JButton bttn = new JButton(title);
		
		bttn.setBackground(Color.decode("#042822"));
		bttn.setForeground(Color.WHITE);
		bttn.setFont(new Font("Gabriola", Font.BOLD, 18));
		bttn.setBorder(new RoundedBorder(20));

		return bttn;
	}
	
	private TitledBorder editBorder(String title) {
		Font formato = new Font("Gabriola", Font.BOLD, 18);

		return BorderFactory.createTitledBorder(null, title, TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, formato, Color.decode("#042822"));
	}

	public void cleanAll() {
		// TODO Auto-generated method stub
		name.setText("");
		lastName.setText("");
		id.setText("");

	}

	public Client createClient() {

		return new Client(name.getText(), lastName.getText(), Integer.parseInt(id.getText()));
	}

}
