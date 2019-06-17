package cc3002.tarea2.psychic;

import cc3002.tarea2.AbstractEnergy;
import cc3002.tarea2.IEnergy;
import cc3002.tarea2.ITrainer;

/**
 * This class defines the logic of a psychic energy card.
 *
 * @author Guillermo Martinez Salazar
 */
public class PsychicEnergy extends AbstractEnergy implements IEnergy {

    /**
     * Creates a new psychic energy card.
     * {@inheritDoc}
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    public PsychicEnergy(String name, String descr){
        super(name, descr);
    }

    @Override
    public void play(ITrainer trainer){
        trainer.getSelectedPokemon().addPsychicEnergy(this);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof PsychicEnergy && super.equals(obj);
    }
}
