package i18n;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Migue
 */
public class TestDate {
    
    public static void main(String[] args) {
        Date date = new Date(1_000_000_000_000L);
        System.out.println(date.toString());
        date.setTime(date.getTime() + 3_600_000*24);   //+1 day
        System.out.println(date);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        if(Calendar.MONDAY == calendar.getFirstDayOfWeek()){
            System.out.println("Monday is the first day of the week");
        }
        
        System.out.println("Day of the week is " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Day of the year is " + calendar.get(Calendar.DAY_OF_YEAR));
        
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.HOUR, -4);
        date.setTime(calendar.getTimeInMillis());
        System.out.println(date);
        
        calendar.roll(Calendar.MONTH, 6);
        System.out.println(calendar.getTime());
        
        DateFormat df[] = new DateFormat[6];
        df[0] = DateFormat.getInstance();
        df[1] = DateFormat.getDateInstance();
        df[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        df[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df[4] = DateFormat.getDateInstance(DateFormat.LONG);
        df[5] = DateFormat.getDateInstance(DateFormat.FULL);
        
        System.out.println("Formatos:");
        for(DateFormat df1: df){
            System.out.println(df1.format(date));
        }
        
        DateFormat dfParse = DateFormat.getDateInstance();
        String stringDate = "25/04/1986";
        try {
            Date parseDate = dfParse.parse(stringDate);
            System.out.println("parseDate = " + parseDate);
        } catch (ParseException ex) {
            Logger.getLogger(TestDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println("Locales:");
        Locale esFull = new Locale("es", "VE");
        Locale itFull = new Locale("it", "IT");
        Locale enFull = new Locale("en", "US");
        Locale ptFull = new Locale("pt", "BR");
        
        DateFormat dfesVE = DateFormat.getDateInstance(DateFormat.FULL, esFull);
        DateFormat dfitIT = DateFormat.getDateInstance(DateFormat.FULL, itFull);
        DateFormat dfenUS = DateFormat.getDateInstance(DateFormat.FULL, enFull);
        DateFormat dfptBR = DateFormat.getDateInstance(DateFormat.FULL, ptFull);
                
        System.out.println("esVE = " + dfesVE.format(date));
        System.out.println("itIT = " + dfitIT.format(date));
        System.out.println("enUS = " + dfenUS.format(date));
        System.out.println("ptBR = " + dfptBR.format(date));
        
        System.out.println("" + esFull.getDisplayCountry());
        System.out.println("" + esFull.getDisplayLanguage(esFull));
        System.out.println("" + esFull.getDisplayLanguage(enFull));
        System.out.println("" + esFull.getDisplayLanguage(itFull));
        System.out.println("" + esFull.getDisplayLanguage(ptFull));
        System.out.println("");
        System.out.println("" + itFull.getDisplayLanguage(esFull));
        System.out.println("" + itFull.getDisplayLanguage(enFull));
        System.out.println("" + itFull.getDisplayLanguage(itFull));
        System.out.println("" + itFull.getDisplayLanguage(ptFull));
        
        System.out.println("NumberFomrat:");
        float value = 12_987.7654f;
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.format(value));
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(value));
        nf.setMinimumFractionDigits(5);
        System.out.println(nf.format(value));
        System.out.println("");
        
        NumberFormat nf1[] = new NumberFormat[4];
        nf1[0] = NumberFormat.getInstance();
        nf1[1] = NumberFormat.getInstance(esFull);
        nf1[2] = NumberFormat.getCurrencyInstance();
        nf1[3] = NumberFormat.getCurrencyInstance(esFull);
        
        BigDecimal bigD = new BigDecimal("12987.7654");
        
        for(NumberFormat numberFormat: nf1){
            System.out.println(numberFormat.format(value));
        }
        
        System.out.println("");
        for(NumberFormat numberFormat: nf1){
            numberFormat.setMinimumFractionDigits(5);
            System.out.println(numberFormat.format(bigD));
        }
        
    }
    
}
