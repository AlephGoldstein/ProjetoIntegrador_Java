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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunosList = new ArrayList<>();

        int opt = 0;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar um aluno por ID");
            System.out.println("4 - Sair");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o número de matrícula: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();

                    alunosList.add(new Aluno(nome, matricula));
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Alunos:");
                    for (Aluno aluno : alunosList) {
                        System.out.println(aluno);
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do aluno que deseja buscar: ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();

                    boolean alunoEncontrado = false;
                    for (Aluno aluno : alunosList) {
                        if (aluno.getId() == idBusca) {
                            System.out.println("Aluno encontrado: " + aluno);
                            alunoEncontrado = true;
                            break;
                        }
                    }

                    if (!alunoEncontrado) {
                        System.out.println("Aluno com ID " + idBusca + " não encontrado.");
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
