package cc3002.tarea2;

/**
 * Game logic controller class.
 *
 * @author Guillermo Martinez Salazar.
 */
public class GameDriver {

    private ITrainer
            player1,
            player2,
            actualPlayer;
    private boolean
            isPlayerOver,
            firstStepOver,
            secondStepOver,
            thirdStepOver;

    /**
     * Creates a new Game.
     *
     * @param player1 Player 1.
     * @param player2 Player 2.
     * @param actualPlayer Player currently playing.
     * @param isPlayerOver Indicates if the player has ended its turn.
     * @param firstStepOver Indicates if the first step is over.
     * @param secondStepOver Indicates if the second step is over.
     * @param thirdStepOver Indicates if the third step is over.
     */
    public GameDriver(ITrainer player1, ITrainer player2, ITrainer actualPlayer,
                      boolean isPlayerOver, boolean firstStepOver, boolean secondStepOver,
                      boolean thirdStepOver) {
        this.player1 = player1;
        this.player2 = player2;
        this.actualPlayer = actualPlayer;
        this.isPlayerOver = true;
        this.firstStepOver = true;
        this.secondStepOver = true;
        this.thirdStepOver = true;
    }

    /**
     * Starts a turn for a player.
     */
    public void startTurn(){
        this.isPlayerOver = false;
        this.firstStepOver = false;
        this.secondStepOver = false;
        this.thirdStepOver = false;
        player1.setOpponent(player2);
        player2.setOpponent(player1);
    }

    /**
     * The player steals a card from the deck of cards and the first step of the
     * turn has ended.
     */
    public void stealCardFromDeck(){
        if (!this.firstStepOver) {
            actualPlayer.stealCard();
            setFistStepEnded(true);
        }
    }


    /**
     * The player gets to see his hand cards and plays a card, then the second
     * step of the turn has ended.
     *
     * @param card Card played.
     */
    public void seeHandCards(ICard card){
        if (!this.secondStepOver && this.firstStepOver){
            actualPlayer.getHandCards();
            actualPlayer.playCard(card);
            setSecondStepEnded(true);
        }
    }

    /**
     * The player gets to see all the Pokemons on the game, finishing the
     * second step of the turn.
     */
    public void seeAllPokemonsOnGame(){
        if(!this.secondStepOver && this.firstStepOver){
            actualPlayer.getActivePokemon();
            actualPlayer.getBenchCards();
            actualPlayer.getOpponentActivePokemon();
            actualPlayer.getOpponentBenchCards();
            setSecondStepEnded(true);
        }
    }

    /**
     * The player selects and uses an ability of its active Pokemon and
     * the second step of the turn ends.
     *
     * @param index Index of the ability to select and use.
     */
    public void useActivePokemonAbility(int index){
        if (!this.secondStepOver && this.firstStepOver) {
            actualPlayer.selectAbility(index);
            actualPlayer.useAbility();
            setSecondStepEnded(true);
        }
    }

    /**
     * Let the player attacks the opponent, ending the players turn.
     *
     * @param index Index of the attack to use.
     */
    public void attack(int index){
        if (!thirdStepOver && this.firstStepOver && this.secondStepOver) {
            player1.selectAbility(index);
            player1.getActivePokemon().attack(player2);
            setThirdStepEnded(true);
            endTurn();
        }
    }

    /**
     * Ends the turn of a player.
     */
    public void endTurn(){
        if (firstStepOver && secondStepOver && thirdStepOver){
            setIfPlayerIsOver(true);
        }
        this.setActualPlayer();
    }

    /**
     * Sets the player that is going to play the turn.
     */
    public void setActualPlayer(){
        if (this.getActualPlayer().equals(player1)){
            this.actualPlayer = player2;
        }
        else {
            this.actualPlayer = player1;
        }
    }


    /**
     * Getter for the actual player of the turn.
     *
     * @return The player playing the turn.
     */
    public ITrainer getActualPlayer(){
        return this.actualPlayer;
    }

    /**
     * Method to see if the player is over or not.
     *
     * @return <code>true</code> if the player is over, <code>false</code> otherwise.
     */
    public boolean isPlayerOver(){
        return isPlayerOver;
    }

    /**
     * Method to see if the first step is over or not.
     *
     * @return <code>true</code> if the first step is over, <code>false</code> otherwise.
     */
    public boolean isFirstStepOver(){
        return firstStepOver;
    }

    /**
     * Method to see if the second step is over or not.
     *
     * @return <code>true</code> if the second step is over, <code>false</code> otherwise.
     */
    public boolean isSecondStepOver(){
        return secondStepOver;
    }

    /**
     * Method to see if the third step is over or not.
     *
     * @return <code>true</code> if the third step is over, <code>false</code> otherwise.
     */
    public boolean isThirdStepOver(){
        return thirdStepOver;
    }

    /**
     * Sets if the player is over or not.
     *
     * @param over <code>true</code> if the player is over, <code>false</code> otherwise.
     */
    public void setIfPlayerIsOver(boolean over){
        this.isPlayerOver = over;
    }

    /**
     * Sets if the first step is over or not.
     *
     * @param over <code>true</code> if the first step is over, <code>false</code> otherwise.
     */
    public void setFistStepEnded(boolean over){
        this.firstStepOver = over;
    }

    /**
     * Sets if the second step is over or not.
     *
     * @param over <code>true</code> if the second step is over, <code>false</code> otherwise.
     */
    public void setSecondStepEnded(boolean over){
        this.secondStepOver = over;
    }

    /**
     * Sets if the third step is over or not.
     *
     * @param over <code>true</code> if the third step is over, <code>false</code> otherwise.
     */
    public void setThirdStepEnded(boolean over){
        this.thirdStepOver = over;
    }
}
