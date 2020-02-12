public class Main {
        public static void main(String[] args) {
            Files.readFile();
            boolean bool = true;

            while(bool) {

                Dates.checkDateToday();

                switch (outputMenu()) {
                    case 1 :
                        System.out.println("Add task: ");
                        new Task().newTask();
                        break;
                    case 2 :
                        System.out.println("View Tasks: ");
                        new Task().checkTask();
                        break;
                    case 3 :
                        System.out.println("Delete task: ");
                        new Task().deleteTask();
                        break;
                    case 4 :
                        System.out.println("Edit task: ");
                        new Task().editTask();
                        break;
                }
                bool = checkContinue();
            }
        }

        public static int outputMenu() {

            System.out.println("=====----=====\n" +
                               "-----menu-----\n" +
                               "=====----===== \n1. Add task \n2. View Tasks \n3. Delete task \n4. Edit task \n");

            String num = InputText.inputString();

            if ( num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4")) return Integer.parseInt(num);
            else
                return outputMenu();
        }

        public static boolean checkContinue() {

            System.out.println("Continue work? y/n");

            String check = InputText.inputString();

            if (check.equals("n")) {
                Files.writeFile(Files.getMap());
                return false;
            } else if (check.equals("y")) {
                return true;
            } else
                return checkContinue();
        }

}
