package lista.ligada;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalElementos = 0;

    public void adicionaNoComeco(Object elemento){
        if(this.totalElementos == 0){
            Celula celulaNova = new Celula(elemento);
            this.primeira = celulaNova;
            this.ultima = celulaNova;
        } else {
            Celula nova = new Celula(elemento, this.primeira);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }

        this.totalElementos++;
    }

    public void adiciona(Object elemento){
        if(this.totalElementos == 0){
            this.adicionaNoComeco(elemento);
        } else{
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalElementos++;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalElementos;
    }

    private Celula pegaCelula(int posicao){
        if(!posicaoOcupada(posicao))
            throw new IllegalArgumentException("Posição inexistente");

        Celula celAtual = primeira;
        for (int i = 0; i < posicao; i++) {
            celAtual = celAtual.getProxima();
        }

        return celAtual;
    }

    public void adiciona(int posicao, Object elemento){
        if(posicao == 0){
            this.adicionaNoComeco(elemento);
        } else if(posicao == this.totalElementos){
            adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(elemento, anterior.getProxima());
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalElementos++;
        }
    }

    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }

    public void removeDoComeco(){
        if(this.totalElementos == 0) throw new IllegalArgumentException("Lista vazia.");

        this.primeira = this.primeira.getProxima();
        this.totalElementos--;

        if(this.totalElementos==0) this.ultima = null;
    }

    public void remove(int posicao){
        if(posicao == 0){
            this.removeDoComeco();
        }else if(posicao == this.totalElementos - 1){
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);

            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalElementos--;
        }
    }

    public void removeDoFim(){
        if(this.totalElementos == 1){
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalElementos--;
        }
    }

    public int tamanho(){
        return this.totalElementos;
    }

    @Override
    public String toString() {
        if(this.totalElementos == 0) return "[]";

        Celula atual = primeira;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < totalElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        builder.append("]");
        return builder.toString();
    }

    public boolean contem(Object elemento){
        Celula atual = this.primeira;
        while (atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }

            atual = atual.getProxima();
        }

        return false;
    }
}
