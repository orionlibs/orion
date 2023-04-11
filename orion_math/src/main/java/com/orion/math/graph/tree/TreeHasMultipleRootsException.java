package com.orion.math.graph.tree;

import com.orion.math.MathError;

public class TreeHasMultipleRootsException extends MathError
{
    private static final String DefaultErrorMessage = "The given tree has multiple roots.";


    public TreeHasMultipleRootsException()
    {
        super(DefaultErrorMessage);
    }


    public TreeHasMultipleRootsException(String message)
    {
        super(message);
    }


    public TreeHasMultipleRootsException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public TreeHasMultipleRootsException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public TreeHasMultipleRootsException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
