
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.*;

public class Eventos implements ActionListener {
	
	JButton botao1 = new JButton();
	
    JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	
    String guardarTexto1;
	String guardarTexto2;
	String guardarTexto3;

	
	Eventos(JButton botao, JTextField nome, JTextField idade, JTextField descricao){
        this.botao1 = botao;
        t1 = nome;
		t2 = idade;
		t3 = descricao;
    }

	public void actionPerformed(ActionEvent evento) {
        guardarTexto1 = t1.getText();
		guardarTexto2 = t2.getText();
		guardarTexto3 = t3.getText();
		
		
		//debug não sei se é a assim que faz
        JOptionPane.showMessageDialog(null, guardarTexto1);
		JOptionPane.showMessageDialog(null, guardarTexto2);
		JOptionPane.showMessageDialog(null, guardarTexto3);
    }
	
}	

    
