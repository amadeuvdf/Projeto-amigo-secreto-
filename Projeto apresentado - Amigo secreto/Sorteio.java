import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Sorteio extends JFrame {

    private JLabel lblSorteio;
	private JLabel lblSorteioNome;
    private JButton btnSortear;
	
	
    Sorteio(){
		Container tela = getContentPane();
		setLayout(null);
		// Painel do sorteio
        lblSorteio = new JLabel("Sorteio");
        lblSorteio.setBounds(100, 200, 46, 14); // x y w h
        add(lblSorteio);
		
		// escreve
        lblSorteioNome = new JLabel("Seu amigo sorteado é:");
        lblSorteioNome.setBounds(60, 15, 46, 14);
        add(lblSorteioNome);	
		
		
        //botão da sorte
        btnSortear = new JButton("Sortear");
        btnSortear.setBounds(31, 43, 89, 23);
        add(btnSortear);
		
		TrataEv trat = new TrataEv();
		btnSortear.addActionListener(trat);

		
        setSize(800, 600);
		setVisible(true);

    }
	
	class TrataEv implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object botao = e.getSource();
            if (botao == btnSortear) {

                UsuarioDao bd = new UsuarioDao();
				Usuario usuario = bd.Sorteia();
				
				lblSorteioNome.setText(usuario.getNome());

            }
        }
    }
}	