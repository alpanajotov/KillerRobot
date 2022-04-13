import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int OBJECT_WALL   = 1;
        final int OBJECT_CHAIR  = 2;
        final int NO_OBJECT     = 3;


        while (true) {
            System.out.println("Какво има на пътя ми?");
            System.out.println("1. Стена");
            System.out.println("2. Стол");
            System.out.println("3. Чисто е");

            int objectId = scanner.nextInt();
            boolean isWallDetected = objectId == OBJECT_WALL;
            boolean isChairDetected = objectId == OBJECT_CHAIR;
            boolean isClear = objectId == NO_OBJECT;

            if (isWallDetected) {
                System.out.println("Go Sideway");
            }
            if (isChairDetected) {
                System.out.println("Jump");
            }
            if (isClear) {
                System.out.println("Go Forward");
            }


        }
    }
}
