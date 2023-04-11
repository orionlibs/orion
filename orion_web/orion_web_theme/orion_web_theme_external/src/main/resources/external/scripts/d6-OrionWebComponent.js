var webComponent = 
{
    load : function(webComponentURLToLoad, IDOfHTMLElementToLoadWebComponentIn)
    {
        $("#" + IDOfHTMLElementToLoadWebComponentIn).load(webComponentURLToLoad);
    },
    
    
    addOnLoadEvent : function(onLoadFunction)
    {
        var oldOnLoad = window.onload;
        
        if(typeof window.onload != 'function')
        {
            window.onload = onLoadFunction;
        }
        else
        {
            window.onload = function()
            {
                if(oldOnLoad)
                {
                    oldOnLoad();
                }
                
                onLoadFunction();
            }
        }
    }
};