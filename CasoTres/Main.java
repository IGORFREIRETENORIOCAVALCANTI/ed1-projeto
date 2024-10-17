package CasoTres;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Mesa> mesas = new ListaCircular<>();
        ListaCircular<Pedido> pedidos = new ListaCircular<>();
        
        //Inserções de exemplo
        Mesa mesa1 = new Mesa(1, "cleito");
        mesas.inserir(mesa1);
        //Exemplo 10 mesas
        for (int i = 2; i <= 10; i++) {
            mesas.inserir(new Mesa(i, ""));
        }
        

        Pedido pedido1 = new Pedido("amburgue", 2, 20.00, 1);
        Pedido pedido2 = new Pedido("suco de amburgue", 3, 9.00, 1);
        pedidos.inserir(pedido1);
        pedidos.inserir(pedido2);
        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----------------------------");
            System.out.println("Menu:");
            System.out.println("1. Adicionar nova mesa");
            System.out.println("2. Adicionar novo pedido");
            System.out.println("3. Fechar conta");
            System.out.println("4. Buscar mesa específica");
            System.out.println("5. Buscar pedido específico");
            System.out.println("6. Atualizar dados dos itens pedidos");
            System.out.println("7. Listar todas as mesas");
            System.out.println("8. Listar todos os pedidos");
            System.out.println("9. Associar cliente a uma mesa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    System.out.println("----------------------------");
                    System.out.println("Número da mesa:");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Cliente associado:");
                    String cliente = scanner.nextLine();
                    System.out.println("----------------------------");
                    Mesa novaMesa = new Mesa(numeroMesa, cliente);
                    mesas.inserir(novaMesa);
                    System.out.println("Mesa adicionada com sucesso.");
                    break;
                case 2:
                    System.out.println("----------------------------");
                    System.out.println("Número da mesa para o pedido:");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Descrição do pedido:");
                    String descricao = scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Quantidade:");
                    int quantidade = scanner.nextInt();
                    System.out.println("----------------------------");
                    System.out.println("Total a pagar:");
                    double total = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    Mesa mesaPedido = (Mesa) mesas.buscarPorDescricao("Mesa: " + numeroMesa);
                    if (mesaPedido != null) {
                        Pedido novoPedido = new Pedido(descricao, quantidade, total, numeroMesa);
                        pedidos.inserir(novoPedido);
                        System.out.println("Pedido adicionado com sucesso.");
                    } else {
                        System.out.println("Mesa não encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("----------------------------");
                    System.out.println("Número da mesa para fechar a conta:");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    mesas.fecharConta(numeroMesa);
                    break;
                case 4:
                    System.out.println("----------------------------");
                    System.out.println("Número da mesa a ser buscada:");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    Mesa mesa = (Mesa) mesas.buscarPorDescricao("Mesa: " + numeroMesa);
                    if (mesa != null) {
                        System.out.println(mesa.toString());
                    } else {
                        System.out.println("Mesa não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("----------------------------");
                    System.out.println("Descrição do pedido a ser buscado:");
                    descricao = scanner.nextLine();
                    System.out.println("----------------------------");
                    Pedido pedido = (Pedido) pedidos.buscarPorDescricao(descricao);
                    if (pedido != null) {
                        System.out.println(pedido.toString());
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("----------------------------");
                    System.out.println("Descrição do pedido a ser atualizado:");
                    String descricaoAntiga = scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Nova descrição:");
                    String novaDescricao = scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Nova quantidade:");
                    int novaQuantidade = scanner.nextInt();
                    System.out.println("----------------------------");
                    System.out.println("Novo total:");
                    double novoTotal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    pedidos.atualizarPedido(descricaoAntiga, novaDescricao, novaQuantidade, novoTotal);
                    break;
                case 7:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todas as mesas:");
                    mesas.listarTodosMesas();
                    break;
                case 8:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todos os pedidos:");
                    pedidos.listarTodosPedidos();
                    break;
                case 9:
                    System.out.println("----------------------------");
                    System.out.println("Número da mesa a ser associada a um cliente:");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Nome do cliente:");
                    cliente = scanner.nextLine();
                    System.out.println("----------------------------");
                    Mesa mesaAssociar = (Mesa) mesas.buscarPorDescricao("Mesa: " + numeroMesa);
                    if (mesaAssociar != null) {
                        mesaAssociar.setCliente(cliente);
                        System.out.println("Cliente " + cliente + " associado à mesa " + numeroMesa + " com sucesso.");
                    } else {
                        System.out.println("Mesa não encontrada.");
                    }
                    break;
                case 0:
                System.out.println("----------------------------");
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
