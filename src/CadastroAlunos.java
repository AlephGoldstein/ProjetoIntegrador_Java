import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroAlunos {

    public static class Aluno {
        private static int contadorId = 1;
        private int id;
        private String nome;
        private int matricula;

        public Aluno(String nome, int matricula) {
            this.id = contadorId++;
            this.nome = nome;
            this.matricula = matricula;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Aluno: " + nome + ", Matrícula: " + matricula;
        }
    }

    public static class Funcionario {
        private static int contadorId = 1;
        private int id;
        private String nome;
        private int matricula;
        private String cargo;

        public Funcionario(String nome, int matricula, String cargo) {
            this.id = contadorId++;
            this.nome = nome;
            this.matricula = matricula;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Nome: " + nome + ", Matrícula: " + matricula + ", Cargo: " + cargo;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunosList = new ArrayList<>();
        List<Funcionario> funcionariosList = new ArrayList<>();

        int opt;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Aluno ou Funcionário");
            System.out.println("2 - Listar Alunos ou Funcionários");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Sair");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Deseja cadastrar aluno ou funcionário? ");
                    String escolha = scanner.nextLine().toLowerCase();
                    if (escolha.equals("aluno")) {
                        System.out.print("Digite o nome do aluno: ");
                        String nomeAluno = scanner.nextLine();
                        System.out.print("Digite o número de matrícula do aluno: ");
                        int matriculaAluno = scanner.nextInt();
                        scanner.nextLine();
                        alunosList.add(new Aluno(nomeAluno, matriculaAluno));
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else if (escolha.equals("funcionario")) {
                        System.out.print("Digite o nome do funcionário: ");
                        String nomeFunc = scanner.nextLine();
                        System.out.print("Digite o número de matrícula do funcionário: ");
                        int matriculaFunc = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o cargo do funcionário (cord para Coordenador ou aqv para Analista de Qualidade de Vida): ");
                        String cargo = scanner.nextLine();
                        if (!cargo.equals("cord") && !cargo.equals("aqv")) {
                            System.out.println("Cargo inválido. Escolha 'cord' ou 'aqv'.");
                        } else {
                            funcionariosList.add(new Funcionario(nomeFunc, matriculaFunc, cargo));
                            System.out.println("Funcionário cadastrado com sucesso!");
                        }
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("Deseja listar alunos ou funcionários? ");
                    escolha = scanner.nextLine().toLowerCase();
                    if (escolha.equals("aluno")) {
                        System.out.println("Lista de Alunos:");
                        for (Aluno aluno : alunosList) {
                            System.out.println(aluno);
                        }
                    } else if (escolha.equals("funcionario")) {
                        System.out.println("Lista de Funcionários:");
                        for (Funcionario funcionario : funcionariosList) {
                            System.out.println(funcionario);
                        }
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;

                case 3:
                    System.out.println("Deseja buscar aluno ou funcionário? ");
                    escolha = scanner.nextLine().toLowerCase();
                    System.out.print("Digite o ID que deseja buscar: ");
                    int idBusca = scanner.nextInt();
                    boolean encontrado = false;

                    if (escolha.equals("aluno")) {
                        for (Aluno aluno : alunosList) {
                            if (aluno.getId() == idBusca) {
                                System.out.println("Aluno encontrado: " + aluno);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Aluno com ID " + idBusca + " não encontrado.");
                        }
                    } else if (escolha.equals("funcionario")) {
                        for (Funcionario funcionario : funcionariosList) {
                            if (funcionario.getId() == idBusca) {
                                System.out.println("Funcionário encontrado: " + funcionario);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Funcionário com ID " + idBusca + " não encontrado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opt != 4);

        scanner.close();
    }
}
