/*
 * PROBLEM STATEMENT:
 * Two friends Anna and Brian are having dinner at a restaurant. Anna shared k items from the menu.
 * Brian shared all n items. They decide to split the bill equally, but Anna realizes that she didn't eat item k, so she shouldn't pay for it.
 * 
 * Given the total bill, determine if Brian charged Anna fairly or if he overcharged her.
 * 
 * Example:
 * Input: bill = [3, 10, 2, 9], k = 1, b = 12
 * Output: 5
 * Explanation: Anna should pay (3+2+9)/2 = 7, but she paid 12. Brian should refund 12-7 = 5.
 * 
 * Constraints: 2 ≤ n ≤ 10^5, 0 ≤ k < n, 0 ≤ bill[i] ≤ 10^4, 0 ≤ b ≤ sum(bill)
 */

public class _19_BillDivision {
    public static void bonAppetit(int[] bill, int k, int b) {
        int totalBill = 0;
        
        // Calculate total bill excluding item k
        for (int i = 0; i < bill.length; i++) {
            if (i != k) {
                totalBill += bill[i];
            }
        }
        
        int annaShare = totalBill / 2;
        
        if (b == annaShare) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - annaShare);
        }
    }
    
    public static void main(String[] args) {
        int[] bill = {3, 10, 2, 9};
        int k = 1; // Item Anna didn't eat
        int b = 12; // Amount Anna paid
        bonAppetit(bill, k, b);
    }
}