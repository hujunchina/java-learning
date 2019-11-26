import com.fourinone.Contractor;
import com.fourinone.WareHouse;
import com.fourinone.WorkerLocal;
import java.util.ArrayList;

public class CtorDemo extends Contractor
{
	private String ctorname;
	// construct function, assgin name
	CtorDemo(String ctorname)
	{
		this.ctorname = ctorname;
	}
	// interface
	public WareHouse giveTask(WareHouse inhouse)
	{
		// got workers instance
		WorkerLocal[] wks = getWaitingWorkers("workdemo");
		System.out.println("wks.length:"+wks.length);
		
		// got a type of id
		String outStr = inhouse.getString("id");
		WareHouse[] hmarr = new WareHouse[wks.length];

		int data=0;
		// 20 tasks in total
		for(int j=0;j<20;)
		{
			for(int i=0;i<wks.length;i++){
				// has no job, and assgin job
				if(hmarr[i]==null){
					WareHouse wh = new WareHouse();
					wh.put("id",ctorname+(data++));
					hmarr[i] = wks[i].doTask(wh);
				}
				// doing a job, print
				else if(hmarr[i].getStatus()!=WareHouse.NOTREADY)
				{
					System.out.println(hmarr[i]);
					outStr+=hmarr[i];
					hmarr[i]=null;
					j++;
				}
			}
		}
		
		inhouse.setString("id", outStr);
		return inhouse;
	}
	
	public static void main(String[] args)
	{
		// three ctors
		Contractor a = new CtorDemo("OneCtor");
		a.toNext(new CtorDemo("TwoCtor")).toNext(new CtorDemo("ThreeCtor"));
		WareHouse house = new WareHouse("id","begin ");
		System.out.println(a.giveTask(house,true));
	}
}