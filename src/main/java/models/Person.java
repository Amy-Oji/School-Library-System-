package models;

import enums.PersonStatus;

public class Person {
    private String name;
    private String LibCardId;
    private final PersonStatus personStatus;
    private int priority;

    public Person(String name, String libCardId, PersonStatus personStatus) {
        this.name = name;
        this.LibCardId = libCardId;
        this.personStatus = personStatus;
        setPriority();
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibCardId() {
        return LibCardId;
    }

    public void setLibCardId(String libCardId) {
        LibCardId = libCardId;
    }

    public PersonStatus getPersonStatus() {
        return personStatus;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(){
        if (personStatus == PersonStatus.TEACHER){
            this.priority = PersonStatus.TEACHER.getPriority();
            }else if(personStatus == PersonStatus.SENIOR_STUDENT){
            this.priority = PersonStatus.SENIOR_STUDENT.getPriority();
        }else{
            this.priority = PersonStatus.JUNIOR_STUDENT.getPriority();
        }
    }

}

