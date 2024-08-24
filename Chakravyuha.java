public class Chakravyuha {

    public static boolean canAbhimanyuCross(int powerOfAbhimanyu, int[] enemies, int skips, int recharge) {
        int initialPower = powerOfAbhimanyu;

        for (int i = 0; i < enemies.length; i++) {
            int enemyPower = enemies[i];

            // Special handling for enemies at index 2 (k3) and index 6 (k7)
            if (i == 2 || i == 6) {
                // Regenerate enemy power
                int regeneratedPower = enemyPower / 2;
                enemyPower = enemyPower + regeneratedPower; // Total power after regeneration

                // Check if Abhimanyu's power is sufficient after regeneration
                if (powerOfAbhimanyu >= enemyPower) {
                    powerOfAbhimanyu -= enemyPower;
                } else if (recharge > 0) {
                    // Use recharge if available
                    powerOfAbhimanyu = initialPower + powerOfAbhimanyu; // Recharge to initial power
                    if (powerOfAbhimanyu >= enemyPower) {
                        powerOfAbhimanyu -= enemyPower;
                    } 
                    recharge--;
                } else if (skips > 0) {
                    skips--;
                } else {
                    return false;
                }
            } else {
                // Normal handling
                if (powerOfAbhimanyu >= enemyPower) {
                    powerOfAbhimanyu -= enemyPower;
                } else if (recharge > 0) {
                    // Use recharge if available
                    powerOfAbhimanyu = initialPower + powerOfAbhimanyu; // Recharge to initial power
                    if (powerOfAbhimanyu >= enemyPower) {
                        powerOfAbhimanyu -= enemyPower;
                    }
                    recharge--;
                } else if (skips > 0) {
                    skips--;
                } else {
                    return false;
                }
            }
        }
        return true; // Successfully crossed all circles
    }

    public static void main(String[] args) {
        // Test Case 1
        int powerOfAbhimanyu1 = 15;
        int[] enemies1 = {1, 2, 5, 10, 4, 8, 6, 9, 3, 7, 5};
        int skips1 = 1;
        int recharge1 = 2;

        if (canAbhimanyuCross(powerOfAbhimanyu1, enemies1, skips1, recharge1)) {
            System.out.println("Abhimanyu can cross the Chakravyuha in Test Case 1.");
        } else {
            System.out.println("Abhimanyu cannot cross the Chakravyuha in Test Case 1.");
        }

        // New Test Case
        int powerOfAbhimanyu2 = 30;
        int[] enemies2 = {5, 8, 12, 15, 6, 7, 9, 5, 10, 11, 4};
        int skips2 = 2;
        int recharge2 = 2;

        if (canAbhimanyuCross(powerOfAbhimanyu2, enemies2, skips2, recharge2)) {
            System.out.println("Abhimanyu can cross the Chakravyuha in the  Test Case 2.");
        } else {
            System.out.println("Abhimanyu cannot cross the Chakravyuha in the new Test Case 2.");
        }
    }
}
