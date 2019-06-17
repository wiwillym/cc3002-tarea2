package cc3002.tarea2;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name and base damage.
 *
 * @author Guillermo Martinez Salazar
 */

public abstract class AbstractAttack extends AbstractAbility implements IAttack{

    private int baseDamage;
    private String name;
    private String descr;
    private EnergyCounter costPerEnergy;

    /**
     * Creates a new attack.
     *
     * @param name Attack name.
     * @param baseDamage Base damage of the attack.
     * @param descr Description of the attack.
     * @param costPerEnergy Costs per energy of the attack.
     */
    protected AbstractAttack(String name, int baseDamage, String descr, EnergyCounter costPerEnergy) {
        super(name, descr, costPerEnergy);
        this.name = name;
        this.baseDamage = baseDamage;
        this.descr = descr;
        this.costPerEnergy = costPerEnergy;
    }

    @Override
    public int getBaseDamage(){
        return baseDamage;
    }

    @Override
    public void play(ITrainer trainer){
        trainer.getActivePokemon().genericAttack(trainer.getOpponent());
    }

    /**
     * Checks if this attack is equal to another.
     *
     * @param obj Object to compare this attack with.
     * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj){
        return obj instanceof IAttack && ((IAttack) obj).getBaseDamage() == baseDamage
                && ((IAttack) obj).getName().equals(name)
                && ((IAttack) obj).getDescription().equals(descr)
                && ((IAttack) obj).getCostOfEnergies().equals(costPerEnergy);
    }
}
