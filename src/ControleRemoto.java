import java.util.ArrayList;

public class ControleRemoto {
	private ArrayList<Televisao> listaDeTVs = new ArrayList<>();

	public ArrayList<Televisao> getListaDeTVs() {
		return listaDeTVs;
	}

	public void setListaDeTVs(ArrayList<Televisao> listaDeTVs) {
		this.listaDeTVs = listaDeTVs;
	}
	

	public void adicionarTV(Televisao tv) throws ExceptionTVCadastrada {
		if (!(this.listaDeTVs.contains(tv))) {
			this.listaDeTVs.add(tv);
		} else {
			throw new ExceptionTVCadastrada("TV já cadastrada", tv);
		}
	}

	public void aumentarVolume() {
		for (Televisao tv : listaDeTVs) {
			tv.alterarVolume("incremento");
		}
	}

	public void diminuirVolume() {
		for (Televisao tv : listaDeTVs) {
			tv.alterarVolume("decremento");
		}
	}

	public void sintonizarCanal(int numCanal) throws ExceptionCanalInexistente {
		for (Televisao tv : listaDeTVs) {
			tv.sintonizar(numCanal);
			
		}
	}

	public void proximoCanal() {
		for (Televisao tv : listaDeTVs) {
			tv.alterarCanal("proximo");
		}
	}

	public void anteriorCanal() {
		for (Televisao tv : listaDeTVs) {
			tv.alterarCanal("anterior");
		}
	}

	public void informarDados(Televisao tv) {
		tv.informarDados();
	}

	public void mostrarGrade() {
		for (Televisao tv : listaDeTVs) {
			tv.mostrarGrade();
		}
	}

}
