package br.edu.ifpb.decorator;

import br.edu.ifpb.domain.CalculadorDoPreco;

public class PrecoComEntrega implements CalculadorDoPreco {
    private CalculadorDoPreco preco;
    public PrecoComEntrega(CalculadorDoPreco preco) {
        this.preco = preco;
    }
    public double aplicar(double parcial) {
        return this.preco.aplicar(parcial) + 10;
    }
}
