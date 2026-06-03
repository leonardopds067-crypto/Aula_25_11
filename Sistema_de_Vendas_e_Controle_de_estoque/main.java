import java.util.*;
import java.time.LocalDateTime;

class Main {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		sistema.run();
	}
}

// Classe helper para formatação da interface
class UI {
	// Cores ANSI
	static final String RESET = "\u001B[0m";
	static final String CYAN = "\u001B[36m";
	static final String GREEN = "\u001B[32m";
	static final String YELLOW = "\u001B[33m";
	static final String BLUE = "\u001B[34m";
	static final String BOLD = "\u001B[1m";

	static void headerPrincipal(String titulo) {
		System.out.println("\n" + CYAN + BOLD + "╔════════════════════════════════════════════════════════════╗" + RESET);
		System.out.println(CYAN + BOLD + "║" + RESET + CYAN + centralize(titulo, 60) + CYAN + BOLD + "║" + RESET);
		System.out.println(CYAN + BOLD + "╚════════════════════════════════════════════════════════════╝" + RESET);
	}

	static void headerSecundario(String titulo) {
		System.out.println("\n" + BLUE + BOLD + "╭─ " + titulo + RESET);
	}

	static void opcao(String numero, String descricao, String emoji) {
		System.out.printf("  %s %s %s%s%s\n", YELLOW + numero + RESET, emoji, descricao, RESET, "");
	}

	static void separador() {
		System.out.println(CYAN + "────────────────────────────────────────────────────────────" + RESET);
	}

	static void mensagem(String msg, String tipo) {
		if (tipo.equals("sucesso")) {
			System.out.println(GREEN + "✅ " + msg + RESET);
		} else if (tipo.equals("erro")) {
			System.out.println("\u001B[31m" + "❌ " + msg + RESET); // Vermelho
		} else if (tipo.equals("info")) {
			System.out.println(BLUE + "ℹ️  " + msg + RESET);
		} else if (tipo.equals("aviso")) {
			System.out.println(YELLOW + "⚠️  " + msg + RESET);
		}
	}

	static void input(String prompt) {
		System.out.print(YELLOW + BOLD + prompt + RESET);
	}

	private static String centralize(String texto, int width) {
		int totalSpaces = width - texto.length();
		int leftSpaces = totalSpaces / 2;
		int rightSpaces = totalSpaces - leftSpaces;
		return " ".repeat(leftSpaces) + texto + " ".repeat(rightSpaces);
	}
}

class Sistema {
	private List<Produto> produtos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private List<Venda> vendas = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public void run() {
		while (true) {
			UI.headerPrincipal("🛒 Sistema de Vendas e Controle de Estoque");
			UI.separador();
			UI.opcao("1", "Produtos", "📦");
			UI.opcao("2", "Clientes", "👥");
			UI.opcao("3", "Vendas", "🛒");
			UI.opcao("0", "Sair", "🚪");
			UI.separador();
			UI.input("Escolha: ");
			String opt = sc.nextLine().trim();
			switch (opt) {
				case "1": menuProdutos(); break;
				case "2": UI.mensagem("Gestão de clientes em desenvolvimento", "aviso"); break;
				case "3": UI.mensagem("Fluxo de vendas em desenvolvimento", "aviso"); break;
				case "0": UI.mensagem("Até logo!", "info"); return;
				default: UI.mensagem("Opção inválida. Tente novamente.", "erro");
			}
		}
	}

	private void menuProdutos() {
		while (true) {
			UI.headerSecundario("📦 Gerenciador de Produtos");
			UI.separador();
			UI.opcao("1", "Cadastrar novo produto", "➕");
			UI.opcao("2", "Listar todos os produtos", "📊");
			UI.opcao("3", "Buscar produto", "🔍");
			UI.opcao("4", "Atualizar estoque", "📈");
			UI.opcao("5", "Remover produto", "🗑️");
			UI.opcao("0", "Voltar ao menu principal", "⬅️");
			UI.separador();
			UI.input("Escolha: ");
			String opt = sc.nextLine().trim();
			switch (opt) {
				case "1": cadastrarProduto(); break;
				case "2": listarProdutos(); break;
				case "3": buscarProduto(); break;
				case "4": atualizarEstoque(); break;
				case "5": removerProduto(); break;
				case "0": return;
				default: UI.mensagem("Opção inválida. Tente novamente.", "erro");
			}
		}
	}

	private void cadastrarProduto() {
		UI.headerSecundario("➕ Cadastrar Novo Produto");
		UI.separador();
		UI.input("Código: ");
		String codigo = sc.nextLine().trim();
		if (codigo.isEmpty()) { UI.mensagem("Código não pode ser vazio.", "erro"); return; }
		if (findProdutoByCodigo(codigo) != null) {
			UI.mensagem("Já existe um produto com esse código.", "erro");
			return;
		}
		UI.input("Nome: ");
		String nome = sc.nextLine().trim();
		if (nome.isEmpty()) { UI.mensagem("Nome não pode ser vazio.", "erro"); return; }
		double preco = readDouble("Preço (R$): ");
		if (preco < 0) { UI.mensagem("Preço inválido. Deve ser >= 0.", "erro"); return; }
		int estoque = readInt("Quantidade em estoque: ");
		if (estoque < 0) { UI.mensagem("Estoque não pode ser negativo.", "erro"); return; }
		Produto p = new Produto(codigo, nome, preco, estoque);
		produtos.add(p);
		UI.separador();
		UI.mensagem("Produto \"" + nome + "\" cadastrado com sucesso!", "sucesso");
	}

