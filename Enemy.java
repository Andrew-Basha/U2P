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

    int atkBuff = 0;
    int atkBuffTimer = 0;
    int defBuff = 0;
    int defBuffTimer = 0;
    int spdBuff = 0;
    int spdBuffTimer = 0;
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
        if (atkBuff > 0) {
            if (atkBuffTimer > 0) {
                atkBuffTimer--;
            } else {
                attack -= atkBuff;
                atkBuff = 0;
            }
        }
        if (defBuff > 0) {
            if (defBuffTimer > 0) {
                defBuffTimer--;
            } else {
                defense -= defBuff;
                defBuff = 0;
            }
        }
        if (spdBuff > 0) {
            if (spdBuffTimer > 0) {
                spdBuffTimer--;
            } else {
                speed -= spdBuff;
                spdBuff = 0;
            }
        }
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
            dmgTaken = 0;
            if (pickAttack < 0.4) {
                dmgTaken = attack - playerDef;
                System.out.println(name + " attacks\nplayer takes " + dmgTaken + " damage");
            } else if (pickAttack < 0.5 && atkBuff == 0) {
                attack += 2;
                atkBuff = 2;
                atkBuffTimer = 3;
                System.out.println(name + " boosts its attack damage");
            } else if (pickAttack < 0.5) {
                atkBuffTimer = 3;
                System.out.println(name + " lengthens its attack boost");
            } else if (pickAttack < 0.6 && defBuff == 0) {
                defense += 2;
                defBuff = 2;
                defBuffTimer = 3;
                System.out.println(name + " boosts its ability to resist damage");
            } else if (pickAttack < 0.6) {
                defBuffTimer = 3;
                System.out.println(name + " lengthens its resistance to damage");
            } else if (pickAttack < 0.65) {
                dmgTaken = (attack * 3) - playerDef;
                System.out.println(name + " attacks with tremendous power\nplayer takes " + dmgTaken + " damage");
            } else if (pickAttack < 0.9) {
                System.out.println(name + " heals 3 HP from itself");
                currentHP += 3;
                if (currentHP > maxHP) {
                    currentHP = maxHP;
                }
            } else {
                System.out.println(name + " waits");
            }
        } else if (AI.equals("dragonType")) {
            if (pickAttack < 0.7) {
                dmgTaken = attack - playerDef;
                System.out.println(name + " attacks\nplayer takes " + dmgTaken + " damage");
            } else if (pickAttack < 0.95) {
                dmgTaken = (int) (attack * 1.5) - playerDef;
                System.out.println(name + " slashes at player\nplayer takes " + dmgTaken + " damage");
            } else {
                dmgTaken = (attack * 3) - playerDef;
                System.out.println(name + " attacks with tremendous power\nplayer takes " + dmgTaken + " damage");
            }
        } else {
            dmgTaken = 0;
        }
        return dmgTaken;
    }
}