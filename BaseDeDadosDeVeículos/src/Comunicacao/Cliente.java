package Comunicacao;

import Entity.Veiculo;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Protocolo protocolo = new Protocolo("Vasco!");

        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o renavam do veículo: ");
                    String renavam = scanner.nextLine();
                    Veiculo veiculo = protocolo.buscarVeiculos(renavam);
                    if (veiculo != null) {
                        System.out.println("Veículo encontrado:");
                        System.out.println(veiculo);
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Digite os dados do veículo:");
                    System.out.print("Placa: ");
                    String Placa = scanner.nextLine();
                    System.out.print("Renavam: ");
                    String novoRenavam = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Cpf do condutor: ");
                    String CpfCondutor = scanner.nextLine();
                    System.out.print("Nome do condutor: ");
                    String Nomecondutor = scanner.nextLine();
                    Veiculo novoVeiculo = new Veiculo(Placa,novoRenavam,Nomecondutor,CpfCondutor, marca, modelo);
                    if (protocolo.cadastrarVeiculo(novoVeiculo)) {
                        System.out.println("Veículo cadastrado com sucesso.");
                    } else {
                        System.out.println("Falha ao cadastrar veículo.");
                    }
                    break;
                case 3:
                    System.out.println("Lista de veículos:");
                    protocolo.listarVeiculos();
                    break;
                case 4:
                    System.out.print("Digite o renavam do veículo a ser alterado: ");
                    String renavamAlteracao = scanner.nextLine();
                    Veiculo veiculoAlteracao = protocolo.buscarVeiculos(renavamAlteracao);
                    if (veiculoAlteracao != null) {
                        System.out.println("Digite os novos dados do veículo:");
                        System.out.print("Modelo: ");
                        String novoModelo = scanner.nextLine();
                        System.out.print("Cpf do condutor: ");
                        String novoCPF = scanner.nextLine();
                        System.out.print("Nome do condutor: ");
                        String novoNome = scanner.nextLine();
                        String novaData = scanner.nextLine();
                        veiculoAlteracao.setDataFabricacao(novaData);
                        veiculoAlteracao.setModelo(novoModelo);
                        veiculoAlteracao.setCpfCondutor(novoCPF);
                        veiculoAlteracao.setNomeCondutor(novoNome);
                        System.out.println("Veículo alterado com sucesso.");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o renavam do veículo a ser removido: ");
                    String renavamRemocao = scanner.nextLine();
                    Veiculo veiculoRemocao = protocolo.buscarVeiculos(renavamRemocao);
                    if (veiculoRemocao != null) {
                        protocolo.removerVeiculo(veiculoRemocao);
                        System.out.println("Veículo removido com sucesso.");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 6:
                    int quantidade = protocolo.qntVeiculos();
                    System.out.println("Quantidade de veículos cadastrados: " + quantidade);
                    break;
                case 7:
                    String mensagemEncerramento = protocolo.encerrarConexao();
                    System.out.println(mensagemEncerramento);
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nOpções:");
        System.out.println("1. Consultar veículo");
        System.out.println("2. Cadastrar veículo");
        System.out.println("3. Listar veículos");
        System.out.println("4. Alterar veículo");
        System.out.println("5. Remover veículo");
        System.out.println("6. Obter quantidade de veículos");
        System.out.println("7. Encerrar conexão");
        System.out.print("Escolha uma opção: ");
    }
}