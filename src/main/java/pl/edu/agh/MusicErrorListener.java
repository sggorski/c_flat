package pl.edu.agh;

import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.ParseTree;
import pl.edu.agh.errors.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MusicErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {


        if (recognizer instanceof Parser) {
            CommonToken token = (CommonToken) offendingSymbol;
            MusicParser parser = (MusicParser) recognizer;
            ParserRuleContext ctx = parser.getRuleContext();
            String rulename = parser.getRuleNames()[ctx.getRuleIndex()];

            String message = tryToResolveError(parser, token, rulename);

            System.out.println(ExpectedTokens(parser));
            System.out.println(rulename + " " + token.getText() + " " + ctx.start.getText());
            throw new SyntaxError(message, line, charPositionInLine);
        } else {

            MusicLexer lexer = (MusicLexer) recognizer; // Cast recognizer to lexer, because it's lexer's stage

            CodePointCharStream charStream = (CodePointCharStream) lexer.getInputStream(); // Retrieve input stream at the time of an error
            // (Our is CodePoint32BitCharStream ,but I used parent class just in case)

            String errorChar = new String(Character.toChars(charStream.LA(1))); //Return char that caused the error
            // Using Character class to handle extended Unicode character (e.g. emojis)

            throw new SyntaxError("Unrecognized character: " + errorChar, lexer.getLine(), lexer.getCharPositionInLine());
        }
        // throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }

    private List<String> ExpectedTokens(Parser parser) {

        ArrayList<String> expectedTokens = new ArrayList<>();

        if (parser.getExpectedTokens() == null) {
            return null;
        }

        IntervalSet tokens = parser.getExpectedTokens();

        for (int i = 0; i < tokens.size() - 1; i++) {
            expectedTokens.add(parser.getVocabulary().getDisplayName(tokens.get(i)));
        }
        return expectedTokens;

    }

    public String tryToResolveError(MusicParser parser, CommonToken faultyToken, String rulename) {
        ParserRuleContext ctx = parser.getRuleContext();
        ArrayList<String> tokens = (ArrayList<String>) ExpectedTokens(parser);

        if(tokens != null ) {
            if(tokens.size() == 1 && tokens.get(0).equals(";")){
                return "Missing semicolon";
            }
        }

        if(rulename.equals("expr") && ctx.getParent() instanceof MusicParser.IfContext) {
            return "If expression cannot be empty";
        }
        if(rulename.equals("expr") && ctx.getParent() instanceof MusicParser.WhileLoopContext) {
            return "While loop expression cannot be empty";
        }

        return "Unrecognized character: " + faultyToken.getText();
    }


}
