package src;

public class Main {

	public static void main(String[] args) {
		Cliente giulia = new Cliente();
		giulia.setNome("Giulia");

		Conta cc = new ContaCorrente(giulia);
		Conta poupanca = new ContaPoupanca(giulia);

		Banco banco = new Banco();
		banco.adicionarConta(cc);
		banco.adicionarConta(poupanca);

		cc.depositar(100);
		cc.transferir(100, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		System.out.println("Clientes do banco:");
		for (Cliente cliente : banco.getClientes()) {
			System.out.println(cliente.getNome());
		}

		System.out.println("Contas do clientes:");
		for (Conta conta : banco.getContasDoCliente(giulia)) {
			System.out.println("Conta número: " + conta.getNumero() + ", Saldo: " + conta.getSaldo());
		}
	}
}
