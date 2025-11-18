public class Enemy {
    final private String name;
    private int currentHP;
    final private int maxHP;
    private int attack;
    private int defense;
    private int speed;
    public Enemy(String enemyName, int enemyHP, int enemyAtk, int enemyDef, int enemySpd){
        name = enemyName;
        currentHP = enemyHP;
        maxHP = enemyHP;
        attack = enemyAtk;
        defense = enemyDef;
        speed = enemySpd;
    }

    public String getName(){
        return name;
    }

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

    public int takeTurn(String AI, int playerDef){
        int dmgTaken;
        int recoil;
        double pickAttack = Math.random(); //"random" element
        if (AI.equals("slimeType")) {
            if (pickAttack < 0.8) {
                dmgTaken = attack - playerDef;
                System.out.println(name + " attacks\nplayer takes " + dmgTaken + " damage");
            } else {
                dmgTaken = (attack * 2) - playerDef;
                recoil = attack / 2;
                System.out.println(name + " recklessly charges into player\nplayer takes " + dmgTaken + " damage\n" + name + " crashes, taking " + recoil + " damage");
                currentHP -= 1;
            }
        } else if (AI.equals("beastType")) {
            if (pickAttack < 0.65) {
                dmgTaken = attack - playerDef;
                System.out.println(name + " attacks\nplayer takes " + dmgTaken + " damage");
            } else if (pickAttack < 0.9) {
                dmgTaken = (int) (attack * 1.5) - playerDef;
                System.out.println(name + " rushes in to strike\nplayer takes " + dmgTaken + " damage");
            } else {
                dmgTaken = attack - playerDef;
                System.out.println(name + " bites player and steals their life\n" + name + " heals " + dmgTaken + " HP\nplayer takes " + dmgTaken + " damage");
                currentHP += dmgTaken;
                if (currentHP > maxHP) {
                    currentHP = maxHP;
                }
            }
        } else if (AI.equals("spiritType")) {
            //To be implemented
        } else {
            dmgTaken = 0;
        }
        return dmgTaken;
    }
}