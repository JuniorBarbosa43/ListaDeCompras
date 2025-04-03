# Lista de Compras em Java

## Descrição

Este projeto é um sistema de lista de compras em Java que permite adicionar itens a uma lista, categorizá-los por setores predefinidos e conferir os itens ao adicioná-los ao carrinho. O usuário pode visualizar tanto a lista de compras quanto os itens já conferidos no carrinho e calcular o total gasto.

## Funcionalidades

- **Adicionar Itens**: O usuário pode adicionar itens à lista de compras e escolher seus setores a partir de uma lista predefinida.
- **Remover Itens**: Permite a remoção de itens da lista de compras.
- **Conferir Itens no Carrinho**: Quando um item é conferido, ele é removido da lista de compras e adicionado ao carrinho, registrando o valor pago.
- **Filtrar por Setor**: Exibe os itens pertencentes a um setor específico.
- **Exibir Lista de Compras**: Mostra todos os itens ainda não conferidos.
- **Exibir Carrinho**: Lista os itens que já foram adicionados ao carrinho com seus preços.
- **Calcular Total**: Soma os valores dos itens no carrinho.

## Tecnologias Utilizadas

- **Java** (versão 8 ou superior)
- **Scanner** para entrada de dados
- **Coleções Java (List, Set)** para manipulação de itens e setores

## Como Usar

1. Clone o repositório ou copie o código-fonte.
2. Compile o programa com:
   ```sh
   javac ListaDeCompras.java
   ```
3. Execute o programa:
   ```sh
   java ListaDeCompras
   ```
4. Siga as instruções do menu para gerenciar sua lista de compras.

## Estrutura do Código

- **Classe ****`Item`**: Representa um item com nome, setores e preço.
- **Classe ****`ListaDeCompras`**: Gerencia os itens na lista de compras e no carrinho.
- **Método ****`main`**: Controla a interação do usuário através de um menu interativo.

## Melhorias Futuras

- Implementação de um banco de dados para persistência de dados.
- Interface gráfica para facilitar o uso.
- Suporte para múltiplos usuários e listas compartilhadas.

##

