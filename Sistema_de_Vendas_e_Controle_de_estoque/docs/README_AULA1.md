# Sistema de Vendas e Controle de Estoque — Aula 1

Resumo das alterações, construção e melhorias do código

## Objetivo desta aula
Criar a estrutura base do sistema com classes principais, implementar o menu principal no console, e disponibilizar funcionalidades completas de gestão de produtos (cadastrar, listar, buscar, atualizar estoque, remover).

## Arquitetura e classes

### `Main`
- Ponto de entrada que cria e executa o `Sistema`.

### `Sistema`
- Classe que contém coleções em memória (`produtos`, `clientes`, `vendas`) e o menu de navegação.

**Métodos principais:**
- `run()` — loop principal do menu com navegação entre módulos.
- `menuProdutos()` — submenu de produtos com todas as 5 operações.
- `cadastrarProduto()` — cadastra produto com validações (código único, preço >= 0, estoque >= 0).
- `listarProdutos()` — mostra produtos com numeração para fácil visualização.
- `buscarProduto()` — busca por código ou nome (case-insensitive, busca parcial).
- `atualizarEstoque()` — altera estoque de um produto existente.
- `removerProduto()` — remove produto com confirmação do usuário.
- `findProdutoByCodigo(String)` — busca interna por código (evita duplicatas).
- `readDouble(String)` / `readInt(String)` — helpers de leitura com loop de retry em caso de erro.
- `validarCPF(String)` — validação básica de CPF (apenas dígitos, 11 chars).

### `Produto`
- **Atributos:** `codigo` (único), `nome`, `preco`, `estoque`.
- **Métodos:** Construtor, getters, setters e `toString()` formatado.
- **Regra:** Código deve ser único e estoque não pode ser negativo.

### `Cliente`
- **Atributos:** `nome`, `cpf`.
- **Métodos:** Construtor, getters, setters e `toString()` formatado como `[CPF] Nome`.
- **Status:** Estrutura pronta para CRUD futuro.

### `ItemVenda`
- **Associação:** Produto + quantidade.
- **Métodos:** `getSubtotal()` calcula preço × quantidade.
- **Exibição:** `toString()` formatado para listagem clara.

### `Venda`
- **Atributos:** `UUID id`, `Cliente cliente`, lista de `ItemVenda`, `total`, `data`.
- **Métodos:** 
  - `adicionarItem()` — adiciona item e recalcula total.
  - `recalcTotal()` — recalcula total ao modificar itens.
  - Getters: `getId()`, `getCliente()`, `getItens()`, `getData()`, `getQuantidadeItens()`.
- **Status:** Pronto para relatórios futuros.

## Regras de negócio aplicadas

✅ Código de produto é único (verificação ao cadastrar).
✅ Estoque não pode ser negativo (validação de entrada).
✅ Validação básica de CPF (11 dígitos, apenas números).
✅ Entrada de preço aceita `,` ou `.` como separador decimal.
✅ Entrada robusta com loops de retry em caso de erro.

## O que foi implementado

### Funcionalidades de Produtos (100% completo)
1. ✅ **Cadastrar produto** — com validação de código único, preço, estoque
2. ✅ **Listar produtos** — com numeração visual e formatação clara
3. ✅ **Buscar produto** — por código ou nome (busca parcial, case-insensitive)
4. ✅ **Atualizar estoque** — altera quantidade existente
5. ✅ **Remover produto** — com confirmação do usuário

### Estrutura do Sistema
- Menu principal com 3 módulos: Produtos / Clientes / Vendas
- Submenu de Produtos com todas as 5 operações
- Classes base criadas e estruturadas
- Tratamento de entrada robusto com loops de retry

### Melhorias Implementadas

1. **Validação robusta de entrada**
   - `readDouble` e `readInt` têm loops de retry em caso de erro
   - Mensagens de erro claras com emojis (✅, ❌)
   
2. **Busca avançada**
   - Busca por código ou nome
   - Case-insensitive
   - Suporte a busca parcial (substring)
   
3. **Feedback visual melhorado**
   - Emojis para sucesso (✅), erro (❌) e ação (📋, 🛒, 👋)
   - Formatação de saída com separadores (`\n`)
   - Listagem numerada de produtos
   
4. **Confirmação de operações críticas**
   - Pergunta ao usuário antes de remover produtos
   - Previne deletamentos acidentais
   
5. **Getters adicionados à classe Venda**
   - `getId()`, `getCliente()`, `getItens()`, `getData()`, `getQuantidadeItens()`
   - Suporta relatórios futuros
   
6. **toString() em todas as classes**
   - `Produto`: `[código] nome - R$ preço - Estoque: qtd`
   - `Cliente`: `[CPF] Nome`
   - `ItemVenda`: `nome x qtd = R$ subtotal`
   - `Venda`: ID | Cliente | Itens | Total | Data
   
7. **Estrutura modular e escalável**
   - Pronta para adicionar novos menus
   - Classes bem separadas por responsabilidade
   - Fácil expansão para próximas aulas

## Como compilar e executar

```bash
# Compilar
javac main.java

# Executar
java Main

# Teste sugerido:
# 1. Escolha opção 1 (Produtos)
# 2. Cadastre alguns produtos (ex: código P001, P002)
# 3. Liste os produtos (visualize numeração)
# 4. Busque por nome ou código
# 5. Atualize estoque de um produto
# 6. Remova um produto (com confirmação)
```

## Pontos pendentes / próximos passos

### Aula 2 - Gestão de Clientes
- Implementar CRUD completo de `Cliente`
- Cadastrar, listar, buscar por nome/CPF, remover
- Impedir duplicatas de CPF
- Validação de CPF com cálculo de dígitos verificadores

### Aula 3+ - Fluxo de Vendas
- Implementar fluxo completo de `Vendas`
- **Verificar estoque** antes de vender (produto sem estoque não pode ser vendido)
- **Atualizar estoque** ao finalizar venda (decrementar quantidade)
- Calcular subtotais e total automaticamente
- Listar vendas realizadas
- Histórico de vendas por cliente

### Futuros
- Persistência de dados (arquivo ou banco de dados)
- Relatórios e estatísticas
- Interface gráfica (Swing/JavaFX)

## Observações técnicas

- **Estrutura:** Todas as classes em um único arquivo `main.java` para simplicidade (Aula 1).
- **Armazenamento:** Em memória (`ArrayList`) — dados são perdidos ao encerrar.
- **IDs:** Vendas usam `UUID` para garantir unicidade.
- **Tratamento de erro:** Loops de retry melhoram UX.
- **Escalabilidade:** Estrutura pronta para separar em múltiplos arquivos.

## Status do projeto

- ✅ Estrutura base completa
- ✅ Menu principal navegável
- ✅ CRUD de Produtos 100% funcional
- ✅ Validações em lugar
- ✅ Feedback visual com emojis
- 🔄 CRUD de Clientes (próxima aula)
- 🔄 Fluxo de Vendas (próxima aula)
- ⏳ Persistência de dados

---

**Versão:** Aula 1 (Revisada e Melhorada)  
**Data:** 2026-06-03  
**Status:** ✅ Estrutura base funcionando com navegação no menu
