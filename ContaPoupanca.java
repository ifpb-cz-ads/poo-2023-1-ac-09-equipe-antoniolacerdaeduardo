public class ContaPoupanca extends Conta {
    //metodos
    public void reajustar (double percentual) {
        this.saldo += saldo * percentual;
    }
    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor){
            this.saldo -= valor;
            return true;
        }
        else {
            return false;
        }
    }
}
