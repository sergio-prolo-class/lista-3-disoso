package ifsc.poo.catalogo;

public class Filme {
    // Criando os atributos
    private String titulo;
    private int anoLancamento;
    private String genero;

    // Criando um objeto Filme com titulo, ano de lancamento e genero
    public Filme(String titulo, int anoLancamento, String genero) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    // Aqui os métodos para acessar os atributos
    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    // Definindo como sera mostrado no menu
    @Override
    public String toString() {
        return "Filme: " + titulo + " | Ano: " + anoLancamento + " | Gênero: " + genero;
    }
}
