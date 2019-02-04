package views;

public enum EnumsPrincipal {

	E_NEW_CLIENT_MB("Nuevo Cliente"),
	E_CREATE_CLIENT("Crear"),
	E_CANCEL_CREATE_CLIENT("Cancelar"),
	E_UPDATE("Actualizar"), 
	E_OK_BUTTON_SHOW_DATES("OK"),
	E_OK_BUTTON_WRITE_KEEKS("OK"),
	SHOW_DATES(""),
	EXIT(""),
	E_WEEKS(""),
	E_CONFIRM_ACCOUNT("Ingresar"),
	E_CREATE_ACCOUNT("Crear cuenta");
	
	
	private String valor;

	private EnumsPrincipal(String name) {
		this.valor = name;
	}

	@Override
	public String toString() {
		return valor;
	}
}
