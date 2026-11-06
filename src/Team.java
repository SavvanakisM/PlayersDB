public class Team {

    String name,city;
    int titles, yearFounded;

    public Team(String name, String city, int titles, int yearFounded) {
        this.name = name;
        this.city = city;
        this.titles = titles;
        this.yearFounded = yearFounded;
    }

    public String getName() {
        return name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setTitles(int titles){
        this.titles = titles;
    }

    public void setYearFounded(int yearFounded){
        this.yearFounded = yearFounded;
    }

}
