package model;

import java.util.Collections;
import java.util.LinkedList;

public class SortingAlgorithms {
    
    public static void bubbleSort (SortingArray array) {
        
        for (int endBound = array.length()-1; endBound>0; --endBound)
            for (int iterator = 0; iterator<endBound; ++iterator)
                if (array.isGreater(array.get(iterator), array.get(iterator+1)))
                    array.swap(iterator, iterator+1);
        
    }
    
    public static void selectionSort (SortingArray array) {
        
        for (int min = 0; min<array.length()-1; ++min)
            for (int iterator = min+1; iterator<array.length(); ++iterator)
                if (array.isGreater(array.get(min), array.get(iterator)))
                    array.swap(min, iterator);
        
    }
    
    public static void insertionSort (SortingArray array) {
        
        for (int endBound = 1; endBound<array.length(); ++endBound) {
            
            int insertingElement, iterator;
            insertingElement = array.get(endBound);
            
            for (iterator = endBound-1; iterator>=0
                    && array.isGreater(array.get(iterator), insertingElement); --iterator)
                array.set(iterator+1, array.get(iterator));
            
            array.set(iterator+1, insertingElement);
            
        }
        
    }
    
    public static void countingSort (SortingArray array) {
        
        int[] count = new int[array.getMax()+1];
        for (int iterator = 0; iterator<array.length(); ++iterator) {
            ++count[array.get(iterator)];
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
    
    public static void bucketSort (SortingArray array) {
    
        int numBuckets = (int) Math.sqrt(array.getMax())+1;
        LinkedList<Integer>[] buckets = new LinkedList[numBuckets];
        for (int iterator = 0; iterator<numBuckets; ++iterator)
            buckets[iterator] = new LinkedList<>();
        
        for (int iterator = 0; iterator<array.length(); ++iterator)
            buckets[array.get(iterator)/numBuckets].add(array.get(iterator));
        
        int arrayIterator = 0;
        for (int iterator = 0; iterator<numBuckets; ++iterator) {
    
            Collections.sort(buckets[iterator]);
            for (int element: buckets[iterator])
                array.set(arrayIterator++, element);
            
        }
        
    }
    
    public static void radixSort (SortingArray array) {
        
        LinkedList<Integer>[] digits = new LinkedList[10];
        for (int iterator = 0; iterator<digits.length; ++iterator)
            digits[iterator] = new LinkedList<>();
        
        for (int currentDigit = 1; currentDigit<=array.getMax(); currentDigit *= 10) {
            
            for (int iterator = 0; iterator<array.length(); ++iterator)
                digits[array.get(iterator)/currentDigit%10].add(array.get(iterator));
            
            int digitsIndex, arrIndex;
            for (digitsIndex = arrIndex = 0; arrIndex<array.length(); ++digitsIndex)
                while (digits[digitsIndex].size()!=0)
                    array.set(arrIndex++, digits[digitsIndex].pop());
            
        }
        
    }
    
    public static void shellSort (SortingArray array) {
        
        for (int gap = array.length()/2; gap>0; gap /= 2) {
            
            for (int beginBound = gap; beginBound<array.length(); ++beginBound) {
                
                int insertingElement, iterator;
                insertingElement = array.get(beginBound);
                
                for (iterator = beginBound; iterator>=gap&&array.isGreater(array.get(iterator-gap), insertingElement); iterator -= gap)
                    array.set(iterator, array.get(iterator-gap));
                
                array.set(iterator, insertingElement);
                
            }
            
        }
    
    }
    
    public static void quickSort (SortingArray array) {
        quickSort(array, 0, array.length()-1);
    }
    
    private static void quickSort (SortingArray array, int begin, int end) {
        
        if (begin>=end) return;
        
        int pivotIndex = begin;
        int pivotValue = array.get(end);
    
        for (int iterator = begin; iterator<end; ++iterator) {
            if (array.isGreater(pivotValue, array.get(iterator))) {
                array.swap(pivotIndex, iterator);
                ++pivotIndex;
            }
        }
        array.swap(pivotIndex, end);
        
        int middle = pivotIndex;
        quickSort(array, begin, middle-1);
        quickSort(array, middle+1, end);
        
    }
    
    public static void mergeSort (SortingArray array) {
        
        int[] leftSegment, rightSegment;
        leftSegment = new int[array.length()-1];
        rightSegment = new int[array.length()/2];
        
        for (int segmentLength = 1; segmentLength<array.length(); segmentLength *= 2) {
        
            for (int left = 0; left+segmentLength<array.length(); left += 2*segmentLength) {
    
                int right, middle, leftLength, rightLength;
                right = Math.min(left+2*segmentLength-1, array.length()-1);
                middle = left+segmentLength-1;
                
                leftLength = middle-left+1;
                rightLength = right-middle;
                
                for (int iterator = left; iterator<=middle; ++iterator)
                    leftSegment[iterator-left] = array.get(iterator);
                for (int iterator = middle+1; iterator<=right; ++iterator)
                    rightSegment[iterator-middle-1] = array.get(iterator);
                
                int l, r, iterator;
                l = r = 0;
                for (iterator = left; l<leftLength&&r<rightLength; ++iterator) {
                    
                    if (array.isGreater(leftSegment[l], rightSegment[r]))
                        array.set(iterator, rightSegment[r++]);
                    else
                        array.set(iterator, leftSegment[l++]);
                    
                }
                
                while (l<leftLength)
                    array.set(iterator++, leftSegment[l++]);
                while (r<rightLength)
                    array.set(iterator++, rightSegment[r++]);
                    
            }
        
        }
        
    }
    
}
