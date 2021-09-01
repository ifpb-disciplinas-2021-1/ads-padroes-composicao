package br.edu.ifpb.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DecoratorComTexto {
    public static void main(String[] args) {
        String nome = " Ricardo Job ";
        String trim =
        new RemoveEspacoVazio(
//           new Maiusculo(
             new TextoEmString(nome)
//             new TextoEmArquivo(Paths.get("src/main/java/br/edu/ifpb/main/arquivo.txt"))
//           )
        ).ler();
        System.out.println(nome);
        System.out.println(trim);

    }

}
interface Texto{
    public String ler();
}
class Maiusculo implements Texto{
    private Texto texto;
    public Maiusculo(Texto texto) {
        this.texto = texto;
    }
    public String ler(){
        return texto.ler().toUpperCase();
    }
}
class RemoveEspacoVazio implements Texto{
    private Texto texto;
    public RemoveEspacoVazio(Texto texto) {
        this.texto = texto;
    }
    public String ler(){
        return texto.ler().trim();
    }
}
class TextoEmString implements Texto{
    private String string;
    public TextoEmString(String string) {
        this.string = string;
    }
    public String ler() {
        return string;
    }
}
class TextoEmArquivo implements Texto{
    private Path path;
    public TextoEmArquivo(Path path) {
        this.path = path;
    }
    @Override
    public String ler() {
        try {
            return new String(
                    Files.readAllBytes(this.path)
            );
        } catch (IOException e) {
            return "erro: "+e.getMessage();
        }
    }
}
