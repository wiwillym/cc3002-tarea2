package cc3002.tarea2.grass;

import cc3002.tarea2.AbstractEnergy;
import cc3002.tarea2.IEnergy;
import cc3002.tarea2.ITrainer;

/**
 * This class defines the logic of a grass energy card.
 *
 * @author Guillermo Martinez Salazar
 */
public class GrassEnergy extends AbstractEnergy implements IEnergy {

    /**
     * Creates a new grass type card.
     * {@inheritDoc}
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    public GrassEnergy(String name, String descr){
        super(name, descr);
    }

    @Override
    public void play(ITrainer trainer){
        trainer.getSelectedPokemon().addGrassEnergy(this);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof GrassEnergy && super.equals(obj);
    }
}
