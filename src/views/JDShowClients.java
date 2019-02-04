package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Control;

public class JDShowClients extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private JTable jtElements;
	private JScrollPane jsTable;
	private JPanel panel;

	public JDShowClients(Control control) {
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imgs/icono.png"));
		setIconImage(icon);

		this.setBounds(0, 0, 300, 400);
		this.setModal(true);
		this.setTitle("Show Dates");
		this.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		panel.setBackground(Color.decode("#e3efa8"));
		init(control);
	}

	private void init(Control control) {
		// TODO Auto-generated method stub

		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 14);

		JLabel title = new JLabel("Clientes registrados");
		title.setFont(fontHeader);
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setForeground(Color.decode("#042822"));
		title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
		panel.add(title);

		dtmElements = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String headers[] = { "Nombres", "Apellidos", "Documento" };

		dtmElements.setColumnIdentifiers(headers);
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.setFillsViewportHeight(true);
		jsTable = new JScrollPane(jtElements);
		jsTable.setPreferredSize(new Dimension(400, 300));

		jtElements.getTableHeader().setBackground(Color.decode("#042822"));
		jtElements.getTableHeader().setForeground(Color.white);
		jtElements.getTableHeader().setFont(fontHeader);
		jtElements.setBackground(Color.white);
		jtElements.setBorder(null);

		panel.add(jsTable);
		JButton ok = new JButton("OK");
		ok.setMaximumSize(new Dimension(100, 30));
		ok.setAlignmentX(CENTER_ALIGNMENT);
		ok.setBackground(Color.decode("#042822"));
		ok.setForeground(Color.white);
		ok.addActionListener(control);
		ok.setActionCommand(EnumsPrincipal.E_OK_BUTTON_SHOW_DATES.name());
		panel.add(ok);

		this.add(panel);
	}

	public void clean() {
		dtmElements.setRowCount(0);
	}

	public void addVectorToTable(Object[] objects) {
		// TODO Auto-generated method stub
		dtmElements.addRow(objects);
	}
}
