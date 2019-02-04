package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Client;
import model.ManagerModel;
import views.EnumsPrincipal;
import views.IoManager;
import views.JDShowClients;
import views.JDWriteWeeks;
import views.JFramePrincipal;
import views.NewClient;
import views.Starting_Screen_P1;

public class Control implements ActionListener {

	private JFramePrincipal frame;
	private NewClient newClient;
	private ManagerModel managerModel;
	private JDShowClients showClients;
	private ArrayList<Object[]> arrayClient = new ArrayList<>();
	private JDWriteWeeks writeWeek;
	private Starting_Screen_P1 panelInitP1;

	public Control() {

		frame = new JFramePrincipal(this);
		newClient = new NewClient(this);
		managerModel = new ManagerModel();
		showClients = new JDShowClients(this);
		panelInitP1 = new Starting_Screen_P1(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (EnumsPrincipal.valueOf(e.getActionCommand())) {

		case E_NEW_CLIENT_MB:
			showNewClient();
			break;

		case EXIT:
			frame.setVisible(false);
			break;
		case E_CANCEL_CREATE_CLIENT:
			newClient.setVisible(false);
			break;

		case E_CREATE_CLIENT:
			createClient();
			break;

		case E_UPDATE:
			updateDates();
			break;

		case SHOW_DATES:
			showClientsTable();
			break;

		case E_OK_BUTTON_SHOW_DATES:
			showClients.setVisible(false);
			break;

		case E_WEEKS:
			searchClient();
			break;

		case E_OK_BUTTON_WRITE_KEEKS:
			writeWeeks();
			break;

		case E_CONFIRM_ACCOUNT:
			confirmAccount();
			break;
		case E_CREATE_ACCOUNT:
			break;

		default:
			break;

		}
	}

	private void writeWeeks() {
		// TODO Auto-generated method stub
		writeWeek.setVisible(false);
		writeWeek.clean();
	}

	private void searchClient() {
		// TODO Auto-generated method stub
		int id = frame.readInt("Digite documento del cliente");
		Client clientSearch = managerModel.searchClient(id);
		if (clientSearch == null) {
			frame.showMessage("El cliente no existe");
		} else {

			creteNewWeek(clientSearch);
		}
	}

	private void creteNewWeek(Client clientSearch) {

		// TODO Auto-generated method stub

		double week = frame.readDouble("Digite los kilos reciclados");
		clientSearch.addWeek(week);

		writeWeek = new JDWriteWeeks(this, clientSearch.getSizeArray());

		writeWeek.getDates(clientSearch);
		writeWeek.setVisible(true);
	}

	private void updateDates() {
		// TODO Auto-generated method stub
		frame.update(managerModel.getSize(), managerModel.getTotalRecycle());

	}

	private void createClient() {
		// TODO Auto-generated method stub
		Client client = newClient.createClient();
		managerModel.addRecord(client);

		arrayClient.add(client.toObjectVector());
		newClient.setVisible(false);

	}

	private void showNewClient() {
		// TODO Auto-generated method stub
		newClient.setVisible(true);
		newClient.cleanAll();
	}

	private void showClientsTable() {

		showClients.clean();
		for (int i = 0; i < arrayClient.size(); i++) {
			showClients.addVectorToTable(arrayClient.get(i));
		}
		showClients.setVisible(true);

	}
	
	private void confirmAccount() {
		if (panelInitP1.confirmAdmin("", "")) {
			panelInitP1.setVisible(false);
			frame.setVisible(true);
		}else {
			IoManager.showMessage("Nombre o Contraseña incorrecta","    *** Error ***");
		}
	}
	
}
