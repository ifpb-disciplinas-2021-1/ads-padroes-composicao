package br.edu.ifpb.decorator;

import br.edu.ifpb.domain.CalculadorDoPreco;
import br.edu.ifpb.domain.Compra;

public class PrecoComDesconto implements CalculadorDoPreco {
    private Compra compra;
    private CalculadorDoPreco preco;
    public PrecoComDesconto(CalculadorDoPreco preco, Compra compra) {
        this.preco = preco;
        this.compra = compra;
    }

    public double aplicar(double parcial) {
        //TODO: chain of Responsability -> Desconto ( abstract class)
        double desconto = 0;
        if (compra.quantidade() > 1) {
            desconto += 10; //absoluto
        }
        if (compra.naBlackFriday()) {
            double valor = compra.valorTotal();
            double descontoParcial = 0.3 * valor;
            desconto += descontoParcial;
        }
        return preco.aplicar(parcial) - desconto;
    }
}
