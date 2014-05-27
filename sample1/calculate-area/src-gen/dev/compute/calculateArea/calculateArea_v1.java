package com.chorusjs.process.junit;

/**
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org/>
**/

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.util.HashMap;


public class CalculateAreaTest {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		
		
        URL url = null;
		try {
		} catch (MalformedURLException e) {
			fail("MalformedURLException:"+url.toString()) ;
		}
		finally {
	        String query = "{ \"input\" : { \"a\": \"YOUR_VALUE_OF_A\", \"b\": \"YOUR_VALUE_OF_B\"}}";
	
	        //make connection
	        HttpURLConnection urlc = null;
	        try {
				urlc = (HttpURLConnection) url.openConnection();
		        urlc.setRequestMethod("POST");
		        //use post mode
		        urlc.setDoOutput(true);
		        urlc.setAllowUserInteraction(false);
		
		        urlc.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	
		        
		        //send query
		        java.io.OutputStreamWriter wr = new java.io.OutputStreamWriter(urlc.getOutputStream());
		        wr.write(query);
		        wr.flush();
		        	
		        //get result
		        BufferedReader br = new BufferedReader(new InputStreamReader(urlc
		            .getInputStream()));
		        String l = null;
		        String response = "" ;
		        while ((l=br.readLine())!=null) {
		            response += l ;
		        }
		        HashMap<Object,Object> o = ((HashMap<Object,Object>)JSON.parseJSON(response));
		        
		        HashMap<Object,Object> p = (HashMap<Object,Object>)JSON.get(o, "reply") ;
		        HashMap<Object,Object> r = (HashMap<Object,Object>)JSON.get(p, "response") ;
		        
		        
			    br.close();
			} catch (IOException e) {
				fail("IOException:"+url.toString()) ;
			}
		}
	}
}

