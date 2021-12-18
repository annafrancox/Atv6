package main;

import usuario.Secretario;
import usuario.Usuario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opc = -1;
        while(opc != 0) {
            System.out.println("BEM-VINDO AO SISTEMA DE IMPRESSÃO");
            System.out.println("ESCOLHA UMA DAS OPÇÕES ABAIXO DE ACORDO COM SEU NÍVEL DE USUÁRIO");
            System.out.println("DIGITE 1 PARA PROFESSOR");
            System.out.println("DIGITE 2 PARA ALUNO");
            System.out.println("DIGITE 3 PARA SECRETÁRIO");
            System.out.println("DIGITE 0 PARA SAIR");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("DIGITE A MATRICULA PARA ACESSAR");
                    String matriculaA = scanner.nextLine();
                    while (matriculaA != "123456") {
                        System.out.println("ERRO! DIGITE NOVAMENTE");
                        matriculaA = scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("DIGITE A MATRICULA PARA ACESSAR");
                    String matriculaP = scanner.nextLine();
                    while (matriculaP != "123456") {
                        System.out.println("ERRO! DIGITE NOVAMENTE");
                        matriculaP = scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("DIGITE A CREDENCIAL DE ACESSO DE SECRETÁRIOS");
                    String cred = scanner.nextLine();
                    while (cred != Secretario.credential) {
                        System.out.println("ERRO! DIGITE NOVAMENTE");
                        cred = scanner.nextLine();
                    }
                    int secOpc = -1;
                    while (secOpc != 0) {
                        System.out.println("ESCOLHA UMA DAS OPERAÇÕES ABAIXO");
                        System.out.println("DIGITE 1 PARA COLOCAR PEDIDOS NA FILA");
                        System.out.println("DIGITE 2 PARA DAR PEDIDOS COMO CONCLUÍDO");
                        System.out.println("DIGITE 3 PARA CADASTRAR USUÁRIOS");
                        System.out.println("DIGITE 0 PARA SAIR");
                    }
                    switch(secOpc) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            System.out.println("Deseja cadastrar um professor ou um aluno? (P para professor e A para aluno)");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}