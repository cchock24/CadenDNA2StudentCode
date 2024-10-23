/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Caden Chock
 *
 */

public class DNA {

    //p = mod
    //radix = radix
    //power = radix place of the first char in string
    //length = length of STR
    final static long p = 999999000001L;
    final static int radix = 256;
    static long power = 1;
    static int length;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
       return method(sequence, STR);
    }

    public static int method(String sequence, String STR){
        String check = STR;
        length = STR.length();
        power = 1;
        int start = 0;
        for(int i = 0; i < length-1; i++){
            power = (power * radix) % p;
        }
        int place = index(sequence, check, start);
        int count = 0;
        while(place >= 0){
            check += STR;
            length += STR.length();
            power = 1;
            for(int i = 0; i < length-1; i++){
                power = (power * radix) % p;
            }
            count++;
            start = place;
            place = index(sequence,check, start);
        }
        return count;
    }
    //Basically IndexOf but better
    public static int index(String sequence, String STR, int start){
        long x = hash(STR, 0, length);
        long y = hash(sequence, start, start+length);
        for(int i = 0; i < sequence.length()-length-start; i++){
            if(x == y){
                return start+i;
            }
            y = shiftHash(y, sequence.charAt(i+start), sequence.charAt(i+length+start));
        }
        return -1;
    }

    //Make Initial Hash for first set letters
   public static long hash(String sequence, int start, int end){
        long hash = 0;
        for(int i = 0; i < (end - start); i++){
            hash = (radix * hash + sequence.charAt(i+start)) % p;
        }
        return hash;
   }

    //Shift Hash one over
   public static long shiftHash(long hash, char old, char n){
       hash = ((hash + p) - ((old * power) % p))%p;
       hash = (hash * radix + n) % p;
        return hash;
   }
}


