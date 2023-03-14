package br.edu.fateczl.ordenavet;

import javax.swing.JOptionPane;

public class Operacoes {

	public int[] opBuble(int[] vetor, int tamanho) {
		
		int soma = 0;
		int aux = 0;
		
		System.out.println(java.util.Arrays.toString(vetor)+" Rodada #1");
		
		for(int i = 0 ; i < tamanho ; i++) {
			for(int j = i+1 ; j <= tamanho ; j++) {
				if(vetor[i] > vetor[j]) {
					aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
					soma = soma + 1;
				}
			}
			System.out.println(java.util.Arrays.toString(vetor)+" Rodada #"+(i+2));
		}
		JOptionPane.showMessageDialog(null, "Foram necessárias "+soma+" trocas para poder organizar este vetor.");
		return vetor;
		
	}
	
	public int[] opMerge(int[] vetor, int inicio, int fim) {
		System.out.println("vetor da posição "+inicio+" até "+fim);
		
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			opMerge(vetor, inicio, meio);
			opMerge(vetor, meio +1, fim);
			intercala(vetor, inicio, meio, fim);
		}
		return vetor;
	}

	private void intercala(int[] vetor, int inicio, int meio, int fim) {
		int auxVet[] = new int[vetor.length];
		for(int i = inicio ; i <= fim; i++) {
			auxVet[i] = vetor[i];
		}
		
		int esq = inicio;
		int dir = meio+1;
		
		for(int cont = inicio ; cont <= fim ; cont++) {
			if(esq > meio) {
				vetor[cont] = auxVet[dir];
				dir++;
			}
			else if (dir > fim) {
				vetor[cont] = auxVet[esq];
				esq++;
			}
			else if(auxVet[esq] < auxVet[dir]) {
				vetor[cont] = auxVet[esq];
				esq++;
			}
			else {
				vetor[cont] = auxVet[dir];
				dir++;
			}
		}
	}
}
				
			
		
		
	


