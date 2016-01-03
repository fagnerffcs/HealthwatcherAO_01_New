package lib.exceptions;

public class InvalidDateException extends Exception {

	private static final long serialVersionUID = 6117265917835495475L;

	public InvalidDateException(int segundos, int minutos, int hora) {
		super("ExcecaoHora: ");
	}

	public InvalidDateException(String erro) {
		super("ExcecaoHora:" + erro);
	}
}