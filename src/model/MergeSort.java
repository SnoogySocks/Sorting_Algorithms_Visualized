package model;

import view.VisualizedSortingArray;

public class MergeSort extends SortingAlgorithm {

    public MergeSort () {
        super("Merge Sort", "O(nlogn)", "O(n)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        int[] leftSegment, rightSegment;
        leftSegment = new int[array.length()-1];
        rightSegment = new int[array.length()/2];
    
        for (int segmentLength = 1; segmentLength<array.length(); segmentLength *= 2) {
        
            for (int left = 0; left+segmentLength<array.length(); left += 2*segmentLength) {
            
                int right, middle;
                right = Math.min(left+2*segmentLength-1, array.length()-1);
                middle = left+segmentLength-1;
            
                merge(array, left, middle, right);
            
            }
        
        }
        
    }
    
    protected void merge (VisualizedSortingArray array, int left, int middle, int right) {
        
        int leftLength = middle-left+1;
        int rightLength = right-middle;
        
        int[] leftSegment = new int[leftLength];
        int[] rightSegment = new int[rightLength];
    
        for (int i = left; i<=middle; ++i)
            leftSegment[i-left] = array.get(i);
        for (int i = middle+1; i<=right; ++i)
            rightSegment[i-middle-1] = array.get(i);
    
        int l, r, i;
        l = r = 0;
        for (i = left; l<leftLength&&r<rightLength; ++i) {
        
            if (array.isGreater(leftSegment[l], rightSegment[r]))
                array.set(i, rightSegment[r++]);
            else
                array.set(i, leftSegment[l++]);
        
        }
    
        while (l<leftLength)
            array.set(i++, leftSegment[l++]);
        while (r<rightLength)
            array.set(i++, rightSegment[r++]);
        
    }
    
}
