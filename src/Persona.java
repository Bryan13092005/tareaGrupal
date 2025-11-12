import java.util.ArrayList;
import java.util.Scanner;

public abstract class Persona {
    private String nombre,cedula,direccion,telefono;
    public void pedirDatos(Scanner datos){
        System.out.print("Ingrese el nombre: ");
        setNombre(datos.nextLine());
        System.out.print("Ingrese la cedula: ");
        setCedula(datos.nextLine());
        System.out.print("Direccion: ");
        setDireccion(datos.nextLine());
        System.out.print("Telefono: ");
        setTelefono(datos.nextLine());
    }
    private ArrayList<Cliente> clientes=new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void crearCliente(Cliente c){
        clientes.add(c);
    }

    public void actualizarDatos(Scanner datos){
        System.out.print("1.Actualizar nombre\n2.Actualizar cedula\n3.Actualizar direccion\n4.Actualizar telefono\nIngrese una opcion: ");
        int opcion= datos.nextInt();
        datos.nextLine();
        switch (opcion){
            case 1:
                setNombre(datos.nextLine());
            case 2:
                setCedula(datos.nextLine());
            case 3:
                setDireccion(datos.nextLine());
            case 4:
                setTelefono(datos.nextLine());
            default:
                System.out.println("Opcion Incorrecta");
        }
    }
    public abstract void mostrarRol();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
            try {
                if (nombre == null || nombre.trim().isEmpty()) {
                    this.nombre="nombre";
                    throw new Exception("Nombre incorrecto, Actualice el dato");
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
                throw new Exception("Cedula incorrecta, actualice el dato");
            }

            this.cedula = cedula;
            System.out.println("Cedula aceptada: " + this.cedula);
        } catch (Exception e) {
            return;
        }


    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        try {
            if (direccion == null || direccion.trim().isEmpty()) {
                throw new Exception("Cedula incorrecta, actualice el dato");
            }
            this.direccion = direccion;
            System.out.println("Cedula aceptada: " + this.direccion);
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
                throw new Exception("Telefono incorrecto, actualice el dato");
            }

            this.telefono = telefono;
            System.out.println("Telefono aceptado: " + this.telefono);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
