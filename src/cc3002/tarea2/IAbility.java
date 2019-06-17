package cc3002.tarea2;

/**
 * Common interface for the ability cards.
 *
 * @author Guillermo Martinez Salazar.
 */
public interface IAbility {

    /**
     * Getter for the energies and their quantities required to use an ability, in a Map format.
     *
     * @return Energies and their quantities required to use an ability.
     */
    EnergyCounter getCostOfEnergies();

    /**
     * Getter for the description of the ability.
     *
     * @return Description of the ability.
     */
    String getDescription();

    /**
     * Getter for the name of the ability.
     *
     * @return Name of the ability.
     */
    String getName();

    /**
     * Plays an ability.
     *
     * @param trainer Trainer that played the ability.
     */
    void play(ITrainer trainer);
}
