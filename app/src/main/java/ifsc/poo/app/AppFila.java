package ifsc.poo.app;

import ifsc.poo.fila.FilaAtendimento;
import ifsc.poo.fila.Cliente;
import ifsc.poo.fila.Solicitacao;
import java.util.Scanner;

public class AppFila {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== FILA DE ATENDIMENTO ===");
            System.out.println("1. Registrar nova solicitacao");
            System.out.println("2. Atender proxima solicitacao");
            System.out.println("3. Listar telefones registrados");
            System.out.println("4. Ver o proximo cliente");
            System.out.println("5. Listar idades atendidos");
            System.out.println("6. Listar telefones em espera");
            System.out.println("0. Voltar");
            System.out.print("Opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> registrarSolicitacao(fila, scanner);
                case 2 -> atenderProxima(fila);
                case 3 -> listarTelefonesRegistrados(fila);
                case 4 -> verProximoCliente(fila);
                case 5 -> listarIdadesAtendidos(fila);
                case 6 -> listarTelefonesEmEspera(fila);
            }
        } while (opcao != 0);
    }

    private static void registrarSolicitacao(FilaAtendimento fila, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Descricao do problema: ");
        String descricao = scanner.nextLine();
        
        Cliente cliente = new Cliente(nome, idade, telefone);
        fila.registrarSolicitacao(cliente, descricao);
        System.out.println("Solicitacao registrada!");
    }

    private static void atenderProxima(FilaAtendimento fila) {
        Solicitacao solicitacao = fila.atenderProxima();
        if (solicitacao == null) {
            System.out.println("Fila vazia!");
        } else {
            System.out.println("Atendido: " + solicitacao.getCliente().getNome() + 
                             " | Problema: " + solicitacao.getDescricao());
        }
    }

    private static void listarTelefonesRegistrados(FilaAtendimento fila) {
        System.out.println("Telefones registrados:");
        fila.listarTelefonesRegistrados().forEach(System.out::println);
    }

    private static void verProximoCliente(FilaAtendimento fila) {
        String nome = fila.proximoCliente();
        System.out.println(nome != null ? "Proximo: " + nome : "Fila vazia!");
    }

    private static void listarIdadesAtendidos(FilaAtendimento fila) {
        System.out.println("Idades atendidos:");
        fila.listarIdadesAtendidos().forEach(System.out::println);
    }

    private static void listarTelefonesEmEspera(FilaAtendimento fila) {
        System.out.println("Telefones em espera:");
        fila.listarTelefonesEmEspera().forEach(System.out::println);
    }
}
