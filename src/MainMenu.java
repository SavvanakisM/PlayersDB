import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) throws Exception {

        String option = "0";
        Scanner scanner = new Scanner(System.in);

        String s1,s2,s3;
        int n1,n2;

        HashMap<String, Team> teams = new HashMap<>();
        HashMap<String, Player> players = new HashMap<>();

        while(option != "5"){
            System.out.println("Choose an option:\n 1. Add Team\n 2. Add Player\n 3. Find a Player\n 4. Find a Team\n 5. Exit");
            option = scanner.nextLine();
            scanner.nextLine(); // Consume the newline character
            switch (option) {
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
                    
                    teams.put(s1, new Team(s1,s2,n1,n2));

                    break;
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
                        if(teams.containsKey(s3)){
                            break;
                        }
                        System.out.println("Team not found. Please enter a valid team name:");
                    }

                    players.put(s2, new Player(s1,s2,n1,s3));

                    break;
                case "3":
                    System.out.println("Please enter player's surname to get his information: ");
                    while(true){
                        s2=scanner.nextLine();
                        if(players.containsKey(s2)){
                            break;
                        }
                        System.out.println("Player not found. Please enter a valid surname:");
                    }
                    
                    for(Map.Entry<String, Player> entry : players.entrySet()){
                        if(entry.getKey().equals(s2)){
                            Player p = entry.getValue();
                            System.out.println("Player Info:\nName: "+p.name+"\nSurname: "+p.sur+"\nAge: "+p.age+"\nTeam: "+p.team);
                        }
                    }
                    
                    break;
                case "4":

                    System.out.println("Please enter team's name to get its information: ");
                    while(true){
                        s1=scanner.nextLine();
                        if(teams.containsKey(s1)){
                            break;
                        }
                        System.out.println("Team not found. Please enter a valid team name:");
                    }
                    
                    for(Map.Entry<String, Team> entry : teams.entrySet()){
                        if(entry.getKey().equals(s1)){
                            Team t = entry.getValue();
                            System.out.println("Team Info:\nName: "+t.name+"\nCity: "+t.city+"\nTitles: "+t.titles+"\nYear Founded: "+t.yearFounded);
                        }
                    }

                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();    
    }
}
