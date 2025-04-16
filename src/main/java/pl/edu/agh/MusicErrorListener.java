package pl.edu.agh;

import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.ParseTree;
import pl.edu.agh.errors.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.stream.Collectors;

public class MusicErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {


        if(recognizer instanceof Parser) {
            CommonToken token = (CommonToken) offendingSymbol;
            MusicParser parser = (MusicParser) recognizer;

            ParserRuleContext ctx = parser.getRuleContext();
            String rulename = parser.getRuleNames()[ctx.getRuleIndex()];

            System.out.println(ExpectedTokens(parser));
            System.out.println(rulename  + " " + token.getText() + " " +  ctx.start.getText());
            throw new SyntaxError("Unexpected symbol " + token.getText() + ", expecting: " + ExpectedTokens(parser), line, charPositionInLine);
        }else {

            MusicLexer lexer = (MusicLexer) recognizer; // Cast recognizer to lexer, because it's lexer's stage

            CodePointCharStream charStream = (CodePointCharStream) lexer.getInputStream(); // Retrieve input stream at the time of an error
            // (Our is CodePoint32BitCharStream ,but I used parent class just in case)

            String errorChar = new String(Character.toChars(charStream.LA(1))); //Return char that caused the error
            // Using Character class to handle extended Unicode character (e.g. emojis)

            throw new SyntaxError("Unrecognized character: " + errorChar, lexer.getLine(), lexer.getCharPositionInLine());
        }
       // throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }

    private String ExpectedTokens(Parser parser) {

        if(parser.getExpectedTokens() == null) {
            return null;
        }

        IntervalSet tokens = parser.getExpectedTokens();

        if(tokens.size() == 1){
            return " Expected value: " + parser.getVocabulary().getDisplayName(tokens.get(0));
        }else {
            StringBuilder buf = new StringBuilder();
            buf.append("{ ");
            for (int i = 0; i < tokens.size() - 1; i++) {
                buf.append(parser.getVocabulary().getDisplayName(tokens.get(i)) + ", ");
            }
            buf.append(parser.getVocabulary().getDisplayName(tokens.get(tokens.size() - 1)));
            buf.append(" }");
            return buf.toString();
        }
    }
}
