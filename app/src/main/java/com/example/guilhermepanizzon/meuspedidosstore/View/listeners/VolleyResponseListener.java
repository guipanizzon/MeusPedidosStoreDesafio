package com.example.guilhermepanizzon.meuspedidosstore.View.Listeners;

import java.util.ArrayList;

/**
 * Created by guilhermepanizzon on 7/31/16.
 */

public interface VolleyResponseListener {
    void onError(String message);
    void onResponse(ArrayList<?> response);
}