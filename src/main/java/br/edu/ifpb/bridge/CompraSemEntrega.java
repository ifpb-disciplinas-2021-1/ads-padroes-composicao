package br.edu.ifpb.bridge;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.domain.Pagamento;

public class CompraSemEntrega extends Compra {
    @Override
    protected Pagamento pagamento() {
        return null;
    }
}
