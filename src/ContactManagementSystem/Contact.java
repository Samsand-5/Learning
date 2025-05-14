package ContactManagementSystem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Contact
{
    private int id;
    private String name;
    private String phoneNumber;
    private String email;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    static Scanner sc = new Scanner(System.in);
    public Contact(int id, String name, String phoneNumber, String email)
    {
        this.id = id;
        setName(name); // validate name
        setPhoneNumber(phoneNumber); // validate phone
        setEmail(email); // validate email
    }
    public Contact()
    {

    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getEmail()
    {
        return email;
    }

    public boolean setName(String name)
    {
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        boolean isValid = name.matches(regex);
        if (isValid)
        {
            this.name = name;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean setPhoneNumber(String phoneNumber)
    {
        boolean isValid = phoneNumber.matches("^[6-9]\\d{9}$");
        if (isValid)
        {
            this.phoneNumber = phoneNumber;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean setEmail(String email)
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (matcher.matches())
        {
            this.email = email;
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public String toString()
    {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
