package pl.edu.agh;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class MusicErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        CommonToken token = (CommonToken) offendingSymbol;

        if(recognizer instanceof Parser) {
            MusicParser parser = (MusicParser) recognizer;
           //System.out.println(parser.getContext().getText());
        }else {
            MusicLexer lexer = (MusicLexer) recognizer;
            //System.out.println(lexer.getInputStream());
        }
        //System.out.println(token.getText());
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
