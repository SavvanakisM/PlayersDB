//import java.lang.classfile.ClassFile.Option;
import java.util.Scanner;

public class Controller {

    public void panel(){

        String option = "0";
        Scanner scanner = new Scanner(System.in);

        TeamsController teamsController = new TeamsController();
        PlayersController playersController = new PlayersController();
        
        System.out.println("\nWelcome to the Players Database!");

        while(!option.equals("5")){

            System.out.println("\nChoose an option:\n 1. Add\n 2. Show\n 3. Edit\n 4. Transfer History\n 5. Exit\n");
            option = scanner.nextLine();

            switch (option) {
                //Option ADD
                case "1":
                    System.out.println("\nChoose an option:\n 1. Add Team\n 2. Add Player\n 3. Back");
                    option = scanner.nextLine();

                    switch (option) {
                        //Option ADD TEAM
                        case "1":
                            teamsController.addTeam();
                            break;
                        //Option ADD PLAYER
                        case "2":
                            playersController.addPlayer(teamsController.getTeamsIndex());
                            break;
                        //Option BACK
                        case "3":
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                    break;
                //Option SHOW
                case "2":
                    System.out.println("\nChoose an option:\n 1. Show a Team\n 2. Show a Player\n 3. Back");
                    option = scanner.nextLine();

                    switch (option) {
                        //Option SHOW TEAM
                        case "1":
                            teamsController.showTeam();
                            break;
                            //Option SHOW PLAYER
                        case "2":
                            playersController.showPlayer();
                            break;
                        //Option BACK
                        case "3":
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;                    
                    }
                    break;
                //Option EDIT
                case "3":
                    break;
                //Option TRANSFER HISTORY
                case "4":

                    int ind = -1;
                    ind = AppUtils.idChecker("\nPlease enter player's surname to get his transfer history: ", "Player not found. Please enter a valid surname:", scanner, playersController.getPlayersIndex());
                    System.out.println("\nChoose an option:\n 1. Show Transfer History\n 2. Add Transfer\n 3. Back");
                    option = scanner.nextLine();

                    switch (option){
                        //Option SHOW TRANSFER HISTORY
                        case "1":
                            playersController.showTransferHistory(ind);
                            break;
                        //Option ADD TRANSFER
                        case "2":
                            playersController.addTransfer(teamsController.getTeamsIndex(), ind, teamsController.getTeams());
                            break;
                        //Option BACK
                        case "3":
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                    break;
                // Option EXIT
                case "5":
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
