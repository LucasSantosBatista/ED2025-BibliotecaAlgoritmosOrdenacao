package br.lucassbatista;

public class AlgoritmosOrdenacao {
	
	public AlgoritmosOrdenacao() {
		super();
	}
	
	
	public int[] bubbleSort(int[] vetor, int tamanho) {
		// Condição de parada: vetor de 1 posição
		if (tamanho == 1) {
			return vetor;
		}

		// Passa pelo vetor e empurra o maior elemento para o final
		for (int contador = 0; contador < tamanho - 1; contador++) {
			if (vetor[contador] > vetor[contador + 1]) {
				// Troca os elementos
				int aux = vetor[contador];
				vetor[contador] = vetor[contador + 1];
				vetor[contador + 1] = aux;
			}
		}

		// Chama recursivamente para o restante do vetor
		return bubbleSort(vetor, tamanho - 1);
	}

	public int[] mergeSort(int[] vetor, int inicio, int fim) {
		// Condição de parada: vetor de 1 posição
		if (inicio < fim) {
			// Define posição do meio do vetor
			int meio = (inicio + fim) / 2;

			// Divide vetor em subvetores à esquerda e direita
			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio + 1, fim);

			// Merge subvetores e ordena
			intercala(vetor, inicio, meio, fim);
		}
		return vetor;
	}

	private void intercala(int[] vetor, int inicio, int meio, int fim) {
		// Copia vetor para vetor auxiliar
		int novoVetor[] = new int[vetor.length];
		for (int i = inicio; i <= fim; i++) {
			novoVetor[i] = vetor[i];
		}

		// Define ponteiros
		int esquerda = inicio;
		int direita = meio + 1;

		// Define contador e executa comparações
		for (int contador = inicio; contador <= fim; contador++) {
			if (esquerda > meio) {
				// Se ponteiro da esquerda for maior que ponteiro do meio, vetor recebe valor da
				// direita
				vetor[contador] = novoVetor[direita];
				direita++;
			} else if (direita > fim) {
				// Senão, se ponteiro da direita for maior que o fim, vetor recebe valor da
				// esquerda
				vetor[contador] = novoVetor[esquerda];
				esquerda++;
			} else if (novoVetor[esquerda] < novoVetor[direita]) {
				// Senão, se valor na posição esquerda for menor que valor na posição da
				// direita, vetor recebe valor da esquerda
				vetor[contador] = novoVetor[esquerda];
				esquerda++;
			} else {
				// Senão vetor recebe valor da direita
				vetor[contador] = novoVetor[direita];
				direita++;
			}
		}
	}
	
	public int[] quickSort(int[] vetor, int inicio, int fim) {
		//Condição de parada: vetor de 1 posição
		if (fim > inicio) {
			int pivoFixo = dividir(vetor, inicio, fim); //Determina pivo fixo
			quickSort(vetor, inicio, pivoFixo - 1); //Subvetor da esquerda
			quickSort(vetor, pivoFixo + 1, fim); //Subvetor da direita
		}
		
		return vetor;
	}
	
	private int dividir(int[] vetor, int inicio, int fim) {
		//Define pivo e ponteiros
		int pivo = vetor[inicio];
		int ponteiroEsquerda = inicio + 1;
		int ponteiroDireita = fim;
		
		//Enquanto ponteiros não cruzarem
		while(ponteiroEsquerda <= ponteiroDireita) {
			//Enquanto ponteiros não cruzarem E valor da esquerda for menor que pivo
			while (ponteiroEsquerda <= ponteiroDireita && vetor[ponteiroEsquerda] <= pivo) {
				ponteiroEsquerda++;
			}
			//Enquanto ponteiros não cruzarem E valor da direita for maior que pivo
			while (ponteiroDireita >= ponteiroEsquerda && vetor[ponteiroDireita] > pivo) {
				ponteiroDireita--;
			}
			//Caso movimento dos ponteiros cessarem mas não cruzarem
			if (ponteiroEsquerda < ponteiroDireita) {
				trocar(vetor, ponteiroEsquerda, ponteiroDireita);
				ponteiroEsquerda++;
				ponteiroDireita--;
			}
		}
		
		//Troca valor com valor no ponteiro da direita, e o retorna para o pivo fixo dos subvetores
		trocar(vetor, inicio, ponteiroDireita);
		return ponteiroDireita;
	}
	
	private void trocar(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
}
