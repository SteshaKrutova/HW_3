package HW_3.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
//    T getFather;
    //T getMother;
    String getName();
    LocalDate getBirthday();



}
