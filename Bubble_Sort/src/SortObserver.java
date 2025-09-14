
public class SortObserver {
	public void aoComparacao(int indice1, int indice2) {
		System.out.println("Comparando indices: "+indice1+" com "+indice2);
	}
	
	public void aoTrocar(int indice1, int indice2) {
		System.out.println("Trocando indices: "+indice1+" com "+indice2);
	}
	
	public void aoConcluir(int totalComparacoes, int totalTrocas) {
		System.out.println("Total de comparações: "+totalComparacoes+" \n Total de trocas: "+ totalTrocas);
	}
}
