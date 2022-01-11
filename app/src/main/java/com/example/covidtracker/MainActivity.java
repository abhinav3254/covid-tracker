package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidtracker.api.ApiUtilites;
import com.example.covidtracker.api.CountryData;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView total_confirm,total_active,total_recovered,total_death,total_tests;
    private TextView today_confirm,today_recovered,today_death,date;

    private PieChart pieChart;

    private List<CountryData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        init();
        ApiUtilites.getApiInterface().getCountryData()
                .enqueue(new Callback<List<CountryData>>() {
                    @Override
                    public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
                     list.addAll(response.body());

                     for(int i=0;i<list.size();i++){
                         if(list.get(i).getCountry().equals("India")){
                             int confirm = Integer.parseInt(list.get(i).getCases());
                             int active = Integer.parseInt(list.get(i).getActive());
                             int recovered = Integer.parseInt(list.get(i).getRecovered());
                             int death = Integer.parseInt(list.get(i).getDeaths());

                             total_confirm.setText(NumberFormat.getInstance().format(confirm));
                             total_active.setText(NumberFormat.getInstance().format(active));

                             total_recovered.setText(NumberFormat.getInstance().format(recovered));

                             total_death.setText(NumberFormat.getInstance().format(death));

                             // adding today cases

                             today_death.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayDeaths())));
                             today_confirm.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayCases())));

                             today_recovered.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayRecovered())));

                             total_tests.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTests())));



                             // setting up date

                             setText(list.get(i).getUpdate());

                             // mPieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));

                             pieChart.addPieSlice(new PieModel("confirm",confirm,getResources().getColor(R.color.yellow)));
                             pieChart.addPieSlice(new PieModel("active",active,getResources().getColor(R.color.yellow)));

                             pieChart.addPieSlice(new PieModel("recovered",recovered,getResources().getColor(R.color.yellow)));
                             pieChart.addPieSlice(new PieModel("death",death,getResources().getColor(R.color.yellow)));

                             pieChart.startAnimation();


                         }
                     }
                    }

                    @Override
                    public void onFailure(Call<List<CountryData>> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setText(String update) {
        DateFormat format = new SimpleDateFormat("dd,MMM,yyyy");
        long miliseconds =  Long.parseLong(update);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(miliseconds);

        date.setText("Updated at "+format.format(calendar.getTime()));
    }

    public void init(){
        total_confirm = findViewById(R.id.total_confirm);
        total_active = findViewById(R.id.total_active);
        total_recovered = findViewById(R.id.total_recovered);
        total_death = findViewById(R.id.total_death);
        total_tests = findViewById(R.id.total_test);
        today_confirm = findViewById(R.id.today_confirm);
        today_recovered = findViewById(R.id.today_recovered);
        today_death = findViewById(R.id.today_death);
        pieChart = findViewById(R.id.piechart);
        //total_tests = findViewById(R.id.total_test);
        date = findViewById(R.id.date);
    }
}