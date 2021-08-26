package br.edu.ifpb.domain;

import br.edu.ifpb.composite.ItemDeVenda;
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
//    Compra compra; // Composição recursiva
    public void adicionar(int quantidade,Produto produto) {
            adicionar(new ItemDeVenda(
                quantidade,produto
            ));
    }
    public void adicionar(Item item) {
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


    /*
    <compra>
        <item quantidade= "">
            <produto descricao = "" > valor <produto>
        </item>
    </compra>
    */
    public String emXml(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<compra>");
        for(Item item:itens){
            itemNoXML(stringBuffer, item);
        }
        stringBuffer.append("</compra>");
        return stringBuffer.toString();
    }

    private void itemNoXML(StringBuffer stringBuffer, Item item) {
        stringBuffer.append("<item quantidade = \"");
        stringBuffer.append(item.quantidade());
        stringBuffer.append("\" >");
        for(Produto produto:item.produtos()){
            produtoNoXML(stringBuffer, produto);
        }
        stringBuffer.append("</item>");
    }
    private void produtoNoXML(StringBuffer stringBuffer, Produto produto) {
        stringBuffer.append("<produto descricao = \"");
        stringBuffer.append(produto.descricao());
        stringBuffer.append("\" >");
        stringBuffer.append(produto.valor());
        stringBuffer.append("</produto>");

        /*
        <name atributtes>
            value
        </name>
         */

    }



}
