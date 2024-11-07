import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskCli {
    static private Map<Integer, TaskCli> idCollection = new HashMap<>();
    int id;
    static int mayorId = 0;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Status status;

    static void tasksCommands() {
        System.out.println("#create a new task with 'add <task>'");
        System.out.println("#delete tasks with 'delete <task-number>'");
        System.out.println("#update a task with 'update <task-number> <update-task>'");
        System.out.println("#mark tasks as it will be make it with 'mark-todo <task-number>'");
        System.out.println("#mark tasks with 'mark-done <task-number>'");
        System.out.println("#mark task as in progress with 'mark-in-progress <task-number>'");
        System.out.println("#Listing all tasks with 'list-all'");
        System.out.println("#Listing tasks by status with 'list <tasks-status>'");
    }

    void addNewTask(Scanner description){
        this.description =  description.useDelimiter("\\s*add\\s*").nextLine();
        System.out.println("the task " + this.description + " has been successfully added");
        TaskCli.mayorId++;
        this.id = TaskCli.mayorId;
        TaskCli.idCollection.put(this.id, this);
        System.out.println("The ids collection are " + TaskCli.idCollection.keySet());
        this.createdAt = LocalDateTime.now();
        System.out.println("the task has been created at " + this.createdAt.minusNanos(this.createdAt.getNano()));
        description.close();
    };

    static void markTask(String theCommand , Scanner userCommand){

        Integer id =  userCommand.nextInt();
        switch (theCommand) {
            case "mark-in-progress" -> TaskCli.idCollection.get(id).status = Status.IN_PROGRESS;
            case "mark-done" -> TaskCli.idCollection.get(id).status = Status.DONE;
            case "mark-as-todo" -> TaskCli.idCollection.get(id).status = Status.TODO;
            default -> System.out.println("Command not recognized");
        }

        if (TaskCli.idCollection.get(id).status != null) {
            System.out.println("their status of the Task: " + id + " is " + TaskCli.idCollection.get(id).status.name());
        }
    }

    void modifyTask(Scanner userCommand){

    }

    void commandType(Scanner userCommand){
        String theCommand = userCommand.next();
        switch (theCommand){
            case ("add"):
                addNewTask(userCommand);
                break;
            case ("update"):
                modifyTask(userCommand);
                break;
            default:
                TaskCli.markTask(theCommand, userCommand);

        }
    }

}

enum Status {
    TODO, IN_PROGRESS, DONE
}
