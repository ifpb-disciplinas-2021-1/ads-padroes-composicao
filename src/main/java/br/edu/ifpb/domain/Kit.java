package br.edu.ifpb.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/08/2021, 22:05:28
 */
public class Kit implements Item{
    private final String descricao;
    private final List<Item> itens = new ArrayList<>();
    public Kit(String descricao) {
        this.descricao =descricao;
    }
    public void adicionar(ItemDeVenda item) {
        this.itens.add(item);
    }
    @Override
    public double subTotal() {
        return itens.stream()
            .mapToDouble(Item::subTotal)
            .sum();
    }

}
