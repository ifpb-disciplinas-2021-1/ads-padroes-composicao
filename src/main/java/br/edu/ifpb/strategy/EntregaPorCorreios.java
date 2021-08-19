package br.edu.ifpb.strategy;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.domain.Entrega;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/07/2021, 08:58:40
 */
public class EntregaPorCorreios implements Entrega{

    public double calcularTaxa(Compra compra) {
        if(compra.valorTotal() > 100.0){
            //desconto
//        }if(compra.nordeste()){
            //não tem desconto
        }
        return 0.2 * compra.valorTotal();
    }
}
