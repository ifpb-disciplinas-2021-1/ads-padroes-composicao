package br.edu.ifpb.decorator;

import br.edu.ifpb.domain.CalculadorDoPreco;
import br.edu.ifpb.domain.Compra;

public class PrecoDaCompra implements CalculadorDoPreco {
    private Compra compra;
    public PrecoDaCompra(Compra compra) {
        this.compra = compra;
    }
    public double aplicar(double parcial) {
        return compra.valorTotal();
    }
}
