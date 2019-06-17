package cc3002.tarea2;


/**
 * Base class for all the energies. This contains the methods to access the energy card
 * properties, like its name and type.
 *
 * @author Guillermo Martinez Salazar
 */
public abstract class AbstractEnergy extends AbstractCard implements IEnergy{

    private String name;
    private String descr;

    /**
     * Creates a new energy.
     *
     * @param name Name of the energy card.
     * @param descr Description of the energy card.
     */
    protected AbstractEnergy(String name, String descr){
        super(name);
        this.name = name;
        this.descr = descr;
    }

    @Override
    public String getDescription(){
        return this.descr;
    }

    /**
     * Checks if this energy is equal to another.
     *
     * @param obj Object to compare this energy with.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj){
        return obj instanceof IEnergy
                && ((ICard) obj).getCardName().equals(name)
                && ((IEnergy) obj).getDescription().equals(descr);
    }

}
