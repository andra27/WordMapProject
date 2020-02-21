package com.example.worldmap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.worldmap.sqlite.helper.DatabaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tvResp1;
    TextView tvResp2;
    TextView tvResp3;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    ImageButton btnSaveFile;
    DatabaseHelper db;


    private OnFragmentInteractionListener mListener;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_settings, container, false);
        tv1=(TextView)view.findViewById(R.id.tvInfo);
        tv2=(TextView)view.findViewById(R.id.tvQuestion1);
        tv3=(TextView)view.findViewById(R.id.tvQuestion2);
        tv4=(TextView)view.findViewById(R.id.tvQuestion3);
        tv5=(TextView)view.findViewById(R.id.textView5);
        tvResp1=(TextView)view.findViewById(R.id.tvAnswer1);
        tvResp2=(TextView)view.findViewById(R.id.tvAnswer12);
        tvResp3=(TextView)view.findViewById(R.id.tvAnswer3);
        btn1=(Button)view.findViewById(R.id.btNFindOut);
        btn2=(Button)view.findViewById(R.id.btnFindOut1);
        btn3=(Button)view.findViewById(R.id.btnFindOut2);
        btn4=(Button)view.findViewById(R.id.btnClickJson);
        btnSaveFile=(ImageButton)view.findViewById(R.id.btnSave);
        db= new DatabaseHelper(getContext());


        btnSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title=tv1.getText().toString();
                String tvQ1=tv2.getText().toString();
                String tvQ2=tv3.getText().toString();
                String tvQ3=tv4.getText().toString();
                String tvInfo=tv5.getText().toString();
                String tvresp1=tvResp1.getText().toString();
                String tvresp2=tvResp2.getText().toString();
                String tvresp3=tvResp3.getText().toString();

                StringBuilder sb=new StringBuilder();
                sb.append(title);
                sb.append("\n\r");
                sb.append(tvQ1+"\n\r"+"  Answer: "+tvresp1);
                sb.append("\n\r");
                sb.append(tvQ2+"\n\r"+"  Answer: "+tvresp2);
                sb.append("\n\r");
                sb.append(tvQ3+"\n\r"+"  Answer: "+tvresp3);
                sb.append("\n\r");
                sb.append("The three countries that have the highest population:");
                sb.append("\n\r");
                sb.append(tvInfo);

                Log.v("ceva:",sb.toString());
                try{
                    FileOutputStream fileOut=getActivity().openFileOutput("FileName.txt", getContext().MODE_APPEND);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileOut);
                    outputWriter.write(sb.toString());
                    outputWriter.close();
                    fileOut.close();
                    Toast.makeText(getActivity(),"The file was saved!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getContext(),File.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("files",sb.toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String info= db.getInfo(2);
               tvResp1.setText(info);
               Toast.makeText(getActivity(),"The country with the largest surface is Russia!",Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String info= db.getInfo(3);
                tvResp2.setText(info);
                Toast.makeText(getActivity(),"Africa has 54 countries!",Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info= db.getInfo(4);
                tvResp3.setText(info);
                Toast.makeText(getActivity(),"90% of the world's fresh water is in Antarctica!",Toast.LENGTH_SHORT).show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iau din file si dupa ilk pu in text view

                JSONObject reader=null;
                try {
                    reader=new JSONObject(loadJSONFromAsset());

//                    Reader readerr = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//                    JSONObject reader = new JSONObject(new String());
                    JSONObject one=reader.getJSONObject("1");
                    String country=one.getString("country");
                    String population=one.getString("population");
                    String capital=one.getString("capital");

                    JSONObject two= reader.getJSONObject("2");
                    String country2=two.getString("country");
                    String population2=two.getString("population");
                    String capital2=two.getString("capital");

                    JSONObject three= reader.getJSONObject("3");
                    String country3=two.getString("country");
                    String population3=two.getString("population");
                    String capital3=two.getString("capital");


                    tv5.setText(country+" that has a population of "+population+" with capital at "+ capital+System.getProperty("line.separator")+
                            country2+" that has a population of "+population2+" with capital at "+ capital2+System.getProperty("line.separator")+
                            country3+" that has a population of "+population3+" with capital at "+ capital3+System.getProperty("line.separator")
                    );



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

        return view;
    }


    public  String loadJSONFromAsset(){
        String json=null;
        try{
            InputStream is=getActivity().getAssets().open("countriess.json");
            int size=is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            json= new String(buffer,"UTF-8");


        }catch(IOException ex){
            ex.printStackTrace();
            return null;

        }
        return json;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
