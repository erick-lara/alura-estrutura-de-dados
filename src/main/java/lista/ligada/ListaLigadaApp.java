package lista.ligada;

public class ListaLigadaApp {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adicionaNoComeco("Mauricio");
        lista.adicionaNoComeco("Paulo");
        lista.adicionaNoComeco("Guilherme");

        System.out.println(lista);
        lista.adiciona("Marcelo");
        System.out.println(lista);

        lista.adiciona(2, "Gabriel");
        System.out.println(lista);

        Object x = lista.pega(2);
        System.out.println(x);

        System.out.println(lista.tamanho());

        lista.removeDoComeco();

        System.out.println(lista);

        System.out.println(lista.tamanho());

        lista.removeDoFim();

        System.out.println(lista);

        lista.adiciona("Jose");
        lista.adiciona("João");

        System.out.println(lista);

        lista.remove(1);

        System.out.println(lista);

        System.out.println(lista.contem("Mauricio"));
        System.out.println(lista.contem("Danilo"));
    }
}
