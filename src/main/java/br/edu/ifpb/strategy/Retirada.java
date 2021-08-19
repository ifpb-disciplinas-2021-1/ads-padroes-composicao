package br.edu.ifpb.strategy;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.domain.Entrega;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/08/2021, 08:56:40
 */
public class Retirada implements Entrega{

    @Override
    public double calcularTaxa(Compra compra) {
        return 0.0;
    }

}
