package cc3002.tarea2.grass;

import cc3002.tarea2.AbstractAttack;
import cc3002.tarea2.EnergyCounter;
import cc3002.tarea2.IAttack;

/**
 * This class defines the logic of a grass type attack.
 *
 * @author Guillermo Martinez Salazar
 */
public class GrassAttack extends AbstractAttack implements IAttack {

    /**
     * Creates a new grass type attack.
     * {@inheritDoc}
     *
     * @param name Attack's name.
     * @param baseDamage Attack's base damage.
     * @param descr Description of the attack.
     * @param cost Map with the cost of the attack.
     */
    public GrassAttack(String name, int baseDamage, String descr, EnergyCounter cost){
        super(name, baseDamage, descr, cost);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof GrassAttack && super.equals(obj);
    }
}
