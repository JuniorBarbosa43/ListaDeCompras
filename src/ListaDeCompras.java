import java.util.*;

class Item {
    String nome;
    Set<String> setores;
    double preco;
    boolean conferido;

    public Item(String nome, Set<String> setores) {
        this.nome = nome;
        this.setores = setores;
        this.preco = 0;
        this.conferido = false;
    }

    public void conferir(double preco) {
        this.preco = preco;
        this.conferido = true;
    }

    @Override
    public String toString() {
        return nome + " | Setores: " + setores + " | " + (conferido ? "No Carrinho - R$ " + preco : "Pendente");
    }
}

public class ListaDeCompras {
    private final List<Item> lista;
    private final List<Item> carrinho;
    private static final List<String> SETORES = Arrays.asList("Enlatados", "Higiene", "Açougue", "Padaria", "Hortifruti", "Limpeza");

    public ListaDeCompras() {
        this.lista = new ArrayList<>();
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, Set<String> setores) {
        lista.add(new Item(nome, setores));
    }

    public void removerItem(String nome) {
        lista.removeIf(item -> item.nome.equalsIgnoreCase(nome));
    }

    public void conferirItem(String nome, double preco) {
        Iterator<Item> it = lista.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.nome.equalsIgnoreCase(nome)) {
                item.conferir(preco);
                carrinho.add(item);
                it.remove();
                return;
            }
        }
    }

    public void filtrarPorSetor(String setor) {
        System.out.println("Itens no setor " + setor + ":");
        for (Item item : lista) {
            if (item.setores.contains(setor)) {
                System.out.println(item);
            }
        }
    }

    public void exibirLista() {
        System.out.println("Lista de Compras:");
        for (Item item : lista) {
            System.out.println(item);
        }
    }

    public void exibirCarrinho() {
        System.out.println("Carrinho:");
        for (Item item : carrinho) {
            System.out.println(item);
        }
    }

    public double calcularTotal() {
        return carrinho.stream().mapToDouble(item -> item.preco).sum();
    }

    public static void main(String[] args) {
        ListaDeCompras lista = new ListaDeCompras();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Conferir Item no Carrinho");
            System.out.println("4. Filtrar por Setor");
            System.out.println("5. Exibir Lista de Compras");
            System.out.println("6. Exibir Carrinho");
            System.out.println("7. Calcular Total");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Item: ");
                    String nome = scanner.nextLine();
                    Set<String> setoresEscolhidos = new HashSet<>();
                    while (true) {
                        System.out.println("Escolha um setor (ou digite 0 para finalizar):");
                        for (int i = 0; i < SETORES.size(); i++) {
                            System.out.println((i + 1) + ". " + SETORES.get(i));
                        }
                        int escolha = scanner.nextInt();
                        scanner.nextLine();
                        if (escolha == 0) break;
                        if (escolha > 0 && escolha <= SETORES.size()) {
                            setoresEscolhidos.add(SETORES.get(escolha - 1));
                        }
                    }
                    lista.adicionarItem(nome, setoresEscolhidos);
                    break;
                case 2:
                    System.out.print("Nome do Item para remover: ");
                    String nomeRemover = scanner.nextLine();
                    lista.removerItem(nomeRemover);
                    break;
                case 3:
                    System.out.print("Nome do Item conferido: ");
                    String nomeConferir = scanner.nextLine();
                    System.out.print("Preço pago: ");
                    double preco = scanner.nextDouble();
                    lista.conferirItem(nomeConferir, preco);
                    break;
                case 4:
                    System.out.print("Setor para filtrar: ");
                    String setorFiltrar = scanner.nextLine();
                    lista.filtrarPorSetor(setorFiltrar);
                    break;
                case 5:
                    lista.exibirLista();
                    break;
                case 6:
                    lista.exibirCarrinho();
                    break;
                case 7:
                    System.out.println("Total do carrinho: R$ " + lista.calcularTotal());
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }1
        }
    }
}