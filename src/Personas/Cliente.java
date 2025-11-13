package Personas;
import Cuenta.Cuenta;

import java.util.Objects;
import java.util.Scanner;
import static ejecucion.Main.cuentas;
import static ejecucion.Main.clientes;

public class Cliente extends Persona {
    private boolean cuenta=false;
    private boolean solicitarPrestamo=false;
    private double p;
    public Cliente(String nombre,String cedula,String direccion,String telefono){
        super(nombre,cedula,direccion,telefono);
    }

    public Cliente(){}

    @Override
    public void pedirDatos(Scanner datos) {
        System.out.println("--------------MENU CLIENTE-------------");
        System.out.print("Ingrese el nombre: ");
        setNombre(datos.nextLine());
        System.out.print("Ingrese la cedula: ");
        setCedula(datos.nextLine());
        System.out.print("Direccion: ");
        setDireccion(datos.nextLine());
        System.out.print("Telefono: ");
        setTelefono(datos.nextLine());
    }

    public void setCuenta(boolean cuenta) {
        this.cuenta = cuenta;
    }

    public void setSolicitarPrestamo(boolean solicitarPrestamo) {
        this.solicitarPrestamo = solicitarPrestamo;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getP() {
        return p;
    }

    public boolean getSolicitarPrestamo() {
        return solicitarPrestamo;
    }

    public boolean getCuenta() {
        return cuenta;
    }


    @Override
    public String toString() {
        String mensaje ="Cliente\n" +
        "Nombre: "+ getNombre()+
                "\nCedula: "+getCedula()+
                "\nCuenta: "+getCuenta();
        if (getCuenta()){
            for (Cuenta c:cuentas){
                if (getCedula().equals(c.getCedula())) {
                    double saldo = c.getSaldo();
                    String tipo=c.getTipo();
                    mensaje+="\nSaldo: "+saldo+
                            "\nTipo de Cuenta: "+tipo;
                }
            }
        }
        return mensaje;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Usted es un cliente");
    }

    public static void validacionCreacionClientes(Cliente cliente1){
        if (cliente1.getNombre() == null ||
                cliente1.getCedula() == null ||
                cliente1.getDireccion() == null ||
                cliente1.getTelefono() == null){
            System.out.println("El cliente no puede ser creado");
            return;
        }
        for(Cliente c:clientes){
            if(c.getCedula().equals(cliente1.getCedula())){
                System.out.println("El cliente ya existe");
                return;
            }
        }
        clientes.add(cliente1);
        System.out.println("Agregado con exito");
    }

    public void crearCuenta(){
        if (this.cuenta){
            System.out.println("Ya tienes una cuenta");
        }else {
            Cuenta cuenta1=new Cuenta();
            cuenta1.nombrePropietario=getNombre();
            cuenta1.setTipo("Ahorros");
            cuenta1.setCedula(getCedula());
            this.cuenta=true;
            cuentas.add(cuenta1);
            System.out.println("Creado Correctamente");
        }
    }

    public void prestamo(Scanner datos) {
        if (!this.cuenta) {
            System.out.println("Para solicitar un préstamo primero debes crear una cuenta");
            return;
        }

        boolean encontrado = false;

        for (Cuenta c : cuentas) {
            if (Objects.equals(c.getCedula(), getCedula())) {
                encontrado = true;

                if (solicitarPrestamo) {
                    System.out.println("Ya solicitó un préstamo");
                    break;
                }

                System.out.print("Monto del préstamo: $");
                setP(datos.nextDouble());
                datos.nextLine();

                if (p > 0) {
                    System.out.println("Su solicitud de préstamo fue generada. Si es aprobada, lo verá reflejado en su cuenta.");
                    solicitarPrestamo = true;
                } else {
                    System.out.println("Valor inválido. Debe ser mayor que 0.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void menuClientes(Scanner datos){
        do {
            System.out.print("1.Ver tu saldo\n2.Abrir Cuenta Bancaria\n3.Solicitar Prestamo\n4.Salir\nIngrese una opcion: ");
            int opcion = datos.nextInt();
            datos.nextLine();
            boolean encontrado=false;
            switch (opcion) {
                case 1:
                    if (this.cuenta) {
                        for (Cuenta c : cuentas) {
                            if (Objects.equals(c.getCedula(), getCedula())) {
                                System.out.println("Saldo: "+c.getSaldo());
                                encontrado=true;
                                break;
                            }
                        }

                         if(!encontrado) {
                            System.out.println("Cuenta no encontrada");
                         }
                    } else {
                        System.out.println("Para ver tu saldo primero debes crear una cuenta");
                    }
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    prestamo(datos);
                    break;
                case 4:
                    System.out.println("Regresando al menu principal");
                    return;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while (true);
    }

}