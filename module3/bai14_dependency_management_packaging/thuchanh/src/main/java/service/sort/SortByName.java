package service.sort;

import bean.User;

import java.util.Comparator;

public class SortByName implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        String name1 = o1.getName().substring(o1.getName().lastIndexOf(" ") + 1);
        String name2 = o2.getName().substring(o2.getName().lastIndexOf(" ") + 1);
        return name1.compareTo(name2);
    }
}
