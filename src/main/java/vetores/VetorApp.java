package vetores;

public class VetorApp {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("José");
        Aluno a3 = new Aluno("!Danilo");
        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(a2);

        System.out.println(lista);

        System.out.println(lista.tamanho());
    }
}
