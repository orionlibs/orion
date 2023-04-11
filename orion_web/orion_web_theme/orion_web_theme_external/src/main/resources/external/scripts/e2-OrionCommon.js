$(document).ready(function()
{
    window.onerror = function()
    {
        return true;
    }
    
    
    giveOnLoadSupportToAllHTMLElements();
});


function giveOnLoadSupportToAllHTMLElements()
{
    jQuery.each($("[onload]"), function(index, item)
    {
        $(item).prop("onload").call(item);
        return false;
    });
}


var common = 
{
    createSweetAlertDialog : function(title, message, alertType)
    {
        commonSweetAlert.createDialog(title, message, alertType);
    },
    
    
    bindAndCreateSweetAlertDialog : function(IDOfElementToBind, title, message, alertType)
    {
        commonSweetAlert.bindAndCreateDialog(IDOfElementToBind, title, message, alertType);
    },
    
    
    bindAndCreateSweetWarningDialog : function(IDOfElementToBind, title, message, functionCallbackOnConfirmation)
    {
        commonSweetAlert.bindAndCreateWarningDialog(IDOfElementToBind, title, message, functionCallbackOnConfirmation);
    },
    
    
    createSweetAlertSuccessDialog : function(message)
    {
        commonSweetAlert.createSuccessDialog(message);
    },
    
    
    bindAndCreateSweetAlertSuccessDialog : function(IDOfElementToBind, message)
    {
        commonSweetAlert.bindAndCreateSuccessDialog(IDOfElementToBind, message);
    },
    
    
    createSweetAlertErrorDialog : function(message)
    {
        commonSweetAlert.createErrorDialog(message);
    },
    
    
    bindAndCreateSweetAlertErrorDialog : function(IDOfElementToBind, message)
    {
        commonSweetAlert.bindAndCreateErrorDialog(IDOfElementToBind, message);
    },
    
    
    loadWebComponent : function(webComponentURLToLoad, IDOfHTMLElementToLoadWebComponentIn)
    {
        webComponent.load(webComponentURLToLoad, IDOfHTMLElementToLoadWebComponentIn);
    },
    
    
    addOnLoadEvent : function(onLoadFunction)
    {
        webComponent.addOnLoadEvent(onLoadFunction);
    },
    
    
    bindEnterKeyToElement : function(IDOfHTMLElementToBindEnterKeyFor, IDOfButtonToClick)
    {
        buttons.bindEnterKeyToElement(IDOfHTMLElementToBindEnterKeyFor, IDOfButtonToClick);
    },
    
    
    updateRadioButtons : function(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue)
    {
        buttons.updateRadioButtons(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue);
    },
    
    
    bindAndUpdateRadioButtons : function(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue)
    {        
        buttons.bindAndUpdateRadioButtons(radioButtonsClass, IDOfHiddenInputToGetRadioButtonValue);
    },
    
    
    createFormToDownloadFile : function(URLOfFileToDownload)
    {
        uploadDownload.createFormToDownloadFile(URLOfFileToDownload);
    },
    
    
    bindDownloadButtonAndCreateFormToDownloadFile : function(IDOfDownloadButton, URLOfFileToDownload)
    {
        uploadDownload.bindDownloadButtonAndCreateFormToDownloadFile(IDOfDownloadButton, URLOfFileToDownload);
    },
    
    
    copyToClipboard : function(IDOfElementToCopy)
    {
        copy.copyToClipboard(IDOfElementToCopy);
    },
    
    
    bindCopyButtonsForTableInModal : function(copyButtonsIDsPrefix, prefixOfIDOfElementToCopy)
    {
        copy.bindCopyButtonsForTableInModal(copyButtonsIDsPrefix, prefixOfIDOfElementToCopy);
    },
    
    
    bindCopyButtonsForTableInModalWhenPaginationButtonIsClicked : function(selectorOfElementToBind, copyButtonsIDsPrefix, prefixOfIDOfElementToCopy)
    {
        copy.bindCopyButtonsForTableInModalWhenPaginationButtonIsClicked(selectorOfElementToBind, copyButtonsIDsPrefix, prefixOfIDOfElementToCopy);
    },
    
    
    bindCopyButton : function(IDOfCopyButton, IDOfElementToCopy)
    {
        buttons.bindCopyButton(IDOfCopyButton, IDOfElementToCopy);
    },
    
    
    bindOpenModalButton : function(IDOfOpenModalButton, modalID)
    {
        buttons.bindOpenModalButton(IDOfOpenModalButton, modalID)
    },
    
    
    createSearchButton : function(buttonID, buttonText)
    {
        return buttons.createSearchButton(buttonID, buttonText);
    },
    
    
    createDownloadAsCSVButton : function(buttonID, buttonText)
    {
        return buttons.createDownloadAsCSVButton(buttonID, buttonText);
    },
    
    
    getTimeseriesChartData : function(data, chartLabel)
    {
        return chart.getTimeseriesChartData(data, chartLabel);
    },
    
    
    convertListOfListsToString : function(data)
    {
        var dataAsString = "[";
            
        for(var i = 0; i < data.length; i++)
        {
            dataAsString += "[";
            
            for(var j = 0; j < data[i].length; j++)
            {
                dataAsString += data[i][j];
                
                if(j < data[i].length - 1)
                {
                    dataAsString += ",";
                }
            }
            
            dataAsString += "]";
            
            if(i < data.length - 1)
            {
                dataAsString += ",";
            }
        }
        
        return dataAsString + "]";
    },
    
    
    getSubstringAfterLastUnderscore : function(value)
    {
        return value.substring(value.lastIndexOf("_") + 1);
    },
    
    
    resetTextInputs : function(textInputsClass)
    {
        $(".textInputsClass").val("");
    },
    
    
    resetTextInputsInsideElementWithID : function(elementID)
    {
        $("#" + elementID).find("input:text").val("");
    },
    
    
    resetTextInputsInsideElementWithClass : function(elementClass)
    {
        $("." + elementClass).find("input:text").val("");
    },
    
    
    uncheckRadioButton : function(radioButtonID)
    {
        $("#" + radioButtonID).prop("checked", false);
    },
    
    
    uncheckRadioButtons : function(radioButtonsClass)
    {
        $("." + radioButtonsClass).prop("checked", false);
    },
    
    
    uncheckSelectInputWithID : function(selectInputID)
    {
        $("#" + selectInputID).prop("checked", false);
    },
    
    
    uncheckSelectInputsWithClass : function(selectInputsClass)
    {
        $("." + selectInputsClass).prop("checked", false);
    },
    
    
    uncheckSelectInputsWithSelector : function(selector)
    {
        $(selector).find("input:checkbox").prop("checked", false);
    }
};