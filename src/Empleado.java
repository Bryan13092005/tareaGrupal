import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Empleado extends Persona{
    Scanner datos=new Scanner(System.in);
    @Override
    public void mostrarRol() {
        System.out.println("Usted es empleado");
    }
    private ArrayList <Empleado> empleados =new ArrayList<>();
    private ArrayList <Cuenta> cuentas= new ArrayList<>();


    public void crearEmpleado(Empleado e){
        empleados.add(e);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }



    public boolean autenticarEmpleado(String usuario, String clave){
    }
    public void crearCuentaParaCliente(Cliente cliente, String tipo){}
    public void modificarDatosCliente(Cliente cliente){}
    public void registrarPrestamo(Cliente cliente, double monto){}
    public void cerrarCuenta(Cliente cliente, Cuenta cuenta){}

    public class Cajero extends Empleado{
        @Override
        public void crearCuentaParaCliente(Cliente cliente, String tipo) {
            Cuenta c1=new Cuenta();
            c1.nombre=cliente.getNombre();
            c1.setTipo(tipo);
            cuentas.add(c1);
        }

        public void procesarRetiro(){
            System.out.print("Nombre del cliente: ");
            String nombre=datos.nextLine();
            for (int i=0;i<cuentas.size();i++){
                if(Objects.equals(cuentas.get(i).nombre, nombre)){
                    System.out.print("Ingrese el monto a retirar: $");
                    double monto= datos.nextDouble();
                    datos.nextLine();
                    cuentas.get(i).retiro(monto);
                }else{
                    System.out.println("Cuenta no encontrada");
                }
            }
        }

        public void

        @Override
        public void registrarPrestamo(Cliente cliente, double monto) {
            cliente.getNombre();
        }

        @Override
        public void modificarDatosCliente(Cliente cliente) {
            cliente.actualizarDatos(datos);
        }


    }
}
