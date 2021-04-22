package model;

import view.VisualizedSortingArray;

public class ShellSort extends SortingAlgorithm {
    
    public ShellSort () {
        super("Shell Sort", "O(nlog^2n)", "O(1)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        for (int gap = array.length()/2; gap>0; gap /= 2) {
        
            for (int beginBound = gap; beginBound<array.length(); ++beginBound) {
            
                int insertingElement, i;
                insertingElement = array.get(beginBound);
            
                for (i = beginBound; i>=gap&&array.isGreater(array.get(i-gap), insertingElement); i -= gap)
                    array.set(i, array.get(i-gap));
            
                array.set(i, insertingElement);
            
            }
        
        }
        
    }
    
}
