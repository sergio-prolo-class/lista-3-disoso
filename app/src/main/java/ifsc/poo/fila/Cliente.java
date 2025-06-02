package ifsc.poo.fila;

public class Cliente {
    private String nome;
    private int idade;
    private String telefone;
    
    public Cliente(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }
    
    // Getters
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getTelefone() { return telefone; }
}