	private void listarProdutos() {
		UI.headerSecundario("📊 Lista de Produtos");
		UI.separador();
		if (produtos.isEmpty()) {
			UI.mensagem("Nenhum produto cadastrado.", "info");
			return;
		}
		for (int i = 0; i < produtos.size(); i++) {
			System.out.printf("  %d. %s\n", i + 1, produtos.get(i));
		}
		UI.separador();
		System.out.printf("  Total: %d produto(s)\n", produtos.size());
	}

	private void buscarProduto() {
		UI.headerSecundario("🔍 Buscar Produto");
		UI.separador();
		UI.input("Digite código ou nome: ");
		String termo = sc.nextLine().trim().toLowerCase();
		if (termo.isEmpty()) { UI.mensagem("Termo não pode ser vazio.", "erro"); return; }
		List<Produto> resultados = new ArrayList<>();
		for (Produto p : produtos) {
			if (p.getCodigo().toLowerCase().contains(termo) || 
			    p.getNome().toLowerCase().contains(termo)) {
				resultados.add(p);
			}
		}
		UI.separador();
		if (resultados.isEmpty()) {
			UI.mensagem("Nenhum produto encontrado com o termo: " + termo, "aviso");
		} else {
			System.out.println("  " + UI.GREEN + "Produtos encontrados:" + UI.RESET);
			for (Produto p : resultados) System.out.println("  " + p);
		}
	}

	private void atualizarEstoque() {
		UI.headerSecundario("📈 Atualizar Estoque");
		UI.separador();
		UI.input("Código do produto: ");
		String codigo = sc.nextLine().trim();
		Produto p = findProdutoByCodigo(codigo);
		if (p == null) {
			UI.mensagem("Produto não encontrado.", "erro");
			return;
		}
		System.out.printf("  Produto: %s | Estoque atual: %d\n", p.getNome(), p.getEstoque());
		int novoEstoque = readInt("Novo quantidade em estoque: ");
		if (novoEstoque < 0) { UI.mensagem("Estoque não pode ser negativo.", "erro"); return; }
		p.setEstoque(novoEstoque);
		UI.separador();
		UI.mensagem("Estoque atualizado para: " + novoEstoque, "sucesso");
	}

	private void removerProduto() {
		UI.headerSecundario("🗑️  Remover Produto");
		UI.separador();
		UI.input("Código do produto: ");
		String codigo = sc.nextLine().trim();
		Produto p = findProdutoByCodigo(codigo);
		if (p == null) {
			UI.mensagem("Produto não encontrado.", "erro");
			return;
		}
		UI.input("Tem certeza de remover \"" + p.getNome() + "\"? (s/n): ");
		String conf = sc.nextLine().trim().toLowerCase();
		if (conf.equals("s")) {
			produtos.remove(p);
			UI.separador();
			UI.mensagem("Produto removido com sucesso!", "sucesso");
		} else {
			UI.mensagem("Operação cancelada.", "info");
		}
	}

	private Produto findProdutoByCodigo(String codigo) {
		for (Produto p : produtos) if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
		return null;
	}

	private double readDouble(String prompt) {
		while (true) {
			UI.input(prompt);
			try {
				String s = sc.nextLine().trim();
				return Double.parseDouble(s.replace(',', '.'));
			} catch (Exception e) { 
				UI.mensagem("Entrada inválida. Digite um número.", "erro");
			}
		}
	}

	private int readInt(String prompt) {
		while (true) {
			UI.input(prompt);
			try { 
				return Integer.parseInt(sc.nextLine().trim()); 
			}
			catch (Exception e) { 
				UI.mensagem("Entrada inválida. Digite um número inteiro.", "erro");
			}
		}
	}

	// CPF validation (basic: only digits and length 11). Will be used in future lessons.
	public static boolean validarCPF(String cpf) {
		if (cpf == null) return false;
		String onlyDigits = cpf.replaceAll("\\D", "");
		return onlyDigits.length() == 11;
	}
}

class Produto {
	private String codigo;
	private String nome;
	private double preco;
	private int estoque;

	public Produto(String codigo, String nome, double preco, int estoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getCodigo() { return codigo; }
	public String getNome() { return nome; }
	public double getPreco() { return preco; }
	public int getEstoque() { return estoque; }

	public void setNome(String nome) { this.nome = nome; }
	public void setPreco(double preco) { this.preco = preco; }
	public void setEstoque(int estoque) { this.estoque = estoque; }

	@Override
	public String toString() {
		return String.format("[%s] %s - R$ %.2f - Estoque: %d", codigo, nome, preco, estoque);
	}
}

class Cliente {
	private String nome;
	private String cpf; // 11 dígitos

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() { return nome; }
	public String getCpf() { return cpf; }

	public void setNome(String nome) { this.nome = nome; }

	@Override
	public String toString() {
		return String.format("[%s] %s", cpf, nome);
	}
}

class ItemVenda {
	private Produto produto;
	private int quantidade;

	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() { return produto; }
	public int getQuantidade() { return quantidade; }
	public double getSubtotal() { return produto.getPreco() * quantidade; }
}

class Venda {
	private UUID id;
	private Cliente cliente;
	private List<ItemVenda> itens = new ArrayList<>();
	private double total;
	private LocalDateTime data;

	public Venda(Cliente cliente) {
		this.id = UUID.randomUUID();
		this.cliente = cliente;
		this.data = LocalDateTime.now();
	}

	public void adicionarItem(ItemVenda it) {
		itens.add(it);
		recalcTotal();
	}

	private void recalcTotal() {
		total = 0;
		for (ItemVenda it : itens) total += it.getSubtotal();
	}

	public double getTotal() { return total; }
	public UUID getId() { return id; }
	public Cliente getCliente() { return cliente; }
	public List<ItemVenda> getItens() { return new ArrayList<>(itens); }
	public LocalDateTime getData() { return data; }
	public int getQuantidadeItens() { return itens.size(); }
}

