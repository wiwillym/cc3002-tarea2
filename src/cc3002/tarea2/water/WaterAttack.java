package cc3002.tarea2.water;

import cc3002.tarea2.AbstractAttack;
import cc3002.tarea2.EnergyCounter;
import cc3002.tarea2.IAttack;
import cc3002.tarea2.ITrainer;

/**
 * This class defines the logic of a water type attack.
 *
 * @author Guillermo Martinez Salazar
 */
public class WaterAttack extends AbstractAttack implements IAttack {

    /**
     * Creates a new water type attack.
     * {@inheritDoc}
     *
     * @param name Attack's name.
     * @param baseDamage Attack's base damage.
     * @param descr Description of the attack.
     * @param cost Map with the cost of the attack.
     */
    public WaterAttack(String name, int baseDamage, String descr, EnergyCounter cost){
        super(name, baseDamage, descr, cost);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof WaterAttack && super.equals(obj);
    }
}
