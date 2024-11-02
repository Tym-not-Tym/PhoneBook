/*Tymofiy Grebenyk
 * Assignment 2: Phone Book
 * 
 * A simple Java program that implements a phone book application. 
 * This program allows users to add, search, and delete contacts 
 * within a phone book. Each contact includes basic information 
 * such as name, phone number, address.
 */

public class Test {
    public static void main(String[] args) {
        Manager phoneBook = new Manager();
        phoneBook.menu();
    }
}