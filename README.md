Entrega semanal para diciplina de Tecnologias Web do 4º semestre de engenharia da computação no Insper.

REQUERIMENTOS:

* Java 8

* Tomcat 8

* MariaDB / MySQL

SETUP:

* No console do MariaDB/MySQL crie dentro da sua base de dados escolhida crie a tabela com o seguinte comando:
    ```
    create table Pessoas (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(32) NOT NULL,
    altura DECIMAL (2, 1),
    nascimento DATE,
    PRIMARY KEY (id) );
    ```

* Modifique as variáveis da base de dados no arquivo DAO.java para que condizam com as do seu sistema

* Rode o projeto!
  - Adicione novas pessoas!
    localhost:8080/\<nome do projeto>/cria

  - Modifique usuários já existentes!
    localhost:8080/\<nome do projeto>/atualiza

  - Remova usuários que não condizem com a maneira com que você vê o mundo!
    localhost:8080/\<nome do projeto>/remove

  - Veja a maravilhosa tabela de usuários que você criou!
    localhost:8080/\<nome do projeto>/lista