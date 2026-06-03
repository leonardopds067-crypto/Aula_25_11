# Instruções de Teste e Uso — Aula 1

## Como compilar e executar

```bash
cd /home/codespace/Aula_25_11/Sistema_de_Vendas_e_Controle_de_estoque
javac main.java
java Main
```

## Teste Manual Sugerido

### 1. Cadastre alguns produtos

No menu principal, escolha **1 (Produtos)** → **1 (Cadastrar produto)**

Exemplo de produtos:
```
Código: P001
Nome: Notebook Dell
Preço: 2500.50 (ou 2500,50)
Estoque: 10

---

Código: P002
Nome: Mouse Wireless
Preço: 150
Estoque: 25

---

Código: P003
Nome: Teclado Mecânico
Preço: 350.99
Estoque: 5
```

### 2. Liste os produtos

Escolha **2 (Listar produtos)** e veja todos cadastrados com numeração.

**Saída esperada:**
```
== Lista de Produtos ==
1. [P001] Notebook Dell - R$ 2500.50 - Estoque: 10
2. [P002] Mouse Wireless - R$ 150.00 - Estoque: 25
3. [P003] Teclado Mecânico - R$ 350.99 - Estoque: 5
```

### 3. Busque por nome ou código

Escolha **3 (Buscar produto)** e teste:
- Buscar por código: `P001`
- Buscar por nome: `mouse` (case-insensitive)
- Buscar parcial: `not` (encontra Notebook)

### 4. Atualize estoque

Escolha **4 (Atualizar estoque)**
```
Código do produto: P001
Novo quantidade em estoque: 15
```

### 5. Remova um produto

Escolha **5 (Remover produto)**
```
Código do produto: P003
Tem certeza de remover "Teclado Mecânico"? (s/n): s
```

## Teste Automatizado

Um arquivo `test_input.txt` foi criado com entradas pré-definidas:

```bash
java Main < test_input.txt
```

Este teste realiza:
1. Cadastra 2 produtos (Notebook e Mouse)
2. Lista produtos
3. Busca por termo
4. Atualiza estoque
5. Retorna ao menu principal

## Validações Testadas

✅ Código duplicado (rejeita)
✅ Preço negativo (rejeita)
✅ Estoque negativo (rejeita)
✅ Campo vazio (rejeita)
✅ Entrada inválida (retry automático)
✅ Busca case-insensitive
✅ Busca parcial (substring)
✅ Confirmação antes de remover

## Estrutura de Classes

```
Main (ponto de entrada)
    ↓
Sistema (gerenciador)
    ├── List<Produto>
    ├── List<Cliente>
    └── List<Venda>
        ├── Produto
        ├── Cliente
        ├── ItemVenda
        └── Venda
```

## Próximas Funcionalidades (Aula 2+)

- [ ] Menu de Clientes com CRUD completo
- [ ] Fluxo de Vendas (adicionar itens, calcular total)
- [ ] Validação de estoque (não permitir venda sem estoque)
- [ ] Histórico de vendas por cliente
- [ ] Relatórios

---

**Versão:** Aula 1  
**Status:** ✅ Totalmente funcional
