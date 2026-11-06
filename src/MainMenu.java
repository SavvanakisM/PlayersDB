/* import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner; */

import java.util.Scanner;

public class MainMenu { 
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(scanner);
        String option = "0";
        

        System.out.println("\nWelcome to the Players Database!");
        

        while(!option.equals("5")){

            System.out.println("\nChoose an option:\n 1. Add\n 2. Show\n 3. Edit\n 4. Transfer History\n 5. Exit\n");
            option = scanner.nextLine();

            controller.panel(option);
        }

        scanner.close();

    }
}