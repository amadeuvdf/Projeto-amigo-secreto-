public class Usuario {
    private Long id;
    private String nome;
    private String idade;
    private String descricaoPresente;
	private boolean sorteado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDescricaoPresente() {
        return descricaoPresente;
    }

    public void setDescricaoPresente(String descricaoPresente) {
        this.descricaoPresente = descricaoPresente;
    }

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }
}



