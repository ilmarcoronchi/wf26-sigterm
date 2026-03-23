package lab.sigterm.core.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.bind.adapter.JsonbAdapter;

/*
 * L'annotazione @Temporal è specifica di JPA (Java Persistence API) e viene utilizzata per specificare 
 * come un campo o una proprietà di tipo java.util.Date o java.util.Calendar debba essere mappata nella 
 * base dati come uno dei tipi SQL java.sql.Date, java.sql.Time, o java.sql.Timestamp. 
 * 
 * Quando si lavora con JSON-B o qualsiasi framework di serializzazione JSON in applicazioni JEE, è comune 
 * imbattersi in problemi di serializzazione con tipi di data e ora, soprattutto quando si utilizzano tipi 
 * di data JPA in entità che vengono serializzate direttamente in JSON.
 * 
 */
public class DateAdapter implements JsonbAdapter<Date, String> {
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String adaptToJson(Date date) throws Exception {
		return dateFormat.format(date);
	}

	@Override
	public Date adaptFromJson(String dateStr) throws Exception {
		return dateFormat.parse(dateStr);
	}
}
