import java.util.Scanner;
public class Player {
    private int currentHP;
    private int maxHP;
    private int currentMP;
    private int maxMP;
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
            System.out.print("Heavy attack (4 MP)-");
        }
        if (currentMP >= 2){
            System.out.print("Heal (2 MP)-");
        }
        if (currentMP >= 6){
            System.out.print("Grand heal (6 MP)-");
        }
        System.out.print("\n");
        String action = makeMove.nextLine();
        if (action.equals("Attack")) {
            dmgTaken = attack - enemyDef;
            if (dmgTaken < 0) {
                dmgTaken = 0;
            }
            System.out.println("player attacks " + enemyName + ", dealing " + dmgTaken + " damage");
        } else if (currentMP >= 4 && action.equals("Heavy attack")){
            dmgTaken = (attack * 2) - enemyDef;
            if (dmgTaken < 0) {
                dmgTaken = 0;
            }
            System.out.println("player strikes at " + enemyName + " with all their might, dealing " + dmgTaken + " damage");
            currentMP -= 4;
        } else if (currentMP >= 2 && action.equals("Heal")){
            dmgTaken = 0;
            System.out.println("player heals 7 HP from themselves");
            currentHP += 7;
            currentMP -= 2;
            if (currentHP > maxHP){
                currentHP = maxHP;
            }
        } else if (currentMP >= 6 && action.equals("Grand heal")) {
            dmgTaken = 0;
            System.out.println("player heals a whopping 16 HP from themselves");
            currentHP += 16;
            currentMP -= 6;
            if (currentHP > maxHP){
                currentHP = maxHP;
            }
        } else {
            dmgTaken = 0;
        }
        return dmgTaken;
    }
    public void levelUp(int HPIncrease, int MPIncrease, int atkIncrease, int defIncrease, int spdIncrease){
        System.out.println("player levels up\nplayer's HP is refilled\nplayer gains " + HPIncrease + " HP\nplayer's MP is refilled\nplayer gains " + MPIncrease  + " MP");
        maxHP += HPIncrease;
        maxMP += MPIncrease;
        currentHP = maxHP;
        currentMP = maxMP;
        System.out.println("player gains " + atkIncrease + " Attack, " + defIncrease + " Defense, and " + spdIncrease + " Speed");
        attack += atkIncrease;
        defense += defIncrease;
        speed += spdIncrease;
    }
}
