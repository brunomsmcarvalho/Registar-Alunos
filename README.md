🎓 Sistema de Registro de Alunos

Um sistema web desenvolvido em Java com Spring Boot, Thymeleaf e Lombok, para o cadastro, listagem, edição e exclusão de alunos, com validações nos formulários e filtros de busca.

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot 3+

Spring Web

Spring Data JPA

Spring Validation

Thymeleaf (para renderização das páginas HTML)

Lombok (para reduzir boilerplate code)

H2 Database (banco de dados em memória)

Maven (gerenciador de dependências)

Bootstrap 5 (para o layout)

🧩 Funcionalidades

✅ Cadastro de alunos (nome, e-mail, matrícula, curso, data de nascimento, etc.)

✅ Validação de campos obrigatórios e formatos (e-mail válido, datas, etc.)

✅ Listagem de alunos cadastrados

✅ Edição e exclusão de alunos

✅ Filtro de busca por nome, curso ou matrícula

✅ Feedback de sucesso/erro nas operações

✅ Layout simples e responsivo com Bootstrap

🗃️ Estrutura do Projeto

<pre> ```text src/ └── main/ ├── java/com/exemplo/alunos/ │ ├── controller/ │ │ └── AlunoController.java │ ├── model/ │ │ └── Aluno.java │ ├── repository/ │ │ └── AlunoRepository.java │ ├── service/ │ │ └── AlunoService.java │ └── Application.java └── resources/ ├── templates/ │ ├── index.html │ ├── form.html │ └── listar.html ├── static/ │ └── css/ │ └── style.css └── application.properties ``` </pre>

⚙️ Configuração do Projeto

1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/sistema-alunos.git
cd sistema-alunos

2️⃣ Compilar e executar o projeto
mvn spring-boot:run

3️⃣ Acessar a aplicação

Abra o navegador e acesse:

http://localhost:8080

🧠 Exemplo de Entidade Aluno
@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "A matrícula é obrigatória")
    private String matricula;

    @NotBlank(message = "O curso é obrigatório")
    private String curso;

    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate dataNascimento;
}

🔍 Exemplo de Filtro (Busca)

No controlador:

@GetMapping("/alunos")
public String listar(@RequestParam(required = false) String nome, Model model) {
    List<Aluno> alunos;
    if (nome != null && !nome.isEmpty()) {
        alunos = alunoService.buscarPorNome(nome);
    } else {
        alunos = alunoService.listarTodos();
    }
    model.addAttribute("alunos", alunos);
    return "listar";
}

Acesse o browser em:
👉 http://localhost:8080

🧰 Dependências Principais (pom.xml)
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>

🧪 Testes

Execute os testes com:

mvn test

👨‍💻 Autor

Bruno, Anderson, Paulina, Cristiane
📧 brunomatoscarvalho@hotmail.com

🔗 [LinkedIn](https://www.linkedin.com/in/bruno-carvalho-a2062688/)

🐙 GitHub

📄 Licença

Este projeto é distribuído sob a licença MIT.
Consulte o arquivo LICENSE
 para mais detalhes.
