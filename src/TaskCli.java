import java.util.Date;
import java.util.Scanner;

public class TaskCli {
    int id;
    private String description;
    Date createdAt;
    Date updatedAt;
    Status status;

    static void tasksCommands() {
        System.out.println("#Yo can create a new task with 'add <task>'");
        System.out.println("#Yo can delete tasks with 'delete <task-number>'");
        System.out.println("#Yo can finishing tasks with 'done <task-number>'");
        System.out.println("#Yo can update a task with 'update <task-number> <update-task>'");
        System.out.println("#Yo can mark task as in progress with 'mark-in-progress <task-number>'");
        System.out.println("You can Listing all tasks with 'list-all'");
        System.out.println("You can Listing tasks by status with 'list <tasks-status>'");
    }

    void addNewTask(Scanner description){
        Scanner newDescription = description.useDelimiter("\\s*add\\s*");
        this.description =  newDescription.nextLine();
        System.out.println("the task " + this.description + " has been successfully added");
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
