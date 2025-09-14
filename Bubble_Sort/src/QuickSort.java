public class QuickSort extends ObservableSort {

	private void trocar(Integer[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	    notificarTrocas(i, j);
	}
	
    public Integer[] sort(Integer[] array) {
    		quickSort(array, 0, array.length - 1);
        notificarConclusao();
        return array;
    }

    private void quickSort(Integer[] array, int baixo, int alto) {
        if (baixo < alto) {
            int pivo = particionar(array, baixo, alto);
            quickSort(array, baixo, pivo - 1);
            quickSort(array, pivo + 1, alto);
        }
    }

    private int particionar(Integer[] array, int low, int high) {
        int pivo = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            notificarComparacao(j, high);
            if (array[j] <= pivo) {
                i++;
                trocar(array, i, j);
            }
        }
        trocar(array, i + 1, high);
        return i + 1;
    }
}
