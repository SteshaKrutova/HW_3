package family_free.family.buider.human.Sort;

import family_free.family.buider.human.Human;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
