package cleaning.model;

import java.util.*;

public class Cleaner {
    private  String name;
    private  String address;
    private  String contactInfo;
    private final int ID;


    public Cleaner(String name, String address, String contactInfo, int ID) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
        this.ID = ID;

        if (ID <= 0){
            throw new IllegalArgumentException ("ID cannot be negative");
        } else if (name == null || name.isEmpty() || !name.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException ("Name cannot be empty or contain numbers");
        } else if (address == null || address.isEmpty() ){
            throw new IllegalArgumentException ("Address cannot be empty");
        } else if (contactInfo == null || contactInfo.isEmpty() || !contactInfo.matches("[0-9,A-Za-z]+")){
            throw new IllegalArgumentException("Contact info cannot be empty or contain special characters");
        }
    }


    public int getID() {
        return ID;
    }





    @Override // Override the toString method
    public String toString() {
    return "Cleaner " +
            "Name: '" + name + '\'' + ", Address: '" + address + '\'' + ", ContactInfo: '" + contactInfo +
            '\'' + ", ID: " + ID + '.';
}
}

