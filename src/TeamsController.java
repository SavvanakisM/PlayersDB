import java.util.HashMap;
import java.util.Scanner;

public class TeamsController {

    private Scanner scanner;

    public TeamsController(Scanner scanner){
        this.scanner = scanner;
    }

    HashMap<Integer, Team> teams = new HashMap<>();
    HashMap<String, Integer> teamsIndex = new HashMap<>();

    int idt = 0;

    //Add Team Method
    public void addTeam() {

        System.out.println("\nPlease enter team's info:\nName: ");
        String s1=scanner.nextLine();
        System.out.println("City: ");
        String s2=scanner.nextLine();
        System.out.println("Titles: ");
        int n1=scanner.nextInt();
        System.out.println("Year Founded: ");
        int n2=scanner.nextInt();
        scanner.nextLine();

        ++idt;
        teams.put(idt, new Team(s1,s2,n1,n2));
        teamsIndex.put(s1, idt);

    }

    //Show Team Method
    public void showTeam() {

        int teamId = -1;
        teamId = AppUtils.idChecker("Please enter the name of the team you want to show: ", "Team not found, please try again: ", scanner, teamsIndex);
        Team team = teams.get(teamId);
        System.out.println("\nTeam Info:\nName: " + team.getName() + "\nCity: " + team.city + "\nTitles: " + team.titles + "\nYear Founded: " + team.yearFounded);

    }

    //Get Teams Method
    public HashMap<Integer, Team> getTeams() {
        return teams;
    }

    //Get Teams Index Method
    public HashMap<String, Integer> getTeamsIndex(){
        return teamsIndex;
    }

}
