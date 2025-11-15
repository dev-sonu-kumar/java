/*
 * PROBLEM STATEMENT:
 * HackerLand Enterprise is adopting a new viral advertising strategy. When they launch a new product, they advertise it to exactly 5 people on social media.
 * On the first day, half of those 5 people (i.e., floor(5/2) = 2) like the advertisement and each shares it with 3 of their friends.
 * At the beginning of the second day, floor(5/2) × 3 = 2 × 3 = 6 people receive the advertisement.
 * Each day, floor(recipients/2) of the recipients like the advertisement and will share it with 3 friends on the following day.
 * 
 * Assuming nobody receives the advertisement twice, determine how many people have liked the ad by the end of a given day, beginning with day 1.
 * 
 * Example:
 * Input: n = 3
 * Output: 9
 * Explanation: Day 1: 5 receive, 2 like. Day 2: 6 receive, 3 like. Day 3: 9 receive, 4 like. Total likes = 2+3+4 = 9.
 * 
 * Constraints: 1 ≤ n ≤ 50
 */

public class _90_ViralAdvertising {
    public static int viralAdvertising(int n) {
        int shared = 5;
        int totalLikes = 0;
        
        for (int day = 1; day <= n; day++) {
            int liked = shared / 2;
            totalLikes += liked;
            shared = liked * 3;
        }
        
        return totalLikes;
    }
    
    public static void main(String[] args) {
        System.out.println("Total likes after 3 days: " + viralAdvertising(3));
        System.out.println("Total likes after 5 days: " + viralAdvertising(5));
    }
}