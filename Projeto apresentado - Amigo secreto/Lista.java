import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;


public class Lista extends JFrame {

    private JLabel lblLista;
    private List dados;
	private JButton btnRefresh;
	
    Lista(){
		
		Container tela = getContentPane();
		setLayout(null);

        lblLista = new JLabel("Lista");
        lblLista.setBounds(10, 11, 86, 20);
        add(lblLista);
		
		dados = new List(3, false);
		add(dados);
		dados.setVisible(true);
		dados.setBounds(10, 31, 350, 100);
		
		// Botão de cadastrar
        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(250, 400, 100, 23);
        add(btnRefresh);
		
		TrataEv trat = new TrataEv();
		btnRefresh.addActionListener(trat);
		
        setSize(800, 600);
		setVisible(true);
		
    }
	
	//
	class TrataEv implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object botao = e.getSource();
            if (botao == btnRefresh) {

				UsuarioDao bd = new UsuarioDao();
				Usuario[] usuario = bd.getLista();
				
				//System.out.println("OLAAAAA: " + bd.Conta());
				
				for(int i = 0; i <= bd.Conta() - 1 ; i++){
					
					dados.addItem(usuario[i].getNome());

				}
				
            }
        }
    }
}