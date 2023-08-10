package Dados;

public class ArvoreAVL {
	private No root = null;

    public void inserir(int chave, String valor) {
        root = inserir(root, chave, valor);
    }

    private No inserir(No arv, int chave, String valor) {
        if (arv == null) {
            return new No(chave, valor);
        }

        if (chave < arv.chave) {
            arv.esq = inserir(arv.esq, chave, valor);
        } else if (chave > arv.chave) {
            arv.dir = inserir(arv.dir, chave, valor);
        } else {
            // Chaves duplicadas não são inseridas
            return arv;
        }

        // Atualiza a altura do nó
        arv.alturaNo = 1 + Math.max(altura(arv.esq), altura(arv.dir));

        // Verifica e realiza as rotações se necessário
        return balancear(arv);
    }
    
    private No balancear(No n) {
        int fb = obterFB(n);

        if (fb > 1) {
            if (obterFB(n.esq) >= 0) {
                return rotacaoDireitaSimples(n);
            } else {
                n.esq = rotacaoEsquerdaSimples(n.esq);
                return rotacaoDireitaSimples(n);
            }
        } else if (fb < -1) {
            if (obterFB(n.dir) <= 0) {
                return rotacaoEsquerdaSimples(n);
            } else {
                n.dir = rotacaoDireitaSimples(n.dir);
                return rotacaoEsquerdaSimples(n);
            }
        }

        return n;
    }

    private No rotacaoDireitaSimples(No y) {
        No x = y.esq;
        No T2 = x.dir;

        x.dir = y;
        y.esq = T2;

        y.alturaNo = 1 + Math.max(altura(y.esq), altura(y.dir));
        x.alturaNo = 1 + Math.max(altura(x.esq), altura(x.dir));

        return x;
    }

    private No rotacaoEsquerdaSimples(No x) {
        No y = x.dir;
        No T2 = y.esq;

        y.esq = x;
        x.dir = T2;

        x.alturaNo = 1 + Math.max(altura(x.esq), altura(x.dir));
        y.alturaNo = 1 + Math.max(altura(y.esq), altura(y.dir));

        return y;
    }

    public void remover(int chave) {
        root = remover(root, chave);
    }

    private No remover(No arv, int chave) {
        // Implemente a lógica de remoção
        // ...

        // Atualiza a altura do nó
        arv.alturaNo = 1 + Math.max(altura(arv.esq), altura(arv.dir));

        // Balancear a árvore após a remoção, se necessário
        return balancear(arv);
    }

    // Restante dos m	étodos, incluindo os de remoção e rotações
    // ...

    // Funções auxiliares
    private int altura(No n) {
        if (n == null) {
            return -1;
        }
        return n.alturaNo;
    }

    private int obterFB(No n) {
        if (n == null) {
            return 0;
        }
        return altura(n.esq) - altura(n.dir);
    }

}