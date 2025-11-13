package Personas;
import java.util.Scanner;

import static ejecucion.Main.clientes;

public abstract class Persona {
    private String nombre,cedula,direccion,telefono;

    public Persona(String nombre,String cedula,String direccion,String telefono){
        setNombre(nombre);
        setCedula(cedula);
        setDireccion(direccion);
        setTelefono(telefono);
    }

    public Persona() {}

    public abstract void pedirDatos(Scanner datos);

    public void actualizarDatos(Scanner datos){
        System.out.println("______________MENU ACTUALIZACION DE DATOS____________");
        System.out.print("1.Actualizar nombre\n2.Actualizar cedula\n3.Actualizar direccion\n4.Actualizar telefono\n5.Regresasr\nIngrese una opcion: ");
        int opcion= datos.nextInt();
        datos.nextLine();
        switch (opcion){
            case 1:
                setNombre(datos.nextLine());
                break;
            case 2:
                setCedula(datos.nextLine());
                break;
            case 3:
                setDireccion(datos.nextLine());
                break;
            case 4:
                setTelefono(datos.nextLine());
                break;
            case 5:
                System.out.println("Saliendo");
                return;
            default:
                System.out.println("Opcion Incorrecta");
                break;
        }
    }
    public abstract void mostrarRol();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
            try {
                if (nombre == null || nombre.trim().isEmpty()) {
                    this.nombre=null;
                    throw new Exception("Nombre incorrecto");
                }

                this.nombre = nombre.toUpperCase();
                System.out.println("Nombre asignado correctamente: " + this.nombre);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        try {
            if (cedula == null || cedula.trim().isEmpty() || cedula.length()!=10) {
                this.cedula=null;
                throw new Exception("Cedula incorrecta");
            } else{
                for(Cliente c:clientes){
                    if (c.getCedula().equals(cedula)){
                        System.out.println("El usuario ya existe");
                        this.cedula=null;
                    }
                }
            }

            this.cedula = cedula;
            System.out.println("Cedula aceptada: " + this.cedula);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        try {
            if (direccion == null || direccion.trim().isEmpty()) {
                this.direccion=null;
                throw new Exception("Direccion incorrecta");
            }
            this.direccion = direccion.toUpperCase();
            System.out.println("Direccion aceptada: " + this.direccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        try {
            if (telefono == null || telefono.trim().isEmpty() || telefono.length()!=10) {
                this.telefono=null;
                throw new Exception("Telefono incorrecto");
            }

            this.telefono = telefono;
            System.out.println("Telefono aceptado: " + this.telefono);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }


}
