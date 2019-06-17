package specificrequirements.luckystadium;

import cc3002.tarea2.*;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.trainercards.LuckyStadium;
import cc3002.tarea2.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LuckyStadiumTest {

    private LuckyStadium luckyStadium;
    private EnergyCounter costOfEnergies1 = new EnergyCounter();
    private ITrainer trainer1;
    private IBasicPokemon dummy1, dummy2;
    private List<IPokemon> benchList;
    private List<ICard> handList;
    private List<ICard> deckList;
    private List<ICard> discardPile;
    private List<ICard> rewardCards;
    private Visitor visitor;

    @Before
    public void setUp(){
        dummy2 = new BasicWaterPokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        benchList = new ArrayList<>();
        handList = new ArrayList<>();
        deckList = new ArrayList<>(Arrays.asList(dummy2, dummy1));
        discardPile = new ArrayList<>();
        rewardCards = new ArrayList<>();
        luckyStadium = new LuckyStadium("Lucky Stadium", "DESCR");
        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        trainer1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void acceptTest(){
        trainer1.addCardToHand(dummy1);
        assertEquals(new ArrayList<>(Arrays.asList(dummy1)), trainer1.getHandCards());
        luckyStadium.accept(visitor);
        assertTrue(new ArrayList<>(Arrays.asList(dummy1, dummy2)).equals(trainer1.getHandCards()) ||
                new ArrayList<>(Arrays.asList(dummy1)).equals(trainer1.getHandCards()));
    }
}
