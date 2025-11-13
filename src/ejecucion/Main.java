package ejecucion;

import Cuenta.Cuenta;
import Personas.Cliente;
import Personas.Empleado;
import Personas.subclasesEmpleado.BalconServicios;
import Personas.subclasesEmpleado.Cajero;
import Personas.subclasesEmpleado.JefeAgencia;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import static Personas.Cliente.validacionCreacionClientes;

public class Main {
    public static ArrayList<Empleado> empleados=new ArrayList<>();
    public static ArrayList<Cliente> clientes=new ArrayList<>();
    public static ArrayList<Cuenta> cuentas=new ArrayList<>();
    public static ArrayList<Cajero> cajeros=new ArrayList<>();
    public static ArrayList<BalconServicios> balconesServicios=new ArrayList<>();
    public static ArrayList<JefeAgencia> jefesAgencias=new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        System.out.println("CREANDO EMPLEADO DEFAUTL");
        Empleado eDefalult=new Empleado("BRYAN SALVADOR","1753655172","SUR","0987654321","root","Jefe Agencia");
        empleados.add(eDefalult);
        System.out.println("AÑADIENDO JEFE DE AGENCIA PRINCIPAL");
        JefeAgencia empleadoD=new JefeAgencia("BRYAN SALVADOR","1753655172","SUR","0987654321","root","Jefe Agencia");
        jefesAgencias.add(empleadoD);
        do {
            try {
                System.out.println("------------MENU PRINCIPAL---------------");
                System.out.print("1.Registrar cliente\n2.Ingresar como cliente\n3.Ingresar como empleado\n0. Salir\nIngrese la opcion: ");
                int opcionMenuPrincipal = datos.nextInt();
                datos.nextLine();
                boolean encontrado = false;
                switch (opcionMenuPrincipal) {
                    case 1:
                        Cliente cliente1 = new Cliente();
                        cliente1.pedirDatos(datos);
                        validacionCreacionClientes(cliente1);
                        break;
                    case 2:
                        String cedulaIngresada;
                        System.out.print("Ingresa tu cedula: ");
                        cedulaIngresada = datos.nextLine();
                        for (Cliente c : clientes) {
                            if (c.getCedula().equals(cedulaIngresada)) {
                                System.out.println("Bienvenido " + c.getNombre());
                                c.menuClientes(datos);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("El usuario no existe");
                        }
                        break;
                    case 3:
                        String claveIngresada, usuario;
                        System.out.print("Ingresa tu cedula: ");
                        usuario = datos.nextLine();
                        System.out.print("Ingresa tu clave: ");
                        claveIngresada = datos.nextLine();
                        for (Empleado e : empleados) {
                            if (e.getClave().equals(claveIngresada) && e.getCedula().equals(usuario)) {
                                System.out.println("Bienvenido " + e.getNombre());
                                e.menuEmpleados(datos);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("El empleado no existe");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo");
                        return;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } catch (InputMismatchException e) {
            System.out.println("⚠️ Error: Debes ingresar un número válido.");
            datos.nextLine();
        }
        }while (true);

    }
}