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

    static void addNewTask(Scanner description){
        TaskCli newTask = new TaskCli();
        newTask.description =  description.useDelimiter("\\s*add\\s*").nextLine();
        System.out.println("the task " + newTask.description + " has been successfully added");
        TaskCli.mayorId++;
        newTask.id = TaskCli.mayorId;
        TaskCli.idCollection.put(newTask.id, newTask);
        System.out.println("The ids collection are " + TaskCli.idCollection.keySet());
        newTask.createdAt = LocalDateTime.now();
        System.out.println("the task has been created at " + newTask.createdAt.minusNanos(newTask.createdAt.getNano()));
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

//    void modifyTask(Scanner userCommand){
//
//    }

    static void commandType(Scanner userPrompt){
        String theCommand = userPrompt.next();
        
        if (Pattern.matches("add", theCommand)) {
            TaskCli.addNewTask(userPrompt);
        } else if (Pattern.matches("^mark-\\w+-*\\w+", theCommand)) {
            TaskCli.markTask(theCommand, userPrompt);
        }

    }

}

enum Status {
    TODO, IN_PROGRESS, DONE
}
