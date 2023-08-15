package Dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Entity.Veiculo;

public class ArvoreAVL<T> {
    No<T> raiz = null;
    int rotEsq = 0;
    int rotDir = 0;

    public int getRotEsq() {
		return rotEsq;
	}

	public void setRotEsq(int rotEsq) {
		this.rotEsq = rotEsq;
	}

	public int getRotDir() {
		return rotDir;
	}

	public void setRotDir(int rotDir) {
		this.rotDir = rotDir;
	}

	public No<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}

	public void inserir(String chave, T veiculo) {
        raiz = inserir(this.getRaiz(), chave, veiculo);
        gravarLog();
    }

	private No<T> inserir(No<T> arv, String chave, T valor) {
	    if (arv == null) {
	        return new No<T>(chave, valor);
	    }

	    if (chave.compareTo(arv.getChave()) < 0) {
	        arv.esq = inserir(arv.esq, chave, valor);
	    } else if (chave.compareTo(arv.getChave()) > 0) {
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
            if (chave.compareTo(arv.esq.getChave()) < 0) {
                return rotacaoDireitaSimples(arv);
            } else {
                arv.esq = rotacaoEsquerdaSimples(arv.esq);
                return rotacaoDireitaSimples(arv);
            }
        } else if (fb < -1) {
            if (chave.compareTo(arv.dir.getChave()) > 0) {
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
        if (y == null || y.esq == null) {
            return y; // Não é possível fazer rotação
        }
        
        rotDir++;
        
        No<T> x = y.esq;
        No<T> T2 = x.dir;

        x.dir = y;
        y.esq = T2;

        y.alturaNo = 1 + Math.max(altura(y.esq), altura(y.dir));
        x.alturaNo = 1 + Math.max(altura(x.esq), altura(x.dir));

        return x;
    }

    private No<T> rotacaoEsquerdaSimples(No<T> x) {
        if (x == null || x.dir == null) {
            return x; // Não é possível fazer rotação
        }

        rotEsq++;
        
        No<T> y = x.dir;
        No<T> T2 = y.esq;

        y.esq = x;
        x.dir = T2;

        x.alturaNo = 1 + Math.max(altura(x.esq), altura(x.dir));
        y.alturaNo = 1 + Math.max(altura(y.esq), altura(y.dir));

        return y;
    }

    public void remover(String chave) {
        raiz = remover(raiz, chave);
        gravarLog();
    }

    private No<T> remover(No<T> arv, String chave) {
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

    public boolean atualizar(String chave, T novoValor) {
        No<T> no = buscar(chave);
        if (no != null) {
            no.valor = novoValor;
            return true;
        }
        return false; // Caso a chave não seja encontrada
    }

	public No<T> buscar(String chaveBusca) {
        return this.buscar(this.getRaiz(), chaveBusca);
    }

    private No<T> buscar(No<T> arv, String chaveBusca) {
        if (arv == null) {
            return null;
        }

        if (chaveBusca.compareTo(arv.chave) < 0) {
            return buscar(arv.esq, chaveBusca);
        } else if (chaveBusca.compareTo(arv.chave) > 0) {
            return buscar(arv.dir, chaveBusca);
        } else {
            return arv;
        }
    }
    
    public int getQuantidade() {
        return getQuantidade(raiz);
    }

    private int getQuantidade(No<T> arv) {
        if (arv == null) {
            return 0;
        }
        return 1 + getQuantidade(arv.esq) + getQuantidade(arv.dir);
    }

    public void percursoEmOrdem() {
        percursoEmOrdem(raiz);
    }

    private void percursoEmOrdem(No<T> no) {
        if (no != null) {
            percursoEmOrdem(no.esq);
            System.out.println(no.valor + " " +  no.getValor()); // Ou realize outra operação com o valor do nó
            percursoEmOrdem(no.dir);
        }
    }
    
    public void gravarLog() {
        try {
        	String caminhoArquivo = "data/log.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true));
            writer.write("Altura da árvore: " + altura(raiz));
            writer.newLine();
            writer.write("Rotações à Esquerda: " + rotEsq + ", Rotações à Direita: " + rotDir);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}