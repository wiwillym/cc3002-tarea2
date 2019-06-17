package cc3002.tarea2;

import java.util.List;
import java.util.Random;

/**
 * Class that represents a trainer. This class contains the necessary methods to get information
 * about the trainer, to use energy cards and swap active Pokemon.
 *
 * @author Guillermo Martinez Salazar
 */

public class Trainer implements ITrainer {
    private IPokemon activePokemon;
    private List<IPokemon> benchList;
    private List<ICard> handList;
    private List<ICard> deckList;
    private List<ICard> discardPile;
    private List<ICard> rewardCards;
    private IPokemon selectedPokemon;
    private ITrainer opponent;

    /**
     * Creates a new Trainer.
     *
     * @param activePokemon Active Pokemon of the Trainer.
     * @param benchList Bench cards of the Trainer.
     * @param handList Hand cards of the trainer.
     * @param deckList Deck cards of the Trainer.
     * @param discardPile Discard pile of the Trainer.
     * @param rewardCards Reward cards of the Trainer.
     * @param selectedPokemon Pokemon the Trainer selected.
     * @param opponent The opponent of the Trainer.
     */
    public Trainer(IPokemon activePokemon, List<IPokemon> benchList,
                   List<ICard> handList, List<ICard> deckList, List<ICard> discardPile,
                   List<ICard> rewardCards, IPokemon selectedPokemon, ITrainer opponent){
        this.activePokemon = activePokemon;
        this.benchList = benchList;
        this.handList = handList;
        this.deckList = deckList;
        this.discardPile = discardPile;
        this.rewardCards = rewardCards;
        this.selectedPokemon = null;
        this.opponent = null;
    }

    @Override
    public void addCardToHand(ICard card){
        this.handList.add(card);
    }

    @Override
    public void addToBench(int index) {
        if (this.benchList.size() < 5) {
            this.benchList.add((IPokemon) handList.get(index));
            this.handList.remove(index);
        }
    }

    @Override
    public void addToDiscardPile(ICard card){
        this.discardPile.add(card);
    }

    @Override
    public void addToRewardCards(ICard card){
        if (this.rewardCards.size() < 6){
            this.rewardCards.add(card);
        }
    }

    @Override
    public void evolveActivePokemon(IPokemon pokemon){
        if (this.getActivePokemon().getPokedexNumber() == pokemon.getPokedexNumber()) {
            this.addToDiscardPile(this.getActivePokemon());
            this.activePokemon = pokemon;
        }
    }

    /*
    @Override
    public void makePokemonEvolve(IPokemon pokemon){
        if (this.getActivePokemon().getPokedexNumber().equals(pokemon.getPokedexNumber())){
            this.evolveActivePokemon(pokemon);
            this.getHandCards().remove(pokemon);
        }
        else{
            for (IPokemon foundpokemon : this.getBenchCards()){
                if (foundpokemon.getPokedexNumber().equals(pokemon.getPokedexNumber())){
                    this.addToDiscardPile(foundpokemon);
                    this.getBenchCards().remove(foundpokemon);
                    this.addToBench(this.getHandCards().indexOf(pokemon));
                    this.getHandCards().remove(pokemon);
                }
            }
        }
    }
     */

    @Override
    public void makePokemonEvolve(IPokemon pokemon){
        if (selectedPokemon.equals(this.getActivePokemon())){
            this.evolveActivePokemon(pokemon);
        }
        else{
            if (selectedPokemon.getPokedexNumber() == pokemon.getPokedexNumber()) {
                this.addToDiscardPile(selectedPokemon);
                this.getBenchCards().remove(selectedPokemon);
                this.addToBench(this.getHandCards().indexOf(pokemon));
                this.getHandCards().remove(pokemon);
            }
        }
    }

    @Override
    public IPokemon getActivePokemon(){
        return activePokemon;
    }

    public IPokemon getOpponentActivePokemon(){
        return this.opponent.getActivePokemon();
    }

    @Override
    public List<IPokemon> getBenchCards(){
        return benchList;
    }

    public List<IPokemon> getOpponentBenchCards(){
        return this.opponent.getBenchCards();
    }

    @Override
    public List<ICard> getHandCards(){
        return handList;
    }

    @Override
    public List<ICard> getDiscardPile(){
        return this.discardPile;
    }

    @Override
    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }

    @Override
    public List<ICard> getRewardCards(){
        return this.rewardCards;
    }

    @Override
    public ITrainer getOpponent(){
        return this.opponent;
    }

    @Override
    public boolean isActivePokemonAlive(){
        return this.activePokemon.getHP() > 0;
    }

    @Override
    public void playCard(ICard card){
        card.play(this);
    }

    @Override
    public void swapActivePokemon(){
        this.activePokemon = benchList.get(0);
        this.benchList.remove(0);
    }

    @Override
    public void selectAbility(int index){
        activePokemon.selectAbility(index);
    }

    @Override
    public void setSelectedPokemon(IPokemon pokemon){
        this.selectedPokemon = pokemon;
    }

    @Override
    public void setOpponent(ITrainer opponent){
        this.opponent = opponent;
    }

    @Override
    public void stealCard(){
        this.addCardToHand(this.deckList.get(0));
        deckList.remove(0);
    }

    public int throwCoin(){
        Random r = new Random();
        return r.nextInt(2);
    }

    //OJO CON ESTA
    @Override
    public void useAttackAbility(ITrainer opponent){
        this.activePokemon.genericAttack(opponent);
    }

    @Override
    public void useAbility(){
        activePokemon.play(opponent);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof ITrainer && ((ITrainer) obj).getActivePokemon().equals(activePokemon)
                && ((ITrainer) obj).getHandCards().equals(handList)
                && ((ITrainer) obj).getBenchCards().equals(benchList);
    }
}
