import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskCli newTask = new TaskCli();
        Scanner userInput = new Scanner(System.in);
        newTask.commandType(userInput);
    }
}