package cc3002.tarea2;

/**
 * Common interface for energy cards. Every energy card has a name and a type.
 *
 * @author Guillermo Martinez Salazar
 */
public interface IEnergy extends ICard{

    /**
     * Getter for the description of the energy card.
     *
     * @return String with the description of the energy card.
     */
    String getDescription();
}
