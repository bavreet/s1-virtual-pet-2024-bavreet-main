import javax.swing.JLayeredPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class VirtualPet2 {
    // Pet face
    VirtualPetFace face; 
    // Pet stats
    int hunger = 0;   // How hungry the pet is
    int Health = 100;
    int AttackDammage = 50;
    int HealthPots = 2;
    int HealthPotsHealFor = 25;
    int HPDropChance = 50;  // Perent chance of health potion drop
    
    // Enemy stats
    String[] enemies =              {"Skeleton", "Zombie", "Warrior", "Assassin"};
    int[] maxEnemyHealth =          {60, 120, 100, 100};
    int[] maxEnemyAttackDammage =   {40, 30, 60, 75};

    int enemyType;

    boolean running = true;
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    int enemyHealth = rand.nextInt(maxEnemyHealth[enemyType]);
    String enemy = enemies[rand.nextInt(enemies.length)];
    int round;

    // Constructor
    public VirtualPet2() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Welcome to the Dungeon!");
        waitAMoment(0.8f);
    }

    // First encounter with an enemy
    public void Start() {
        face.setImage("Skeleton");
        ResetEnemy();


        while (Health > 0) {
            Encounter();
        }

        JOptionPane.showMessageDialog(face,"You died :(");
        System.exit(0);
    }

    void ResetEnemy() {
        if (round < 4)
        enemyType = rand.nextInt(4);
        else {
            if (rand.nextInt(0, 3) == 1)  enemyType = rand.nextInt(0, 2);
            else enemyType = rand.nextInt(2, 4);
        }
        enemyHealth = rand.nextInt(maxEnemyHealth[enemyType] - 10, maxEnemyHealth[enemyType]);
        enemy = enemies[enemyType];
        // face.setImage(enemy);
    }

    void Encounter() {
        
        face.setMessage("Your opponent is " + enemy + "!" +
                        "\nYour HP: " + Health + 
                        "\n" + enemy + "'s HP: " + enemyHealth + "\n");
        waitAMoment(0.8f);

        Object[] options = {"Attack", "Heal", "Run"};

        int n = -1;
        while (n < 0) {
            n = JOptionPane.showOptionDialog(face, "What will you do?", "Action", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        }
        

        if (n == 0) {
            int damageDealt = rand.nextInt(AttackDammage);
            
            face.setMessage("You did " + damageDealt + " damage to the " + enemy);
            enemyHealth -= damageDealt;
            waitAMoment(1);

            if (enemyHealth <= 0) {
                JOptionPane.showMessageDialog(face,"You defeated the " + enemy + "! \n \n      Your health increased by 20");
                    round++;
                    ResetEnemy();
                    Health += 20;
                    Health = Math.min(Health, 120);
                    return;
            }

            int damageTaken = rand.nextInt(maxEnemyAttackDammage[enemyType]);

            face.setMessage("You recieved " + damageTaken + " damage from " + enemy);
            Health -= damageTaken;
            waitAMoment(1);
        } 
        else if (n == 1) {
            int heal = rand.nextInt(20, 40);
            Health += heal;
            Health = Math.min(Health, 120);

            face.setMessage("You healed " + heal + " health");
            waitAMoment(1);

            int damageTaken = rand.nextInt(maxEnemyAttackDammage[enemyType]);

            face.setMessage("You recieved " + damageTaken + " damage from " + enemy);
            Health -= damageTaken;
            waitAMoment(1);
        } 
        else if (n == 2) {
            if (rand.nextInt(10) <= 4) {
                JOptionPane.showMessageDialog(face,"You escaped the " + enemy + " and were able to rest! \n \n      Your health increased by 20");
                ResetEnemy();
                Health += 20;
                Health = Math.min(Health, 120);
                return;
            }
            else {
                face.setMessage("You failed to escape");
                waitAMoment(1);

                int damageTaken = rand.nextInt(maxEnemyAttackDammage[enemyType]);

                face.setMessage("You recieved " + damageTaken + " damage from " + enemy);
                Health -= damageTaken;
                waitAMoment(1);
            }
        } 
        
    }

    // Feed the pet
    public void feed() {
        if (hunger > 10) {
            hunger -= 10;
        } else {
            hunger = 0;
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
    }

    // Exercise the pet
    public void exercise() {
        hunger += 3;
        face.setMessage("1, 2, 3, jump. Whew.");
        face.setImage("tired");
    }
// double truth = 0.0;
    // Make the pet sleep
    public void sleep() {
        hunger += 1;
        face.setImage("asleep");
    }

    // Pause the game for a moment
    public void waitAMoment(float seconds) {
        try {
            Thread.sleep((int)(seconds * 1000));  // Convert to milliseconds
        } catch (Exception e) {
            // Handle exception
        }
    }
}