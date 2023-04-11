package com.orion.web.core.upload;

import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
class ServletResponseConfiguration
{
    private HttpServletResponse response;
    private String MIMEType;
    private String fileNameForClient;
    private int contentLength;
}