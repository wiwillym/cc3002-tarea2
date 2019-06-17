package specificrequirements.electrickshock;

import cc3002.tarea2.*;
import cc3002.tarea2.fire.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ElectrickShockTest {

    private ElectricShock electricShock;
    private EnergyCounter costOfEnergies1 = new EnergyCounter();
    private ITrainer trainer1, trainer2;
    private IBasicPokemon dummy1;
    private List<IPokemon> benchList;
    private List<ICard> handList;
    private List<ICard> deckList;
    private List<ICard> discardPile;
    private List<ICard> rewardCards;
    private Visitor visitor;

    @Before
    public void setUp(){
        benchList = new ArrayList<>();
        handList = new ArrayList<>();
        deckList = new ArrayList<>();
        discardPile = new ArrayList<>();
        rewardCards = new ArrayList<>();
        electricShock = new ElectricShock("Electric Shock", 10, "DESCR", costOfEnergies1);
        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        trainer1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        trainer2 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void acceptTest(){
        trainer1.setOpponent(trainer2);
        assertEquals(100, dummy1.getHP());
        electricShock.accept(visitor);
        assertTrue((trainer1.getOpponentActivePokemon().getHP()==100)||(trainer1.getOpponentActivePokemon().getHP()==90));
    }
}
