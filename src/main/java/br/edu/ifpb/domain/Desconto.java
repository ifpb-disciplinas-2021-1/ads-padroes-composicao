package br.edu.ifpb.domain;

public abstract class Desconto {
    private Desconto proximo;
    public abstract void aplicar(Compra compra);
    public void proximo(Desconto proximo) {
        this.proximo = proximo;
    }
    //        public double aplicar(Compra compra){
//            if(compra.quantidade() > 10){
//                compra.adicionarDesconto(10); //absoluto
//            }
//            if(compra.naBlackFriday()){
//                double valorTotal = compra.valorTotal();
//                double desconto = 0.3 * valorTotal; //30%
//                compra.adicionarDesconto(desconto);
//            }
//        }

//         class DescontoComQuantidade extends Desconto{
//             @Override
//             public void aplicar(Compra compra) {
//                if(compra.quantidade() > 10){
//                    compra.adicionarDesconto(10); //absoluto
//                }
//                proximo.aplicar(compra);
//             }
//         }
//         class BlackFriday extends Desconto{
//             @Override
//             public void aplicar(Compra compra) {
//                 if(compra.naBlackFriday()){
//                    double valorTotal = compra.valorTotal();
//                    double desconto = 0.3 * valorTotal; //30%
//                    compra.adicionarDesconto(10); //absoluto
//                }
//                 proximo.aplicar(compra);
//             }
//         }
}
