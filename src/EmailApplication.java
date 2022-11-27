import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailApplication {
    //(sales, development, accounting)
    private int phone;
    private int pc;

    private String cnp;
    private String sales = "sales";
    private String development = "development";
    private String accounting = "accounting";

    private String department;
    private String company = "strauss.com";
    private String addres;
    private String password;

    private int mailBoxCapacity = 0;
    private String alternativAddres;
    private String fullName;

    public void generateDepartment() {
        int randomDepartment = (int) (Math.random() * 3);
        switch (randomDepartment) {
            case 0:
                if (randomDepartment == 0) {
                    this.sales = sales;
                }
                break;
            case 1:
                if (randomDepartment == 1) {
                    this.development = development;
                }
                break;
            case 2:
                if (randomDepartment == 2) {
                    this.accounting = accounting;
                }
                break;
        }
        if (randomDepartment == 0) {
            department = sales;
        } else if (randomDepartment == 1) {
            department = development;
        } else if (randomDepartment == 2) {
            department = accounting;
        }

        System.out.println("Department : "+department);
    }
    public void assignComputerOrPhone() {
        String lowerLetters = "abcdefghijklmnopqrstuvxyz";
        String digits = "0123456789";
        int sizePc=10;
        int sizePhone=8;

        if (department == development) {
            String pcGenerated = digits + lowerLetters;
            char[] pc = new char[sizePc];
            Random random = new Random();
            for (int i = 0; i < sizePc; i++) {
                pc[i] = pcGenerated.charAt(random.nextInt(pcGenerated.length()));
            }
            System.out.println("Your computer's serial number is : "+String.valueOf(pc));
            this.phone= Integer.parseInt(String.valueOf(phone));

        } else if (department == sales || department == accounting) {
            String phoneGenerated = digits ;
            char[] phone = new char[sizePhone];
            Random random = new Random();
            for (int i = 0; i < sizePhone; i++) {
                phone[i] = phoneGenerated.charAt(random.nextInt(phoneGenerated.length()));
            }
            System.out.println("Your phone number is : 07"+String.valueOf(phone));

            this.phone= Integer.parseInt(String.valueOf(phone));
        }

    }
    public void name(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
        this.addres=firstName+"."+lastName;
        System.out.println("Name : "+ fullName);
    }
    public void generateCompanyAddress(){
        System.out.println("The company addres is: "+ addres.toLowerCase(Locale.ROOT)+"@"+department+"."+company);
    }

    public String generatePassword() {

        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvxyz";
        String digits = "0123456789";
        String specialChar = "!@#$%^&*?+";
        String allChars = upperLetters + lowerLetters + digits + specialChar;

        Random random = new Random();
        int length = random.nextInt(6) + 6;
        char[] password = new char[length];

        password[0] = lowerLetters.charAt(random.nextInt(lowerLetters.length()));
        password[1] = upperLetters.charAt(random.nextInt(upperLetters.length()));
        password[2] = specialChar.charAt(random.nextInt(specialChar.length()));
        password[3] = digits.charAt(random.nextInt(digits.length()));

        for (int i = 4; i < length; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }

        this.password = String.valueOf(password);
        System.out.println("Automatically generated password is : " + String.valueOf(password));
        return this.password;
    }

    public void changePassword(String newPassword) {
        if (newPassword.length() >= 6) {
            password = newPassword;
            System.out.println("The new password is : " + newPassword);
        } else if (newPassword.length() < 5) {
            System.out.println("The password is too short, " +
                    "the minimum number of characters is 6");
        }
    }

    public void alternateEmailAddress(String alternativeGmailAddress) {
        String email_pattern = "[\\w]*@*[a-z]*\\.*[\\w]{5,}(\\.)*(com)*(@gmail\\.com)";
        Pattern pat = Pattern.compile(email_pattern);
        Matcher mat = pat.matcher(alternativeGmailAddress);
        if (mat.matches()) {
            System.out.println("The gmail address is valid");
            this.alternativAddres = alternativeGmailAddress;
        } else if (!mat.matches()) {
            System.out.println("The alternative address is not valid because it is not gmail");
        }

    }
    public void NewHire(String cnp) {
        boolean hasDigits = true;
        for (int i = 0; i < cnp.length(); i++) {
            if (!Character.isDigit(cnp.charAt(i))) {
                hasDigits = false;}
        }
        if (cnp.length() != 13 || !hasDigits || !verifyFormatMonth(cnp) || !verifyFormatYear(cnp)) {
            System.out.println("This cnp is invalid!");}
        else if (showAge(cnp) < 18) {
            System.out.println("The employee is under 18 and cannot be hired.");}
        else {
            this.cnp = cnp;
            mailBoxCapacity = 300;}
    }


    static int calcAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }
    public static int showAge(String cnp) {
        char result1 = cnp.charAt(1);
        char result2 = cnp.charAt(2);

        String year19__ = "19" + result1 + result2;
        String year20__ = "20" + result1 + result2;
        String month = String.valueOf(cnp.charAt(3)) + cnp.charAt(4);
        String day = String.valueOf(cnp.charAt(5)) + cnp.charAt(6);

        String string19__ = year19__ + "-" + month + "-" + day;
        String string20__ = year20__ + "-" + month + "-" + day;

        char s = cnp.charAt(0);
        LocalDate dateOfBirth = null;
        if (s == '1' || s == '2') {
            dateOfBirth = LocalDate.parse(string19__);
            System.out.format("The age is : "+calcAge(dateOfBirth));
        }
        else if (s == '5' || s == '6') {
            dateOfBirth = LocalDate.parse(string20__);
            System.out.format("The age is : "+calcAge(dateOfBirth));}
        return calcAge(dateOfBirth);
    }


    public static boolean verifyFormatYear(String cnp){
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            String year = cnp.substring(1, 3);
            int yearAsInt = Integer.parseInt(year);
            return yearAsInt >= 0 && yearAsInt <= 99;}
        else if (cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            String year = cnp.substring(1, 3);
            int yearAsInt = Integer.parseInt(year);
            return yearAsInt >= 0 && yearAsInt <= 21; }
        return false;
    }
    public static boolean verifyFormatMonth(String cnp) {
        String year = cnp.substring(1,3);
        int yearAsInt = Integer.parseInt(year);
        String month = cnp.substring(3,5);
        int monthAsInt = Integer.parseInt(month);
        String day= cnp.substring(5,7);
        int dayAsInt = Integer.parseInt(day);
        if(monthAsInt <1 || monthAsInt >12){
            return false;}
        else {
            if(monthAsInt == 1 ||monthAsInt == 3 ||monthAsInt == 5 ||monthAsInt == 7 ||
                    monthAsInt == 8 ||monthAsInt == 10 ||monthAsInt == 12){
                return  dayAsInt >= 1 && dayAsInt <=31;}
            else if (monthAsInt == 4 ||monthAsInt == 6 ||monthAsInt == 9 ||monthAsInt == 11){
                return  dayAsInt >= 1 && dayAsInt <=30;}
            else {
                if (yearAsInt%4 == 0){
                    return dayAsInt >=1 && dayAsInt <= 29;}
                else {
                    return dayAsInt >=1 && dayAsInt <= 28;}
            }
        }
    }

    }

