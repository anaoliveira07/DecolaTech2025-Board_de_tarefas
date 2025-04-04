import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaDAO tarefaDAO = new TarefaDAO();
        TarefaService tarefaService = new TarefaService(tarefaDAO);

        while (true) {
            System.out.println("\n### MENU ###");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Atualizar Tarefa");
            System.out.println("5. Excluir Tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    tarefaService.adicionarTarefa(descricao);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    List<Tarefa> tarefas = tarefaService.listarTarefas();
                    tarefas.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa a ser concluída: ");
                    Long idConcluir = scanner.nextLong();
                    tarefaService.concluirTarefa(idConcluir);
                    System.out.println("Tarefa concluída!");
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa a ser atualizada: ");
                    Long idAtualizar = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Digite a nova descrição: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("A tarefa está concluída? (true/false): ");
                    boolean concluida = scanner.nextBoolean();
                    tarefaService.atualizarTarefa(idAtualizar, novaDescricao, concluida);
                    System.out.println("Tarefa atualizada!");
                    break;
                case 5:
                    System.out.print("Digite o ID da tarefa a ser excluída: ");
                    Long idExcluir = scanner.nextLong();
                    tarefaService.excluirTarefa(idExcluir);
                    System.out.println("Tarefa excluída!");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
