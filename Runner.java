public class Runner {
    public static void main(String[] args){
        double random = Math.random();
        Player player = new Player(30, 10, 5,0,3);
        Enemy enemy1;
        String AI;
        if (random < .2) {
            enemy1 = new Enemy("Green Slime", 20, 3, 0, 3);
            AI = "slimeType";
        } else if (random < .4) {
            enemy1 = new Enemy("Wolf", 12, 4, 0, 4);
            AI = "beastType";
        } else if (random < .6) {
            enemy1 = new Enemy("Blue Slime", 15, 4, 1, 2);
            AI = "slimeType";
        } else if (random < .8) {
            enemy1 = new Enemy("Lost Soul", 30, 1, 0, 5);
            AI = "spiritType";
        } else {
            enemy1 = new Enemy("Brute", 8, 6, 1, 3);
            AI = "beastType";
        }
        System.out.println(enemy1.getName() + " appeared");
        int dmgTaken;
        while(enemy1.getCurrentHP() > 0 && player.getCurrentHP() > 0){ //iteration
            if (enemy1.getSpeed() > player.getSpeed()){ //selection is everywhere but here's an example
                dmgTaken = enemy1.takeTurn(AI, player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                if (player.getCurrentHP() > 0) {
                    dmgTaken = player.takeTurn(enemy1.getDefense(), enemy1.getName());
                    enemy1.setCurrentHP(enemy1.getCurrentHP() - dmgTaken);
                }
            } else {
                dmgTaken = player.takeTurn(enemy1.getDefense(), enemy1.getName());
                enemy1.setCurrentHP(enemy1.getCurrentHP() - dmgTaken);
                if (enemy1.getCurrentHP() > 0) {
                    dmgTaken = enemy1.takeTurn(AI, player.getDefense());
                    player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                }
            }
        }
        if (player.getCurrentHP() > 0) {
        System.out.println(enemy1.getName() + " is defeated");
        random = Math.random();
            if (random < .2) {
                enemy1 = new Enemy("Death", 25, 3, 1, 5);
                AI = "spiritType";
            } else if (random < .4) {
                enemy1 = new Enemy("Dragon", 32, 3, 1, 3);
                AI = "dragonType";
            } else if (random < .6) {
                enemy1 = new Enemy("Creature", 18, 8, 0, 3);
                AI = "beastType";
            } else if (random < .8) {
                enemy1 = new Enemy("Black Slime", 14, 5, 4, 1);
                AI = "slimeType";
            } else {
                enemy1 = new Enemy("Wyvern", 24, 5, 2, 2);
                AI = "dragonType";
            }
            System.out.println(enemy1.getName() + " appeared");
        while (enemy1.getCurrentHP() > 0 && player.getCurrentHP() > 0) {
            if (enemy1.getSpeed() > player.getSpeed()) {
                dmgTaken = enemy1.takeTurn(AI, player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                if (player.getCurrentHP() > 0) {
                    dmgTaken = player.takeTurn(enemy1.getDefense(), enemy1.getName());
                    enemy1.setCurrentHP(enemy1.getCurrentHP() - dmgTaken);
                }
            } else {
                dmgTaken = player.takeTurn(enemy1.getDefense(), enemy1.getName());
                enemy1.setCurrentHP(enemy1.getCurrentHP() - dmgTaken);
                if (enemy1.getCurrentHP() > 0) {
                    dmgTaken = enemy1.takeTurn(AI, player.getDefense());
                    player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                }
            }
        }
        }
        if (player.getCurrentHP() > 0) {
            System.out.println(enemy1.getName() + " is defeated");
        } else {
            System.out.println("player is defeated");
        }
    }
}
