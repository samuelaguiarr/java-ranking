import java.util.Scanner;

public class RobocupRanking {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int quantidadeEquipe;
		int numeroEquipe[];
		int totalCombate;
		String resultado[];
		int totalPonto[];
		double notaDesign[];
		int auxPonto;
		int auxEquipe;
		double auxDesign;

		System.out.print("Quantidade de equipes --> ");
		quantidadeEquipe = teclado.nextInt();

		System.out.print("Quantidade de combates --> ");
		totalCombate = teclado.nextInt();

		resultado = new String[totalCombate];

		numeroEquipe = new int[quantidadeEquipe];

		notaDesign = new double[quantidadeEquipe];

		totalPonto = new int[quantidadeEquipe];

		// ENTRADA DAS EQUIPES
		for (int i = 0; i < quantidadeEquipe; i++) {
			System.out.print("Número da equipe " + (i + 1) + " (11-99) --> ");
			numeroEquipe[i] = teclado.nextInt();

			// VERIFICAR SE ESTÁ ENTRE 11 E 99
			while (numeroEquipe[i] < 11 || numeroEquipe[i] > 99) {
				System.out.println("O número precisa ser entre 11 e 99. Digite outro");
				numeroEquipe[i] = teclado.nextInt();
			}
			// VERIFICAR NÚMERO DUPLICADO
			for (int j = 0; j < i; j++) {
				if (numeroEquipe[i] == numeroEquipe[j]) {
					System.out.println("Este número já está em uso, tente outro.");
					numeroEquipe[i] = teclado.nextInt();
				}
			}
			totalPonto[i] = 0;
			// ENTRADA DO RESULTADO DOS COMBATES
			for (int cont = 0; cont < totalCombate; cont++) {
				System.out.println("Combate " + (cont + 1) + " digite V (Vitória), E (Empate) ou D(Derrota): ");
				resultado[cont] = teclado.next();

				// VERIFICAR SE FOI DIGITADO CORRETAMENTE
				while (!resultado[cont].equalsIgnoreCase("V") && !resultado[cont].equalsIgnoreCase("E")
						&& !resultado[cont].equalsIgnoreCase("D")) {
					System.out.println("Letra inváilida. Digite V (Vitória) ou E (Empate) ou D (Derrota):");
					resultado[cont] = teclado.next();
				}
				// SOMA DOS PONTOS
				if (resultado[cont].equalsIgnoreCase("V")) {
					totalPonto[i] += 5;
				}
				if (resultado[cont].equalsIgnoreCase("E")) {
					totalPonto[i] += 3;
				}
			}
			// NOTA DE DESIGN
			System.out.println("Nota de design da equipe " + (numeroEquipe[i]) + " (0-10): ");
			notaDesign[i] = teclado.nextDouble();

			// VERIFICAR SE ESTÁ ENTRE 0 E 10
			while (notaDesign[i] < 0 || notaDesign[i] > 10) {
				System.out.println("Nota precisa estar entre 0 e 10, digite novamente!");
				notaDesign[i] = teclado.nextDouble();
			}

			// SAÍDA TOTAL DE PONTOS DAS EQUIPES
			System.out.println("Total de pontos da equipe " + (numeroEquipe[i]) + ": " + totalPonto[i]);
			System.out.println();
		}

		// ORDENAÇÃO DE NÚMERO DA EQUIPE, PONTUAÇÃO E DESEMPATE
		for (int j = 0; j < quantidadeEquipe; j++) {
			for (int i = 0; i < quantidadeEquipe - 1; i++) {
				if (totalPonto[i] < totalPonto[i + 1]
						|| (totalPonto[i] == totalPonto[i + 1] && notaDesign[i] < notaDesign[i + 1])) {
					auxPonto = totalPonto[i];
					totalPonto[i] = totalPonto[i + 1];
					totalPonto[i + 1] = auxPonto;

					auxEquipe = numeroEquipe[i];
					numeroEquipe[i] = numeroEquipe[i + 1];
					numeroEquipe[i + 1] = auxEquipe;

					auxDesign = notaDesign[i];
					notaDesign[i] = notaDesign[i + 1];
					notaDesign[i + 1] = auxDesign;
				}
			}
		}

		// CLASSIFICAÇÃO EM ORDEM DECRESCENTE
		System.out.println("Classificação: ");
		for (int i = 0; i < quantidadeEquipe; i++) {
			System.out.println(
					(i + 1) + "º lugar - " + "Equipe " + numeroEquipe[i] + ", total de pontos: " + totalPonto[i] +", nota de design: "+notaDesign[i]);
		}
	}
}
