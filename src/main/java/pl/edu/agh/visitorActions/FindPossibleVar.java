package pl.edu.agh.visitorActions;

import pl.edu.agh.Melody;
import pl.edu.agh.utils.LevenshteinDamerau;
import pl.edu.agh.utils.Scope;

import java.util.HashSet;
import java.util.Set;

public class FindPossibleVar {



    public static String returnProposal(String varName, HashSet<String> possibleVars) {
        return LevenshteinDamerau.proposeWord(varName, possibleVars, 1);
    }

    public static void copyForProposal(Set<String> memKeys, HashSet<String>  possibleVars){
        possibleVars.addAll(memKeys);
    }



}
