public class Runner {
    public static void main(String[] args){
        Player player = new Player(20, 8, 3,0,4);
        Enemy slime = new Enemy("Slime", 10, 2, 0, 3);
        System.out.println(slime.getName() + " appeared");
        int dmgTaken;
        while(slime.getCurrentHP() > 0 && player.getCurrentHP() > 0){ //iteration
            if (slime.getSpeed() > player.getSpeed()){ //selection is everywhere but here's an example
                dmgTaken = slime.takeTurn("slimeType", player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                dmgTaken = player.takeTurn(slime.getDefense(), slime.getName());
                slime.setCurrentHP(slime.getCurrentHP() - dmgTaken);
            } else {
                dmgTaken = player.takeTurn(slime.getDefense(), slime.getName());
                slime.setCurrentHP(slime.getCurrentHP() - dmgTaken);
                dmgTaken = slime.takeTurn("slimeType", player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
            }
        }
        System.out.println(slime.getName() + " is defeated");
        Enemy slime2 = new Enemy("Black Slime", 15, 3, 1, 5);
        System.out.println(slime2.getName() + " appeared");
        while(slime2.getCurrentHP() > 0 && player.getCurrentHP() > 0){
            if (slime2.getSpeed() > player.getSpeed()){
                dmgTaken = slime2.takeTurn("slimeType", player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
                dmgTaken = player.takeTurn(slime2.getDefense(), slime2.getName());
                slime2.setCurrentHP(slime2.getCurrentHP() - dmgTaken);
            } else {
                dmgTaken = player.takeTurn(slime2.getDefense(), slime2.getName());
                slime2.setCurrentHP(slime2.getCurrentHP() - dmgTaken);
                dmgTaken = slime2.takeTurn("slimeType", player.getDefense());
                player.setCurrentHP(player.getCurrentHP() - dmgTaken);
            }
        }
        System.out.println(slime.getName() + " is defeated");
    }
}
