package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

/*
MemComposerDao to represent the operations in a composer data persistence layer.
 */
public class MemComposerDao {

    private List<Composer> composers;

    public MemComposerDao() {
        composers = new ArrayList<>(List.of(
                new Composer(1, "Ludwig van Beethoven", "Classical"),
                new Composer(2, "Wolfgang Amadeus Mozart", "Classical"),
                new Composer(3, "Johannes Brahms", "Classical"),
                new Composer(4, "Joseph Haydn", "Classical"),
                new Composer(5, "Johann Sebastian", "Classical")
        ));
    }   

    public List<Composer> findAll() {
        return composers;
    }

    public Composer findBy(int id) {
        for (Composer composer : composers) {
            if (composer.getId() == id) {
                return composer;
            }
        }
        return null; // Return null if no composer is found with the given id
    }

    //An overridden insert method that adds a new composer object to the list of composers
    public void insert(Composer composer) {
        composers.add(composer);
    }    
}
