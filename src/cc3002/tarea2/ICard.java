package cc3002.tarea2;

/**
 * Common interface for the cards.
 *
 * @author Guillermo Martínez Salazar
 */
public interface ICard {

    /**
     * Getter of the card's name.
     *
     * @return Name of the energy card.
     */
    String getCardName();

    /**
     * The card is played, depending of which type of card it is.
     *
     * @param trainer Trainer that played the card.
     */
    void play(ITrainer trainer);
}
