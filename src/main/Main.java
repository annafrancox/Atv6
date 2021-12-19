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
            System.out.println("Bem-vindo ao sistema de impressão");
            System.out.println("Escolha e digite uma das opções abaixo de acordo com seu nível de usuário:");
            System.out.println("[1] para professor");
            System.out.println("[2] para aluno");
            System.out.println("[3] para secretário");
            System.out.println("[0] para sair");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite a mátricula para acessar:");
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
                        int opcProf = -1;
                        while(opcProf != 0) {
                            System.out.println("Bem-vindo, professor!");
                            System.out.println("Escolha e digite uma das opções abaixo:");
                            System.out.println("[1] para pedir impressão");
                            System.out.println("[2] para retirar impressões concluídas");
                            System.out.println("[0] para sair");
                            opcProf = scanner.nextInt();
                            switch(opcProf) {
                                case 1:
                                    int arquivo, numCopias;
                                    String cor, dataEntrega, horaEntrega;
                                    System.out.println("Digite a seguir as informações do pedido!");
                                    System.out.println("Número do arquivo:");
                                    arquivo = scanner.nextInt();
                                    System.out.println("Número de cópias:");
                                    numCopias = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Data da impressão:");
                                    dataEntrega = scanner.nextLine();
                                    System.out.println("Hora da impressão:");
                                    horaEntrega = scanner.nextLine();
                                    System.out.println("Cor da impressão:");
                                    cor = scanner.nextLine();
                                    PedidoImpressao pedidoImpressao = professorPedindo.pedeImpressao(arquivo, numCopias, cor, dataEntrega, horaEntrega);
                                    System.out.println(pedidoImpressao);
                                    listaPedidos.add(pedidoImpressao);
                                    System.out.println("Pedido concluído com sucesso! Agora é só esperar a aprovação :)");
                                    break;
                                case 2:
                                    PedidoImpressao pedidosParaRemover[] = new PedidoImpressao[listaPedidos.size()];
                                    int i = 0, j = 0;
                                    for(PedidoImpressao pedido : listaPedidos) {
                                        j++;
                                        if(pedido.getSolicitanteProfessor() == professorPedindo && pedido.getStatus() == "Concluido") {
                                            System.out.println(pedido);
                                            if(professorPedindo.pegar(pedido)) {
                                                pedidosParaRemover[i] = pedido;
                                                i++;
                                                System.out.println("Impressão retirada com sucesso!");
                                            }
                                        }
                                    }
                                    if(j == 0) {
                                        System.out.println("Não existem pedidos para serem retirados.");
                                    }
                                    for(PedidoImpressao r : pedidosParaRemover) {
                                        listaPedidos.remove(r);
                                    }
                                case 0:
                                    System.out.println("Obrigado por usar o sistema! (:");
                                    break;
                                default:
                                    System.out.println("Erro! Opção inválida.");
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("Erro! A mátricula digitada não foi encontrada. Tente novamente");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Digite a matricula para acessar:");
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
                        int opcAluno = -1;
                        while(opcAluno != 0) {
                            System.out.println("Bem-vindo, aluno!");
                            System.out.println("Escolha e digite uma das opções abaixo:");
                            System.out.println("[1] para pedir impressão");
                            System.out.println("[2] para retirar impressões concluídas");
                            System.out.println("[0] para sair");
                            opcAluno = scanner.nextInt();
                            switch(opcAluno) {
                                case 1:
                                    int arquivo, numCopias;
                                    String cor, dataEntrega, horaEntrega;
                                    System.out.println("Digite a seguir as informações do pedido!");
                                    System.out.println("Número do arquivo:");
                                    arquivo = scanner.nextInt();
                                    System.out.println("Número de cópias:");
                                    numCopias = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Data da impressão:");
                                    dataEntrega = scanner.nextLine();
                                    System.out.println("Hora da impressão:");
                                    horaEntrega = scanner.nextLine();
                                    System.out.println("Cor da impressão:");
                                    cor = scanner.nextLine();
                                    PedidoImpressao pedidoImpressao = alunoPedindo.pedeImpressao(arquivo, numCopias, cor, dataEntrega, horaEntrega);
                                    listaPedidos.add(pedidoImpressao);
                                    System.out.println("Pedido concluído com sucesso! Agora é só esperar a aprovação :)");
                                    break;
                                case 2:
                                    PedidoImpressao pedidosParaRemover[] = new PedidoImpressao[listaPedidos.size()];
                                    int i = 0, j = 0;
                                    for(PedidoImpressao pedido : listaPedidos) {
                                        j++;
                                        if(pedido.getSolicitanteAluno() == alunoPedindo && pedido.getStatus() == "Concluido") {
                                            System.out.println(pedido);
                                            if(alunoPedindo.pegar(pedido)) {
                                                pedidosParaRemover[i] = pedido;
                                                i++;
                                                System.out.println("Impressão retirada com sucesso!");
                                            }
                                        }
                                    }
                                    if(j == 0) {
                                        System.out.println("Não existem pedidos para serem retirados.");
                                    }
                                    for(PedidoImpressao r : pedidosParaRemover) {
                                        listaPedidos.remove(r);
                                    }
                                case 0:
                                    System.out.println("Obrigado por usar o sistema! (:");
                                    break;
                                default:
                                    System.out.println("Erro! Opção inválida.");
                            }
                        }
                    }
                    else {
                        System.out.println("Erro! A mátricula digitada não foi encontrada. Tente novamente");
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite a credencial de acesso de secretários:");
                    String cred = scanner.nextLine();
                    while (!Objects.equals(cred, Secretario.credential)) {
                        System.out.println("ERRO! Digite novamente.");
                        cred = scanner.nextLine();
                    }
                    int secOpc = -1;
                    while (secOpc != 0) {
                        System.out.println("Bem-vindo, secretário!");
                        System.out.println("Escolha e digite uma das opções abaixo:");
                        System.out.println("[1] para colocar pedidos na fila");
                        System.out.println("[2] para dar pedidos como concluídos");
                        System.out.println("[3] para cadastrar usuários");
                        System.out.println("[4] para cadastrar disciplinas");
                        System.out.println("[0] para sair");
                        secOpc = scanner.nextInt();
                        switch(secOpc) {
                            case 1:
                                if(listaPedidos.isEmpty()) {
                                    System.out.println("Não existe nenhum pedido cadastrado no momento!");
                                }
                                else {
                                    System.out.println("Lista dos pedidos a serem registrados:");
                                    int contPedidosSolicitados = 0;
                                    for(PedidoImpressao pedido : listaPedidos) {
                                        if(Objects.equals(pedido.getStatus(), "Solicitado")) {
                                            contPedidosSolicitados++;
                                            System.out.println(pedido);
                                        }
                                    }
                                    if(contPedidosSolicitados > 0) {
                                        System.out.println("Digite o ID do pedido que deseja registrar:");
                                        int id = scanner.nextInt();
                                        PedidoImpressao pedidoParaAdicionarNaFila = null;
                                        for(PedidoImpressao pedido : listaPedidos) {
                                            if(pedido.getId() == id) {
                                                pedidoParaAdicionarNaFila = pedido;
                                                break;
                                            }
                                        }
                                        if(pedidoParaAdicionarNaFila != null && Objects.equals(pedidoParaAdicionarNaFila.getStatus(), "Solicitado")) {
                                            PedidoImpressao pedido = Secretario.registraImpressao(pedidoParaAdicionarNaFila);
                                            listaPedidos.remove(pedidoParaAdicionarNaFila);
                                            listaPedidos.add(pedido);
                                        }
                                        else {
                                            System.out.println("Erro! Pedido não encontrado.");
                                        }
                                    }
                                    else {
                                        System.out.println("Não existe pedido solicitado no momento.");
                                    }
                                }
                                break;
                            case 2:
                                if(listaPedidos.isEmpty()) {
                                    System.out.println("Não existe pedido solicitado no momento.");
                                }
                                else {
                                    int contPedidosFila = 0;
                                    System.out.println("Lista dos pedidos em fila: ");
                                    for(PedidoImpressao pedido : listaPedidos) {
                                        if(Objects.equals(pedido.getStatus(), "Fila")) {
                                            contPedidosFila++;
                                            System.out.println(pedido);
                                        }
                                    }
                                    if(contPedidosFila > 0) {
                                        System.out.println("Digite o ID do pedido concluido: ");
                                        int idFila = scanner.nextInt();
                                        PedidoImpressao pedidoParaConcluir = null;
                                        for(PedidoImpressao pedido : listaPedidos) {
                                            if(pedido.getId() == idFila && Objects.equals(pedido.getStatus(), "Fila")) {
                                                pedidoParaConcluir = pedido;
                                                break;
                                            }
                                        }
                                        if(pedidoParaConcluir != null && Objects.equals(pedidoParaConcluir.getStatus(), "Fila")) {
                                            PedidoImpressao pedidoConcluido = Secretario.imprimir(pedidoParaConcluir);
                                            listaPedidos.remove(pedidoParaConcluir);
                                            listaPedidos.add(pedidoConcluido);
                                        }
                                        else {
                                            System.out.println("Erro! Pedido não encontrado.");
                                        }
                                    }
                                    else {
                                        System.out.println("Não existe pedido na fila para aprovação.");
                                    }
                                }
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.println("Digite o nível de usuário que deseja cadastrar:");
                                System.out.println("[P] para professor");
                                System.out.println("[A] para aluno");
                                System.out.println("[S] para secretário");
                                String nome, sexo, anoNascimento, mesNascimento, diaNascimento, matricula;
                                String opcUsuario = scanner.nextLine();
                                while(!Objects.equals(opcUsuario, "P") && !Objects.equals(opcUsuario, "A") && !Objects.equals(opcUsuario, "S")) {
                                    System.out.println("Opção inválida! Tente novamente.");
                                    opcUsuario = scanner.nextLine();
                                }
                                switch(opcUsuario) {
                                    case "P":
                                        String unidade, departamento, horarioAtendimento;
                                        System.out.println("Digite as informações do professor a ser registrado:");
                                        System.out.println("Nome: ");
                                        nome = scanner.nextLine();
                                        System.out.println("Sexo: ");
                                        sexo = scanner.nextLine();
                                        System.out.println("Data de nascimento");
                                        System.out.println("Ano de nascimento(AAAA): ");
                                        anoNascimento = scanner.nextLine();
                                        System.out.println("Mês de nascimento(MM): ");
                                        mesNascimento = scanner.nextLine();
                                        System.out.println("Dia de nascimento(DD): ");
                                        diaNascimento = scanner.nextLine();
                                        String dataNascimento = anoNascimento + "/" + mesNascimento + "/" + diaNascimento;
                                        System.out.println("Matrícula:");
                                        matricula = scanner.nextLine();
                                        boolean verificaMatricula = false;
                                        for(Professor professor : listaProfessores) {
                                            if(Objects.equals(professor.getMatricula(), matricula)) {
                                                verificaMatricula = true;
                                                break;
                                            }
                                        }
                                        while(verificaMatricula) {
                                            Professor p = null;
                                            System.out.println("Matrícula já existe. Por favor digite outra");
                                            matricula = scanner.nextLine();
                                            for(Professor professor : listaProfessores) {
                                                if(Objects.equals(professor.getMatricula(), matricula)) {
                                                    p = professor;
                                                    break;
                                                }
                                            }
                                            if(p == null) {
                                                verificaMatricula = false;
                                            }
                                        }
                                        System.out.println("Unidade: ");
                                        unidade = scanner.nextLine();
                                        System.out.println("Departamento: ");
                                        departamento = scanner.nextLine();
                                        System.out.println("Horário de atendimento: ");
                                        horarioAtendimento = scanner.nextLine();
                                        Professor professor = Secretario.cadastraProfessor(nome, sexo, dataNascimento, matricula, unidade, departamento, horarioAtendimento);
                                        listaProfessores.add(professor);
                                        System.out.println("Professor cadastrado com sucesso!");
                                        break;
                                    case "A":
                                        String curso;
                                        System.out.println("Digite as informações do aluno a ser registrado:");
                                        System.out.println("Nome: ");
                                        nome = scanner.nextLine();
                                        System.out.println("Sexo: ");
                                        sexo = scanner.nextLine();
                                        System.out.println("Data de nascimento: ");
                                        System.out.println("Ano de nascimento(AAAA): ");
                                        anoNascimento = scanner.nextLine();
                                        System.out.println("Mês de nascimento(MM): ");
                                        mesNascimento = scanner.nextLine();
                                        System.out.println("Dia de nascimento(DD): ");
                                        diaNascimento = scanner.nextLine();
                                        dataNascimento = anoNascimento + "/" + mesNascimento + "/" + diaNascimento;
                                        System.out.println("Matrícula: ");
                                        matricula = scanner.nextLine();
                                        boolean verificaMatriculaAluno = false;
                                        for(Aluno aluno : listaAlunos) {
                                            if(Objects.equals(aluno.getMatricula(), matricula)) {
                                                verificaMatriculaAluno = true;
                                                break;
                                            }
                                        }
                                        while(verificaMatriculaAluno) {
                                            System.out.println("Matrícula já existe. Por favor digite outra");
                                            matricula = scanner.nextLine();
                                            Aluno a = null;
                                            for(Aluno aluno : listaAlunos) {
                                                if(Objects.equals(aluno.getMatricula(), matricula)) {
                                                    a = aluno;
                                                    break;
                                                }
                                            }
                                            if(a == null) {
                                                verificaMatriculaAluno = false;
                                            }
                                        }
                                        System.out.println("Curso: ");
                                        curso = scanner.nextLine();
                                        Aluno aluno = Secretario.cadastraAluno(nome, sexo, dataNascimento, matricula, curso);
                                        listaAlunos.add(aluno);
                                        System.out.println("Aluno cadastrado com sucesso!");
                                        break;
                                    case "S":
                                        System.out.println("Digite as informações do secretário a ser registrado:");
                                        String horarioTrabalho;
                                        System.out.println("Nome: ");
                                        nome = scanner.nextLine();
                                        System.out.println("Sexo: ");
                                        sexo = scanner.nextLine();
                                        System.out.println("Data de nascimento");
                                        System.out.println("Ano de nascimento(AAAA): ");
                                        anoNascimento = scanner.nextLine();
                                        System.out.println("Mês de nascimento(MM): ");
                                        mesNascimento = scanner.nextLine();
                                        System.out.println("Dia de nascimento(DD): ");
                                        diaNascimento = scanner.nextLine();
                                        dataNascimento = anoNascimento + "/" + mesNascimento + "/" + diaNascimento;
                                        System.out.println("Matrícula: ");
                                        matricula = scanner.nextLine();
                                        boolean verificaMatriculaSec = false;
                                        for(Secretario secretario : listaSecretarios) {
                                            if(Objects.equals(secretario.getMatricula(), matricula)) {
                                                verificaMatriculaSec = true;
                                                break;
                                            }
                                        }
                                        while(verificaMatriculaSec) {
                                            System.out.println("Matrícula já existe. Por favor digite outra");
                                            matricula = scanner.nextLine();
                                            Secretario s = null;
                                            for(Secretario secretario : listaSecretarios) {
                                                if(Objects.equals(secretario.getMatricula(), matricula)) {
                                                    s = secretario;
                                                    break;
                                                }
                                            }
                                            if(s == null) {
                                                verificaMatriculaSec = false;
                                            }
                                        }
                                        System.out.println("Unidade: ");
                                        unidade = scanner.nextLine();
                                        System.out.println("Departamento: ");
                                        departamento = scanner.nextLine();
                                        System.out.println("Horário de trabalho: ");
                                        horarioTrabalho = scanner.nextLine();
                                        Secretario secretario = Secretario.cadastraSecretario(nome, sexo, dataNascimento, matricula, unidade, departamento, horarioTrabalho);
                                        listaSecretarios.add(secretario);
                                        System.out.println("Secretário cadastrado com sucesso!");
                                        System.out.println("A credencial de acesso para o novo secretário é " + Secretario.credential + ". Por favor informe-lhe.");
                                        break;
                                    default:
                                        System.out.println("Erro! Opção inválida");
                                        break;
                                    }
                                break;
                            case 4:
                                scanner.nextLine();
                                System.out.println("Digite o nome da disciplina :");
                                String nomeDisciplina = scanner.nextLine();
                                boolean existeDisciplina = false;
                                Disciplina disciplinaProcurada = null;
                                for(Disciplina disciplina : listaDisciplinas) {
                                    if(Objects.equals(disciplina.getNome(), nomeDisciplina)) {
                                        existeDisciplina = true;
                                        disciplinaProcurada = disciplina;
                                        break;
                                    }
                                }
                                if(!existeDisciplina) {
                                    System.out.println("Disciplina não encontrada. Cadastrando...");
                                    Disciplina disciplina = new Disciplina(nomeDisciplina);
                                    listaDisciplinas.add(disciplina);
                                    disciplinaProcurada = disciplina;
                                }
                                Professor professorMinistrado = null;
                                System.out.println("Indique a matrícula do professor que ministrará a disciplina: ");
                                String matriculaProf = scanner.nextLine();
                                for(Professor prof : listaProfessores) {
                                    if(Objects.equals(prof.getMatricula(), matriculaProf)) {
                                        professorMinistrado = prof;
                                    }
                                }
                                if(professorMinistrado == null) {
                                    System.out.println("O professor não existe. Volte na opção 3 para cadastrá-lo. ");
                                }
                                else {
                                    System.out.println("Informe o semestre atual: ");
                                    String semestre = scanner.nextLine();
                                    boolean cadastrado = false;
                                    DisciplinaSemestre disciplinaSemestre = new DisciplinaSemestre(disciplinaProcurada, professorMinistrado, semestre);
                                    for(DisciplinaSemestre ds : listaDisciplinasSemestre) {
                                        if(ds.getProfessor() != null && Objects.equals(ds.getDisciplina().getNome(), disciplinaProcurada.getNome()) && Objects.equals(ds.getSemestre(), semestre)) {
                                            cadastrado = true;
                                            break;
                                        }
                                    }
                                    if(cadastrado) {
                                        System.out.println("Esta disciplina já tem um professor nesse semestre!");
                                    }
                                    else {
                                        listaDisciplinasSemestre.add(disciplinaSemestre);
                                        System.out.println("O professor está cadastrado na disciplina!");
                                    }
                                }
                            case 0:
                                System.out.println("Obrigado por usar o sistema! (:");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}