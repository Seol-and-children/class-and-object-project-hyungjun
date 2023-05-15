package kr.ac.sahmyook.han;

import java.util.Random;

public class Adventurer {
        private String name;
        private int distance;
        private int monsterCount;
        private boolean inBattle;
        private int attackCount;

        public Adventurer(String name) {
                this.name = name;
                this.distance = 0;
                this.monsterCount = 0;
                this.inBattle = false;
                this.attackCount = 0;
        }

        public void moveForward() {
                if (!inBattle) {
                        distance++;
                        System.out.println(name + "은(는) 앞으로 한 칸 나아갔습니다.");

                        if (distance >= 10) {
                                endAdventure();
                        } else {
                                Random random = new Random();
                                int battleChance = random.nextInt(100) + 1;

                                if (battleChance <= 30) {
                                        inBattle = true;
                                        System.out.println("전투가 시작되었습니다!");
                                        generateMonster();
                                }
                        }
                } else {
                        System.out.println("전투 중에는 앞으로 나아갈 수 없습니다.");
                }
        }

        public void attackMonster() {
                if (inBattle) {
                        if (attackCount < 5) {
                                Random random = new Random();
                                int damage = random.nextInt(76);
                                Monster monster = Monster.getInstance();

                                monster.receiveDamage(damage);

                                if (monster.getCurrentHP() <= 0) {
                                        System.out.println("몬스터를 처치하였습니다!");
                                        monsterCount++;
                                        inBattle = false;
                                } else {
                                        System.out.println("몬스터에게 " + damage + "만큼의 데미지를 주었습니다.");
                                        attackCount++;
                                }
                        } else {
                                System.out.println("몬스터를 공격할 수 있는 횟수를 모두 사용하였습니다.");
                                endAdventure();
                        }
                } else {
                        System.out.println("전투 중이 아닙니다.");
                }
        }

        public void runAway() {
                if (inBattle) {
                        Random random = new Random();
                        int escapeChance = random.nextInt(100) + 1;

                        if (escapeChance <= 50) {
                                distance++;
                                inBattle = false;
                                System.out.println(name + "은(는) 전투에서 도망쳤습니다. 앞으로 한 칸 나아갑니다.");
                        } else {
                                System.out.println(name + "은(는) 도망에 실패하였습니다. 전투에 머물러 있습니다.");
                        }
                } else {
                        System.out.println("전투 중이 아닙니다.");
                }
        }

        public void endAdventure() {
                System.out.println("모험이 종료되었습니다.");
                System.out.println("처치한 몬스터 수: " + monsterCount);

                if (distance >= 10) {
                        System.out.println("축하합니다! 모험에 성공하였습니다!");
                } else {
                        System.out.println("아쉽게도 모험에 실패하였습니다.");
                }
        }

        private void generateMonster() {
                Monster monster = Monster.getInstance();
                System.out.println("몬스터가 나타났습니다!");
                System.out.println("몬스터 정보 - HP: " + monster.getMaxHP() + ", 종류: " + monster.getName());
        }
}
