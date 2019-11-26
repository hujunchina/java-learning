import com.fourinone.MigrantWorker;
import com.fourinone.WareHouse;

public class SimpleWorker extends MigrantWorker
{	
	public WareHouse doTask(WareHouse inhouse)
	{
		// get a type of word
		String word = inhouse.getString("word");
		System.out.println(word+" is a Contractor.");
		// will return ok
		return new WareHouse("word", word+" world!");
	}
	
	public static void main(String[] args)
	{
		SimpleWorker mw = new SimpleWorker();
		mw.waitWorking("simpleworker");
	}
}