package gamedriver;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.BasicElectricPokemon;
import cc3002.tarea2.electric.ElectricAttack;
import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.fighting.BasicFightingPokemon;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.fire.Phase1FirePokemon;
import cc3002.tarea2.grass.BasicGrassPokemon;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.psychic.BasicPsychicPokemon;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.water.BasicWaterPokemon;
import cc3002.tarea2.water.Phase1WaterPokemon;
import cc3002.tarea2.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class GameDriverTest {

    private GameDriver gameDriver;
    private ITrainer player1, player2;
    private IPokemon
            dummy1,
            dummy2,
            dummy3,
            dummy4,
            dummy5,
            dummy6,
            dummy7,
            dummy8,
            dummy9,
            pokemonToEvolve,
            pokemonToEvolve2;
    private IEnergy
            electricEnergy,
            fightingEnergy,
            fireEnergy,
            grassEnergy,
            psychicEnergy,
            waterEnergy,
            electricEnergy2;
    private ICard
            pokemon1,
            energy1;
    private IAttack
            electricAttack;
    private List<ICard> handList, handList2, deckList, discardPile, rewardCards;
    private List<IPokemon> benchList, benchList2;
    private EnergyCounter costOfEnergies1 = new EnergyCounter();
    private EnergyCounter costOfEnergies2 = new EnergyCounter();
    private EnergyCounter costOfEnergies3 = new EnergyCounter();
    private EnergyCounter costOfEnergies4 = new EnergyCounter();
    private EnergyCounter costOfEnergies5 = new EnergyCounter();
    private EnergyCounter costOfEnergies6 = new EnergyCounter();
    private EnergyCounter costOfEnergies7 = new EnergyCounter();
    private EnergyCounter costOfEnergies8 = new EnergyCounter();
    private EnergyCounter costOfEnergies9 = new EnergyCounter();
    private EnergyCounter costOfEnergies10 = new EnergyCounter();

    @Before
    public void setUp(){
        electricAttack = new ElectricAttack("Thundershock", 40, "Does something1", costOfEnergies1);
        electricEnergy = new ElectricEnergy("electricenergy", "Does something");
        fightingEnergy = new FightingEnergy("fightingenergy", "Does something");
        fireEnergy = new FireEnergy("fireenergy", "Does something");
        grassEnergy = new GrassEnergy("grassenergy", "Does something");
        psychicEnergy = new PsychicEnergy("psychicenergy", "Does something");
        waterEnergy = new WaterEnergy("waterenergy", "Does something");
        electricEnergy2 = new ElectricEnergy("electricenergy 2", "Does something");
        energy1 = new GrassEnergy("energy", "Does something");

        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(Arrays.asList(electricAttack)), costOfEnergies1);
        dummy2 = new BasicWaterPokemon("2", 100, 100, null, new ArrayList<>(), costOfEnergies2);
        dummy3 = new BasicElectricPokemon("3", 100, 100, null, new ArrayList<>(), costOfEnergies3);
        dummy4 = new BasicGrassPokemon("4", 100, 100, null, new ArrayList<>(), costOfEnergies4);
        dummy5 = new BasicPsychicPokemon("5", 100, 100, null, new ArrayList<>(), costOfEnergies5);
        dummy6 = new BasicFightingPokemon("6", 100, 100, null, new ArrayList<>(), costOfEnergies6);
        dummy7 = new Phase1FirePokemon("1", 5, 100, null, new ArrayList<>(), costOfEnergies7);
        dummy8 = new BasicPsychicPokemon("8", 100, 100, null, new ArrayList<>(), costOfEnergies8);
        dummy9 = new BasicElectricPokemon("9", 100, 100, null, new ArrayList<>(), costOfEnergies9);
        pokemon1 = new BasicWaterPokemon("10", 100, 100, null, new ArrayList<>(), costOfEnergies10);
        pokemonToEvolve = new Phase1FirePokemon("1", 120, 120, null, new ArrayList<>(), costOfEnergies1);
        pokemonToEvolve2 = new Phase1WaterPokemon("2", 150, 150, null, new ArrayList<>(), costOfEnergies2);

        handList = new ArrayList<>(Arrays.asList(electricEnergy, fightingEnergy, fireEnergy, grassEnergy,
                psychicEnergy, waterEnergy, dummy8, dummy9));
        handList2 = new ArrayList<>(Arrays.asList((ICard) fightingEnergy, (ICard) fireEnergy));
        benchList = new ArrayList<>(Arrays.asList(dummy2, dummy3));
        benchList2 = new ArrayList<>(Arrays.asList(dummy4, dummy5, dummy6));
        deckList = new ArrayList<>();
        deckList.add(dummy6);
        deckList.add(dummy9);
        deckList.add(dummy5);
        rewardCards = new ArrayList<>();
        discardPile = new ArrayList<>();

        player1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        player2 = new Trainer(dummy7, benchList2, handList2, deckList, discardPile, rewardCards, null, null);

        gameDriver = new GameDriver(player1, player2, player1, true, true, true, true);
    }

    @Test
    public void startTurnTest(){
        gameDriver.startTurn();
        assertEquals(player1, gameDriver.getActualPlayer());
        assertNotEquals(player2, gameDriver.getActualPlayer());
        assertFalse(gameDriver.isPlayerOver());
        assertFalse(gameDriver.isFirstStepOver());
        assertFalse(gameDriver.isSecondStepOver());
        assertFalse(gameDriver.isThirdStepOver());
    }

    @Test
    public void stealCardFromDeckTest(){
        gameDriver.startTurn();
        gameDriver.stealCardFromDeck();
        assertEquals(new ArrayList<>(Arrays.asList(electricEnergy, fightingEnergy, fireEnergy, grassEnergy,
                psychicEnergy, waterEnergy, dummy8, dummy9, dummy6)), player1.getHandCards());
        gameDriver.stealCardFromDeck();
        assertEquals(new ArrayList<>(Arrays.asList(electricEnergy, fightingEnergy, fireEnergy, grassEnergy,
                psychicEnergy, waterEnergy, dummy8, dummy9, dummy6)), player1.getHandCards());
        assertNotEquals(new ArrayList<>(Arrays.asList(electricEnergy, fightingEnergy, fireEnergy, grassEnergy,
                psychicEnergy, waterEnergy, dummy8, dummy9, dummy6, dummy9)), player1.getHandCards());
    }

    @Test
    public void seeAllPokemonsOnGameTest(){
        gameDriver.startTurn();
        gameDriver.seeAllPokemonsOnGame();
        assertFalse(gameDriver.isSecondStepOver());
        gameDriver.setFistStepEnded(true);
        gameDriver.seeAllPokemonsOnGame();
        assertTrue(gameDriver.isSecondStepOver());
    }

    @Test
    public void seeHandCardsTest(){
        gameDriver.startTurn();
        gameDriver.seeHandCards(dummy7);
        assertEquals(dummy1, player1.getActivePokemon());
        gameDriver.setFistStepEnded(true);
        gameDriver.seeHandCards(dummy7);
        assertEquals(dummy1, player1.getActivePokemon());
    }

    @Test
    public void useActivePokemonAbilityTest(){
        gameDriver.startTurn();
        gameDriver.setFistStepEnded(true);
        gameDriver.useActivePokemonAbility(0);
        assertTrue(gameDriver.isSecondStepOver());
    }

    @Test
    public void attackTest(){
        gameDriver.startTurn();
        gameDriver.setFistStepEnded(true);
        gameDriver.setSecondStepEnded(true);
        gameDriver.attack(0);
        assertTrue(gameDriver.isThirdStepOver());
        assertEquals(0, player2.getActivePokemon().getHP());
    }

    @Test
    public void endTurn(){
        gameDriver.startTurn();
        assertFalse(gameDriver.isPlayerOver());
        gameDriver.endTurn();
        assertFalse(gameDriver.isPlayerOver());
        gameDriver.setFistStepEnded(true);
        gameDriver.setSecondStepEnded(true);
        gameDriver.setThirdStepEnded(true);
        gameDriver.endTurn();
        assertTrue(gameDriver.isPlayerOver());
    }

    @Test
    public void setActualPlayerTest(){
        gameDriver.startTurn();
        assertEquals(player1, gameDriver.getActualPlayer());
        gameDriver.setActualPlayer();
        assertNotEquals(player1, gameDriver.getActualPlayer());
        assertEquals(player2,gameDriver.getActualPlayer());
    }

    @Test
    public void setIfPlayerIsOverTest(){
        gameDriver.startTurn();
        assertFalse(gameDriver.isPlayerOver());
        gameDriver.setIfPlayerIsOver(true);
        assertTrue(gameDriver.isPlayerOver());
    }
}
