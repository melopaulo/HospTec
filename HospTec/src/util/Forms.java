package util;


import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class Forms {
    
    //Centraliza os JInternalFrame
    public static void centraliza(JInternalFrame objeto) {
        Dimension d = objeto.getDesktopPane().getSize();
        objeto.setLocation((d.width - objeto.getSize().width) / 2, (d.height - objeto.getSize().height) / 2);
    }
    
}
