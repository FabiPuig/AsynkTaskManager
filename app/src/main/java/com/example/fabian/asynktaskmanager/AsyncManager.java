package com.example.fabian.asynktaskmanager;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Fabian on 07/06/2017.
 */

public class AsyncManager {

    private static ProgressDialog progressDialog;


    public static class AsyncOne extends AsyncTask<Void, Void, Bitmap> {

        private String wow = "https://bnetproduct-a.akamaihd.net//dg/7364/751D461631E9293C9460EC52BE3A3736C9B89E61.jpg";
        private AsyncResponse asyncResponse = null;

        public interface AsyncResponse {
            void processFinish( Bitmap bitmap );
        }


        public AsyncOne(Activity activity, AsyncResponse asyncResponse ){
            this.asyncResponse = asyncResponse;
            progressDialog = new ProgressDialog( activity );
            progressDialog.setMessage("Cargando...");

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;
            InputStream in = null;
            try {
                in = new java.net.URL( wow ).openStream();
                bitmap = BitmapFactory.decodeStream(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressDialog.dismiss();
            asyncResponse.processFinish( bitmap );
        }
    }


    public static class AsyncTwo extends AsyncTask<Void, Void, Bitmap> {

        private String lol = "http://img3.meristation.com/files/imagenes/general/league-of-legends_0.jpg";
        private AsyncResponse asyncResponse = null;

        public interface AsyncResponse {
            void processFinish( Bitmap bitmap );
        }

        public AsyncTwo( Activity activity, AsyncResponse asyncResponse ){
            this.asyncResponse = asyncResponse;
            progressDialog = new ProgressDialog( activity );
            progressDialog.setMessage("Cargando...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;
            InputStream in;
            try {
                in = new java.net.URL( lol ).openStream();
                bitmap = BitmapFactory.decodeStream(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressDialog.dismiss();
            asyncResponse.processFinish(bitmap);
        }
    }

    public static class AsyncThree extends AsyncTask<Void, Void, Bitmap> {

        private String csgo = "http://www.logicalincrements.com/assets/img/articles/csgo/csgowallpaper4.jpg";
        private AsyncResponse asyncResponse;

        public interface AsyncResponse{
            void processFinish( Bitmap bitmap );
        }

        public AsyncThree( Activity activity, AsyncResponse asyncResponse ){
            this.asyncResponse = asyncResponse;
            progressDialog = new ProgressDialog( activity );
            progressDialog.setMessage("Cargando...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;
            InputStream in = null;
            try {
                in = new java.net.URL( csgo ).openStream();
                bitmap = BitmapFactory.decodeStream(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;       }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressDialog.dismiss();
            asyncResponse.processFinish( bitmap );
        }
    }
}
