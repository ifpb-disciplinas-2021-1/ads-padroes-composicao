package br.edu.ifpb.main;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.bridge.CompraAPrazo;
import br.edu.ifpb.domain.Entrega;
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
            "arroz", 2.65
        );
        Produto leite = new Produto(
            "leite", 6.89
        );
        Entrega entrega = new EntregaPorSedex();
//        Compra compra = new CompraAPrazoEntregaCorreiros();
        Compra compra = new CompraAPrazo(entrega);
        compra.adicionar(3, arroz);
        compra.adicionar(2, leite);
        compra.addNotificador(new NotificacaoNoConsole()); //adicionando um observador
        String codigo = compra.concluir();  
        System.out.println("codigo = " + codigo);
    }
}
