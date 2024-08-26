package family_free.family.FamilyTree;

import HW_3.FamilyTree.TreeNode;
import HW_3.human.Human;
import family_free.family.human.Sort.ComparatorByAge;
import family_free.family.human.Sort.ComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    //переменая для генирации индентификаторов
    private long humansId;
    //список людей
    private List<E> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList){
        //обычный сеттер принимает лист и записывает его
        this.humanList = humanList;
    }

    public void addHumanNew(E human){
        humanList.add(human);
    }

    public boolean addHuman(E human){
        //если передили пустую ссылку, то эту ссылку мы не добавляем в дерево
        if (human ==null){
            return false;
        }
        if (!(humanList.contains(human))){
            humanList.add(human);
            human.setId((int) humansId++);

            addToParants((Human) human);
        }
        return false;
    }

    private void addToParants(Human human){
        for (Human parant: human.getParants()){
            parant.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addChild(human);
        }
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if(human.getName()==name){
                res.add((E) human);
            }
        }
        return res;
    }

    public E getById(long id){
        for(E human:humanList){
            if(human.getId()==id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        humanList.sort(new ComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge());
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

//My
//    public List<List<Human>> getAllDescendants(Human human){
//        if (human.getChildren().size()==0) {
//            return null;
//        }
//        else {
//            List<List<Human>> res = new ArrayList<>();
//        }
//        long id = human.getId();
//
//        for (Human i:humanList){
//            if(i.getChildren().size()!=0) {
//                if (i.getId() == id) {
//                    for (Human child : i.getChildren()) {
//                        res.add(getAllDescendants(child));
//                    }
//                }
//            }
//    }
//        return res;
//    }