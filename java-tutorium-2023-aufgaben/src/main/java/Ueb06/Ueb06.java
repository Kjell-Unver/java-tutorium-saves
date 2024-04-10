package Ueb06;

import java.util.Scanner;

public class Ueb06 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            int maxGasStations = Integer.parseInt(args[0]);

            GasStation[] gasStations = new GasStation[maxGasStations];

            int gasStationCounter = 0;

            boolean terminateInput = false;
            while (gasStationCounter < maxGasStations && !terminateInput) {

                GasStation gasStation = new GasStation();

                String[] inputNames = new String[]{"Marke", "PLZ", "Ort", "Preis"};
                int inputIndex = 0;
                while (inputIndex < inputNames.length && !terminateInput) {
                    String inputName = inputNames[inputIndex];
                    printInputPrompt(inputName);
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("x")) {
                        System.out.println("Die Eingabe wurde abgebrochen!");
                        terminateInput = true;
                    } else {
                        if (isInputValid(input, inputName)) {
                            addInputToGasStation(input, gasStation, inputName);
                            inputIndex++;
                        }
                    }
                }

                if (!terminateInput) {
                    gasStations[gasStationCounter] = gasStation;
                    gasStationCounter++;
                }
            }

            if (gasStationCounter > 0) {
                String minPlzString;
                do {
                    System.out.println("Bitte geben Sie eine untere Grenze fuer die PLZ ein.");
                    minPlzString = scanner.nextLine();
                } while (!isInputValid(minPlzString, "PLZ"));
                int minPlz = Integer.parseInt(minPlzString);

                String maxPlzString;
                do {
                    System.out.println("Bitte geben Sie eine obere Grenze fuer die PLZ ein.");
                    maxPlzString = scanner.nextLine();
                } while (!isInputValid(maxPlzString, "PLZ") || !isValidMaxPlz(minPlzString, maxPlzString));
                int maxPlz = Integer.parseInt(maxPlzString);

                printGasStations(gasStations, gasStationCounter, minPlz, maxPlz);
            }

            scanner.close();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }
    }

    private static void printGasStations(GasStation[] gasStations, int gasStationCounter, int minPlz, int maxPlz) {
        int counter = 0;
        for (int i = 0; i < gasStationCounter; i++) {
            if (gasStations[i].getPlz() >= minPlz && gasStations[i].getPlz() <= maxPlz) {
                System.out.format("%d. eingegebene Adresse:%n%s%n%d %s%n%-4.2f Euro", (i + 1), gasStations[i].getMarke(), gasStations[i].getPlz(), gasStations[i].getOrt(), gasStations[i].getPreis());
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Es gibt keine Tankstelle mit einer PLZ in der definierten Spanne!");
        }
    }

    private static void printInputPrompt(String inputName) {
        switch (inputName) {
            case "Marke":
                System.out.println("Bitte geben Sie eine Marke ein.");
                break;
            case "PLZ":
                System.out.println("Bitte geben Sie eine PLZ ein.");
                break;
            case "Ort":
                System.out.println("Bitte geben Sie einen Ort ein.");
                break;
            case "Preis":
                System.out.println("Bitte geben Sie einen Preis ein.");
                break;
        }
    }

    private static void printInputError(String inputName) {
        switch (inputName) {
            case "Marke":
                System.out.println("Es wurde eine ungueltige Marke eingegeben!");
                break;
            case "PLZ":
                System.out.println("Es wurde eine ungueltige PLZ eingegeben!");
                break;
            case "Ort":
                System.out.println("Es wurde ein ungueltiger Ort eingegeben!");
                break;
            case "Preis":
                System.out.println("Es wurde ein ungueltiger Preis eingegeben!");
                break;
        }
    }

    private static boolean isInputValid(String input, String inputName) {
        boolean validInput = false;
        switch (inputName) {
            case "Marke":
                validInput = input != null && !input.equals("");
                break;
            case "PLZ":
                try {
                    int plz = Integer.parseInt(input);
                    validInput = plz >= 10000 && plz <= 99999;
                } catch (NumberFormatException e) {
                    validInput = false;
                }
                break;
            case "Ort":
                validInput = input != null && input.length() >= 5;
                break;
            case "Preis":
                if (!input.contains(".") || input.substring(input.lastIndexOf(".")).length() <= 3) {
                    try {
                        double preis = Double.parseDouble(input);
                        validInput = preis >= 1 && preis <= 2;
                    } catch (NumberFormatException e) {
                        validInput = false;
                    }
                } else {
                    validInput = false;
                }
                break;
        }
        if (!validInput) {
            printInputError(inputName);
        }
        return validInput;
    }

    private static boolean isValidMaxPlz(String minPlzString, String maxPlzString) {
        boolean validInput;
        try {
            validInput = Integer.parseInt(minPlzString) < Integer.parseInt(maxPlzString);
        } catch (NumberFormatException e) {
            validInput = false;
        }
        if (!validInput) {
            printInputError("PLZ");
        }
        return validInput;
    }

    private static void addInputToGasStation(String input, GasStation gasStation, String inputName) {
        switch (inputName) {
            case "Marke":
                gasStation.setMarke(input);
                break;
            case "PLZ":
                gasStation.setPlz(Integer.parseInt(input));
                break;
            case "Ort":
                gasStation.setOrt(input);
                break;
            case "Preis":
                gasStation.setPreis(Double.parseDouble(input));
                break;
        }
    }
}
