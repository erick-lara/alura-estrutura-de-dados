package vetores;

import java.util.Arrays;

public class Vetor {
    private Aluno[] alunos = new Aluno[100];
    private int totalAlunos = 0;

    public void adiciona(Aluno aluno){
        this.garanteEspaco();
        this.alunos[totalAlunos] = aluno;
        totalAlunos++;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= totalAlunos;
    }

    private void garanteEspaco(){
        if(totalAlunos == alunos.length){
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            System.arraycopy(alunos, 0, novoArray, 0, alunos.length);
            this.alunos = novoArray;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < totalAlunos;
    }

    public void adiciona(int posicao, Aluno aluno){

        this.garanteEspaco();
        if(!this.posicaoValida(posicao))
            throw new IllegalArgumentException("Posição inválida");

        for (int i = totalAlunos - 1; i >= posicao ; i-=1) {
            alunos[i + 1] = alunos[i];
        }
        alunos[posicao] = aluno;
        totalAlunos++;
    }

    public Aluno pega(int posicao){
        if(!this.posicaoOcupada(posicao))
            throw new IllegalArgumentException("Posição inválida");

        return alunos[posicao];
    }

    public void remove(int posicao){
        for(int i = posicao - 1; i < totalAlunos; i++) {
            alunos[i] = alunos[i + 1];
        }
        totalAlunos--;
        this.alunos[totalAlunos] = null;
    }

    public boolean contain(Aluno aluno){
        for (int i = 0; i < totalAlunos; i++) {
            if(aluno.equals(alunos[i])){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return totalAlunos;
    }

    @Override
    public String toString() {
        return Arrays.toString(alunos);
    }
}
