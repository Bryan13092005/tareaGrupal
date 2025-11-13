package Cuenta;

public class Cuenta {
    public String nombrePropietario;
    private double saldo=0.00;
    private String tipo,cedula;


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTipo() {
        return tipo;
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

    public double getSaldo() {
        return saldo;
    }
}
