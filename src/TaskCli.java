import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskCli {
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
        System.out.println("#mark tasks as it will be make it with 'todo <task-number>'");
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

        this.createdAt = LocalDateTime.now();
        System.out.println("the task has been created at " + this.createdAt.minusNanos(this.createdAt.getNano()));
    };

    void markTask(Scanner userCommand){
        if (userCommand.findInLine("mark-in-progress") != null) {
            this.status = Status.IN_PROGRESS;
        }else if (userCommand.findInLine("mark-done") != null) {
            this.status = Status.DONE;
        } else if (userCommand.findInLine("todo") != null) {
            this.status = Status.TODO;
        }
        System.out.println("their status is "+ this.status.name());
    }

    void commandType(Scanner userCommand){
        tasksCommands();
        switch (userCommand.next()){
            case ("add"):
                addNewTask(userCommand);
            default:
                markTask(userCommand);
        }
    }

}

enum Status {
    TODO, IN_PROGRESS, DONE
}
