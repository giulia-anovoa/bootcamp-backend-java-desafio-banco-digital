package src;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes;

	public Banco() {
		this.contas = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return new ArrayList<>(contas); // Retorna uma cópia para evitar modificações diretas
	}

	public List<Cliente> getClientes() {
		return new ArrayList<>(clientes); // Retorna uma cópia para evitar modificações diretas
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
		if (!clientes.contains(conta.getCliente())) {
			this.clientes.add(conta.getCliente());
		}
	}

	public List<Conta> getContasDoCliente(Cliente cliente) {
		List<Conta> contasDoCliente = new ArrayList<>();
		for (Conta conta : contas) {
			if (conta.getCliente().equals(cliente)) {
				contasDoCliente.add(conta);
			}
		}
		return contasDoCliente;
	}

	public Cliente buscarClientePorNome(String nome) {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equalsIgnoreCase(nome)) {
				return cliente;
			}
		}
		return null;
	}
}
