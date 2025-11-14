package Personas.subclasesEmpleado;

import Cuenta.Cuenta;
import Personas.Cliente;
import Personas.Empleado;

import java.util.InputMismatchException;
import java.util.Scanner;

import static ejecucion.Main.clientes;
import static ejecucion.Main.cuentas;

public class JefeAgencia extends Empleado {
    public JefeAgencia(String nombre, String cedula, String direccion, String telefono, String clave,String rol) {
        super(nombre, cedula, direccion, telefono, clave,rol);
    }

    public void menuJefeAgencia(Scanner datos){
        do {
            try {
                System.out.println("______________MENU JEFE AGENCIA____________");
                System.out.print("1.Aprobar prestamos\n2.Generar Reporte\n3.Crear Empleado\n4.Cerrar sesion\nIngrese una opcion: ");
                int opcion = datos.nextInt();
                datos.nextLine();
                switch (opcion) {
                    case 1:
                        char prestamo;
                        for (Cliente c : clientes) {
                            if (c.getSolicitarPrestamo()) {
                                for (Cuenta cu : cuentas) {
                                    System.out.println("MOSTRANDO INFORMACION");
                                    System.out.println("Cedula del usuario: "+cu.getCedula());
                                    if (c.getCedula().equals(cu.getCedula())) {
                                        System.out.println("Nombre usuario: "+c.getNombre());
                                        System.out.println("Monto: $"+c.getP());
                                        System.out.print("Desea aprobar el prestamo? (S/N): ");
                                        prestamo=datos.next().toUpperCase().charAt(0);
                                        if (prestamo=='S'){
                                            cu.deposito(c.getP());
                                            System.out.println("Prestamo realizado con exito a " + c.getNombre()+"\n Monto: $"+c.getP());
                                            c.setSolicitarPrestamo(false);
                                            c.setP(0.00);
                                        }else{
                                            System.out.println("Prestamo no aprobado");
                                            c.setSolicitarPrestamo(false);
                                            c.setP(0.00);
                                        }

                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        boolean encontrado = false;
                        System.out.print("Ingrese la cedula de la cuenta: ");
                        String cedula = datos.nextLine();
                        for (Cliente c : clientes) {
                            if (cedula.equals(c.getCedula())) {
                                System.out.println(c);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No encontrado");
                        }
                        break;
                    case 3:
                        Empleado e = new Empleado();
                        e.pedirDatos(datos);
                        validacionCreacionEmpleados(e);
                        break;
                    case 4:
                        System.out.println("Cerrando sesion");
                        return;
                    default:
                        System.out.println("Ingreso erroneo");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("⚠️ Error: Debes ingresar un número válido.");
                datos.nextLine();
            }
        }while (true);
    }
}
