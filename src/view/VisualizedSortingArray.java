package view;

import model.SortingArray;

import java.awt.*;

public class VisualizedSortingArray extends SortingArray {
    
    public VisualizedSortingArray (int length) {
        super(length);
    }
    
    public VisualizedSortingArray (SortingArray array) {
        super(array);
    }
    
    public void highlight (int index, Color color) {
    
    
    
    }
    
    public void highlight (int left, int right) {
        // TODO highlight a range of indices
    }
    
    @Override
    public int get (int index) {
//        highlight(index, );
        return super.get(index);
    }
    
    @Override
    public void set (int index, int value) {
//        highlight(index, );
        super.set(index, value);
    }
    
    @Override
    public void swap (int i, int j) {
//        highlight(i, ), highlight(j, );
        super.swap(i, j);
    }
    
    @Override
    public String toString () {
        return "VisualizedSortingArray{"+
                super.toString()+
                "}";
    }
    
}
