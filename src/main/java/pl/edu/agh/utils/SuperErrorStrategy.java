package pl.edu.agh.utils;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.util.ArrayList;
import java.util.List;

public class SuperErrorStrategy extends DefaultErrorStrategy {

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e){
        TokenStream tokens = recognizer.getInputStream();
        Token prevToken = tokens.get(e.getOffendingToken().getTokenIndex() - 1);

        String msg = "mismatched input " + this.getTokenErrorDisplay(prevToken) + " expecting " + e.getExpectedTokens().toString(recognizer.getVocabulary());
        recognizer.notifyErrorListeners(prevToken, msg, e);
    }

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {

        TokenStream tokens = recognizer.getInputStream();
        Token prevToken = tokens != null ? tokens.get(e.getOffendingToken().getTokenIndex() - 1) : null;
        //System.out.println(recognizer.getExpectedTokens().toString(recognizer.getVocabulary()));
        String input;
        if (tokens != null) {
            if (e.getStartToken().getType() == -1) {
                input = "<EOF>";
            } else {
                input = tokens.getText(e.getStartToken(), e.getOffendingToken());
            }
        } else {
            input = "<unknown input>";
        }

        String msg = "no viable alternative at input " + this.escapeWSAndQuote(input);
        recognizer.notifyErrorListeners(prevToken, msg, e);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            TokenStream input = recognizer.getInputStream();
            Token previousToken = input.get(t.getTokenIndex() - 1);
            String tokenName = this.getTokenErrorDisplay(t);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "extraneous input " + tokenName + " expecting " + expecting.toString(recognizer.getVocabulary());
            recognizer.notifyErrorListeners(previousToken, msg, (RecognitionException)null);
        }
    }

    @Override
    protected void reportMissingToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            TokenStream input = recognizer.getInputStream();
            Token previousToken = input.get(t.getTokenIndex() - 1);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "missing " + expecting.toString(recognizer.getVocabulary()) + " at " + this.getTokenErrorDisplay(t);
            recognizer.notifyErrorListeners(previousToken, msg, (RecognitionException)null);
        }
    }

    private ArrayList<String> vocabularyStrings(Vocabulary vocabulary) {
        ArrayList<String> vocabularyStrings = new ArrayList<>();
        for (int i = 0; i < vocabulary.getMaxTokenType(); i++){
            vocabularyStrings.add(vocabulary.getSymbolicName(i));
        }
        return vocabularyStrings;
    }

}
