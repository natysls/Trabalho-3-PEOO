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

	public Televisao(ArrayList<Canal> canaisCadastrados) {
		this.canaisDisponiveis = canaisCadastrados;
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
		if (alteracao.equalsIgnoreCase("incremento")) {
			novoVolume = this.volume + 1;
			if (novoVolume > VOLUME_MAX) {
				System.out.println("Volume não pode ser maior que dez!");
				return false;
			}
		} else if (alteracao.equalsIgnoreCase("decremento")) {
			novoVolume = this.volume - 1;
			if (novoVolume < VOLUME_MIN) {
				System.out.println("Volume não pode ser menor que um!");
				return false;
			}
		} else {
			System.out.println("Ação inválida!");
			return false;
		}

		this.setVolume(novoVolume);
		return true;
	}

	public abstract void cadastrarCanais();

	public boolean verificarCanalExistente(Canal canal) {
		if (!(this.canaisCadastrados.contains(canal))) {
			return false;
		}
		return true;
	}

	public void sintonizar(int numeroCanal) throws ExceptionCanalInexistente {
		for (Canal canal : canaisCadastrados) {
			if (canal.getNumero() == numeroCanal) {
				if (verificarCanalExistente(canal)) {
					canal.setNumero(numeroCanal);
				} else {
					throw new ExceptionCanalInexistente("Canal inexistente", numeroCanal);
				}
			}
		}
	}

	public void alterarCanal(String alteracao) {
		int aux = canaisCadastrados.indexOf(canalAtual); // indice do canal atual
		if (alteracao.equalsIgnoreCase("proximo")) { // lógica: r = D - d * q (formula do resto da divisão)
			aux += 1; // aumenta um
			aux %= canaisCadastrados.size(); // se for aux= 10%10 = 0(aux inicial)
		} else if (alteracao.equalsIgnoreCase("anterior")) { // lógica: D = d * q + r (formula da divisão)
			aux -= 1; // diminui um
			if (aux >= 0) {
				aux %= canaisCadastrados.size();
			} else {
				aux = canaisCadastrados.size() + aux;
			}
		}
		setCanalAtual(this.canaisCadastrados.get(aux));
	}

	public void informarDados() {
		System.out.println(canalAtual);
	}

	public void mostrarGrade() { // lista ordenada
		this.canaisCadastrados.stream().sorted(Comparator.comparing(Canal::getNumero)).forEach(System.out::println);
	}

}
