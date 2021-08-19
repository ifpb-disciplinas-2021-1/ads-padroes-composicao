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
public abstract class Compra {
    private final List<ItemDeVenda> itens = new ArrayList<>();
    private final Entrega entrega;
    private final List<Notificacao> notificacoes = new ArrayList<>();
//    private String status; // CRIADA, EM_ANDAMENTO, PROCESSADA, CONCLUIDA -> State
    
    public Compra() {
        this(new Retirada());
    }
    //ctor principal
    public Compra(Entrega entrega) {
        Objects.requireNonNull(entrega,"Não podemos criar uma compra sem uma entrega");
        this.entrega = entrega;
    }
    public void adicionar(int quantidade, Produto produto){
        ItemDeVenda item = new ItemDeVenda( 
            quantidade,produto
        );
        if(!itens.contains(item)) 
            itens.add(item);
    }
    public double valorTotal() {
        return itens.stream()
            .mapToDouble(ItemDeVenda::subTotal)
            .sum();
        
    }
    public double calculaTaxa(Entrega entrega){
//        if(status.equals("CRIADA"))
//            return entrega.calcularTaxa(this);
//        if(status.equals("CONCLUIDA"))
//            return 0.0;
        return entrega.calcularTaxa(this);
    }
    public String concluir(){
//        if(status.equals("CRIADA")){
//            double taxa = this.entrega.calcularTaxa(this); //hook methods - > hook classes
//            double valorTotal = this.valorTotal() + taxa;
//            String codigoPagamento = pagamento().pagar(valorTotal); //hook methods 
//        return codigoPagamento;
//        }
//        if(status.equals("CONCLUIDA")){
//            return status;
//        }
//        if(entrega ==null) { // Null Object
//            String codigoPagamento = pagamento().pagar(this.valorTotal()); //hook methods 
//            return codigoPagamento;
//        }
        double taxa = this.entrega.calcularTaxa(this); //hook methods - > hook classes
        double valorTotal = this.valorTotal() + taxa;
        String codigoPagamento = pagamento().pagar(valorTotal); //hook methods 
        notificarClientes(); // informar que a compra foi concluída
        return codigoPagamento;
    }
    //comportamento associado entre a confirmação e o pagamento
    protected abstract Pagamento pagamento(); // Factory Method
    //pós-processamento (comportamento não associado - pode variar independente)
//    protected abstract double calcularTaxaDaEntrega(Compra compra);
    
    public void addNotificador(Notificacao notificacao){
        this.notificacoes.add(notificacao);
    }
    private void notificarClientes() {
        notificacoes.forEach((cliente) -> {
            //notificar cliente a cliente
            cliente.concluida(this);
        });
    }
}
