public class Cliente {

    private int id, telefono, edad;
    private String nombre, apellido, dni, correo;
    private int[] tramites;


    public Cliente(int i, String s, String naiara, String gonzalez, int i1, int i2, String s1) {
    }

    public Cliente(int id, String dni, String nombre, String apellido, int edad, int telefono, String correo, int[] tramites) {
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.tramites = tramites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int[] getTramites() {
        return tramites;
    }

    public void setTramites(int[] tramites) {
        this.tramites = tramites;
    }

    public String mostrarDatos(){
        String mensaje;
        mensaje = ("ID: " + id +
                "\nDNI: " + dni +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nEdad: " + edad +
                "\nTelefono: : " + telefono +
                "\nCorreo: " + correo +
                "\nNumero de tramites: " + tramites.length + "\n");
        return mensaje;
    }
}


