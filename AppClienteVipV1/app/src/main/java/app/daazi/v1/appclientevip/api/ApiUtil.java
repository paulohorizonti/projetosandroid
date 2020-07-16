package app.daazi.v1.appclientevip.api;

import java.util.Calendar;

/**
 * Classe de apoio contendo métodos que podem ser
 * reutilizaveis em todo o projeto
 *
 * Criada por Paulo Roberto - 04/2020
 *
 * */
public class ApiUtil {

    public static final int TIME_SPLASH = 5 * 1000; //5 segundos
    //atributo para guardar dados do usuario no celular
    public static final String PREF_APP = "app_cliente_vip_pref";

    /**
     *
     *
     * @return devole a data atual
     * */
    public static String getDataAtual(){
       String dia, mes, ano;
       String dataAtual = "";


        try {
            Calendar calendar = Calendar.getInstance(); //Pega a data e a hora nesse momento
            dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            mes = String.valueOf(calendar.get(Calendar.MONTH)+1);
            ano = String.valueOf(calendar.get(Calendar.YEAR));
            dia = (Calendar.DAY_OF_MONTH<10) ? "0"+dia : dia;
            int mesAtual = (Calendar.MONTH)+1;
            mes = (mesAtual<10) ? "0"+mes : mes;
            dataAtual = dia+"/"+mes+"/"+ano;


        }catch(Exception e){

        }
        return dataAtual;
    }

    /**
     * @return devolve a hora atual
     * */
    public static String getHoraAtual(){
        String hora, min, seg;
        String horaAtual = "00:00:00";

        try {
            Calendar calendar = Calendar.getInstance(); //Pega a data e a hora nesse momento
           int ihora = calendar.get(Calendar.HOUR_OF_DAY);
           int imin = calendar.get(Calendar.MINUTE);
           int iseg = calendar.get(Calendar.SECOND);

           hora = (ihora <= 9)? "0"+ihora: Integer.toString(ihora);
           min = (imin <= 9)? "0"+imin: Integer.toString(imin);
           seg = (iseg <=9)? "0"+iseg: Integer.toString(iseg);
           horaAtual = hora+":"+min+":"+seg;

        }catch(Exception e){

        }

        return horaAtual;
    }

}
