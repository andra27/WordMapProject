package com.example.worldmap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jp.wasabeef.picasso.transformations.GrayscaleTransformation;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WorldMapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WorldMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorldMapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    ImageView imgPrincipal;
    Button b1;
    Button upload;
    private static final int PICK_IMAGE=20;
    Uri imageUri;

    private OnFragmentInteractionListener mListener;

    public WorldMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment WorldMapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorldMapFragment newInstance(String param1, String param2) {
        WorldMapFragment fragment = new WorldMapFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_world_map2, container, false);

         imgPrincipal=(ImageView) view.findViewById(R.id.imageWorldMap);
         b1=(Button)view.findViewById(R.id.button);
         upload=(Button)view.findViewById(R.id.buttonUpload);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (true==chechInternetConnection()) {
                     downloadImage("https://external-preview.redd.it/i0iUo157p8TNGgYXwvbazFSrS3JlaL9uhFHTOyryeiA.jpg?auto=webp&s=80c15c16a4d3cb7a159134e2107fbdeda551e54f");
                 }
             }
         });
         upload.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 uploadPhoto();
             }


         });

        return view;
    }


    private void uploadPhoto(){
        Intent uploadPhotoGallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(uploadPhotoGallery,PICK_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri=data.getData();
            Picasso.get().load(imageUri).transform(new GrayscaleTransformation()).into(imgPrincipal);

        }
    }
    private void downloadImage(String urlStr){
        progressDialog=ProgressDialog.show(getContext(),"","Downloading Image from internet  ");
        final String url=urlStr;
        new Thread(){

            public void run(){
                InputStream in=null;
                Message msg=Message.obtain();
                try{
                    in=openHttpConnection(url);
                    bitmap= BitmapFactory.decodeStream(in);
                    Bundle b=new Bundle();
                    b.putParcelable("bitmap",bitmap);
                    msg.setData(b);
                    if(in!=null){
                        in.close();
                    }
                }catch(IOException e1){
                    e1.printStackTrace();
                }
                messageHandler.sendMessage(msg);
            }
        }.start();


    }



    private InputStream openHttpConnection(String urlStr){
        InputStream in=null;
        int resCode=-1;

        try{
            URL url= new URL(urlStr);
            HttpURLConnection httpConn=(HttpURLConnection)url.openConnection();
           // httpConn.setAllowUserInteraction(false);
           // httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            resCode=httpConn.getResponseCode();


            if(resCode==200/*HttpURLConnection.HTTP_OK*/){
                Log.v("okkkkkkk","okkk");
                in=httpConn.getInputStream();
                Log.v("okkkkkkk",String.valueOf(in));
            }

        } catch(MalformedURLException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }
        return in;
    }




    private Handler messageHandler= new Handler(){
        public void  handleMessage(Message msg){
            super.handleMessage(msg);
            //ImageView img=(ImageView)getView().findViewById(R.id.imageViewInternet);
            ImageView img1=(ImageView)getView().findViewById(R.id.imageWorldMap);
            img1.setImageBitmap((Bitmap)(msg.getData().getParcelable("bitmap")));
            progressDialog.dismiss();

        }
    };





    private boolean chechInternetConnection(){
        ConnectivityManager connec
                =(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);


        if ( connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
            Toast.makeText(this.getContext(), " Connected ", Toast.LENGTH_LONG).show();
            return true;
        }else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  ) {
            Toast.makeText(this.getContext(), " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
