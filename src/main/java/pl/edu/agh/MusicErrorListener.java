package pl.edu.agh;

import pl.edu.agh.errors.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class MusicErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {


        if(recognizer instanceof Parser) {
            CommonToken token = (CommonToken) offendingSymbol;
            MusicParser parser = (MusicParser) recognizer;
            ParserRuleContext ctx = parser.getContext();
            String rulename = parser.getRuleNames()[ctx.getRuleIndex()];
        }else {

            MusicLexer lexer = (MusicLexer) recognizer; // Cast recognizer to lexer, because it's lexer's stage

            CodePointCharStream charStream = (CodePointCharStream) lexer.getInputStream(); // Retrieve input stream at the time of an error
            // (Our is CodePoint32BitCharStream but I used parent class just in case)

            String errorChar = new String(Character.toChars(charStream.LA(1))); //Return char that caused the error
            // Using Character class to handle extended unicode character (e.g emojis)

            throw new SyntaxError("Unrecognized character: " + errorChar, lexer.getLine(), lexer.getCharPositionInLine());
        }
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
