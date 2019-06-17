package cc3002.tarea2;

/**
 * Abstract class that represents an ability.
 *
 * @author Guillermo Martinez Salazar.
 */
public abstract class AbstractAbility implements IAbility{

    private String name;
    private String descr;
    private EnergyCounter costPerEnergy;

    /**
     * Creates a new ability.
     *
     * @param name Attack name.
     * @param descr Description of the ability.
     * @param costPerEnergy Costs per energy of the ability.
     */
    public AbstractAbility(String name, String descr, EnergyCounter costPerEnergy) {
        this.name = name;
        this.descr = descr;
        this.costPerEnergy = costPerEnergy;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDescription(){
        return descr;
    }

    @Override
    public EnergyCounter getCostOfEnergies(){
        return costPerEnergy;
    }
}
