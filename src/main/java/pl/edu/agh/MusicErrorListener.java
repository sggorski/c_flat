package pl.edu.agh;

import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
import pl.edu.agh.errors.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import pl.edu.agh.utils.LevenshteinDamerau;
import pl.edu.agh.utils.LineOrigin;

import java.util.*;
import java.util.stream.Collectors;

public class MusicErrorListener extends BaseErrorListener {
    private final Map<Integer, LineOrigin> lineMap;

    public MusicErrorListener(Map<Integer, LineOrigin> lineMap) {
        this.lineMap = lineMap;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

        //System.err.println(e.getClass());

        if (recognizer instanceof Parser) {
            CommonToken token = (CommonToken) offendingSymbol;
            MusicParser parser = (MusicParser) recognizer;
            ParserRuleContext ctx = parser.getRuleContext();
            String rulename = parser.getRuleNames()[ctx.getRuleIndex()];

            //System.out.println(e != null ? e.getClass().getSimpleName() : "null");

            if(e == null) {
                throw new SyntaxError(msg, lineMap.get(line), charPositionInLine);
            }

            String message = tryToResolveError(parser, token, rulename, e);

//            System.out.println(ExpectedTokens(parser));
//            System.out.println(rulename + " " + token.getText() + " " + ctx.start.getText());
            throw new SyntaxError(message==null ? msg : message, lineMap.get(line), charPositionInLine);
        } else {

            MusicLexer lexer = (MusicLexer) recognizer; // Cast recognizer to lexer, because it's lexer's stage

            CodePointCharStream charStream = (CodePointCharStream) lexer.getInputStream(); // Retrieve input stream at the time of an error
            // (Our is CodePoint32BitCharStream ,but I used parent class just in case)

            String errorChar = new String(Character.toChars(charStream.LA(1))); //Return char that caused the error
            // Using Character class to handle extended Unicode character (e.g. emojis)
            String proposedWord = LevenshteinDamerau.proposeWord(errorChar, vocabularyStrings(lexer.getVocabulary()), 1);
            if(proposedWord != null){
                throw new SyntaxError("Unrecognized character: " + errorChar + " Did you mean " + proposedWord, lineMap.get(lexer.getLine()), lexer.getCharPositionInLine());
            }else {
                throw new SyntaxError("Unrecognized character: " + errorChar + " No viable proposals", lineMap.get(lexer.getLine()), lexer.getCharPositionInLine());
            }
        }
        // throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }

    private String ExpectedTokens(Parser parser) {

//        ArrayList<String> expectedTokens = new ArrayList<>();
//
//        if (parser.getExpectedTokens() == null) {
//            return null;
//        }

        IntervalSet tokens = parser.getExpectedTokens();

//        for (int i = 0; i < tokens.size() - 1; i++) {
//            expectedTokens.add(parser.getVocabulary().getDisplayName(tokens.get(i)));
//        }
        return tokens.toString(parser.getVocabulary());

    }

    public String tryToResolveError(MusicParser parser, CommonToken faultyToken, String rulename, RecognitionException e) {
        ParserRuleContext ctx = parser.getRuleContext();
        String tokenTypeName = getLexemName(faultyToken);
        String tokens = ExpectedTokens(parser);

        //System.out.println(ctx.start.getText() + " " + ctx.getText() + " " + faultyToken.getText() + " " + rulename + " " + tokenTypeName);
//        if(tokens.equals("';'")) {
//            return "missing ;";
//        }


//        if(tokenTypeName != null ) {
//            switch (tokenTypeName) {
//                case "NOTE_VAL":
//                    return "Note value cannot be here";
//                case "INT_VAL":
//                    return "Integer value cannot be here";
//                case "BOOL_VAL":
//                    return "Boolean value cannot be here";
//                case "STRING_VAL":
//                    return "String value cannot be here";
//                case "INSTRUMENT_VALUE":
//                    return "Instrument value cannot be here";
//
//            }
//
//        }

        if(rulename.equals("settings") ){
            return "Cannot perform this " + faultyToken.getText() + " action while setting an option";
        }

        if(rulename.equals("expr") && ctx.getParent() instanceof MusicParser.IfContext) {
            return "If expression cannot be empty";
        }
        if(rulename.equals("expr") && ctx.getParent() instanceof MusicParser.WhileLoopContext) {
            return "While loop expression cannot be empty";
        }

        String wordProposal = LevenshteinDamerau.proposeWord(faultyToken.getText(), vocabularyStrings(parser.getVocabulary()), 1);


        if(wordProposal != null){
            return "Unrecognized character: " + faultyToken.getText() + " Did you mean " + LevenshteinDamerau.proposeWord(faultyToken.getText(),vocabularyStrings(parser.getVocabulary()), 1);
        }else {
            return "Unrecognized character: " + faultyToken.getText() + " No viable proposal ";
        }
    }

    private String getLexemName(CommonToken token) {
        return MusicParser.VOCABULARY.getSymbolicName(token.getType());
    }

    private ArrayList<String> vocabularyStrings(Vocabulary vocabulary) {
        ArrayList<String> vocabularyStrings = new ArrayList<>();
        for (int i = 0; i < vocabulary.getMaxTokenType(); i++){
            String displayName = vocabulary.getLiteralName(i);
            if (displayName != null){
                vocabularyStrings.add(vocabulary.getLiteralName(i).substring(1, vocabulary.getLiteralName(i).length() - 1));
            }
        }
        return vocabularyStrings;
    }

}
