package cc3002.tarea2;

/**
 * Class that represents the Electric Shock attack.
 *
 * @author Guillermo Martinez Salazar.
 */
public class ElectricShock extends AbstractAttack implements IAttack {

    /**
     * Creates a new Electric Shock attack.
     *
     * @param name Name of the attack.
     * @param baseDamage Base damage of the attack.
     * @param descr Description of the attack.
     * @param costPerEnergy Cost of the attack to be used.
     */
    public ElectricShock(String name, int baseDamage, String descr, EnergyCounter costPerEnergy){
        super(name, baseDamage, descr, costPerEnergy);
    }

    public void accept(Visitor visitor){
        visitor.visitElectricShock(this);
    }
}
