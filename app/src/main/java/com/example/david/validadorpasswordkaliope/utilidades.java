package com.example.david.validadorpasswordkaliope;

import java.util.Calendar;
import java.util.Locale;

public class utilidades {

    public static int getNumeroSemana(){

        final Calendar calendar = Calendar.getInstance(new Locale("en","UK"));
        //calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);


        //definimos la fecha de donde comenzara esto solo lo use para hacer pruebas y determinar
        //si devolvia correctamente el numero de semana
        //calendar.set(Calendar.YEAR,2020);
        //calendar.set(Calendar.MONTH,2);
        //calendar.set(Calendar.DATE,2);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

}
