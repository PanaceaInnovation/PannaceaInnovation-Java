# HELENA - Sistema de Gerenciamento Acadêmico

HELENA é uma aplicação desenvolvida em Java para auxiliar alunos e professores no gerenciamento de atividades acadêmicas. A plataforma oferece funcionalidades como cadastro de usuários, visualização de boletins, revisão de testes, acompanhamento de rankings e suporte psicológico.

## Funcionalidades

### Para Alunos
- **Cadastro e Login**: Alunos podem se cadastrar e fazer login usando suas credenciais da instituição.
- **Visualização de Notas**: Acesso ao boletim com detalhes das notas por matéria.
- **Revisão de Testes**: Verificação do status das revisões solicitadas em testes.
- **Ranking**: Visualização do ranking acadêmico com base no desempenho.
- **Suporte Psicológico**: Acesso a psicólogos cadastrados para atendimento.

### Para Professores
- **Gerenciamento de Notas**: Professores podem visualizar as médias dos alunos por matéria.
- **Testes de Alunos**: Visualização e acompanhamento do desempenho dos alunos em testes.
- **Revisões**: Gestão das revisões de testes feitas pelos alunos.
- **Ranking de Alunos**: Acesso ao ranking acadêmico de todos os alunos.
- **Gerenciamento de Alunos**: Possibilidade de visualizar ou excluir alunos do sistema.
- **Suporte Psicológico**: Acesso aos serviços de psicologia disponíveis.

## Como Executar

1. Clone o repositório:
   git clone https://github.com/seu-usuario/helena.git
2. Compile e execute o projeto no seu ambiente de desenvolvimento Java.
3. O sistema iniciará com a tela inicial para cadastro ou login.

## Estrutura do Projeto

O projeto segue uma arquitetura baseada em controladores e modelos:

- **Controllers**: Gerenciam a lógica de negócios para cada funcionalidade (ex: `HelenaController`, `BoletimController`, etc.).
- **Models (DTOs)**: Representam as entidades do sistema, como `UsuarioDTO`.
- **DAO**: Camada responsável pela conexão e operações no banco de dados.

## Tecnologias Utilizadas

- **Java SE**: Linguagem principal de desenvolvimento.
- **Swing**: Interface gráfica para interação com o usuário.
- **JDBC**: Conexão e manipulação do banco de dados.
- **MySQL (ou outro banco)**: Banco de dados utilizado para persistência.
