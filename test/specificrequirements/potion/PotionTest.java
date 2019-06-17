package specificrequirements.potion;

import cc3002.tarea2.*;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.trainercards.Potion;
import cc3002.tarea2.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PotionTest {

    private Potion potion;
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
        handList = new ArrayList<>();
        deckList = new ArrayList<>(Arrays.asList(dummy2, dummy1));
        discardPile = new ArrayList<>();
        rewardCards = new ArrayList<>();
        potion = new Potion("Potion", "DESCR");
        dummy1 = new BasicFirePokemon("1", 89, 100, null, new ArrayList<>(), costOfEnergies1);
        dummy2 = new BasicWaterPokemon("1", 95, 100, null, new ArrayList<>(), costOfEnergies1);
        trainer1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void acceptTest(){
        trainer1.setSelectedPokemon(dummy1);
        potion.accept(visitor);
        assertEquals(99, dummy1.getHP());
        trainer1.setSelectedPokemon(dummy2);
        potion.accept(visitor);
        assertEquals(100, dummy2.getHP());
    }
}
