package specificrequirements.professorjuniper;

import cc3002.tarea2.*;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.trainercards.ProfessorJuniper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ProfessorJuniperTest {

    private ProfessorJuniper professorJuniper;
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
        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        dummy2 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        benchList = new ArrayList<>();
        handList = new ArrayList<>(Arrays.asList(dummy1));
        deckList = new ArrayList<>(Arrays.asList(dummy2, dummy1, dummy2, dummy2, dummy1, dummy2, dummy2));
        discardPile = new ArrayList<>();
        rewardCards = new ArrayList<>();
        professorJuniper = new ProfessorJuniper("Professor Juniper", "DESCR");
        trainer1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        trainer2 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void acceptTest(){
        assertEquals(new ArrayList<>(Arrays.asList(dummy1)), trainer1.getHandCards());
        professorJuniper.accept(visitor);
        assertEquals(new ArrayList<>(Arrays.asList(dummy2, dummy1, dummy2, dummy2, dummy1, dummy2, dummy2)), trainer1.getHandCards());
    }
}
