import java.util.*;

public class ST
{
    private int _tokenCount = 0;
    private int _index;
    private String[] _tokens = new String[50];
    private String _delims;

    // Problem 1 & 2
    public ST(String input)
    {
        _delims = " ";
        _split(input);
    }

    // Problem 3 & 4
    public ST(String input, String delims)
    {
        _delims = delims;
        _split(input);
    }

    // Perhaps not a particularly elegant solution...
    private void _split(String input)
    {
        String letter;
        String token = "";

        for(int i = 0; i < input.length(); i++)
        {
            letter = input.substring(i, i + 1);
            if(_isDelim(letter)) 
            {
                if(token.length() > 0) 
                {
                    _tokens[_tokenCount] = token;
                    _tokenCount++;
                }
                token = "";
                continue;
            } 
            token += letter;
        }
        if(token.length() > 0)
        {
            _tokens[_tokenCount] = token;
            _tokenCount++;
        }
    }

    // Returns a boolean indicating whether the
    // given string is in the "array" of delimiters.
    private boolean _isDelim(String a)
    {
        String currentDelim;
        for(int i = 0; i < _delims.length(); i++)
        {
            currentDelim = _delims.substring(i, i + 1);
            if ( currentDelim.equals(a) ) return true;
        }
        return false;
    }

    // Returns the number of tokens yet to be returned.
    public int countTokens()
    {
        return (_tokenCount - _index);
    }

    // Returns a boolean indicating if any tokens
    // has yet to be returned.
    public boolean hasMoreTokens()
    {
        return (_tokenCount > _index);
    }

    // Advances the index and returns the next token.
    public String nextToken()
    {
        return _tokens[_index++];
    }
}
