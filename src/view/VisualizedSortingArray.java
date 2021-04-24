package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static model.Constants.*;

public class VisualizedSortingArray extends JPanel {
    
    private int[] array;
    private int max;
    private int comparisonsCount, setsCount;
    
    private int[] barColor;
    private int barWidth;
    private double barHeightUnits;
    
    private long frameRate;
    
    public VisualizedSortingArray () {
        
        setBackground(Color.darkGray);
        array = null;
        max = Integer.MIN_VALUE;
        resetCounts();
        
        barColor = null;
        frameRate = 1_000_000_000L;
        
    }
    
    public VisualizedSortingArray (int length) {
        this();
        updateLength(length);
    }
    
    public void updateLength (int length) {
        
        barColor = new int[length];
        array = new int[length];
        frameRate /= length;
        
        barWidth = ARRAY_PANEL_WIDTH/length;
        barHeightUnits = (double) ARRAY_PANEL_HEIGHT/length;
        
    }
    
    /**
     * Fill the array with values in the range [1, array.length]
     * such that there are no duplicate numbers in the range
     */
    public void generateBalancedArray () {
        for (int i = 0; i<array.length; ++i)
            set(i, (int) Math.round(barHeightUnits*(i+1)));
        resetCounts();
        clearSelected();
    }
    
    /**
     * Shuffle the elements in the array
     */
    public void shuffle () {
        
        Random random = new Random();
        for (int i = array.length-1; i>=1; --i)
            swap(i, random.nextInt(i+1));
        resetCounts();
        clearSelected();
        
    }
    
    void select (int index) {
        
        barColor[index] = SELECTED;
        sleep();
        repaint();
        
    }
    
    public int length () {
        return array.length;
    }
    
    public int get (int index) {
        select(index);
        return array[index];
    }
    
    public void set (int index, int value) {
        
        ++setsCount;
        max = Math.max(max, value);
        array[index] = value;
        select(index);
        
    }
    
    public void swap (int i, int j) {
        
        setsCount += 2;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
        select(i);
        select(j);
        
    }
    
    public boolean isGreater (int val1, int val2) {
        ++comparisonsCount;
        return val1>val2;
    }
    
    public int getMax () {
        return max;
    }
    
    public int getCountSets () {
        return setsCount;
    }
    
    public int getComparisonsCount () {
        return comparisonsCount;
    }
    
    public void resetCounts () {
        comparisonsCount = setsCount = 0;
    }
    
    @Override
    protected void paintComponent (Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        for (int i = 0; i<array.length; ++i) {
            
            // Fade the color away
            int val = Math.min(255-barColor[i]*2, 255);
            g2d.setColor(new Color(255, val, val));
            barColor[i] = Math.max(barColor[i]-COLOR_RATE_OF_CHANGE, UNSELECTED);
            
            // Calculate the bar coordinates and display them to the screen
            int barHeight, xBegin, yBegin;
            barHeight = array[i];
            xBegin = i*barWidth;
            yBegin = ARRAY_PANEL_HEIGHT-barHeight;
            g2d.fillRect(xBegin, yBegin, barWidth, barHeight);
            
        }
        
    }
    
    public void sleep () {
        long startTime = System.nanoTime();
        while (System.nanoTime()-startTime<frameRate) ;
    }
    
    public void clearSelected () {
        
        for (int i = 0; i<40; ++i) {
            sleep();
            repaint();
        }
        
    }
    
    @Override
    public String toString () {
        return "# of Comparisons: "+comparisonsCount+
                "<br/># of Array Accesses: "+setsCount;
    }
    
}
