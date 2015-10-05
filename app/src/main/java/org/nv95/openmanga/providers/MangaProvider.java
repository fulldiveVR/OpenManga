package org.nv95.openmanga.providers;

import android.support.annotation.Nullable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by nv95 on 30.09.15.
 *
 */
public abstract class MangaProvider {
    protected boolean features[];
    //content access methods
    public abstract MangaList getList(int page) throws IOException;
    public abstract MangaSummary getDetailedInfo(MangaInfo mangaInfo);
    public abstract ArrayList<MangaPage> getPages(String readLink);
    public abstract String getPageImage(MangaPage mangaPage);
    //optional content acces methods
    @Nullable
    public MangaList search(String query) throws IOException {
        return null;
    }
    @Nullable
    public MangaChapters getChapters(MangaSummary mangaSummary) {
        return null;
    }
    //other methods
    public abstract String getName();
    public abstract boolean hasFeatures(int future);
    //String[] getGenres();

    //******************************static*********************************
    protected static Document getPage(String url) throws IOException {
        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        con.setConnectTimeout(15000);
        InputStream is = con.getInputStream();
        return Jsoup.parse(is, con.getContentEncoding(), url);
    }

    protected static Document getPage(String url, String cookie) throws IOException {
        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        con.setDoOutput(true);
        /*DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(cookies);
        out.flush();
        out.close();*/
        con.setRequestProperty("Cookie", cookie);
        con.setConnectTimeout(15000);
        InputStream is = con.getInputStream();
        return Jsoup.parse(is, con.getContentEncoding(), url);
    }

    protected static Document postPage(String url, String[] data) throws IOException {
        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        con.setConnectTimeout(15000);
        con.setRequestMethod("POST");
        if (data!=null) {
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            String query = "";
            for (int i = 0; i < data.length; i = i + 2) {
                query += URLEncoder.encode(data[i], "UTF-8") + "=" + URLEncoder.encode(data[i + 1], "UTF-8");
                query += "&";
            }
            if (query.length()>1) query = query.substring(0, query.length() - 1);
            out.writeBytes(query);
            out.flush();
            out.close();
        }
        InputStream is = con.getInputStream();
        return Jsoup.parse(is, con.getContentEncoding(), url);
    }
}
