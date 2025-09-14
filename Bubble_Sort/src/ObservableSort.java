
public abstract class ObservableSort {
	private SortObserver observer;
	private int contadorComparacao = 0;
	private int contadorTrocas = 0;
	
	public void setObserver(SortObserver observer) {
		this.observer = observer;
	}
	public int getContadorComparacao() {
		return contadorComparacao;
	}
	public void setContadorComparacao(int contadorComparacao) {
		this.contadorComparacao = contadorComparacao;
	}
	public int getContadorTrocas() {
		return contadorTrocas;
	}
	public void setContadorTrocas(int contadorTrocas) {
		this.contadorTrocas = contadorTrocas;
	}
	
	protected void notificarComparacao(int indice1, int indice2) {
		this.contadorComparacao++;
		if(observer!=null)
		observer.aoComparacao(indice1, indice2);
	}
	protected void notificarTrocas(int indice1, int indice2) {
		this.contadorTrocas++;
		if(observer!=null)
		observer.aoTrocar(indice1, indice2);
	}
	protected void notificarConclusao() {
		if(observer!=null)
		observer.aoConcluir(contadorComparacao, contadorTrocas);
	}
	
	/*protected void mostrarArray() {
		observer.aoRetornar();
	}*/
}
