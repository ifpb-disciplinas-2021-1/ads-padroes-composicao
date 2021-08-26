package br.edu.ifpb.main;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.bridge.CompraAPrazo;
import br.edu.ifpb.domain.Entrega;
import br.edu.ifpb.domain.ItemDeVenda;
import br.edu.ifpb.domain.Kit;
import br.edu.ifpb.observer.NotificacaoNoConsole;
import br.edu.ifpb.domain.Produto;
import br.edu.ifpb.strategy.EntregaPorSedex;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/06/2021, 10:57:59
 */
public class Contexto {

    public static void main(String[] args) {
        Produto arroz = new Produto(
            "arroz",4.50
        );
        Produto leite = new Produto(
            "leite",5.00
        );
        Produto cafe = new Produto(
            "cafe",3.50
        );

        Kit kit = new Kit("cafes");
        kit.adicionar(new ItemDeVenda(2,cafe)); //7
        kit.adicionar(new ItemDeVenda(1,leite)); //5

        Entrega entrega = new EntregaPorSedex();
//        Compra compra = new CompraAPrazoEntregaCorreiros();
        Compra compra = new CompraAPrazo(entrega);
        compra.adicionar(new ItemDeVenda(
            4,arroz
        ));
        compra.adicionar(kit);
        compra.addNotificador(new NotificacaoNoConsole()); //adicionando um observador
//        String codigo = compra.concluir();  
//        System.out.println("codigo = " + codigo);
        System.out.println("compra = " + compra.valorTotal());
    }
}
