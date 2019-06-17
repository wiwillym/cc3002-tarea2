# Tarea 2 - Pokémon TCG: Electric Boogaloo

Se implementó un clon del juego de cartas Pokémon. En el juego los participantes asumen el rol de entrenadores Pokémon y usan sus Pokémon para pelear con sus oponentes. Los entrenadores juegan sus cartas al campo de juego con el objetivo proncipal de derrotar a los Pokémon de su oponente.
Existen las entidades Entrenador y Carta, en donde carta puede ser un Pokemon, una abilidad o bien una carta especial.

## Descripción

Se decidió utilizar las siguientes interfaces en la implementación:

* IAbility
* IAttack
* IBasicPokemon
* ICard
* IEnergy
* IPhase1Pokemon
* IPhase2Pokemon
* IPokemon
* ITrainer
* ITrainerCard
* IVisitor

En donde cabe recalcar que los ataques son un tipo de habilidad, y los pokemones básicos, de fase 1 o fase 2 son a su vez un tipo de pokemon.
Además, las cartas de entrenador son cartas especiales, las cuales pueden ser cartas de objeto, cartas de estadio, o cartas de soporte.

Se utilizaron las siguientes clases abstractas, todas debido a la enorme cantidad de subclases que las pueden extender 
debido a que existen muchas cartas o ataques de cada tipo. En adición, la clase abstracta Visitor se utilizo para bajar el costo de
añadir nuevas operaciones (mediante el patrón de diseño Visitor Pattern):

* AbstractPokemon
* AbstractElectricPokemon
* AbstractFightingPokemon
* AbstractFirePokemon
* AbstractGrassPokemon
* AbstractPsychicPokemon
* AbstractWaterPokemon
* AbstractItemCard
* AbstractStadiumCard
* AbstractSupporterCard
* AbstractAbility
* AbstractAttack
* AbstractCard
* AbstractEnergy
* AbstractTrainerCard
* Visitor


Por último se definieron las siguientes clases que extienden a sus respectivas clases abstractas, a excepción de Trainer, GameDriver y EnergyCounter:

* BasicElectricPokemon
* BasicFightingPokemon
* BasicFirePokemon
* BasicGrassPokemon
* BasicPsychicPokemon
* BasicWaterPokemon
* Phase1ElectricPokemon
* Phase1FightingPokemon
* Phase1FirePokemon
* Phase1GrassPokemon
* Phase1PsychicPokemon
* Phase1WaterPokemon
* Phase2ElectricPokemon
* Phase2FightingPokemon
* Phase2FirePokemon
* Phase2GrassPokemon
* Phase2PsychicPokemon
* Phase2WaterPokemon
* ElectricAttack
* FightingAttack
* FireAttack
* GrassAttack
* PsychicAttack
* WaterAttack
* ElectricEnergy
* FightingEnergy
* FireEnergy
* GrassEnergy
* PsychicEnergy
* WaterEnergy
* LuckyStadium
* Potion
* ProfessorJuniper
* ElectricShock
* StrikesBack
* EnergyCounter
* GameDriver
* Trainer
* VisitorCheckBasic
* VisitorCheckPhase1
* VisitorPlayCard

Las clases abstractas se definieron para así poder tener distintos tipos de Pokémon, ataques, habilidades y energías.

Tambien existe una clase enumtype que contiene los 6 distintos tipos de energia (GRASS, FIRE, WATER, ELECTRIC, FIGHTING, PSYCHIC):

* EnergyType


### Funcionalidades opcionales

Se implementaron las siguientes funcionalidades opcionales:

* Lucky Stadium
* Potion
* Professor Juniper
* Electric Shock
* Strikes Back

Los tests que prueban estas funcionalidades se encuentran dentro del paquete "specificrequirementes", cuyas clases correspondientes son:

* LuckyStadiumTest
* PotionTest
* ProfessorJuniperTest
* ElectricShockTest
* StrikesBackTest

### Correr el programa

Por ahora lo único que se puede probar en el programa son los tests definidos que cubren aproximadamente un 95% de las líneas de métodos.
Para correr los tests se debe tener clonado o descargado el programa. Una vez clonado y abierto con IntelliJ IDEA se debe hacer click derecho en la carpeta test > Run 'All Tests' with Coverage.

### Instalar

Para instalar el programa se debe clonar o descargar el repositorio. Luego, utilizando IntelliJ IDEA se debe abrir un nuevo proyecto indicando el directorio en el cual se clonó o descargó el repositorio.

## Autores

* **Guillermo Martínez Salazar** - [wiwillym](https://github.com/wiwillym)
