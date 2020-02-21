package com.example.worldmap;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CountriesAndCapitalsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CountriesAndCapitalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountriesAndCapitalsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Spinner spinner;
    TextView txt;
    Country c;ListView lv;

    private OnFragmentInteractionListener mListener;

    public CountriesAndCapitalsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CountriesAndCapitalsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountriesAndCapitalsFragment newInstance(String param1, String param2) {
        CountriesAndCapitalsFragment fragment = new CountriesAndCapitalsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


     final  View view=inflater.inflate(R.layout.fragment_countries_and_capitals, container, false);
       spinner=(Spinner)view.findViewById(R.id.lvSpinner);
       txt=(TextView)view.findViewById(R.id.lvItem);
        lv=(ListView)view.findViewById(R.id.lvCountries);

        ArrayList<String> arrayList= new ArrayList<String>();
        arrayList.add("Africa");
        arrayList.add("Australia & Oceania");
        arrayList.add("Central America");
        arrayList.add("Central Asia");
        arrayList.add("East & Southeast Asia");
        arrayList.add("Europe");
        arrayList.add("Middle East");
        arrayList.add("North America");
        arrayList.add("South America");
        arrayList.add("South Asia");




        ArrayList<Country> arrayListSpinnerAfrica= new ArrayList<Country>();
        Capital caa=new Capital("Cairo","606km2" ,9500000f,"Its metropolitan area, with a population of over 20 million, is the largest in Africa, the Arab world, and the Middle East, and the 15th-largest in the world. Cairo is associated with ancient Egypt, as the famous Giza pyramid complex and the ancient city of Memphis are located in its geographical area.");
        Country c3=new Country("Egypt",99581200f,"Arabic",caa,"informati legate de tara");

        Capital caa1=new Capital("Addis Ababa","527 km2",3384569f,"Addis Ababa is therefore often referred to as \"the political capital of Africa\" for its historical, diplomatic and political significance for the continent.[5] The city lies a few miles west of the East African Rift which splits Ethiopia into two, through the Nubian Plate and the Somali Plate.");
        Country c4= new Country("Ethiopia",1000f,"Amharic",new Capital(),"Its capital and largest city is Addis Ababa, which lies a few miles west of the East African Rift that splits the country into the Nubian and Somali tectonic plates.");


        Capital cca2= new Capital("Nairobi","696 km2",9354580f,"Home to thousands of Kenyan businesses and over 100 major international companies and organizations, including the United Nations Environment Programme (UN Environment) and the United Nations Office at Nairobi (UNON), Nairobi is an established hub for business and culture.");
        Country c5= new Country("Kenya",47564296f,"Swahili",cca2,"Nairobi was founded in 1899 by the colonial authorities in British East Africa, as a rail depot on the Uganda Railway.[5] The town quickly grew to replace Mombasa as the capital of Kenya in 1907..");
        arrayListSpinnerAfrica.add(c3);
        arrayListSpinnerAfrica.add(c4);
        arrayListSpinnerAfrica.add(c5);

        ArrayList<Country> arrayListSpinnerAustrala_Oceania= new ArrayList<Country>();
        Capital caa3= new Capital("Canberra","814.2 km2",420960f,"Canberra does not have a local council or city government like other Australian cities. The Australian Capital Territory Legislative Assembly performs the roles of both a city council for the city and a territory government for the rest of the Australian Capital Territory.");
        Country c6=new Country("Australia",	25578900f,"English",caa3,"On 1 January 1901, the six colonies federated, forming the Commonwealth of Australia. Australia has since maintained a stable liberal democratic political system that functions as a federal parliamentary constitutional monarchy, comprising six states and ten territories.");

        Capital caa4= new Capital("Wellington","442 km2",418500f,"Described by Lonely Planet in 2013 as \"the coolest little capital in the world\", the emerging world city has grown from a bustling Māori settlement, to a small colonial outpost, and from there to an Australasian capital experiencing a \"remarkable creative resurgence\".");
        Country c7= new Country("New Zealand",4952190f,"English",caa4,"Sometime between 1250 and 1300, Polynesians settled in the islands and developed a distinctive Māori culture. In 1642, Dutch explorer Abel Tasman became the first European to sight New Zealand. In 1840, representatives of the United Kingdom and Māori chiefs signed the Treaty of Waitangi");

        Capital caa5= new Capital("Suva","2,048 km2",88271f,"Suva is the political, economic, and cultural centre of Fiji. It is also the economic and cultural capital of the South Pacific, hosting the majority of regional headquarters of major corporations, as well as international agencies and diplomatic missions in the region. ");
        Country c8= new Country("Fiji",912241f,"Fijian",caa5," Europeans visited Fiji from the 17th century onwards, and, after a brief period as an independent kingdom, the British established the Colony of Fiji in 1874. Fiji operated as a Crown colony until 1970, when it gained independence as the Dominion of Fiji.");

        arrayListSpinnerAustrala_Oceania.add(c6);
        arrayListSpinnerAustrala_Oceania.add(c7);
        arrayListSpinnerAustrala_Oceania.add(c8);


        ArrayList<Country> arrayListSpinnerCentral_America= new ArrayList<Country>();

        Capital caa6= new Capital("Havana","728.26 km2",2106146f,"Old Havana was declared a UNESCO World Heritage Site in 1982.[14] The city is also noted for its history, culture, architecture and monuments.");
        Country c9=new Country("Cuba",11209628f,"Spanish",caa6,"Since 1965, the state has been governed by the Communist Party of Cuba. The country was a point of contention during the Cold War between the Soviet Union and the United States, and a nuclear war nearly broke out during the Cuban Missile Crisis of 1962.");

        Capital caa7= new Capital("Guatemala City","108,889 km2",17263239f,"Guatemala's abundance of biologically significant and unique ecosystems includes many endemic species and contributes to Mesoamerica's designation as a biodiversity hotspot.");
        Country c10= new Country("Guatemala",17263239f,"Spanish",caa7,"From 1960 to 1996, Guatemala endured a bloody civil war fought between the US-backed government and leftist rebels, including genocidal massacres of the Maya population perpetrated by the military.");


        Capital caa8= new Capital("Kingston","480 km2",1243072f,"The city proper is bounded by Six Miles to the west, Stony Hill to the north, Papine to the northeast and Harbour View to the east, communities in urban and suburban Saint Andrew.");
        Country c11= new Country("Jamaica",2890299f,"English",caa8,"Jamaica is an upper-middle income country[16] with an economy heavily dependent on tourism, with an average of 4.3 million tourists a year.[17] Politically it is a Commonwealth realm, with Elizabeth II as its queen.");

        arrayListSpinnerCentral_America.add(c9);
        arrayListSpinnerCentral_America.add(c10);
        arrayListSpinnerCentral_America.add(c11);




        ArrayList<Country> arrayListSpinnerCentral_Asia= new ArrayList<Country>();

        Capital caa9= new Capital("Moscow","2,511 km2",12506468f,"Moscow is situated on the Moskva River in the Central Federal District of European Russia, making it Europe's most populated inland city. The city is well known for its architecture, particularly its historic buildings such as Saint Basil's Cathedral");
        Country c12=new Country("Russia",146801931f,"Russian",caa9,"ollowing the Russian Revolution, the Russian Soviet Federative Socialist Republic (Russian SFSR) became the largest and leading constituent of the Union of Soviet Socialist Republics (USSR/Soviet Union), the world's first constitutionally socialist state.");

        Capital caa10= new Capital("Dushanbe","143,100 km2",9275827f,"Tajikistan is a presidential republic consisting of four provinces. Most of Tajikistan's population belongs to the Tajik ethnic group,who speak Tajik (a dialect of Persian).");
        Country c13= new Country("Tajikistar",9275827f,"Russian",caa10," Since the end of the war, newly established political stability and foreign aid have allowed the country's economy to grow.");

        arrayListSpinnerCentral_Asia.add(c12);
        arrayListSpinnerCentral_Asia.add(c13);

        ArrayList<Country> arrayListSpinnerEast_SoutheastAsia= new ArrayList<Country>();

        Capital caa11= new Capital("Beijing","9,596,961 km2",1427647786f,"Since the introduction of economic reforms in 1978, China's economy has been one of the world's fastest-growing with annual growth rates consistently above 6 percent. According to the World Bank, China's GDP grew from $150 billion in 1978 to $12.24 trillion by 2017.");
        Country c14=new Country("China",1427647786f,"Standard Chinese",caa11,"China emerged as one of the world's first civilizations, in the fertile basin of the Yellow River in the North China Plain. For millennia, China's political system was based on hereditary monarchies, or dynasties, beginning with the semi-mythical Xia dynasty in 21st century BCE");

        Capital caa12= new Capital("Tokyo","2,193.96 km2",13929286f,"Tokyo ranks first in the Global Economic Power Index and third in the Global Cities Index. The GaWC's 2018 inventory classified Tokyo as an alpha+ world city [15] – and as of 2014 TripAdvisor's World City Survey ranked Tokyo first in its \"Best overall experience\" category");
        Country c15= new Country("Japan",126150000f,"Japanese",caa12,"While archaeological evidence indicates that Japan was inhabited as early as the Upper Paleolithic period, the first written mention of the archipelago appears in Chinese texts from the first century AD.");


        Capital caa13= new Capital("Bangkok","1,568.737 km2",8305218f,"An inadequate road network, despite an extensive expressway network, together with substantial private car usage, have led to chronic and crippling traffic congestion, which caused severe air pollution in the 1990s.");
        Country c16= new Country("Thailand",69428453f,"Thai",caa13,"Through the 18th and 19th centuries, Siam faced pressure from France and the United Kingdom, including forced concessions of territory; nevertheless, it remained the only Southeast Asian country to avoid direct Western rule. Following a bloodless revolution in 1932.");

        arrayListSpinnerEast_SoutheastAsia.add(c14);
        arrayListSpinnerEast_SoutheastAsia.add(c15);
        arrayListSpinnerEast_SoutheastAsia.add(c16);

        ArrayList<Country> arrayListSpinnerEurope= new ArrayList<Country>();


        Capital caa14= new Capital("","228 km2",1883425f,"Bucharest was first mentioned in documents in 1459. It became the capital of Romania in 1862 and is the centre of Romanian media, culture, and art. Its architecture is a mix of historical (neo-classical and Art Nouveau), interbellum (Bauhaus, and art deco), communist era and modern. ");
        Country c17=new Country("Romania",19401658f,"Romanian",caa14,"Romania ranks 52nd in the Human Development Index,and is a developing country.It has the world's 47th largest economy by nominal GDP and an annual economic growth rate of 7% (2017), the highest in the EU at the time.");

        Capital caa15= new Capital("Berlin","891.1 km2 ",3748148f,"Berlin straddles the banks of the River Spree, which flows into the River Havel (a tributary of the River Elbe) in the western borough of Spandau.");
        Country c18= new Country("Germany",83019200f,"German",caa15,"The Federal Republic of Germany was a founding member of the European Economic Community in 1957 and the European Union in 1993. It is part of the Schengen Area and became a co-founder of the Eurozone in 1999. ");


        Capital caa16= new Capital("Madrid","604.3 km2 ",3223334f,"While Madrid possesses modern infrastructure, it has preserved the look and feel of many of its historic neighbourhoods and streets. Its landmarks include the Plaza Mayor, the Royal Palace of Madrid; the Royal Theatre with its restored 1850 Opera House.");
        Country c19= new Country("Spain",46733038f,"Spanish",caa16,"In the early eighth century the Visigothic Kingdom fell to the Muslims of the Umayyad Islamic Caliphate, who arrived to rule most of the peninsula in the year 711, leaving only a handful of small Christian realms in the north and lasting up to eight centuries in the Kingdom of Granada.");

        arrayListSpinnerEurope.add(c17);
        arrayListSpinnerEurope.add(c18);
        arrayListSpinnerEurope.add(c19);

        ArrayList<Country> arrayListSpinnerMiddle_East= new ArrayList<Country>();

        Capital caa17= new Capital("Yerevan","223 km2 ",1075800f,"Of the notable landmarks of Yerevan, Erebuni Fortress is considered to be the birthplace of the city, the Katoghike Tsiranavor church is the oldest surviving church of Yerevan and Saint Gregory Cathedral is the largest Armenian cathedral in the world, Tsitsernakaberd is the official memorial to the victims of the Armenian Genocide, and several opera houses.");
        Country c20=new Country("Armenia",2951745f,"Armenian",caa16,"Armenia recognises the Armenian Apostolic Church, the world's oldest national church, as the country's primary religious establishment.The unique Armenian alphabet was invented by Mesrop Mashtots in 405 AD.");

        Capital caa18= new Capital("Tehran","",1075800f,"Of the notable landmarks of Yerevan, Erebuni Fortress is considered to be the birthplace of the city, the Katoghike Tsiranavor church is the oldest surviving church of Yerevan and Saint Gregory Cathedral is the largest Armenian cathedral in the world, Tsitsernakaberd is the official memorial to the victims of the Armenian Genocide, and several opera houses, theatres, museums, libraries, and other cultural institutions.");
        Country c21= new Country("Iran",82531700f,"Persian",caa18,"Iran's political system has elements of a presidential democracy with a theocracy governed by an autocratic \"Supreme Leader\".");

        Capital caa19= new Capital("Amman","1,680 km2 ",4007526f,"The city is among the most popular locations in the Arab world for multinational corporations to set up their regional offices, alongside Doha and only behind Dubai. It is expected that in the next 10 years these three cities will capture the largest share of multinational corporation activity in the region.");
        Country c22= new Country("Jordan",10407793f,"Arabic",caa19,"Jordan is classified as a country of \"high human development\" with an \"upper middle income\" economy. The Jordanian economy, one of the smallest economies in the region, is attractive to foreign investors based upon a skilled workforce.");

        arrayListSpinnerMiddle_East.add(c20);
        arrayListSpinnerMiddle_East.add(c21);
        arrayListSpinnerMiddle_East.add(c22);

        ArrayList<Country> arrayListSpinnerNorth_America= new ArrayList<Country>();


        Capital caa20=new Capital("Ottawa","2,790.30 km2",934243f,"Local populations used the area for wild edible harvesting, hunting, fishing, trade, travel, and camps for over 6500 years. The Ottawa river valley has archeological sites with arrow heads, pottery, and stone tools.");
        Country c23=new Country("Canada",37797496f,"English,French",caa20,"Various indigenous peoples inhabited what is now Canada for thousands of years before European colonization. Beginning in the 16th century, British and French expeditions explored and later settled along the Atlantic coast.");

        Capital caa21=new Capital("Washington, D.C.","68.34 sq mi",705749f,"All three branches of the U.S. federal government are centered in the District: Congress (legislative), the president (executive), and the Supreme Court (judicial).");
        Country c24= new Country("US",328239523f,"English",caa20,"Although its population is 4% of the world total, it holds 29.4% of the total wealth in the world, the largest share of global wealth concentrated in a single country.");

        Capital caa22=new Capital("Mexico City","1,485 km2 ",8918653f,"After years of demanding greater political autonomy, residents were finally given the right to elect both a Head of Government and the representatives of the unicameral Legislative Assembly by election in 1997. Ever since, the left-wing Party of the Democratic Revolution (PRD) has controlled both of them.");
        Country c25= new Country("Mexico",126577691f,"Spanish",caa22,"Mexico has the 15th largest nominal GDP and the 11th largest by purchasing power parity.The Mexican economy is strongly linked to those of its 1994 North American Free Trade Agreement (NAFTA) partners, especially the United States.");

        arrayListSpinnerNorth_America.add(c23);
        arrayListSpinnerNorth_America.add(c24);
        arrayListSpinnerNorth_America.add(c25);

        ArrayList<Country> arrayListSpinnerSouth_America= new ArrayList<Country>();

        Capital caa23= new Capital("Brasília","5,802 km2",3039444f,"The plan was conceived in 1827 by José Bonifácio, an advisor to Emperor Pedro I. He presented a plan to the General Assembly of Brazil for a new city called Brasília, with the idea of moving the capital westward from the heavily populated southeastern corridor. ");
        Country c26=new Country("Brazil",210147125f,"Portuguese",caa23,"Brazil is considered an advanced emerging economy.[18] It has the ninth largest GDP in the world by nominal, and eight by PPP measures.[19][20] It is one of the world's major breadbaskets, being the largest producer of coffee for the last 150 years.");

        Capital caa24= new Capital("Lima","2,672.3 km2",8852000f,"In October 2013, Lima was chosen to host the 2019 Pan American Games, these games were held at venues in and around Lima, and were the largest sporting event ever hosted by the country. It also hosted the APEC Meetings of 2008 and 2016.");
        Country c27= new Country("Peru",33105273f,"Spanish",caa24,"The country forms part of The Pacific Pumas, a political and economic grouping of countries along Latin America's Pacific coast that share common trends of positive growth, stable macroeconomic foundations, improved governance and an openness to global integration.");

        arrayListSpinnerSouth_America.add(c26);
        arrayListSpinnerSouth_America.add(c27);


        ArrayList<Country> arrayListSpinnerSouth_Asia= new ArrayList<Country>();

        Capital caa25= new Capital("New Delhi","1,484.0 km2",16787941f,"Delhi is also the centre of the National Capital Region (NCR), which is a unique 'interstate regional planning' area created by the National Capital Region Planning Board Act of 1985.");
        Country c28=new Country("India",1352642280f,"Hindi,English",caa25,"India is a secular federal republic governed in a democratic parliamentary system. It is a pluralistic, multilingual and multi-ethnic society. India's population grew from 361 million in 1951 to 1,211 million in 2011.");

        Capital caa26= new Capital("Sri Jayawardenepura Kotte","17 km2",2234289f,"The village of Darugama lay at the confluence of two streams, the Diyawanna Oya and the Kolonnawa Oya. As Darugama was a naturally secure place, it was not easy for enemies to enter it. ");
        Country c29= new Country("Siri Lanca",21670000f,"Sinhala",caa26,"The island is home to many cultures, languages, and ethnicities. The majority of the population are from the Sinhalese ethnicity, while a large minority of Tamils have also played an influential role in the island's history.");

        arrayListSpinnerSouth_Asia.add(c23);
        arrayListSpinnerSouth_Asia.add(c24);

        ListView listView=(ListView) view.findViewById(R.id.lvCountries);
        ListAdapter adapter= new ListAdapter(this.getContext(),arrayList,arrayListSpinnerEurope,arrayListSpinnerAfrica,arrayListSpinnerAustrala_Oceania,arrayListSpinnerCentral_America,arrayListSpinnerCentral_Asia,arrayListSpinnerEast_SoutheastAsia,arrayListSpinnerMiddle_East,arrayListSpinnerNorth_America,arrayListSpinnerSouth_America,arrayListSpinnerSouth_Asia);
        listView.setAdapter(adapter);
        return view;
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Object obj=parent.getItemAtPosition(position);
        c=(Country)obj;
        Log.v("TEST: ",c.toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
