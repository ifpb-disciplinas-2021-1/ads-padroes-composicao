package br.edu.ifpb.domain;

import br.edu.ifpb.bridge.CompraAPrazo;
import br.edu.ifpb.composite.ItemDeVenda;
import br.edu.ifpb.composite.Kit;
import br.edu.ifpb.strategy.EntregaPorSedex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TagXMLTest {
    @Test
    void testTagComProdutoVazio(){
        TagXML tag = new TagXML("produto");
        String result = tag.toString();
        String expected = "<produto></produto>";
        assertEquals(expected, result, "Os valores devem ser iguais");
    }
    @Test
    void testTagComProdutoVazioComAtributo(){
        TagXML tag = new TagXML("produto");
        tag.addAttribute("descricao", "arroz");
        String result = tag.toString();
        String expected = "<produto descricao = \"arroz\" ></produto>";
        assertEquals(expected, result, "Os valores devem ser iguais");
    }
    @Test
    void testTagComProdutoComValor(){
        TagXML tag = new TagXML("produto");
        tag.value(String.valueOf(5.0));
        String result = tag.toString();
        String expected = "<produto>5.0</produto>";
        assertEquals(expected, result, "Os valores devem ser iguais");
    }

    @Test
    public void testComCompra(){
        Produto arroz = new Produto("arroz", 4.5);
        Produto leite = new Produto("leite", 5.0);
        Produto cafe = new Produto("cafe", 2.0); //conjunto
        Kit kit = new Kit("café com leite");//a
        kit.adicionar(new ItemDeVenda(2,leite)); //b);
        kit.adicionar(new ItemDeVenda(1,cafe)); //b);
        Compra compra = new CompraAPrazo(new EntregaPorSedex());
        compra.adicionar( new ItemDeVenda(4, arroz));
        compra.adicionar(kit);
        String expected = "<compra><item quantidade = \"4\" ><produto descricao = \"arroz\" >4.5</produto></item><item quantidade = \"2\" ><produto descricao = \"leite\" >5.0</produto><produto descricao = \"cafe\" >2.0</produto></item></compra>";
        String result = compra.emXml();
        assertEquals(expected, result, "Os valores precisam ser iguais");
    }

}