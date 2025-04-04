import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaDAO {
    private List<Tarefa> tarefas = new ArrayList<>();
    private Long idCounter = 1L;

    public Tarefa salvar(Tarefa tarefa) {
        tarefa.setId(idCounter++);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Optional<Tarefa> atualizar(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaExistente = buscarPorId(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setConcluida(tarefaAtualizada.isConcluida());
            return Optional.of(tarefa);
        }
        return Optional.empty();
    }

    public boolean excluir(Long id) {
        return tarefas.removeIf(t -> t.getId().equals(id));
    }
}
