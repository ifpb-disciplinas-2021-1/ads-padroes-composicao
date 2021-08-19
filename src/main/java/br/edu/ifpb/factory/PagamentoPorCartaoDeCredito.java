package br.edu.ifpb.factory;

import br.edu.ifpb.domain.Pagamento;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 03/08/2021, 10:26:54
 */
public class PagamentoPorCartaoDeCredito implements Pagamento{

    @Override
    public String pagar(double valor) {
        return String.valueOf(
            System.nanoTime()
        );
    }

}
