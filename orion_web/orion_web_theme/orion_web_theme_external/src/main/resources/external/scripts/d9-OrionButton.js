var buttons = 
{
    bindEnterKeyToElement : function(IDOfHTMLElementToBindEnterKeyFor, IDOfButtonToClick)
    {
        $("#" + IDOfHTMLElementToBindEnterKeyFor).on("keypress", function(args)
        {
            if(args.keyCode == 13)
            {
                $("#" + IDOfButtonToClick).click();
                return false;
            }
        });
    },
    
    
    updateRadioButtons : function(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue)
    {
        $("#" + IDOfHiddenInputToGetRadioButtonValue).val($("." + radioButtonsClass + ":checked").val());
    },
    
    
    bindAndUpdateRadioButtons : function(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue)
    {
        $("." + radioButtonsClass).bind("click", function()
        {
            buttons.updateRadioButtons(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue);
        });
    },
    
    
    bindCopyButton : function(IDOfCopyButton, IDOfElementToCopy)
    {
        $("#" + IDOfCopyButton).bind("click", function()
        {
            common.copyToClipboard(IDOfElementToCopy);
        });
    },
    
    
    bindOpenModalButton : function(IDOfOpenModalButton, modalID)
    {
        $("#" + IDOfOpenModalButton).bind("click", function()
        {
            $("#" + modalID).click();
        });
    },
    
    
    createSearchButton : function(buttonID, buttonText)
    {
        if(buttonText !== undefined && buttonText !== null && buttonText !== "")
        {
            return "<button id='" + buttonID + "' class='btn btn-outline-success'>" + buttonText + "</button>";
        }
        else
        {
            return "<button id='" + buttonID + "' class='btn btn-outline-success'><i class='zmdi zmdi-sun'></i></button>";
        }
    },
    
    
    createDownloadAsCSVButton : function(buttonID, buttonText)
    {
        return "<button id='" + buttonID + "' class='btn btn-outline-danger'>" + buttonText + "&nbsp;&nbsp;<img class='button_icon' src='/images/icons2/csv.jpg' width='46%'/></button>";
    }
};