package model;

import view.VisualizedSortingArray;

import java.util.LinkedList;

public class RadixSort extends SortingAlgorithm {
    
    public RadixSort() {
        super("Radix Sort", "O(nk)", "O(n)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        LinkedList<Integer>[] digits = new LinkedList[10];
        for (int i = 0; i<digits.length; ++i)
            digits[i] = new LinkedList<>();
    
        for (int currentDigit = 1; currentDigit<=array.getMax(); currentDigit *= 10) {
        
            for (int i = 0; i<array.length(); ++i)
                digits[array.get(i)/currentDigit%10].add(array.get(i));
        
            int digitsIndex, arrIndex;
            for (digitsIndex = arrIndex = 0; arrIndex<array.length(); ++digitsIndex)
                while (digits[digitsIndex].size()!=0)
                    array.set(arrIndex++, digits[digitsIndex].pop());
        
        }
        
    }
}
