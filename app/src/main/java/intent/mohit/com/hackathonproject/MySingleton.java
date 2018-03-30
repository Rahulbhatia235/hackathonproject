package intent.mohit.com.hackathonproject;

import com.android.volley.RequestQueue;
/**
 * Created by MOHIT KUMAR on 30-03-2018.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mctx;

    private MySingleton(Context context)
    {
        mctx=context;
        requestQueue=getRequestQueue();
    }
    public static synchronized MySingleton getInstance(Context context)
    {
        if(mInstance==null) {
            mInstance = new MySingleton(context);

        }return mInstance;
    }
    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;

    }
    public <T> void addToRequest(Request<T> request)
    {
        requestQueue.add(request);
    }


}

