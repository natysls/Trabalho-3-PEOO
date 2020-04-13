import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public abstract class Televisao {
	private String id;
	private int volume;
    Canal canalAtual;
    ArrayList<Canal> canaisCadastrados = new ArrayList<>();
    ArrayList<Canal> canaisDisponiveis = new ArrayList<>();

    public static final int VOLUME_MAX = 10;
    public static final int VOLUME_MIN = 0;
    
    public Televisao(ArrayList<Canal> canaisDisponiveis) {
        this.canaisCadastrados = canaisDisponiveis;
        this.volume = 5;
    }

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Canal getCanalAtual() {
		return canalAtual;
	}
	public void setCanalAtual(Canal canalAtual) {
		this.canalAtual = canalAtual;
	}
    
    public boolean alterarVolume(String alteracao) {
    	int novoVolume = 0;
    	if(alteracao.equalsIgnoreCase("incremento")) {
    		novoVolume = this.volume + 1;
    		if (novoVolume > VOLUME_MAX){
                System.out.println("Volume n�o pode ser maior que dez!");
                return false;
            }
    	}else if(alteracao.equalsIgnoreCase("decremento")) {
    		novoVolume = this.volume - 1;
    		if (novoVolume < VOLUME_MIN){
                System.out.println("Volume n�o pode ser menor que um!");
                return false;
            }
    	}else {
            System.out.println("A��o inv�lida!");
            return false;
        }

        this.setVolume(novoVolume);
        return true;
    }
    
    public abstract void cadastrarCanais();
    
    public boolean verificarCanalExistente(Canal canal) {
		for (Canal canalInterno : this.canaisCadastrados){
            if (!(canalInterno.getNumero() == canal.getNumero())){
                return false;
            }
        }
        return true;
    }
    
    public void sintonizar(int numeroCanal) throws ExceptionCanalInexistente {
    	for(Canal canal: canaisCadastrados) {
    		if(canal.getNumero() == numeroCanal) {
    			if(verificarCanalExistente(canal)) {
    				canal.setNumero(numeroCanal);
    			}else {
    				throw new ExceptionCanalInexistente("Canal inexistente", numeroCanal);
    			}
    		}
    	}
    }
    
    public void alterarCanal(String alteracao) {
    	int aux = canaisCadastrados.indexOf(canalAtual); //indice do canal atual
    	if(alteracao.equalsIgnoreCase("proximo")) {
    		aux += 1; //aumenta um indice
    		if(aux == (this.canaisCadastrados.size() - 1)) { //se o indice atual for igual ao final
    			setCanalAtual(this.canaisCadastrados.get(0));
    		}
    	}else if(alteracao.equalsIgnoreCase("anterior")){
    		aux -= 1; //diminui um
    		if(aux == this.canaisCadastrados.size()) {
    			for (int i = aux; i < canaisCadastrados.size(); i++) { 
    				  setCanalAtual(this.canaisCadastrados.get(i)); 
    			}
    		}else {
    			System.out.println("Canal invalido");
    		}
    	}
    }
    
    public void informarDados() {
    	System.out.println(canalAtual);
    }
    
    public void mostrarGrade() { //lista ordenada
    	for(Canal canais: canaisCadastrados) {
	    	System.out.println(this.canaisCadastrados.stream().sorted(
	    			Comparator.comparing(Canal::getNumero)).collect(
	    					Collectors.toList()));
    	}
    }
    
    
}