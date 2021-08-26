package br.edu.ifpb.domain;

import br.edu.ifpb.strategy.Retirada;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/06/2021, 10:44:37
 */
// Source
public abstract class Compra {

    private final List<Item> itens = new ArrayList<>();
    private final Entrega entrega;
    private final List<Notificacao> notificacoes = new ArrayList<>();
//    private String status; // CRIADA, EM_PROCESSAMENTO, CONCLUIDA -> State

    public Compra() {
        this(new Retirada());
    }

    //ctor principal
    public Compra(Entrega entrega) {
        Objects.requireNonNull(entrega,"Não podemos criar uma compra sem uma entrega");
        this.entrega = entrega;
    }

    public void adicionar(Item item) {
//        ItemDeVenda item = new ItemDeVenda(
//            quantidade,produto
//        );
        if (!itens.contains(item)) {
            itens.add(item);
        }
    }
    public String concluir() {
        double taxa = this.entrega.calcularTaxa(this); //hook methods - > hook classes
        double valorTotal = this.valorTotal() + taxa;
        String codigoPagamento = pagamento().pagar(valorTotal); //hook methods 
        notificarClientes(); // informar que a compra foi concluída
        return codigoPagamento;
    }

    protected abstract Pagamento pagamento();

    //notify
    private void notificarClientes() {
        notificacoes.forEach((cliente) -> {
            //notificar cliente a cliente
            cliente.concluida(this);
        });
    }

    public void addNotificador(Notificacao notificacao) {
        this.notificacoes.add(notificacao);
    }

    public double valorTotal() {
        return itens.stream()
            .mapToDouble(Item::subTotal)
            .sum();
    }

    public double calculaTaxa() {
        return this.entrega.calcularTaxa(this);
    }

}
