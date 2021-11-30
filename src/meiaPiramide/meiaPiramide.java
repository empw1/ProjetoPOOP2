package meiaPiramide;

public class meiaPiramide {
    public static void main(String[] args) {
        int[] piramide = new int[] {51, 98, 12, 31, 9, 21, 20, 77, 65, 10};
        int soma = 0;
        int menornum = 999;
        int i, j, k;

        System.out.println("-----PIRAMIDE-----");
        for (i = 0, k = 0; i < (piramide.length) / 2; i++){
            for (j = 0; j < i; j++){
                System.out.print(piramide[k] + " ");
                if (piramide[k] < menornum){
                    menornum = piramide[k];
                    soma = soma + menornum;
                }else if (menornum == 9){
                    menornum = menornum+1;
                    soma = soma + menornum;
                }
                k++;
            }
            System.out.print("\n");
        }
        System.out.println("\n----------------");
        System.out.println("\nValor da soma dos menores numeros por linha: " + soma);
    }
}
