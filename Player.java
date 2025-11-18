import java.util.Scanner;
public class Player {
    private int currentHP;
    final private int maxHP;
    private int currentMP;
    final private int maxMP;
    private int attack;
    private int defense;
    private int speed;
    public Player(int HP, int MP, int atk, int def, int spd){
        currentHP = HP;
        maxHP = HP;
        currentMP = MP;
        maxMP = MP;
        attack = atk;
        defense = def;
        speed = spd;
    }

    Scanner makeMove = new Scanner(System.in);

    public int getCurrentHP(){
        return currentHP;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public void setCurrentHP(int newHP){
        currentHP = newHP;
    }

    public int takeTurn(int enemyDef, String enemyName){
        int dmgTaken;
        System.out.print(currentHP + "/" + maxHP + "HP\n" + currentMP + "/" + maxMP + "MP\nPerform an action\n-Attack (0 MP)-");
        if (currentMP >= 4){
            System.out.print("Heavy blow (4 MP)-");
        }
        if (currentMP >= 2){
            System.out.print("Heal (2 MP)-");
        }
        System.out.print("\n");
        String action = makeMove.nextLine();
        if (action.equals("Attack")) {
            dmgTaken = attack - enemyDef;
            System.out.println("player attacks " + enemyName + ", dealing " + dmgTaken + " damage");
        } else if (currentMP >= 4 && action.equals("Heavy blow")){
            dmgTaken = (attack * 2) - enemyDef;
            System.out.println("player strikes at " + enemyName + " with all their might, dealing " + dmgTaken + " damage");
            currentMP -= 4;
        } else if (currentMP >= 2 && action.equals("Heal")){
            dmgTaken = 0;
            System.out.println("player heals 5 HP from themselves");
            currentHP += 5;
            currentMP -= 2;
            if (currentHP > maxHP){
                currentHP = maxHP;
            }
        } else {
            dmgTaken = 0;
        }
        return dmgTaken;
    }
}
