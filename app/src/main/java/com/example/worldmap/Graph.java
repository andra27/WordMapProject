package com.example.worldmap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldmap.sqlite.helper.DatabaseHelper;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {

    DatabaseHelper db;
    BarChart barChart;
    ArrayList<VisitedCountries> list;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        barChart=findViewById(R.id.visitedBarchart);
        tv=(TextView)findViewById(R.id.textViewStat);
        btn=(Button)findViewById(R.id.butDone);
        ArrayList<BarEntry> entries = new ArrayList<>();
        db=new DatabaseHelper(getApplicationContext());
        list= new ArrayList<VisitedCountries>();
        list=db.getAllVC();
        int ids= 1;
        int count=0;
        for(int i=0;i<list.size();i++)
        {
            if(ids==list.get(i).getCountryId()){
            count++;
            }
        }
        entries.add(new BarEntry(0,count));

        int ids2= 2;
        int count2=0;
        for(int i=0;i<list.size();i++)
        {
            if(ids2==list.get(i).getCountryId()){
                count2++;
            }
        }
        entries.add(new BarEntry(1,count2));

        int ids3= 3;
        int count3=0;
        for(int i=0;i<list.size();i++)
        {
            if(ids3==list.get(i).getCountryId()){
                count3++;
            }
        }
        entries.add(new BarEntry(2,count3));
        int ids4= 4;
        int count4=0;
        for(int i=0;i<list.size();i++)
        {
            if(ids4==list.get(i).getCountryId()){
                count4++;
            }
        }
        entries.add(new BarEntry(3,count4));

        BarDataSet bardataset = new BarDataSet(entries, "Cells");

        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("Cairo");
        labels.add("Bucharest");
        labels.add("Paris");
        labels.add("Canberra");



        BarData data = new BarData( bardataset);
        XAxis x=barChart.getXAxis();
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);

        ValueFormatter formatter=new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return labels.get((int)value);
            }
        };
        x.setGranularity(1f);
        x.setValueFormatter(formatter);
        barChart.setData(data);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
