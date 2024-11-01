import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

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
        System.out.println("#mark tasks as it will be do it with 'todo <task-number>'");
        System.out.println("#mark tasks with 'done <task-number>'");
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

    void commandType(Scanner userCommand){
        tasksCommands();
        switch (userCommand.next()){
            case ("add"):
                addNewTask(userCommand);
        }
    }

}

enum Status {
    TODO, IN_PROGRESS, DONE
}
