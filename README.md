# 2023/2 - Projeto de Sistemas de Software - Trabalho Final 

---
## Alunos

Artur Matos Siqueira - 2021200505

Guilherme Diniz Láu - 2021200797

---

# Gestao de Usuarios

## INTRODUÇÃO
O trabalho consistiu no desenvolvimento de um sistema para a gestão de usuários, com funcionalidades como, cadastro, edição e envio de notificações. 

Para o desenvolvimento do mesmo, utilizamos dos padrões abordados em sala de aula para a criação de uma aplicação mais robusta e com maior manutenibilidade.

Para ter o projeto em seu ambiente local, basta executar o seguinte comando:
```
git clone https://github.com/artursiqueira/Gestao-Usuarios.git
```

## REQUISITOS IMPLEMENTADOS

### REQUISITOS FUNCIONAIS

#### _RF01 - Cadastro de Administrador:_
O primeiro usuário se cadastra e se torna o administrador do sistema, habilitado para cadastrar outros usuários.

#### _RF02 - Autorização de Acesso:_
Usuários não cadastrados precisam de autorização do administrador para acessar o sistema após o cadastro.

#### _RF03 - Autenticação de Usuários:_
Todos os usuários devem autenticar-se no sistema por meio de nome de usuário e senha.

#### _RF04 - Envio de Mensagens/Notificações:_
Administradores podem enviar mensagens ou notificações para um ou mais usuários cadastrados.

#### _RF05 - Visualização de Notificações:_
Usuários devem ter a capacidade de visualizar notificações no sistema e marcar como "lidas".

#### _RF06 - Informações de Usuários:_
O administrador deve visualizar, ao listar usuários, além do nome e data de cadastro, o número de notificações enviadas e lidas.

#### _RF07 - Alteração de Senha:_
Cada usuário pode alterar sua senha a qualquer momento, desde que autenticado.

#### _RF08 - Registro em Arquivo (Log de Sistema):_
O sistema deve registrar operações específicas em um arquivo de log, incluindo inclusão, alteração ou exclusão de usuários, envio e leitura de notificações, alteração de senha e autorização de usuário.

### REQUISITOS NÃO FUNCIONAIS

#### _RNF01 – Casos de uso do tipo CRUD com State_
Os casos de uso do tipo CRUD devem seguir o que foi ministrado e debatido em aula, utilizando o padrão de navegação entre janelas disponível em https://whimsical.com/crud-manter-HcNY9D491ajiNZ7j8EA7Y9

#### _RNF02 – Persistência de dados_
Utilize como persistência qualquer banco de dados, relacional ou não, que não exija instalações ou configurações extras no ambiente de implementação. Prefira utilizar o SQLite. Não utilizar o Docker para manter o banco de dados.

#### _RNF03 – Padrão de projeto DAO_
Utilize o padrão de projeto DAO, sabendo que não é permitido utilizar Framework de persistência como  Hibernate ou similares.

#### _RNF04 – Interface gráfica_
O sistema deve ser desenvolvido utilizando o kit de componentes gráficos do Java Swing.
O sistema deve permitir que usuários naveguem entre telas que estejam abertas para realizar as funções desejadas. Ou seja, utilizar o MDI (Multiple Document Interface). Um exemplo de sistema com o padrão MDI é apresentado na figura abaixo. A barra de botões é opcional.

#### _RNF05 – Utilizar o padrão de projeto Command_
Ao utilizar o State, utilizar o padrão Command integrado à ele.

#### _RNF06 – Padrão de projeto Observer_
Implemente o padrão Observer de modo que caso qualquer usuário altere algum dado em uma janela aberta, as demais janelas abertas referentes àquele dado sejam atualizadas.

#### _RNF07 – Formatos de arquivos de Log_
O sistema deve permitir os seguintes formatos para arquivos de log: CSV (com separação de campos usando ponto e vírgula “;”), JSON.

#### _RNF08 – Padrão de Projeto Adapter para Log_
O módulo de log deve adotar o padrão de projeto Adapter. Além disso, deve ser um projeto Maven independente, utilizado pelo sistema proposto nesta especificação.

#### _RNF09 – Criação de senhas_
Ao criar senhas do sistema utilizar adaptar o Validador de senhas disponível em https://github.com/claytonfraga/validadorsenha, que deve ser incluído como JAR no projeto Maven, utilizando o JitPack (https://jitpack.io/)
