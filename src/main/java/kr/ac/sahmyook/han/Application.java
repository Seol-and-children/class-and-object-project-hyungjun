package kr.ac.sahmyook.han;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Adventurer adventurer = null;
        boolean adventureStarted = false;

        while (true) {
            displayMenu();

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (!adventureStarted) {
                        System.out.print("모험가의 이름을 입력하세요: ");
                        String name = sc.nextLine();
                        adventurer = new Adventurer(name);
                        adventureStarted = true;
                        System.out.println("모험이 시작되었습니다!");
                    } else {
                        System.out.println("이미 모험이 진행 중입니다.");
                    }
                    break;
                case 2:
                    if (adventureStarted) {
                        adventurer.moveForward();
                    } else {
                        System.out.println("모험이 시작되지 않았습니다. 먼저 모험을 시작하세요.");
                    }
                    break;
                case 3:
                    if (adventureStarted) {
                        adventurer.attackMonster();
                    } else {
                        System.out.println("모험이 시작되지 않았습니다. 먼저 모험을 시작하세요.");
                    }
                    break;
                case 4:
                    if (adventureStarted) {
                        adventurer.runAway();
                    } else {
                        System.out.println("모험이 시작되지 않았습니다. 먼저 모험을 시작하세요.");
                    }
                    break;
                case 5:
                    if (adventureStarted) {
                        adventurer.endAdventure();
                        adventureStarted = false;
                    } else {
                        System.out.println("모험이 시작되지 않았습니다. 먼저 모험을 시작하세요.");
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n[모험가 메뉴]");
        System.out.println("1. 모험 시작하기");
        System.out.println("2. 앞으로 나아가기");
        System.out.println("3. 몬스터 공격하기");
        System.out.println("4. 도망가기");
        System.out.println("5. 모험 끝내기");
        System.out.println("6. 프로그램 종료");
        System.out.print("메뉴 번호를 선택하세요: ");
    }
}