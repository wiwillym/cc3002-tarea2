package cc3002.tarea2;

/**
 * Class that represents the visitor that checks if a Pokemon is a phase 1 Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public class VisitorCheckPhase1 extends Visitor {

    private boolean status;

    /**
     * Creates a new Visitor that checks if a Pokemon is a phase 1 Pokemon.
     *
     * @param trainer Trainer of the Pokemon.
     * @param status Status that indicates if the Pokemon is a phase 1 Pokemon or not.
     */
    public VisitorCheckPhase1(ITrainer trainer, boolean status){
        super(trainer);
        this.status = false;
    }

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon pokemon){
        status = true;
    }

    /**
     * Getter for the Visitor status.
     *
     * @return <code>true</code> if the Pokemon is a phase 1 Pokemon, <code>false</code> otherwise.
     */
    public boolean getVisitorStatus(){
        return status;
    }
}
