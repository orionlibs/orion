var commonSweetAlert = 
{
    createDialog : function(title, message, alertType)
    {
        Swal.fire(
        {
            title: title,
            //text: message,
            html: message,
            type: alertType,
            buttonsStyling: false,
            confirmButtonClass: 'btn btn-lg btn-light',
            background: 'rgba(0, 0, 0, 0.75)'
        });
    },
    
    
    bindAndCreateDialog : function(IDOfElementToBind, title, message, alertType)
    {
        $("#" + IDOfElementToBind).click(function()
        {
            commonSweetAlert.createDialog(title, message, alertType);
        });
    },
    
    
    bindAndCreateWarningDialog : function(IDOfElementToBind, title, message, functionCallbackOnConfirmation)
    {
        $("#" + IDOfElementToBind).click(function()
        {
            Swal.fire(
            {
                title: title,
                text: message,
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: "OK",
                cancelButtonText: "Cancel",
                background: 'rgba(0, 0, 0, 0.75)',
            }).then((result) =>
            {
                if(result.isConfirmed)
                {
                    functionCallbackOnConfirmation();
                }
            });
        });
    },
    
    
    createSuccessDialog : function(message)
    {
        commonSweetAlert.createDialog("Success!", message, "success");
    },
    
    
    bindAndCreateSuccessDialog : function(IDOfElementToBind, message)
    {
        $("#" + IDOfElementToBind).click(function()
        {
            commonSweetAlert.createSuccessDialog(message);
        });
    },
    
    
    createErrorDialog : function(message)
    {
        commonSweetAlert.createDialog("Error", message, "warning");
    },
    
    
    bindAndCreateErrorDialog : function(IDOfElementToBind, message)
    {
        $("#" + IDOfElementToBind).click(function()
        {
            commonSweetAlert.createErrorDialog(message);
        });
    }
};