public class Runner {
    public static void main(String[] args){
        double random = Math.random();
        Player player = new Player(20, 8, 3,0,3);
        Enemy enemy1 = new Enemy("Green Slime", 5, 2, 0, 3);
        String AI = "slimeType";
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
        System.out.println(enemy1.getName() + " is defeated");
        random = Math.random();
        Enemy enemy2 = new Enemy("Green Slime", 5, 2, 0, 3);
        //AI = "slimeType";
        System.out.println(enemy2.getName() + " appeared");
        while (enemy2.getCurrentHP() > 0 && player.getCurrentHP() > 0) {
            if (enemy2.getSpeed() > player.getSpeed()) {
                dmgTaken = enemy2.takeTurn(AI, player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                if (player.getCurrentHP() > 0) {
                    dmgTaken = player.takeTurn(enemy2.getDefense(), enemy2.getName());
                    enemy2.setCurrentHP(enemy2.getCurrentHP() - dmgTaken);
                }
            } else {
                dmgTaken = player.takeTurn(enemy2.getDefense(), enemy2.getName());
                enemy2.setCurrentHP(enemy2.getCurrentHP() - dmgTaken);
                if (enemy1.getCurrentHP() > 0) {
                    dmgTaken = enemy2.takeTurn(AI, player.getDefense());
                    player.setCurrentHP(player.getCurrentHP() - dmgTaken);
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
