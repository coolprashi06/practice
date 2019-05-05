import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subsequence {

    public static void main(String args[]){
        System.out.println(buildSubsequences("abc"));
    }

    public static List<String> buildSubsequences(String s){
        HashSet<String> sequences = new HashSet<>();

        int length = s.length();

        if(!s.matches("^[a-z]{2,15}+$")){
            throw new IllegalArgumentException("invalid string");
        }

        for(int i = 0; i< length; i++){
            for(int j = length; j> i ; j--){
                String combination = s.substring(i ,j);
                if(!sequences.contains(combination)){
                    sequences.add(combination);
                }

                for(int k = 1; k < combination.length() - 1; k++){
                    StringBuilder builder = new StringBuilder(combination);
                    builder.deleteCharAt(k);

                    if(!sequences.contains(builder.toString())){

                        sequences.add(builder.toString());
                    }
                }
            }
        }
        ArrayList<String> combinations = new ArrayList<>();
        for(String combination : sequences){
            combinations.add(combination);
        }
        return combinations;
    }
}
