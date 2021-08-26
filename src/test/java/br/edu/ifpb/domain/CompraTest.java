 
package br.edu.ifpb.domain;

import br.edu.ifpb.bridge.CompraAPrazo;
import br.edu.ifpb.bridge.CompraSemEntrega;
import br.edu.ifpb.observer.NotificacaoNoConsole;
import br.edu.ifpb.strategy.EntregaPorSedex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
public class CompraTest {
    
    @Test
    public void testAdicionar() {
        Produto arroz = new Produto(
            "arroz",4.50
        );
        Produto leite = new Produto(
            "leite",5.00
        );
        Produto cafe = new Produto(
            "cafe",3.50
        );

        Kit kit = new Kit("cafes");
        kit.adicionar(new ItemDeVenda(2,cafe)); //7
        kit.adicionar(new ItemDeVenda(1,leite)); //5
        Compra compra = new CompraSemEntrega();
        compra.adicionar(new ItemDeVenda(
            4,arroz
        ));
        compra.adicionar(kit);
        assertEquals(30.0,compra.valorTotal(), "");
    }
}
