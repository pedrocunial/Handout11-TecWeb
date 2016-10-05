# Entrega semanal para diciplina de Tecnologias Web do 4º semestre de engenharia da computação no Insper.

### REQUERIMENTOS:

* Java 8

* Tomcat 8

* MariaDB / MySQL

**Nota**: *O projeto foi feito utilizando o Eclipse JEE Neon. Não me responsabilizo por tentativas frustradas de utilização em condições diferentes.*

### SETUP:

* No console do MariaDB/MySQL crie dentro da sua base de dados escolhida crie a tabela com o seguinte comando:
```sql
CREATE TABLE Pessoas (
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(32) NOT NULL,
altura DECIMAL (2, 1),
nascimento DATE,
passaporte VARCHAR(60),
PRIMARY KEY (id) );
```

#### Modifique as variáveis da base de dados no arquivo DAO.java para que condizam com as do seu sistema!

#### Rode o projeto!
  - Adicione novas pessoas!

    http://localhost:8080/\<nome do projeto>/cria.jsp

    ou

    http://localhost:8080/\<nome do projeto>/cria *(versão anterior)*

  - Modifique usuários já existentes!
    
    http://localhost:8080/\<nome do projeto>/atualiza.jsp
  
    ou
  
    http://localhost:8080/\<nome do projeto>/atualiza *(versão anterior)*

  - Remova usuários que não condizem com a maneira com que você vê o mundo!
    
    http://localhost:8080/\<nome do projeto>/remove.jsp
    
    ou
  
    http://localhost:8080/\<nome do projeto>/remove *(versão anterior)*

  - Veja a maravilhosa tabela de usuários que você criou!
    
    http://localhost:8080/\<nome do projeto>/tabela.jsp
    
    ou
  
    http://localhost:8080/\<nome do projeto>/lista *(versão inferior... quero dizer, anterior)*
