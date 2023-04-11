var ajaxResponseData = {};

var OrionAjax =
{
    numberOfAJAXRequests : 0,
    isAJAXLocked : false,
    waitingTime : undefined,
    action : undefined,
    callbackFunction : undefined,
    exception : undefined,
    
    
    simpleAjax : function(URL, postMethod, contentDataType, replaceDoubleQuotes)
    {
        OrionAjax.ajax(null, URL, postMethod, contentDataType, replaceDoubleQuotes);
    },
    
    
    ajax : function(callbackFunction, URL, postMethod, contentDataType, dataToSend, replaceDoubleQuotes)
    {
        OrionAjax.ajaxRequest("", callbackFunction, URL, postMethod, contentDataType, dataToSend, replaceDoubleQuotes);
    },
    
    
    ajaxJSON : function(callbackFunction, URL, JSONDataToSend, postMethod)
    {
        OrionAjax.ajaxRequestJSON(callbackFunction, URL, JSONDataToSend, postMethod);
    },
    
    
    ajaxForFileUpload : function(callbackFunction, fileInputID, URL)
    {
        OrionAjax.ajaxRequestForFileUpload(callbackFunction, fileInputID, URL);
    },
    

    ajaxRequest : function(action, callbackFunction, URL, postMethod, contentDataType, dataToSend, replaceDoubleQuotes)
    {
        navigation.showPreloaderConstantly();
        var ajaxCaller = null;
        
        if(OrionAjax.ajaxRequest.caller)
        {
            ajaxCaller = OrionAjax.ajaxRequest.caller;
        }

        OrionAjax.numberOfAJAXRequests = OrionAjax.numberOfAJAXRequests + 1;

        if(OrionAjax.isAJAXLocked === false)
        {
            var requestCountAtLockPoint = OrionAjax.numberOfAJAXRequests;
            var parameters = {};
            
            if(dataToSend !== undefined && dataToSend !== null)
            {
                parameters = JSON.stringify(dataToSend);
            }
            else
            {
                parameters = OrionAjax.getAdvancedAjaxParametersObject(undefined, replaceDoubleQuotes);
            }
            
            OrionAjax.isAJAXLocked = true;
            //OrionAjax.exception = OrionAjax.createException();
            
            if(action !== undefined && action !== null && action !== "")
            {
                parameters.ajax_action = action;
            }

            setTimeout(function()
            {
                if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                {
                    OrionAjax.isAJAXLocked = false;
                    OrionAjax.ajaxRequest(action, callbackFunction, URL, postMethod, contentDataType, dataToSend, replaceDoubleQuotes);
                }
                else
                {
                    if(postMethod == undefined || postMethod == null || postMethod.length == 0)
                    {
                        postMethod = "POST";
                    }
                    
                    if(contentDataType == undefined || contentDataType == null || contentDataType.length == 0)
                    {
                        contentDataType = "application/x-www-form-urlencoded; charset=UTF-8";
                    }
                    else if(contentDataType === "json" || contentDataType === "JSON")
                    {
                        contentDataType = "application/json; charset=UTF-8";
                    }
                    
                    var headers = {};
                    headers["X-CSRF-TOKEN"] = $("input[name='_csrf']").val();
                    
                    $.ajax(
                    {
                        type : postMethod,
                        url : URL,
                        contentType : contentDataType,
                        data : parameters,
                        dataType : "json",
                        async : false,
                        crossDomain: true,
                        headers: headers,
                        
                        success : function(ajaxResponseData)
                        {
                            OrionAjax.isAJAXLocked = false;
                            
                            if(typeof ajaxResponseData === "object")
                            {
                                if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                                {
                                    OrionAjax.ajaxRequest(OrionAjax.action, OrionAjax.callbackFunction, URL, postMethod, contentDataType, dataToSend, replaceDoubleQuotes);
                                }
                                else
                                {
                                    OrionAjax.numberOfAJAXRequests = 0;
                                    requestCountAtLockPoint = 0;
                                }
                                
                                navigation.hidePreloader();
                                
                                if(typeof callbackFunction === "function")
                                {
                                    callbackFunction(ajaxResponseData);
                                }
                            }
                        },
                        
                        
                        error : function(jqXHR, text, errorThrown)
                        {
                            OrionAjax.isAJAXLocked = false;
                            
                            if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                            {
                                OrionAjax.ajaxRequest(OrionAjax.action, OrionAjax.callbackFunction, URL, postMethod, contentDataType, dataToSend, replaceDoubleQuotes);
                            }
                            
                            navigation.hidePreloader();
                            
                            if(typeof callbackFunction === "function")
                            {
                                callbackFunction(ajaxResponseData);
                            }
                        },


                        complete : function(jqXHR, textStatus)
                        {
                            navigation.hidePreloader();
                            OrionAjax.isAJAXLocked = false;
                        }
                    });
                }
            }, 20);
            
            OrionAjax.isAJAXLocked = false;
        }
    },
    
    
    ajaxRequestJSON : function(callbackFunction, URL, JSONDataToSend, postMethod)
    {
        navigation.showPreloaderConstantly();
        var ajaxCaller = null;
        
        if(OrionAjax.ajaxRequestJSON.caller)
        {
            ajaxCaller = OrionAjax.ajaxRequestJSON.caller;
        }

        OrionAjax.numberOfAJAXRequests = OrionAjax.numberOfAJAXRequests + 1;

        if(OrionAjax.isAJAXLocked === false)
        {
            var requestCountAtLockPoint = OrionAjax.numberOfAJAXRequests;
            var parameters = JSON.stringify(JSONDataToSend);
            OrionAjax.isAJAXLocked = true;
            //OrionAjax.exception = OrionAjax.createException();

            setTimeout(function()
            {
                if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                {
                    OrionAjax.isAJAXLocked = false;
                    OrionAjax.ajaxRequestJSON(callbackFunction, URL, JSONDataToSend);
                }
                else
                {
                    var headers = {};
                    headers["X-CSRF-TOKEN"] = $("input[name='_csrf']").val();
                    var postMethodToUse = "POST";
                    
                    if(postMethod !== undefined && postMethod !== null && postMethod.length > 0)
                    {
                        postMethodToUse = postMethod;
                    }
                    
                    $.ajax(
                    {
                        type : postMethodToUse,
                        url : URL,
                        contentType : "application/json",
                        data : parameters,
                        dataType : "json",
                        async : false,
                        crossDomain: true,
                        headers: headers,
                        
                        success : function(ajaxResponseData)
                        {
                            OrionAjax.isAJAXLocked = false;
                            
                            if(typeof ajaxResponseData === "object")
                            {
                                if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                                {
                                    OrionAjax.ajaxRequestJSON(OrionAjax.callbackFunction, URL, JSONDataToSend);
                                }
                                else
                                {
                                    OrionAjax.numberOfAJAXRequests = 0;
                                    requestCountAtLockPoint = 0;
                                }
                                
                                navigation.hidePreloader();
                                
                                if(typeof callbackFunction === "function")
                                {
                                    callbackFunction(ajaxResponseData);
                                }
                            }
                        },
                        
                        
                        error : function(jqXHR, text, errorThrown)
                        {
                            OrionAjax.isAJAXLocked = false;
                            
                            if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                            {
                                OrionAjax.ajaxRequestJSON(OrionAjax.callbackFunction, URL, JSONDataToSend);
                            }
                            
                            navigation.hidePreloader();
                            
                            if(typeof callbackFunction === "function")
                            {
                                callbackFunction(ajaxResponseData);
                            }
                        },


                        complete : function(jqXHR, textStatus)
                        {
                            navigation.hidePreloader();
                            OrionAjax.isAJAXLocked = false;
                        }
                    });
                }
            }, 20);
            
            OrionAjax.isAJAXLocked = false;
        }
    },
    
    
    ajaxRequestForFileUpload : function(callbackFunction, fileInputID, URL)
    {
        navigation.showPreloaderConstantly();
        var ajaxCaller = null;
        
        if(OrionAjax.ajaxRequest.caller)
        {
            ajaxCaller = OrionAjax.ajaxRequest.caller;
        }

        OrionAjax.numberOfAJAXRequests = OrionAjax.numberOfAJAXRequests + 1;

        if(OrionAjax.isAJAXLocked === false)
        {
            var requestCountAtLockPoint = OrionAjax.numberOfAJAXRequests;
            OrionAjax.isAJAXLocked = true;
            //OrionAjax.exception = OrionAjax.createException();

            setTimeout(function()
            {
                if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                {
                    OrionAjax.isAJAXLocked = false;
                    OrionAjax.ajaxRequestForFileUpload(callbackFunction, fileInputID, URL);
                }
                else
                {
                    postMethod = "POST";
                    contentDataType = "multipart/form-data";
                    var formData = new FormData();
                    formData.append("file", document.getElementById(fileInputID).files[0]);
                    
                    $.ajax(
                    {
                        type : postMethod,
                        url : URL,
                        enctype: contentDataType,
                        data : formData,
                        contentType : false,
                        processData : false,
                        
                        
                        success : function(ajaxResponseData)
                        {
                            if(typeof ajaxResponseData === "object")
                            {
                                if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                                {
                                    OrionAjax.ajaxRequestForFileUpload(callbackFunction, fileInputID, URL);
                                }
                                else
                                {
                                    OrionAjax.numberOfAJAXRequests = 0;
                                    requestCountAtLockPoint = 0;
                                }
                                
                                navigation.hidePreloader();
                                
                                if(typeof callbackFunction === "function")
                                {
                                    callbackFunction(ajaxResponseData);
                                }
                            }
                        },
                        
                        
                        error : function(jqXHR, text, errorThrown)
                        {
                            if(requestCountAtLockPoint !== OrionAjax.numberOfAJAXRequests)
                            {
                                OrionAjax.ajaxRequestForFileUpload(callbackFunction, fileInputID, URL);
                            }
                            
                            navigation.hidePreloader();
                            
                            if(typeof callbackFunction === "function")
                            {
                                callbackFunction(ajaxResponseData);
                            }
                        },


                        complete : function(jqXHR, textStatus)
                        {
                            navigation.hidePreloader();
                            OrionAjax.isAJAXLocked = false;
                        }
                    });
                }
            }, 1000);
        }
    },

    
    getAdvancedAjaxParametersObject : function(context, replaceDoubleQuotes)
    {
        var parametersObject = {};
        
        $('input[type="hidden"], input[type="text"], input[type="email"], input[type="file"], input[type="url"], input[type="password"], input[type="radio"], input[type="checkbox"], input[type="tel"]', context).each(function(index)
        {
            var currentItem = $(this);
            OrionAjax.addInputFieldToParam(currentItem.attr('name'), currentItem.val(), parametersObject, replaceDoubleQuotes);
        });
        
        $('textarea', context).each(function(index)
        {
            var currentItem = $(this);
            OrionAjax.addInputFieldToParam(currentItem.attr('name'), currentItem.val(), parametersObject, replaceDoubleQuotes);
        });

        $('select option', context).filter(":selected").each(function(index)
        {
            var currentItem = $(this);
            OrionAjax.addDropDownToParam(currentItem.parent().attr('name'), currentItem.val(), parametersObject);
        });

        return parametersObject;
    },
    
    
    addInputFieldToParam : function(inputFieldName, inputFieldValue, parametersObject, replaceDoubleQuotes)
    {
        if(inputFieldName !== undefined && inputFieldName !== null && inputFieldName.length > 0)
        {
            if(replaceDoubleQuotes === undefined || replaceDoubleQuotes === null || replaceDoubleQuotes)
            {
                if(inputFieldValue !== null && inputFieldValue !== undefined)
                {
                    inputFieldValue = inputFieldValue.replace(/"/g, "");
                }
            }
            
            parametersObject[inputFieldName] = inputFieldValue;
        }
    },

    
    addDropDownToParam : function(dropDownName, dropDownValue, parametersObject)
    {
        if(dropDownName !== null && dropDownName !== undefined && dropDownName.length > 0)
        {
            parametersObject[dropDownName] = dropDownValue;
        }
    }
};