import java.util.ArrayList;

public class TVHD extends Televisao{
	private String modelo; //LED, PLASMA, HD
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TVHD(ArrayList<Canal> canaisDisponiveis, String modelo){
		super(canaisDisponiveis);
		this.modelo = modelo;
	}

	@Override
	public void cadastrarCanais() {
		for(Canal canal: canaisDisponiveis) {
			if(canal.isEhHD() == true) {
				this.canaisCadastrados.add(canal);
			}else {
				System.out.println("Canal não cadastrado pois não é HD");
			}
		}
		this.canalAtual = this.canaisCadastrados.get(canaisCadastrados.size() - 1); //ultimo canal
		
	}

}
