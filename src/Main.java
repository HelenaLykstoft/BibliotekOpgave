import Niveau2_logik.TerminalInput;
import Niveau3_persistens.Facade;

public class Main {
    private static LanguageController languageController;
    private static Facade facade = new Facade();
    private static String bullet = "\u2022";
    public static void main(String[] args) {


        LanguageMenu("");
        languageController.allMenus();

        }

    public static void LanguageMenu(String ErrorMessage) {

        int input;
        System.out.println(ErrorMessage);
        String s = "\nAnnouncement - Welcome to the Public Library" +
                "\nPlease choose a language! // Veuillez choisir une langue! // Kōwhirihia he reo! " +
                "\n" + bullet + " 1 = English // Anglais // Engelsk" +
                "\n" + bullet + " 2 = French // Francais // Fransk" +
                "\n" + bullet + " 3 = Danish // Danoise // Dansk\n";

            input = TerminalInput.getInt(s);
            switch (input) {
                case 1 -> languageController = new EnglishMenu();
                case 2 -> languageController = new FrenchMenu();
                case 3 -> languageController = new DanishMenu();
                default -> LanguageMenu("\n Error -- Please choose from the options available.");
            }

         }
    }

