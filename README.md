# escola-api

## Descrição do Projeto
O Escola-App é uma API REST desenvolvida com Spring Boot para servir como backend de uma aplicação de gerenciamento de tarefas escolares, registros de notas e comunicados entre Escola e Pai. Ele oferece recursos para manipulação de usuários, agenda, boletim e envio de comunicados para os responsáveis dos alunos, proporcionando uma interface para interação com o banco de dados MySQL.

## Configuração do Ambiente

### Requisitos
Certifique-se de ter as seguintes dependências instaladas em seu ambiente de desenvolvimento:

* [Java 11+](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [MySQL](https://dev.mysql.com/downloads/installer/)

* ### Instalação
1. Clone o repositório:
```
[git clone https://github.com/Cayton-Benicio/escola-api.git]
```
2. No terminal, navegue até o diretório do projeto:
```
cd escola=api
```
3. Configure o banco de dados:
Certifique-se de que um servidor MySQL esteja em execução e crie um banco de dados chamado "taskify".
```
CREATE DATABASE Escola-Api;
```
4. Configure as propriedades do banco de dados:
Se for o caso, edite o arquivo `src/main/resources/application.properties` e ajuste as configurações de conexão com o servidor MySQL:
```
spring.datasource.url=jdbc:mysql://localhost:3306/escola
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```
5. Execute a aplicação:
```
mvn spring-boot:run
```
O servidor estará acessível em `http://localhost:8080` por padrão.

## Estrutura do Projeto
O projeto é estruturado da seguinte forma:
* `com.escola.api.constants`: Constantes utilizadas na aplicação.
* `com.escola.api.controller`: Controladores para manipular as requisições HTTP.
* `com.escola.api.model`: Modelos de dados para representar Usuários, Alunos, Professores, Disciplinas, Coordenação, Responsáveis, Turma, Comunicado, Agenda e Boletim.
* `com.escola.api.repository`: Repositórios para interação com o banco de dados.
* `com.escola.api.dto`: Dto utilizado na nos métodos que precisam de umavariável do tipo Double informados no corpo Json.
* `com.escola.api.service`: Service para criar os métodos que serão chamados no Controller.

## Uso da API
A API possui os seguintes endpoints:

### Aluno:
*`POST /aluno`: Cria um novo aluno.
* `GET /aluno`: Lista todos os alunos.
* `GET /aluno/{id}`: Obtém informações de um aluno específico.
* `PUT /aluno/{id}`: Atualiza as informações de um aluno.
* `DELETE /aluno/{id}`: Exclui um aluno.

### Professor:
*`POST /professor`: Cria um novo professor.
* `GET /professor`: Lista todos os professores.
* `GET /professor/{id}`: Obtém informações de um professor específico.
* `PUT /professor/{id}`: Atualiza as informações de um pofessor.
* `DELETE /professor/{id}`: Exclui um pofessor.

### Responsável:
*`POST /resposável`: Cria um novo respnsável.
* `GET /resonsável`: Lista todos os resonsáveis.
* `GET /responsável/{id}`: Obtém informações de um repsonsável específico.
* `PUT /resonsável/{id}`: Atualiza as informações de um respnsável.
* `DELETE /resonsável/{id}`: Exclui um responsável.

### Coordenação:
*`POST /coordenacao`: Cria um novo coordenador.
* `GET /coordenacao`: Lista todos os coordenadores.
* `GET /coordenacao/{id}`: Obtém informações de um coordenador específico.
* `PUT /coordenacao/{id}`: Atualiza as informações de um coordenador.
* `DELETE /coordenacao/{id}`: Exclui um coordenador.

### Disciplina:
*`POST /disciplina`: Cria uma nova disciplina.
* `GET /disciplina`: Lista todas as disciplinas.
* `GET /disciplina/{id}`: Obtém informações de uma disciplina específica.
* `PUT /disciplina/{id}`: Atualiza as informações de uma discipina.
* `DELETE /disciplina/{id}`: Exclui uma disciplina.

### Turma:
*`POST /turma`: Cria uma nova turma.
* `GET /turma`: Lista todas as turmas.
* `GET /turma/{id}`: Obtém informações de uma turma específica.
* `PUT /turma/{id}`: Atualiza as informações de uma turma.
* `DELETE /turma/{id}`: Exclui uma turma.

### Agenda:
*`POST /agenda`: Cria uma nova agenda (atividade).
* `GET /agenta`: Lista todas as agendas (atividade).
* `GET /agenda/{id}`: Obtém informações de uma agenda (atividade) espcífica.
* `PUT /agenda/{id}`: Atualiza as informações de uma agenda (atividade).
* `DELETE /agenda/{id}`: Exclui uma agenda (atividade).

### Comunicado:
*`POST /comunicado`: Cria um novo comunicado.
* `GET /comunicado`: Lista todos os comunicados.
* `GET /comunicado/{id}`: Obtém informações de um comunicado específico.
* `PUT /comunicado/{id}`: Atualiza as informações de um comunicado.
* `DELETE /comunicado/{id}`: Exclui um comunicado.

### boletim:
*`POST /boletim`: Cria um novo boletim.
*`POST /boletim/calcularMedia/{id}`: Calcula a media de duas notas.
* `GET /boletim`: Lista todos os boletins.
* `GET /boletim/{id}`: Obtém informações de um boletim específico.
* `PUT /boletim/{id}`: Atualiza as informações de um boletim.
* `DELETE /boletim/{id}`: Exclui um boletim.

## Chamando os Endpoints via Postman
Após iniciar a aplicação, você pode acessar em seu navegador a documentação interativa da API por meio do [Postman](http://localhost:8080/swagger-ui.html). Lá, você encontrará uma interface fácil de usar para explorar e testar os endpoints da API.




