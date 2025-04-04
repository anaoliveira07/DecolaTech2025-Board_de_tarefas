import java.util.List;
import java.util.Optional;

public class TarefaService {
    private TarefaDAO tarefaDAO;

    public TarefaService(TarefaDAO tarefaDAO) {
        this.tarefaDAO = tarefaDAO;
    }

    public Tarefa adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(null, descricao, false);
        return tarefaDAO.salvar(novaTarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaDAO.listar();
    }

    public Optional<Tarefa> atualizarTarefa(Long id, String descricao, boolean concluida) {
        Tarefa tarefaAtualizada = new Tarefa(id, descricao, concluida);
        return tarefaDAO.atualizar(id, tarefaAtualizada);
    }

    public boolean excluirTarefa(Long id) {
        return tarefaDAO.excluir(id);
    }

    public Optional<Tarefa> concluirTarefa(Long id) {
        Optional<Tarefa> tarefa = tarefaDAO.buscarPorId(id);
        tarefa.ifPresent(t -> t.setConcluida(true));
        return tarefa;
    }
}
