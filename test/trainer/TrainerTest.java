package trainer;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.BasicElectricPokemon;
import cc3002.tarea2.electric.ElectricAttack;
import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.electric.AbstractElectricPokemon;
import cc3002.tarea2.fighting.BasicFightingPokemon;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fighting.AbstractFightingPokemon;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.fire.AbstractFirePokemon;
import cc3002.tarea2.fire.Phase1FirePokemon;
import cc3002.tarea2.grass.BasicGrassPokemon;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.grass.AbstractGrassPokemon;
import cc3002.tarea2.psychic.BasicPsychicPokemon;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.psychic.AbstractPsychicPokemon;
import cc3002.tarea2.water.BasicWaterPokemon;
import cc3002.tarea2.water.Phase1WaterPokemon;
import cc3002.tarea2.water.WaterEnergy;
import cc3002.tarea2.water.AbstractWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class TrainerTest {

    private ITrainer
            trainer1,
            trainer2,
            trainer3;
    private List<ICard> handList, handList2, handtest1, handtest2, decklist, discardpile, rewardcards;
    private List<IPokemon> pokemonList, pokemonList2;
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
    private EnergyCounter test1 = new EnergyCounter();

    @Before
    public void setUp() {
        electricAttack = new ElectricAttack("Thundershock", 40, "Does something1", costOfEnergies1);
        electricEnergy = new ElectricEnergy("electricenergy", "Does something");
        fightingEnergy = new FightingEnergy("fightingenergy", "Does something");
        fireEnergy = new FireEnergy("fireenergy", "Does something");
        grassEnergy = new GrassEnergy("grassenergy", "Does something");
        psychicEnergy = new PsychicEnergy("psychicenergy", "Does something");
        waterEnergy = new WaterEnergy("waterenergy", "Does something");
        electricEnergy2 = new ElectricEnergy("electricenergy 2", "Does something");
        energy1 = new GrassEnergy("energy", "Does something");

        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), costOfEnergies1);
        dummy2 = new BasicWaterPokemon("2", 100, 100, null, new ArrayList<>(), costOfEnergies2);
        dummy3 = new BasicElectricPokemon("3", 100, 100, null, new ArrayList<>(), costOfEnergies3);
        dummy4 = new BasicGrassPokemon("4", 100, 100, null, new ArrayList<>(), costOfEnergies4);
        dummy5 = new BasicPsychicPokemon("5", 100, 100, null, new ArrayList<>(), costOfEnergies5);
        dummy6 = new BasicFightingPokemon("6", 100, 100, null, new ArrayList<>(), costOfEnergies6);
        dummy7 = new BasicFirePokemon("7", 5, 100, null, new ArrayList<>(), costOfEnergies7);
        dummy8 = new BasicPsychicPokemon("8", 100, 100, null, new ArrayList<>(), costOfEnergies8);
        dummy9 = new BasicElectricPokemon("9", 100, 100, null, new ArrayList<>(), costOfEnergies9);
        pokemon1 = new BasicWaterPokemon("10", 100, 100, null, new ArrayList<>(), costOfEnergies10);
        pokemonToEvolve = new Phase1FirePokemon("1", 120, 120, null, new ArrayList<>(), costOfEnergies1);
        pokemonToEvolve2 = new Phase1WaterPokemon("2", 150, 150, null, new ArrayList<>(), costOfEnergies2);

        handList = new ArrayList<>(Arrays.asList(electricEnergy, fightingEnergy, fireEnergy, grassEnergy,
                psychicEnergy, waterEnergy, dummy8, dummy9));
        handtest1 = new ArrayList<>();
        handtest2 = new ArrayList<>();
        handList2 = new ArrayList<>(Arrays.asList((ICard) fightingEnergy, (ICard) fireEnergy));
        pokemonList = new ArrayList<>(Arrays.asList(dummy2, dummy3));
        pokemonList2 = new ArrayList<>(Arrays.asList(dummy4, dummy5, dummy6));
        decklist = new ArrayList<>();
        rewardcards = new ArrayList<>();
        discardpile = new ArrayList<>();

        trainer1 = new Trainer(dummy1, pokemonList, handList, decklist, discardpile, rewardcards, null, null);
        trainer2 = new Trainer(dummy7, pokemonList2, handList2, decklist, discardpile, rewardcards, null, null);
        trainer3 = new Trainer(dummy2, pokemonList2, handtest2, decklist, discardpile, rewardcards, null, null);
    }

    @Test
    public void constructorTest() {
        assertEquals(dummy1, trainer1.getActivePokemon());
        assertEquals(pokemonList, trainer1.getBenchCards());
        assertNotEquals(dummy2, trainer1.getActivePokemon());
    }

    @Test
    public void getActivePokemonTest(){
        assertEquals(dummy7, trainer2.getActivePokemon());
        assertNotEquals(dummy4, trainer1.getActivePokemon());
        assertNotEquals(dummy5, trainer1.getActivePokemon());
        assertNotEquals(dummy6, trainer2.getActivePokemon());
    }

    @Test
    public void swapActivePokemonTest() {
        assertEquals(dummy1, trainer1.getActivePokemon());
        trainer1.swapActivePokemon();
        assertEquals(dummy2, trainer1.getActivePokemon());
        assertEquals(dummy3, pokemonList.get(0));
    }

    @Test
    public void useEnergyCardTest() {
        trainer1.setSelectedPokemon(trainer1.getActivePokemon());
        assertEquals(dummy1.getEnergies().getElectricEnergy(), test1.getElectricEnergy());
        trainer1.playCard(electricEnergy);
        assertNotEquals(dummy1.getEnergies().getElectricEnergy(), test1.getElectricEnergy());
        test1.setElectricEnergy(1);
        assertEquals(dummy1.getEnergies().getElectricEnergy(), test1.getElectricEnergy());
    }

    @Test
    public void addPokemonToBenchTest() {
        assertEquals(new ArrayList<>(Arrays.asList(dummy2, dummy3)), trainer1.getBenchCards());
        trainer1.addToBench(6);
        trainer1.addToBench(6);
        assertEquals(new ArrayList<>(Arrays.asList(dummy2, dummy3, dummy8, dummy9)),
                trainer1.getBenchCards());
    }

    @Test
    public void isActivePokemonAliveTest(){
        assertTrue(trainer1.isActivePokemonAlive());
        dummy1.setHP(0);
        assertFalse(trainer1.isActivePokemonAlive());
    }

    @Test
    public void selectAbilityTest(){
        assertNull(trainer2.getActivePokemon().getSelectedAbility());
        dummy7.addAbility(electricAttack);
        trainer2.selectAbility(0);
        assertEquals(electricAttack, trainer2.getActivePokemon().getSelectedAbility());
    }

    @Test
    public void useAttackAbilityTest(){
        dummy7.addAbility(electricAttack);
        assertEquals(100, trainer1.getActivePokemon().getHP());
        trainer2.selectAbility(0);
        trainer2.useAttackAbility(trainer1);
        assertEquals(60, trainer1.getActivePokemon().getHP());
    }

    @Test
    public void addAndGetHandCardsTest() {
        assertEquals(handtest1, trainer3.getHandCards());
        handtest1.add(waterEnergy);
        handtest1.add(dummy5);
        assertNotEquals(handtest1, trainer3.getHandCards());
        trainer3.addCardToHand(waterEnergy);
        trainer3.addCardToHand(dummy5);
        assertEquals(handtest1, trainer3.getHandCards());
    }

    @Test
    public void addToRewardCardsTest(){
        assertEquals(new ArrayList<>(), trainer1.getRewardCards());
        trainer1.addToRewardCards(dummy5);
        assertEquals(new ArrayList<>(Arrays.asList(dummy5)), trainer1.getRewardCards());
    }

    @Test
    public void evolvePokemonTest(){
        trainer1.addCardToHand(pokemonToEvolve2);
        assertEquals(dummy1,trainer1.getActivePokemon());
        trainer1.setSelectedPokemon(dummy1);
        trainer1.makePokemonEvolve(pokemonToEvolve);
        assertEquals(pokemonToEvolve, trainer1.getActivePokemon());
        assertEquals(new ArrayList<>(Arrays.asList(dummy2, dummy3)), trainer1.getBenchCards());
        trainer1.setSelectedPokemon(dummy2);
        trainer1.makePokemonEvolve(pokemonToEvolve2);
        assertEquals(new ArrayList<>(Arrays.asList(dummy3, pokemonToEvolve2)), trainer1.getBenchCards());
    }

    @Test
    public void getOpponentActivePokemonTest(){
        trainer1.setOpponent(trainer2);
        assertEquals(dummy7, trainer1.getOpponentActivePokemon());
    }

    @Test
    public void getOpponentBenchCards(){
        trainer1.setOpponent(trainer2);
        assertEquals(new ArrayList<>(Arrays.asList(dummy4, dummy5, dummy6)), trainer1.getOpponentBenchCards());
    }


    @Test
    public void equalsTest(){
        assertNotEquals(new Trainer(dummy1, pokemonList, handList, decklist, discardpile, rewardcards, null, null), trainer3);
        assertEquals(new Trainer(dummy1, pokemonList, handList, decklist, discardpile, rewardcards, null, null), trainer1);
    }
}
