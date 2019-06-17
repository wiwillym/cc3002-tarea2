package cc3002.tarea2.fire;

import cc3002.tarea2.AbstractEnergy;
import cc3002.tarea2.IEnergy;
import cc3002.tarea2.ITrainer;

/**
 * This class defines the logic of a fire energy card.
 *
 * @author Guillermo Martinez Salazar
 */
public class FireEnergy extends AbstractEnergy implements IEnergy {


    /**
     * Creates a new fire energy card.
     * {@inheritDoc}
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    public FireEnergy(String name, String descr){
        super(name, descr);
    }

    @Override
    public void play(ITrainer trainer){
        trainer.getSelectedPokemon().addFireEnergy(this);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof FireEnergy && super.equals(obj);
    }
}
