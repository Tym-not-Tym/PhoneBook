import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Manager{
    public static int GET_COUNTER = 0;//counter for 'Delete Contact' it counts the location of a needed node for remove()

    public void menu() {
        int intInput = 9999999;//for menu loop
        ListNode head = new ListNode();
        String name;
        String address;
        String city;
        String phoneNum;
        do {
            System.out.println("\nMenu");
            System.out.println("'1' - Add New Contact");
            System.out.println("'2' - View Contacts");
            System.out.println("'3' - Modify Contact");
            System.out.println("'4' - Delete Contact");
            System.out.println("'5' - Exit");
            
            Scanner scn = new Scanner(System.in);
            boolean intCheck = true;

            do {//check input
                try {
                    System.out.print("Your Choice: ");
                    intInput = scn.nextInt();
                    intCheck = true;
                } catch (RuntimeException re) {
                    intCheck = false;
                    scn.next();
                    System.out.println("Enter A Number!");
                }
            } while(!intCheck);

            switch (intInput) {
                case 1://Add New Contact
                    
                    Scanner scn1 = new Scanner(System.in);

                    System.out.print("Name: ");
                    name = scn1.nextLine();

                    System.out.print("Address: ");
                    address = scn1.nextLine();

                    System.out.print("City, State, Zip Code: ");
                    city = scn1.nextLine();

                    System.out.print("Phone Number: ");
                    phoneNum = scn1.nextLine();
                    
                    add(head, name, address, city, phoneNum);
                    break;
                case 2://View Contacts

                    if (countNodes(head) <= 1) {//check contact availability
                        System.out.println("Add At Least One Contact!");
                        break;
                    }     

                    printList(head);
                    break;
                case 3://Modify Contact   
                
                    if (countNodes(head) <= 1) {//check contact availability
                        System.out.println("Add At Least One Contact!");
                        break;
                    }

                    System.out.print("Enter The Name Of The Contact: ");
                    Scanner scn3 = new Scanner(System.in);
                    name = scn3.nextLine();
                    ListNode current;

                    try {//check if contact exist
                        current = get(head, name);
                    } catch (NullPointerException npe) {
                        System.out.println("Contact Doesn't Exist!");
                        break;
                    }
                    printNode(current);
                    int intInput2 = 0;
                    do {//modifing a node
                        System.out.println("\nEditing");
                        System.out.println("'1' - Change Name");
                        System.out.println("'2' - Change Address");
                        System.out.println("'3' - Change City, State, Zip Code");
                        System.out.println("'4' - Change Phone Number");
                        System.out.println("'5' - Exit");
                
                        do {//check input
                            try {
                                System.out.print("Your Choice: ");
                                intInput2 = scn.nextInt();
                                intCheck = true;
                            } catch (RuntimeException re) {
                                intCheck = false;
                                scn.next();
                                System.out.println("Enter A Number!");
                            }
                        } while(!intCheck);
                        
                        switch (intInput2) {
                            case 1:
                                System.out.print("Name: ");
                                name = scn3.nextLine();
                                current.name = name;
                                break;
                            case 2:
                                System.out.print("Address: ");
                                address = scn3.nextLine();
                                current.address = address;
                                break;
                            case 3:
                                System.out.print("City, State, Zip Code: ");
                                city = scn3.nextLine();
                                current.city = city;
                                break;
                            case 4:
                                System.out.print("Phone Number: ");
                                phoneNum = scn3.nextLine();
                                current.phoneNum = phoneNum;
                                break;
                            case 5:
                                break;                    
                            default://input validation
                                System.out.println("Enter A Valid Number!");
                                break;
                        }
                    } while (intInput2 != 5);
                    printNode(current);
                    break;
                case 4://Delete Contact

                    if (countNodes(head) <= 1) {//check contact availability
                        System.out.println("Add At Least One Contact!");
                        break;
                    }
                    
                    System.out.print("Enter The Name Of The Contact: ");
                    Scanner scn4 = new Scanner(System.in);
                    name = scn4.nextLine();
                    GET_COUNTER = 1;
                    ListNode currentLocal;

                    try {//check if contact exist
                        currentLocal = get(head, name);
                    } catch (NullPointerException npe) {
                        System.out.println("Contact Doesn't Exist!");
                        break;
                    }

                    printNode(currentLocal);
                    remove(head, GET_COUNTER);
                    break;
                case 5:
                    break;
                default://input validation
                    System.out.println("Be careful!");
                    break;
            }
        } while (intInput != 5);     
    }//end of menu

    //counts number of nodes
    public int countNodes(ListNode head) {
        int counter = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    //add with data
    public void add(ListNode head, String name, String address, String city, String phoneNum) {
        ListNode current = head;
        if (current.next == null) {
            head.next = new ListNode(name, address, city, phoneNum);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(name, address, city, phoneNum);
        }
    }

    //add without data(not used)
    public void add(ListNode head) {
        ListNode current = head;
        if (current.next == null) {
            head.next = new ListNode();
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode();
        }
    }

    //add with data to a specific location
    public void add(ListNode head, int index, String name, String address, String city, 
                                                                         String phoneNum) {
        if (index == 0) {
            head = new ListNode(head, name, address, city, phoneNum);
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            current.next = new ListNode(current.next, name, address, city, phoneNum);
        }
    }

    //get a specific node
    public ListNode get(ListNode head, String name) {
        ListNode current = head.next;
        String currentName = current.name;
        while (!currentName.equals(name)) {            
            current = current.next;
            currentName = current.name;
            GET_COUNTER++;
        }
        return current;
    }

    //print all nodes exept the 1st one
    public void printList(ListNode head) {
        ListNode current = head.next;
        System.out.println("\nPhone Book");
        while (current != null) {
            System.out.print(current.name + " ");
            System.out.print(current.address + " ");
            System.out.print(current.city + " ");
            System.out.println(current.phoneNum);
            current = current.next;
        }
    }

    //print single passed node
    public void printNode(ListNode current) {
        System.out.print(current.name + " ");
        System.out.print(current.address + " ");
        System.out.print(current.city + " ");
        System.out.println(current.phoneNum);
    }

    //works only with origignal node or if current.next = current.next.next(not used)
    public void remove(ListNode current) {
        if (current == null) {
            throw new NoSuchElementException();
        } else {            
            current = current.next;            
        }
    
    }

    //remove node at a given index
    public void remove(ListNode head, int index) {
        if (index == 0) {
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }


}