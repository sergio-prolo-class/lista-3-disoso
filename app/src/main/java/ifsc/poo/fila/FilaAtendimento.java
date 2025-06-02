package ifsc.poo.fila;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class FilaAtendimento {
    private Queue<Solicitacao> fila = new LinkedList<>();
    private List<Cliente> clientesAtendidos = new ArrayList<>();
    private List<Cliente> clientesRegistrados = new ArrayList<>();
    
    // Registrando uma nova solicitacao
    public void registrarSolicitacao(Cliente cliente, String descricao) {
        if (!clientesRegistrados.contains(cliente)) {
            clientesRegistrados.add(cliente);
        }
        fila.add(new Solicitacao(cliente, descricao));
    }
    
    // Atendendeno a proxima solicitacao
    public Solicitacao atenderProxima() {
        Solicitacao solicitacao = fila.poll();
        if (solicitacao != null) {
            clientesAtendidos.add(solicitacao.getCliente());
        }
        return solicitacao;
    }
    
    // Metodos para as listagens solicitadas
    public List<String> listarTelefonesRegistrados() {
        return clientesRegistrados.stream().map(Cliente::getTelefone).toList();
    }
    
    public List<String> listarTelefonesEmEspera() {
        return fila.stream().map(s -> s.getCliente().getTelefone()).toList();
    }
    
    public List<Integer> listarIdadesAtendidos() {
        return clientesAtendidos.stream().map(Cliente::getIdade).toList();
    }

    // Atendendo o proximo cliente 
    public String proximoCliente() {
        return fila.isEmpty() ? null : fila.peek().getCliente().getNome();
    }
}
