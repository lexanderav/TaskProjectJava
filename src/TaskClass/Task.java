package TaskClass;

import java.util.HashMap;
import InputTextClass.InputText;
import FilesClass.Files;
import DatesClass.Dates;

public class Task {

    public void newTask() {

        System.out.print("Enter a new date as dd/MM/yyyy: ");
        String key = Dates.getInputDate();//ввод даты
        System.out.print("Enter a new task: ");
        String value = InputText.inputString();//ввод задачи

        if (!checkKeyMap(key, value)){
            Files.setMap(key,value);
            System.out.println("Task successfully added.");
        } else {
            for (HashMap.Entry<String, String> pair : Files.getMap().entrySet()) {
                if (pair.getKey().equals(key)) {
                    Files.setMap(key, pair.getValue() + " " + value);
                    System.out.println("Task successfully added to existing.");
                }
            }
        }
        Files.writeFile(Files.getMap());//
    }

    public void checkTask() {

        Files.readFile();

        if (Files.getMap() != null) {
            Files.getMap().forEach( (k,v) -> System.out.println(k + " " + v));
        }
        else
            System.out.println("The task list is empty.");
    }

    public void deleteTask() {
        //Files.readFile();
        checkTask();

        System.out.println("Select the task to delete and enter the dd/MM/yyyy");

        String delKey = Dates.getInputDate();

        if (checkKeyMap(delKey, "")) {
            Files.getMap().remove(delKey);
            Files.writeFile(Files.getMap());//
            System.out.println("Task deleted.");
        } else
            System.out.println("Tasks with this key do not exist or the task list is empty.");
    }

    public boolean checkKeyMap(String key, String value) { //проверка на существование введенного ключа

        boolean bool = false;

        if (Files.getMap() != null) {
            for (HashMap.Entry<String, String> pair : Files.getMap().entrySet()) {
                if (pair.getKey().equals(key)) {
                    bool = true;
                }
            }
        }
        return bool;
    }

    public void editTask() {

        checkTask();

        System.out.println("Select a task to edit and enter a dd/MM/yyyy");

        String edT = Dates.getInputDate();

        if (checkKeyMap(edT,"")) {
            System.out.println("Enter a new task!");
            String value = InputText.inputString();
            Files.setMap(edT, value);
            Files.writeFile(Files.getMap());//
        } else
            System.out.println("Tasks with this key do not exist or the task list is empty.");
    }

}
