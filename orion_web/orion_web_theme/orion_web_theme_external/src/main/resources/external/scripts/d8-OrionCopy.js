var copy = 
{
    copyToClipboard : function(IDOfElementToCopy)
    {
        var copyText = document.getElementById(IDOfElementToCopy);
        
        if(copyText.select || copyText.setSelectionRange)
        {
            copyText.select();
            copyText.setSelectionRange(0, 99999); /*For mobile devices*/
            document.execCommand("copy");
        }
        else
        {
            var textArea = document.createElement("textarea");
            textArea.value = copyText.textContent.trim();
            var copyTextParent = copyText.parentElement
            copyTextParent.appendChild(textArea);
            textArea.select();
            document.execCommand("copy");
            copyTextParent.removeChild(textArea);
        }
    },
    
    
    bindCopyButtonsForTableInModal : function(copyButtonsIDsPrefix, prefixOfIDOfElementToCopy)
    {
        $('[id^="' + copyButtonsIDsPrefix + '"]').bind("click", function()
        {
            var buttonID = $(this).prop("id").substring(copyButtonsIDsPrefix.length);
            copy.copyToClipboard(prefixOfIDOfElementToCopy + buttonID);
        });
    },
    
    
    bindCopyButtonsForTableInModalWhenPaginationButtonIsClicked : function(selectorOfElementToBind, copyButtonsIDsPrefix, prefixOfIDOfElementToCopy)
    {
        $(selectorOfElementToBind).bind("click", function()
        {
            copy.bindCopyButtonsForTableInModal(copyButtonsIDsPrefix, prefixOfIDOfElementToCopy);
            copy.bindCopyButtonsForTableInModalWhenPaginationButtonIsClicked(selectorOfElementToBind, copyButtonsIDsPrefix, prefixOfIDOfElementToCopy);
        });
    },
};