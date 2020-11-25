package com.example.mobilefantasyadventure;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class PlayAppWidget extends AppWidgetProvider {
    private final String PLAY_BUTTON = "PLAY_BUTTON";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.play_app_widget);
            Intent intent = new Intent(context, PlayAppWidget.class).setAction(PLAY_BUTTON);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0, intent, 0);
            remoteViews.setOnClickPendingIntent(R.id.fullView, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        if(action.equals(PLAY_BUTTON)){
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.play_app_widget);
            ComponentName componentName = new ComponentName(context, PlayAppWidget.class);
            SoundPlayer.playSound(context, Phrase.getIntegerArrayList_Moon().get(1));
            remoteViews.setTextViewText(R.id.appwidget_text,Phrase.getStringArrayList().get(1));
            appWidgetManager.updateAppWidget(componentName, remoteViews);
        }
    }
}