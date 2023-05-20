package proekt.model;

public class User {
        private long Id;
        private String name;
        private String dateBirthday; //Заменить на date?
        private long Phone;
        private double salary;
        private long idDepartment;


        public User(String name, String dateBirthday, long Id, long Phone, double salary, long idDepartment) {
            this.name = name;
            this.dateBirthday = dateBirthday;
            this.Id = Id;
            this.Phone = Phone;
            this.salary = salary;
            this.idDepartment = idDepartment;
        }

        public User() {
            this.name = "";
            this.dateBirthday = "";
            this.Id = 0;
            this.Phone  = 0;
            this.salary = 0;
            this.idDepartment = 0;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDateBirthday() {
            return dateBirthday;
        }

        public void setDateBirthday(String dateBirthday) {
            this.dateBirthday = dateBirthday;
        }

        public long getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public long getPhone() {
            return Phone;
        }

        public void setPhone(long phone) {
            Phone = phone;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public long getIdDepartment() {
            return idDepartment;
        }

        public void setIdDepartment(long idDepartment) {
            this.idDepartment = idDepartment;
        }

        public String toString() {
            return "Id: " + getId() + "; name: " + getName() + "; dateBirthday: " + getDateBirthday()  +
                    "; Phone: " + getPhone() + "; salary: " + getSalary() + "; idDepartament: " + getIdDepartment();
        }
}
