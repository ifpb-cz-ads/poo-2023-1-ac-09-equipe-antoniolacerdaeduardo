public abstract class Conta {
    // atributos
    protected int numero;
    protected Cliente titular;
    protected double saldo;

    // metodos
    public Conta(int numero, Cliente titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
    }

    void depositar(double valor) {
        this.saldo = this.getSaldo() + valor;
    }

    public abstract boolean sacar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }


}