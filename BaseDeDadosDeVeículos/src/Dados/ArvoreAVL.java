package Dados;

import Entity.Veiculo;

public class ArvoreAVL<T extends Comparable<T>> {
    private No<T> raiz = null;

    public void inserir(T chave, String valor) {
        raiz = inserir(raiz, chave, valor);
    }

    private No<T> inserir(No<T> arv, T chave, String valor) {
        if (arv == null) {
            return new No<>(chave, valor);
        }

        if (chave.compareTo(arv.chave) < 0) {
            arv.esq = inserir(arv.esq, chave, valor);
        } else if (chave.compareTo(arv.chave) > 0) {
            arv.dir = inserir(arv.dir, chave, valor);
        } else {
            return arv; // Chaves duplicadas não são inseridas
        }

        // Atualiza a altura do nó atual
        arv.alturaNo = 1 + Math.max(altura(arv.esq), altura(arv.dir));

        // Calcula o fator de balanceamento
        int fb = obterFB(arv);

        // Realiza as rotações e balanceamento, caso necessário
        if (fb > 1) {
            if (chave.compareTo(arv.esq.chave) < 0) {
                return rotacaoDireitaSimples(arv);
            } else {
                arv.esq = rotacaoEsquerdaSimples(arv.esq);
                return rotacaoDireitaSimples(arv);
            }
        }
        if (fb < -1) {
            if (chave.compareTo(arv.dir.chave) > 0) {
                return rotacaoEsquerdaSimples(arv);
            } else {
                arv.dir = rotacaoDireitaSimples(arv.dir);
                return rotacaoEsquerdaSimples(arv);
            }
        }

        return arv;
    }

    private int altura(No<T> no) {
        if (no == null) {
            return -1;
        }
        return no.alturaNo;
    }

    private int obterFB(No<T> no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esq) - altura(no.dir);
    }


    private No<T> balancear(No<T> n) {
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

    private No<T> rotacaoDireitaSimples(No<T> y) {
        No<T> x = y.esq;
        No<T> T2 = x.dir;

        x.dir = y;
        y.esq = T2;

        y.alturaNo = 1 + Math.max(altura(y.esq), altura(y.dir));
        x.alturaNo = 1 + Math.max(altura(x.esq), altura(x.dir));

        return x;
    }

    private No<T> rotacaoEsquerdaSimples(No<T> x) {
        No<T> y = x.dir;
        No<T> T2 = y.esq;

        y.esq = x;
        x.dir = T2;

        x.alturaNo = 1 + Math.max(altura(x.esq), altura(x.dir));
        y.alturaNo = 1 + Math.max(altura(y.esq), altura(y.dir));

        return y;
    }

    public void remover(T chave) {
        raiz = remover(raiz, chave);
    }

    private No<T> remover(No<T> arv, T chave) {
    	if (arv == null) {
            return null;
        }

        if (chave.compareTo(arv.chave) < 0) {
            arv.esq = remover(arv.esq, chave);
        } else if (chave.compareTo(arv.chave) > 0) {
            arv.dir = remover(arv.dir, chave);
        } else {
            if (arv.esq == null || arv.dir == null) {
                arv = (arv.esq != null) ? arv.esq : arv.dir;
            } else {
                No<T> sucessor = noMenorChave(arv.dir);
                arv.chave = sucessor.chave;
                arv.valor = sucessor.valor;
                arv.dir = remover(arv.dir, sucessor.chave);
            }
        }

        if (arv == null) {
            return arv;
        }

        arv.alturaNo = 1 + Math.max(altura(arv.esq), altura(arv.dir));

        int fb = obterFB(arv);

        if (fb > 1) {
            if (obterFB(arv.esq) >= 0) {
                return rotacaoDireitaSimples(arv);
            } else {
                arv.esq = rotacaoEsquerdaSimples(arv.esq);
                return rotacaoDireitaSimples(arv);
            }
        }
        if (fb < -1) {
            if (obterFB(arv.dir) <= 0) {
                return rotacaoEsquerdaSimples(arv);
            } else {
                arv.dir = rotacaoDireitaSimples(arv.dir);
                return rotacaoEsquerdaSimples(arv);
            }
        }

        return arv;
    }
    
    private No<T> noMenorChave(No<T> arv) {
        if (arv == null || arv.esq == null) {
            return arv;
        }
        return noMenorChave(arv.esq);
    }

	public boolean atualizar(T chave, String novoValor) {
		// TODO Auto-generated method stub
		return false;
	}

	public T buscar(T chave) {
		// TODO Auto-generated method stub
		return null;
	}
    
}