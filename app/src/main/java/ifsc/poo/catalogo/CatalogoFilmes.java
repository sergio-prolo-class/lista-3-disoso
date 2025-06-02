package ifsc.poo.catalogo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatalogoFilmes {
    private List<Filme> filmes = new ArrayList<>();

    // Adicionando um filme
    public void adicionarFilme(Filme novoFilme) {
        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(novoFilme.getTitulo())) {
                return;
            }
        }
        filmes.add(novoFilme);
    }

    // Removendo um filme
    public void removerFilme(String titulo) {
        filmes.removeIf(f -> f.getTitulo().equalsIgnoreCase(titulo));
    }

    // Ordenando os filmes por ordem alfabetica
    public List<Filme> listarPorTitulo() {
        filmes.sort(Comparator.comparing(Filme::getTitulo));
        return new ArrayList<>(filmes);
    }

    // Ordenando os filmes por genero
    public List<Filme> listarPorGenero() {
        filmes.sort(Comparator.comparing(Filme::getGenero).thenComparing(Filme::getTitulo));
        return new ArrayList<>(filmes);
    }

    // Ordenando os filmes por ano de lancamento
    public List<Filme> listarPorAno() {
        filmes.sort(Comparator.comparingInt(Filme::getAno));
        return new ArrayList<>(filmes);
    }

    // Pesquisando filmes de um ano x
    public List<Filme> buscarPorAno(int ano) {
        return filmes.stream()
                .filter(f -> f.getAno() == ano)
                .toList();
    }
}
