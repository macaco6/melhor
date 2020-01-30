package com.example.tela;

import android.os.AsyncTask;

import com.example.tela.ui.CEP;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void,Void,CEP> {

        private final String cep;
        private static final String BLANK_SPACE =" ";
        public  HttpService(String cep){
            this.cep = cep;
        }

        @Override
        protected CEP doInBackground(Void... voids) {
            StringBuilder resposta = new StringBuilder();

            if (this.cep != null && this.cep.length() == 8){

                try{

                    URL url = new URL(" " + this.cep + "/json/");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-type","application/json");
                    connection.setRequestProperty("Accept","application/json");
                    connection.setConnectTimeout(5000);
                    connection.connect();

                    Scanner scanner = new Scanner(url.openStream());
                    while (scanner.hasNext()) {
                        resposta.append(scanner.next());
                        resposta.append(BLANK_SPACE);
                    }
                } catch (MalformedURLException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
                    return new Gson().fromJson(resposta.toString(), CEP.class);
            }

        }





