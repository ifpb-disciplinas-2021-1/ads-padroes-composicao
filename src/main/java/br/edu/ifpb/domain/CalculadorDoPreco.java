package br.edu.ifpb.domain;

public interface CalculadorDoPreco {
    public double aplicar(double parcial);
}
//// subtotal - desconto + entrega
//    public double valorTotal() {
//        return itens.stream()
//            .mapToDouble(Item::subTotal)
//            .sum() - desconto + 20;
//    }
