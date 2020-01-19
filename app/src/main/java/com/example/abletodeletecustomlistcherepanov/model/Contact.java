package com.example.abletodeletecustomlistcherepanov.model;

public class Contact implements Comparable<Contact> {
    private String contactName;
    private String contactNumber;

    public Contact(String contactName, String contactNumber, boolean checked) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public int compareTo(Contact o) {
        if(o == null) {
            return 1;
        }
        if(this.getContactName().compareTo(o.getContactName()) == 1) {
            return 1;
        } else if(this.getContactName().compareTo(o.getContactName()) == -1) {
            return -1;
        }
        return 0;
    }
}
