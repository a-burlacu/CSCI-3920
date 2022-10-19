package ser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {

    //the version of the class the obj was serialized with and the version of the class the JVM loaded the obj with
    // have to match or it will cause problems
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    private List<String> livedInPlaces;
    transient private List<String> visitedPlaces;
    //transient means makes sense to keep in memory but not to serialize it


    public Person(String name, int age){
        this.name = name;
        this.age = age;

        this.livedInPlaces = new ArrayList<>();
        this.visitedPlaces = new ArrayList<>();
    }


    public void addLivedIn(String city) {
        this.livedInPlaces.add(city);
    }
    public void addVisitedIn(String city) {
        this.visitedPlaces.add(city);
    }

    @Override
    public String toString(){
        return "Person:" + this.name +
                "\nAge:"+ this.age +
                "\nLivedIn:" + this.livedInPlaces +
                "\nVisited:" + this.visitedPlaces +
                "\n-------------------------------";
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public static Person getSamplePerson() {
        Person p = new Person("John",30);
        p.addLivedIn("NYC");
        p.addLivedIn("Denver");

        p.addVisitedIn("Los Angeles");
        p.addVisitedIn("San Diego");

        return p;
    }

}
