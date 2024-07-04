![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

## Steps to Setup

### 1. Clone the repository

> git clone https://github.com/BrenoCidade/TrilhaBackEndJR-JUN15

### 2. Start the application via Maven package or Start it using Spring Boot Application as default:
 `TrilhaBackEndJR-JUN15/project/src/main/java/com/trilhabackendjr/project/ProjectApplication.java`

### 3. The App will start running at http://localhost:8080/

___

## Explore HTTP Methods:

| Http Methods(auth)      | URL                                                 |
| ----------------------- | --------------------------------------------------- |
| POST                    | http://localhost:8080/auth/login                    |
| POST                    | http://localhost:8080/auth/register                 |

| Http Methods(tasks)    | URL                                                  |
| ----------------------- | --------------------------------------------------- |
| GET                     | http://localhost:8080/tasks                         |
| GET({taskId})           | http://localhost:8080/tasks/{taskId}                |
| POST                    | http://localhost:8080/tasks                         |
| PUT                     | http://localhost:8080/tasks/{taskId}                |
| DELETE                  | http://localhost:8080/tasks/{taskId}                |

You can use them using a REST client such as Apidog, Postman, Insomnia, etc.

Be careful to use the correct Id and remove the `{taskId}`. For example: 
> Put - http://localhost:8080/tasks/1

## How use Http Methods(auth):

`POST` : http://localhost:8080/auth/register

Creating one user within the Database.

Body Return:

```Json
{
    "username": "teste",
    "password": "12345"
}
```
___

`POST` : http://localhost:8080/auth/login 

Login.

Body: 

```Json
{
    "username": "brenocidade",
    "password": "12345"
}
```
___

## How use Http Methods(tasks):

`GET` : http://localhost:8080/tasks/  

Getting all tasks from the Database.

Body Return:

```Json
[
    {
        "taskId": 1,
        "nameTask": "Task 1",
        "description": "OIE galera",
        "creationTimestamp": "2024-07-04T18:08:16.357Z"
    },
    {
        "taskId": 2,
        "nameTask": "Task 2",
        "description": "OIE galera2",
        "creationTimestamp": "2024-07-04T18:08:17.300Z"
    },
    {
        "taskId": 3,
        "nameTask": "Task 3",
        "description": "OIE galera3",
        "creationTimestamp": "2024-07-04T18:08:19.141Z"
    },
    {
        "taskId": 4,
        "nameTask": "Task 4",
        "description": "OIE galera4"
        "creationTimestamp": "2024-07-04T18:08:19.990Z"
    }
]
```
___

`GET` : http://localhost:8080/tasks/1  

Getting task by id from the Database.

Body Return:

```Json
[
    {
        "taskId": 1,
        "nameTask": "Task 1",
        "description": "OIE galera",
        "creationTimestamp": "2024-07-04T18:08:16.357Z"
    }
]
```
___

`POST` : http://localhost:8080/tasks/   

Creating one task within the Database.

Body: 

```Json
{
    "description": "OIE galera1",
    "nameTask": "Task 1"
}
```
___

`PUT/{taskId}` : http://localhost:8080/tasks/1

Updating a task by Id.

Body: 

```Json
{
    "description": "OIE teste",
    "nameTask": "Task 2567"
}
```
___

`DELETE/{taskId}` : http://localhost:8080/tasks/1

Delete a task by Id.

Body: 

```Json

```
___



# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

## Objetivos:
- Criar uma API que permita CRUD (Create, Read, Update, Delete) de tarefas.
- Implementar autenticação de usuários.
- Utilizar um banco de dados SQLite para armazenar as tarefas.
- Documentar todo o processo e apresentar as conclusões.

## Requisitos Funcionais:
- Criar Tarefa: Endpoint para criar uma nova tarefa.
- Listar Tarefas: Endpoint para listar todas as tarefas.
- Atualizar Tarefa: Endpoint para atualizar uma tarefa existente.
- Deletar Tarefa: Endpoint para deletar uma tarefa existente.

## Autenticação de Usuários:
- Registro de Usuário: Endpoint para registrar um novo usuário.
- Login de Usuário: Endpoint para autenticar um usuário e gerar um token JWT.
- Proteção de Rotas: Garantir que apenas usuários autenticados possam acessar os endpoints de tarefas.

## Banco de Dados:
- Utilizar SQLite como banco de dados para armazenar informações de usuários e tarefas.

   #### Estrutura do Projeto:
   ```plaintext
   project-root/
   │
   ├── src/
   │   ├── controllers/
   │   ├── models/
   │   ├── routes/
   │   ├── middlewares/
   │   ├── database/
   │   └── app.js
   │
   ├── .env
   ├── .gitignore
   ├── README.md
   └── package.json
   ```
## Entregáveis:
   1. **Código Fonte:**
      - Código fonte do projeto, organizado conforme a estrutura acima.
   2. **Repositório GitHub:**
      - Repositório público contendo o código fonte e documentação.
   3. **Documentação:**
      - README.md com instruções sobre como configurar e executar o projeto, além de detalhes dos endpoints da API.

### Detalhes Técnicos: 🔧
- **Boas Práticas:** Utilizar boas práticas de código limpo, legível e bem documentado.
- **Git:** Utilizar Git para controle de versão e submeter o projeto através de um repositório público no GitHub.

### Dicas para Abordar o Projeto 🌟
- **Crie um Fork desse Repositório.**
- **Criar do Zero:** É fundamental que o projeto seja desenvolvido completamente do zero, demonstrando suas habilidades e criatividade desde o início.
- **Utilize bibliotecas** como Express para criação da API e jsonwebtoken para autenticação.
- **Documente cada etapa do processo para facilitar a compreensão.**

### Critérios de Avaliação: 📝
- **Funcionalidade:** A aplicação atende aos requisitos funcionais e funciona corretamente?
- **Qualidade do Código:** O código é limpo, bem estruturado e adequadamente documentado?
- **Segurança:** A autenticação foi implementada corretamente e as rotas estão protegidas?
- **Uso do Git:** O controle de versão é usado de forma eficaz com mensagens de commit significativas?
- **Documentação:** A documentação é clara e detalha o processo de desenvolvimento e uso da API?

### Não Queremos 🚫
- Descobrir que o candidato não foi quem realizou o teste.
- Ver commits grandes sem muita explicação nas mensagens no repositório.
- Entregas padrão ou cópias de outros projetos. Buscamos originalidade e autenticidade em cada contribuição.

### Prazo ⏳
A data máxima para entrega das trilhas foi removida, permitindo que as pessoas entreguem conforme sua disponibilidade. No entanto, ainda é necessário concluir a trilha com sucesso para ser inserido em uma equipe.

### Instruções de Entrega: 📬
Após finalizar o projeto, publique-o em uma URL pública (por exemplo, Vercel, Netlify, GitHub Pages, etc.) e hospede o seu servidor na nuvem. Use serviços que ofereçam uso gratiuto por um período, como a AWS e preencha o [Formulário](https://forms.gle/gZViPMTSDV5nidSu6):  

---

### Desafio da Inovação 🚀
Achou esse projeto inicial simples? Eleve ainda mais! Estamos em busca de mentes inovadoras que não apenas criem, mas que também desafiem os padrões. Como você pode transformar essa estrutura inicial em algo verdadeiramente extraordinário? Demonstre o poder da sua criatividade e o impacto das suas ideias inovadoras!

---

🔗 **Mantenha-se Conectado:**
- [Discord](https://discord.gg/wzA9FGZHNv)
- [Website](http://www.codigocertocoders.com.br/)
- [LinkedIn](https://www.linkedin.com/company/codigocerto/)
  
🌐 **Contato:**
- Email: codigocertocoders@gmail.com

---

### Precisa de Ajuda?
Está com alguma dificuldade, encontrou algum problema no desafio ou tem alguma sugestão pra gente? Crie uma issue e descreva o que achar necessário.

**Construindo o amanhã, hoje.**
