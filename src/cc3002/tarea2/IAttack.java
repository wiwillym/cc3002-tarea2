package cc3002.tarea2;

/**
 * Common interface for all the attacks. Every attack has a name and a base damage, and should be
 * able to damage a Pokemon.
 *
 * @author Guillermo Martinez Salazar
 */

public interface IAttack extends IAbility {

    /**
     * Getter for the base damage.
     *
     * @return Base damage of the attack.
     */
    int getBaseDamage();
}
