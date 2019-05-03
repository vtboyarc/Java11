import java.util.ArrayList;

// making this Generic with T, T will be replaced automatically by java with the actual
// class we are using with the real type we are using when we instantiate the class
// extending Player tells it that the parameter has to be any type that extends from Player
// this is called a bounded type parameter
public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int thierScore) {
        String message;
        if (ourScore > thierScore) {
            won++;
            message = " beat ";
        } else if (ourScore == thierScore) {
            tied++;
            message = "tied with ";
        } else {
            lost++;
            message = "lost to ";
        }
        played++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, thierScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    // command + n > implement methods
    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}


