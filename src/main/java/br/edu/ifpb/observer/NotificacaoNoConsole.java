package br.edu.ifpb.observer;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.domain.Notificacao;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/08/2021, 09:23:53
 */
public class NotificacaoNoConsole implements Notificacao{

    @Override
    public void concluida(Compra compra) {
        System.out.println("Chegou uma nova notificação");
        System.out.println("A compra no valor: "+compra.valorTotal());
    }

}
