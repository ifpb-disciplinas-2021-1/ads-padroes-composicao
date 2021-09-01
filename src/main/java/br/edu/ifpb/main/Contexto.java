package br.edu.ifpb.main;

import br.edu.ifpb.decorator.PrecoComDesconto;
import br.edu.ifpb.decorator.PrecoDaCompra;
import br.edu.ifpb.decorator.PrecoComEntrega;
import br.edu.ifpb.domain.*;
import br.edu.ifpb.bridge.CompraAPrazo;
import br.edu.ifpb.composite.ItemDeVenda;
import br.edu.ifpb.composite.Kit;
import br.edu.ifpb.strategy.EntregaPorSedex;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/06/2021, 10:57:59
 */
public class Contexto {
    public static void main(String[] args) {
        Produto arroz = new Produto(
            "arroz", 4.5
        );
        Produto leite = new Produto(
            "leite", 5.0
        );
        Produto cafe = new Produto(
                "cafe", 2.0
        ); //conjunto

        Kit kit = new Kit("café com leite");//a
        kit.adicionar(new ItemDeVenda(2,leite)); //b);
        kit.adicionar(new ItemDeVenda(1,cafe)); //b);

//        Kit cesta = new Kit("cesta básica");
//        cesta.adicionar(new ItemDeVenda(4,arroz));
//        cesta.adicionar(kit);

        Entrega entrega = new EntregaPorSedex();
        Compra compra = new CompraAPrazo(entrega);
        compra.adicionar(
                new ItemDeVenda(4, arroz)
        );
//        compra.adicionar(cesta);
        compra.adicionar(kit);
        System.out.println("compra = " + compra.valorTotal());

        double total= new PrecoComEntrega(
                        new PrecoComDesconto(
                            new PrecoDaCompra(compra)
                            ,compra
                        )
                     ).aplicar(compra.valorTotal());
        System.out.println("total = " + total);






//        System.out.println(compra.emXml());
//        Desconto desconto = new Desconto();
//        desconto.aplicar(compra);
//        System.out.println("compra = " + compra.valorTotal());

//        double total =
//                new CalculadorPreco.PrecoFinal(
////                    new CalculadorPreco.PrecoComDesconto(
//                        new CalculadorPreco.PrecoNaCompra()
////                        , compra
////                    )
//                )
//        .calcular(compra.valorTotal());
//        System.out.println("compra = " + total);
    }
}
