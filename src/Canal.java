
public class Canal {
	private int numero;
	private String nome;
	private boolean ehHD;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isEhHD() {
		return ehHD;
	}
	public void setEhHD(boolean ehHD) {
		this.ehHD = ehHD;
	}
	
	public Canal(int numero, String nome, boolean ehHD) {
		this.numero = numero;
		this.nome = nome;
		this.ehHD = ehHD;
	}
	@Override
	public String toString() { //para printar no informarDados()
		return "Canal [numero=" + numero + ", nome=" + nome + ", ehHD=" + ehHD + "]";
	}
	
	
	
	
	
}
