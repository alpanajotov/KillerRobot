import java.util.Random;
import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static Random randomGenerator = new Random();
    public static boolean isRunning = true;
    public static int availableHitCount = 4;

    public static void processMove() {
        final int OBJECT_WALL   = 1;
        final int OBJECT_CHAIR  = 2;
        final int NO_OBJECT     = 3;
        final int PROCESS_EXIT = 4;
        boolean isRunning = true;


        while (isRunning) {
            System.out.println("Какво има на пътя ми?");
            System.out.println("1. Стена");
            System.out.println("2. Стол");
            System.out.println("3. Чисто е");
            System.out.println("4. Изход oт процедурата");

            int objectId = scanner.nextInt();
            boolean isWallDetected = objectId == OBJECT_WALL;
            boolean isChairDetected = objectId == OBJECT_CHAIR;
            boolean isClear = objectId == NO_OBJECT;

            switch (objectId) {
                case OBJECT_WALL -> System.out.println("Go Sideway");
                case OBJECT_CHAIR -> System.out.println("Jump");
                case NO_OBJECT -> System.out.println("Go Forward");
                case PROCESS_EXIT -> isRunning = false;
                default -> System.out.println("*** Repeat ***");
            }
        }
        System.out.println("Робота спря да се движи");
    }

    public static boolean isTargetLocked() {
        // Засичане
        int randomNumber = randomGenerator.nextInt(5000);
        return randomNumber % 2 == 0;
    }
    public static boolean isBatteryCharged() {
        // Провекра на батерията
        return availableHitCount != 0;
    }
    public static boolean isHitSafe() {
        //Проверка за безопасност на батерията
        int targetChanceId =  randomGenerator.nextInt(10) + 1;
        return targetChanceId != 5;
    }
    public static boolean isBatteryEmpty() {
        return !isBatteryCharged();
    }
    public static boolean isHitProcessable() {
        boolean isTargetLocked = isTargetLocked();
        boolean isBatteryCharged = isBatteryCharged();
        boolean isHitSave = isHitSafe();

        return isBatteryCharged && isTargetLocked && isHitSave;

    }

    public static void processFight() {
        
        if (isBatteryEmpty()) {
            processCharge();
        }
        if (isHitProcessable()) {
            System.out.println("Ударът е нанесен успешно");
            availableHitCount--;
        }
    }

    private static void processCharge() {
        availableHitCount = 4;
    }

    public static void processExit() {
        isRunning = false;
    }
    public static void main(String[] args) {

        final int PROCESS_MOVE = 1;
        final int PROCESS_FIGHT = 2;
        final int PROCESS_EXIT = 3;

        while (isRunning) {
            System.out.println("1. Движение");
            System.out.println("2. Бой");
            System.out.println("3. Изключване на робота");

            int processCode = scanner.nextInt();

            switch (processCode) {
                case PROCESS_MOVE -> processMove();
                case PROCESS_FIGHT -> processFight();
                case PROCESS_EXIT -> processExit();
            }
        }
        System.out.println("Робота е изключен");
    }
}
