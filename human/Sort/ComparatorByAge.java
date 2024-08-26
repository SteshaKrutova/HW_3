package family_free.family.human.Sort;

import HW_3.FamilyTree.TreeNode;

import java.util.Comparator;

public class ComparatorByAge<T extends TreeNode> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
