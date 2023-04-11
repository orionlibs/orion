$(document).ready(function()
{
    window.onerror = function()
    {
        return true;
    }
});


var navigation = 
{
    bindMenuButton : function(menuButtonID, hrefToOpen)
    {
        $("#" + menuButtonID).bind("click", function()
        {
            window.location.href = hrefToOpen;
        });
    },


    goToPreviousPage : function()
    {
        window.history.back();
    },
    
    
    showPreloader : function(duration)
    {
        if(duration !== undefined && duration !== null)
        {
            $("#loader-wrapper").delay(duration).fadeOut();
        }
        else
        {
            $("#loader-wrapper").delay(1000).fadeOut();
        }
    },
    
    
    showPreloaderConstantly : function()
    {
        $("#loader-wrapper").show();
    },
    
    
    hidePreloader : function()
    {
        $("#loader-wrapper").fadeOut();
    }
};