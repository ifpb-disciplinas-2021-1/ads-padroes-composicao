package br.edu.ifpb.strategy;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.domain.Entrega;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/07/2021, 08:58:40
 */
public class EntregaPorPAC implements Entrega{

    public double calcularTaxa(Compra compra) {
        return 0.1 * compra.valorTotal();
    }
}
