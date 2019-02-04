package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controller.Control;
import model.Client;


public class JDWriteWeeks extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private JTable jtElements;
	private JScrollPane jsTable;
	private JPanel panel;
	private JLabel name;
	private JLabel lastName;
	private JLabel id ;
	private String[] headers;
	private JLabel totalTxt;

	
	public JDWriteWeeks(Control control,int sizeArray) {
		this.setBounds(0, 0, 300, 210);
		this.setModal(true);
		this.setTitle("Write weeks");
		this.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		panel.setBackground(Color.decode("#e3efa8"));
		
		makeHeaders(sizeArray);
		init(control);
	}


	private void init(Control control) {
		// TODO Auto-generated method stub
		
		name = new JLabel("");
		name.setAlignmentX( CENTER_ALIGNMENT );

		panel.add(name);
		

		lastName = new JLabel("");
		lastName.setAlignmentX( CENTER_ALIGNMENT );

		panel.add(lastName);
		
		id = new JLabel("");
		id.setAlignmentX( CENTER_ALIGNMENT );
		
		panel.add(id);
		
		
		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 14);
		
		dtmElements = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		dtmElements.setColumnIdentifiers(headers);		
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.setFillsViewportHeight(true);
		jsTable = new JScrollPane(jtElements);
		
		
		jtElements.getTableHeader().setBackground(Color.decode("#042822"));
		jtElements.getTableHeader().setForeground(Color.white);
		jtElements.getTableHeader().setFont(fontHeader);
		
		jsTable.setOpaque(false);
		panel.add(jsTable);
		
		
		totalTxt = new JLabel("");
		totalTxt.setAlignmentX(CENTER_ALIGNMENT);
		totalTxt.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		panel.add(totalTxt);
		
		
		JButton ok = new JButton("OK");
		ok.setMaximumSize(new Dimension(100,30));
		ok.setAlignmentX( CENTER_ALIGNMENT );
		ok.setBackground(Color.decode("#042822"));
		ok.setForeground(Color.white);
		ok.addActionListener(control);
		ok.setActionCommand(EnumsPrincipal.E_OK_BUTTON_WRITE_KEEKS.name());
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
	


	public void getDates(Client clientSearch) {
		// TODO Auto-generated method stub
				
		name.setText("Nombres: "+clientSearch.getName());
		lastName.setText("Apellidos: "+clientSearch.getLastName());
		id.setText("ID: "+clientSearch.getId());
		addVectorToTable(clientSearch.getRegisterToTable());
		totalKilos(clientSearch.getRegister());
	}
	
	
	private void totalKilos(ArrayList<Double> register) {
		
		double total =0;
		for (int i = 0; i < register.size(); i++) {
			total+= register.get(i);
		}
		totalTxt.setText("Total "+total+ " kilos");
		
	}


	private void makeHeaders(int sizeArray) {
		// TODO Auto-generated method stub
		headers = new  String[sizeArray];
		
		for (int i = 0; i < sizeArray; i++) {
			headers[i] = "SEM"+(i+1);
		}
	}

	
}
