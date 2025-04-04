# Board de Tarefas - Java

Este é um projeto simples de um **Board de Tarefas** desenvolvido em **Java**. O objetivo do projeto é gerenciar tarefas, permitindo adicionar, listar, atualizar, concluir e excluir tarefas, utilizando uma estrutura simples de camadas: **Camada de Dados (DAO)**, **Camada de Serviços** e **Camada de UI (Interface do Usuário)**.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

- **Tarefa.java**: Define a entidade **Tarefa**, com atributos como `id`, `descricao` e `concluida`.
- **TarefaDAO.java**: Camada responsável pelo acesso a dados, realizando operações como salvar, listar, atualizar e excluir tarefas.
- **TarefaService.java**: Camada de serviços, que contém a lógica de negócios, como adicionar, atualizar, listar, excluir e concluir tarefas.
- **Main.java**: Classe responsável pela interface com o usuário, permitindo a interação com o sistema através de um menu simples de opções.
