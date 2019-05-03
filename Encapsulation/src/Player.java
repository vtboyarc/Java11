public class Player {
    //making the fields private, not accessible to other classes, requires us to use the getter to access fields
    // helps prevent unauthorized access. Should always use encapsulation.
    private String name;
    private  int health = 100;
    private String weapon;

    public Player(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 && health <= 100) {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
        }
    }

    // back in main, when we make a Player object, we have to access health via this getter,
    // instead of the field directly, since it is private
    public int getHealth() {
        return health;
    }
}
