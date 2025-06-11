package pl.edu.agh.utils;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.Transition;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.util.ArrayList;
import java.util.List;

public class SuperErrorStrategy extends DefaultErrorStrategy {

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e){
        TokenStream tokens = recognizer.getInputStream();
        Token prevToken = tokens.get(e.getOffendingToken().getTokenIndex() - 1);

        IntervalSet expecting = this.getExpectedTokens(recognizer);
        //System.out.println(expecting.toString(recognizer.getVocabulary()));

        //System.out.println(e.getOffendingToken().getType());

        String msg = "mismatched input " + this.getTokenErrorDisplay(e.getOffendingToken()) + " expecting " + e.getExpectedTokens().toString(recognizer.getVocabulary());
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {

        TokenStream tokens = recognizer.getInputStream();
        Token prevToken = tokens != null ? tokens.get(e.getOffendingToken().getTokenIndex()) : null;
        //System.out.println(recognizer.getExpectedTokens().toString(recognizer.getVocabulary()));
        String input;
        //System.out.println(e.getOffendingToken().getType());
        //System.out.println(prevToken.getType());

        if (tokens != null) {
            if (e.getStartToken().getType() == -1) {
                input = "<EOF>";
            } else {
                input = tokens.getText(e.getStartToken(), e.getOffendingToken());
            }
        } else {
            input = "<unknown input>";
        }

        String msg = "no viable alternative at input " + this.escapeWSAndQuote(input) + e.getOffendingToken().getText();
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            String msg;

            //System.out.println("Unwanted Token");
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            TokenStream input = recognizer.getInputStream();
            Token previousToken = input.get(t.getTokenIndex() - 1);
            String tokenName = this.getTokenErrorDisplay(t);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            //System.out.println(expecting.toString(recognizer.getVocabulary()));
            if(tokenName.equals("'<EOF>'")){
                msg = "Missing '}'";
            }else{
                msg = " Unnecessary character/word: " + tokenName + " remove it";
            }
            recognizer.notifyErrorListeners(previousToken, msg, (RecognitionException)null);
        }
    }

    @Override
    protected void reportMissingToken(Parser recognizer) {
        if (!this.inErrorRecoveryMode(recognizer)) {
            //System.out.println("Missing token");
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            TokenStream input = recognizer.getInputStream();
            Token previousToken = input.get(t.getTokenIndex() - 1);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "missing " + expecting.toString(recognizer.getVocabulary());
            recognizer.notifyErrorListeners(previousToken, msg, (RecognitionException)null);

        }
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        Token matchedSymbol = this.singleTokenDeletion(recognizer);
        if (matchedSymbol != null) {
            recognizer.consume();
            return matchedSymbol;
        } else if (this.singleTokenInsertion(recognizer)) {
            return this.getMissingSymbol(recognizer);
        } else {
            InputMismatchException e;
            if (this.nextTokensContext == null) {
                e = new InputMismatchException(recognizer);
            } else {
                e = new InputMismatchException(recognizer, this.nextTokensState, this.nextTokensContext);
            }

            throw e;
        }
    }

    @Override
    protected boolean singleTokenInsertion(Parser recognizer) {
        int currentSymbolType = recognizer.getInputStream().LA(1);
        ATNState currentState = (ATNState)((ParserATNSimulator)recognizer.getInterpreter()).atn.states.get(recognizer.getState());
        ATNState next = currentState.transition(0).target;
        ATN atn = ((ParserATNSimulator)recognizer.getInterpreter()).atn;

        IntervalSet expectingAtLL2 = atn.nextTokens(next, recognizer.getRuleContext());
        if (expectingAtLL2.contains(currentSymbolType)) {
            this.reportMissingToken(recognizer);
            return true;
        } else {
            return false;
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
