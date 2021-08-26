package br.edu.ifpb.domain;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/06/2021, 10:43:37
 */
public class Produto {

    private final String descricao;
    private double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor =valor;
    }
    public double valor(){
        return this.valor;
    }
    public String descricao(){
        return this.descricao;
    }

}
