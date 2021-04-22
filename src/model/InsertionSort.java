package model;

import view.VisualizedSortingArray;

public class InsertionSort extends SortingAlgorithm {
    
    public InsertionSort () {
        super("Insertion Sort", "O(n^2)", "O(1)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        for (int endBound = 1; endBound<array.length(); ++endBound) {
        
            int insertingElement, i;
            insertingElement = array.get(endBound);
        
            for (i = endBound-1; i>=0
                    && array.isGreater(array.get(i), insertingElement); --i)
                array.set(i+1, array.get(i));
        
            array.set(i+1, insertingElement);
        
        }
        
    }
    
}

