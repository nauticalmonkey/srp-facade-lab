package srpfacadelab;

import java.util.List;
import java.util.ArrayList;

public class PlayerInvintory {

    public static boolean checkIfItemExistsInInventory(Item item, RpgPlayer player) {
        for (Item i : player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public static int calculateInventoryWeight(RpgPlayer player) {
        int sum = 0;
        for (Item i : player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }

    public static void calculateStats(RpgPlayer player) {
        for (Item i : player.getInventory()) {
            player.setArmour(player.getArmour() + i.getArmour());
        }
    }

    public static boolean pickUpItem(Item item, RpgPlayer player) {
        int weight = calculateInventoryWeight(player);
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item, player))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getMaxHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.getGameEngine().playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            player.getGameEngine().playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique()) {
            player.getGameEngine().playSpecialEffect("blue_swirly");
        }

        player.getInventory().add(item);

        calculateStats(player);

        return true;
    }

}