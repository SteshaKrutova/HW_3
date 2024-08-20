package family_free.family.buider.FamilyTree;

import family_free.family.buider.human.Human;

import java.util.Iterator;
import java.util.List;

public class iterator implements  Iterator<Human> {
    private int index;
    private List<Human> family;

    public iterator(List<Human> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public Human next() {
        return family.get(index++);
    }
}
