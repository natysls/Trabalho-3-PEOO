import java.util.ArrayList;

public class SmartTV extends Televisao {
	private int polegadas;

	public int getPolegadas() {
		return polegadas;
	}

	public void setPolegadas(int polegadas) {
		this.polegadas = polegadas;
	}

	public SmartTV(ArrayList<Canal> canaisDisponiveis, int polegadas) {
		super(canaisDisponiveis);
		this.polegadas = polegadas;
	}

	@Override
	public void cadastrarCanais() {
		for (Canal canal : canaisDisponiveis) {
			this.canaisCadastrados.add(canal);
		}
		this.canalAtual = this.canaisCadastrados.get(0); // primeiro canal
	}

}
