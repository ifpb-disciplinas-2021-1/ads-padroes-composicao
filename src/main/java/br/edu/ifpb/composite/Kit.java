package br.edu.ifpb.composite;

import br.edu.ifpb.domain.Item;
import br.edu.ifpb.domain.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kit implements Item {
    private final String descricao;
    private List<Item> itens = new ArrayList<>();
    public Kit(String descricao) {
        this.descricao = descricao;
    }
    public void adicionar(Item item) {
        if (!itens.contains(item)) {
            itens.add(item);
        }
    }
    public double subTotal() {
        return itens.stream()
                .mapToDouble(Item::subTotal) //composição recursiva
                .sum();
    }

    @Override
    public int quantidade() {
        return itens.size();
    }

    @Override
    public List<Produto> produtos() {
        return itens.stream()
                .flatMap(item -> item.produtos().stream())
                .collect(Collectors.toList());
    }

}
