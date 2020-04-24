
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;


public class AmigoSecreto extends JFrame {

    public AmigoSecreto() {
        View view = new View();
		//Eventos eventos = new Eventos();
    }

    public static void main(String args[]) {
        AmigoSecreto app = new AmigoSecreto();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}