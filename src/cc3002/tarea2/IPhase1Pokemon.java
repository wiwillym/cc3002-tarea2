package cc3002.tarea2;

/**
 * Common interface for the phase 1 Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public interface IPhase1Pokemon {

    /**
     * Plays the phase 1 pokemon.
     *
     * @param trainer Trainer that played the card.
     */
    void play(ITrainer trainer);

    /**
     * Accept method for the visitor.
     *
     * @param visitor Visitor that "visits" the phase 1 Pokemon.
     */
    void accept(Visitor visitor);
}
