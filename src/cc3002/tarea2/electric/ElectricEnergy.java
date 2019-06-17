package cc3002.tarea2.electric;

import cc3002.tarea2.*;

/**
 * This class defines the logic of an electric energy card.
 *
 * @author Guillermo Martinez Salazar
 */
public class ElectricEnergy extends AbstractEnergy implements IEnergy {

    /**
     * Creates a new electric energy card.
     * {@inheritDoc}
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    public ElectricEnergy(String name, String descr){
        super(name, descr);
    }

    @Override
    public void play(ITrainer trainer){
        trainer.getSelectedPokemon().addElectricEnergy(this);
    }


    @Override
    public boolean equals(Object obj){
        return obj instanceof ElectricEnergy && super.equals(obj);
    }
}
