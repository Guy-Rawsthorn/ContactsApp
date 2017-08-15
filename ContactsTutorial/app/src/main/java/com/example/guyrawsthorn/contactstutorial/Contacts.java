package com.example.guyrawsthorn.contactstutorial;

/**
 * Created by guyrawsthorn on 14/08/2017.
 */

public class Contacts {


        String firstName;
        String surName;
        String email;
        String number;
        int id;

        public Contacts(String firstName, String surName, String email, String number) {
            super();
            this.firstName = firstName;
            this.surName = surName;
            this.email = email;
            this.number = number;
        }

        public Contacts(){

        }


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getId() {
            return id;
        }


        @Override
        public String toString() {
            return "contacts{" +
                    "firstName='" + firstName + '\'' +
                    ", surName='" + surName + '\'' +
                    ", email='" + email + '\'' +
                    ", number='" + number + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

