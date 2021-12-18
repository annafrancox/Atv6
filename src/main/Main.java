package main;

import disciplina.Disciplina;
import disciplina.DisciplinaSemestre;
import impressao.PedidoImpressao;
import usuario.Aluno;
import usuario.Secretario;
import usuario.Usuario;
import usuario.Professor;
import impressao.PedidoImpressao;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Professor> listaProfessores = new ArrayList<>();
        Collection<Aluno> listaAlunos = new ArrayList<>();
        Collection<Secretario> listaSecretarios = new ArrayList<>();
        Collection<PedidoImpressao> listaPedidos = new ArrayList<>();
        Collection<Disciplina> listaDisciplinas = new ArrayList<>();
        Collection<DisciplinaSemestre> listaDisciplinasSemestre = new ArrayList<>();
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
                    boolean existeAluno = false;
                    Aluno alunoPedindo = null;
                    for(Aluno aluno : listaAlunos) {
                        if(Objects.equals(matriculaA, aluno.getMatricula())) {
                            alunoPedindo = aluno;
                            existeAluno = true;
                            break;
                        }
                    }
                    if(existeAluno) {
                        System.out.println("DIGITE 1 PARA PEDIR IMPRESSÃO");
                        System.out.println("DIGITE 2 PARA RETIRAR IMPRESSÕES CONCLUÍDAS");
                        System.out.println("DIGITE 0 PARA SAIR");
                        int opcAluno = scanner.nextInt();
                        switch(opcAluno) {
                            case 1:
                                int arquivo, numCopias;
                                String cor, dataEntrega, horaEntrega;
                                System.out.println("DIGITE AS INFORMAÇÕES DO PEDIDO");
                                System.out.println("Digite o número do arquivo");
                                arquivo = scanner.nextInt();
                                System.out.println("Digite o número de cópias");
                                numCopias = scanner.nextInt();
                                System.out.println("Digite a data da impressão");
                                dataEntrega = scanner.nextLine();
                                System.out.println("Digite a hora da impressão");
                                horaEntrega = scanner.nextLine();
                                System.out.println("Digite a cor da impressão");
                                cor = scanner.nextLine();
                                alunoPedindo.pedeImpressao(arquivo, numCopias, cor, dataEntrega, horaEntrega);
                                break;
                            case 2:
                                for(PedidoImpressao pedido : listaPedidos) {
                                    if(pedido.getSolicitanteAluno() == alunoPedindo && pedido.getStatus() == "Concluido") {
                                        pedido.toString();
                                        alunoPedindo.pegar(pedido);
                                    }
                                }
                                System.out.println("AS SUAS IMPRESSÕES FORAM RETIRADAS COM SUCESSO!");
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida! Erro");
                        }
                    }
                    break;
                case 2:
                    System.out.println("DIGITE A MATRICULA PARA ACESSAR");
                    String matriculaP = scanner.nextLine();
                    boolean existe = false;
                    Professor professorPedindo = null;
                    for(Professor professor : listaProfessores) {
                        if(Objects.equals(matriculaP, professor.getMatricula())) {
                            professorPedindo = professor;
                            existe = true;
                            break;
                        }
                    }
                    if(existe) {
                        System.out.println("DIGITE 1 PARA PEDIR IMPRESSÃO");
                        System.out.println("DIGITE 2 PARA RETIRAR IMPRESSÕES CONCLUÍDAS");
                        System.out.println("DIGITE 0 PARA SAIR");
                        int opcProf = scanner.nextInt();
                        switch(opcProf) {
                            case 1:
                                int arquivo, numCopias;
                                String cor, dataEntrega, horaEntrega;
                                System.out.println("DIGITE AS INFORMAÇÕES DO PEDIDO");
                                System.out.println("Digite o número do arquivo");
                                arquivo = scanner.nextInt();
                                System.out.println("Digite o número de cópias");
                                numCopias = scanner.nextInt();
                                System.out.println("Digite a data da impressão");
                                dataEntrega = scanner.nextLine();
                                System.out.println("Digite a hora da impressão");
                                horaEntrega = scanner.nextLine();
                                System.out.println("Digite a cor da impressão");
                                cor = scanner.nextLine();
                                professorPedindo.pedeImpressao(arquivo, numCopias, cor, dataEntrega, horaEntrega);
                                break;
                            case 2:
                                for(PedidoImpressao pedido : listaPedidos) {
                                    if(pedido.getSolicitanteProfessor() == professorPedindo && pedido.getStatus() == "Concluido") {
                                        pedido.toString();
                                        professorPedindo.pegar(pedido);
                                    }
                                }
                                System.out.println("AS SUAS IMPRESSÕES FORAM RETIRADAS COM SUCESSO!");
                            case 0:
                                break;
                            default:
                                System.out.println("Erro! Opção inválida");
                                break;
                        }
                    }
                    else {
                        System.out.println("ERRO! MATRÍCULA NÃO ENCONTRADA! TENTE NOVAMENTE");
                    }
                    break;
                case 3:
                    System.out.println("DIGITE A CREDENCIAL DE ACESSO DE SECRETÁRIOS");
                    String cred = scanner.nextLine();
                    while (!Objects.equals(cred, Secretario.credential)) {
                        System.out.println("ERRO! DIGITE NOVAMENTE");
                        cred = scanner.nextLine();
                    }
                    int secOpc = scanner.nextInt();
                    while (secOpc != 0) {
                        System.out.println("ESCOLHA UMA DAS OPERAÇÕES ABAIXO");
                        System.out.println("DIGITE 1 PARA COLOCAR PEDIDOS NA FILA");
                        System.out.println("DIGITE 2 PARA DAR PEDIDOS COMO CONCLUÍDO");
                        System.out.println("DIGITE 3 PARA CADASTRAR USUÁRIOS");
                        System.out.println("DIGITE 4 PARA CADASTRAR DISCIPLINAS");
                        System.out.println("DIGITE 0 PARA SAIR");
                        secOpc = scanner.nextInt();
                    }
                    switch(secOpc) {
                        case 1:
                            System.out.println("LISTA DOS PEDIDOS PARA COLOCAR NA FILA: ");
                            for(PedidoImpressao pedido : listaPedidos) {
                                if(pedido.getStatus() == "Solicitado") {
                                    pedido.toString();
                                }
                            }
                            System.out.println("DIGITE O ID DO PEDIDO QUE QUER ADICIONAR NA FILA: ");
                            int id = scanner.nextInt();
                            PedidoImpressao pedidoParaAdicionarNaFila = null;
                            for(PedidoImpressao pedido : listaPedidos) {
                                if(pedido.getId() == id) {
                                    pedidoParaAdicionarNaFila = pedido;
                                    break;
                                }
                            }
                            if(pedidoParaAdicionarNaFila != null && Objects.equals(pedidoParaAdicionarNaFila.getStatus(), "Solicitado")) {
                                Secretario.registraImpressao(pedidoParaAdicionarNaFila);
                            }
                            else {
                                System.out.println("PEDIDO NÃO ENCONTRADO!");
                            }
                            break;
                        case 2:
                            System.out.println("LISTA DOS PEDIDOS PARA DAR COMO CONCLUÍDO: ");
                            for(PedidoImpressao pedido : listaPedidos) {
                                if(pedido.getStatus() == "Fila") {
                                    pedido.toString();
                                }
                            }
                            System.out.println("DIGITE O ID DO PEDIDO QUE QUER DAR COMO CONCLUIDO: ");
                            int idFila = scanner.nextInt();
                            PedidoImpressao pedidoParaConcluir = null;
                            for(PedidoImpressao pedido : listaPedidos) {
                                if(pedido.getId() == idFila) {
                                    pedidoParaConcluir = pedido;
                                    break;
                                }
                            }
                            if(pedidoParaConcluir == null && Objects.equals(pedidoParaConcluir.getStatus(), "Fila")) {
                                Secretario.imprimir(pedidoParaConcluir);
                            }
                            else {
                                System.out.println("PEDIDO NÃO ENCONTRADO!");
                            }
                            break;
                        case 3:
                            System.out.println("Deseja cadastrar um professor ou um aluno? (P para professor, A para aluno e S para secretário)");
                            String nome, sexo, anoNascimento, mesNascimento, diaNascimento, matricula;
                            String opcUsuario = scanner.nextLine();
                            while(!Objects.equals(opcUsuario, "P") && !Objects.equals(opcUsuario, "A") && !Objects.equals(opcUsuario, "S")) {
                                System.out.println("Opção inválida!");
                                opcUsuario = scanner.nextLine();
                            }
                            switch(opcUsuario) {
                                case "P":
                                    String unidade, departamento, horarioAtendimento;
                                    System.out.println("Digite o nome");
                                    nome = scanner.nextLine();
                                    System.out.println("Digite o sexo");
                                    sexo = scanner.nextLine();
                                    System.out.println("DATA DE NASCIMENTO");
                                    System.out.println("Digite o ano de nascimento: ");
                                    anoNascimento = scanner.nextLine();
                                    System.out.println("Digite o mês de nascimento: ");
                                    mesNascimento = scanner.nextLine();
                                    System.out.println("Digite o dia de nasicmento: ");
                                    diaNascimento = scanner.nextLine();
                                    String dataNascimento = anoNascimento + "/" + mesNascimento + "/" + diaNascimento;
                                    System.out.println("Digite a matricula:");
                                    matricula = scanner.nextLine();
                                    System.out.println("Digite a unidade: ");
                                    unidade = scanner.nextLine();
                                    System.out.println("Digite o departamento: ");
                                    departamento = scanner.nextLine();
                                    System.out.println("Digite o horario de atendimento: ");
                                    horarioAtendimento = scanner.nextLine();
                                    Professor professor = Secretario.cadastraProfessor(nome, sexo, dataNascimento, matricula, unidade, departamento, horarioAtendimento);
                                    listaProfessores.add(professor);
                                    break;
                                case "A":
                                    String curso;
                                    System.out.println("Digite o nome");
                                    nome = scanner.nextLine();
                                    System.out.println("Digite o sexo");
                                    sexo = scanner.nextLine();
                                    System.out.println("DATA DE NASCIMENTO");
                                    System.out.println("Digite o ano de nascimento: ");
                                    anoNascimento = scanner.nextLine();
                                    System.out.println("Digite o mês de nascimento: ");
                                    mesNascimento = scanner.nextLine();
                                    System.out.println("Digite o dia de nasicmento: ");
                                    diaNascimento = scanner.nextLine();
                                    dataNascimento = anoNascimento + "/" + mesNascimento + "/" + diaNascimento;
                                    System.out.println("Digite a matricula: ");
                                    matricula = scanner.nextLine();
                                    System.out.println("Digite o curso: ");
                                    curso = scanner.nextLine();
                                    Aluno aluno = Secretario.cadastraAluno(nome, sexo, dataNascimento, matricula, curso);
                                    listaAlunos.add(aluno);
                                    break;
                                case "S":
                                    String horarioTrabalho;
                                    System.out.println("Digite o nome");
                                    nome = scanner.nextLine();
                                    System.out.println("Digite o sexo");
                                    sexo = scanner.nextLine();
                                    System.out.println("DATA DE NASCIMENTO");
                                    System.out.println("Digite o ano de nascimento: ");
                                    anoNascimento = scanner.nextLine();
                                    System.out.println("Digite o mês de nascimento: ");
                                    mesNascimento = scanner.nextLine();
                                    System.out.println("Digite o dia de nasicmento: ");
                                    diaNascimento = scanner.nextLine();
                                    dataNascimento = anoNascimento + "/" + mesNascimento + "/" + diaNascimento;
                                    System.out.println("Digite a matricula:");
                                    matricula = scanner.nextLine();
                                    System.out.println("Digite a unidade: ");
                                    unidade = scanner.nextLine();
                                    System.out.println("Digite o departamento: ");
                                    departamento = scanner.nextLine();
                                    System.out.println("Digite o horário de trabalho: ");
                                    horarioTrabalho = scanner.nextLine();
                                    Secretario secretario = Secretario.cadastraSecretario(nome, sexo, dataNascimento, matricula, unidade, departamento, horarioTrabalho);
                                    listaSecretarios.add(secretario);
                                    break;
                                default:
                                    System.out.println("Erro! Opção inválida");
                                    break;
                            }
                        case 4:
                            System.out.println("Digite o nome da disciplina");
                            String nomeDisciplina = scanner.nextLine();
                            boolean existeDisciplina = false;
                            Disciplina disciplinaProcurada;
                            for(Disciplina disciplina : listaDisciplinas) {
                                if(Objects.equals(disciplina.getNome(), nomeDisciplina)) {
                                    existeDisciplina = true;
                                    disciplinaProcurada = disciplina;
                                }
                            }
                            if(!existeDisciplina) {
                                System.out.println("Disciplina não encontrada. Cadastrando...");
                                Disciplina disciplina = new Disciplina(nomeDisciplina);
                                listaDisciplinas.add(disciplina);
                            }
                            System.out.println("Indique a matrícula do professor que ministrará a disciplina: ");
                            
                    }
                    break;
                default:
                    break;
            }
        }
    }
}