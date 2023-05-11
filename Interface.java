public class Interface {
    public void principal() {
        System.out.println("--------- Banco ADS ---------");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Visualizar saldo");
        System.out.println("3 - Sacar");
        System.out.println("4 - Depositar");
        System.out.println("0 - Sair do programa");
    }

    public void criarConta() {
        System.out.println("Escolha o tipo da conta:");
        System.out.println("1 - Conta Especial");
        System.out.println("2 - Conta Poupança");
        System.out.println("0 - Voltar");
    }

    public void informarNumero() {
        System.out.println("Informe o numero da conta:");
    }

    public void informarNome() {
        System.out.println("Informe o nome do cliente:");
    }

    public void informarCpf() {
        System.out.println("Informe o CPF do cliente:");
    }

    public void informarValor(String tipo) {
        System.out.println("Informe o valor do " + tipo + ":");
    }

    public void receberValor(String tipo, double valor) {
        System.out.println("Você " + tipo + " R$" + valor + " .");
    }

    public void informarSaldo(double saldo) {
        System.out.println("Saldo atual: R$" + saldo + " .");
    }

    public void contaInexistente() {
        System.out.println("Conta inexistente!");
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida!");
    }

    public void saldoInsuficiente () {
        System.out.println("Saldo insuficiente!");
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
