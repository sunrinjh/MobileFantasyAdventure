package com.example.mobilefantasyadventure;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Button;
import android.widget.RemoteViews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class PlayAppWidget extends AppWidgetProvider {
    private final String ACTION_BTN = "ButtonClick";
    AssetManager assetManager;
    Random random = new Random();
    String jsonData;
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.play_app_widget);



            Intent intent = new Intent(context, PlayAppWidget.class).setAction(ACTION_BTN);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0, intent, 0);
            context.sendBroadcast(intent);
            remoteViews.setOnClickPendingIntent(R.id.w_button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        }
    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();

        if(action.equals(ACTION_BTN)){
            assetManager = context.getAssets();
            try{
                InputStream is = assetManager.open("phrase.json");

                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);

                StringBuffer buffer = new StringBuffer();
                String line = reader.readLine();
                while(line!=null){
                    buffer.append(line+"\n");

                    line = reader.readLine();

                }
                jsonData = buffer.toString();

            } catch (IOException e) {
                e.printStackTrace();

            }
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(jsonData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String text = null;
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.play_app_widget);
            ComponentName componentName = new ComponentName(context, PlayAppWidget.class);
            JSONObject jsonObject = null;
            int randInt = random.nextInt(jsonArray.length());
            try {
                jsonObject = jsonArray.getJSONObject(randInt);
                text = jsonObject.getString("text");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(text.length() >32){
                text = text.substring(0,32)+"...";
            }
            remoteViews.setTextViewText(R.id.appwidget_text,text);

            appWidgetManager.updateAppWidget(componentName, remoteViews);
        }

    }
}