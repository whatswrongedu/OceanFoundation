# 🌊 Ocean Foundation
> **Gestão Escolar Inteligente e Segura com Spring Boot**

![Status do Projeto](https://img.shields.io/badge/Status-Concluído-success) ![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Security](https://img.shields.io/badge/Spring-Security-green)

## 💡 A Proposta

O **Ocean Foundation** não é apenas um sistema de gestão; é uma solução desenvolvida para modernizar a interação entre o corpo docente e os alunos.

O objetivo principal deste projeto foi criar uma arquitetura segura e escalável para resolver dores comuns do ambiente acadêmico: **o controle de frequência e a centralização de comunicados.**

---

## 📸 O Projeto em Ação


### Principais Recursos
| Perfil | Funcionalidades Exclusivas |
| :--- | :--- |
| **👨‍🎓 Aluno** | Acesso ao dashboard pessoal, visualização de faltas em tempo real, envio de justificativas e consulta ao mural de avisos. |
| **👩‍🏫 Professor** | Painel administrativo para gestão de turma, lançamento e abono de faltas, criação e exclusão de avisos importantes. |

---

## 🧠 Arquitetura e Segurança

Um dos grandes diferenciais deste projeto é a implementação de segurança e boas práticas de desenvolvimento Back-End.

### 🔐 Segurança com Spring Security
A autenticação não é apenas um login simples. O sistema implementa **RBAC (Role-Based Access Control)**, garantindo que usuários tenham permissões estritas baseadas em seus papéis:
* Implementação da interface `UserDetailsService` para autenticação customizada.
* Criptografia de senhas utilizando **BCrypt** no momento do cadastro.
* Proteção de rotas: Um aluno jamais acessa a área de um professor e vice-versa.

### 🏛️ Padrão MVC e Organização
O código segue o padrão **Model-View-Controller**, garantindo uma separação clara de responsabilidades:
* **Services:** Regras de negócio isoladas (ex: lógica de abono de faltas).
* **Repositories:** Abstração completa do acesso a dados com JPA.
* **Controllers:** Gerenciamento de rotas limpo e intuitivo.

---

## 🛠️ Stack Tecnológica

Este projeto foi construído utilizando o ecossistema moderno do Java:

* **Core:** Java 17 & Spring Boot 4
* **Segurança:** Spring Security
* **Dados:** MySQL & Spring Data JPA
* **Front-End:** Thymeleaf & Tailwind (Server-Side Rendering)
* **Ferramentas:** Maven, Docker

---

## 🚀 Como testar localmente

Se você deseja explorar o código ou rodar a aplicação em sua máquina:

1. **Clone este repositório**
   ```bash
   git clone [https://github.com/seu-usuario/ocean-foundation.git](https://github.com/seu-usuario/ocean-foundation.git)
