# 📊 Relatório de Complexidade e Estruturas de Dados

  

Este projeto tem como objetivo analisar e comparar o desempenho de diferentes estruturas de dados e algoritmos de ordenação. O sistema implementa manipulação de vetores, Árvores Binárias de Busca e Árvores AVL, permitindo verificar o comportamento computacional (complexidade) em diferentes cenários.

## 🗂 Estrutura do Projeto

O código foi organizado seguindo boas práticas de **Orientação a Objetos**, com separação clara de responsabilidades em pacotes distintos.

```bash
relatorio-complexidade/
│
├── Main.java                 # Ponto de entrada (Entry Point) da aplicação
├── Sorts.java                # Implementação de algoritmos de ordenação
│
├── array/                    # Módulo de manipulação de Vetores
│   ├── Array.java            # Lógica e operações sobre arrays
│
├── arvoreAVL/                # Módulo da Árvore AVL (Balanceada)
│   ├── Tree.java             # Lógica da Árvore AVL (rotações, inserção)
│   ├── Sheet.java            # Representação do Nó/Folha da AVL
│
└── arvoreBinaria/            # Módulo da Árvore Binária de Busca (BST)
    ├── TreeBinary.java       # Lógica da Árvore Binária
    ├── SheetBinary.java      # Representação do Nó/Folha da Binária
```

## 🚀 Como Executar

### Opção 1: Via Linha de Comando (Terminal)

Certifique-se de estar na pasta **pai** do diretório `relatorio-complexidade`.

1.  **Compilar:**
    ```bash
    javac relatorio-complexidade/Main.java
    ```
2.  **Executar:**
    ```bash
    java relatorio-complexidade.Main
    ```

-----

### Opção 2: Utilizando o jGRASP 🐞

O jGRASP é ideal para este projeto, pois permite visualizar graficamente a montagem das árvores e arrays.

#### 1\. Abrindo o Projeto

1.  Abra o **jGRASP**.
2.  Vá em **File** \> **Open**.
3.  Navegue até a pasta `relatorio-complexidade` e selecione o arquivo `Main.java`.

#### 2\. Compilando e Executando

1.  Certifique-se de que o arquivo `Main.java` está aberto na janela de código.
2.  Clique no botão **Compile** (ícone de **+** verde) na barra de ferramentas.
      * *Aguarde a mensagem "Operation Complete" no console inferior.*
3.  Clique no botão **Run** (ícone do **bonequinho vermelho** correndo).

#### 💡 Dica Pro: Visualizando as Estruturas (Debug Mode)

Para ver suas Árvores e Arrays sendo montados graficamente:

1.  Clique no botão **Debug** (ícone da joaninha 🐞) ao invés do Run.
2.  Avance o código passo a passo usando o botão **Step** (seta para baixo).
3.  Abra a aba **Canvas** (lateral esquerda ou topo).
4.  Arraste as variáveis das suas árvores (`Tree`, `TreeBinary`) da lista de variáveis para a janela preta do Canvas. O jGRASP desenhará a estrutura de nós e ponteiros automaticamente\!

-----

## 🛠 Detalhes da Implementação

### 🔹 Estruturas de Dados

  * **Array:** Implementação de operações em listas lineares.
  * **Árvore Binária (BST):** Estrutura hierárquica sem balanceamento automático. Ideal para testes de pior caso ($O(n)$).
  * **Árvore AVL:** Árvore binária de busca auto-balanceada. Garante complexidade logarítmica ($O(\log n)$) para buscas e inserções através de rotações.

### 🔹 Algoritmos (`Sorts.java`)

A classe `Sorts` atua como uma biblioteca utilitária contendo métodos de ordenação para preparar os dados antes da inserção nas estruturas ou para medição de tempo de ordenação.

## 📝 Qualidade de Código e Documentação

O projeto foi desenvolvido prezando pela legibilidade e manutenção:

  * **Nomenclatura Semântica:** Variáveis e métodos possuem nomes descritivos (ex: `TreeBinary`, `Sheet`) que indicam claramente sua função.
  * **Modularização:** Cada estrutura de dados reside em seu próprio pacote (`package`), evitando conflitos de nomes.
  * **Orientação a Objetos:** Uso de classes para encapsular a lógica de cada estrutura.

## ✒️ Autor

Desenvolvido por **Thiago Ferreira Gonçalves**.
*Estudante de Análise e Desenvolvimento de Sistemas.*
