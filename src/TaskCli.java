import java.util.Date;

public class TaskCli {
    int id;
    String description;
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

    public static void main (String[] input){
        tasksCommands();
    }

}

enum Status {
    TODO, IN_PROGRESS, DONE
}
