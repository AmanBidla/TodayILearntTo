package test.test;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BitlyClient client = new BitlyClient("dcd6cf5a9df3a93fef4d472a60bb49dd96c89f4e");
        client.shorten().addQueryParameter("GET","/v3/realtime/hot_phrases?access_token=dcd6cf5a9df3a93fef4d472a60bb49dd96c89f4e");
        client.shorten().buildUrl();
        Response<ShortenResponse>r=client.shorten().call();
        
        
        System.out.println(r);
        
     
    }
}
