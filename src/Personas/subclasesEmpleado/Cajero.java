package Personas.subclasesEmpleado;

import Cuenta.Cuenta;
import Personas.Empleado;
import static ejecucion.Main.cuentas;
import static ejecucion.Main.clientes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cajero extends Empleado {
    public Cajero(String nombre, String cedula, String direccion, String telefono, String clave,String rol) {
        super(nombre, cedula, direccion, telefono, clave,rol);
    }

    public void menuCajeros(Scanner datos){
        do {
            try {
                System.out.println("______________MENU CAJERO____________");
                System.out.print("1.Depositar\n2.Retirar\n3.Cerrar Cuenta\n4.Cerrar Sesion\nIngrese una opcion: ");
                int opcion = datos.nextInt();
                datos.nextLine();
                String cedula="";
                boolean encontrado = false;
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el numero de cedula de la cuenta: ");
                        cedula = datos.nextLine();
                        for (Cuenta c : cuentas) {
                            if (!cedula.trim().isEmpty() && cedula.length() == 10 && cedula.trim().equals(c.getCedula())) {
                                System.out.print("Ingrese el monto a dopsitar: $");
                                c.deposito(datos.nextDouble());
                                datos.nextLine();
                                System.out.println("Deposito exitoso");
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Cuenta no encontrada");
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese el numero de cedula de la cuenta: ");
                        cedula = datos.nextLine();
                        for (Cuenta c : cuentas) {
                            if (!cedula.trim().isEmpty() && cedula.length() == 10 && cedula.trim().equals(c.getCedula())) {
                                System.out.print("Ingrese el monto a retirar: $");
                                c.retiro(datos.nextDouble());
                                datos.nextLine();
                                System.out.println("Retiro exitoso");
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Cuenta no encontrada");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el numero de cedula de la cuenta: ");
                        cedula = datos.nextLine();
                        for (int i = 0; i < cuentas.size(); i++) {
                            if (!cedula.trim().isEmpty() && cedula.length() == 10 && cedula.trim().equals(cuentas.get(i).getCedula())) {
                                System.out.print("Esta seguro de eliminar la cuenta? con un saldo de : " + cuentas.get(i).getSaldo() + " (S/N)");
                                char desicion = datos.next().toUpperCase().charAt(0);
                                datos.nextLine();
                                if (desicion == 'S') {
                                    String cedulaCuenta = cuentas.get(i).getCedula();
                                    cuentas.remove(i);
                                    for (int j = 0; j < clientes.size(); j++) {
                                        if (cedulaCuenta.equals(clientes.get(j).getCedula())) {
                                            clientes.get(j).setCuenta(false);
                                            break;
                                        }
                                    }
                                    System.out.println("Eliminacion exitosa");
                                    encontrado = true;
                                    break;
                                }
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Cuenta no encontrada");
                        }
                        break;
                    case 4:
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
        }while (true);
    }
}
