package com.example.worldmap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.worldmap.sqlite.helper.DatabaseHelper;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisitedCountrieFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VisitedCountrieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisitedCountrieFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    DatabaseHelper db;
    ListView listView;
    ListAdapterVisited adapter;
    ArrayList<VisitedCountries> list;
    ImageButton btnSave;
    StringBuilder sb;

    private TextView textViewShow;

    private OnFragmentInteractionListener mListener;

    public VisitedCountrieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *  param1 Parameter 1.
     *  param2 Parameter 2.
     * @return A new instance of fragment VisitedCountrieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisitedCountrieFragment newInstance(/*String param1, String param2*/) {
        VisitedCountrieFragment fragment = new VisitedCountrieFragment();
       // Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onResume() {
        super.onResume();
        db=new DatabaseHelper(getContext());
        list= new ArrayList<VisitedCountries>();
        listView=getView().findViewById(R.id.lvVisitedCountries);
        list=db.getAllVC();
        for(int i=0;i<list.size();i++) {
            String nameCountry=list.get(i).getCountryName();
            adapter = new ListAdapterVisited(this.getContext(), list, nameCountry);
            listView.setAdapter(adapter);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_visited_countrie,container,false);
        db=new DatabaseHelper(getContext());

        TextView txtView=(TextView)v.findViewById(R.id.txtTitle);
        final String titlee=txtView.getText().toString();
        ImageButton imgBtn=(ImageButton)v.findViewById(R.id.btnAddVisited);
        Button btnAsyncTask=(Button)v.findViewById(R.id.btnAsyncTask);
        textViewShow=v.findViewById(R.id.tvShow);
        btnSave=(ImageButton)v.findViewById(R.id.btnSave);
        listView=v.findViewById(R.id.lvVisitedCountries);

        sb=new StringBuilder();
        sb.append(titlee);
        sb.append("\n\r");

        list= new ArrayList<VisitedCountries>();

        list=db.getAllVC();
        for(int i=0;i<list.size();i++) {
            String nameCountry=list.get(i).getCountryName();
            sb.append(list.get(i).getCountryName()+list.get(i).getNotes()+list.get(i).getDateStart());
            sb.append("\n\r");
            adapter = new ListAdapterVisited(this.getContext(), list, nameCountry);
            listView.setAdapter(adapter);
        }



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    FileOutputStream fileOut=getActivity().openFileOutput("VisitedCountriesFile.txt", getContext().MODE_APPEND); // you can directly give file name as FileName.csv
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileOut);
                    long count=db.countVC();
                    sb.append("You have visited: "+count+" countries!");
                    sb.append("\n\r");
                    outputWriter.write(sb.toString());
                    outputWriter.close();
                    fileOut.close();
                    Toast.makeText(getActivity(),"The file was saved!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getContext(),File2.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("files",sb.toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),AddCountry.class);
                startActivity(intent);
            }
        });


        btnAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner=new AsyncTaskRunner();
                String sleepTime="5";
                runner.execute(sleepTime);
                Intent intent = new Intent(v.getContext(), Graph.class);
                startActivity(intent);

            }
        });

        return v;
    }


    public class AsyncTaskRunner  extends AsyncTask<String,String,String> {

        private String resp;
        ProgressDialog progressDialog;
        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping...");
            try {
                int time = Integer.parseInt(params[0]) * 1000;
                Thread.sleep(time);
                resp="Slept for"+params[0]+" seconds";
            }catch(InterruptedException e){
                e.printStackTrace();
                resp=e.getMessage();
            }catch (Exception e){
                e.printStackTrace();
                resp=e.getMessage();

            }
            return resp;
        }


        @Override
        protected void onPreExecute() {
            progressDialog=ProgressDialog.show(getActivity(),"ProgressDialog","Wait for "+"5"+" seconds");

        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            int count=0;
            for(VisitedCountries r : list){
                count++;

            }
            textViewShow.setText("You visited "+count+" capitals!");


        }

        @Override
        protected void onProgressUpdate(String... values) {
            textViewShow.setText(values[0]);
        }
    }






    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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




