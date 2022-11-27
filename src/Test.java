public class Test {
    public static void main(String[] args) {

    EmailApplication employee1 = new EmailApplication();
    employee1.name("Gabriel","Necula");
    employee1.NewHire("1990215040080");
        System.out.println();
    employee1.generateDepartment();
    employee1.generateCompanyAddress();
    employee1.generatePassword();
    employee1.assignComputerOrPhone();
    employee1.changePassword("here_input_new_password");
    employee1.alternateEmailAddress("gabriel_nicolae1999@gmail.com");

        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println();
    EmailApplication employee2 = new EmailApplication();
    employee2.name("Ioana","Pantea");
    employee2.NewHire("2950922070050");
    System.out.println();
    employee2.generateDepartment();
    employee2.generateCompanyAddress();
    employee2.generatePassword();
    employee2.assignComputerOrPhone();
    employee2.changePassword("here_input_new_password");
    employee2.alternateEmailAddress("ioana.pantea78@yahoo.com");
    System.out.println();
    System.out.println("-------------------------------------------------------");
    System.out.println();
    EmailApplication employee3 = new EmailApplication();
    employee3.name("Marius","Ioan");
    employee3.NewHire("1901030020020");
    System.out.println();
    employee3.generateDepartment();
    employee3.generateCompanyAddress();
    employee3.generatePassword();
    employee3.assignComputerOrPhone();
    employee3.changePassword("here_input_new_password");
    employee3.alternateEmailAddress("marius90@gmail.com");
    }

}
