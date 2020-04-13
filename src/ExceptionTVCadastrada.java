
public class ExceptionTVCadastrada extends Exception{
	private Televisao tv;
	
	public ExceptionTVCadastrada(String mensagem, Televisao tv) {
		super(mensagem);
		this.tv = tv;
	}
	
}
