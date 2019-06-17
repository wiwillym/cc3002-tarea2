package cc3002.tarea2.fire;

import cc3002.tarea2.AbstractAttack;
import cc3002.tarea2.EnergyCounter;
import cc3002.tarea2.IAttack;

/**
 * This class defines the logic of a fire type attack.
 *
 * @author Guillermo Martinez Salazar
 */
public class FireAttack extends AbstractAttack implements IAttack {

    /**
     * Creates a new fire type attack.
     * {@inheritDoc}
     *
     * @param name Attack's name.
     * @param baseDamage Attack's base damage.
     * @param descr Description of the attack.
     * @param cost Map with the cost of the attack.
     */
    public FireAttack(String name, int baseDamage, String descr, EnergyCounter cost){
        super(name, baseDamage, descr, cost);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof FireAttack && super.equals(obj);
    }

}
