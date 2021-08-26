package br.edu.ifpb.domain;

import java.util.List;

public interface Item {
        public double subTotal();
        public int quantidade();
        public List<Produto> produtos();
}
