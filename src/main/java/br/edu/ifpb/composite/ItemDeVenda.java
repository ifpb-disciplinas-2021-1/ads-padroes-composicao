package br.edu.ifpb.composite;

import br.edu.ifpb.domain.Item;
import br.edu.ifpb.domain.Produto;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/06/2021, 11:00:09
 */
public class ItemDeVenda implements Item {

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

    @Override
    public List<Produto> produtos() {
        return Arrays.asList(produto);
    }

    public double subTotal(){
        return this.produto.valor() * this.quantidade;
    }




}
