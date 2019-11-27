package familyTree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fyl on 7/16/19.
 */
public class Person {
    Person[] parents = new Person[2];
    String id; //unique
    String firstname;
    String lastname;
    List<Person> children = new ArrayList<>();
    List<Person> spouses = new ArrayList<>();
    Gender gender = Gender.MALE;
    Date birthday = new Date(0);

    // even if there are twin sisters, one must born before the other
    // including half sister
    public Person getOldestSister() {
        Person os1 = getOldestSisterFromParent(this.parents[0]);
        Person os2 = getOldestSisterFromParent(this.parents[1]);
        if (os1 == null) {
            return os2;
        }
        if (os2 == null) {
            return os1;
        }

        return os1.birthday.before(os2.birthday) ? os1 : os2;
    }

    public Person getOldestSisterFromParent(Person parent) {
        if (parent == null) {
            return null;
        }
        Person oldestSister = null;
        for (Person p : parent.children) {
            if (p.id != this.id && p.gender == Gender.FEMALE) {
                if (oldestSister == null) {
                    oldestSister = p;
                } else {
                    if (p.birthday.before(oldestSister.birthday)) {
                        oldestSister = p;
                    }
                }
            }
        }
        return oldestSister;
    }
}

enum Gender {
    MALE,
    FEMALE
}

//class Person {
//    private String name;
//    private Gender gender;
//    private List<Relation> relations = new ArrayList<>();
//
//    Person(String name, Gender gender) {
//        this.name = name;
//        this.gender = gender;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Relation> getRelations() {
//        return relations;
//    }
//
//    public void setRelations(List<Relation> relations) {
//        this.relations = relations;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//}
//
//class Relation {
//    private TreeRelationType type;
//    private Person person1;
//    private Person person2;
//
//    Relation(TreeRelationType type, Person person1, Person person2) {
//        this.type = type;
//        this.person1 = person1;
//        this.person2 = person2;
//    }
//
//    public TreeRelationType getType() {
//        return type;
//    }
//
//    public Person getPerson2() {
//        return person2;
//    }
//}
//
//enum TreeRelationType {
//    SPOUSE, PARENT, CHILD
//}
//
//enum Gender {
//    MALE, FEMALE
//}
//
//
// class FamilyTree {
//    private Person root;
//    private Map<String, Boolean> visted = new HashMap<>();
//
//    public Person getRoot() {
//        return root;
//    }
//
//    public void setRoot(Person root) {
//        this.root = root;
//    }
//
//    private Person findPerson(Person cur, String name) {
//        this.visted.put(cur.getName(), Boolean.TRUE);
//        if (cur.getName().equals(name)) {
//            this.visted.clear();
//            return cur;
//        } else {
//            for (Relation relation : cur.getRelations()) {
//                Person person2 = relation.getPerson2();
//                if (!visted.containsKey(person2.getName())) {
//                    Person person = findPerson(person2, name);
//                    if (person != null) {
//                        return person;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private List<Person> fetchChildren(String name) {
//        List<Person> children = new ArrayList<>();
//        Person person = findPerson(this.root, name);
//        for (Relation relation : person.getRelations()) {
//            if (TreeRelationType.CHILD.equals(relation.getType())) {
//                children.add(relation.getPerson2());
//            }
//        }
//        return children;
//    }
//
//    private List<Person> fetchParents(String name) {
//        List<Person> parents = new ArrayList<>();
//        Person person = findPerson(this.root, name);
//        for (Relation relation : person.getRelations()) {
//            if (TreeRelationType.PARENT.equals(relation.getType())) {
//                parents.add(relation.getPerson2());
//            }
//        }
//        return parents;
//    }
//
//    private Person fetchFather(String name){
//        Person father = null;
//        List<Person> parents = fetchParents(name);
//        for (Person person : parents) {
//            if (Gender.MALE.equals(person.getGender()))
//                father = person;
//        }
//        return father;
//    }
//
//    private List<Person> fetchSiblings(String name){
//        List<Person> siblings = new ArrayList<>();
//        Person father = fetchFather(name);
//        if (father != null) {
//            List<Person> children = fetchChildren(father.getName());
//            for (Person person : children) {
//                if (!person.getName().equals(name)) {
//                    siblings.add(person);
//                }
//            }
//        }
//        return siblings;
//    }
//
//    private List<Person> fetchSisters(String name){
//        List<Person> sisters = new ArrayList<>();
//        List<Person> siblings = fetchSiblings(name);
//        for (Person person : siblings) {
//            if (Gender.FEMALE.equals(person.getGender())) {
//                sisters.add(person);
//            }
//        }
//        return sisters;
//    }
//
//}