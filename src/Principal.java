import java.util.*;

public class Principal {
	public static void main(String[] args) {
		ArrayList<Canal> canais = new ArrayList<Canal>(); // lista de canais
		canais.add(new Canal(2, "RedeTV", false));
		canais.add(new Canal(5, "Cultura", true));
		canais.add(new Canal(8, "Record", false));
		canais.add(new Canal(10, "Globo", true));
		canais.add(new Canal(12, "SBT", true));
		canais.add(new Canal(14, "RecordNews", false));
		canais.add(new Canal(17, "TvUnião", true));
		canais.add(new Canal(19, "RedeBrasil", false));
		canais.add(new Canal(20, "Band", true));

		Televisao smarttv = new SmartTV(canais, 10); // polegadas
		Televisao tvhd = new TVHD(canais, "LED"); // modelo

		ControleRemoto controle = new ControleRemoto();

		Scanner teclado = new Scanner(System.in);
		while (true) {
			System.out.println("Escolha a sua TV: ");
			System.out.println("A - SmartTV  ou  B - TVHD");
			String escolha = teclado.next();
			if (escolha.equalsIgnoreCase("A")) {
				smarttv.cadastrarCanais();
				try {
					controle.adicionarTV(smarttv);
				} catch (ExceptionTVCadastrada e) {
					System.out.println(e);
				}
				opcoes(smarttv, controle, canais);
			} else if (escolha.equalsIgnoreCase("B")) {
				tvhd.cadastrarCanais(); // vai cadastrar so quem é HD
				try {
					controle.adicionarTV(tvhd);
				} catch (ExceptionTVCadastrada e) {
					System.out.println(e);
				}
				opcoes(tvhd, controle, canais);
			} else {
				System.out.println("Opção inválida");
			}
		}

	}

	// Realiza as opções
	private static void opcoes(Televisao tv, ControleRemoto controle, ArrayList<Canal> canais) {
		Scanner scan = new Scanner(System.in);
		while (true) { // loop infinito.
			printMenu(); // imprime o Menu
			int opcao = scan.nextInt();
			if (opcao == 1) {
				controle.aumentarVolume();
				System.out.println("Volume: " + tv.getVolume() + "\n");
			} else if (opcao == 2) {
				controle.diminuirVolume();
				System.out.println("Volume: " + tv.getVolume() + "\n");
			} else if (opcao == 3) {
				controle.proximoCanal();
				System.out.println("Canal: " + tv.getCanalAtual() + "\n");
			} else if (opcao == 4) {
				controle.anteriorCanal();
				System.out.println("Canal: " + tv.getCanalAtual() + "\n");
			} else if (opcao == 5) {
				controle.informarDados(tv);
			} else if (opcao == 6) {
				System.out.println("Digite o número do canal para sintonizar");
				int numCanal = scan.nextInt();
				try {
					controle.sintonizarCanal(numCanal);
				} catch (ExceptionCanalInexistente e) {
					e.getMessage();
				}
				System.out.println("Canal Atual: " + tv.getCanalAtual() + "\n");
			} else if (opcao == 7) {
				controle.mostrarGrade();
			} else if (opcao == 0) { // o Loop para aqui.
				System.exit(0); // Saindo do programa
			} else {
				System.out.println("Opção inválida");
				printMenu();
			}
		}
	}

	// Imprime o menu
	private static void printMenu() {
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Aumentar Volume");
		System.out.println("2 - Diminuir Volume");
		System.out.println("3 - Proximo Canal");
		System.out.println("4 - Anterior Canal");
		System.out.println("5 - Informar Dados do Canal Atual");
		System.out.println("6 - Sintonizar Canal");
		System.out.println("7 - Mostrar Grade");
		System.out.println("0 - EXIT");
	}
}
