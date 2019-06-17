package cc3002.tarea2.fighting;

import cc3002.tarea2.AbstractEnergy;
import cc3002.tarea2.IEnergy;
import cc3002.tarea2.ITrainer;

/**
 * This class defines the logic of a fighting energy card.
 *
 * @author Guillermo Martinez Salazar
 */
public class FightingEnergy extends AbstractEnergy implements IEnergy {

    /**
     * Creates a new fighting energy card.
     * {@inheritDoc}
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    public FightingEnergy(String name, String descr){
        super(name, descr);
    }

    public void play(ITrainer trainer){
        trainer.getSelectedPokemon().addFightingEnergy(this);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof FightingEnergy && super.equals(obj);
    }
}
