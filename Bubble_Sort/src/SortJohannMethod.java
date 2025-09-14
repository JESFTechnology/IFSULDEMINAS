import java.util.Comparator;

public class SortJohannMethod<T> extends ObservableSort{
	private void troca(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
	}
	
	@SuppressWarnings("null")
	public Integer[] sort(Integer[] array){
		Integer[] arrayReturn = array;
		int menorValor = 1000000000;
		int coord = 0;

		for(int i=0;i<array.length-1;i++){
			System.out.print(i);
    			if(array[i] < menorValor) {
        			menorValor = array[i];
        			arrayReturn[coord] = array[i];
        			coord++;
        			i = 0;
    			}
    			System.out.print(" | "+coord+" | ");
    			System.out.println(arrayReturn[i]);
    		}
        return arrayReturn;
    }

}
