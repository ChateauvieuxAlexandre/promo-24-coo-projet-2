package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;

/**
 * Presse produisant des Mini Canards.
 *
 * TODO (Ex2) :
 *   - Faites hériter cette classe de Machine
 *   - Implémentez le constructeur sans paramètre avec un appel à super
 *   - Implémentez produceDuck(), getPurchaseCost(), getName()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class MiniPress extends Machine {

    public static final int PURCHASE_COST    = 300;
    public static final int CAPACITY         = 8;
    public static final int MAINTENANCE_COST = 30;

    /**
     * Constructeur fourni.
     *
     * @param producedType
     * @param capacity
     * @param maintenanceCost
     */
    protected MiniPress(DuckType producedType, int capacity, int maintenanceCost) {
        super(producedType, capacity, maintenanceCost);
    }

    @Override
    public Duck produceDuck() {
        return null;
    }

    @Override
    public int getPurchaseCost() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }
}
