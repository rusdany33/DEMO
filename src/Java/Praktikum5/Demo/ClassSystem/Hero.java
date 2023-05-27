package Java.Praktikum5.Demo.ClassSystem;

public abstract class Hero {
    protected int healthPoint;
    protected int attackDamage;
    protected int defense;
    protected int level;
    protected boolean isDefeated;

    protected int receivedDamage;

    public Hero(int level) {
        this.level = level;
        this.isDefeated = false;
    }

    public abstract void spawnIntro();

    public abstract void attackIntro();

    public abstract void attackNotification(String player);

    public abstract void damagedNotification(String player);

    public void attack(Hero target) {
        target.reviewDamage(calculateRealDamage());
    }

    public void reviewDamage(int damage) {
        int realDamage = damage - defense;
        this.receivedDamage = realDamage;
        if (realDamage > 0) {
            healthPoint -= realDamage;
        }
        if (healthPoint <= 0) {
            healthPoint = 0;
            isDefeated = true;
        }
    }

    public void checkStatus() {
        System.out.println("Health Point: " + healthPoint);
        System.out.println("Attack Damage: " + attackDamage);
        System.out.println("Defense: " + defense);
        System.out.println("Level: " + level);
        System.out.println("Life Status: " + (isDefeated ? "Defeated" : "Alive"));
    }

    public boolean lifeStatus() {
        if (this.isDefeated == true) {
            return false;
        } else {
            return true;
        }
    }

    public void checkBattleStat(String player) {
        System.out.println(player + " HP : " + getHealthPoint());
    }

    protected abstract int calculateRealDamage();

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getReceivedDamage() {
        return receivedDamage;
    }
}
