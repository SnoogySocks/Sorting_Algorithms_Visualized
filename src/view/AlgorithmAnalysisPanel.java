package view;

import model.SortingAlgorithm;

import javax.swing.*;
import java.awt.*;

import static model.Constants.*;

public class AlgorithmAnalysisPanel extends JPanel {
    
    private JLabel analysis;
    private JButton startButton;
    
    public AlgorithmAnalysisPanel (SortingAlgorithm algorithm, VisualizedSortingArray array) {
    
        setSize(ANALYSIS_PANEL_WIDTH, ANALYSIS_PANEL_HEIGHT);
        setBackground(Color.darkGray);
        setLayout(null);
    
        analysis = new JLabel();
        analysis.setBounds(10, 10, 300, ANALYSIS_PANEL_HEIGHT-20);
        analysis.setForeground(Color.white);
        setAnalysis(algorithm, array);
        add(analysis);
    
        startButton = new JButton("Press to Start");
        startButton.setBounds(ANALYSIS_PANEL_WIDTH-200, 10, 190, ANALYSIS_PANEL_HEIGHT-20);
        add(startButton);
        
    }
    
    public void setAnalysis (SortingAlgorithm algorithm, VisualizedSortingArray array) {
        analysis.setText("<html>"+algorithm.toString()+"<br/>"+array.toString()+"</html>");
    }
    
    public JButton getStartButton() {
        return startButton;
    }
    
    
}
