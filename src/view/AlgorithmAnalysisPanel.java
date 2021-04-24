package view;

import model.SortingAlgorithm;

import javax.swing.*;
import java.awt.*;

import static model.Constants.*;

public class AlgorithmAnalysisPanel extends JPanel {
    
    private JLabel analysis;
    private JButton startButton;
    
    // Update length textArea
    private TextArea lengthInput;
    
    public AlgorithmAnalysisPanel (SortingAlgorithm algorithm, VisualizedSortingArray array) {
        
        setSize(ANALYSIS_PANEL_WIDTH, ANALYSIS_PANEL_HEIGHT);
        setBackground(Color.darkGray);
        setLayout(null);
        
        analysis = new JLabel();
        analysis.setBounds(10, 10, 300, ANALYSIS_PANEL_HEIGHT-55);
        analysis.setForeground(Color.white);
        setAnalysis(algorithm);
        add(analysis);
        
        startButton = new JButton("Press to Start");
        startButton.setBounds(ANALYSIS_PANEL_WIDTH-200, 10, 190, ANALYSIS_PANEL_HEIGHT-20);
        add(startButton);
        
        lengthInput = new TextArea(Integer.toString(array.length()));
        lengthInput.setBounds(ANALYSIS_PANEL_WIDTH/2-100, 10, 100, ANALYSIS_PANEL_HEIGHT-20);
        lengthInput.setFont(new Font("serif", Font.PLAIN, 20));
        add(lengthInput);
        
    }
    
    public void setAnalysis (SortingAlgorithm algorithm) {
        analysis.setText("<html>"+algorithm.toString()+"</html>");
    }
    
    public JButton getStartButton () {
        return startButton;
    }
    
    public TextArea getLengthInput () {
        return lengthInput;
    }
    
}
