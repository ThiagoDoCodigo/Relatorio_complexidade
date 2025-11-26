import java.util.Random;
import arvoreAVL.Tree;
import arvoreAVL.Sheet;
import arvoreBinaria.TreeBinary;
import arvoreBinaria.SheetBinary;
import array.Array;

public class Main {

    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        return array;
    }

    public static double measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    private static void printTableHeader(String title) {
        System.out.println("\n===============================================================");
        System.out.println(title.toUpperCase());
        System.out.println("===============================================================");
    }

    private static void printSortHeader(String title) {
        System.out.println("\n--- " + title + " ---");
        System.out.printf("| %-11s | %-7s | %-12s | %-10s |\n", "Tipo", "Tamanho", "Ordem", "Tempo (ms)");
        System.out.println("---------------------------------------------------------------");
    }

    private static void printSortResult(String tipo, int tamanho, String ordem, double tempo) {
        System.out.printf("| %-11s | %-7d | %-12s | %-10.3f |\n", tipo, tamanho, ordem, tempo);
    }

    private static void printSearchResult(String tipo, int valor, boolean encontrado, double tempo) {
        System.out.printf("%-25s | Valor: %-8d | Encontrado: %-5s | Tempo: %.3f ms\n",
                tipo, valor, encontrado ? "true" : "false", tempo);
    }
    
    private static void printSearchResultArray(String tipo, int valor, boolean encontrado, double tempo, String method) {
        System.out.printf("%-25s | Valor: %-8d | Encontrado: %-5s | Tempo: %.3f ms | busca: %-16s\n",
                tipo, valor, encontrado ? "true" : "false", tempo, method);
    }


    public static void testSearchTimes(Tree tree, int[] array, String label) {
        Random random = new Random();

        int first = array[0];
        int last = array[array.length - 1];
        int middle = array[array.length / 2];
        int random1 = array[random.nextInt(array.length)];
        int random2 = array[random.nextInt(array.length)];
        int random3 = array[random.nextInt(array.length)];
        int notFound = 99999999;

        System.out.println("\n---- Testes de busca em " + label + " ----");

        double t1 = measureTime(() -> tree.search(first));
        printSearchResult("Busca primeiro elemento", first, tree.search(first) != null, t1);

        double t2 = measureTime(() -> tree.search(last));
        printSearchResult("Busca ultimo elemento", last, tree.search(last) != null, t2);

        double t3 = measureTime(() -> tree.search(middle));
        printSearchResult("Busca elemento do meio", middle, tree.search(middle) != null, t3);

        double t4 = measureTime(() -> tree.search(random1));
        printSearchResult("Busca aleatoria 1", random1, tree.search(random1) != null, t4);

        double t5 = measureTime(() -> tree.search(random2));
        printSearchResult("Busca aleatoria 2", random2, tree.search(random2) != null, t5);

        double t6 = measureTime(() -> tree.search(random3));
        printSearchResult("Busca aleatoria 3", random3, tree.search(random3) != null, t6);

        double t7 = measureTime(() -> tree.search(notFound));
        printSearchResult("Busca inexistente", notFound, tree.search(notFound) != null, t7);
    }
    
    public static void testSearchTimesBinary(TreeBinary tree, int[] array, String label) {
        Random random = new Random();

        int first = array[0];
        int last = array[array.length - 1];
        int middle = array[array.length / 2];
        int random1 = array[random.nextInt(array.length)];
        int random2 = array[random.nextInt(array.length)];
        int random3 = array[random.nextInt(array.length)];
        int notFound = 99999999;

        System.out.println("\n---- Testes de busca em " + label + " ----");

        double t1 = measureTime(() -> tree.search(first));
        printSearchResult("Busca primeiro elemento", first, tree.search(first) != null, t1);

        double t2 = measureTime(() -> tree.search(last));
        printSearchResult("Busca ultimo elemento", last, tree.search(last) != null, t2);

        double t3 = measureTime(() -> tree.search(middle));
        printSearchResult("Busca elemento do meio", middle, tree.search(middle) != null, t3);

        double t4 = measureTime(() -> tree.search(random1));
        printSearchResult("Busca aleatoria 1", random1, tree.search(random1) != null, t4);

        double t5 = measureTime(() -> tree.search(random2));
        printSearchResult("Busca aleatoria 2", random2, tree.search(random2) != null, t5);

        double t6 = measureTime(() -> tree.search(random3));
        printSearchResult("Busca aleatoria 3", random3, tree.search(random3) != null, t6);

        double t7 = measureTime(() -> tree.search(notFound));
        printSearchResult("Busca inexistente", notFound, tree.search(notFound) != null, t7);
    }
    
    public static void testArrayClassSearch(Array<Integer> array, String label) {
        Random random = new Random();
   
        int first = array.getElement(0);
        int last = array.getElement(array.getSize() - 1);
        int middle = array.getElement(array.getSize() / 2);
        int random1 = array.getElement(random.nextInt(array.getSize()));
        int random2 = array.getElement(random.nextInt(array.getSize()));
        int random3 = array.getElement(random.nextInt(array.getSize()));
        int notFound = 99999999;
   
        System.out.println("\n---- Testes de busca usando Array<T> em " + label + " ----");
   
        double t1 = measureTime(() -> array.sequentialSearch(first));
        printSearchResultArray("Busca primeiro elemento", first, array.sequentialSearch(first) != -1, t1, "sequencial");
   
        double t2 = measureTime(() -> array.sequentialSearch(last));
        printSearchResultArray("Busca ultimo elemento", last, array.sequentialSearch(last) != -1, t2, "sequencial");
   
        double t3 = measureTime(() -> array.sequentialSearch(middle));
        printSearchResultArray("Busca elemento do meio", middle, array.sequentialSearch(middle) != -1, t3, "sequencial");
   
        double t4 = measureTime(() -> array.sequentialSearch(random1));
        printSearchResultArray("Busca aleatoria 1", random1, array.sequentialSearch(random1) != -1, t4, "sequencial");
        
        double t5 = measureTime(() -> array.sequentialSearch(random2));
        printSearchResultArray("Busca aleatoria 2", random2, array.sequentialSearch(random2) != -1, t5, "sequencial");
        
        double t6 = measureTime(() -> array.sequentialSearch(random3));
        printSearchResultArray("Busca aleatoria 3", random3, array.sequentialSearch(random3) != -1, t6, "sequencial");
    
        double t7 = measureTime(() -> array.sequentialSearch(notFound));
        printSearchResultArray("Busca inexistente", notFound, array.sequentialSearch(notFound) != -1, t7, "sequencial");
        
        if (!array.isSorted()) {
            System.out.println("Array nao ordenado. Testes de busca binaria ignorados.");
            return; 
       }
        
        
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        double tb1 = measureTime(() -> array.binarySearchRecursive(first));
        printSearchResultArray("Busca primeiro elemento", first, array.binarySearchRecursive(first) != -1, tb1, "binaria");
        
        double tb2 = measureTime(() -> array.binarySearchRecursive(last));
        printSearchResultArray("Busca ultimo elemento ", last, array.binarySearchRecursive(last) != -1, tb2, "binaria");
        
        double tb3 = measureTime(() -> array.binarySearchRecursive(middle));
        printSearchResultArray("Busca elemento do meio", middle, array.binarySearchRecursive(middle) != -1, tb3, "binaria");
        
        double tb4 = measureTime(() -> array.binarySearchRecursive(random1));
        printSearchResultArray("Busca aleatoria 1", random1, array.binarySearchRecursive(random1) != -1, tb4, "binaria");
        
        double tb5 = measureTime(() -> array.binarySearchRecursive(random2));
        printSearchResultArray("Busca aleatoria 2", random2, array.binarySearchRecursive(random2) != -1, tb5, "binaria");
        
        double tb6 = measureTime(() -> array.binarySearchRecursive(random3));
        printSearchResultArray("Busca aleatoria 3 ", random3, array.binarySearchRecursive(random3) != -1, tb6, "binaria");
        
        double tb7 = measureTime(() -> array.binarySearchRecursive(notFound));
        printSearchResultArray("Busca inexistente", notFound, array.binarySearchRecursive(notFound) != -1, tb7, "binaria");
    }
   
       
    public static void main(String[] args) {

        printTableHeader("Resultados de desempenho");

        System.out.println("\nGeracao e ordenacao de arrays");

        int[] numbers100 = generateArray(100);
        int[] numbers1000 = generateArray(1000);
        int[] numbers10000 = generateArray(10000);

        int[] numbers100CresBubble = Sorts.copiarArray(numbers100);
        int[] numbers100DescBubble = Sorts.copiarArray(numbers100);
        int[] numbers100CresQuick = Sorts.copiarArray(numbers100);
        int[] numbers100DescQuick = Sorts.copiarArray(numbers100);

        int[] numbers1000CresBubble = Sorts.copiarArray(numbers1000);
        int[] numbers1000DescBubble = Sorts.copiarArray(numbers1000);
        int[] numbers1000CresQuick = Sorts.copiarArray(numbers1000);
        int[] numbers1000DescQuick = Sorts.copiarArray(numbers1000);

        int[] numbers10000CresBubble = Sorts.copiarArray(numbers10000);
        int[] numbers10000DescBubble = Sorts.copiarArray(numbers10000);
        int[] numbers10000CresQuick = Sorts.copiarArray(numbers10000);
        int[] numbers10000DescQuick = Sorts.copiarArray(numbers10000);

        // BubbleSort
        printSortHeader("ORDENACAO - BUBBLESORT");
        printSortResult("BubbleSort", 100, "Crescente", measureTime(() -> Sorts.bubbleSort(numbers100CresBubble, true)));
        printSortResult("BubbleSort", 100, "Decrescente", measureTime(() -> Sorts.bubbleSort(numbers100DescBubble, false)));
        printSortResult("BubbleSort", 1000, "Crescente", measureTime(() -> Sorts.bubbleSort(numbers1000CresBubble, true)));
        printSortResult("BubbleSort", 1000, "Decrescente", measureTime(() -> Sorts.bubbleSort(numbers1000DescBubble, false)));
        printSortResult("BubbleSort", 10000, "Crescente", measureTime(() -> Sorts.bubbleSort(numbers10000CresBubble, true)));
        printSortResult("BubbleSort", 10000, "Decrescente", measureTime(() -> Sorts.bubbleSort(numbers10000DescBubble, false)));

        // QuickSort
        printSortHeader("ORDENACAO - QUICKSORT");
        printSortResult("QuickSort", 100, "Crescente", measureTime(() -> Sorts.quickSort(numbers100CresQuick, true)));
        printSortResult("QuickSort", 100, "Decrescente", measureTime(() -> Sorts.quickSort(numbers100DescQuick, false)));
        printSortResult("QuickSort", 1000, "Crescente", measureTime(() -> Sorts.quickSort(numbers1000CresQuick, true)));
        printSortResult("QuickSort", 1000, "Decrescente", measureTime(() -> Sorts.quickSort(numbers1000DescQuick, false)));
        printSortResult("QuickSort", 10000, "Crescente", measureTime(() -> Sorts.quickSort(numbers10000CresQuick, true)));
        printSortResult("QuickSort", 10000, "Decrescente", measureTime(() -> Sorts.quickSort(numbers10000DescQuick, false)));

        // AVL
        printTableHeader("Testes de insercao e busca em arvore AVL");

        // Aleatorios
        System.out.println("\n=== Insercao com valores aleatorios ===");
        Tree tree100 = new Tree();
        double t1 = measureTime(() -> { for (int n : numbers100) tree100.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 100", "ordem: Aleatoria", t1);
        testSearchTimes(tree100, numbers100, "AVL 100 aleatorios");
        System.out.println("--------------------------------------------------------------------\n\n");

        Tree tree1000 = new Tree();
        double t2 = measureTime(() -> { for (int n : numbers1000) tree1000.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 1000", "ordem: Aleatoria", t2);
        testSearchTimes(tree1000, numbers1000, "AVL 1000 aleatorios");
        System.out.println("--------------------------------------------------------------------\n\n");

        Tree tree10000 = new Tree();
        double t3 = measureTime(() -> { for (int n : numbers10000) tree10000.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 10000", "ordem: Aleatoria", t3);
        testSearchTimes(tree10000, numbers10000, "AVL 10000 aleatorios");
        System.out.println("--------------------------------------------------------------------\n\n");

        // Crescente
        System.out.println("\n=== Insercao com valores em ordem crescente ===");
        Tree treeCres100 = new Tree();
        double t4 = measureTime(() -> { for (int n : numbers100CresQuick) treeCres100.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 100", "ordem: Crescente", t4);
        testSearchTimes(treeCres100, numbers100CresQuick, "AVL 100 crescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        Tree treeCres1000 = new Tree();
        double t5 = measureTime(() -> { for (int n : numbers1000CresQuick) treeCres1000.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 1000", "ordem: Crescente", t5);
        testSearchTimes(treeCres1000, numbers1000CresQuick, "AVL 1000 crescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        Tree treeCres10000 = new Tree();
        double t6 = measureTime(() -> { for (int n : numbers10000CresQuick) treeCres10000.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 10000", "ordem: Crescente", t6);
        testSearchTimes(treeCres10000, numbers10000CresQuick, "AVL 10000 crescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        // Decrescente
        System.out.println("\n=== Insercao com valores em ordem decrescente ===");
        Tree treeDesc100 = new Tree();
        double t7 = measureTime(() -> { for (int n : numbers100DescQuick) treeDesc100.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 100", "ordem: Decrescente", t7);
        testSearchTimes(treeDesc100, numbers100DescQuick, "AVL 100 decrescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        Tree treeDesc1000 = new Tree();
        double t8 = measureTime(() -> { for (int n : numbers1000DescQuick) treeDesc1000.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 1000", "ordem: Decrescente", t8);
        testSearchTimes(treeDesc1000, numbers1000DescQuick, "AVL 1000 decrescente");
        System.out.println("-------------------------------------------------------------------\n\n-");

        Tree treeDesc10000 = new Tree();
        double t9 = measureTime(() -> { for (int n : numbers10000DescQuick) treeDesc10000.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: AVL", "valores: 10000", "ordem: Decrescente", t9);
        testSearchTimes(treeDesc10000, numbers10000DescQuick, "AVL 10000 decrescente");
        System.out.println("--------------------------------------------------------------------\n\n");
        
        
        
        
        // Árvore binária
        printTableHeader("Testes de insercao e busca em arvore binaria");

        // Aleatorios
        System.out.println("\n=== Insercao com valores aleatorios ===");
        TreeBinary tree100b = new TreeBinary();
        double t1b = measureTime(() -> { for (int n : numbers100) tree100b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 100", "ordem: Aleatoria", t1b);
        testSearchTimesBinary(tree100b, numbers100, "arvore binaria 100 aleatorios");
        System.out.println("--------------------------------------------------------------------\n\n");

        TreeBinary tree1000b = new TreeBinary();
        double t2b = measureTime(() -> { for (int n : numbers1000) tree1000b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 1000", "ordem: Aleatoria", t2b);
        testSearchTimesBinary(tree1000b, numbers1000, "arvore binaria 1000 aleatorios");
        System.out.println("--------------------------------------------------------------------\n\n");

        TreeBinary tree10000b = new TreeBinary();
        double t3b = measureTime(() -> { for (int n : numbers10000) tree10000b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 10000", "ordem: Aleatoria", t3b);
        testSearchTimesBinary(tree10000b, numbers10000, "arvore binaria 10000 aleatorios");
        System.out.println("--------------------------------------------------------------------\n\n");

        // Crescente
        System.out.println("\n=== Insercao com valores em ordem crescente ===");
        TreeBinary treeCres100b = new TreeBinary();
        double t4b = measureTime(() -> { for (int n : numbers100CresQuick) treeCres100b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 100", "ordem: Crescente", t4b);
        testSearchTimesBinary(treeCres100b, numbers100CresQuick, "arvore binaria 100 crescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        TreeBinary treeCres1000b = new TreeBinary();
        double t5b = measureTime(() -> { for (int n : numbers1000CresQuick) treeCres1000b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 1000", "ordem: Crescente", t5b);
        testSearchTimesBinary(treeCres1000b, numbers1000CresQuick, "arvore binaria 1000 crescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        TreeBinary treeCres10000b = new TreeBinary();
        double t6b = measureTime(() -> { for (int n : numbers10000CresQuick) treeCres10000b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 10000", "ordem: Crescente", t6b);
        testSearchTimesBinary(treeCres10000b, numbers10000CresQuick, "arvore binaria 10000 crescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        // Decrescente
        System.out.println("\n=== Insercao com valores em ordem decrescente ===");
        TreeBinary treeDesc100b = new TreeBinary();
        double t7b = measureTime(() -> { for (int n : numbers100DescQuick) treeDesc100b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 100", "ordem: Decrescente", t7b);
        testSearchTimesBinary(treeDesc100b, numbers100DescQuick, "arvore binaria 100 decrescente");
        System.out.println("--------------------------------------------------------------------\n\n");

        TreeBinary treeDesc1000b = new TreeBinary();
        double t8b = measureTime(() -> { for (int n : numbers1000DescQuick) treeDesc1000b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 1000", "ordem: Decrescente", t8b);
        testSearchTimesBinary(treeDesc1000b, numbers1000DescQuick, "arvore binaria 1000 decrescente");
        System.out.println("-------------------------------------------------------------------\n\n-");

        TreeBinary treeDesc10000b = new TreeBinary();
        double t9b = measureTime(() -> { for (int n : numbers10000DescQuick) treeDesc10000b.insert(n); });
        System.out.printf("| %-17s | %-13s | %-17s | tempo de insercao: %-8.3f ms |\n", "Estrutura: arvore binaria", "valores: 10000", "ordem: Decrescente", t9b);
        testSearchTimesBinary(treeDesc10000b, numbers10000DescQuick, "arvore binaria 10000 decrescente");
        System.out.println("--------------------------------------------------------------------\n\n");     
        
        //Array crescente
        
        Array<Integer> arr100cres = new Array<>();
        double t1arrayCres = measureTime(() -> { for(int n : numbers100CresQuick) arr100cres.add(n); });
        testArrayClassSearch(arr100cres, "100 elementos | crescente | " + "tempo de insercao: " + t1arrayCres);
        
        Array<Integer> arr1000cres = new Array<>();
        double t2arrayCres = measureTime(() -> { for(int n : numbers1000CresQuick) arr1000cres.add(n); });
        testArrayClassSearch(arr1000cres, "1.000 elementos | crescente | " + "tempo de insercao: " + t2arrayCres);
        
        Array<Integer> arr10000cres = new Array<>();
        double t3arrayCres = measureTime(() -> { for(int n : numbers10000CresQuick) arr10000cres.add(n); });
        testArrayClassSearch(arr10000cres, "10.000 elementos | crescente | " + "tempo de insercao: " + t3arrayCres);
        
        //Array decrescente
        
        Array<Integer> arr100desc = new Array<>();
        double t1arrayDesc = measureTime(() -> { for(int n : numbers100DescQuick) arr100desc.add(n); });
        testArrayClassSearch(arr100desc, "100 elementos | decrescente | " + "tempo de insercao: " + t1arrayDesc);
        
        Array<Integer> arr1000desc = new Array<>();
        double t2arrayDesc = measureTime(() -> { for(int n : numbers1000DescQuick) arr1000desc.add(n); });
        testArrayClassSearch(arr1000desc, "1.000 elementos | decrescente | " + "tempo de insercao: " + t2arrayDesc);
        
        Array<Integer> arr10000desc = new Array<>();
        double t3arrayDesc = measureTime(() -> { for(int n : numbers10000DescQuick) arr10000desc.add(n); });
        testArrayClassSearch(arr10000desc, "10.000 elementos | decrescente | " + "tempo de insercao: " + t3arrayDesc);
        
        Array<Integer> arr100rand = new Array<>();
        double t1arrayRand = measureTime(() -> { for(int n : numbers100) arr100rand.add(n); });
        testArrayClassSearch(arr100rand, "100 elementos | aleatorio | tempo de insercao: " + t1arrayRand);
         
        Array<Integer> arr1000rand = new Array<>();
        double t2arrayRand = measureTime(() -> { for(int n : numbers1000) arr1000rand.add(n); });
        testArrayClassSearch(arr1000rand, "1.000 elementos | aleatorio | tempo de insercao: " + t2arrayRand);
         
        Array<Integer> arr10000rand = new Array<>();
        double t3arrayRand = measureTime(() -> { for(int n : numbers10000) arr10000rand.add(n); });
        testArrayClassSearch(arr10000rand, "10.000 elementos | aleatorio | tempo de insercao: " + t3arrayRand);
        
        printTableHeader("Fim dos testes");
    }
}
