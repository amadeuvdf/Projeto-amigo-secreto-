
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Random;

public class UsuarioDao {


    private Connection connection;

    public UsuarioDao() {
        /*this.connection = new ConnectionFactory().getConnection();*/
		
    }

    //Inserção - INSERT
    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO CADASTRO	" +
                "(NOME,IDADE,DESCRICAOPRESENTE) " +
                "values(?,?,?)";
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amigo", "root", "");
			System.out.println("INSERT");		
			
            //prepared statement para inserção
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getIdade());
            stmt.setString(3, usuario.getDescricaoPresente());
   
            //executa
            stmt.execute();
            stmt.close();
			
        } catch (Exception e) {
            throw new RuntimeException(e);
			//System.out.println(e.getMessage());
        }
    }

    //Listagem - GET
    public Usuario[] getLista(){
		
//ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		Usuario usuario[] = new Usuario[30];
		//Usuario novoUsu[];
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amigo", "root", "");
			System.out.println("GET");
			
			

			//ID_RANDOM = random() - > x = int(random*(b-a+a));
			//PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM CADASTRO WHERE" + ID_RANDOM);
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM CADASTRO");
            ResultSet rs = stmt.executeQuery();
	
			
			
			int i = 0;
            while (rs.next()) {
                /*criando	o objeto	usuario*/
				
				usuario[i] = new Usuario();
				
                usuario[i].setId(rs.getLong("id"));
                usuario[i].setNome(rs.getString("nome"));
                usuario[i].setIdade(rs.getString("idade"));
                usuario[i].setDescricaoPresente(rs.getString("descricaoPresente"));

				i++;
	
            }
			
			/*novoUsu = new Usuario[i];
			for(int y = 0; y < i; y++){
				novoUsu[y] = usuario[y];
			}*/
			
			
            rs.close();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
			//System.out.println(e.getMessage());
        }
		
		 //return novoUsu;
		 return usuario;
    }
	
	public int Conta(){
		int conta = 0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amigo", "root", "");
			
			//PreparedStatement stmt = this.connection.prepareStatement("SELECT COUNT(*) AS CONTA FROM CADASTRO");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS CONTA FROM CADASTRO");
			
			if(rs.next()){
				conta = Integer.parseInt(rs.getString("CONTA"));
				System.out.println("OI"+ conta);
			}
			
			rs.close();		
			stmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
        }	

		return conta;
	}
	
	
	//Sortear - GET + Update
    public Usuario Sorteia(){
		Usuario usuario = new Usuario();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PreparedStatement stmt_ = null;
		
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amigo", "root", "");
			System.out.println("GET");
			
			
			//ID_RANDOM = random() - > x = int(random*(b-a+a));
			
			
 
			
            while (true) {
				
				
				Random random = new Random();
				
				int ID_RANDOM = random.nextInt(11);
				
				stmt = this.connection.prepareStatement("SELECT * FROM CADASTRO WHERE ID =" + ID_RANDOM);
				rs = stmt.executeQuery();
				
				stmt_ = this.connection.prepareStatement("UPDATE CADASTRO SET SORTEADO = 1 WHERE ID =" + ID_RANDOM);
				
				if(rs.next()){
					/*criando	o objeto	usuario*/				
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setIdade(rs.getString("idade"));
					usuario.setDescricaoPresente(rs.getString("descricaoPresente"));
					usuario.setSorteado(rs.getInt("sorteado") == 1);
		
					/*adicionando o	objeto à lista*/
					//usuarios.add(usuario);
					
					if(!usuario.isSorteado()){
						
						stmt_.execute();
						
						break;
						
					}
				}
				
	

            }
			
            
        } catch (Exception e) {
            throw new RuntimeException(e);
			//System.out.println(e.getMessage());
        }finally{
			try{
				rs.close();
			}catch(Exception e){
				
			}
			
			try{
				stmt.close();
			}catch(Exception e){
				
			}
			
			try{
				stmt_.close();
			}catch(Exception e){
				
			}

		}
		
		 return usuario;
    }
	
	
	
	
}