package gui.tabbedPanels;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AuditPanel extends JPanel
{
    public AuditPanel()
    {
        super();
        initialize();
    }
    
    private JTextArea auditTextArea;
    
    private void initialize()
    {
        setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.setBorder(new EmptyBorder(0, 3, 0, 3));
        scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        scrollPane_1.setBounds(0, 0, 497, 168);
        add(scrollPane_1);
        
        auditTextArea = new JTextArea();
        auditTextArea.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        auditTextArea.setEditable(false);
        auditTextArea.setBorder(null);
        scrollPane_1.setViewportView(auditTextArea);
        auditTextArea.setWrapStyleWord(true);
        auditTextArea.setLineWrap(true);
        auditTextArea.setText("This is a very long text that might occur when we have very long audit log and or long directory nagmes\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n0\r\n-");
       
    }
    
    public void print(String str)
    {
        String text = auditTextArea.getText();
        text += "\n" + str;
        auditTextArea.setText(text);
    }
}
