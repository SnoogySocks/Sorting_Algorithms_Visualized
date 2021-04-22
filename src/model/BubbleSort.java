package model;

import view.VisualizedSortingArray;

public class BubbleSort extends SortingAlgorithm {
    
    public BubbleSort () {
        super("Bubble Sort", "O(n^2)", "O(1)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        for (int endBound = array.length()-1; endBound>0; --endBound)
            for (int it = 0; it<endBound; ++it)
                if (array.isGreater(array.get(it), array.get(it+1)))
                    array.swap(it, it+1);
        
    }
    
}
