package controller;

import model.BubbleSort;
import model.SortingAlgorithm;
import view.AlgorithmAnalysisPanel;
import view.VisualizedSortingArray;

import javax.swing.*;

import static model.Constants.*;
import model.*;

import java.awt.*;

public class SortingVisualizationController extends JFrame {
    
    // Menu stuff
    private JMenuBar algorithmsMenuBar;
    private JMenu algorithmsMenu;
    private JMenuItem[] algorithmMenuItems;
    
    // GUI stuff
    private JPanel display;
    
    private static final int DEFAULT_ARRAY_LENGTH = 100;
    private VisualizedSortingArray array;
    private AlgorithmAnalysisPanel analysisPanel;
    
    private int algorithm;
    private final SortingAlgorithm[] algorithms;
    
    boolean isRunning;
    
    public SortingVisualizationController () {
    
        algorithm = 0;
        algorithms = new SortingAlgorithm[] {
                
                new BubbleSort(), new SelectionSort(), new InsertionSort(),
                new CountingSort(), new BucketSort(), new RadixSort(),
                new ShellSort(), new QuickSort(), new MergeSort(),
                
        };
        
        setSize(FRAME_WIDTH+FRAME_WIDTH_CORRECT, FRAME_HEIGHT+FRAME_HEIGHT_CORRECT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        display = new JPanel();
        display.setLayout(null);
        display.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        display.setBackground(Color.darkGray);
        add(display);
    
        array = new VisualizedSortingArray(DEFAULT_ARRAY_LENGTH);
        array.setBounds(0, ANALYSIS_PANEL_HEIGHT+1, ARRAY_PANEL_WIDTH, ARRAY_PANEL_HEIGHT);
        display.add(array);
    
        analysisPanel = new AlgorithmAnalysisPanel(algorithms[algorithm], array);
        analysisPanel.setBounds(0, 0, ANALYSIS_PANEL_WIDTH, ANALYSIS_PANEL_HEIGHT);
        
        analysisPanel.getStartButton().addActionListener(event->new Thread(()->{
    
            int length = Integer.parseInt(analysisPanel.getLengthInput().getText().trim());
            if (isRunning&&length>ARRAY_PANEL_WIDTH) return;
            isRunning = true;
            
            // Create a new array if it is a new length
            if (length!=array.length()) {
                array.updateLength(length);
                array.generateBalancedArray();
                array.clearSelected();
            }
            
            array.resetCounts();
            analysisPanel.setAnalysis(algorithms[algorithm], array);
            array.shuffle();
            algorithms[algorithm].sort(array);
            array.clearSelected();
            analysisPanel.setAnalysis(algorithms[algorithm], array);
            
            isRunning = false;
            
        }).start());
        
        display.add(analysisPanel);

        algorithmsMenuBar = new JMenuBar();
        setJMenuBar(algorithmsMenuBar);
        algorithmsMenu = new JMenu("Algorithms");
        algorithmsMenuBar.add(algorithmsMenu);

        // Add the algorithms in the menu
        algorithmMenuItems = new JMenuItem[algorithms.length];
        for (int i = 0; i<algorithms.length; ++i) {

            final int j = i;
            algorithmMenuItems[j] = new JMenuItem(algorithms[j].getName());

            // Transition the algorithm to the selected one
            algorithmMenuItems[j].addActionListener(event->{
                algorithm = j;
                analysisPanel.setAnalysis(algorithms[algorithm], array);
            });

            algorithmsMenu.add(algorithmMenuItems[j]);

        }
    
        setVisible(true);
        array.generateBalancedArray();
        
    }
    
}
