package cc3002.tarea2;

/**
 * Common interface for the Phase 2 Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public interface IPhase2Pokemon {

    /**
     * Plays the phase 2 Pokemon
     *
     * @param trainer Trainer that played the card.
     */
    void play(ITrainer trainer);

    /**
     * Accept method for the visitor.
     *
     * @param visitor Visitor that "visits" the phase 2 pokemon.
     */
    void accept(Visitor visitor);
}
