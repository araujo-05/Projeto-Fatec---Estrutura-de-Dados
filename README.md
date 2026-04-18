# 📚 Sistema de Central de Atendimento com Prioridade

## 📌 Descrição
Este projeto foi desenvolvido como parte da disciplina de **Estrutura de Dados**, com o objetivo de simular o funcionamento de uma central de atendimento.

O sistema gerencia processos (atendimentos) utilizando **pilhas com níveis de prioridade**, permitindo organizar, atender e até desfazer atendimentos realizados.

---

## 🎯 Objetivo
- Implementar estruturas de dados na prática
- Simular um sistema real de atendimento com prioridades
- Trabalhar com conceitos como pilhas, tratamento de exceções e organização de dados
- Aplicar lógica de controle com menus interativos

---

## ⚙️ Funcionamento do Sistema
O sistema permite ao usuário:

1. **Abrir um processo**
   - Informando nome, tipo e prioridade (1 a 3)
   - A prioridade define a ordem de atendimento

2. **Atender próximo processo**
   - Sempre atende primeiro os processos mais urgentes

3. **Desfazer último atendimento**
   - Permite retornar um processo atendido para a fila de pendentes

4. **Listar processos pendentes**

5. **Listar histórico de atendimentos**

---

## 🧱 Estruturas de Dados Utilizadas

### 🔹 Pilha (Stack)
Utilizada para armazenar:
- Processos pendentes
- Histórico de atendimentos

### 🔹 Pilha com Prioridade
A classe `PilhaPrioridade` organiza os dados em três pilhas:

- Prioridade 3 → **Urgente**
- Prioridade 2 → **Normal**
- Prioridade 1 → **Baixa**

Ordem de atendimento:
```
Urgente → Normal → Baixa
```

### 🔹 Vetor Dinâmico
Utilizado internamente para armazenar os elementos da pilha (`PilhaProcesso`).

---

## 🗂️ Estrutura do Projeto
```
/projeto
 ├── Main.java
 ├── CentralAtendimento.java
 ├── PilhaPrioridade.java
 ├── PilhaProcesso.java
 ├── VetorDinamico.java
 ├── Processo.java
 └── PilhaVaziaException.java
```

---

## 💻 Tecnologias Utilizadas
- Linguagem: **Java**
- Paradigma: **Orientação a Objetos**
- Execução: **Terminal (console)**

---

## ▶️ Como Executar

1. Compile os arquivos:
```bash
javac *.java
```

2. Execute o programa:
```bash
java Main
```

---

## 🧠 Conceitos Aplicados
- Estrutura de dados: Pilhas
- Pilhas com múltiplas prioridades
- Encapsulamento e organização de classes
- Tratamento de exceções (`try/catch`)
- Entrada de dados com `Scanner`
- Manipulação de data e hora

---

## ⚠️ Tratamento de Erros
O sistema trata erros como:
- Entrada inválida do usuário
- Tentativa de atender sem processos disponíveis
- Tentativa de desfazer sem histórico

---

## 📌 Exemplo de Uso
```
1-Abrir  2-Atender  3-Desfazer  4-Pendentes  5-Historico  0-Sair
Opção: 1

Nome: João
Tipo: Suporte
Prioridade: 3

Processo aberto!
```

---

## 👨‍🎓 Autores
- Abraão Castro de Araújo | `RA:` 1430482423054
- Eduardo Alves Dos Santos | `RA:` 1430482511004
- Kaique Miranda Santos | `RA:` 1430482513035
- Angelo Ribeiro Rodrigues dos Santos | `RA:` 1430642327026
- Matheus Sebrian de Souza| `RA: ` 1430482511008
---

## 🏫 Disciplina
- Estrutura de Dados

---

