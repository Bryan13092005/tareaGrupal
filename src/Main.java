import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        System.out.print("1.Registrar cliente\n2.Ingresar como cliente\n3.Ingresar como empleado\nIngrese la opcion: ");
        int opcionMenuPrincipal=datos.nextInt();
        datos.nextLine();
        switch (opcionMenuPrincipal){
            case 1:
                Cliente cliente=new Cliente();
                cliente.pedirDatos(datos);
                cliente.crearCliente(cliente);
            case 2:
                System.out.print("Ingrese su usuario: ");
                String usuario=datos.nextLine();
                System.out.print("Ingrese su clave: ");
                String clave=datos.nextLine();

        }

    }
}