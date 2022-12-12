# App Previsão do tempo

#### Bem-Vindo! 👋

## Objetivo

Utilizar a interface JDBC para conexão com banco de dados MySQL.

## Visão Geral
A API Java DataBase Connectivity (JDBC) faz o meio de campo entre a aplicação Java e bancos de dados relacionais.
Cada banco de dados possui um driver específico, e sem o JDBC, haveria um alto acoplamento entre aplicação e banco de dados. 
Para evitar isso, a Sun Mycrosystems introduziu a API JDBC no JDK. Assim, com poucas configurações (como troca do driver e modificação de acessos) podemos substituir o banco de dados sem grandes dificuldades.

## O Projeto
O MySQL Workbench traz consigo um banco de dados modelo chamado WORLD, que possui dados de cidades e países (não oficiais) para uso.
Minha aplicação possui as seguintes camadas:

#### Model
Nesta camada, foram criadas os objetos que representam as entidades do banco. São elas:
 - Cidade;
 - Pais.
*Como a tabela possui diversas colunas, me reservei a usar apenas alguns.

#### DAO
O pattern DAO (Data Access Object) separa as regras de negócio da camada de persistência.
Os métodos responsáveis pelas operações com banco de dados ficam em uma classe DAO.
A classe DAO recebe algumas classes do pacote java.sql. No projeto fiz uso das seguintes classes:
 - Connection: atributo da classe, e seu valor é inicializado no construtor recebendo uma Connection quando a classe DAO for instanciada;
 - PreparedStatement: responsável por preparar a query e executá-la no banco de dados;
 - ResultSet: contém o resultado da execução do PreparedStatement, sendo usado para montar os objetos quando percorremos o ResultSet em um laço.

#### DB
Nesta camada, utilizei o pattern FACTORY para criar um pool de conexões com o banco de dados usando o driver C3P0 e a classe DataSource (javax.sql).
Aqui temos os dados de acesso ao banco de dados.
Criamos um DataSource no construtor da classe, e o método abrirConexao abre uma nova conexão para ser usada no construtor de um DAO que for chamado.

## Tecnologias

- Java JDK 17;
- Maven;
- JUnit;
- JDBC;
- MySQL.

## Autor

- GitHub - [André Cruz](https://github.com/andreldcm989)
- LinkedIn - [André Cruz](https://www.linkedin.com/in/andreldcruz/)
