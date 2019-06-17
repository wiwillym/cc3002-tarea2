package cc3002.tarea2;

import java.util.List;

/**
 * Interface for the trainer. Each trainer has an active Pokemon, a list of inactive Pokemon
 * and a list of energy cards.
 *
 * @author Guillermo Martinez Salazar
 */
public interface ITrainer{

    /**
     * Adds a new card to the hand.
     *
     * @param card Card that´s intended to be added.
     */
    void addCardToHand(ICard card);

    /**
     * Adds Pokemon to trainers' bench.
     *
     * @param index Index of the Pokemon intended to be added.
     */
    void addToBench(int index);

    /**
     * Adds Pokemon to the discard pile of the trainer.
     *
     * @param card Card added to the discard pile.
     */
    void addToDiscardPile(ICard card);

    /**
     * Adds card to the reward cards of the trainer.
     *
     * @param card Card added to the reward cards.
     */
    void addToRewardCards(ICard card);

    /**
     * Makes the active pokemon of the trainer evolves.
     *
     * @param pokemon Pokemon "evolved".
     */
    void evolveActivePokemon(IPokemon pokemon);

    /**
     * Getter for the discard pile of the trainer.
     *
     * @return Discard pile of the trainer.
     */
    List<ICard> getDiscardPile();

    /**
     * Getter for the active Pokemon of the trainer.
     *
     * @return Active Pokemon that is playing.
     */
    IPokemon getActivePokemon();

    /**
     * Getter for the opponent's active Pokemon.
     *
     * @return Active Pokemon of the opponent.
     */
    IPokemon getOpponentActivePokemon();

    /**
     * Getter for the hand cards of the trainer.
     *
     * @return List of cards available.
     */
    List<ICard> getHandCards();

    /**
     * Getter for the trainers' bench.
     *
     * @return List of Pokemon on the trainers' bench.
     */
    List<IPokemon> getBenchCards();

    /**
     * Getter for the opponent bench cards.
     *
     * @return Bench cards of the opponent.
     */
    List<IPokemon> getOpponentBenchCards();

    List<ICard> getRewardCards();

    /**
     * Getter for the opponent.
     *
     * @return Opponent of the trainer.
     */
    ITrainer getOpponent();

    /**
     * Getter for the selected Pokemon.
     *
     * @return Selected pokemon of the trainer.
     */
    IPokemon getSelectedPokemon();

    /**
     * Checks if the active pokemon of the trainer is still alive or not.
     *
     * @return <code>true</code> if active pokemon hit points are over 0, <code>false</code> otherwise.
     */
    boolean isActivePokemonAlive();

    /**
     * Makes a Pokemon evolve.
     *
     * @param pokemon Pokemon "evolved"
     */
    void makePokemonEvolve(IPokemon pokemon);

    /**
     * Plays a card.
     *
     * @param card Card meant to be played.
     */
    void playCard(ICard card);

    /**
     * Selects an ability.
     *
     * @param index Index in the list of abilities of the active pokemon.
     */
    void selectAbility(int index);

    /**
     * Selects a pokemon.
     *
     * @param pokemon Pokemon to be selected.
     */
    void setSelectedPokemon(IPokemon pokemon);

    /**
     * Chooses another active Pokemon once the currently active Pokemon dies.
     */
    void swapActivePokemon();

    /**
     * Uses selected attack ability.
     *
     * @param trainer Other trainer that receives the attack.
     */
    void useAttackAbility(ITrainer trainer);

    /**
     * Uses the selected ability.
     */
    void useAbility();

    /**
     * Throws a coin.
     *
     * @return Returns 0 or 1 (Heads or Tails).
     */
    int throwCoin();

    /**
     * Steals a card from the deck cards.
     */
    void stealCard();

    /**
     * Sets an opponent for the trainer.
     *
     * @param opponent The opponent of the trainer.
     */
    void setOpponent(ITrainer opponent);
}