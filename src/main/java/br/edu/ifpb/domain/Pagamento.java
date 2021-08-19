package br.edu.ifpb.domain;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/07/2021, 11:01:16
 */
public interface Pagamento {
    public String pagar(double valor);
//    class SemPagamento implements Pagamento{
//
//        @Override
//        public String pagar(double valor) {
//            return "";
//        }
//        
//    }
}
