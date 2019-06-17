package specificrequirements.strikesback;

import cc3002.tarea2.*;
import cc3002.tarea2.fire.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class StrikesBackTest {

    private StrikesBack strikesBack;
    private EnergyCounter costOfEnergies1 = new EnergyCounter();
    private ITrainer trainer1, trainer2;
    private IBasicPokemon dummy1, dummy2;
    private List<IPokemon> benchList;
    private List<ICard> handList;
    private List<ICard> deckList;
    private List<ICard> discardPile;
    private List<ICard> rewardCards;
    private Visitor visitor;

    @Before
    public void setUp(){
        benchList = new ArrayList<>();
        handList = new ArrayList<>(Arrays.asList(dummy1));
        deckList = new ArrayList<>(Arrays.asList(dummy2, dummy1, dummy2, dummy2, dummy1, dummy2, dummy2));
        discardPile = new ArrayList<>();
        rewardCards = new ArrayList<>();
        strikesBack = new StrikesBack("Electric Shock", "DESCR", costOfEnergies1);
        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        trainer1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        trainer2 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void acceptTest(){
        trainer1.setOpponent(trainer2);
        assertEquals(100, trainer2.getActivePokemon().getHP());
        strikesBack.accept(visitor);
        assertEquals(90, trainer2.getActivePokemon().getHP());
    }
}
