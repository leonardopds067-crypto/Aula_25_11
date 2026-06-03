# 🛒 Sistema de Vendas e Controle de Estoque

**Projeto educacional** desenvolvido na Aula 1 de Java — Estrutura base e gestão de produtos

## 📋 Estrutura do Projeto

```
Sistema_de_Vendas_e_Controle_de_estoque/
├── main.java                    # Código-fonte (todas as classes)
├── *.class                      # Arquivos compilados
├── test_input.txt              # Entrada de teste automatizado
└── docs/
    ├── README_AULA1.md         # 📖 Documentação completa da Aula 1
    └── TESTE_E_USO.md          # 🧪 Guia de testes e uso
```

## 🚀 Quick Start

```bash
# Compilar
javac main.java

# Executar
java Main

# Testar com entrada pré-definida
java Main < test_input.txt
```

## ✨ Funcionalidades Implementadas

### ✅ Gestão de Produtos (100% completo)
- 📝 **Cadastrar** — com validação de código único, preço e estoque
- 📊 **Listar** — com numeração e formatação clara
- 🔍 **Buscar** — por código ou nome (case-insensitive, parcial)
- 📈 **Atualizar estoque** — alterar quantidade
- 🗑️ **Remover** — com confirmação do usuário

### 🔄 Em Desenvolvimento (Próximas Aulas)
- 👥 **Gestão de Clientes** (Aula 2)
- 🛒 **Fluxo de Vendas** (Aula 3+)
- 💾 **Persistência de dados** (Futuros)

## 📚 Documentação

- **[README_AULA1.md](docs/README_AULA1.md)** — Arquitetura, classes, regras de negócio, melhorias implementadas
- **[TESTE_E_USO.md](docs/TESTE_E_USO.md)** — Guia prático de testes e uso do sistema

## 🏗️ Arquitetura

```
Main (ponto de entrada)
    ↓
Sistema (gerenciador central)
    ├── menuProdutos()
    ├── menuClientes() [em breve]
    ├── menuVendas() [em breve]
    └── Coleções:
        ├── List<Produto>
        ├── List<Cliente>
        └── List<Venda>
```

## 📦 Classes Implementadas

| Classe | Responsabilidade | Status |
|--------|------------------|--------|
| `Main` | Entrada do programa | ✅ Completo |
| `Sistema` | Gerenciador central e menus | ✅ Completo |
| `Produto` | Modelo de produto | ✅ Completo |
| `Cliente` | Modelo de cliente | 🔄 Estrutura pronta |
| `ItemVenda` | Item de uma venda | ✅ Pronto |
| `Venda` | Modelo de venda | 🔄 Estrutura pronta |

## ✅ Validações Implementadas

- ✅ Código de produto único
- ✅ Estoque não negativo
- ✅ Preço não negativo
- ✅ CPF com 11 dígitos (validação básica)
- ✅ Entrada robusta com retry automático
- ✅ Confirmação antes de operações críticas

## 🎯 Próximas Etapas

### Aula 2 — Gestão de Clientes
- [ ] Cadastrar cliente com CPF validado
- [ ] Listar clientes
- [ ] Buscar por nome ou CPF
- [ ] Remover cliente
- [ ] Impedir duplicatas de CPF

### Aula 3+ — Fluxo de Vendas
- [ ] Adicionar itens à venda
- [ ] Validar se produto tem estoque
- [ ] Impedir venda de produto sem estoque
- [ ] Atualizar estoque automaticamente
- [ ] Calcular subtotais e total
- [ ] Listar vendas e histórico por cliente

### Futuros
- [ ] Persistência em arquivo (CSV/JSON)
- [ ] Banco de dados (SQL)
- [ ] Relatórios e estatísticas
- [ ] Interface gráfica (Swing/JavaFX)

## 🔧 Melhorias Implementadas nesta Aula

1. **Validação robusta** — loops de retry em entrada inválida
2. **Busca avançada** — parcial e case-insensitive
3. **Feedback visual** — emojis e mensagens claras
4. **Confirmação de remoção** — previne deletamentos acidentais
5. **Formatação melhorada** — toString() em todas as classes
6. **Menu modular** — fácil expansão para novos módulos
7. **Estrutura escalável** — pronta para crescimento

## 📊 Status do Projeto

| Componente | Status | Progresso |
|-----------|--------|-----------|
| Estrutura base | ✅ Completo | 100% |
| Menu principal | ✅ Completo | 100% |
| Gestão de Produtos | ✅ Completo | 100% |
| Gestão de Clientes | 🔄 Estrutura | 0% |
| Fluxo de Vendas | 🔄 Estrutura | 0% |
| Persistência | ⏳ Planejado | 0% |

## 💡 Instruções de Uso

Para testes e exemplos práticos, veja **[TESTE_E_USO.md](docs/TESTE_E_USO.md)**

## 📝 Notas

- Código em memória (ArrayList) — dados perdidos ao encerrar
- Todas as classes em um arquivo para simplicidade (Aula 1)
- Pronto para separação em múltiplos arquivos em aulas futuras

---

**Desenvolvido em:** 2026-06-03  
**Versão:** Aula 1 (Revisada e Melhorada)  
**Status:** ✅ Estrutura base funcionando — Pronto para próximas aulas
