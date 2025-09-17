public class InsertionSort {

    public static void sort(int[] arr) {
        sort(arr, false);
    }

    public static void sort(int[] arr, boolean decrescente) {
        if (arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            if (!decrescente) {
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            } else {
                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 5, 6};
        System.out.print("Original: ");
        printArray(a);

        sort(a);
        System.out.print("Crescente: ");
        printArray(a);

        int[] b = {5, 2, 9, 1, 5, 6};
        sort(b, true);
        System.out.print("Decrescente: ");
        printArray(b);
    }
}
