import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador player1;
    private Jogador player2;
    public Scanner sc = new Scanner(System.in);

    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();

        while(Jogar());
    }

    public void iniciarJogadores(){
        System.out.println("Quem será o Player 1?");
        if (escolherPlayer() == 1){
            this.player1 = new Humano(1);
        }else{
            this.player1 = new CPU(1);
        }

        System.out.println("----------------------");
        System.out.println("Quem vai ser o Player 2?");
        if (escolherPlayer() == 2){
            this.player2 = new Humano(2);
        }else{
            this.player2 = new CPU(2);
        }
    }

    public int escolherPlayer(){
        int opcao = 0;
        do {
            System.out.println("1. Humano");
            System.out.println("2. CPU");
            System.out.println("Opção: ");
            opcao = sc.nextInt();
            if (opcao != 1 && opcao != 2){
                System.out.println("Tente Novamente!");
            }
        }while (opcao != 1 && opcao != 2);
        return opcao;
    }

    public boolean Jogar(){
        if(ganhou() == 0 ){
            System.out.println();
            System.out.println("----------------------");
            System.out.println("\nRodada " + rodada);
            System.out.println("É a vez do jogador " + vez() );

            if(vez()==1)
                player1.jogar(tabuleiro);
            else
                player2.jogar(tabuleiro);

            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            vez++;
            rodada++;
            return true;
        }else{
            if(ganhou() == -1 )
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");

            return false;
        }
    }

    public int vez(){
        if (vez % 2 == 1){
            return 1;
        }else{
            return 2;
        }
    }

    public int ganhou(){
        if (tabuleiro.checkLinha() == 1){
            return 1;
        }else if (tabuleiro.checkColunas() == 1){
            return 1;
        }else if (tabuleiro.checkDiagonais() == 1){
            return 1;
        }if (tabuleiro.checkLinha() == -1){
            return -1;
        }else if (tabuleiro.checkColunas() == -1){
            return -1;
        }else if (tabuleiro.checkDiagonais() == -1){
            return -1;
        }
        return 0;
    }
}
