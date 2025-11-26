public class Sorts {
    // ---------- BUBBLE SORT ----------
    public static void bubbleSort(int[] array, boolean crescente) {
        int n = array.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if ((crescente && array[j] > array[j + 1]) ||
                    (!crescente && array[j] < array[j + 1])) {
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    // ---------- QUICK SORT ----------
    public static void quickSort(int[] array, boolean crescente) {
        quickSortRec(array, 0, array.length - 1, crescente);
    }

    private static void quickSortRec(int[] array, int inicio, int fim, boolean crescente) {
        if (inicio < fim) {
            int pivoIndex = particionar(array, inicio, fim, crescente);
            quickSortRec(array, inicio, pivoIndex - 1, crescente);
            quickSortRec(array, pivoIndex + 1, fim, crescente);
        }
    }

    private static int particionar(int[] array, int inicio, int fim, boolean crescente) {
        int pivo = array[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if ((crescente && array[j] <= pivo) ||
                (!crescente && array[j] >= pivo)) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }

    // ---------- CÓPIA DE ARRAY ----------
    public static int[] copiarArray(int[] origem) {
        int[] copia = new int[origem.length];
        for (int i = 0; i < origem.length; i++) {
            copia[i] = origem[i];
        }
        return copia;
    }
}
