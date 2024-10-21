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

    final static int p = 2147483647;
    final static int radix = 256;
    static long power;
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
//        power = (long) Math.pow(radix, length-1);
        for(int i = 0; i < length-1; i++){
            power = (power * radix) % p;
        }
        int place = index(sequence, check);
        int count = 0;
        while(place >= 0){
            check += STR;
            count++;
            sequence = sequence.substring(place);
            place = index(sequence,check);
        }
        return count;
    }

    public static int index(String sequence, String STR){
        long x = hash(STR);
        String z = sequence.substring(0, length);
        long y = hash(z);
        for(int i = 0; i < sequence.length()-length; i++){
            String c = sequence.substring(i,length+i);
            if(x == y){
                return i;
            }
            y = shiftHash(y, sequence.charAt(i), sequence.charAt(i+length));
        }
        return -1;
    }

    //Make Initial Hash for first set letters
   public static long hash(String s){
        long hash = 0;
        for(int i = 0; i < s.length(); i++){
            hash = (radix * hash + s.charAt(i)) % p;
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


