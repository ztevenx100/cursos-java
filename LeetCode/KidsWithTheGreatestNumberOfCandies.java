import java.util.ArrayList;
import java.util.List;

/*
 * 1431. Kids With the Greatest Number of Candies
 * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 * Return the merged string.
 * 
 * - Complejidad:
 *     - Tiempo: O(n),
*/
class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> solution(int[] candies, int extraCandies) {
        List<Boolean> validateExtraCadies = new ArrayList<>();
         int maxCandies = 0;

        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        for (int candy : candies) {
            validateExtraCadies.add(candy + extraCandies >= maxCandies);
        }

        return validateExtraCadies;
    }
}