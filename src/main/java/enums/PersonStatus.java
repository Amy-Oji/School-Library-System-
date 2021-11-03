package enums;

public enum PersonStatus {
    TEACHER(1),
    SENIOR_STUDENT(2),
    JUNIOR_STUDENT(3);

    private int priority;

    PersonStatus(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}


