package srpfacadelab;
import java.util.List;
public class Actions {

    public static void takeDamage(int damage, RpgPlayer player) {
        double damageToDeal;

        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        if (player.getCarryingCapacity() <= 0.5 * player.MAX_CARRYING_CAPACITY) {
            damageToDeal = 0.75 * (damage - player.getArmour());
        } else {
            damageToDeal = damage - player.getArmour();
        }

        player.setHealth(player.getHealth() - (int) damageToDeal);

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }


    public static void useItem(Item item, RpgPlayer player) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

}