package model;

import view.VisualizedSortingArray;

public class SelectionSort extends SortingAlgorithm {
    
    public SelectionSort () {
        super("Selection Sort", "O(n^2)", "O(1)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        for (int min = 0; min<array.length()-1; ++min)
            for (int i = min+1; i<array.length(); ++i)
                if (array.isGreater(array.get(min), array.get(i)))
                    array.swap(min, i);
        
    }
    
}
