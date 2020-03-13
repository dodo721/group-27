package com.napier.set08103.group27.report;

import com.napier.set08103.group27.DataStore;

import java.text.DecimalFormat;
import java.util.Arrays;

public class LanguagesOfWorldReport implements ReportGenerator {

    private long worldPopulation = 0;
    DecimalFormat df = new DecimalFormat("#.000");

    public LanguagesOfWorldReport(){}

    @Override
    public String[] generate() {
        String[] report = new String[5];

        long speakersEnglish = 0;
        long speakersChinese = 0;
        long speakersHindi = 0;
        long speakersSpanish = 0;
        long speakersArabic = 0;

        DataStore dataStore = DataStore.getInstance();

        for(String key : dataStore.getCountriesHashMap().keySet())
        {
            worldPopulation += dataStore.getCountriesHashMap().get(key).getPopulation();
        }

        System.out.println("World Pop: " + worldPopulation);

        for(String key : dataStore.getLanguageHashMap().keySet())
        {
            for(int i = 0; i < dataStore.getLanguageHashMap().get(key).size(); i++)
            {
                if(dataStore.getLanguageHashMap().get(key).get(i).getLanguage().equals("English"))
                {
                    int populationThisKey = dataStore.getCountriesHashMap().get(key).getPopulation();
                    speakersEnglish += populationThisKey * dataStore.getLanguageHashMap().get(key).get(i).getPercentage()/100;
                }

                if(dataStore.getLanguageHashMap().get(key).get(i).getLanguage().equals("Chinese"))
                {
                    int populationThisKey = dataStore.getCountriesHashMap().get(key).getPopulation();
                    speakersChinese += populationThisKey * dataStore.getLanguageHashMap().get(key).get(i).getPercentage()/100;
                }

                if(dataStore.getLanguageHashMap().get(key).get(i).getLanguage().equals("Spanish"))
                {
                    int populationThisKey = dataStore.getCountriesHashMap().get(key).getPopulation();
                    speakersSpanish += populationThisKey * dataStore.getLanguageHashMap().get(key).get(i).getPercentage()/100;
                }

                if(dataStore.getLanguageHashMap().get(key).get(i).getLanguage().equals("Arabic"))
                {
                    int populationThisKey = dataStore.getCountriesHashMap().get(key).getPopulation();
                    speakersArabic += populationThisKey * dataStore.getLanguageHashMap().get(key).get(i).getPercentage()/100;
                }

                if(dataStore.getLanguageHashMap().get(key).get(i).getLanguage().equals("Hindi"))
                {
                    int populationThisKey = dataStore.getCountriesHashMap().get(key).getPopulation();
                    speakersHindi += populationThisKey * dataStore.getLanguageHashMap().get(key).get(i).getPercentage()/100;
                }
            }
        }

        //adding number of speakers for each language to array to be sorted
        long[] array = new long[5];
        array[0] = speakersEnglish;
        array[1] = speakersChinese;
        array[2] = speakersArabic;
        array[3] = speakersHindi;
        array[4] = speakersSpanish;
        Arrays.sort(array);

        //Reversing through sorted array
        for(int i = array.length-1; i>=0; i--)
        {
            //Inserting into array from largest to smallest number of speakers
            int reportPosition = (array.length-1) - i;

            if(array[i] == speakersEnglish)
            {
                report[reportPosition] = "Number of speakers (English): " + speakersEnglish + ", Percentage of speakers: " + getPercentageOfWorld(speakersEnglish) + "%";
            }
            if(array[i] == speakersChinese)
            {
                report[reportPosition] = "Number of speakers (Chinese): " + speakersChinese + ", Percentage of speakers: " + getPercentageOfWorld(speakersChinese) + "%";
            }
            if(array[i] == speakersSpanish)
            {
                report[reportPosition] = "Number of speakers (Spanish): " + speakersSpanish + ", Percentage of speakers: " + getPercentageOfWorld(speakersSpanish) + "%";
            }
            if(array[i] == speakersArabic)
            {
                report[reportPosition] = "Number of speakers (Arabic): " + speakersArabic + ", Percentage of speakers: " + getPercentageOfWorld(speakersArabic) + "%";
            }
            if(array[i] == speakersHindi)
            {
                report[reportPosition] = "Number of speakers (Hindi): " + speakersHindi + ", Percentage of speakers: " + getPercentageOfWorld(speakersHindi) + "%";
            }
        }

        return report;
    }

    private double getPercentageOfWorld(double speakers)
    {
        double percentage = (speakers/worldPopulation)*100;
        return Double.parseDouble(df.format(percentage));
    }
}
