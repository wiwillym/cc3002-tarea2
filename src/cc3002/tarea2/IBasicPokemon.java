package cc3002.tarea2;

/**
 * Common interface for the basic Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public interface IBasicPokemon extends IPokemon {

    /**
     * Plays the basic Pokemon.
     *
     * @param trainer Trainer that played the card.
     */
    void play(ITrainer trainer);

    /**
     * Accept method for the visitor.
     *
     * @param visitor Visitor that "visits" the pokemon cards.
     */
    void accept(Visitor visitor);
}
