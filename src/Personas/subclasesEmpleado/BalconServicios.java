package Personas.subclasesEmpleado;

import Personas.Cliente;
import Personas.Empleado;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Personas.Cliente.validacionCreacionClientes;
import static ejecucion.Main.clientes;

public class BalconServicios extends Empleado {
    public BalconServicios(String nombre, String cedula, String direccion, String telefono, String clave, String rol) {
        super(nombre, cedula, direccion, telefono, clave,rol);
    }

    public void menuBalcon(Scanner datos){
        try {
            System.out.println("______________MENU BALCON SERVICIOS____________");
            System.out.print("1.Registrar nuevo cliente\n2.Actualizar datos cliente\n3.Cerrar Sesion\nIngresa una opcion: ");
            int opcion = datos.nextInt();
            datos.nextLine();
            switch (opcion) {
                case 1:
                    Cliente cliente1 = new Cliente();
                    cliente1.pedirDatos(datos);
                    validacionCreacionClientes(cliente1);
                    break;
                case 2:
                    String ingreso;
                    boolean encontrado = false;
                    System.out.print("Buscar por nombre o cedula (N/C): ");
                    char eleccion = datos.next().toUpperCase().charAt(0);
                    datos.nextLine();
                    if (eleccion == 'N') {
                        System.out.print("Ingrese el nombre: ");
                        ingreso = datos.nextLine();
                        for (Cliente c : clientes) {
                            if (c.getNombre().equals(ingreso)) {
                                c.actualizarDatos(datos);
                                encontrado = true;
                                break;
                            }
                        }
                    } else if (eleccion == 'C') {
                        System.out.print("Ingrese la cedula");
                        ingreso = datos.nextLine();
                        for (Cliente c : clientes) {
                            if (ingreso.length() == 10 && ingreso.equals(c.getCedula())) {
                                c.actualizarDatos(datos);
                                encontrado = true;
                                break;
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Nombre o cedula no encontrados");
                    }
                    break;
                case 3:
                    System.out.println("Cerrando Sesion...");
                    return;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("⚠️ Error: Debes ingresar un número válido.");
            datos.nextLine();
        }
    }
}
