# Correção

| Questão     | Legibilidade | P1 | P2 | Total |
|-------------|--------------|----|----|-------|
| Nota máxima | 15           | 35 | 50 | 100   |
| Nota        | 12           | 30 | 40 | 82    |

- dependências e usos de classes padrão do Java (como Comparator) geralmente não são adicionadas no diagrama de classes

## Diagramas

- atributos com nome e tipo invertidos
- associação Solicitacao Cliente com multiplicidade errada
- associação simples (sem seta, sem direção, sem símbolo) em casos onde deveria ter algo

## P1

- se não pode haver filmes duplicados, por que usar lista?
  - na tentativa de solucionar esse problema, SRP é ferida
  - CatalogoFilmes define o que é o conceito de igualdade entre dois filmes (nome em letras minusculas)
  - deveria ser responsabilidade da classe Filme

### Requisitos Funcionais
- [x] Adicionar filmes
- [x] Remover filmes
- [x] Listar filmes por ordem alfabética de título
- [x] Listar filmes por ordem alfabética de gênero
- [x] Listar filmes por ordem de lançamento
- [x] Buscar filmes de um ano

## P2

- o que garante que o telefone de um cliente é único?
  - FilaAtendimento.registrarSolicitacao() adiciona o cliente se ele não está na lista clientesRegistrados
  - mas o que define que ele está lá? seu nome? telefone? endereço de memória?
  - a solução apresentada permite telefones duplicados.

### Requisitos Funcionais
- [x] Registrar dados de um cliente quando é sua primeira solicitação
- [ ] Registrar novas solicitações vinculadas a um cliente
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar as idades dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera