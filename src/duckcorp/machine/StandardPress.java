package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;

/**
 * Presse produisant des canards Standard.
 *
 * TODO (Ex2) :
 *   - Faites hériter cette classe de Machine
 *   - Implémentez le constructeur sans paramètre avec un appel à super
 *   - Implémentez produceDuck(), getPurchaseCost(), getName()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class StandardPress extends Machine{

    public static final int PURCHASE_COST    = 500;
    public static final int CAPACITY         = 5;
    public static final int MAINTENANCE_COST = 50;

    /**
     * Constructeur fourni.
     *
     * @param producedType
     * @param capacity
     * @param maintenanceCost
     */
    protected StandardPress(DuckType producedType, int capacity, int maintenanceCost) {
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
