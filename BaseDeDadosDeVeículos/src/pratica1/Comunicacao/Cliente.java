package pratica1.Comunicacao;

import pratica1.Entity.Condutor;
import pratica1.Entity.Veiculo;

import java.util.Scanner;

public class Cliente {

    Protocolo protocolo = new Protocolo("Vasco!");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.cinquentaValores();
        cliente.executar();
        scanner.close();
    }

    private void executar() {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    buscar();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 6:
                    qntVeiculos();
                    break;
                case 7:
                    encerrar();
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
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
  
    public void cinquentaValores() {
    	this.inserir(new Veiculo("ABC1234", "12345678910", "Fiat Uno", "01/01/2023", new Condutor("Juninho Pernambucano", "123.456.789-01")));
    	this.inserir(new Veiculo("XYZ5678", "98765432101", "Toyota Corolla", "05/15/2023", new Condutor("Romário de Souza Faria", "987.654.321-02")));
    	this.inserir(new Veiculo("DEF6789", "45678901230", "Honda Civic", "07/22/2023", new Condutor("Roberto Dinamite", "456.789.012-03")));
    	this.inserir(new Veiculo("GHI9012", "23456789011", "Chevrolet Cruze", "03/10/2023", new Condutor("Felipe Loureiro", "234.567.890-04")));
    	this.inserir(new Veiculo("JKL3456", "78901234560", "Volkswagen Golf", "09/18/2023", new Condutor("Edmundo Alves de Souza Neto", "789.012.345-05")));
    	this.inserir(new Veiculo("MNO7890", "56789012340", "Nissan Sentra", "11/05/2023", new Condutor("Carlos Germano Schwambach", "567.890.123-06")));
    	this.inserir(new Veiculo("PQR2345", "89012345671", "Ford Focus", "04/30/2023", new Condutor("Mauro Galvão", "890.123.456-07")));
    	this.inserir(new Veiculo("STU4567", "67890123450", "Mazda Mazda3", "06/20/2023", new Condutor("Ademir Menezes", "678.901.234-08")));
    	this.inserir(new Veiculo("VWX6789", "34567890129", "Kia Optima", "02/14/2023", new Condutor("Bellini", "345.678.901-09")));
    	this.inserir(new Veiculo("YZA8901", "01234567818", "Subaru Impreza", "08/08/2023", new Condutor("Barbosa", "012.345.678-10")));
    	this.inserir(new Veiculo("BCD1234", "23456789012", "Hyundai Elantra", "01/07/2023", new Condutor("Eurico Miranda", "234.567.890-11")));
    	this.inserir(new Veiculo("EFG5678", "45678901231", "Mercedes-Benz C-Class", "05/25/2023", new Condutor("Garrincha", "456.789.012-12")));
    	this.inserir(new Veiculo("HIJ7890", "67890123451", "Audi A3", "07/14/2023", new Condutor("Carlos Alberto Torres", "678.901.234-13")));
    	this.inserir(new Veiculo("KLM2345", "89012345672", "BMW 3 Series", "03/02/2023", new Condutor("Valdir Pereira", "890.123.456-14")));
    	this.inserir(new Veiculo("NOP4567", "01234567819", "Lexus ES", "09/29/2023", new Condutor("Dener Augusto de Souza", "012.345.678-15")));
    	this.inserir(new Veiculo("QRS6789", "23456789013", "Tesla Model 3", "11/18/2023", new Condutor("Bebeto", "234.567.890-16")));
    	this.inserir(new Veiculo("TUV8901", "45678901232", "Porsche 911", "04/13/2023", new Condutor("Paulinho de Almeida", "456.789.012-17")));
    	this.inserir(new Veiculo("WXY1234", "67890123452", "Jaguar XF", "06/06/2023", new Condutor("Mazinho", "678.901.234-18")));
    	this.inserir(new Veiculo("ZAB5678", "89012345673", "Volvo S60", "02/28/2023", new Condutor("Roberto Antonio Dinamite", "890.123.456-19")));
    	this.inserir(new Veiculo("CDE7890", "01234567820", "Mitsubishi Lancer", "08/22/2023", new Condutor("Carlos Tenorio", "012.345.678-20")));
    	this.inserir(new Veiculo("FGH1234", "23456789021", "Renault Megane", "01/15/2023", new Condutor("Zico", "234.567.890-21")));
    	this.inserir(new Veiculo("IJK5678", "45678901233", "Acura TLX", "05/10/2023", new Condutor("Falcão", "456.789.012-22")));
    	this.inserir(new Veiculo("LMN7890", "67890123453", "Infiniti Q50", "07/25/2023", new Condutor("Cafu", "678.901.234-23")));
    	this.inserir(new Veiculo("OPQ2345", "89012345674", "Cadillac CT4", "03/08/2023", new Condutor("Ronaldo Nazário", "890.123.456-24")));
    	this.inserir(new Veiculo("RST4567", "01234567822", "Chrysler 300", "09/05/2023", new Condutor("Rivaldo", "012.345.678-25")));
    	this.inserir(new Veiculo("TUV6789", "23456789023", "Dodge Charger", "11/22/2023", new Condutor("Ricardo Kaká", "234.567.890-26")));
    	this.inserir(new Veiculo("WXY8901", "45678901234", "Ferrari 488", "04/18/2023", new Condutor("Ronaldinho Gaúcho", "456.789.012-27")));
    	this.inserir(new Veiculo("ZAB2345", "67890123454", "Lamborghini Huracan", "06/30/2023", new Condutor("Robinho", "678.901.234-28")));
    	this.inserir(new Veiculo("CDE4567", "89012345675", "Maserati Ghibli", "02/03/2023", new Condutor("Coutinho", "890.123.456-29")));
    	this.inserir(new Veiculo("FGH6789", "01234567824", "Porsche Panamera", "08/17/2023", new Condutor("Casemiro", "012.345.678-30")));
    	this.inserir(new Veiculo("IJK8901", "23456789024", "Alfa Romeo Giulia", "01/19/2023", new Condutor("Marcelo", "234.567.890-31")));
    	this.inserir(new Veiculo("LMN2345", "45678901235", "Jaguar F-Type", "05/12/2023", new Condutor("Gabriel Jesus", "456.789.012-32")));
    	this.inserir(new Veiculo("OPQ4567", "67890123455", "Koenigsegg Jesko", "07/28/2023", new Condutor("Neymar Jr.", "678.901.234-33")));
    	this.inserir(new Veiculo("RST6789", "89012345676", "Pagani Huayra", "03/10/2023", new Condutor("Philippe Coutinho", "890.123.456-34")));
    	this.inserir(new Veiculo("TUV2345", "01234567825", "Bugatti Chiron", "09/07/2023", new Condutor("Roberto Firmino", "012.345.678-35")));
    	this.inserir(new Veiculo("WXY4567", "23456789025", "Lexus LC", "11/24/2023", new Condutor("Thiago Silva", "234.567.890-36")));
    	this.inserir(new Veiculo("ZAB6789", "45678901236", "Lotus Evora", "04/20/2023", new Condutor("Marquinhos", "456.789.012-37")));
    	this.inserir(new Veiculo("CDE8901", "67890123456", "McLaren 720S", "06/10/2023", new Condutor("Fabinho", "678.901.234-38")));
    	this.inserir(new Veiculo("FGH2345", "89012345677", "Nissan GT-R", "02/12/2023", new Condutor("Fred", "890.123.456-39")));
    	this.inserir(new Veiculo("IJK4567", "01234567826", "Tesla Model S", "08/28/2023", new Condutor("Douglas Luiz", "012.345.678-40")));
    	this.inserir(new Veiculo("LMN6789", "23456789026", "Toyota Supra", "01/21/2023", new Condutor("Everton Ribeiro", "234.567.890-41")));
    	this.inserir(new Veiculo("OPQ8901", "45678901237", "Volkswagen Arteon", "05/15/2023", new Condutor("Tite", "456.789.012-42")));
    	this.inserir(new Veiculo("RST2345", "67890123457", "Volvo XC60", "07/30/2023", new Condutor("Casemiro", "678.901.234-43")));
    	this.inserir(new Veiculo("TUV4567", "89012345678", "Jeep Grand Cherokee", "03/12/2023", new Condutor("Neymar Jr.", "890.123.456-44")));
    	this.inserir(new Veiculo("WXY6789", "01234567827", "Land Rover Discovery", "09/09/2023", new Condutor("Philippe Coutinho", "012.345.678-45")));
    	this.inserir(new Veiculo("ZAB8901", "23456789027", "Lamborghini Urus", "11/26/2023", new Condutor("Roberto Firmino", "234.567.890-46")));
    	this.inserir(new Veiculo("CDE2345", "45678901238", "Ferrari SF90", "04/22/2023", new Condutor("Marquinhos", "456.789.012-47")));
    	this.inserir(new Veiculo("FGH4567", "67890123458", "Porsche Taycan", "06/15/2023", new Condutor("Fabinho", "678.901.234-48")));
    	this.inserir(new Veiculo("IJK6789", "89012345679", "Aston Martin DB11", "02/15/2023", new Condutor("Fred", "890.123.456-49")));
    	this.inserir(new Veiculo("LMN8901", "01234567828", "Maserati Quattroporte", "08/30/2023", new Condutor("Douglas Luiz", "012.345.678-50")));
    }

	private void inserir(Veiculo veiculo) {
		protocolo.cadastrarVeiculo(veiculo);
	}
	
	private void buscar() {
	System.out.print("Digite o renavam do veículo: ");
    String renavam = scanner.nextLine();
    Veiculo veiculo = protocolo.buscarVeiculos(renavam);
    if (veiculo != null) {
        System.out.println("Veículo encontrado:");
        System.out.println(veiculo);
    } else {
        System.out.println("Veículo não encontrado.");
    	}
    }
	
	private void cadastrar() {
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
        Veiculo novoVeiculo = new Veiculo(novoRenavam,Placa, marca, modelo, new Condutor(Nomecondutor,CpfCondutor));
        if (protocolo.cadastrarVeiculo(novoVeiculo)) {
            System.out.println("Veículo cadastrado com sucesso.");
        } else {
            System.out.println("Falha ao cadastrar veículo.");
        }
	}
	
	private void atualizar() {
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
            System.out.print("Data de fabricação: ");
            String novaData = scanner.nextLine();
            veiculoAlteracao.setDataFabricacao(novaData);
            veiculoAlteracao.setModelo(novoModelo);
            veiculoAlteracao.setCondutor(novoNome, novoCPF);
            System.out.println("Veículo alterado com sucesso.");
        } else {
            System.out.println("Veículo não encontrado.");
        }
	}
	
	private void listar() {
		System.out.println("Lista de veículos:");
        protocolo.listarVeiculos();
    }
	
	private void remover() {
		System.out.print("Digite o renavam do veículo a ser removido: ");
        String renavamRemocao = scanner.nextLine();
        Veiculo veiculoRemocao = protocolo.buscarVeiculos(renavamRemocao);
        if (veiculoRemocao != null) {
            protocolo.removerVeiculo(veiculoRemocao);
            System.out.println("Veículo removido com sucesso.");
        } else {
            System.out.println("Veículo não encontrado.");
        }
	}
	
	private void qntVeiculos() {
        int quantidade = protocolo.qntVeiculos();
        System.out.println("Quantidade de veículos cadastrados: " + quantidade);
    }

    private void encerrar() {
        String mensagemEncerramento = protocolo.encerrarConexao();
        System.out.println(mensagemEncerramento);
    }
}