package cc3002.tarea2;

/**
 * Class that represents the Strikes Back ability.
 *
 * @author Guillermo Martinez Salazar.
 */
public class StrikesBack extends AbstractAbility implements IAbility {

    /**
     * Creates a new Strikes Back ability.
     *
     * @param name Name of the ability.
     * @param descr Description of the ability.
     * @param costPerEnergy Costs per energy of the ability.
     */
    public StrikesBack(String name, String descr, EnergyCounter costPerEnergy){
        super(name, descr, costPerEnergy);
    }

    @Override
    public void play(ITrainer trainer){
    }

    public void accept(Visitor visitor){
        visitor.visitStrikesBack(this);
    }
}
