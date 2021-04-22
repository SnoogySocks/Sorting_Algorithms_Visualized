package model;

import view.VisualizedSortingArray;

public class QuickSort extends SortingAlgorithm {
    
    public QuickSort () {
        super("Quick Sort", "O(nlogn)", "O(logn)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
        sort(array, 0, array.length()-1);
    }
    
    public void sort (VisualizedSortingArray array, int begin, int end) {
        
        if (begin>=end) return;
        
        int pivotIndex = begin;
        int pivotValue = array.get(end);
        
        for (int i = begin; i<end; ++i) {
            if (array.isGreater(array.get(i), pivotValue)) continue;
            array.swap(pivotIndex, i);
            ++pivotIndex;
        }
        array.swap(pivotIndex, end);
        
        int middle = pivotIndex;
        sort(array, begin, middle-1);
        sort(array, middle+1, end);
        
    }
    
}
