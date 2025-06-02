package ifsc.poo.app;

import ifsc.poo.catalogo.CatalogoFilmes;
import ifsc.poo.catalogo.Filme;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== CATALOGO DE FILMES ===");
            System.out.println("1. Adicionar um filme");
            System.out.println("2. Remover um filme");
            System.out.println("3. Listar por titulo");
            System.out.println("4. Listar por genero");
            System.out.println("5. Listar por ano");
            System.out.println("6. Buscar por ano");
            System.out.println("0. Sair");
            System.out.print("Opcao desejada: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }
            
            switch (opcao) {
                case 1 -> adicionarFilme(catalogo, scanner);
                case 2 -> removerFilme(catalogo, scanner);
                case 3, 4, 5 -> listarFilmes(catalogo, opcao);
                case 6 -> buscarPorAno(catalogo, scanner);
                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    private static void adicionarFilme(CatalogoFilmes catalogo, Scanner scanner) {
        System.out.print("Titulo que gostaria de adicionar: ");
        String titulo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();
        
        catalogo.adicionarFilme(new Filme(titulo, ano, genero));
        System.out.println("Filme adicionado!");
    }

    private static void removerFilme(CatalogoFilmes catalogo, Scanner scanner) {
        System.out.print("Titulo que gostaria de remover: ");
        String titulo = scanner.nextLine();
        catalogo.removerFilme(titulo);
        System.out.println("Filme removido!");
    }

    private static void listarFilmes(CatalogoFilmes catalogo, int tipoOrdenacao) {
        List<Filme> lista;
        switch (tipoOrdenacao) {
            case 3 -> lista = catalogo.listarPorTitulo();
            case 4 -> lista = catalogo.listarPorGenero();
            case 5 -> lista = catalogo.listarPorAno();
            default -> lista = List.of();
        }
        
        if (lista.isEmpty()) {
            System.out.println("Poxa, nenhum filme encontrado!");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private static void buscarPorAno(CatalogoFilmes catalogo, Scanner scanner) {
        System.out.print("Buscar por ano de lancamento: ");
        int ano = scanner.nextInt();
        List<Filme> resultado = catalogo.buscarPorAno(ano);
        
        if (resultado.isEmpty()) {
            System.out.println("Nenhum filme encontrado para " + ano + "!");
        } else {
            resultado.forEach(System.out::println);
        }
    }
}
