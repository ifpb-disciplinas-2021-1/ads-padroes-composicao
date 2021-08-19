package br.edu.ifpb.bridge;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.domain.Entrega;
import br.edu.ifpb.domain.Pagamento;
import br.edu.ifpb.factory.PagamentoEmDinheiro;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/08/2021, 08:34:24
 */
public class CompraAVista extends Compra{

    public CompraAVista() {
    }

    
    public CompraAVista(Entrega entrega) {
        super(entrega);
    }

    @Override
    protected Pagamento pagamento() {
        return new PagamentoEmDinheiro();
    }

//    @Override
//    protected double calcularTaxaDaEntrega(Compra compra) {
//        Entrega entrega = new EntregaPorCorreios();
//        return entrega.calcularTaxa(compra);
//    }

}
