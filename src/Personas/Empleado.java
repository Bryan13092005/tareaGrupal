package Personas;
import Personas.subclasesEmpleado.BalconServicios;
import Personas.subclasesEmpleado.Cajero;
import Personas.subclasesEmpleado.JefeAgencia;

import java.util.Scanner;

import static ejecucion.Main.*;

public class Empleado extends Persona {
    Scanner datos = new Scanner(System.in);
    private String clave, rol;
    public Empleado(String nombre,String cedula,String direccion,String telefono,String clave,String rol){
        super(nombre,cedula,direccion,telefono);
        this.clave=clave;
        this.rol=rol;
    }
    public Empleado(){
        super();
    }

    @Override
    public void pedirDatos(Scanner datos) {
        System.out.println("----------EMPLEADO-----------");
        System.out.print("Ingrese el nombre: ");
        setNombre(datos.nextLine());
        System.out.print("Ingrese la cedula: ");
        setCedula(datos.nextLine());
        System.out.print("Direccion: ");
        setDireccion(datos.nextLine());
        System.out.print("Telefono: ");
        setTelefono(datos.nextLine());
        System.out.println("Cual es el rol de empleado?");
        System.out.print("ROLES:\n1.Cajero\n2.Balcon\n3.Jefe Agencia\nIngrese una opcion: ");
        setRol(datos.nextInt());
        datos.nextLine();
        System.out.print("Ingrese su clave: ");
        setClave(datos.nextLine());
    }

    public void setRol(int opcionRol) {
        if(opcionRol==1){
            this.rol = "Cajero";
        }else if(opcionRol==2){
            this.rol="Balcon";
        }else if(opcionRol==3){
            this.rol="Jefe Agencia";
        }else{
            System.out.println("Opcion invalida");
            this.rol=null;
        }
    }

    public String getRol() {
        return rol;
    }

    public void setClave(String clave) {
        try{
            if (clave.trim().isEmpty()){
                this.clave=null;
                throw new Exception("Clave invalida");
            }else{
                this.clave = clave;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }

    public String getClave() {
        return clave;
    }

    @Override
    public void mostrarRol() {

    }

    public static void validacionCreacionEmpleados(Empleado e1){
        if (e1.getNombre() == null ||
                e1.getCedula() == null ||
                e1.getDireccion() == null ||
                e1.getTelefono() == null||
                e1.getRol()==null){
            System.out.println("El Empleado no puede ser creado");
            return;
        }
        for(Empleado e:empleados){
            if(e.getCedula().equals(e1.getCedula())){
                System.out.println("El empleado ya existe");
                return;
            }
        }
        if(e1.getRol().equals("Cajero")){
            Cajero c1=new Cajero(e1.getNombre(),e1.getCedula(),e1.getDireccion(),e1.getTelefono(),e1.getClave(),e1.getRol());
            cajeros.add(c1);
        }else if(e1.getRol().equals("Balcon")){
            BalconServicios balcon=new BalconServicios(e1.getNombre(),e1.getCedula(),e1.getDireccion(),e1.getTelefono(),e1.getClave(),e1.getRol());
            balconesServicios.add(balcon);
        }else{
            JefeAgencia jefeAgencia =new JefeAgencia(e1.getNombre(),e1.getCedula(),e1.getDireccion(),e1.getTelefono(),e1.getClave(),e1.getRol());
            jefesAgencias.add(jefeAgencia);
        }
        empleados.add(e1);
        System.out.println("Agregado con exito");
    }

    public void menuEmpleados(Scanner datos){
        do {
            System.out.println("______________MENU INGRESO EMPLEADOS____________");
            System.out.print("1.Cajero\n2.Balcon\n3.Jefe Agencia\n4.Regresar\nIngresa tu rol: ");
            int opcion= datos.nextInt();
            datos.nextLine();
            boolean entrar=false;
            switch (opcion) {
                case 1:
                    for (Cajero c : cajeros) {
                        if (c.getRol().equals("Cajero")) {
                            System.out.println("ACCESO CONCEDIDO BIENVENIDO " + c.getNombre());
                            entrar=true;
                            c.menuCajeros(datos);
                            break;
                        }
                    }
                    if(!entrar){
                        System.out.println("Rol incorrecto");
                    }
                    break;
                case 2:
                    for(BalconServicios b:balconesServicios){
                        if (b.getRol().equals("Balcon")){
                            System.out.println("ACCESO CONCEDIDO BIENVENIDO "+b.getNombre());
                            entrar=true;
                            b.menuBalcon(datos);
                            break;
                        }
                    }
                    if(!entrar){
                        System.out.println("Rol incorrecto");
                    }
                    break;
                case 3:
                    for(JefeAgencia j:jefesAgencias){
                        if (j.getRol().equals("Jefe Agencia")){
                            System.out.println("ACCESO CONCEDIDO BIENVENIDO "+j.getNombre());
                            entrar=true;
                            j.menuJefeAgencia(datos);
                            break;
                        }
                    }
                    if(!entrar){
                        System.out.println("Rol incorrecto");
                    }
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