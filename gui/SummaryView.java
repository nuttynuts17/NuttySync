package gui;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import support.FileDrop;
public class SummaryView
{
    public interface SummaryViewDelegate {
        public void sourceTextChanged(JTextField label, String text);
        public void destinationTextChanged(JTextField label, String text);
    }
    
    private SummaryViewDelegate delegate;
    private JFrame synchiveFrame;
    private JTextField sourceTextField, destinationTextField;
    /**
     * Create the application.
     */
    public SummaryView(SummaryViewDelegate delegate)
    {
        this.delegate = delegate;
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        synchiveFrame = new JFrame();
        synchiveFrame.setTitle("Synchive");
        synchiveFrame.setBounds(100, 100, 526, 340);
        synchiveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setPreferredSize(new Dimension(57, 14));
        sourceLabel.setMinimumSize(new Dimension(57, 14));
        sourceLabel.setMaximumSize(new Dimension(57, 14));
        sourceLabel.setBounds(7, 7, 67, 22);
        sourceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        sourceLabel.setFont(new Font("Arial", Font.BOLD, 11));
        
        sourceTextField = new JTextField();
        sourceTextField.setBounds(93, 7, 352, 22);
        sourceTextField.setMinimumSize(new Dimension(50, 20));
        sourceTextField.setToolTipText("");
        sourceTextField.setColumns(10);
        sourceTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                delegate.sourceTextChanged(sourceTextField, sourceTextField.getText());
            }
            
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                delegate.sourceTextChanged(sourceTextField, sourceTextField.getText());
            }
            
            @Override
            public void changedUpdate(DocumentEvent e)
            {
            }
        });
        
        new FileDrop(sourceTextField, new FileDrop.Listener()
        {
            @Override
            public void filesDropped(File[] files)
            {
                sourceTextField.setText(files[0].getPath());
            } // end filesDropped
        }); // end FileDrop.Listener
        
        JButton sourceMoreButton = new JButton("...");
        sourceMoreButton.setBounds(463, 7, 40, 22);
        sourceMoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sourceMoreButton.setMinimumSize(new Dimension(23, 23));
        sourceMoreButton.setMaximumSize(new Dimension(45, 22));
        sourceMoreButton.setDefaultCapable(false);
        sourceMoreButton.setFocusPainted(false);
        
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(7, 33, 67, 22);
        destinationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        destinationLabel.setFont(new Font("Arial", Font.BOLD, 11));
        
        destinationTextField = new JTextField();
        destinationTextField.setBounds(93, 33, 352, 22);
        destinationTextField.setMinimumSize(new Dimension(50, 20));
        destinationTextField.setColumns(10);
        destinationTextField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                delegate.destinationTextChanged(destinationTextField, destinationTextField.getText());
            }
            
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                delegate.destinationTextChanged(destinationTextField, destinationTextField.getText());
            }
            
            @Override
            public void changedUpdate(DocumentEvent e)
            {
            }
        });
        
        new FileDrop(destinationTextField, new FileDrop.Listener()
        {
            @Override
            public void filesDropped(File[] files)
            {
                destinationTextField.setText(files[0].getPath());
            } // end filesDropped
        }); // end FileDrop.Listener
        
        JButton destinationMoreButton = new JButton("...");
        destinationMoreButton.setBounds(463, 33, 40, 22);
        destinationMoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        destinationMoreButton.setMinimumSize(new Dimension(23, 23));
        destinationMoreButton.setMaximumSize(new Dimension(45, 22));
        destinationMoreButton.setDefaultCapable(false);
        destinationMoreButton.setFocusTraversalKeysEnabled(false);
        destinationMoreButton.setFocusPainted(false);
        
        JLabel sizeReadLabel = new JLabel("Read: ");
        sizeReadLabel.setBounds(7, 258, 99, 14);
        synchiveFrame.getContentPane().add(sizeReadLabel);
        
        JLabel sizeReadSpeedLabel = new JLabel("Read Speed:");
        sizeReadSpeedLabel.setBounds(116, 258, 154, 14);
        synchiveFrame.getContentPane().add(sizeReadSpeedLabel);
        
        JLabel totalRunningTimeLabel = new JLabel("Running Time:");
        totalRunningTimeLabel.setBounds(280, 258, 223, 14);
        synchiveFrame.getContentPane().add(totalRunningTimeLabel);
        
        JProgressBar processingFileProgressBar = new JProgressBar();
        processingFileProgressBar.setBounds(7, 276, 496, 14);
        synchiveFrame.getContentPane().add(processingFileProgressBar);
        
        synchiveFrame.getContentPane().setLayout(null);
        synchiveFrame.getContentPane().add(sourceLabel);
        synchiveFrame.getContentPane().add(sourceTextField);
        synchiveFrame.getContentPane().add(sourceMoreButton);
        synchiveFrame.getContentPane().add(destinationLabel);
        synchiveFrame.getContentPane().add(destinationTextField);
        synchiveFrame.getContentPane().add(destinationMoreButton);
    }
    
    public JFrame getFrame()
    {
        return synchiveFrame;
    }
    
    public void setVisible(boolean flag) {
        synchiveFrame.setVisible(flag);
    }
    
    public void loadSettings(String sourceText, String destinationText)
    {
        sourceTextField.setText(sourceText);
        destinationTextField.setText(destinationText);
    }
}