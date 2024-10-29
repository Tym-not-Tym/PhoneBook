import java.util.Scanner;

public class Manager{
    public void menu() {
        Scanner scn = new Scanner(System.in);
        int intInput;
        do {
            System.out.println("'1' - Add new contact");
            System.out.println("'2' - View contacts");
            System.out.println("'3' - Modify contact");
            System.out.println("'4' - Delete contact");
            System.out.println("'5' - Exit");
            System.out.print("Your choice: ");
            
            intInput = scn.nextInt();

            switch (intInput) {
                case 1:
                        
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                default:
                    System.out.println("Be careful!");
                    break;
            }
        } while (intInput != 5);   

        
    }
}