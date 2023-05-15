package kr.ac.sahmyook.han;
import java.util.Random;

public class Monster {
    private static final String[] MONSTER_NAMES = {"고블린", "트롤", "좀비", "해골"};
    private static final int MIN_HP = 50;
    private static final int MAX_HP = 150;

    private static Monster instance;
    private String name;
    private int maxHP;
    private int currentHP;

    private Monster() {
        generateMonster();
    }

    public static Monster getInstance() {
        if (instance == null) {
            instance = new Monster();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void receiveDamage(int damage) {
        currentHP -= damage;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    private void generateMonster() {
        Random random = new Random();
        int index = random.nextInt(MONSTER_NAMES.length);
        name = MONSTER_NAMES[index];
        maxHP = random.nextInt(MAX_HP - MIN_HP + 1) + MIN_HP;
        currentHP = maxHP;
    }
}

