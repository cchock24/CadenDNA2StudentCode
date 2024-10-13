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

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
       return method(sequence, STR);
    }

    public static int method(String sequence, String STR){
        String check = STR;
        int place = index(sequence,STR);
        //int place = sequence.indexOf(check);
        int count = 0;
        while(place >= 0){
            check += STR;
            count++;
            sequence = sequence.substring(place);
            place = index(sequence, check);
            //place = sequence.indexOf(check);
        }
        return count;
    }

    public static int index(String sequence, String STR){
        int x = STR.hashCode();
        for(int i = 0; i < sequence.length()-STR.length(); i++){
            String z = sequence.substring(i,(i+STR.length()));
            int y = z.hashCode();
            if(x == y){
                return i;
            }
        }
        return -1;
    }

//    public static int hash(String s){
//
//    }
}
