package model;

import view.VisualizedSortingArray;

public class CountingSort extends SortingAlgorithm {
    
    public CountingSort () {
        super("Counting Sort", "O(n+k)", "O(n+k)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        int[] count = new int[array.getMax()+1];
        for (int i = 0; i<array.length(); ++i) {
            ++count[array.get(i)];
        }
    
        int arrayIterator = 0;
        for (int number = 0; number<count.length; ++number) {
            while (count[number]>0) {
                array.set(arrayIterator, number);
                ++arrayIterator;
                --count[number];
            }
        }
        
    }
    
}
