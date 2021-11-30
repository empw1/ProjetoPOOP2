package meiaPiramide;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    int numeros[] = new int[20];

    for(int i=0; i<20; i++) {
        System.out.println("Digite um número: ");
        numeros[i] = entrada.nextInt();
    }
    for(int i=0; i<20; i++) {
        System.out.println("Numero na posição " + i + ": " + numeros[i]);
        }
    }
}
