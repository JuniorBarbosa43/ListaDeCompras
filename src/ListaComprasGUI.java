import java.awt.*;
import java.util.*;
import javax.swing.*;

class ListaComprasGUI {
    private final ListaDeCompras lista;
    private final JFrame frame;
    private final DefaultListModel<String> modeloLista;
    private final DefaultListModel<String> modeloCarrinho;
    private final JList<String> listaItens;
    private final JList<String> listaCarrinho;
    private final JTextField campoNome;
    private final JTextField campoPreco;
    private final JComboBox<String> setorBox;
    
    private static final String[] SETORES = {"Enlatados", "Higiene", "Açougue", "Padaria", "Hortifruti", "Limpeza"};

    public ListaComprasGUI() {
        lista = new ListaDeCompras();
        frame = new JFrame("Lista de Compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        modeloLista = new DefaultListModel<>();
        modeloCarrinho = new DefaultListModel<>();
        listaItens = new JList<>(modeloLista);
        listaCarrinho = new JList<>(modeloCarrinho);

        campoNome = new JTextField(10);
        campoPreco = new JTextField(5);
        setorBox = new JComboBox<>(SETORES);

        JButton btnAdicionar = new JButton("Adicionar Item");
        JButton btnRemover = new JButton("Remover Item");
        JButton btnConferir = new JButton("Conferir para Carrinho");

        JPanel painelTopo = new JPanel();
        painelTopo.add(new JLabel("Nome:"));
        painelTopo.add(campoNome);
        painelTopo.add(new JLabel("Setor:"));
        painelTopo.add(setorBox);
        painelTopo.add(btnAdicionar);

        JPanel painelMeio = new JPanel(new GridLayout(1, 2));
        painelMeio.add(new JScrollPane(listaItens));
        painelMeio.add(new JScrollPane(listaCarrinho));

        JPanel painelBaixo = new JPanel();
        painelBaixo.add(btnRemover);
        painelBaixo.add(new JLabel("Preço:"));
        painelBaixo.add(campoPreco);
        painelBaixo.add(btnConferir);

        frame.add(painelTopo, BorderLayout.NORTH);
        frame.add(painelMeio, BorderLayout.CENTER);
        frame.add(painelBaixo, BorderLayout.SOUTH);

        // Eventos dos botões
        btnAdicionar.addActionListener(e -> adicionarItem());
        btnRemover.addActionListener(e -> removerItem());
        btnConferir.addActionListener(e -> conferirItem());

        frame.setVisible(true);
    }

    private void adicionarItem() {
        String nome = campoNome.getText().trim();
        String setor = (String) setorBox.getSelectedItem();
        if (!nome.isEmpty() && setor != null) {
            Set<String> setores = new HashSet<>();
            setores.add(setor);
            lista.adicionarItem(nome, setores);
            modeloLista.addElement(nome + " (" + setor + ")");
            campoNome.setText("");
        }
    }

    private void removerItem() {
        int index = listaItens.getSelectedIndex();
        if (index != -1) {
            String item = modeloLista.get(index);
            lista.removerItem(item.split(" ")[0]);
            modeloLista.remove(index);
        }
    }

    private void conferirItem() {
        int index = listaItens.getSelectedIndex();
        if (index != -1) {
            String item = modeloLista.get(index);
            String nome = item.split(" ")[0];
            double preco;
            try {
                preco = Double.parseDouble(campoPreco.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Preço inválido!");
                return;
            }
            lista.conferirItem(nome, preco);
            modeloLista.remove(index);
            modeloCarrinho.addElement(nome + " - R$ " + preco);
            campoPreco.setText("");
        }
    }

    public static void main(String[] args) {
        new ListaComprasGUI();
    }
}
