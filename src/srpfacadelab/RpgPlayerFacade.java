package srpfacadelab;

public class RpgPlayerFacade {

    

    public void takeDamage(int damage, RpgPlayer player){
        Actions.takeDamage(damage, player);
    }

    public static boolean checkIfItemExistsInInventory(Item item, RpgPlayer player){
        return PlayerInvintory.checkIfItemExistsInInventory(item, player);
    }

    public static int calculateInventoryWeight(RpgPlayer player){
        return PlayerInvintory.calculateInventoryWeight(player);
    }
    
    public void useItem(Item item, RpgPlayer player){
        Actions.useItem(item, player);
    }

    public boolean pickUpItem(Item item, RpgPlayer player){
        return PlayerInvintory.pickUpItem(item, player);
    }

    public static void calculateStats(RpgPlayer player){
        PlayerInvintory.calculateStats(player);
    }

}