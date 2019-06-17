package cc3002.tarea2.electric;

import cc3002.tarea2.AbstractAttack;
import cc3002.tarea2.EnergyCounter;
import cc3002.tarea2.IAttack;

/**
 * This class defines the logic of an electric type attack.
 *
 * @author Guillermo Martinez Salazar
 */
public class ElectricAttack extends AbstractAttack implements IAttack {

    /**
     * Creates a new electric type attack.
     * {@inheritDoc}
     *
     * @param name Attack's name.
     * @param baseDamage Attack's base damage.
     * @param descr Description of the attack.
     * @param cost Map with the cost of the attack.
     */
    public ElectricAttack(String name, int baseDamage, String descr, EnergyCounter cost){
        super(name, baseDamage, descr, cost);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof ElectricAttack && super.equals(obj);
    }
}
