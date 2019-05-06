package br.cap.sistemas.bibliacelular.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date  parseDate(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Date  parseDataHoraSeconds(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
	public static String format(Calendar calendar, String format) {
		
		return DateUtil.format(calendar.getTime(), format);
	}
	
//	public static String format(String calendar) {
//
//		return DateUtil.format(calendar.getTime(), "dd/MM/yyyy");
//	}

    public static String format(Date date) {

        return DateUtil.format(date, "dd/MM/yyyy HH:mm");
    }
    public static String formatSeconds(Date date) {

        return DateUtil.format(date, "dd/MM/yyyy HH:mm:ss");
    }
    public static String format(Date date, String format) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

	public static Calendar parse(String date) {
		
		Calendar calendar = Calendar.getInstance();
		
		String[] array = date.split("T");
		String[] dateArray = array[0].split("-");
        boolean defaultFormat = false;

        if (dateArray.length == 1) {

            defaultFormat = true;
            dateArray = array[0].split("/");
        }

        String[] timeArray = new String[] { "0", "0", "0"};

        if (array.length > 1)
		    timeArray = array[1].split(":");

        if (defaultFormat)
		    calendar.set(Integer.valueOf(dateArray[2]), Integer.valueOf(dateArray[1]), Integer.valueOf(dateArray[0]), Integer.valueOf(timeArray[0]), Integer.valueOf(timeArray[1]), Integer.valueOf(timeArray[2]));
        else
            calendar.set(Integer.valueOf(dateArray[0]), Integer.valueOf(dateArray[1]), Integer.valueOf(dateArray[2]), Integer.valueOf(timeArray[0]), Integer.valueOf(timeArray[1]), Integer.valueOf(timeArray[2]));
		
		return calendar;
	}

    public static int calcularIdade(Calendar cn) {

        Date dataAtual = new Date(System.currentTimeMillis());
        Calendar ca = Calendar.getInstance();
        ca.setTime(dataAtual);

        int idade = ca.get(Calendar.YEAR) - cn.get(Calendar.YEAR);
        if (ca.get(Calendar.MONTH) < cn.get(Calendar.MONTH)) {
            idade--;
        } else if (ca.get(Calendar.MONTH) == cn.get(Calendar.MONTH)) {
            if (ca.get(Calendar.DAY_OF_MONTH) < cn.get(Calendar.DAY_OF_MONTH))
                idade--;
        }
        return idade;
    }

    public static boolean isDateValid(String dateToValidate, String dateFromat) {

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {

            return false;
        }

        return true;
    }

    public static Date getInitialDate() {

        Calendar calendar = Calendar.getInstance();
        Calendar calendarInicial = Calendar.getInstance();
        calendarInicial.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        calendarInicial.set(Calendar.MILLISECOND, 0);

        return calendarInicial.getTime();
    }

    public static Date getFinalDate() {

        Calendar calendar = Calendar.getInstance();
        Calendar calendarFinal = Calendar.getInstance();
        calendarFinal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 23, 59, 59);
        calendarFinal.set(Calendar.MILLISECOND, 0);

        return calendarFinal.getTime();
    }
}
