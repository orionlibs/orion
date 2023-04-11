package com.orion.web.core.services;

import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class JavaNetExample
{
    /*
     * public static void main(String[] args) { OrionUserModel user =
     * OrionUserModel.of(); user.setUserID("user ID"); String userJSON =
     * JSONService.convertObjectToJSON(user); String https_url =
     * "https://api.signable.co.uk/v1/envelopes"; try { SSLContext ssl_ctx =
     * SSLContext.getInstance("TLS"); TrustManager[] trust_mgr =
     * getCertificateTrustManager(); ssl_ctx.init(null, trust_mgr, new
     * SecureRandom());
     * HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
     * URL url = new URL(https_url); HttpsURLConnection con =
     * (HttpsURLConnection)url.openConnection(); String authString =
     * "21822b4b6fb4de8bac020d49462d5926:x"; byte[] authEncBytes =
     * Base64EncodingService.encodeBase64ForString(authString.getBytes()).getBytes()
     * ; String authStringEnc = new String(authEncBytes);
     * con.setRequestProperty("Authorization", "Basic " + authStringEnc);
     * con.setRequestMethod("POST"); con.setDoOutput(true);
     * //con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
     * con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
     * con.addRequestProperty("envelope_title", "Test Contract");
     * con.addRequestProperty("envelope_documents", URLEncoder.encode(userJSON,
     * "UTF-8")); if(con != null) { try { try(OutputStream out =
     * con.getOutputStream()) { String o = "Content-Disposition: form-data; name=\""
     * + URLEncoder.encode("envelope_documents", "UTF-8") + "\"\r\n";
     * out.write(o.getBytes(StandardCharsets.UTF_8));
     * out.write(URLEncoder.encode(userJSON,
     * "UTF-8").getBytes(StandardCharsets.UTF_8)); } BufferedReader br = new
     * BufferedReader(new InputStreamReader(con.getInputStream())); String input;
     * while((input = br.readLine()) != null) { System.out.println(input); }
     * br.close(); } catch(IOException e) { e.printStackTrace(); } } }
     * catch(NoSuchAlgorithmException e) { e.printStackTrace(); }
     * catch(KeyManagementException e) { e.printStackTrace(); }
     * catch(MalformedURLException e) { e.printStackTrace(); } catch(IOException e)
     * { e.printStackTrace(); } }
     */
    private static TrustManager[] getCertificateTrustManager()
    {
        TrustManager[] certs = new TrustManager[]
        {new X509TrustManager()
        {
            public X509Certificate[] getAcceptedIssuers()
            {
                return null;
            }


            public void checkClientTrusted(X509Certificate[] certs, String t)
            {
            }


            public void checkServerTrusted(X509Certificate[] certs, String t)
            {
            }
        }};
        return certs;
    }
}