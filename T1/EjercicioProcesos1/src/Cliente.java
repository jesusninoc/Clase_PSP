public class Cliente {
        int id, telefono, edad;
        String nombre, apellido, dni, correo;

        public Cliente() {
        }

        public Cliente(int id, String dni, String nombre, String apellido, int edad, int telefono, String correo) {
            this.id = id;
            this.telefono = telefono;
            this.edad = edad;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.correo = correo;
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

        public void mostrarDatos() {
            System.out.println("ID: " + id + "\n" +
                    "DNI: " + dni + "\n" +
                    "Nombre: " + nombre + "\n" +
                    "Apellido: " + apellido + "\n" +
                    "Edad: " + edad + "\n" +
                    "Telefono: : " + telefono + "\n" +
                    "Correo: " + correo + "\n");
        }

    }
