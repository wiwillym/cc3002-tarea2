package cc3002.tarea2.water;

import cc3002.tarea2.AbstractEnergy;
import cc3002.tarea2.IEnergy;
import cc3002.tarea2.ITrainer;

/**
 * This class defines the logic of a water energy card.
 *
 * @author Guillermo Martinez Salazar
 */
public class WaterEnergy extends AbstractEnergy implements IEnergy {

    /**
     * Creates a new water energy card.
     * {@inheritDoc}
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    public WaterEnergy(String name, String descr){
        super(name, descr);
    }

    @Override
    public void play(ITrainer trainer){
        trainer.getSelectedPokemon().addWaterEnergy(this);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof WaterEnergy && super.equals(obj);
    }
}
