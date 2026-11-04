import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainMenu { 
    public static void main(String[] args) throws Exception {

        String option = "0";
        Scanner scanner = new Scanner(System.in);

        String s1,s2,s3;
        int n1,n2,idp=0,idt=0;

        HashMap<Integer, Team> teams = new HashMap<>();
        HashMap<Integer, Player> players = new HashMap<>();
        HashMap<String, Integer> teamsIndex = new HashMap<>();
        HashMap<String, Integer> playersIndex = new HashMap<>();
        HashMap<Integer, List<String>> transfers = new HashMap<>();
        
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
                            System.out.println("Please enter team's info:\nName: ");
                            s1=scanner.nextLine();
                            System.out.println("City: ");
                            s2=scanner.nextLine();
                            System.out.println("Titles: ");
                            n1=scanner.nextInt();
                            System.out.println("Year Founded: ");
                            n2=scanner.nextInt();
                            scanner.nextLine();

                            ++idt;
                            teams.put(idt, new Team(s1,s2,n1,n2));
                            teamsIndex.put(s1, idt);

                            break;
                        //Option ADD PLAYER
                        case "2":
                            System.out.println("Please enter player's info:\nName: ");
                            s1=scanner.nextLine();
                            System.out.println("Surname: ");    
                            s2=scanner.nextLine();
                            System.out.println("Age: ");
                            n1=scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Team: ");
                            while(true){
                                s3=scanner.nextLine();
                                if(teamsIndex.containsKey(s3)){
                                    break;
                                }
                                System.out.println("Team not found. Please enter a valid team name:");
                            }

                            ++idp;
                            players.put(idp, new Player(s1,s2,n1,s3));
                            playersIndex.put(s2, idp);

                            transfers.put(idp, new ArrayList<>());
                            transfers.get(idp).add(s3);
                            

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

                            int teamId = -1;

                            teamId = idChecker("Please enter team's name to get its information: ", "Team not found. Please enter a valid team name:", scanner, teamsIndex);


                            Team t = teams.get(teamId);
                            System.out.println("\nTeam Info:\nName: "+t.name+"\nCity: "+t.city+"\nTitles: "+t.titles+"\nYear Founded: "+t.yearFounded);
                        
                            break;

                        //Option SHOW PLAYER
                        case "2":

                            int playerId = -1;

                            playerId = idChecker("Please enter player's surname to get his information: ", "Player not found. Please enter a valid surname:", scanner, playersIndex);

                            Player p = players.get(playerId);
                            System.out.println("\nPlayer Info:\nName: "+p.name+"\nSurname: "+p.sur+"\nAge: "+p.age+"\nTeam: "+p.team);

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

                    ind = idChecker("Please enter player's surname to get his transfer history: ", "Player not found. Please enter a valid surname:", scanner, playersIndex);

                    System.out.println("\nChoose an option:\n 1. Show Transfer History\n 2. Add Transfer\n 3. Back");
                    option = scanner.nextLine();

                    switch(option){
                        case "1":
                            
                            List<String> history = transfers.get(ind);
                            for(String team : history){
                                System.out.println("-> " +team);
                            }

                            break;
                        
                        case "2":

                            int teamInd = -1;
                            teamInd = idChecker("Please enter the name of the team to which the player is transferring: ", "Team not found. Please enter a valid team name:", scanner, teamsIndex);

                            String newTeam = teams.get(teamInd).getName();
                            transfers.get(ind).add(newTeam);
                            players.get(ind).setTeam(newTeam);

                            break;

                        case "3":
                            break;

                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                    break;
                //Option EXIT
                case "5":
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;

            }
        }

        scanner.close();
    }    


    //A method that checks if a team or player exists in the database and returns its ID if it does, otherwise it keeps asking for a valid input
    public static int idChecker(String s1, String s2, Scanner scanner, HashMap<String, Integer> index) {
        
        String s;
        
        System.out.println(s1);

        while(true){
            s=scanner.nextLine();
            if(index.containsKey(s)){
                return index.get(s);
            }
            System.out.println(s2);
        }
    }


















}
