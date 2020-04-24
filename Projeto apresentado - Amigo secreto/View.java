import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class View extends JFrame {

    private JFrame frame;
    private JFrame anexo;
	
    private JTextField txtNome;
    private JTextField txtNome_1;
    private JTextField txtNome_2;
	
    private List list;
	
    private JLabel lblSorteio;
	
	
    private JButton btnCadastro;
    private JButton btnSorteio;
    private JButton btnLista;
    private TrataEv trat;
    private JButton btnSortear;
	
    private String nome;
	
    View(){
		Container tela = getContentPane();
		setLayout(null);
		
		//painel principal é o painel dos botoes
        //botão do cadastro
        btnCadastro = new JButton("Cadastro");
        btnCadastro.setBounds(27, 5, 89, 23);
        add(btnCadastro);
        //botão da lista
        btnLista = new JButton("Lista");
        btnLista.setBounds(27, 33, 89, 23);
        add(btnLista);
        //botão do sorteo
        btnSorteio = new JButton("Sortear");
        btnSorteio.setBounds(27, 61, 89, 23);
        add(btnSorteio);
       
		trat = new TrataEv();
		btnSorteio.addActionListener(trat);
		btnCadastro.addActionListener(trat);
		btnLista.addActionListener(trat);
	   
		setSize(800, 600);
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	class TrataEv implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object botao = e.getSource();
            if (botao == btnSorteio){
                Sorteio sortear = new Sorteio();
			}
            if (botao == btnCadastro){
				Cadastro c = new Cadastro();
			}
			if (botao == btnLista){
				Lista L = new Lista();
			}
        }
    }
	
	
	public static void main(String args[]) {
        View app = new View();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	/*public void Menu(){
		//painel principal é o painel dos botoes
        panel = new JPanel();
        setBounds(10, 11, 143, 109);
        setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(panel);
        setLayout(null);
        //botão do cadastro
        btnCadastro = new JButton("Cadastro");
        btnCadastro.setBounds(27, 5, 89, 23);
        add(btnCadastro);
        //botão da lista
        btnLista = new JButton("Lista");
        btnLista.setBounds(27, 33, 89, 23);
        add(btnLista);
        //botão do sorteo
        btnSorteio = new JButton("Sortear");
        btnSorteio.setBounds(27, 61, 89, 23);
        add(btnSorteio);
       
	}
	
	public void Cadastro(){
		 // Painel das caixas de texto para o cadastro
        panel_1 = new JPanel();
        panel_1.setBounds(161, 11, 206, 109);
        panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        txtNome = new JTextField();
        txtNome.setBounds(10, 11, 86, 20);
        panel_1.add(txtNome);
        txtNome.setColumns(10);

        txtNome_1 = new JTextField();
        txtNome_1.setBounds(10, 42, 86, 20);
        panel_1.add(txtNome_1);
        txtNome_1.setColumns(10);

        txtNome_2 = new JTextField();
        txtNome_2.setBounds(10, 73, 86, 20);
        panel_1.add(txtNome_2);
        txtNome_2.setColumns(10);
        // Botão de cadastrar
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(106, 72, 89, 23);
		btnCadastrar.addActionListener(new Eventos(btnCadastrar, txtNome, txtNome_1, txtNome_2));
        panel_1.add(btnCadastrar);
	}
	
	public void Lista(){
		// Painel 2 painel da lista
        panel_2 = new JPanel();
        panel_2.setBounds(10, 131, 251, 74);
        panel_2.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        list = new List(3, false);
        list.add("Azul");
        list.add("Amarelo");
        list.add("Vermelho");
        list.add("Vermelho");
        list.add("Verelho");
        list.add("Vermeo");
        list.add("Vlho");
        list.setVisible(true);
        list.setBounds(10, 11, 231, 52);
        panel_2.add(list);
	}
	
	public void Sorteio(){
		// Painel do sorteio
        panel_3 = new JPanel();
        panel_3.setBounds(271, 131, 153, 94);
        panel_3.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(panel_3);
        panel_3.setLayout(null);

        lblSorteio = new JLabel("Sorteio");
        lblSorteio.setBounds(53, 5, 46, 14);
        panel_3.add(lblSorteio);
        //botão da sorte
        btnSortear = new JButton("Sortear");
        btnSortear.setBounds(31, 43, 89, 23);
        panel_3.add(btnSortear);

        frame.setVisible(true);
        setVisible(true); // Painel dos botões
        panel_1.setVisible(false); // cadastro, os textbox e as porra pra escrever dentro e um btn
        panel_2.setVisible(false); // aqui vai a lista
        panel_3.setVisible(false); // aqui vai o label com um btn e minha
	}
	
	public void Actions(){
		//Acão dos botoes, tem que colocar lá no actions essas fita aqui tbm, mas não sei como
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel_1.setVisible(true);
                panel_2.setVisible(false);
                panel_3.setVisible(false);
            }
        });

        btnLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel_1.setVisible(false);
                panel_2.setVisible(true);
                panel_3.setVisible(false);
            }
        });

        btnSorteio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel_1.setVisible(false);
                panel_2.setVisible(false);
                panel_3.setVisible(true);
            }
        });

        anexo = new JFrame();

        btnSortear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Object[] options = {"OK"};
                nome = "AMADEU";

                int n = JOptionPane.showOptionDialog(frame,
                        "nome: " + nome,
                        "Seu amigo é: ",
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title
            }
        });
	}*/

}