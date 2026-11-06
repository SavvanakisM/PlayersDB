//import java.util.Scanner;

public class Player {

    String name, sur, team;
    int age;

    public Player(String name, String sur, int age, String team) {
        this.name = name;
        this.sur = sur;
        this.age = age;
        this.team = team;
    }

    public String getSur() {
        return sur;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}
