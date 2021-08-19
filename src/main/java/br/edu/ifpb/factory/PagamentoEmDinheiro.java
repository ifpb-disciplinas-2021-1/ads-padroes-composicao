package br.edu.ifpb.factory;

import br.edu.ifpb.domain.Pagamento;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/08/2021, 08:35:10
 */
public class PagamentoEmDinheiro implements Pagamento{

    @Override
    public String pagar(double valor) {
        return String.valueOf(
            this.toString().hashCode()
        );
    }

}
