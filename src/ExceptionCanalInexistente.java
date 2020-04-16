
public class ExceptionCanalInexistente extends Exception {
	private int numeroCanal;

	public ExceptionCanalInexistente(String mensagem, int numeroCanal) {
		super(mensagem);
		this.numeroCanal = numeroCanal;
	}

}
