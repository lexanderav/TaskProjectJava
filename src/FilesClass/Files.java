package FilesClass;

import java.io.*;
import TaskClass.Task;
import java.text.ParseException;
import java.util.*;

public class Files {

    private static FileReader fileName;
    private static BufferedReader fileReader;
    private static File file = new File("TaskFile.txt");
    private static Map<String, String> map = new HashMap<String, String>();

    public static void readFile() {

        try {

            if (file.exists()) file.createNewFile();

            fileName = new FileReader(file);
            fileReader = new BufferedReader(fileName);

            while (fileReader.ready()) {
                String key = "";
                if (!(key = fileReader.readLine()).equals("===========")) {
                    map.put(key,fileReader.readLine());
                }
            }
            fileName.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("A new file will be created.Enter a task.");
            new Task().newTask();
        }
    }

    public static void writeFile(Map<String, String> map) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            //Map<String, String> sortHashMap = sortMap();

            if (map != null){
                for (HashMap.Entry<String, String> pair : map.entrySet()){
                    writer.write(pair.getKey());
                    writer.newLine();
                    writer.write(pair.getValue());
                    writer.newLine();
                    writer.write("===========");
                    writer.newLine();
                }
                writer.close();
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }



    public static void setMap(String key, String value) {
        map.put(key,value);
    }
    public static Map<String, String> getMap() {
        return map;
    }

    /*private static Map<String, String> sortMap() {//сучара не работает

        Map<String, String> newMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>(map.keySet());
        List<String> newList = new ArrayList<String>();
        boolean isSorted = false;

        while (!isSorted){

            isSorted = true;

            for (int k = 0; k < list.size()-1; k++) {
                try {

                    Date date1 = Dates.getDateFormat().parse(list.get(k));
                    Date date2 = Dates.getDateFormat().parse(list.get(k+1));

                    if (date1.before(date2)) {
                        String buff = list.get(k);
                        String buff2 = list.get(k+1);
                        newList.add(buff);
                        newList.add(buff2);
                        System.out.println(" Это в if " + list.get(k));
                        isSorted = false;
                    } else if (date1.after(date2)){
                        String buff = list.get(k);
                        newList.add(buff);
                        System.out.println("Этов else " + list.get(k));
                        isSorted = false;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }

        }
        
        for (int i = newList.size()-1; i >= 0; i--) {
            System.out.println("Значение листа = " + newList.get(i) + "\n");
            newMap.put(newList.get(i), map.get(list.get(i)));
        }

        for (Map.Entry<String, String> pair : newMap.entrySet()){
            System.out.println("newMap = " + pair.getKey() + "\n");
        }
        return newMap;
    }*/
}
