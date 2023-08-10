package Dados;


public class No {
	 int chave;
     String valor;
     int alturaNo;
     No esq, dir;

     No(int chave, String valor) {
         this.chave = chave;
         this.valor = valor;
         this.alturaNo = 0;
         this.esq = null;
         this.dir = null;
     }
}
