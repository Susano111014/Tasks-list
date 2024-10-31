import java.util.Date;

public class TaskCli {
    int id;
    String description;
    Date createdAt;
    Date updatedAt;
    Status status;
}

enum Status {
    TODO, IN_PROGRESS, DONE
}
