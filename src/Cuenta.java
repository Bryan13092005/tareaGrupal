public class Cuenta {
    public String nombre;
    private double saldo=0.00;
    private String tipo;


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void retiro(double monto){
        if (saldo>=monto){
            saldo-=monto;
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    public void deposito(double monto){
        if (monto>0){
            saldo+=monto;
            System.out.println("Transaccion exitosa");
        }else {
            System.out.println("Monto incorrecto");
        }
    }
}
