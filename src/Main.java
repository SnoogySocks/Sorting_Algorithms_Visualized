import model.SortingAlgorithms;
import model.SortingArray;
import view.VisualizedSortingArray;

public class Main {
    
    public static void main (String[] args) {
    
        SortingArray shuffledArray = new VisualizedSortingArray(17);
        VisualizedSortingArray array = new VisualizedSortingArray(shuffledArray);
    
        System.out.println(array);
        SortingAlgorithms.radixSort(array);
        System.out.println(array);
        
//        long begin, end;
//
//        begin = System.nanoTime();
//        SortingAlgorithms.selectionSort(array);
//        end = System.nanoTime();
//        System.out.println(array+", time: "+(end-begin)/1000+"u");
//
//        array = new VisualizedSortingArray(shuffledArray);
//        begin = System.nanoTime();
//        SortingAlgorithms.insertionSort(array);
//        end = System.nanoTime();
//        System.out.println(array+", time: "+(end-begin)/1000+"u");
        
    }
    
}
