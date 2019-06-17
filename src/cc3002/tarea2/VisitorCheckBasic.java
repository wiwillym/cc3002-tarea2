package cc3002.tarea2;

/**
 * Class that represents the visitor that checks if a Pokemon is a basic Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public class VisitorCheckBasic extends Visitor {

    private boolean status;

    /**
     * Creates a new Visitor that checks if a Pokemon is a basic Pokemon.
     *
     * @param trainer Trainer of the Pokemon.
     * @param status Status that indicates if the Pokemon is a basic Pokemon or not.
     */
    public VisitorCheckBasic(ITrainer trainer, boolean status){
        super(trainer);
        this.status = false;
    }

    @Override
    public void visitBasicPokemon(IBasicPokemon pokemon){
        status = true;
    }

    /**
     * Getter for the Visitor status.
     *
     * @return <code>true</code> if the Pokemon is a basic Pokemon, <code>false</code> otherwise.
     */
    public boolean getVisitorStatus(){
        return status;
    }
}
