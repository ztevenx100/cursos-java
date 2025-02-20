/*
 * 605. Can Place Flowers
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * 
 * - Complejidad:
 *     - Tiempo: O(n),
*/
class CanPlaceFlowers {
    public boolean solution(int[] flowerbed, int n) {
        Boolean canBePlanted = true;
        int numberFlowers = n;
        
        for(int i = 0; i < flowerbed.length; i++){
            if ( isPlanted(flowerbed[i]) 
            || ((i-1) >= 0 && isPlanted(flowerbed[i-1]))
            || ((i+1) < flowerbed.length && isPlanted(flowerbed[i+1])) ) continue;

            flowerbed[i] = 1;
            numberFlowers--;
            if (numberFlowers == 0) break;
        }

        if (numberFlowers > 0) return false;

        return canBePlanted;
    }

    public Boolean isPlanted (int plant){
        return (plant == 1);
    }
}