import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class AppBanco {
	public static void main(String[] args) {
		ArrayList<Conta> lista = new ArrayList<>();
		Interface menu = new Interface();
		Conta c = null;
		Cliente usuario = null;
		Scanner scan = new Scanner(System.in);
		int opcao;
		int tipoConta;
		int numeroConta;
		String nome;
		String cpf;
		double valor;
		menu.limparTela();
		do {
			menu.principal();
			opcao = scan.nextInt();
			menu.limparTela();
			switch (opcao) {
				case 1:
					do {
						menu.criarConta();
						tipoConta = scan.nextInt();
						menu.limparTela();
						switch (tipoConta) {
							case 1:
								menu.informarNome();
								nome = scan.next();
								menu.informarCpf();
								cpf = scan.next();
								usuario = new Cliente(nome, cpf);
								menu.informarValor("limite");
								valor = scan.nextDouble();
								menu.informarNumero();
								numeroConta = scan.nextInt();
								c = new ContaEspecial(numeroConta, usuario, valor);
								break;
							case 2:
								menu.informarNome();
								nome = scan.next();
								menu.informarCpf();
								cpf = scan.next();
								usuario = new Cliente(nome, cpf);
								menu.informarNumero();
								numeroConta = scan.nextInt();
								c = new ContaPoupanca(numeroConta, usuario);
								break;
							case 0:
								break;
							default:
								menu.opcaoInvalida();
								break;
						}
					} while (tipoConta != 0);

					lista.add(c);
					break;
				case 2:
					menu.informarNumero();
					numeroConta = scan.nextInt();
					Iterator<Conta> it = lista.iterator();
					c = null;
					boolean contaEncontrada = false;
					while (it.hasNext()) {
						c = it.next();
						if (c.numero == numeroConta) {
							menu.informarSaldo(c.getSaldo());
							contaEncontrada = true;
						}
					}
					if (!contaEncontrada) {
						menu.contaInexistente();
					}
					break;
				case 3:
					menu.informarNumero();
					numeroConta = scan.nextInt();
					it = lista.iterator();
					c = null;
					contaEncontrada = false;
					while (it.hasNext()) {
						c = it.next();
						if (c.numero == numeroConta) {
							menu.informarValor("saque");
							valor = scan.nextDouble();
							boolean saque_efetuado = c.sacar(valor);
							if (saque_efetuado) {
								menu.receberValor("sacou", valor);
								menu.informarSaldo(c.getSaldo());
							} else {
								menu.saldoInsuficiente();
								menu.informarSaldo(c.getSaldo());
							}
							contaEncontrada = true;
						}
					}
					if (!contaEncontrada) {
						menu.contaInexistente();
					}
					break;
				case 4:
					menu.informarNumero();
					numeroConta = scan.nextInt();
					it = lista.iterator();
					c = null;
					contaEncontrada = false;
					while (it.hasNext()) {
						c = it.next();
						if (c.numero == numeroConta) {
							menu.informarValor("deposito");
							valor = scan.nextDouble();
							c.depositar(valor);
							menu.receberValor("depositou", valor);
							menu.informarSaldo(c.getSaldo());
							contaEncontrada = true;
						}
					}
					if (!contaEncontrada) {
						menu.contaInexistente();
					}
					break;
				case 0:
					break;

				default:
					menu.opcaoInvalida();
					break;
			}
		} while (opcao != 0);
		scan.close();
	}
}