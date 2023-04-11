var uploadDownload = 
{
    createFormToDownloadFile : function(URLOfFileToDownload)
    {
        var downloadButton = document.createElement("form");
        downloadButton.setAttribute("method", "post");
        downloadButton.setAttribute("action", URLOfFileToDownload);
        document.body.appendChild(downloadButton);
        downloadButton.submit();
        document.body.removeChild(downloadButton);
    },
    
    
    bindDownloadButtonAndCreateFormToDownloadFile : function(IDOfDownloadButton, URLOfFileToDownload)
    {
        $("#" + IDOfDownloadButton).bind("click", function()
        {
            uploadDownload.createFormToDownloadFile(URLOfFileToDownload);
        });
    },
};