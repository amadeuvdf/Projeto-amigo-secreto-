import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Cadastro extends JFrame {

    private JLabel lblCadastro;
    private JButton btnCadastrar;
	private JTextField txtNome;
	private JTextField txtNome_1;
	private JTextField txtNome_2;
	
    Cadastro(){
		Container tela = getContentPane();
		setLayout(null);

        lblCadastro = new JLabel("Cadastro");
        lblCadastro.setBounds(10, 11, 86, 20);
        add(lblCadastro);
		
        txtNome = new JTextField();
        txtNome.setBounds(10, 42, 200, 22);
        add(txtNome);
        txtNome.setColumns(10);

        txtNome_1 = new JTextField();
        txtNome_1.setBounds(10, 73, 200, 22);
        add(txtNome_1);
        txtNome_1.setColumns(10);

        txtNome_2 = new JTextField();
        txtNome_2.setBounds(10, 104, 200, 22);
        add(txtNome_2);
        txtNome_2.setColumns(10);
        // Botão de cadastrar
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(250, 72, 100, 23);
        add(btnCadastrar);
		
		TrataEv trat = new TrataEv();
		btnCadastrar.addActionListener(trat);
		
        setSize(800, 600);
		setVisible(true);

    }
	
	class TrataEv implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object botao = e.getSource();
			
            if (botao == btnCadastrar) {
				
				UsuarioDao bd = new UsuarioDao();
				Usuario usuario = new Usuario();
				
				usuario.setNome(txtNome.getText());
				usuario.setIdade(txtNome_1.getText());
				usuario.setDescricaoPresente(txtNome_2.getText());

				bd.adiciona(usuario);
				
				
				
				JOptionPane.showMessageDialog(null, usuario.getNome());
            }
        }
    }
}