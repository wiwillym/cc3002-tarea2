package cc3002.tarea2;

import cc3002.tarea2.trainercards.LuckyStadium;
import cc3002.tarea2.trainercards.Potion;
import cc3002.tarea2.trainercards.ProfessorJuniper;

/**
 * Class for the Visitor that plays cards.
 *
 * @author Guillermo Martinez Salazar.
 */
public class VisitorPlayCard extends Visitor{

    private VisitorCheckBasic visitorCheckBasic = new VisitorCheckBasic(trainer, false);
    private VisitorCheckPhase1 visitorCheckPhase1 = new VisitorCheckPhase1(trainer, false);

    /**
     * Creates a new Visitor.
     *
     * @param trainer Trainer of the visitor.
     */
    public VisitorPlayCard(ITrainer trainer) {
        super(trainer);
    }

    @Override
    public void visitBasicPokemon(IBasicPokemon pokemon) {
        trainer.addToBench(trainer.getHandCards().indexOf(pokemon));
        trainer.getHandCards().remove(pokemon);
    }

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon pokemon){
        trainer.getSelectedPokemon().accept(visitorCheckBasic);
        if (visitorCheckBasic.getVisitorStatus()) {
            trainer.makePokemonEvolve((IPokemon)pokemon);
        }
    }

    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon pokemon){
        trainer.getSelectedPokemon().accept(visitorCheckPhase1);
        if (visitorCheckPhase1.getVisitorStatus()){
            trainer.makePokemonEvolve((IPokemon)pokemon);
        }
    }

    @Override
    public void visitStrikesBack(StrikesBack strikesBackAbility){
        trainer.getOpponent().getActivePokemon().setHP(trainer.getOpponent().getActivePokemon().getHP() - 10);
    }

    @Override
    public void visitElectricShock(ElectricShock electricShockAttack){
        int n = trainer.getOpponent().throwCoin();
        if (n == 0){
            trainer.getOpponent().getActivePokemon().setHP(trainer.getOpponent().getActivePokemon().getHP() - electricShockAttack.getBaseDamage());
        }
    }

    @Override
    public void visitLuckyStadium(LuckyStadium luckyStadiumCard){
        int n = trainer.throwCoin();
        if (n == 0){
            trainer.stealCard();
        }
    }

    @Override
    public void visitPotion(Potion potionCard){
        if(trainer.getSelectedPokemon().getHP() < trainer.getSelectedPokemon().getMaxHP() - 10) {
            trainer.getSelectedPokemon().setHP(trainer.getSelectedPokemon().getHP() + 10);
        }
        else if (trainer.getSelectedPokemon().getHP() < trainer.getSelectedPokemon().getMaxHP()) {
            trainer.getSelectedPokemon().setHP(trainer.getSelectedPokemon().getMaxHP());
        }
    }

    @Override
    public void visitProfessorJuniper(ProfessorJuniper professorJuniperCard){
        for (int i = 0; i < trainer.getHandCards().size(); i++){
            trainer.addToDiscardPile(trainer.getHandCards().get(0));
            trainer.getHandCards().remove(trainer.getHandCards().get(0));
        }
        for (int i = 0; i < 7; i++){
            trainer.stealCard();
        }
    }
}

