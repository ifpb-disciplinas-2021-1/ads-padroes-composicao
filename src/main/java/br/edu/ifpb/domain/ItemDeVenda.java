package br.edu.ifpb.domain;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/06/2021, 11:00:09
 */
public class ItemDeVenda {

    private final Produto produto;
    private final int quantidade;
    
    private double desconto;

    public ItemDeVenda(int quantidade, Produto produto) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Produto produto(){
        return this.produto;
    }
    public int quantidade(){
        return this.quantidade;
    }
    
    public double subTotal(){
        return this.produto.valor() * this.quantidade;
    }
    
}
